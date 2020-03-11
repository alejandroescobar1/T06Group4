package application;

import java.util.Random;

public class Mummies {
	Maze mazeInstance = new Maze(6,6);
	Coordinate[][] ordered = mazeInstance.order(mazeInstance.CoordinateList);
	private Coordinate mummy1 = new Coordinate(mazeInstance.length-1,mazeInstance.width-1,'m', 'M', false, false, false, false);
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
			if (ordered[currentMummyYCoord][currentMummyXCoord].getUp() == false) {
				mummy1.setY(newMummyYCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("a")) {
			newMummyXCoord = currentMummyXCoord - 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].getLeft() == false) {
				mummy1.setX(newMummyXCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("s")) {
			newMummyYCoord = currentMummyYCoord + 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].getDown() == false) {
				mummy1.setY(newMummyYCoord);
			}
			else {
				invalid = true;
				}
		}
		else if (mumDirection.equals("d")) {
			newMummyXCoord = currentMummyXCoord + 1;
			if (ordered[currentMummyYCoord][currentMummyXCoord].getRight() == false) { 
				mummy1.setX(newMummyXCoord);
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
		if (newMummyYCoord < 0 || newMummyYCoord > mazeInstance.length) {
			playerCord.setY(currentMummyYCoord);
		}
		if (currentMummyXCoord < 0 || currentMummyXCoord > mazeInstance.width) {
			playerCord.setX(currentMummyXCoord);
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
	
	public String randomMummyDirection(){
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
		else {
			mumDirection = "d";
		}
		return mumDirection;
	}
}
