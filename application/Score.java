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
	private int numGem =  0;
	private int numMummy = 0;
	private int numKilled = 0;
	private int numPosItem = 0;
	private int numNegItem = 0;
	private int secondPassed = 0;
	
	/**
	 * Constructor
	 * @param numGem
	 * @param numMummy
	 * @param numKilled
	 * @param numPosItem
	 * @param numNegItem
	 * @param secondPassed
	 */
	public Score(int numGem, int numMummy, int numKilled, int numPosItem, int numNegItem, int secondPassed) {
		this.numGem = numGem;
		this.numMummy = numMummy;
		this.numKilled = numKilled;
		this.numPosItem = numPosItem;
		this.numNegItem = numNegItem;
		this.secondPassed = secondPassed;
	}
	
	/**
	 * Score calculations per item type. The descriptions are beside every score breakdown. 
	 */
	private int gemScore() {
		return numGem * 100; //100 points for each gem
	}
	private int mummyScore() {
		return numMummy * 300; //300 points for each mummy killed
	}
	private int killedScore() {
		return numKilled * -300; //-300 points for each time killed by mummy
	}
	private int posItemScore() {
		return numPosItem * 300; //300 points for each time killed by mummy
	}
	private int negItemScore() {
		return numNegItem * -300; //-300 points for each time killed by mummy
	}
	
	/**
	 * Converts the time taken to complete the maze to a score. This is done by dividing the score into three 
	 * categories (<30, 30<=t<60, and >60 seconds) and giving a score based on which category the player falls
	 * in.
	 */
	private int timeScore() {
		int timeScore;
		if (secondPassed < 30) timeScore = 1000; //finish under 30 second then get 1000 points
		else if (secondPassed < 60) timeScore = 500; // finish under 60 second then get 500 points
		else timeScore = 250; //else get 250 points for finish
		return timeScore;
	}
	
	/**
	 * Determines the final score. It takes the appropriate tallies in the constructor which is used to calculate the
	 * score for each category and then adds them all together for the overall score. 
	 */
	public int getScore() {
		return gemScore() + mummyScore() + killedScore() + posItemScore() + negItemScore() + timeScore();
	}
}
