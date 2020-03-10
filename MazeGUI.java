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
import javafx.scene.input.KeyEvent;


public class MazeGUI extends Application {
	Maze newMaze;
	private GraphicsContext gc;
	private GridPane grid = new GridPane();
	static private int length;
	static private int width;

	
	public void start(Stage stage) throws Exception
	{	//create a new maze instance
		//length=6;
		//width=6;
		//newMaze= new Maze(length, width);
		//do wall randomization
		//newMaze.GenerateWalls();
		
		//output the wall strutures using a method that  
		stage.setTitle("MazeGUI");
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));

		Label LengthLabel = new Label("Length:");
		final TextField Length = new TextField();
		grid.add(LengthLabel, 0, 0);
		grid.add(Length, 1, 0);
		
		Label WidthLabel = new Label("Width:");
		final TextField Width = new TextField();
		grid.add(WidthLabel, 0, 1);
		grid.add(Width, 1, 1);
		//grid.setGridLinesVisible(true);
		
		final Canvas canvas = new Canvas(456, 456);

		gc=canvas.getGraphicsContext2D();
		grid.add(canvas, 0, 3, 2, 1);
		
	    EventHandler<KeyEvent> dimensionEntered = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent change) {
				if (Length.getText().isEmpty()==false && Width.getText().isEmpty()==false&&Integer.parseInt(Length.getText())==Integer.parseInt(Width.getText()))
				{newMaze = new Maze(Integer.parseInt(Length.getText()), Integer.parseInt(Width.getText()));
				length=Integer.parseInt(Length.getText());
				width=Integer.parseInt(Width.getText());
				newMaze.GenerateWalls();
				PrintMazeGUI(newMaze.CoordinateList);}
			}
	    };
		
	   // Length.setOnKeyPressed(dimensionEntered);
	    Length.setOnKeyTyped(dimensionEntered);
	    //Width.setOnKeyPressed(dimensionEntered);
	    Width.setOnKeyTyped(dimensionEntered);
		//!!!
		//PrintMazeGUI(newMaze.CoordinateList);
		//!!!

		Scene scene = new Scene(grid);
		//scene.getStylesheets().add(MazeGUI.class.getResource("MazeGUI.css").toExternalForm());
		
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		
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
					gc.strokeLine(j+10,i+10, j+10.9, i+10);
					
					
					}
				 else {
					 top = top +"    ";
				}
				row = row + " " + ordered[i][j].getLetter();
				if (ordered[i][j].getRight() == true) {
					row = row+" |";
					// add 10 to both horizontal start and end point to begin with since otherwise the left outter wall gets chunked off 
					gc.strokeLine(j+11,i+10, j+11, i+10.9);
					//gc.strokeText("|",i+1,j+1);
					gc.strokeLine(10,i+10, 10, i+10.9);
				 }
				else {row= row+"  ";}
				}
		
			System.out.println(top);
			System.out.println(row);
			//for (int charac=0;i<row.length();charac++)
				//{System.out.println(row.charAt(charac));}
			}
		
		System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- ---     ");
		for (int i = 0; i < length; i++)
		{gc.strokeLine(i+10,width+10, i+10.9, width+10);}
	}}
