import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;
/**
 * This class is responsible for rendering the car and 
 * making it race down a path reporting when it finishes
 * -
 * Christian Rudder: Made the skeleton connecting it to demonstrate how 
 * a car object will show on the racetrack and how it will report it's win. Also including
 * an initial override for toString and Equals
 */
public class Car extends Rectangle{
    private String color;
    private int speed;
    private int[] track; //coordinate path that the car has to follow

    private Random rand = new Random(); //random is used to randomize the value of the car

    /**
     * The Car constructor
     */
    Car() {
        super(50,30,Color.GREEN);
        this.color = "Green";
        //finishRaceReport();
       
        
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new HLineTo(200));
        PathTransition move = new PathTransition();
        move.setNode(this);
        move.setDelay(Duration.seconds(2));
        move.setPath(path);
        move.play();
        
        
    }

    Car(int carNumber){ //Used to give the cars specific paths according to their numbers
        super(50,30,Color.GREEN);
        this.color = "Green";
        speed = 0;
        randomizeSpeed();

        if(carNumber == 1){
            track = new int[]{1, 2, 3, 4};
        } else if (carNumber == 2){
            track = new int[]{2, 3, 4, 1};
        } else if (carNumber == 3){
            track = new int[]{3, 4, 1, 2};
        } else if (carNumber == 4){
            track = new int[]{4, 1, 2, 3};
        } else {
            track = new int[]{0, 0, 0, 0};
        }


    }
    /**
     * starts following path when told to from RaceTrack startRace()
     */
    public void startEngine() {

    }


    /**
     * getter for the race track's track
     * @return race track coordinates 
     */
    public int[] getTrack() {
        return this.track;
    }
    
    /**
     * getter for the car color
     * @return car color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * getter for the car speed
     * @return the car speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * responsible for displaying the win alert once this car has won
     */
    private void finishRaceReport() {
        SceneController.getInstance().winAlert(this);
    }

    /**
     * Overriding the toString method to work with the Car object
     */
    @Override
    public String toString() {
        return this.color + "car:\nSpeed: " + this.speed + "\nTrack: " + this.track;
    }

    /**
     * Overriding the equals method to work for the Car object
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Car)) {
            return false;
        }

        Car car = (Car) obj;

        return this.color.equals(car.getColor()) && this.speed == car.getSpeed() && this.track == car.getTrack();
    }

    /*
    Method to randomize the speed of the car again if any cars have the matching speed -JL
    */

    public void randomizeSpeed(){
        while(speed == 0) {
            speed = rand.nextInt(5);
        }
    }


    //method used during development to check parameters of the car -JL
    public void carPrinterTester(){
        System.out.println("Car's path is " + track[0] + " " + track[1] + " " +track[2] + " " + track[3] + " \n with speed: " + speed);

    }




 

}