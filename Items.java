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
		this.playerInstance = playerInstance;
	}
/*
 * Setters make the items at some random empty coordinate at the initialization of the maze
 */
	public void setJewelCoord() {
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int jewelYTest = coordOptions.nextInt(Maze.length);
			int jewelXTest = coordOptions.nextInt(Maze.width);
			if (ordered[jewelXTest][jewelYTest].getStatus() == 'e') {
				this.jewelX = jewelXTest;
				this.jewelY = jewelYTest;
				ordered[jewelXTest][jewelYTest].setStatus('j');
				valuesGood = true;
			}
		}
	}
	public void setStaffCoord() {
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int staffYTest = coordOptions.nextInt(Maze.length);
			int staffXTest = coordOptions.nextInt(Maze.width);
			if (ordered[staffXTest][staffYTest].getStatus() == 'e') {
				this.staffX = staffXTest;
				this.staffY = staffYTest;
				ordered[staffXTest][staffYTest].setStatus('s');
				valuesGood = true;
			}
		}
	}
	public void setGemCoord() {
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood ==false){
			int gemYTest = coordOptions.nextInt(Maze.length);
			int gemXTest = coordOptions.nextInt(Maze.width);
			if (ordered[gemXTest][gemYTest].getStatus() == 'e') {
				this.gemX = gemXTest;
				this.gemY = gemYTest;
				ordered[gemXTest][gemYTest].setStatus('g');
				valuesGood = true;
			}
		}
	}
	public void setRingCoord() {
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int ringYTest = coordOptions.nextInt(Maze.length);
			int ringXTest = coordOptions.nextInt(Maze.width);
			if (ordered[ringXTest][ringYTest].getStatus() == 'e') {
				this.ringX = ringXTest;
				this.ringY = ringYTest;
				ordered[ringXTest][ringYTest].setStatus('r');
				valuesGood = true;
			}
		}
	}
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
}
