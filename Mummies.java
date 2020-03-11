package application;

import java.util.Random;

public class Mummies {
	Maze mazeInstance = new Maze(6,6);
	private Coordinate mummy1 = new Coordinate(mazeInstance.length,mazeInstance.width,'m', (char) 0, false, false, false, false);
	private Coordinate playerCord = new Coordinate(0,0,'p', (char) 0, false, false, false, false);
	private Player playerInstance = new Player();
	

	//////////////////////////////////////////////////////////////////////
	//will call this method if lives<0
	public void dead()
	{
		System.out.println("Game Over!");
	}
///////////////////////////////UPDATE COORDINATE////////////////////////
	
	public void updateMummyPosition (String mumDirection){
		int currentMummyXCoord = mummy1.getX();
		int currentMummyYCoord = mummy1.getY();
		int newMummyXCoord = currentMummyXCoord;
		int newMummyYCoord = currentMummyYCoord;
		boolean invalid=false;
		
		if (mumDirection.equals("w")) {
			newMummyYCoord = currentMummyYCoord - 1;
			if (mazeInstance.up[currentMummyYCoord][currentMummyXCoord] == false) {
				mummy1.setY(newMummyYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (mumDirection.equals("a")) {
			newMummyXCoord = currentMummyXCoord - 1;
			if (mazeInstance.right[currentMummyYCoord][currentMummyXCoord-1] == false) {
				mummy1.setX(newMummyXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (mumDirection.equals("s")) {
			newMummyYCoord = currentMummyYCoord + 1;
			if (mazeInstance.down[currentMummyYCoord][currentMummyXCoord] == false) {
				mummy1.setY(newMummyYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (mumDirection.equals("d")) {
			newMummyXCoord = currentMummyXCoord + 1;
			if (mazeInstance.right[currentMummyYCoord][currentMummyXCoord] == false) { 
				mummy1.setX(newMummyXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		if (invalid == false) {
			mazeInstance.CoordinateList2D[currentMummyYCoord][currentMummyXCoord] = 'E';
			mazeInstance.CoordinateList2D[newMummyYCoord][newMummyXCoord] = 'M';
		}
		else {
			mazeInstance.CoordinateList2D[currentMummyYCoord][currentMummyXCoord] = 'M';
		}
		if (newMummyYCoord < 0 || newMummyYCoord > mazeInstance.length) {
			playerCord.setY(currentMummyYCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		if (currentMummyXCoord < 0 || currentMummyXCoord > mazeInstance.width) {
			playerCord.setX(currentMummyXCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		checkCollision();
		
	}
	public int checkCollision() {
		if (playerCord.getX() == mummy1.getX() && playerCord.getY() == mummy1.getY()) {
			playerInstance.updateLives(-1);
			int numKilledChange = 1;
			return numKilledChange;
		}
		else {return 0;}
	}
	
	public void printLocation(){
		System.out.println("Mummy 1 is at " + mummy1.getX() + ", " + mummy1.getY());
	}
	
	public void randomMummyDirection(){
		Random mummDirNum = new Random();
		String mumDirection = null;
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
		else if (directionInput == 3) {
			mumDirection = "d";
		}
	}
}
