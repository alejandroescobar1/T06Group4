

public class Excutable {

	public static void main(String[] args) {
		//Maze maze1 = new Maze(); Create a maze object
		Boolean win = false;
		
		
		Player p1 = new Player();
		p1.setPlayerName();
		
		
		//print maze
		
		while (win != true) {
			//Print player location
			p1.printLocation();
			
			// Prompt for direction
			p1.getDirection();
		}
		
		if (win == true) {
			
		}
	}

}
