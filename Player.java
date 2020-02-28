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
	public void updatePlayerPosition (String direction){
		int currentPlayerXCoord = player.getX();
		int currentPlayerYCoord = player.getY();
		int newPlayerXCoord;
		int newPlayerYCoord;
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			// if check is valid
				player.setY(newPlayerYCoord);
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			// if check is valid
				player.setX(newPlayerXCoord);
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			// if check is valid
				player.setY(newPlayerYCoord);
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			// if check is valid
				player.setX(newPlayerXCoord);
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
				this.printLocation();
			}
		}
	}

//	public void move(int life)
	{
	//	this.direction = currentDirection;



	/*	if (updateLives(life) == 0)
		{
			dead();
		}
		*/
	//	if (updateLives(life) < 0)
	//	{
	//		if (direction == 'w')
	//		{
				//move up with the number of steps
				//ycoord minus 1
	//		}
	//		if (direction == 'd')
		//	{
				//move right with the number of steps
				//xcoord add 1
	//		}
	//		if (direction == 's')
		//	{
				//move down with the number of steps
				//xcoord minus t1
	//		}
		//	if (direction == 'a')
		//	{
				//move left with the number of steps
				//xcoord add  1
		//	}
	//	}
	}
}