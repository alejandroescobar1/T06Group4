package application;

public class Score {
	private int numGem =  0;
	private int numMummy = 0;
	private int numKilled = 0;
	private int numPosItem = 0;
	private int numNegItem = 0;
	private int secondPassed = 0;
	
	public Score(int numGem, int numMummy, int numKilled, int numPosItem, int numNegItem, int secondPassed) {
		this.numGem = numGem;
		this.numMummy = numMummy;
		this.numKilled = numKilled;
		this.numPosItem = numPosItem;
		this.numNegItem = numNegItem;
		this.secondPassed = secondPassed;
	}
	
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
		return numPosItem * 300; //-300 points for each time killed by mummy
	}
	private int negItemScore() {
		return numNegItem * -300; //-300 points for each time killed by mummy
	}
	
	private int timeScore() {
		int timeScore;
		if (secondPassed < 30) timeScore = 1000; //finish under 30 second then get 1000 points
		else if (secondPassed < 60) timeScore = 500; // finish under 60 second then get 500 points
		else timeScore = 250; //else get 250 points for finish
		return timeScore;
	}
	
	public int getScore() {
		return gemScore() + mummyScore() + killedScore() + posItemScore() + negItemScore() + timeScore();
	}
}