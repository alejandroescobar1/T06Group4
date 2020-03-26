/**
 * @author T06 Group 4
 * @version Demo 2 GUI based game
 * @implNote This class creates a timer for the mummy that is used to determine 
 * when the mummy should try a random direction and thus move if valid.
 */
package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MummyTimer {
	private Player p1;
	private Mummies mummy;
	/*
	 * Constructors 
	 */
	public MummyTimer(Player p1, Mummies mummy) {
		this.p1 = p1;
		this.mummy = mummy;
	}
	/* 
	 * creates timer and sets what direction the random number means.
	 */
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run() {
				Random mummyDirection = new Random();
				int move = mummyDirection.nextInt(4);
				
				if (move == 0)
				{
					mummy.goDown();
					mummy.checkCollision();
				}
				else if (move == 1)
				{
					mummy.goUp();
					mummy.checkCollision();
				}
				else if (move==2)
				{
					mummy.goRight();
					mummy.checkCollision();
				}
				else if (move == 3)
				{
					mummy.goLeft();
					mummy.checkCollision();
				}
		}
		
	};
	
	public void stop()
	{
		timer.cancel();
	}

	public void start()
	{
		timer.scheduleAtFixedRate(task, 0, 500);
	}
		
	
}