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
	Maze newMaze = new Maze(5,5); MummyTimer mummyTimer;
	private Player p1; private Mummies mummy;
	private GraphicsContext gc;
	private GridPane grid = new GridPane();
	static private int length;
	static private int width;
	private Scene scene1, scene2, sceneCharacter;
	final static double canvasWidth = 702;
	private boolean canUpdate = true;
	private double imgSize; 
	private final ImageView bg = new ImageView("sandBG.png");
	private int characterSelected;
	
	private Group pane = new Group();
	
	public void start(Stage stage) throws Exception
	{	//create a new maze instance
		//length=6;
		//width=6;
		//newMaze= new Maze(length, width);
		//do wall randomization
		//newMaze.GenerateWalls();
		
		//output the wall strutures using a method that  
		stage.setTitle("Treasure Hunt");
		p1 = new Player(newMaze);
		
		
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
				mummy.printLocation();
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
	    
	    //Scene choosing character
	    HBox hbox = new HBox();
		hbox.setSpacing(20);
		hbox.setPadding(new Insets(500, 10, 10, 10));
		
		ImageView character1 = new ImageView("MSR.png");
		character1.setFitHeight(125);
		character1.setFitWidth(120);
		character1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				characterSelected = 1;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy);
				stage.setScene(scene1);
			}
		});
		
		ImageView character2 = new ImageView("ugandaR.png");
		character2.setFitHeight(125);
		character2.setFitWidth(120);
		character2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				characterSelected = 2;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy);
				stage.setScene(scene1);
			}
		});
		
		ImageView character3 = new ImageView("ugandaR.png");
		character3.setFitHeight(125);
		character3.setFitWidth(120);
		character3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				characterSelected = 3;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy);
				stage.setScene(scene1);
			}
		});
		
		ImageView character4 = new ImageView("ugandaR.png");
		character4.setFitHeight(125);
		character4.setFitWidth(120);
		character4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				characterSelected = 4;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy);
				stage.setScene(scene1);
			}
		});
		
		ImageView character5 = new ImageView("ugandaR.png");
		character5.setFitHeight(125);
		character5.setFitWidth(120);
		character5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				characterSelected = 5;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy);
				stage.setScene(scene1);
			}
		});
		
		hbox.getChildren().addAll(character1, character2, character3, character4, character5);
		
		ImageView characterBG = new ImageView("characterBG.png");
		Group group = new Group();
		group.getChildren().addAll(characterBG, hbox);
		
	    sceneCharacter = new Scene(group, 702, 702);
		
		characterBG.setFitWidth(702);
		characterBG.setFitHeight(702);
	    
		//scene1
	    scene1 = new Scene(grid, 702, 702, Color.ALICEBLUE);
	    
	    
		scene2 = new Scene(pane, canvasWidth, canvasWidth, Color.LIGHTYELLOW);
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
							mummyTimer.stop();
							AlertBox.displayWin(characterSelected);
							System.exit(0);
						}
						if (p1.checkLoss()){
							mummyTimer.stop();
							AlertBox.displayLoss(characterSelected);
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
							mummyTimer.stop();
							AlertBox.displayWin(characterSelected);
							System.exit(0);
						}
						if (p1.checkLoss()){
							mummyTimer.stop();
							AlertBox.displayLoss(characterSelected);
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
							mummyTimer.stop();
							AlertBox.displayWin(characterSelected);
							System.exit(0);
						}
						if (p1.checkLoss()){
							mummyTimer.stop();
							AlertBox.displayLoss(characterSelected);
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
							mummyTimer.stop();
							AlertBox.displayWin(characterSelected);
							System.exit(0);
						}
						if (p1.checkLoss()){
							mummyTimer.stop();
							AlertBox.displayLoss(characterSelected);
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
				
		stage.setScene(sceneCharacter);
		stage.setMaxHeight(canvasWidth + 38);
		stage.setMaxWidth(canvasWidth + 15);
		stage.setMinHeight(canvasWidth + 38);
		stage.setMinWidth(canvasWidth + 15);
		stage.show();
		
		//BUTTON
		Button play = new Button("Play");
		play.setOnAction(e -> {
			mummyTimer = new MummyTimer(p1, mummy);
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
