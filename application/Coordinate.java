/**
 * @author T06 Group 4
 * @version Demo 3 GUI-based game
 * @implNote The Coordinate class assigns a coordinate value to each block It also assigns to it the status of that block, 
 * for example if it is empty or has the player or mummy. It further defines functions that dictate what boundaries of 
 * what block act as a wall.
 */
package application;
public class Coordinate {
	private int xCoord;
	private int yCoord;
	private char status;
	private char letter;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	public boolean visited = false;
	
	/**
	 * Constructors
	 */
	public Coordinate(int col,int row,char newStatus,char newletter, boolean newup,boolean newdown,boolean newleft,boolean newright) {
		this.setStatus(newStatus);
		this.setX(col);
		this.setY(row);
		this.letter = newletter;
		this.up = newup;
		this.down = newdown;
		this.left = newleft;
		this.right = newright;
	}
	
	/**
	 * Constructors
	 */
	public Coordinate(Coordinate Copy) {
		this.xCoord = Copy.xCoord;
		this.yCoord = Copy.yCoord;
		this.status = Copy.status;
		this.letter = Copy.letter;
		this.up = Copy.up;
		this.down = Copy.down;
		this.left = Copy.left;
		this.right = Copy.right;
	}
	
	/*
	 * Setters and getters for attributes. No conditions apply to setting any of these values. Although there are only given 
	 * values or ranges of each attribute, since it is important to do functions only it is a certain value, these requirements
	 * are implicitly checked when the attribute is being used rather than when it is being set. 
	 */
	public void setX(int newX) {
		this.xCoord = newX;
	}
	
	
	public void setY(int newY) {
		this.yCoord = newY;
	}
	
	
	public void setStatus(char newStatus) {
		this.status = newStatus;
	}
	
	
	public void setLetter(char newLetter) {
		this.letter = newLetter;
	}
	
	
	
	public void setUp(boolean newUp) {
		this.up = newUp;
	}
	
	
	public void setDown(boolean newDown) {
		this.down = newDown;
	}
	
	
	public void setLeft(boolean newLeft) {
		this.left = newLeft;
	}
	
	
	public void setRight(boolean newRight) {
		this.right = newRight;
	}
	
	
	
	public int getX() {
		Coordinate copy = new Coordinate(this);
		return copy.xCoord;
	}
	
	
	public int getY() {
		Coordinate copy = new Coordinate(this);
		return copy.yCoord;
	}
	
	
	public char getStatus() {
		Coordinate copy = new Coordinate(this);
		return copy.status;
	}

	
	public char getLetter() {
		Coordinate Copy = new Coordinate(this);
		return Copy.letter;
	}
	
	/*
	 * These getDirection methods return booleans that indicate if the desired direction is allowed or not. 
	 * This is used by MazeGUI while constructing the maze.
	 */
	public boolean getUp() {
		return this.up;
	}
	
	
	public boolean getDown() {
		
		return this.down;
	}
	
	
	public boolean getLeft() {
		return this.left;
	}
	
	
	public boolean getRight() {
		return this.right;
	}
	
	/**
	 * This function checks the status of a coordinate to see what, if anything is occupying it.
	 */
	public boolean statusCheck(char check) {
		if (this.getStatus() == check){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This function relies on the get direction functions to determine if a wall exists in certain areas. 
	 */
	public boolean checkWall(int direction) {
		if (direction == 0) {
			return this.getDown();
		}
		else if (direction == 1) {
			return this.getRight();
		}
		else if (direction == 2) {
			return this.getUp();
		}
		else if (direction == 3) {
			return this.getLeft();
		}
		else { return true;}
	}
	
	/**
	 * This method breaks down the walls that are not needed in the maze. It is used when constructing
	 * the maze. 
	 */
	public void breakWall(int Direction) {
		if (Direction == 0) {
			this.setUp(false);
		}
		else if (Direction == 1) {
			this.setRight(false);	
			}
		else if (Direction == 2) {
			this.setDown(false);		
			}
		else if (Direction == 3) {
			this.setLeft(false);		
		}
	}
	
	/**
	 * This method returns a string that states the coordinate with the X and Y values. 
	 */
	public String toString() {
		return "Coordinate: ("+this.xCoord+","+this.yCoord+")"+" Status:"+ this.status;
	}
	public static void main(String[] args) {
		
	}
}