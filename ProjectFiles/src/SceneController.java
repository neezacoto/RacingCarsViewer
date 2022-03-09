import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SceneController{
    private Stage stage;
	private Scene scene;
	private Parent root;
    
    @FXML
    private BorderPane raceTrackContainer;

    @FXML
    private Button startButton;

    public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    //starts the race
    public void start(ActionEvent event){

    }
    
    public void winAlert(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Winner Winner Chicken Dinner ! ! ! ! ! ! !");
		alert.setHeaderText("____ has won the race!");
		alert.setContentText("the race is finished (clicking 'ok' will reset the track):");

		if(alert.showAndWait().get() == ButtonType.OK) {
				//reset racetrack
		}
    }


}
