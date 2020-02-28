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
    
    public void start() {
    	timer.scheduleAtFixedRate(task, 0, 1000);
    }
    
    public void stop() {
    	timer.cancel();
    }

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