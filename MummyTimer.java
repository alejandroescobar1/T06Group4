package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
//import java.util.Random;


public class MummyTimer {
	private Player p1;
	private Mummies mummy;
	
	public MummyTimer(Player p1, Mummies mummy) {
		this.p1 = p1;
		this.mummy = mummy;
	}
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run() {
				Random mummyDirection = new Random();
				int move = mummyDirection.nextInt(4);
				
				if (move == 0)
				{
					mummy.goDown();
				}
				else if (move == 1)
				{
					mummy.goUp();
				}
				else if (move==2)
				{
					mummy.goRight();
				}
				else if (move == 3)
				{
					mummy.goLeft();
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
			
			