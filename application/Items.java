/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The Items class is a class that can generate all the items for the maze at random, but unoccupied locations. 
 * 				It is not yet implemented but will be for the interactive demo.  
 */
package application;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Items {
	int jewelX, jewelY, staffX, staffY, gemX, gemY, ringX, ringY;
	private Maze maze;
	private Player playerInstance;
	Random coordOptions = new Random();
	protected Image jewel = new Image ("jewel.png");
	private Image staff = new Image ("staff.png");;
	private Image gem = new Image ("gem.png");;
	private Image ring = new Image ("ring.png");;
	protected ImageView jewelImg = new ImageView(jewel);
	protected ImageView staffImg = new ImageView(staff);
	protected ImageView gemImg = new ImageView(gem);
	protected ImageView ringImg = new ImageView(ring);
	
	/* 
	 * Constructor
	 */
	public Items (Maze maze, Player playerInstance) {
		this.maze = maze;
		this.setPlayerInstance(playerInstance);
	}
/*
 * Setters make the items at some random empty coordinate at the initialization of the maze. They do this by randomly generating a 
 * positive integer less than the width and length values as done using coordOptions. These values are then saves to a test attribute.
 * The set methods then check of the randomly generated coordinate is the start or end point of the maze. If it is, it will generate new
 * values. If it not, and the suggested coordinate has a status of 'e', meaning it is empty, it will set the status of that coordinate 
 * with the appropriate character and set the X and Y values for the item the successfully tested values. There are only one of each item
 * except gems which will change on the basis of the maze size. When this is implemented, it will be in a loop such that the number of 
 * gems is the area of the maze divided by 2. 
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
	
	
/*
 * Getter and setter methods
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
