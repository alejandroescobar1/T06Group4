/**
 * @author T06 Group 4
 * @version Final Demo GUI based game
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
	 * Constructor,  it uses  @param p1 and @param mummy to initialize mummy and player instance
	 */
	public MummyTimer(Player p1, Mummies mummy) {
		this.setP1(p1);
		this.mummy = mummy;
		
	}
	
	/** 
	 * creates timers and sets what direction the random number means.
	 */
	Timer timer1 = new Timer();
	Timer timer2 = new Timer();
	
	/**
	 * creates a timertask taskmummy, which uses the find path algorithm to moves towards player
	 */
	TimerTask taskMummy = new TimerTask(){
		public void run() {
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
				}
				else {
					//Do a random move
					Random mummyDirection = new Random();
					int move = mummyDirection.nextInt(4);
					
					if (move == 0)
					{
						mummy.goDown();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move == 1)
					{
						mummy.goUp();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move==2)
					{
						mummy.goRight();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move == 3)
					{
						mummy.goLeft();
						mummy.checkCollision(p1.getStaffCollected());
					}
				};
				}
				catch(StackOverflowError e){
					//Do a random move
					Random mummyDirection = new Random();
					int move = mummyDirection.nextInt(4);
					
					if (move == 0)
					{
						mummy.goDown();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move == 1)
					{
						mummy.goUp();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move==2)
					{
						mummy.goRight();
						mummy.checkCollision(p1.getStaffCollected());
					}
					else if (move == 3)
					{
						mummy.goLeft();
						mummy.checkCollision(p1.getStaffCollected());
					}
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
	 * Start the timer. timer 1 do taskMummy every 500 millisecond, and timer2 do taskGmae every 1000 milliseconds
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
	