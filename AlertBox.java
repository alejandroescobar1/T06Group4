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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class AlertBox {
	static ImageView knucklesWin = new ImageView("knucklesWin.png");
	static ImageView knucklesLoss = new ImageView("knucklesloss.gif");
	static ImageView MSWin = new ImageView("MSwin.gif");
	static ImageView MSLoss = new ImageView("MSLoss.gif");
	public static void displayLoss(int character){
		if (character == 2){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(knucklesLoss);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}else if (character == 1){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(MSLoss);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		}
		
	}
	public static void displayWin(int character) {
		
		if (character == 2){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(knucklesWin);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();}
		else if (character == 1){
			Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Group layout = new Group();
		layout.getChildren().add(MSWin);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();}
	}
}