package application;
import java.util.Scanner;


public class Player {
	private int lives = 3;
	private String playerName= "Dave";
	private double playerX = 0;
	private double playerY = 0;
	private Maze maze;
	
	public Player(Maze newMaze) {
		this.maze = newMaze;
	}
	public void setLives(int newLives)
	{
		this.lives = newLives;
	}

	public int getLives()
	{
		return (this.lives);
	}

	//@param the amount of life added or lose
	public int updateLives(int livesChange)
	{
		return (this.lives = lives + livesChange);
	}

	//////////////////////////////////////////////////////////////////////
	// This code allows the user to name the avatar's name. The default name is Dave
	public void setPlayerName()
	{
		String inputName1 = null;
		System.out.print("Enter user name: ");
		Scanner scan = new Scanner(System.in);
		inputName1 = scan.nextLine();
		if (inputName1 != null)
		{
			if(inputName1.isEmpty() == false) 
			this.playerName = inputName1;
		}
	}

	public String getPlayerName()
	{
		return (this.playerName);
	}
	//will call this method if lives<0
	public void dead()
	{

		System.out.println("Game Over!");
//		String action = getAction();
//		action = "EXIT";
//		return action;
	}
///////////////////////////////UPDATE COORDINATE////////////////////////
	
	public void updatePlayerPosition (String direction){
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		int currentPlayerXCoord = (int)this.getX();
		int currentPlayerYCoord = (int)this.getY();
		int newPlayerXCoord = currentPlayerXCoord;
		int newPlayerYCoord = currentPlayerYCoord;
		boolean invalid=false;
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(2) == false) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(3) == false) {
				this.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(0) == false) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(1) == false) { 
				this.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		if (invalid == false) {
			ordered[currentPlayerYCoord][currentPlayerXCoord].setStatus('e'); 
			ordered[newPlayerYCoord][newPlayerXCoord].setStatus('p');
		}
		else {
			ordered[currentPlayerYCoord][currentPlayerXCoord].setStatus('p');
		}
		if (newPlayerYCoord < 0 || newPlayerYCoord >= Maze.length) {
			this.setY(currentPlayerYCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		if (newPlayerXCoord < 0 || newPlayerXCoord >= Maze.width) {
			this.setX(currentPlayerXCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		
	}
	public boolean checkWin() {
		boolean win = false;
		
		if (this.getX() == Maze.width && this.getY() == Maze.length) {
			win = true;
		}
		
		return win;
	}
	public void checkCollection(int itemX, int itemY) {
		boolean collection = false;
		if(this.getX() == itemX && this.getY() == itemY) {
			collection = true;
		}
	}
	public void printLocation(){
		System.out.println("Player is at " + this.getX() + ", " + this.getY());
	}
	
	public double getX() {
		return this.playerX;
	}

	public double getY() {
		return this.playerY;
	}
	public void setX(double newX) {
		this.playerX = newX;
	}
	
	public void setY(double newY) {
		this.playerY = newY;
	}
	
	
	public void getDirection(){
		String directionInput = null;
		Boolean valid = false;
		System.out.print("Please enter direction (a = left, w = up, d = right, s = down): ");
		Scanner scan = new Scanner(System.in);
		directionInput = scan.nextLine();

		while (valid == false) {
			if (directionInput.equals("a") || directionInput.equals("s") || directionInput.equals("w") || directionInput.equals("d")) {
				this.updatePlayerPosition(directionInput);
				valid = true;
				//this.printLocation();
			}
		}
	}
}