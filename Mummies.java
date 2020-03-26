/**
 * @author T06 Group 4
 * @version Demo 2 GUI based game
 * @implNote The mummy class creates a mummy that takes a random direction as input and evaluates if the resultant move
 * can occur due to the absence of a wall. 
 */
package application;

import java.util.Random;


import java.util.Scanner;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mummies extends Character{
	//Pictures for the mummies
	private Image enemyRight;
	private Image enemyLeft;
	private Image enemyUp;
	private Image enemyDown;
	protected ImageView enemy = new ImageView(enemyRight);
	
	
	
	private Player playerInstance;
	
	public Mummies(Maze newMaze, Player playerInstance) {
		super(newMaze, newMaze.width - 1, newMaze.length -1);
		this.playerInstance = playerInstance;
	}
	
	public void setMaze(Maze newMaze) {
		super.setMaze(newMaze);
		this.setX(Maze.width-1);
		this.setY(Maze.length -1);
	}
	
	/* 
	 * Update coordinate function tests if the resultant move require passing through a wall as well as if the resultant move
	 * would move the mummy out of the boundary. 
	 */
	public void characterSelected(int characterselected){
		if (characterselected == 2){
			enemyRight = new Image("mummyRIGHT.png");
			enemyLeft = new Image("mummyLEFT.png");
			enemyUp = new Image("mummyUP.png");
			enemyDown = new Image("mummyDOWN.png");
		}
		else if (characterselected == 1){
			enemyRight = new Image("creeperR.png");
			enemyLeft = new Image("creeperL.png");
			enemyUp = new Image("creeperU.png");
			enemyDown = new Image("creeperD.png");
		}
		else{
			enemyRight = new Image("mummyRIGHT.png");
			enemyLeft = new Image("mummyLEFT.png");
			enemyUp = new Image("mummyUP.png");
			enemyDown = new Image("mummyDOWN.png");
		}
	}
	public void updatePosition (String mumDirection){
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		int currentMummyXCoord = (int) this.getX();
		int currentMummyYCoord = (int) this.getY();
		int newMummyXCoord = currentMummyXCoord;
		int newMummyYCoord = currentMummyYCoord;
		boolean invalid=false;
		
		if (mumDirection.equals("w")) {
			newMummyYCoord = currentMummyYCoord - 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].checkWall(2) == false && newMummyYCoord < Maze.length && newMummyYCoord >= 0) {
				this.setY(newMummyYCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("a")) {
			newMummyXCoord = currentMummyXCoord - 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].checkWall(3) == false && newMummyXCoord < Maze.width && newMummyXCoord >= 0) {
				this.setX(newMummyXCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("s")) {
			newMummyYCoord = currentMummyYCoord + 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].checkWall(0) == false && newMummyYCoord < Maze.length && newMummyYCoord >= 0) {
				this.setY(newMummyYCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("d")) {
			newMummyXCoord = currentMummyXCoord + 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].checkWall(1) == false && newMummyXCoord < Maze.width && newMummyXCoord >= 0) { 
				this.setX(newMummyXCoord);
			}
			else {
				invalid = true;
				}
		}
		if (invalid == false) {
			ordered[currentMummyYCoord][currentMummyXCoord].setStatus('e');
			ordered[newMummyYCoord][newMummyXCoord].setStatus('m');
		}
		else {
			ordered[currentMummyYCoord][currentMummyXCoord].setStatus('m');
		}
		if (newMummyYCoord < 0 || newMummyYCoord >= Maze.length) {
			this.setY(currentMummyYCoord);
		}
		if (currentMummyXCoord < 0 || currentMummyXCoord >= Maze.width) {
			this.setX(currentMummyXCoord);
		}
		
	}
	/*
	 * This method checks of the player and mummy have collided and will update the player lives accordingly as well as print
	 * a statement explaining what happened to the player into the counsel. 
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
	
	public void printLocation(){
		System.out.println("Mummy 1 is at "+ super.Location());
	}
	/* 
	 * This method takes the random direction input, determines if it is a valid amount, and if it is, feeds it into the update coordinate function
	 */
	public void getDirection(){
		Random mummDirNum = new Random();
		String mumDirection;
		boolean valid = false;
		int directionInput = mummDirNum.nextInt(4);
		if (directionInput == 0) {
			mumDirection = "w";
		}
		else if (directionInput == 1) {
			mumDirection = "a";
		}
		else if (directionInput == 2) {
			mumDirection = "s";
		}
		else {
			mumDirection = "d";
		}
		while (valid == false) {
			if (mumDirection.equals("a") || mumDirection.equals("s") || mumDirection.equals("w") || mumDirection.equals("d")) {
				this.updatePosition(mumDirection);
				valid = true;
			}
		}
	}
	
	/* 
	 * Getter methods
	 */
	
	
	/* 
	 * Moves the mummy GUI location in response to the getDirection() method.
	 */
	public void goDown() {
		if (this.getY()+1 < maze.length) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(0) == false) {
				enemy.setImage(enemyDown);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() + enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()+1);
			}
		}
	}
	
	public void goUp() {
		if (this.getY() - 1 >= 0) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(2) == false) {
				enemy.setImage(enemyUp);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() - enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()-1);
			}
		}
	}
	
	public void goLeft() {
		if (this.getX() - 1 >= 0) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(3) == false) {
				enemy.setImage(enemyLeft);
				this.setX(this.getX()-1);
				enemy.relocate(enemy.getLayoutX() - enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
	
			}
		}
	}
	
	public void goRight() {
		if (this.getX() + 1 < maze.width) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(1) == false) {
				enemy.setImage(enemyRight);
				enemy.relocate(enemy.getLayoutX()+ enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
				this.setX(this.getX()+1);
			}
		}
	}
}