import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.scene.shape.Polyline;
/**
 * This class is responsible for rendering the car and 
 * making it race down a path reporting when it finishes
 * -
 * Christian Rudder: Made the skeleton connecting it to demonstrate how 
 * a car object will show on the race path and how it will report it's win. Also including
 * an initial override for toString and Equals
 */
public class Car extends Rectangle{
    private String color;
    private int speed;
    private ArrayList<Double> path; //coordinate path that the car has to follow
    private PathTransition transition;
    private Random rand = new Random(); //random is used to randomize the value of the car
    /**
     * The Car constructor
     */
    Car(int speed, Color carColor, ArrayList<Double> path, String colorName){
        super(50,30, carColor);
        this.speed = speed;
        this.path = path;
        this.color = colorName;
        this.path = path;
        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(path);
        transition = new PathTransition();
        transition.setNode(this);
        transition.setDuration(Duration.seconds(speed));
        transition.setPath(polyline);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    }
    /**
     * starts following path when told to from Race path startRace()
     */
    public void startEngine() {
        transition.play();
    }
    /**
     * getter for the race path's path
     * @return race path coordinates 
     */
    public ArrayList<Double> getpath() {
        return this.path;
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
     * Overriding the toString method to work with the Car object
     */
    @Override
    public String toString() {
        return this.color + "car:\nSpeed: " + this.speed + "\npath: " + this.path;
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

        return this.color.equals(car.getColor()) && this.speed == car.getSpeed() && this.path == car.getpath();
    }

    /*
    Method to randomize the speed of the car again if the speed were ever 0 -JL
    */
    public void randomizeSpeed(){
        speed = rand.nextInt(5);
        while(speed == 0) {
            speed = rand.nextInt(5);
        }
    }
    //method used during development to check parameters of the car -JL
    public void carPrinterTester(){
        System.out.print("Car's path is: ");
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println("\n With Speed: " + speed);
    }
}