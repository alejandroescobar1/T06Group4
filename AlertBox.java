/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote This class creates a congratulatory alert box when the player wins the game, and a different alert box when
 * 			the player looses the game. This will be edited for the Interactive demo to also state the score when the player
 * 			wins.
 */
package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
	static ImageView knucklesWin = new ImageView("knucklesWin.png");
	static ImageView knucklesLoss = new ImageView("knucklesloss.gif");
	static ImageView MSWin = new ImageView("MSwin.gif");
	static ImageView MSLoss = new ImageView("MSLoss.gif");
	/*
	 * This creates a customized loss screen. It is called when the player looses all their lives. 
	 */
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
	/*
	 * This creates a customized win screen. It is called when the player successfully completes the maze. This
	 * will be edited for the Interactive Demo to also include the score message.  
	 */
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