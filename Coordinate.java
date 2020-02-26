
public class Coordinate {
	private int xCoord;
	private int yCoord;
	private char status;
	private char Letter;
	public Coordinate(int newX,int newY,char newStatus) {
		this.setStatus(newStatus);
		this.setX(newX);
		this.setY(newY);

	}
	public Coordinate(Coordinate Copy) {
		this.xCoord = Copy.xCoord;
		this.yCoord = Copy.yCoord;
		this.status = Copy.status;
		this.Letter = Copy.Letter;		
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
		this.Letter = newLetter;
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
		Coordinate copy = new Coordinate(this);
		return copy.Letter;
	}
	
	public boolean statusCheck(char check) {
		if (this.getStatus() == check){
			return true;
		}
		else {
			return false;
		}
	}
	//RENAME TO "XADJACENT"
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
	public String toString() {
		return "Coordinate: ("+this.xCoord+","+this.yCoord+")"+" Status:"+ this.status+" Letter:"+ this.Letter;
	}
	public static void main(String[] args) {
		Coordinate newcoord = new Coordinate(1,1,'e');
		System.out.println(newcoord.toString());
		Coordinate coord2 = new Coordinate(newcoord);
		coord2.setStatus('w');
		System.out.println(newcoord.toString());
		System.out.println(coord2.toString());
		coord2.setX(2);
		System.out.println(newcoord.xCollision(coord2));
		coord2.setX(3);
		System.out.println(newcoord.xCollision(coord2));
		System.out.println(newcoord.statusCheck('e'));
		System.out.println(newcoord.statusCheck('w'));
	}
}
