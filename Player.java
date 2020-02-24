import java.util.ArrayList;

public class Player {
	// The lives the player has. This will be edited in the enemies and item class
	int lives = 3;
	int livesChange = 0;
	public int updateLives(int lives, int livesChange) {
		lives = lives + livesChange;
		livesChange = 0;
		return lives;
	}
	
	//////////////////////////////////////////////////////////////////////
	// The objectEquiped variable defines what object the player has. This will be changed 
	// in the Items class such that no item sets the value to 0, a gem to 1, the scarab jewel to 2,
	// the jackal ring to 3 and the staff to 4. The amulet sets it to value associated with the 
	// item it randomly changes to. 
	int objectEquiped = 0;
	
	// This should be in Items class
	
	if (Player.coor() == Gem.coor()) {
		objectEquiped = 1;
		// call update score function in Score class
		updateScore(objectEquiped);
		
	}
	
	// This is a draft of the updateScore function
	public int updateScore(objectEquiped) {
		int score = 0;
		if (objectEquiped == 0) {
			return null;
		}
		// in the case of a gem, there is no timer to the effect
		else if (objectEquiped == 1) {
			score = score + 100;
			objectEquiped = 0;
			return score;
		}
		// in the case of the scarab jewl and jakal ring there is no timer to the effect, 
		// but there is an additional step for the updating of lives
		else if (objectEquipped == 2) {
			livesChange = 1;
			updateLives(lives, livesChange);
			score = score + 200;
			objectEquiped = 0;
			return score;
		}
		else if (objectEquipped == 3) {
			livesChange = -1;
			updateLives(lives, livesChange);
			score = score - 200;
			objectEquiped = 0;
			return score;
		}
		else if (objectEquipped == 4) {
			
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////
	// This code allows the user to name the avatar's name. The default name is Dave
	String playerName = "Dave";
	public void setName(String name) {
		String newPlayerName = name;
		this.playerName = newPlayerName;
	}
	//////////////////////////////////////////////////////////////////////
	// This getter method gets the location of the player from the maze class
	public Location getlocationCoordinate() {
		ArrayList<Integer> playerLocation = new ArrayList();
		}
	
	/////////////////////////////////////////////////////////////////////
	// This method moves the player. The setter functions it invokes must be defined in the 
	// maze class
	String direction = "N";
	public ArrayList<Integer> move(direction){
		// Angelica will write a getter function and in this spot, she will call it.
		// this getter function actually just takes user input
		
		if (direction == "w") {
			setVerticalChange(1);
		}
		if (direction == "s") {
			setVerticalChange(-1);
		}
		if (direction == "d") {
			setHorizontalChange(1);
		}
		if (direction == "a") {
			setHorizontalChange(-1);
		}
	}
}
	