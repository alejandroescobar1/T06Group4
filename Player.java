import java.util.ArrayList;

public class Player {
	// The lives the player has. This will be edited in the enemies class
	int lives = 3;
	//////////////////////////////////////////////////////////////////////
	// The objectEquiped variable defines what object the player has. This will be changed 
	// in the Items class such that no item sets the value to 0, a gem to 1, the scarab jewel to 2,
	// the jackal ring to 3 and the staff to 4. The amulet sets it to value associated with the 
	// item it randomly changes to. 
	int objectEquiped = 0;
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
	