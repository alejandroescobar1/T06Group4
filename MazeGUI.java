//This class converts the existing text-based Maze to GUI version

package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MazeGUI extends Application {
	Maze newMaze;
	private GraphicsContext gc;
	private GridPane grid = new GridPane();
	static private int length;
	static private int width;

	
	public void start(Stage stage) throws Exception
	{	//create a new maze instance
		newMaze= new Maze(5, 5);
		length=5;
		width=5;
		//do wall randomization
		newMaze.GenerateWalls();
		
		//output the wall strutures using a method that  
		stage.setTitle("Maze!");
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));

		Label xStartLabel = new Label("X:");
		final TextField xStart = new TextField();
		grid.add(xStartLabel, 0, 0);
		grid.add(xStart, 1, 0);
		
		Label yStartLabel = new Label("Y:");
		final TextField yStart = new TextField();
		grid.add(yStartLabel, 0, 1);
		grid.add(yStart, 1, 1);
		//grid.setGridLinesVisible(true);
		
		final Canvas canvas = new Canvas(456, 456);

		gc = canvas.getGraphicsContext2D();
		grid.add(canvas, 0, 3, 2, 1);
		
		//!!!
		PrintMazeGUI(newMaze.CoordinateList);
		//!!!
		
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(MazeGUI.class.getResource("MazeGUI.css").toExternalForm());
		
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	    //xStart.setOnKeyPressed(textChanged);
	    //yStart.setOnKeyPressed(textChanged);
		//gc = canvas.getGraphicsContext2D();
		//newMaze.PrintMazeGUI(newMaze.CoordinateList);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public void PrintMazeGUI(ArrayList<Coordinate> list) 
	{
		gc.save();
		gc.scale(12,12);
		//gc.clearRect(0, 0, model.getWidth()*10, model.getHeight()*10);
		gc.setLineWidth( 1 );
		gc.setStroke(Color.BLACK);
	
		
		///// put into ordered list
		Coordinate[][] ordered = new Coordinate[length][width];
		for (int i = 0; i < length; i++){
			for (int j = 0;j<width;j++) {
				for (Coordinate c: list) {
					if (c.getX() == i&&c.getY() == j) {
						ordered[j][i] = c;
					}
				}
			}
		}
		////
		
		///print ordered list to gui
		//first print walls
		gc.setStroke(Color.GREEN);
		
		gc.setLineWidth(0.3);
		
		
		//draw a vertical line 3rd arg(horizaontal end point) being same as 1st and 4th arg(vertical end point)  add 1 from 2nd
		//gc.strokeLine(1,1, 1, 2);

		//draw a horizontal line 3rd arg(horizaontal end point) add 1 from 1st; and 4th arg(vertical end point)  stay same
		//gc.strokeLine(3,3, 4, 3);
		//gc.strokeOval(1,1, 1, 1);
		
		
		
		for (int i = 0; i < length; i++){
			String row ="|";
			String top ="";
			//gc.strokeText("",1,1);
			//gc.strokeText("|",10,10);
			
			//gc.fillText("|",10,10,0.3);
			for (int j = 0;j<width;j++) {
	
				if (ordered[i][j].getUp() == true) {
					top = top +" ---";
					
					// add 10 to both horizontal start and end point to begin with since otherwise the left outter wall gets chunked off 
					gc.strokeLine(i+10,j+10, i+10.9, j+10);
					}
				 else {
					 top = top +"    ";
				}
				row = row + " " + ordered[i][j].getLetter();
				if (ordered[i][j].getRight() == true) {
					row = row+" |";
					// add 10 to both horizontal start and end point to begin with since otherwise the left outter wall gets chunked off 
					gc.strokeLine(i+10,j+10, i+10, j+10.9);
					//gc.strokeText("|",i+1,j+1);
					
				 }
				else {row= row+"  ";}
				}
		
			System.out.println(top);
			System.out.println(row);
			
			
			}
		System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- ---     ");

	}}
