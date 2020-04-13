/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
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
	private int secondPassed = 0;
	
	/**
	 * Constructors 
	 * @param p1 
	 * @param mummy
	 */
	public MummyTimer(Player p1, Mummies mummy) {
		this.setP1(p1);
		this.mummy = mummy;
		
	}
	
	/* 
	 * creates timer and sets what direction the random number means.
	 */
	Timer timer1 = new Timer();
	Timer timer2 = new Timer();
	
	TimerTask taskMummy = new TimerTask(){
		public void run() {
				Random mummyDirection = new Random();
				int move = mummyDirection.nextInt(4);
				
				try{if (mummy.findPath(0, (int)mummy.getX(), (int)mummy.getY(),(int) p1.getX(),(int) p1.getY()))
				{
					mummy.goDown();
					mummy.checkCollision(p1.getStaffCollected());
				}
				else if (mummy.findPath(1, (int)mummy.getX(), (int)mummy.getY(),(int) p1.getX(),(int) p1.getY()))
				{
					mummy.goUp();
					mummy.checkCollision(p1.getStaffCollected());
				}
				else if (mummy.findPath(2, (int)mummy.getX(), (int)mummy.getY(),(int) p1.getX(),(int) p1.getY()))
				{
					mummy.goRight();
					mummy.checkCollision(p1.getStaffCollected());
				}
				else if (mummy.findPath(3, (int)mummy.getX(), (int)mummy.getY(),(int) p1.getX(),(int) p1.getY()))
				{
					mummy.goLeft();
					mummy.checkCollision(p1.getStaffCollected());
				}}
				catch(StackOverflowError e){
					System.out.println("Oops!Something went wrong.");
				}
		}
		
	};
	
	TimerTask taskGameTime = new TimerTask() {
    	public void run() {
    		secondPassed++;
    	}
    };
	
	/**
	 * Stop the timer.
	 */
	public void stop()
	{
		timer1.cancel();
		timer2.cancel();
	}
	
	/**
	 * Stop the timer.
	 */
	public void start()
	{
		timer1.scheduleAtFixedRate(taskMummy, 0, 500);
		timer2.scheduleAtFixedRate(taskGameTime, 0, 1000);
	}
	
	/**
	 * Getter for player instance p1" 
	 */
	public Player getP1() {
		return p1;
	}

	/**
	 * Setter for player instance p1" 
	 */
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	
	/**
     * Getter that can tell how many seconds have elapsed since the timer started. 
     */
    public int getSecondPassed() {
		return this.secondPassed;
	}
}
	