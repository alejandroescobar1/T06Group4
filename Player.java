package application;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player extends Character{
	private int lives = 3;
	private String playerName= "Dave";
	private Image playerR;
	private Image playerL;
	private Image playerD;
	private Image playerU;
	protected ImageView playerImg = new ImageView(playerR);

	
	public Player(Maze newMaze) {
		super(newMaze,0,0);
	}
	
	
	
	public void setLives(int newLives)
	{
		this.lives = newLives;
	}

	public int getLives()
	{
		return (this.lives);
	}

	//@param the amount of life added or lose
	public int updateLives(int livesChange)
	{
		return (this.lives = lives + livesChange);
	}

	//////////////////////////////////////////////////////////////////////
	// This code allows the user to name the avatar's name. The default name is Dave
	public void setPlayerName()
	{
		String inputName1 = null;
		System.out.print("Enter user name: ");
		Scanner scan = new Scanner(System.in);
		inputName1 = scan.nextLine();
		if (inputName1 != null)
		{
			if(inputName1.isEmpty() == false) 
			this.playerName = inputName1;
		}
	}

	public String getPlayerName()
	{
		return (this.playerName);
	}
	//will call this method if lives<0
	public void dead()
	{

		System.out.println("Game Over!");
//		String action = getAction();
//		action = "EXIT";
//		return action;
	}
///////////////////////////////UPDATE COORDINATE////////////////////////
	
	public void updatePosition (String direction){
		Coordinate[][] ordered = this.maze.order(this.maze.CoordinateList);
		int currentPlayerXCoord = (int)this.getX();
		int currentPlayerYCoord = (int)this.getY();
		int newPlayerXCoord = currentPlayerXCoord;
		int newPlayerYCoord = currentPlayerYCoord;
		boolean invalid=false;
		
		if (direction.equals("w")) {
			newPlayerYCoord = currentPlayerYCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(2) == false && newPlayerYCoord < Maze.length && newPlayerYCoord >= 0) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("a")) {
			newPlayerXCoord = currentPlayerXCoord - 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(3) == false && newPlayerXCoord < Maze.width && newPlayerXCoord >= 0) {
				this.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("s")) {
			newPlayerYCoord = currentPlayerYCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(0) == false && newPlayerYCoord < Maze.length && newPlayerYCoord >= 0) {
				this.setY(newPlayerYCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		else if (direction.equals("d")) {
			newPlayerXCoord = currentPlayerXCoord + 1;
			if (ordered[currentPlayerYCoord][currentPlayerXCoord].checkWall(1) == false && newPlayerXCoord < Maze.width && newPlayerXCoord >= 0) { 
				this.setX(newPlayerXCoord);
			}
			else {
				System.out.println("Invalid Move. Please enter again. "); 
				invalid = true;
				}
		}
		if (invalid == false) {
			ordered[currentPlayerYCoord][currentPlayerXCoord].setStatus('e'); 
			ordered[newPlayerYCoord][newPlayerXCoord].setStatus('p');
		}
		else {
			ordered[currentPlayerYCoord][currentPlayerXCoord].setStatus('p');
		}
		if (newPlayerYCoord < 0 || newPlayerYCoord >= Maze.length) {
			this.setY(currentPlayerYCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		if (newPlayerXCoord < 0 || newPlayerXCoord >= Maze.width) {
			this.setX(currentPlayerXCoord);
			System.out.println("Invalid Move. Please enter again. ");
		}
		
	}
	public boolean checkLoss(){
		boolean loss = false;
		if(this.lives<=0){
			loss = true;
		}
		return loss;
	}
	public boolean checkWin() {
		boolean win = false;
		
		if (this.getX() == (Maze.width -1) && this.getY() == (Maze.length -1)) {
			win = true;
		}
		
		return win;
	}
	public void checkCollection(int itemX, int itemY) {
		boolean collection = false;
		if(this.getX() == itemX && this.getY() == itemY) {
			collection = true;
		}
	}
	public void printLocation(){
		System.out.println("Player is at "+super.Location());
	}
	
	
	
	public void goDown() {
		if (this.getY() + 1 < maze.length) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(0) == false) {
				playerImg.setImage(playerD);
				playerImg.relocate(playerImg.getLayoutX(), playerImg.getLayoutY() + playerImg.getBoundsInLocal().getHeight());
				this.setY(this.getY()+1);
			}
		}
	}
	
	public void goUp() {
		if (this.getY() - 1 >= 0) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(2) == false) {
				playerImg.setImage(playerU);
				playerImg.relocate(playerImg.getLayoutX(), playerImg.getLayoutY() - playerImg.getBoundsInLocal().getHeight());
				this.setY(this.getY()-1);
			}
		}
	}
	
	public void goLeft() {
		if (this.getX() - 1 >= 0) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(3) == false) {
				playerImg.setImage(playerL);
				this.setX(this.getX()-1);
				playerImg.relocate(playerImg.getLayoutX() - playerImg.getBoundsInLocal().getWidth(), playerImg.getLayoutY());
				checkWin();
			}
		}
	}
	
	public void goRight() {
		if (this.getX() + 1 < maze.width) {
			Coordinate[][] ordered = maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(1) == false) {
				playerImg.setImage(playerR);
				playerImg.relocate(playerImg.getLayoutX()+ playerImg.getBoundsInLocal().getWidth(), playerImg.getLayoutY());
				this.setX(this.getX()+1);
			}
		}
	}
	
	public void getDirection(){
		String directionInput = null;
		Boolean valid = false;
		System.out.print("Please enter direction (a = left, w = up, d = right, s = down): ");
		Scanner scan = new Scanner(System.in);
		directionInput = scan.nextLine();

		while (valid == false) {
			if (directionInput.equals("a") || directionInput.equals("s") || directionInput.equals("w") || directionInput.equals("d")) {
				this.updatePosition(directionInput);
				valid = true;
				//this.printLocation();
			}
		}
	}
	
	public void characterSelected(int characterSelected) {
		if (characterSelected == 1) {
			playerR = new Image("ugandaR.png");
			playerL = new Image("ugandaL.png");
			playerU = new Image("ugandaU.png");
			playerD = new Image("ugandaD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 2) {
			playerR = new Image("ugandaR.png");
			playerL = new Image("ugandaL.png");
			playerU = new Image("ugandaU.png");
			playerD = new Image("ugandaD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 3) {
			playerR = new Image("ugandaR.png");
			playerL = new Image("ugandaL.png");
			playerU = new Image("ugandaU.png");
			playerD = new Image("ugandaD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 4) {
			playerR = new Image("ugandaR.png");
			playerL = new Image("ugandaL.png");
			playerU = new Image("ugandaU.png");
			playerD = new Image("ugandaD.png");
			playerImg = new ImageView(playerR);
		}
		
		else if (characterSelected == 1) {
			playerR = new Image("ugandaR.png");
			playerL = new Image("ugandaL.png");
			playerU = new Image("ugandaU.png");
			playerD = new Image("ugandaD.png");
			playerImg = new ImageView(playerR);
		}
	}
}