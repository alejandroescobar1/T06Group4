/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote This class creates a congratulatory alert box when the player wins the game, and a different alert box when
 * 			the player looses the game. This will be edited for the Interactive demo to also state the score when the player
 * 			wins.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
	static ImageView knucklesWin = new ImageView("/images/knucklesWin.png");
	static ImageView knucklesLoss = new ImageView("/images/knucklesloss.gif");
	static ImageView MSWin = new ImageView("/images/MSwin.gif");
	static ImageView MSLoss = new ImageView("/images/MSLoss.gif");
	
	/**
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
		}
		else if (character == 1){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().add(MSLoss);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
		else if (character == 3){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().add(knucklesLoss);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
		else if (character == 4) {
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().add(knucklesLoss);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
		else if (character == 5) {
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().add(knucklesLoss);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
		}
	}
	
	/**
	 * This creates a customized win screen. It is called when the player successfully completes the maze. This
	 * will be edited for the Interactive Demo to also include the score message.  
	 */
	public static void displayWin(int character, Player p1) {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(150, 10, 10, 250));

		Label gemLbl = new Label("Gems: " + p1.getGemItem());
		gemLbl.setFont(Font.font("Verdana", 30));
		gemLbl.setTextFill(Color.BLACK);
		Label mummyLbl = new Label("Mummy killed: " + p1.getNumMummyKilled());
		mummyLbl.setFont(Font.font("Verdana", 30));
		mummyLbl.setTextFill(Color.BLACK);
		Label deaths = new Label("Lives: " + p1.getLives());
		deaths.setFont(Font.font("Verdana", 30));
		deaths.setTextFill(Color.BLACK);
		Label posItem = new Label("Good item: " + p1.getPosItem());
		posItem.setFont(Font.font("Verdana", 30));
		posItem.setTextFill(Color.BLACK);
		Label negItem = new Label("Bad item: " + p1.getNegItem());
		negItem.setFont(Font.font("Verdana", 30));
		negItem.setTextFill(Color.BLACK);
		Label time = new Label("Time: " + p1.getTimeFinished());
		time.setFont(Font.font("Verdana", 30));
		time.setTextFill(Color.BLACK);
		Label score = new Label("Score: " + Score.getScore(p1));
		score.setFont(Font.font("Verdana", 30));
		score.setTextFill(Color.BLACK);
		vbox.getChildren().addAll(gemLbl, mummyLbl, deaths, posItem, negItem, time, score);
		
		Rectangle rec = new Rectangle(400, 300, Color.LIGHTYELLOW);
		rec.setX(180);
		rec.setY(130);
		
		if (character == 2){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().addAll(knucklesWin, rec, vbox);
		
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
		else if (character == 1){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().add(MSWin);
		
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
		else if (character == 3){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().addAll(knucklesWin, rec, vbox);
		
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
		else if (character == 4){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().addAll(knucklesWin, rec, vbox);
		
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
		else if (character == 5){
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			Group layout = new Group();
			layout.getChildren().addAll(knucklesWin, rec, vbox);
		
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			}
	}
}