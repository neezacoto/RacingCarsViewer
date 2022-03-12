import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
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

    /**
     * The Car constructor
     */
    Car() {
        super(50,30,Color.GREEN);
        this.color = "Green";
        //finishRaceReport();
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




 

}