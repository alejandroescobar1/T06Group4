/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The player class is a subclass and it extends the abstract Character class. This class uses the 
 * 			constructor from its super class to create a player starting at point 0,0. This class also determines
 * 			if the desired movement by the user is valid.  
 */
package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player extends Character{
	private int lives = 3;
	protected Image playerR;
	private Image playerL;
	private Image playerD;
	private Image playerU;
	protected ImageView playerImg = new ImageView(playerR);
	private int negItem = 0;
	private int posItem = 0;
	private int gemItem = 0;
	private boolean staffCollected = false;
	private int staffCollectionStart;

	/**
	 * Constructor
	 * @param newMaze 
	 */
	public Player(Maze newMaze) {
		super(newMaze, 0, 0);
	}
	
	/*
	 * Setter and getter for the number of lives the player has. The player always starts with 3 lives. 
	 * Being hit by a mummy and some items can change this value.
	 */
	public void setLives(int newLives)
	{
		this.lives = newLives;
	}
	public int getLives()
	{
		return (this.lives);
	}

	/**
	 * This method add an integer by param to update the player lives.
	 * @param livesChange: the amount of life added or lost
	 * @return the new number of lives after the positive or negative change
	 */
	public int updateLives(int livesChange)
	{
		return (this.lives = lives + livesChange);
	}
	
	/**
	 * This method checks if the player lost which happens when they have lost all of their lives. It returns a boolean
	 * that is used to determine if the player has indeed lost.  
	 */
	public boolean checkLoss(){
		boolean loss = false;
		if(this.lives<=0){
			loss = true;
		}
		return loss;
	}
	
	/**
	 * This method checks if the player won which happens when they have reached the end of the maze. It returns a boolean
	 * that is used to determine if the player has indeed won.  
	 */
	public boolean checkWin() {
		boolean win = false;
		
		if (this.getX() == (Maze.width -1) && this.getY() == (Maze.length -1)) {
			win = true;
		}
		return win;
	}
	
	////////////////////////////////ITEMS////////////////////////////////////////
	/**
	 * @implNote The below methods encapsulate in the "ITEMS" and "END ITEMS" comments are not implemented in this
	 * version of the code. These methods will be used to implement items as they are implemented in the text-based game.
	 * Namely, some items have a positive effect and add to the score in addition to adding a potential powerup (refer to 
	 * Items class for more information), and other items have negative effects. 
	 */
	
	/*
	 * The update methods increment a tally of how  many positive or negative items in addition to gem count the 
	 * player has collected. 
	 */
	public void updateNegItem() {
		this.negItem += 1;
	}
	public void updatePosItem() {
		this.posItem += 1;
	}
	public void updateGemItem() {
		this.gemItem += 1;
	}
	
	/*
	 * These are getter functions for the positive, negative, and gem item tallies that will be used by the score
	 * class to determine what the final score is. No setters are required as these values start at zero, as per their 
	 * instantiation, and increment only when the player collects them.
	 */
	public int getNegItem() {
		return this.negItem;
	}
	public int getPosItem() {
		return this.posItem;
	}
	public int getGemItem() {
		return this.gemItem;
	}
	
	/**
	 * This method takes care of the effects of ever item. It takes a character parameter that is the status 
	 * of the position the player has moved too. If the previous status of that coordinate was one of the four 
	 * items, it makes the appropriate effects. This may be updating the lives or the positive or negative items
	 * tally to later be used by the score class. 
	 */
	public void itemCollection(char status) {
		if (status == 'r') {
			updateLives(-1);
			System.out.println("You collected the Ring. You lost a life. Number of lives is " + getLives());
			updateNegItem();
		}
		else if (status == 'j') {
			updateLives(1);
			System.out.println("You collected the Jewel. You gained a life. Number of lives is " + getLives());
			updatePosItem();
		}
		else if (status == 's') {
			System.out.println("You collected the Staff");
			updatePosItem();
			setStaffCollected(true);
		}
		else if (status == 'g') {
			System.out.println("You collected a Gem.");
			updateGemItem();
		}
	}
	
	/*
	 * Getter and setter for the staffCollected attribute. This attribute is important because the behavior of the
	 * checkCollisions method in the Mummies class needs to be changed. This is because, if the player has the staff, 
	 * and the mummy and the player come into contact, the mummy will be killed and returned to its start spot. Otherwise,
	 * the player will lose a life and be returned to the start point.
	 */
	public boolean getStaffCollected() {
		return staffCollected;
	}
	public void setStaffCollected(boolean staffCollected) {
		this.staffCollected = staffCollected;
	}
	
	/*
	 * Getter and setter for the staffCollectionStart attribute. This is a number that will record at what time the staff was
	 * collected. This is important as it is a time-sensitive effect. That is, for only a certain time after collection, the 
	 * staff will allow the player to kill mummies. 
	 */
	public int getStaffCollectionStart() {
		return staffCollectionStart;
	}
	public void setStaffCollectionStart(int staffCollectionStart) {
		this.staffCollectionStart = staffCollectionStart;
	}
/////////////////////////////////////////////////END OF ITEMS///////////////////////////////
	
	/**
	 * This method prints the player's location to the counsel
	 */
	public void printLocation(){
		System.out.println("Player is at "+super.Location());
	}
	
	/**
	 * Moves the player avatar location in the direction listed in the method name. It is called in MazeGUI 
	 * when the user presses the appropriate key on their keyboard. 
	 */
	public void goDown() {
		if (this.getY() + 1 < Maze.length) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(0) == false) {
				playerImg.setImage(playerD);
				playerImg.relocate(playerImg.getLayoutX(), playerImg.getLayoutY() + playerImg.getBoundsInLocal().getHeight());
				this.setY(this.getY()+1);
			}
		}
	}
	
	/**
	 * Moves the player avatar location in the direction listed in the method name. It is called in MazeGUI 
	 * when the user presses the appropriate key on their keyboard. 
	 */
	public void goUp() {
		if (this.getY() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(2) == false) {
				playerImg.setImage(playerU);
				playerImg.relocate(playerImg.getLayoutX(), playerImg.getLayoutY() - playerImg.getBoundsInLocal().getHeight());
				this.setY(this.getY()-1);
			}
		}
	}
	
	/**
	 * Moves the player avatar location in the direction listed in the method name. It is called in MazeGUI 
	 * when the user presses the appropriate key on their keyboard. 
	 */
	public void goLeft() {
		if (this.getX() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(3) == false) {
				playerImg.setImage(playerL);
				this.setX(this.getX()-1);
				playerImg.relocate(playerImg.getLayoutX() - playerImg.getBoundsInLocal().getWidth(), playerImg.getLayoutY());
				checkWin();
			}
		}
	}
	
	/**
	 * Moves the player avatar location in the direction listed in the method name. It is called in MazeGUI 
	 * when the user presses the appropriate key on their keyboard. 
	 */
	public void goRight() {
		if (this.getX() + 1 < Maze.width) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(1) == false) {
				playerImg.setImage(playerR);
				playerImg.relocate(playerImg.getLayoutX()+ playerImg.getBoundsInLocal().getWidth(), playerImg.getLayoutY());
				this.setX(this.getX()+1);
			}
		}
	}

	/**
	 * This method assigns the appropriate images to the player according to the character the user chose
	 * in the beginning. Since there are only two unique characters made thus far, if the character picks
	 * any character other than character 1, they will get the same avatar. 
	 */
	public void characterSelected(int characterSelected) {
		if (characterSelected == 1) {
			playerR = new Image("/images/MSR.png");
			playerL = new Image("/images/MSL.png");
			playerU = new Image("/images/MSU.png");
			playerD = new Image("/images/MSD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 3) {
			playerR = new Image("/images/spongebobR.png");
			playerL = new Image("/images/spongebobL.png");
			playerU = new Image("/images/spongebobU.png");
			playerD = new Image("/images/spongebobD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 5) {
			playerR = new Image("/images/linkR.png");
			playerL = new Image("/images/linkL.png");
			playerU = new Image("/images/linkU.png");
			playerD = new Image("/images/linkD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 4) {
			playerR = new Image("/images/neeyanR.png");
			playerL = new Image("/images/neeyanL.png");
			playerU = new Image("/images/neeyanU.png");
			playerD = new Image("/images/neeyanD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 2) {
			playerR = new Image("/images/ugandaR.png");
			playerL = new Image("/images/ugandaL.png");
			playerU = new Image("/images/ugandaU.png");
			playerD = new Image("/images/ugandaD.png");
			playerImg = new ImageView(playerR);
		}
	}
}