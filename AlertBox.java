package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	static ImageView imgWin = new ImageView("imageWin.png");
	
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
