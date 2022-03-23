/**
 * @author 
 */
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

public class RaceTrack extends StackPane { 
    private static RaceTrack instance;//the instance of the RaceTrack
    private int[] track;//the checkpoint path coordinates
    private ArrayList<Car> cars;//all the cars in play

    /**
	 *Creating an instance of the RaceTrack to be referenced
	 * @return an instance of itself
     * @author Christian Rudder
	 */
    public static RaceTrack newInstance() {
        //this is where it's calling the Constructor
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

     public RaceTrack() {
        //Old code used to start the initialization of the racetrack
        /*cars = new ArrayList();
        this.cars.add(car);
        this.setStyle("-fx-background-color: black");
        Button button = new Button();
        
        this.getChildren().addAll(car);*/


        cars = new ArrayList<>();

        ArrayList<Color> carColors = new ArrayList<Color>();
        carColors.add(Color.GREEN);
        carColors.add(Color.RED);
        carColors.add(Color.CYAN);
        carColors.add(Color.YELLOW);

        ArrayList<Integer> track = new ArrayList<>();
        for(int j = 1; j < 5; j++){
            track.add(j);
        }

        ArrayList<Integer> carSpeeds = generateRandomSpeedList();

        ArrayList<Integer> carPath = new ArrayList<Integer>();
        for(int i = 1; i < 5; i++){
            carPath.add(i);
        }

        for(int i = 0; i < 4; i++){
            cars.add(new Car(carSpeeds.get(i), carColors.get(i), carPath));
            int temp = carPath.get(0);
            carPath.remove(0);
            carPath.add(temp);
        }



        //Loop used to test to see what information the cars have
        /*for(int i = 0; i < 4; i++){
            cars.get(i).carPrinterTester();
        }*/

    }
     
     
    //used to generate speeds from an integer to another then randomizes the order of the speeds -JL
    public ArrayList<Integer> generateRandomSpeedList(){
        ArrayList<Integer> speeds = new ArrayList<Integer>();

        for(int i = 5; i < 10; i++){
            speeds.add(i);
        }

        Collections.shuffle(speeds);
        System.out.println(speeds);
        return speeds;
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