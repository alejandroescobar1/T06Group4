package application;

import java.util.Timer;
import java.util.TimerTask;
//import java.util.Random;


public class MummyTimer {
	Maze newMaze = new Maze(5,5);
	private Player p1;
	Mummies mummy = new Mummies(newMaze, p1);
	
	
	Timer timer = new Timer();
	int secondPassed = 0;
	TimerTask task = new TimerTask(){
		public void run() {
			secondPassed++;
			System.out.println(secondPassed);
			
//			while ((p1.getX()!=mummy.getX()) && (p1.getY() != mummy.getY()))
//			{
//				Random mummyDirection = new Random();
//				int move = mummyDirection.nextInt(3);
//				
//				if (move == 0)
//				{
//					mummy.goDown();
//				}
//				else if (move == 1)
//				{
//					mummy.goUp();
//				}
//				else if (move==2)
//				{
//					mummy.goRight();
//				}
//				else 
//				{
//					mummy.goLeft();
//				}
//				
//
//			}
		}
		
	};
	
	public void stop()
	{
		timer.cancel();
	}

	public void start()
	{
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}
		
	
}
			
			

