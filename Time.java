/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The Time class is a class that creates timer to be started at the beginning of the game and end at its conclusion. 
 * 			This is not yet implemented as the Items class is not yet implemented. The timer is used for the score class, and
 * 			is also used for determining if the staff's effects are still in play. The class also allows one to get the number 
 * 			of seconds that have been passed. 
 */
package application;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    Timer timer = new Timer();
    int secondPassed = 0;
    TimerTask task = new TimerTask() {
    	public void run() {
    		secondPassed++;
    	}
    };
    
    /*
     * Getter that can tell how many seconds have elapsed since the timer started. 
     */
    public int getSecondPassed() {
		return this.secondPassed;
	}
    /* 
     * Start and Stop functions for the timer.
     */
    public void start() {
    	timer.scheduleAtFixedRate(task, 0, 1000);
    }
    
    public void stop() {
    	timer.cancel();
    }
    /*
     * Main method runs the timer since the tier was started and will end and be reported when the game is won.
     */
    public static void main(String args[]) {
        Time test1 = new Time();
        test1.start();
        boolean win = false;
        int userInput = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Test Game: Guessing the number (Answer 5)");
        while (win != true) {
        	System.out.println("Enter a number");
        	userInput = scan.nextInt();
        	 if (userInput == 5) 
             	win = true;
        	 };
        
        if (win == true) {
        	scan.close();
        	test1.stop();
        	System.out.println("You took " +test1.secondPassed + " seconds to finish the game");
        }
       
    }


}