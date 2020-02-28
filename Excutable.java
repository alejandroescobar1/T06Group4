public class Excutable {
	static Player p1 = new Player();

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		Boolean win = false;
	
		Player p1 = new Player();
		p1.setPlayerName();
		
		
		Time timer = new Time();
		timer.start();
		//print maze
		
		while (p1.checkWin() != true) {
			//Print player location
			p1.printLocation();
			
			maze1.PrintMaze(6,6);
			// Prompt for direction
			p1.getDirection();
			
		}
		
		if (p1.checkWin() == true) {
			timer.stop();
			Score playerScore = new Score(0,0, timer.getSecondPassed());
			System.out.println("Sucess! You finish in " + timer.getSecondPassed() +" with the score " + playerScore.getScore());
		}
		
		
		
	}

}
