/**
 * @author 
 */
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

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
    private ArrayList<Double> carPath;//the checkpoint path coordinates
    private ArrayList<Car> cars;//all the cars in play
    private Car highSpeed;
    private int lowSpeed;
    Random rand = new Random(); //used to generate random speeds for the cars
    Timer timer = new Timer();// timer to delay win screan
    /**
	 *Creating an instance of the RaceTrack to be referenced
	 * @return an instance of itself
     * @author Christian Rudder
	 */
    public static RaceTrack newInstance() {
        //this is where it's calling the Constructor
        instance = new RaceTrack();
        
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

        this.setStyle("-fx-background-color: black");
        cars = new ArrayList<>();
        lowSpeed=0;

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
        
        // carPath = new Double[] {
        //     10.0, 10.0,
        //     100.0, 10.0,
        //     100.0, 150.0,
        //     10.0,150.0,
        //     
 
        // };

        // carPath = new Double[] {
            
        //     100.0, 10.0,
        //     100.0, 150.0,
        //     10.0,150.0,
        //     10.0,10.0,
        //     
 
        // };

        // carPath = new Double[] {
            
        //     100.0, 150.0,
        //     10.0,150.0,
        //     10.0,10.0,
        //     100.0, 10.0,
 
        // };

        carPath = new ArrayList<>(Arrays.asList(
            10.0,150.0,
            10.0,10.0,
            100.0, 10.0,
            100.0, 150.0
        ));


        for(int i = 0; i < 4; i++){
            Car car = new Car(carSpeeds.get(i), carColors.get(i), shiftCheckpointList(carPath));
            cars.add(car);
            this.getChildren().add(car);
            AnchorPane.setTopAnchor(car, 70.0);
            AnchorPane.setLeftAnchor(car, 250.0);
            if(i==0){
                highSpeed=car;
                }
            if(carSpeeds.get(i)<highSpeed.getSpeed()){
                highSpeed=car;
                }
            if(carSpeeds.get(i)>lowSpeed){
                lowSpeed=carSpeeds.get(i);
                }
            
        }

        // //Loop used to test to see what information the cars have
        // for(int i = 0; i < cars.size(); i++){
        //     cars.get(i).carPrinterTester();
        // }

        
        

    }


    //method used to shift the checkpoint list of the cars to no two cars have the same path -JL
    //Bug fix by Christian so that all cars still ended up with the same path


    private ArrayList<Double> shiftCheckpointList(ArrayList<Double> list){
        ArrayList<Double> newCords = new ArrayList<>();
        
        Double temp1 = list.remove(0);
        Double temp2 = list.remove(0);
        list.add(temp1);
        list.add(temp2);
        for(Double i : list) {
            newCords.add(i);
        }
        return newCords;
    }


    //used to generate speeds from an integer to another then randomizes the order of the speeds -JL
    private ArrayList<Integer> generateRandomSpeedList(){
        ArrayList<Integer> speeds = new ArrayList<Integer>();

        for(int i = 5; i < 10; i++){
            speeds.add(i);
        }

        Collections.shuffle(speeds);
        return speeds;
    }



    /**
     * getter for the RaceTrack UI
     * @return RaceTrack's AnchorPane
     * @author Christian Rudder
     */
    public AnchorPane getRaceTrack() {
        return this;
    }
    
    public void EndOfRace(){
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            SceneController.getInstance().winAlert(highSpeed);
        }
    }, lowSpeed*1000);
    
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
    public ArrayList<Double> getTrack() {
        return carPath;
    }

    /**
     * getter for the cars in the race
     * @return ArrayList of car objects
     */
    public ArrayList<Car> getCars() {
        return cars;
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

        return "Track Checkpoints: " + this.carPath + "\n" + carList;
    }

    public Car getWinner(){
        Car winner = cars.get(0);
        for(int a = 1; a < 4; a++){
            if(winner.getSpeed() <= cars.get(a).getSpeed()){
                winner = cars.get(a);
            }
        }
        winner.carPrinterTester();
        return winner;
    }



}