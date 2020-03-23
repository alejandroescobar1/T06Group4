/**
 * @author T06 Group 4
 * @version Demo 2 Text-based game
 * @see Demo 2 GUI-based game. Directions are found in the README.md file
 * 
 * @implNote This class is the class the user should run to play the text-based game. This version still requires the completion
 * of the effects of the items and thus has the code that generates the items commented out. If you would like to see
 * the player collecting the items, please uncomment the "Make all items" code below. 
 * 
 */

public class Excutable {
	static Player p1;
/* 
 * The first part of the main function instantiates the maze of fixed dimensions, although the actual layout
 * is randomized and will produce a new maze every time this code is run. 
 */
	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); 
		maze1.GenerateWalls();
/*
 * Here, the player and mummy are being instantiated. The items are also instantiated in this block of code, but are 
 * currently commented out for the aforementioned reasons. 
 */
		Player p1 = new Player(maze1);
		p1.setPlayerName();
		Mummies m1 = new Mummies(maze1, p1);
		// Make all items
		Items itemsAll = new Items(maze1, p1);
		itemsAll.setJewelCoord();
		itemsAll.setRingCoord();
		itemsAll.setStaffCoord();
		for (int numOfGems = 0; numOfGems <= (Maze.length*Maze.length)/2; numOfGems++) {
			itemsAll.setGemCoord();
		}
		
/* 
 * Here, the score modifiers are instantiated but will only have an effect after the effects of the items have been 
 * implemented.
 */
		int numMummy = 0;
		int numKilled = 0;
		// Start Timer
		Time timer = new Time();
		timer.start();
/*
 * This is the code that actually runs the game. Here, until the player wins, the user is as
 */
		while (p1.checkWin() != true) {
			// Print player and mummy location
			p1.printLocation();
			m1.printLocation();
			// Print maze
			Maze.PrintMaze(maze1.CoordinateList);
			// Prompt for direction so that the player and mummy can move. Check if there was a collision after every turn.
			p1.getDirection();
			m1.getDirection();
			if(p1.getX() == m1.getX() && p1.getY() == m1.getY()) {
				if (p1.hasStaff().secondPassed <= 5) {
					System.out.println("You killed a mummy!");
					numMummy +=1;
					m1.setX(Maze.width-1);
					m1.setY(Maze.length-1);
				}
				else {
					p1.updateLives(-1);
					System.out.println("Hit by Mummy. Player returned to start. Number of lives is " + p1.getLives());
					numKilled +=1;
					p1.setX(0);
					p1.setY(0);
				}
			}
		}
/*
 * Here we define what happens when the player wins. We print out a message with their score and exit the game. 
 */
		if (p1.checkWin() == true) {
			timer.stop();
			Score playerScore = new Score(p1.getGemItem(), numMummy, numKilled, p1.getPosItem(), p1.getNegItem(), timer.getSecondPassed());
			System.out.println("Congratulations! You win! You finished in " + timer.getSecondPassed() +" seconds with a score of " + playerScore.getScore());
			System.exit(0);
		}
	}
}