/**
 * @author T06 Group 4
 * @version Demo 2 GUI based game
 * @implNote This class contains generates the actual GUI version of the maze using a randomized correct path 
 * to the finish coordinate and generating walls by preventing the passing of these walls. It will rely on the logic developed
 * in the Maze class 
 */
package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;


public class MazeGUI extends Application {
	Maze newMaze = new Maze(5,5);
	private Player p1; private Mummies mummy;
	private GraphicsContext gc;
	private GridPane grid = new GridPane();
	static private int length;
	static private int width;
	private Scene scene1, scene2;
	final static double canvasWidth = 702;
	private boolean canUpdate = true;
	private double imgSize;

	
	public void start(Stage stage) throws Exception
	{	//create a new maze instance
		//length=6;
		//width=6;
		//newMaze= new Maze(length, width);
		//do wall randomization
		//newMaze.GenerateWalls();
		
		//output the wall structures using a method that  
		stage.setTitle("Treasure Hunt");
		p1 = new Player(newMaze);
		mummy = new Mummies(newMaze, p1);
		
		//timer for mummy
	
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
		
		final Canvas canvas = new Canvas(canvasWidth, canvasWidth);
		gc=canvas.getGraphicsContext2D();

	    EventHandler<KeyEvent> dimensionEntered = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent change) {
				if (Length.getText().isEmpty()==false && Width.getText().isEmpty()==false&&Integer.parseInt(Length.getText())==Integer.parseInt(Width.getText()))
				{	
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				length=Integer.parseInt(Length.getText());
				width=Integer.parseInt(Width.getText());
				
				newMaze = new Maze(Integer.parseInt(Length.getText()), Integer.parseInt(Width.getText()));
				newMaze.GenerateWalls();
				PrintMazeGUI(newMaze.CoordinateList);
				
				//determine player image size && create player
				p1.setMaze(newMaze);
				imgSize = canvasWidth / length;
				p1.playerImg.setFitHeight(imgSize); //width/length - lineWidth pixel;
				p1.playerImg.setFitWidth(imgSize);  //width/length - lineWidth pixel;
				
				
				//determining the image size for the mummy
				mummy.setMaze(newMaze);
				mummy.enemy.relocate(imgSize * mummy.getX(), imgSize * mummy.getY());
				mummy.enemy.setFitHeight(imgSize);
				mummy.enemy.setFitWidth(imgSize);
				
				
				}
			}
	    };
		
	   // Length.setOnKeyPressed(dimensionEntered);
	    Length.setOnKeyTyped(dimensionEntered);
	    //Width.setOnKeyPressed(dimensionEntered);
	    Width.setOnKeyTyped(dimensionEntered);
		//!!!
		//PrintMazeGUI(newMaze.CoordinateList);
		//!!!
	    
	    Group pane = new Group();
	    
	    pane.getChildren().addAll(p1.playerImg, canvas, mummy.enemy);
		Scene scene1 = new Scene(grid);
		Scene scene2 = new Scene(pane, canvasWidth, canvasWidth, Color.LIGHTYELLOW);
		//scene.getStylesheets().add(MazeGUI.class.getResource("MazeGUI.css").toExternalForm());
		
		//KeyBoard Interaction
		scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if (e.getCode().equals(KeyCode.W)) {
					if (canUpdate == true) {
						canUpdate = false;
						p1.goUp();
						mummy.checkCollision();
						if(p1.checkWin()) {
							AlertBox.displayWin();
							System.exit(0);
						}
						
					}
				}
				else if (e.getCode().equals(KeyCode.S)) {
					if (canUpdate == true) {
						canUpdate = false;
						p1.goDown();
						mummy.checkCollision();
						if(p1.checkWin()) {
							AlertBox.displayWin();
							System.exit(0);
						}
					}
				}
				else if (e.getCode().equals(KeyCode.D)) {
					if (canUpdate == true) {
						canUpdate = false;
						p1.goRight();
						mummy.checkCollision();
						if(p1.checkWin()) {
							AlertBox.displayWin();
							System.exit(0);
						}
					}
				}
				else if (e.getCode().equals(KeyCode.A)) {
					if (canUpdate == true) {
						canUpdate = false;
						p1.goLeft();
						mummy.checkCollision();
						if(p1.checkWin()) {
							AlertBox.displayWin();
							System.exit(0);
						}
					}
				}
			}
		});
		
		scene2.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
				case W: canUpdate = true; break;
				case S: canUpdate = true; break;
				case D: canUpdate = true; break;
				case A: canUpdate = true; break;
				}
			}
		});			
				
		
		stage.setScene(scene1);
		stage.sizeToScene();
		stage.show();
		
		//BUTTON
		Button play = new Button("Play");
		play.setOnAction(e -> {
			MummyTimer mummyTimer = new MummyTimer(p1, mummy);
			mummyTimer.start();
			stage.setScene(scene2);
		});
		grid.add(play, 0, 2);

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public void PrintMazeGUI(ArrayList<Coordinate> list) 
	{
		gc.restore();
		gc.save();
		//gc.setLineWidth(1);

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
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);

		for (int i = 0; i < length; i++){
			String row ="|";
            String top ="";
            double size = new Double(ordered.length);
            double scale = (canvasWidth-2)/size;
			//gc.strokeText("",1,1);
			//gc.strokeText("|",10,10);
			
			//gc.fillText("|",10,10,0.3);
			for (int j = 0;j<width;j++) {
				if (ordered[i][j].getUp() == true) {
					top = top +" ---";
					
					// add 10 to both horizontal start and end point to begin with since otherwise the left outter wall gets chunked off 
					if (i!=0||j!=0)
                    {double scalej = (j*scale)+1;
                        double scalei = (i*scale)+1;
                        gc.strokeLine(scalej,scalei, scalej+scale, scalei);
                        gc.strokeLine(1,canvasWidth-2,canvasWidth-2-scale,canvasWidth); //2 is LineWidth
                    }
					}
				 else {
					 top = top +"    ";
				}
				row = row + " " + ordered[i][j].getLetter();
				if (ordered[i][j].getRight() == true) {
                    double scalej = (j*scale)+1;
                    double scalei = (i*scale)+1;
					row = row+" |";
					// add 10 to both horizontal start and end point to begin with since otherwise the left outter wall gets chunked off 
					gc.strokeLine(scalej+scale,scalei, scalej+scale, scalei +scale);
					//gc.strokeText("|",i+1,j+1);
					//the below code draws the left side of wall
					gc.strokeLine(1,scalei, 1, scalei+scale);
				 }
                else {row= row+"  ";}
                }
            
			System.out.println(top);
            System.out.println(row);
            
            
			}
            
		for (int n = 1; n<length; n++) {
			if (n == length-1){
				System.out.println(" ---");
			}
        	else if (n == length) {
        		System.out.println(" ---     ");
        	}
        	
        	else {
        		System.out.print(" ---");
        	}
        }
        
		//the below loop draws the bottom side of wall
		//for (int i = 0; i < length-1; i++){
        //gc.strokeLine(i+10,width+10, i+10.9, width+10);
        //}
	}}