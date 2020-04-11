/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The mummy class is a subclass and it extends the abstract Character class. This class uses the 
 * 			constructor from its super class to create a mummy. This class also gives the mummy a random direction
 * 			and tests if that direction is valid. 
 */
package application;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mummies extends Character{
	//Pictures for the mummies
	private Image enemyRight;
	private Image enemyLeft;
	private Image enemyUp;
	private Image enemyDown;
	protected ImageView enemy = new ImageView(enemyRight);
	//Attributes needed to make the mummy start at a random location
	Random coordOptions = new Random();
	private int startX;
	private int startY;
	// Creates an instance of a player
	private Player playerInstance;
	
	/**Constructor. The constructor uses the super constructor to make the mummy. However, it quickly overrides the default
	 * start position by generating a valid, random location for the mummy to start at. This is done by calling the 
	 * tryStartCoord() method followed by the use of the super setters to set the new X and Y coordinates to start. If you want
	 * to start the mummy at a given location, comment out the tryStartCoord() line upto and including the super.setY(startY)
	 * line.
	 */
	public Mummies(Maze newMaze, Player playerInstance) {
		super(newMaze, Maze.width - 1, Maze.length -1);
		tryStartCoord();
		super.setX(startX);
		super.setY(startY);
		this.playerInstance = playerInstance;
	}
	
	/**
	 * This method randomly generates possible coordinates for the mummy start point. It then checks if that randomly
	 * generated position is the start of end position of the maze. If it is not either of those, and that coordinate 
	 * has a status of 'e' (meaning empty), then it will both set that location at the start coordinates and set the 
	 * status of the coordinate to 'm'. This is important as the Item class uses these statuses to determine where it 
	 * can generate items in, and it is also an important functionality for the player when it is checking what it has
	 * collected.
	 */
	public void tryStartCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int startYTest = coordOptions.nextInt(Maze.length);
			int startXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (startYTest == 0 && startXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (startYTest == Maze.length-1 && startXTest == Maze.width-1) {
				endPoint = true;
			}
			if (ordered[startXTest][startYTest].getStatus() == 'e'&& startPoint == false && endPoint == false) {
				this.startX = startXTest;
				this.startY = startYTest;
				ordered[startXTest][startYTest].setStatus('m');
				valuesGood = true;
			}
		}
	}
	
	/** 
	 * This method assigns the appropriate images to the mummy according to the character the user chose
	 * in the beginning. Since there are only two unique characters made thus far, if the character picks
	 * any character other than character 1, they will get the same enemy and the same avatar. 
	 */
	public void characterSelected(int characterselected){
		if (characterselected == 1){
			enemyRight = new Image("/images/creeperR.png");
			enemyLeft = new Image("/images/creeperL.png");
			enemyUp = new Image("/images/creeperU.png");
			enemyDown = new Image("/images/creeperD.png");
			
		}
		else if (characterselected == 2){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 3){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 4){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 5){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
	}

	/**
	 * This method checks of the player and mummy have collided and will update the player lives accordingly. 
	 * It will also move the player to the beginning position as well as print a statement explaining what 
	 * happened to the player into the counsel. 
	 */
	public boolean checkCollision() {
		if (playerInstance.getX() == this.getX() && playerInstance.getY() == this.getY()) {
			playerInstance.updateLives(-1);
			System.out.println("Hit by Mummy. Player returned to start. Number of lives is " + playerInstance.getLives());
			playerInstance.setX(0);
			playerInstance.setY(0);
			playerInstance.playerImg.setImage(playerInstance.playerR);
			playerInstance.playerImg.relocate(0,0);
			return true;
		}
		else {return false;}
	}
	
	/**
	 * Print the location
	 */
	public void printLocation(){
		System.out.println("Mummy 1 is at "+ super.Location());
	}
	
	/* 
	 * Moves the mummy GUI location in the direction listed in the method name. It is called in MazeGUI 
	 * when it is given a random direction. 
	 */
	public void goDown() {
		if (this.getY()+1 < Maze.length) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(0) == false) {
				enemy.setImage(enemyDown);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() + enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()+1);
			}
		}
	}
	
	public void goUp() {
		if (this.getY() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(2) == false) {
				enemy.setImage(enemyUp);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() - enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()-1);
			}
		}
	}
	
	public void goLeft() {
		if (this.getX() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(3) == false) {
				enemy.setImage(enemyLeft);
				this.setX(this.getX()-1);
				enemy.relocate(enemy.getLayoutX() - enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
	
			}
		}
	}
	
	public void goRight() {
		if (this.getX() + 1 < Maze.width) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(1) == false) {
				enemy.setImage(enemyRight);
				enemy.relocate(enemy.getLayoutX()+ enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
				this.setX(this.getX()+1);
			}
		}
	}
}