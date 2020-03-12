package application;

import java.util.Random;
import java.util.Scanner;

public class Mummies {
	private Maze maze;
	private Player playerInstance;
	private double mummyX = Maze.width-1;
	private double mummyY = Maze.length-1;
	
	public Mummies(Maze newMaze, Player playerInstance) {
		this.maze = newMaze;
		this.playerInstance = playerInstance;
	}
	
///////////////////////////////UPDATE COORDINATE////////////////////////
	
	public void updateMummyPosition (String mumDirection){
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
	public boolean checkCollision() {
		if (playerInstance.getX() == this.getX() && playerInstance.getY() == this.getY()) {
			playerInstance.updateLives(-1);
			System.out.println("Hit by Mummy. Player returned to start. Number of lives is " + playerInstance.getLives());
			return true;
		}
		else {return false;}
	}
	
	public void printLocation(){
		System.out.println("Mummy 1 is at " + this.getX() + ", " + this.getY());
	}
	
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
				this.updateMummyPosition(mumDirection);
				valid = true;
			}
		}
	}
	
	
	
	
	public double getX() {
		return this.mummyX;
	}

	public double getY() {
		return this.mummyY;
	}
	public void setX(double newX) {
		this.mummyX = newX;
	}
	
	public void setY(double newY) {
		this.mummyY = newY;
	}
}
