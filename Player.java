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
		return lives;
	}
	
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
	
	public void setSteps(int newSteps)
	{
		this.steps = newSteps;
	}
	
	public int getSteps()
	{
		return (this.steps);
	}
	
	
	public void move(char newDirection, int newSteps)
	{
		if (direction == 'w')
		{
			
		}
		
		if (direction == 's')
		{
			
		}
		
		if (direction == 'd')
		{
			
		}
		
		if (direction == 'a')
		{
			
		}
	}
	
	
	public static void main (String[] args)//
	{
		Scanner playerInfo = new Scanner(System.in);//
		
		System.out.println("Enter the name of the player: ");//
		String inputName = playerInfo.nextLine();//
		
		
		System.out.println("Enter the player's move (Please enter either w, s, d or a) :");
		char move = playerInfo.next().charAt(0);
		
		System.out.println("Enter the amount of steps:");
		int amountOfSteps = playerInfo.nextInt();
		
	    Player player1 =  new Player();
	    player1.setPlayerName(inputName);
	    player1.setDirection(move);
	    player1.setSteps(amountOfSteps);
	    
	    
	    
	    System.out.println(player1.getPlayerName());
	
	}
	
	//////////////////////////////////////////////////////////////////////
	// The objectEquiped variable defines what object the player has. This will be changed 
	// in the Items class such that no item sets the value to 0, a gem to 1, the scarab jewel to 2,
	// the jackal ring to 3 and the staff to 4. The amulet sets it to value associated with the 
	// item it randomly changes to. 
	int objectEquiped = 0;

	// This should be in Items class

	if (Player.coor() == Gem.coor()) 
	{
		objectEquiped = 1;
		// call update score function in Score class
		updateScore(objectEquiped);
	}
		
		// This is a draft of the updateScore function
	public int updateScore(objectEquiped) 
	{
		int score = 0;
		if (objectEquiped == 0) 
		{
			return null;
		}
			// in the case of a gem, there is no timer to the effect
		else if (objectEquiped == 1)
		{
			score = score + 100;
			objectEquiped = 0;
			return score;
		}
		// in the case of the scarab jewl and jakal ring there is no timer to the effect, 
		// but there is an additional step for the updating of lives
		else if (objectEquipped == 2) 
		{
			livesChange = 1;
			updateLives(lives, livesChange);
			score = score + 200;
			objectEquiped = 0;
			return score;
		}
		else if (objectEquipped == 3) 
		{
			livesChange = -1;
			updateLives(lives, livesChange);
			score = score - 200;
			objectEquiped = 0;
			return score;
		}
		else if (objectEquipped == 4)
		{
				
		}
	}
		
	//////////////////////////////////////////////////////////////////////
	// This getter method gets the location of the player from the maze class
	public Location getlocationCoordinate()
	{
		ArrayList<Integer> playerLocation = new ArrayList();
	}

}
	

