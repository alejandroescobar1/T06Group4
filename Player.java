import java.util.ArrayList;
import java.util.Scanner;


public class Player {
	private int lives = 3;
	private String playerName= "Dave";
	private char direction;
	private int steps;

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
		inputName1 = scan.next();
		if (inputName1 != null)
		{
			if(inputName1.isEmpty() == false) 
			this.playerName = inputName1;
			scan.close();
					}
	}

	public String getPlayerName()
	{
		return (this.playerName);
	}

	public void setDirection(char newDirection)
	{
		this.direction = newDirection;
	}

	public char getDirection()
	{
		return (this.direction);
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
	public ArrayList<Integer> updatePlayerPosition (int XCoord, int YCoord, char direction){
		int playerXCoord = XCoord;
		int playerYCoord = YCoord;
		int playerXCoordChange = 0; 
		int playerYCoordChange = 0;
		if (direction == 'w') {
			playerYCoordChange = -1;
		}
		else if (direction == 'a') {
			playerXCoordChange = -1;
		}
		else if (direction == 's') {
			playerYCoordChange = 1;
		}
		else if (direction == 'd') {
			playerXCoordChange = 1;
		}
		int newPlayerXCoord = playerXCoord + playerXCoordChange;
		int newPlayerYCoord = playerYCoord + playerYCoordChange;
		ArrayList<Integer> playerCoordArrayList = new ArrayList<Integer>();
		playerCoordArrayList.add(newPlayerXCoord);
		playerCoordArrayList.add(newPlayerYCoord);
		return playerCoordArrayList;
		
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
