/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The Score class is used to calculate the final score of the player in the case that they complete the maze. This score is calculated 
 * on the basis of time taken to complete the cave, positive and negative items collected, number of times the player was killed by a mummy, and 
 * how many times the player killed the mummy with the staff. 
 * 
 *  This class is not yet implemented. This is because the item class is not yet used and it dictated most of the score components. It will be 
 *  integrated for the Interactive Demo. 
 */
package application;


public class Score {
	private static int numGem =  0;
	private static int numMummy = 0;
	private static int numKilled = 0;
	private static int numPosItem = 0;
	private static int numNegItem = 0;
	private static int secondPassed = 0;
	
	
	/**
	 * Score calculations per item type. The descriptions are beside every score breakdown. 
	 */
	private static int gemScore() {
		return numGem * 100; //100 points for each gem
	}
	private static int mummyScore() {
		return numMummy * 300; //300 points for each mummy killed
	}
	private static int livesScore() {
		return numKilled * 300; //300 points for each live
	}
	private static int posItemScore() {
		return numPosItem * 300; //300 points for each time killed by mummy
	}
	private static int negItemScore() {
		return numNegItem * -300; //-300 points for each time killed by mummy
	}
	
	/**
	 * Converts the time taken to complete the maze to a score. This is done by dividing the score into three 
	 * categories (<30, 30<=t<60, and >60 seconds) and giving a score based on which category the player falls
	 * in.
	 */
	private static int timeScore() {
		int timeScore;
		if (secondPassed < 15) timeScore = 1000; //finish under 15 second then get 1000 points
		else if (secondPassed < 30) timeScore = 750; // finish under 30 second then get 750 points
		else if (secondPassed < 45) timeScore = 500;
		else timeScore = 250; //else get 250 points for finish
		return timeScore;
	}
	
	/**
	 * Determines the final score. It takes the appropriate tallies in the constructor which is used to calculate the
	 * score for each category and then adds them all together for the overall score. 
	 */
	public static int getScore(Player p1) {
		Score.numGem = p1.getGemItem();
		Score.numMummy = p1.getNumMummyKilled();
		Score.numKilled = p1.getLives();
		Score.numPosItem = p1.getPosItem();
		Score.numNegItem = p1.getNegItem();
		Score.secondPassed = p1.getTimeFinished();
		return gemScore() + mummyScore() + livesScore() + posItemScore() + negItemScore() + timeScore();
	}
}
