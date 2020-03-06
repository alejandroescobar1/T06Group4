import java.util.ArrayList;
public class Coordinate {
	private int xCoord;
	private int yCoord;
	private char status;
	private char letter;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	
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
	
	
	public boolean getUp() {
		Coordinate Copy = new Coordinate(this);
		return Copy.up;
	}
	
	
	public boolean getDown() {
		Coordinate Copy = new Coordinate(this);
		return Copy.down;
	}
	
	
	public boolean getLeft() {
		Coordinate Copy = new Coordinate(this);
		return Copy.left;
	}
	
	
	public boolean getRight() {
		Coordinate Copy = new Coordinate(this);
		return Copy.right;
	}
	
	
	public boolean statusCheck(char check) {
		if (this.getStatus() == check){
			return true;
		}
		else {
			return false;
		}
	}
	
	
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
	
	
	public String toString() {
		return "Coordinate: ("+this.xCoord+","+this.yCoord+")"+" Status:"+ this.status;
	}
	public static void main(String[] args) {
		
	}
}












