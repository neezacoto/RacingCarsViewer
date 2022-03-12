/**
 * @author 
 */
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class will be responsible for creating the race track that holds all
 * the cars and start function for the simulation
 * Christian Rudder: created class skeleton, connecting it to the sceneController.
 * This in the begininng allowed for a car object to move to a position and trigger the win alert upon race start.
 */
public class RaceTrack extends StackPane { 
    private static RaceTrack instance;//the instance of the RaceTrack
    private int[] track;//all the checkpoint coordinates
    private ArrayList<Car> cars;//all the cars in play

    /**
	 *Creating an instance of the RaceTrack to be referenced
	 * @return an instance of itself
     * @author Christian Rudder
	 */
    public static RaceTrack newInstance() {
        //this is where it's calling the Constructor
        instance = new RaceTrack(new Car());
        return instance;
    }

    /**
     * The getter for a live instance of RaceTrack
     * @return the current instance of RaceTrack
     * @author Christian Rudder
     */
    public static RaceTrack getInstance() {
        return instance;
    }

    /**
     * This is the constructor where you will set up the AnchorPane
     * @author Christian Rudder
     */

    public RaceTrack(Car car) {
        cars = new ArrayList();
        this.cars.add(car);
        this.setStyle("-fx-background-color: black");
        Button button = new Button();
        
        this.getChildren().addAll(car);
    }

    /**
     * getter for the RaceTrack UI
     * @return RaceTrack's AnchorPane
     * @author Christian Rudder
     */
    public StackPane getRaceTrack() {
        return this;
    }

    /**
     * starts the race
     */
    public void startRace() {
        //this is just some test code to check if the start button is being called
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Yep");
		alert.setHeaderText("start race works");
		alert.setContentText("press ok to do nothing");

		alert.showAndWait();
        //------------------------------------------------------------------------
        
    }

    public int[] getTrack() {
        return null;
    }

    public ArrayList<Object> getCars() {
        return null;
    } 

}