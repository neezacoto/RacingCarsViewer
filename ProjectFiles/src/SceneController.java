import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Responsible for controlling the main UI elements of the Simulation
 */
public class SceneController implements Initializable{
    // private Stage stage;
	// private Scene scene;
	// private Parent root;
    
    @FXML
    private BorderPane raceTrackContainer;

    @FXML
    private Button startButton;

    private static SceneController instance;

    /**
	 * setting an instance for scene controller
	 */
	public SceneController() {
		instance = this;
	}

	/**
	 * @return an intance of SceneController
	 */
	public static SceneController getInstance() {
		return instance;
	}

	/**
	 * Allows for further rendering after the root element has been proccesed
	 */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("hello");
		RaceTrack.newInstance();
        raceTrackContainer.setCenter(RaceTrack.getInstance().getRaceTrack());
	}

    /**
	 * Method to start the race
	 * @param event the StartButton
	 */
    public void startRaceButton(ActionEvent event){
        RaceTrack.getInstance().startRace();
        RaceTrack.getInstance().EndOfRace();
    }
    

	/**
	 * The win alert once a car has won
	 * @param winner the Car object that called winAlert
	 */
    public void winAlert(Car winner){
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Winner Winner Chicken Dinner ! ! ! ! ! ! !");
		alert.setHeaderText(winner.getColor() +" has won the race!");
		alert.setContentText("the race is finished (clicking 'ok' will reset the track):");

		if(alert.showAndWait().get() == ButtonType.OK) {
				//this will reset track by re-creating a whole new race
                //RaceTrack.newInstance();
		}
    }


}
