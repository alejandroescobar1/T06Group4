

public class Excutable {
	static Player p1 = new Player();

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		Boolean win = false;
	
		Player p1 = new Player();
		p1.setPlayerName();
		
		
		
		//print maze
		
		while (win != true) {
			//Print player location
			p1.printLocation();
			
			maze1.PrintMaze(6,6);
			// Prompt for direction
			p1.getDirection();
			
		}
		
		
		
	}

}