/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote This class deals with the actual graphical interface, handling mouse and keyboard inputs, presenting and changing 
 * 			the graphics visible on canvas, ect. This is also the class that needs to be executed in order to run the game.   
 */

package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MazeGUI extends Application {
	Maze newMaze = new Maze(2,2); MummyTimer mummyTimer;
	private Player p1; private Mummies mummy; private Items items;
	private GraphicsContext gc;
	private GridPane grid = new GridPane();
	static private int length;
	static private int width;
	private Scene scene1, scene2, sceneCharacter;
	final static double canvasWidth = 702;
	private boolean canUpdate = true;
	private double imgSize; 
	private final ImageView bg = new ImageView("/images/sandBG.png");
	private int characterSelected;
	private Group pane = new Group();
	
	/*
	 * Generating the screen that asks for user input for the maze dimentions and setting up the canvas length and width accordingly
	 */
	public void start(Stage stage) throws Exception{ 
		stage.setTitle("Treasure Hunt");
		p1 = new Player(newMaze);
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
		
		final Canvas canvas = new Canvas(canvasWidth, canvasWidth);
		gc=canvas.getGraphicsContext2D();
		
		// Event handler for user input for the maze dimensions. It alters the character sizes accordingly. This event handler also generates the maze.

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
				try {
				mummy.setMaze(newMaze);
				mummy.printLocation();
				}
				catch (Exception e){}
				mummy.enemy.relocate(imgSize * mummy.getX(), imgSize * mummy.getY());
				mummy.enemy.setFitHeight(imgSize);
				mummy.enemy.setFitWidth(imgSize);
				
				//determining the image size for the items
				items.setMaze(newMaze);
				
				items.setGemCoord();
				items.gemImg.relocate(imgSize * items.getGemX(), imgSize * items.getGemY());
				items.gemImg.setFitHeight(imgSize);
				items.gemImg.setFitWidth(imgSize);
				
				items.setJewelCoord();
				items.jewelImg.relocate(imgSize * items.getJewelX(), imgSize * items.getJewelY());
				items.jewelImg.setFitHeight(imgSize);
				items.jewelImg.setFitWidth(imgSize);
				
				items.setStaffCoord();
				items.staffImg.relocate(imgSize * items.getStaffX(), imgSize * items.getStaffY());
				items.staffImg.setFitHeight(imgSize);
				items.staffImg.setFitWidth(imgSize);
				
				items.setRingCoord();
				items.ringImg.relocate(imgSize * items.getRingX(), imgSize * items.getRingY());
				items.ringImg.setFitHeight(imgSize);
				items.ringImg.setFitWidth(imgSize);
				}
			}
	    };
		

	    Length.setOnKeyTyped(dimensionEntered);
	    Width.setOnKeyTyped(dimensionEntered);
		//!!!
		//PrintMazeGUI(newMaze.CoordinateList);
		//!!!
	    
	    /*
	     * Here, the choose character screen is being developed
	     */
	    HBox hbox = new HBox();
		hbox.setSpacing(20);
		hbox.setPadding(new Insets(500, 10, 10, 10));
		
		//time and lives label
		HBox root = new HBox();
		root.setSpacing(440);
		Label liveLbl = new Label("Lives: 3");
		liveLbl.setFont(Font.font("Verdana", 25));
		liveLbl.setTextFill(Color.BLACK);
		Label timeLbl = new Label("Time: 0");
		timeLbl.setFont(Font.font("Verdana", 25));
		timeLbl.setTextFill(Color.BLACK);
		root.setPadding(new Insets(710, 10, 10, 20));
		root.getChildren().addAll(liveLbl, timeLbl);
		
		ImageView character1 = new ImageView("/images/MSR.png");
		character1.setFitHeight(125);
		character1.setFitWidth(120);
		character1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			// Here, if the user picks the first character, it uses the Minecraft Steve character as the avatar (MSR.png).
			@Override
			public void handle(MouseEvent arg0) {
				characterSelected = 1;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				items = new Items(newMaze, p1);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy, items.gemImg, items.ringImg, items.jewelImg, items.staffImg, root);
				stage.setScene(scene1);
			}
		});
		// Currently, characters 2-5 are the same character
		ImageView character2 = new ImageView("/images/ugandaR.png");
		character2.setFitHeight(125);
		character2.setFitWidth(120);
		character2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				characterSelected = 2;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				items = new Items(newMaze, p1);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy, items.gemImg, items.ringImg, items.jewelImg, items.staffImg, root);
				stage.setScene(scene1);
			}
		});
		
		ImageView character3 = new ImageView("/images/spongebobR.png");
		character3.setFitHeight(125);
		character3.setFitWidth(120);
		character3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				characterSelected = 3;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				items = new Items(newMaze, p1);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy, items.gemImg, items.ringImg, items.jewelImg, items.staffImg, root);
				stage.setScene(scene1);
			}
		});
		
		ImageView character4 = new ImageView("/images/neeyanR.png");
		character4.setFitHeight(125);
		character4.setFitWidth(120);
		character4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				characterSelected = 4;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				items = new Items(newMaze, p1);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy, items.gemImg, items.ringImg, items.jewelImg, items.staffImg, root);
				stage.setScene(scene1);
			}
		});
		
		ImageView character5 = new ImageView("/images/linkR.png");
		character5.setFitHeight(125);
		character5.setFitWidth(120);
		character5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				characterSelected = 5;
				p1.characterSelected(characterSelected);
				mummy = new Mummies(newMaze, p1);
				mummy.characterSelected(characterSelected);
				items = new Items(newMaze, p1);
				pane.getChildren().addAll(bg, p1.playerImg, canvas, mummy.enemy, items.gemImg, items.ringImg, items.jewelImg, items.staffImg, root);
				stage.setScene(scene1);
			}
		});
		
		hbox.getChildren().addAll(character1, character2, character3, character4, character5);
		// gets background image
		ImageView characterBG = new ImageView("/images/characterBG.png");
		Group group = new Group();
		group.getChildren().addAll(characterBG, hbox);
		
	    sceneCharacter = new Scene(group, 702, 702);
		
		characterBG.setFitWidth(702);
		characterBG.setFitHeight(702);
	    
		//scene1
	    scene1 = new Scene(grid, 702, 702, Color.ALICEBLUE);
	    
	    
		scene2 = new Scene(pane, canvasWidth, canvasWidth + 50, Color.LIGHTYELLOW);
		//scene.getStylesheets().add(MazeGUI.class.getResource("MazeGUI.css").toExternalForm());
		
		//KeyBoard Interaction. These event handlers take the user input and check if the player can appropriately do the requested motion, checks for collisions, and checks if the player has won or lost at every turn 
		scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if (e.getCode().equals(KeyCode.W)) {
					if (canUpdate == true) {
						canUpdate = false;
						p1.goUp();
						mummy.checkCollision();
						items.checkCollisionGem();
						items.checkCollisionJewel();
						items.checkCollisionStaff();
						items.checkCollisionRing();
						if(p1.checkWin()) {
							mummyTimer.stop();
							p1.setTimeFinished(mummyTimer.getSecondPassed());
							AlertBox.displayWin(characterSelected, p1);
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
						items.checkCollisionGem();
						items.checkCollisionJewel();
						items.checkCollisionStaff();
						items.checkCollisionRing();
						if(p1.checkWin()) {
							mummyTimer.stop();
							p1.setTimeFinished(mummyTimer.getSecondPassed());
							AlertBox.displayWin(characterSelected, p1);
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
						items.checkCollisionGem();
						items.checkCollisionJewel();
						items.checkCollisionStaff();
						items.checkCollisionRing();
						if(p1.checkWin()) {
							mummyTimer.stop();
							p1.setTimeFinished(mummyTimer.getSecondPassed());
							AlertBox.displayWin(characterSelected, p1);
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
						items.checkCollisionGem();
						items.checkCollisionJewel();
						items.checkCollisionStaff();
						items.checkCollisionRing();
						if(p1.checkWin()) {
							mummyTimer.stop();
							p1.setTimeFinished(mummyTimer.getSecondPassed());
							AlertBox.displayWin(characterSelected, p1);
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

			@SuppressWarnings("incomplete-switch")
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
		stage.setMaxHeight(canvasWidth + 38 + 50);
		stage.setMaxWidth(canvasWidth + 15);
		stage.setMinHeight(canvasWidth + 38);
		stage.setMinWidth(canvasWidth + 15);
		stage.sizeToScene();
		stage.show();
		
		//making the play button
		Button play = new Button("Play");
		play.setOnAction(e -> {
			mummyTimer = new MummyTimer(p1, mummy);
			mummyTimer.start();
			stage.setScene(scene2);
		});
		grid.add(play, 0, 2);

		//display time in game
		final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler() {  
			@Override
			public void handle(Event arg0) {
			try {
				timeLbl.setText("Time: " + String.valueOf(mummyTimer.getSecondPassed()));
				if (p1.getLives() >= 0) {
				liveLbl.setText("Lives: " + p1.getLives());}
			}	
			catch (Exception e) {}
			}
		}));
				
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public void PrintMazeGUI(ArrayList<Coordinate> list) 
	{
		gc.restore();
		gc.save();

		///// put coordinates for i rows and j columns into ordered list
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
		/*
		 * Print the walls with black ink
		 */
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);

		for (int i = 0; i < length; i++){
			String row ="|";
            String top ="";
            double size = new Double(ordered.length);
            double scale = (canvasWidth-2)/size;
			for (int j = 0;j<width;j++) {
				if (ordered[i][j].getUp() == true) {
					top = top +" ---";
					
					// add 10 to both horizontal start and end point to begin with since otherwise the left outer wall gets cut off 
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
					gc.strokeLine(scalej+scale,scalei, scalej+scale, scalei +scale);
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
	}}