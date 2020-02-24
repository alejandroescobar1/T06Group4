
public class Coordinate {
	private int xCoord;
	private int yCoord;
	private char status;
	public Coordinate(int newX,int newY,char newStatus) {
		
	}
	public Coordinate(Coordinate Copy) {
		this.xCoord = Copy.xCoord;
		this.yCoord = Copy.yCoord;
		this.status = Copy.status;
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
	public boolean statusCheck(char check) {
		if (this.getStatus() == check){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean xCollision(Coordinate coord) {
		if ((this.getY() == coord.getY())&&((this.getX() == (coord.getX() - 1)) || (this.getX() == (coord.getX() + 1)))){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean yCollision(Coordinate coord) {
		if ((this.getX() == coord.getX())&&((this.getY() == (coord.getY() - 1)) || (this.getY() == (coord.getY() + 1)))){
			return true;
		}
		else{
			return false;
		}
	}
}
