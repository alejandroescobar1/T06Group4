/**
 * @author T06 Group 4
 * @version Demo 2 Text-based game
 * @implNote The player class creates a player that takes a letter as the direction input and evaluates if the resultant move
 * can occur due to the absence of a wall. It also contains the lives attribute.
 */
import java.util.Scanner;


public class Player {
	private int lives = 3;
	private String playerName= "Dave";
	private double playerX = 0;
	private double playerY = 0;
	private Maze maze;
/*
 * Constructor 
 */
	public Player(Maze newMaze) {
		this.maze = newMaze;
	}
/*
 * methods pertaining to the player lives. 
 */
	public void setLives(int newLives)
	{
		this.lives = newLives;
	}

	public int getLives()
	{
		return (this.lives);
	}

/**
 * @param livesChanged (the amount of life added or lose)
 * @return updated lives count
 */
	public int updateLives(int livesChange)
	{
		return (this.lives = lives + livesChange);
	}
	//will call this method if lives<0
		public void dead()
		{
			System.out.println("Game Over!");
			System.exit(0);
		}
/*
 * methods pertaining to the player name. 
 */
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
	 
/* Update coordinate function tests if the resultant move require passing through a wall as well as if the resultant move
 * would move the player out of the boundary. 
 */
	
	public void updatePlayerPosition (String direction){
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		int currentPlayerXCoord = (int)this.getX();
		int currentPlayerYCoord = (int)this.getY();
		int newPlayerXCoord = currentPlayerXCoord;
		int newPlayerYCoord = currentPlayerYCoord;
		boolean invalid=false;
		
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(2) == false && newPlayerYCoord < Maze.length && newPlayerYCoord >= 0) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(3) == false && newPlayerXCoord < Maze.width && newPlayerXCoord >= 0) {
				this.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(0) == false && newPlayerYCoord < Maze.length && newPlayerYCoord >= 0) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(1) == false && newPlayerXCoord < Maze.width && newPlayerXCoord >= 0) { 
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
// checks if the player has reached the end of the maze 
	public boolean checkWin() {
		boolean win = false;
		
		if (this.getX() == Maze.width-1 && this.getY() == Maze.length-1) {
			win = true;
		}
		
		return win;
	}
/*
 * checks if player has collected an item. 
 */
	public char checkCollection(int newPlayerYCoord, int newPlayerXCoord) {
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		boolean collection = false;
		char newSpotStatus = 'e';
		if(ordered[newPlayerYCoord][newPlayerXCoord].getStatus() == 'g') {
			collection = true;
		}
	return newSpotStatus;
	}
/*
 * Prints a statement with the player's location
 */
	public void printLocation(){
		System.out.println("Player is at " + this.getX() + ", " + this.getY());
	}
/*
 * Getters for Player attributes
 */
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
	
	/* 
	 * This method takes the user input, determines if it is a valid amount, and if it is, feeds it into the update coordinate function
	 */
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