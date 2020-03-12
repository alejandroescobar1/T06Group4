package application;

public class Excutable {
	static Player p1;

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		maze1.GenerateWalls();
		boolean win = false;
	
		Player p1 = new Player(maze1);
		p1.setPlayerName();
		Mummies m1 = new Mummies(maze1, p1);
		// Make all items
		Items itemsInstance = new Items();
		itemsInstance.setJewelCoord();
		itemsInstance.setStaffCoord();
		itemsInstance.setRingCoord();
		for (int gemNum = 0; gemNum < 10; gemNum++) {
			itemsInstance.setGemCoord();
		}
		// make a variable called num gem that gets the return of a function in item class for the num of gems
		// do this for all other score indicators (num killed, num mummies, num powerups)
		int numGem = 0;
		int numMummy = 0;
		int numKilled = 0;
		int numPosItem = 0;
		int numNegItem = 0;
		// Start Timer
		Time timer = new Time();
		timer.start();
		while (p1.checkWin() != true) {
			//Print player and mummy location
			p1.printLocation();
			m1.printLocation();
			//print maze
			Maze.PrintMaze(maze1.CoordinateList);
			// Prompt for direction
			p1.getDirection();
			m1.getDirection();
			if (m1.checkCollision()== true) {
				numKilled +=1;
				p1.setX(0);
				p1.setY(0);
			}
		}
		if (p1.checkWin() == true) {
			timer.stop();
			Score playerScore = new Score(numGem, numMummy, numKilled, numPosItem, numNegItem, timer.getSecondPassed());
			System.out.println("Congratulations! You win! You finished in " + timer.getSecondPassed() +" seconds with a score of " + playerScore.getScore());
			System.exit(0);
		}
	}
}