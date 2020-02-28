public class Excutable {
	static Player p1 = new Player();

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		boolean win = false;
	
		Player p1 = new Player();
		p1.setPlayerName();
		// Start Timer
		Time timer = new Time();
		timer.start();
		while (p1.checkWin() != true) {
			//Print player location
			p1.printLocation();
			//print maze
			maze1.PrintMaze(6,6);
			// Prompt for direction
			p1.getDirection();
		}
		if (p1.checkWin() == true) {
			timer.stop();
			Score playerScore = new Score(0,0, timer.getSecondPassed());
			System.out.println("Congratulations! You win! You finished in " + timer.getSecondPassed() +" seconds with a score of " + playerScore.getScore());
			System.exit(0);
		}
	}
}