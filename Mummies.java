/**
 * @author T06 Group 4
 * @version Demo 2 Text-based game
 * @implNote The mummy class creates a mummy that takes a random direction as input and evaluates if the resultant move
 * can occur due to the absence of a wall. 
 */

import java.util.Random;

public class Mummies {
	private Maze maze;
	private Player playerInstance;
	private double mummyX = Maze.width-1;
	private double mummyY = Maze.length-1;
	
	public Mummies(Maze newMaze, Player playerInstance) {
		this.maze = newMaze;
		this.setPlayerInstance(playerInstance);
	}
	
/* 
 * Update coordinate function tests if the resultant move require passing through a wall as well as if the resultant move
 * would move the mummy out of the boundary. 
 */
	
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
	public void printLocation(){
		System.out.println("Mummy 1 is at " + this.getX() + ", " + this.getY());
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
				this.updateMummyPosition(mumDirection);
				valid = true;
			}
		}
	}
	
	/* 
	 * Getter methods
	 */
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

	public Player getPlayerInstance() {
		return playerInstance;
	}

	public void setPlayerInstance(Player playerInstance) {
		this.playerInstance = playerInstance;
	}
}
