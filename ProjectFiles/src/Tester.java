/**
 * @author Christian
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.ArrayList;

/**
 * Tester class responsible for running the game
 */
public class Tester extends Application {

	/**
	 * start function responsible for setting the scene and stage
	 */
 	@Override
	public void start(Stage stage) {
		try {

		Parent root = FXMLLoader.load(getClass().getResource("RaceUI.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

		} catch(Exception e) {
		 e.printStackTrace();
		}
	}

 	/**
	* main method
	*/
	public static void main(String[] args) {
		launch(args);
	}
}