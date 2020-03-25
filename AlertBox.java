/**
 * @author T06 Group 4
 * @version Demo 2 GUI based game
 * @implNote This class creates a congratulatory alert box when the player wins the game.
 */
package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	static ImageView imgWin = new ImageView("imageWin.png");
	static ImageView imgLoss = new ImageView("LosingScreen.gif");
	public static void displayLoss(){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(imgLoss);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	public static void displayWin() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(imgWin);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}