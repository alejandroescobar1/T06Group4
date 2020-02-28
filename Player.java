import java.util.Scanner;


public class Player {
	private int lives = 3;
	private String playerName= "Dave";
	private Coordinate player = new Coordinate(0,0,'p');

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
	public void updatePlayerPosition (String direction){
		int currentPlayerXCoord = player.getX();
		int currentPlayerYCoord = player.getY();
		int newPlayerXCoord = currentPlayerXCoord;
		int newPlayerYCoord = currentPlayerYCoord;
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			if (mazeInstance.up[currentPlayerXCoord][currentPlayerYCoord] == false) {
				player.setY(newPlayerYCoord);
			}
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			if (mazeInstance.right[currentPlayerXCoord-1][currentPlayerYCoord] == false) {
				player.setX(newPlayerXCoord);
			}
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			if (mazeInstance.down[currentPlayerXCoord][currentPlayerYCoord] == false) {
				player.setY(newPlayerYCoord);
			}
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			if (mazeInstance.right[currentPlayerXCoord][currentPlayerYCoord] == false) {
				player.setX(newPlayerXCoord);
			}
		}
		if (newPlayerXCoord == 5 && newPlayerYCoord == 5) {
			win();
		}
		
	}
	
	public boolean win() {
		System.out.println("Congradulations! You win!");
		boolean ifWin = true;
		return ifWin;
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
				this.printLocation();
			}
		}
	}
}