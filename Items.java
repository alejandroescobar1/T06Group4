/**
 * @author T06 Group 4
 * @version Demo 2 Text-based game
 * @implNote This class contains all the information for the items that will be available to the players. Currently, it has 
 * the functionality to create the items onto the maze but does not have the effects for each item implemented. 
 */
import java.util.Random;

public class Items {
	int jewelX, jewelY, staffX, staffY, gemX, gemY, ringX, ringY;
	private Maze maze;
	private Player playerInstance;
	Random coordOptions = new Random();
	
	public Items (Maze maze, Player playerInstance) {
		this.maze = maze;
		this.setPlayerInstance(playerInstance);
	}
/*
 * Setters make the items at some random empty coordinate at the initialization of the maze
 */
	public void setJewelCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int jewelYTest = coordOptions.nextInt(Maze.length);
			int jewelXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (jewelYTest == 0 && jewelXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (jewelYTest == Maze.length-1 && jewelXTest == Maze.width-1) {
				endPoint = true;
			}
			if (ordered[jewelXTest][jewelYTest].getStatus() == 'e'&& startPoint == false && endPoint == false) {
				this.jewelX = jewelXTest;
				this.jewelY = jewelYTest;
				ordered[jewelXTest][jewelYTest].setStatus('j');
				valuesGood = true;
			}
		}
	}
	public void setStaffCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int staffYTest = coordOptions.nextInt(Maze.length);
			int staffXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (staffYTest == 0 && staffXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (staffYTest == Maze.length-1 && staffXTest == Maze.width-1) {
				endPoint = true;
			}
			if (ordered[staffXTest][staffYTest].getStatus() == 'e'&& startPoint == false && endPoint == false) {
				this.staffX = staffXTest;
				this.staffY = staffYTest;
				ordered[staffXTest][staffYTest].setStatus('s');
				valuesGood = true;
			}
		}
	}
	public void setGemCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood ==false){
			int gemYTest = coordOptions.nextInt(Maze.length);
			int gemXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (gemYTest == 0 && gemXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (gemYTest == Maze.length-1 && gemXTest == Maze.width-1) {
				endPoint = true;
			}
			if (ordered[gemXTest][gemYTest].getStatus() == 'e'&& startPoint == false && endPoint == false) {
				this.gemX = gemXTest;
				this.gemY = gemYTest;
				ordered[gemXTest][gemYTest].setStatus('g');
				valuesGood = true;
			}
		}
	}
	public void setRingCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int ringYTest = coordOptions.nextInt(Maze.length);
			int ringXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (ringYTest == 0 && ringXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (ringYTest == Maze.length-1 && ringXTest == Maze.width-1) {
				endPoint = true;
			}
			if (ordered[ringXTest][ringYTest].getStatus() == 'e' && startPoint == false && endPoint == false) {
				this.ringX = ringXTest;
				this.ringY = ringYTest;
				ordered[ringXTest][ringYTest].setStatus('r');
				valuesGood = true;
			}
		}
	}
	
	/*public boolean checkCollectionJewel() {
		if (playerInstance.getX() == getJewelX() && playerInstance.getY() == getJewelY()) {
			playerInstance.updateLives(1);
			String statement = "Collected the Jewel. You gained a life. You now have " + playerInstance.getLives() + " lives.";
			System.out.println(statement);
			return true;
		}
		else {return false;}
	}
	
	public boolean checkCollectionStaff() {
		if (playerInstance.getX() == getRingX() && playerInstance.getY() == getRingY()) {
			//playerInstance.updateLives(-1);
			String statement = "Collected the Staff. You can kill mummies for five seconds now";
			System.out.println(statement);
			return true;
		}
		else {return false;}
	}
	
	public boolean checkCollectionGem() {
		if (playerInstance.getX() == getGemX() && playerInstance.getY() == getGemY()) {
			return true;
		}
		else {return false;}
	}
	
	public boolean checkCollectionRing() {
		if (playerInstance.getX() == getRingX() && playerInstance.getY() == getRingY()) {
			playerInstance.updateLives(-1);
			System.out.println("You collected the Ring. You lost a life. Number of lives is " + playerInstance.getLives());
			return true;
		}
		else {return false;}
	}*/
	
	
	
/*
 * Getter methods
 */
	public int getJewelX() {
		return this.jewelX;
	}
	public int getJewelY() {
		return this.jewelX;
	}
	public int getStaffX() {
		return this.jewelX;
	}
	public int getStaffY() {
		return this.jewelX;
	}
	public int getRingX() {
		return this.jewelX;
	}
	public int getRingY() {
		return this.jewelX;
	}
	public int getGemX() {
		return this.jewelX;
	}
	public int getGemY() {
		return this.jewelX;
	}
	public Player getPlayerInstance() {
		return playerInstance;
	}
	public void setPlayerInstance(Player playerInstance) {
		this.playerInstance = playerInstance;
	}
}
