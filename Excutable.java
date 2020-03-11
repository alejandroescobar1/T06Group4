package application;

public class Excutable {
	static Player p1 = new Player();

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		boolean win = false;
	
		Player p1 = new Player();
		p1.setPlayerName();
		Mummies m1 = new Mummies();
		// Make all items
		Items itemsInstance = new Items();
		itemsInstance.setJewelCoord();
		itemsInstance.setStaffCoord();
		itemsInstance.setRingCoord();
		for (int gemNum = 0; gemNum < 10; gemNum++) {
			itemsInstance.setGemCoord();
		}
		// Start Timer
		Time timer = new Time();
		timer.start();
		while (p1.checkWin() != true) {
			//Print player and mummy location
			p1.printLocation();
			m1.printLocation();
			//print maze
			maze1.PrintMaze(6,6);
			// Prompt for direction
			p1.getDirection();
			String numDirection = m1.randomMummyDirection();
			m1.updateMummyPosition(numDirection);
		}
		if (p1.checkWin() == true) {
			timer.stop();
			// make a variable called num gem that gets the return of a function in item class for the num of gems
			// do this for all other score indicators (num killed, num mummies, num powerups)
			int numGem = 0;
			int numMummy = 0;
			int numKilled = 0;
			int numPosItem = 0;
			int numNegItem = 0;
			Score playerScore = new Score(numGem, numMummy, numKilled, numPosItem, numNegItem, timer.getSecondPassed());
			System.out.println("Congratulations! You win! You finished in " + timer.getSecondPassed() +" seconds with a score of " + playerScore.getScore());
			System.exit(0);
		}
	}
}