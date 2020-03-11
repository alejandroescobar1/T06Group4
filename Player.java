package application;
import java.util.Scanner;


public class Player {
	private int lives = 3;
	private String playerName= "Dave";
	private Coordinate player = new Coordinate(0,0,'p', 'P', false, false, false, false);

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
	Maze mazeInstance = new Maze(6,6);
	Coordinate[][] ordered = mazeInstance.order(mazeInstance.CoordinateList);
	public void updatePlayerPosition (String direction){
		int currentPlayerXCoord = player.getX();
		int currentPlayerYCoord = player.getY();
		int newPlayerXCoord = currentPlayerXCoord;
		int newPlayerYCoord = currentPlayerYCoord;
		boolean invalid=false;
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].getUp() == false) {
				player.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].getLeft() == false) {
				player.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].getDown() == false) {
				player.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].getRight() == false) { 
				player.setX(newPlayerXCoord);
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
		if (newPlayerYCoord < 0 || newPlayerYCoord > mazeInstance.length) {
			player.setY(currentPlayerYCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		if (newPlayerXCoord < 0 || newPlayerXCoord > mazeInstance.width) {
			player.setX(currentPlayerXCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		
	}
	public boolean checkWin() {
		boolean win = false;
		
		if (player.getX() == 5 && player.getY() == 5) {
			win = true;
		}
		
		return win;
	}
	public void checkCollection(int itemX, int itemY) {
		boolean collection = false;
		if(player.getX() == itemX && player.getY() == itemY) {
			collection = true;
		}
	}
	public void printLocation(){
		System.out.println("Player is at " + player.getX() + ", " + player.getY());
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