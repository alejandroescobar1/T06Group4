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
	public void setPlayerName(String inputName)
	{
		if (inputName != null)
		{
			if(inputName.isEmpty() == false)
			this.playerName = inputName;
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
	}


	public void move(int life)
	{
	//	this.direction = currentDirection;



		if (updateLives(life) == 0)
		{
			dead();
		}

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
