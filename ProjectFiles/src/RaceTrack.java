/**
 * @author 
 */
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * to comminicate with scenecrontroller
 * SceneController.getInstance().methodName()
 */

/**
 * This class will be responsible for creating the race track that holds all
 * the cars and start function for the simulation
 * -
 * Christian Rudder: created class skeleton, connecting it to the sceneController.
 * This in the begininng allowed for a car object to move to a position and trigger the win alert upon race start.
 * Also including an initial Override to the toString method
 */

public class RaceTrack extends AnchorPane { 
    private static RaceTrack instance;//the instance of the RaceTrack
    private int[] track;//the checkpoint path coordinates
    private ArrayList<Car> cars;//all the cars in play
    private int origin;
    /**
	 *Creating an instance of the RaceTrack to be referenced
	 * @return an instance of itself
     * @author Christian Rudder
	 */
    public static RaceTrack newInstance() {
        //this is where it's calling the Constructor

        
         Double[] path = new Double[] {
            20.0, 20.0,
            300.0, 20.0,
            300.0, 150.0,
            20.0,150.0,
            20.0, 20.0
 
        };
        instance = new RaceTrack(new Car(path));
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
        // Button button = new Button();
        
        this.getChildren().addAll(car);
        System.out.println(this.getHeight());
        AnchorPane.setTopAnchor(car, 20.0);
        AnchorPane.setLeftAnchor(car, 20.0);
    }

    /**
     * getter for the RaceTrack UI
     * @return RaceTrack's AnchorPane
     * @author Christian Rudder
     */
    public AnchorPane getRaceTrack() {
        return this;
    }

    /**
     * starts the race
     */
    public void startRace() {
        //this is just some test code to check if the start button is being called
        //feel free to comment out or delete once you start writing your logic
        // Alert alert = new Alert(AlertType.CONFIRMATION);
		// alert.setTitle("Yep");
		// alert.setHeaderText("start race works");
		// alert.setContentText("press ok to do nothing");

		// alert.showAndWait();
        //------------------------------------------------------------------------
        for (Car car : cars) {
            car.startEngine();
        }
    }

    /**
     * Getter for the track coordinates
     * @return track coordinates
     */
    public int[] getTrack() {
        return null;
    }

    /**
     * getter for the cars in the race
     * @return ArrayList of car objects
     */
    public ArrayList<Object> getCars() {
        return null;
    } 

    /**
     * Overriding toString to present RaceTrack data
     */
    @Override
    public String toString() {

        String carList = "";
        for(Car car : cars ) {
            carList += car + "\n-\n";
        }

        return "Track Checkpoints: " + this.track + "\n" + carList;
    }

}