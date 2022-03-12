import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
/**
 * This class is responsible for rendering the car and 
 * making it race down a path reporting when it finishes
 * Christian Rudder: Made the skeleton connecting it to demonstrate how 
 * a car object will show on the racetrack and how it will report it's win
 */
public class Car extends Rectangle{
    private String color;
    private int speed;
    private int[] track;

    Car() {
        super(50,30,Color.GREEN);
        this.color = "Green";
        //finishRaceReport();
    }
    /**
     * starts following path when told to from RaceTrack
     */
    public void startEngine() {

    }

    /**
     * getter for the race track's track
     * @return race track coordinates 
     */
    public int[] getPath() {
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


 

}