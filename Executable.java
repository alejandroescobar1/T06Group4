///////DO NOT USE THIS FILE//////

public class Executable {
	static Player p1 = new Player();

	public static void main(String[] args) {
		Maze maze1 = new Maze(6,6); //Create a maze object
		Boolean win = false;
		
		
		Player p1 = new Player();
		p1.setPlayerName();
		
		
		//print maze
		

		Time timer = new Time();
		timer.start();
		
		
		
		while (win != true)
		{
			//Print player location
			p1.printLocation();
			
			// Prompt for direction
			p1.getDirection();
		}
		
		if (win == true) 
		{
			timer.stop(); //the timer will stop when the player lose the game
			int secondsPassed = timer.getSecondPassed();
			Score playerScore = new Score(0, 0, secondsPassed);
			System.out.println("Success! Your score is " + playerScore.getScore());
		
			
			
		}
	}

}