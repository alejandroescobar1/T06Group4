/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The mummy class is a subclass and it extends the abstract Character class. This class uses the 
 * 			constructor from its super class to create a mummy. This class also gives the mummy a random direction
 * 			and tests if that direction is valid. 
 */
package application;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mummies extends Character{
	//Pictures for the mummies
	private Image enemyRight;
	private Image enemyLeft;
	private Image enemyUp;
	private Image enemyDown;
	protected ImageView enemy = new ImageView(enemyRight);
	//Attributes needed to make the mummy start at a random location
	Random coordOptions = new Random();
	private int startX;
	private int startY;
	// Creates an instance of a player
	private Player playerInstance;
	Coordinate[][] ordered;
	/**Constructor. The constructor uses the super constructor to make the mummy. However, it quickly overrides the default
	 * start position by generating a valid, random location for the mummy to start at. This is done by calling the 
	 * tryStartCoord() method followed by the use of the super setters to set the new X and Y coordinates to start. If you want
	 * to start the mummy at a given location, comment out the tryStartCoord() line upto and including the super.setY(startY)
	 * line.
	 */
	public Mummies(Maze newMaze, Player playerInstance) {
		super(newMaze, Maze.width - 1, Maze.length -1);
		this.playerInstance = playerInstance;
		this.ordered = Maze.order(newMaze.CoordinateList);
	}
	
	/**
	 * This method randomly generates possible coordinates for the mummy start point. It then checks if that randomly
	 * generated position is the start of end position of the maze. If it is not either of those, and that coordinate 
	 * has a status of 'e' (meaning empty), then it will both set that location at the start coordinates and set the 
	 * status of the coordinate to 'm'. This is important as the Item class uses these statuses to determine where it 
	 * can generate items in, and it is also an important functionality for the player when it is checking what it has
	 * collected.
	 */
	public void tryStartCoord() {
		Coordinate[][] ordered = Maze.order(this.maze.CoordinateList);
		boolean valuesGood = false;
		while (valuesGood == false){
			int startYTest = coordOptions.nextInt(Maze.length);
			int startXTest = coordOptions.nextInt(Maze.width);
			boolean startPoint = false;
			if (startYTest == 0 && startXTest == 0) {
				startPoint = true;
			}
			boolean endPoint = false;
			if (startYTest == Maze.length-1 && startXTest == Maze.width-1) {
				endPoint = true;
			}
			boolean halfway = false;
			if (startYTest >= (Maze.length-1)/2 && startXTest >= (Maze.width-1)/2) {
				halfway = true;
			}
			if (ordered[startXTest][startYTest].getStatus() == 'e'&& startPoint == false && endPoint == false && halfway == true) {
				this.startX = startXTest;
				this.startY = startYTest;
				ordered[startXTest][startYTest].setStatus('m');
				valuesGood = true;
			}
		}
	}
	
	public boolean findPath(int direction,int mummyX,int mummyY,int playerX,int playerY){
		final int originalX = playerX;
		final int originalY = playerY;
		if (direction == 0){
		if (mummyY+1 < Maze.length) {
			if(ordered[(int) mummyY][(int) mummyX].getDown() == false && ordered[(int) mummyY+1][(int) mummyX].visited == false) {
				ordered[(int) mummyY+1][((int) mummyX)].visited = true; 
				if (mummyY + 1 == playerY && mummyX == playerX){
					return true;
				}
				else if(mummyY + 1 == originalY && mummyX == originalX){
					for(Coordinate[] x:ordered){
						for(Coordinate y:x){
							y.visited = false;
						}
					}
					return false;
				}
				else {
					ordered[(int)mummyY+1][(int)mummyX].setStatus('V');
					if (findPath(0,mummyX,mummyY+1,playerX,playerY) == true){return true;}
					else if (findPath(2,mummyX,mummyY+1,playerX,playerY) == true){return true;}
					else if (findPath(3,mummyX,mummyY+1,playerX,playerY) == true){return true;}
					else{
						for(Coordinate[] x:ordered){
							for(Coordinate y:x){
								y.visited = false;
							}
						}
						return false;
					}
				}
			}
			else{
				
				return false;}
		}
		else{
			
			return false;}
		}
		else if (direction == 1){
		if (mummyY - 1 >= 0) {
			if(ordered[(int) mummyY][(int) mummyX].getUp() == false && ordered[(int) mummyY-1][(int) mummyX].visited == false) {
				ordered[((int) mummyY)-1][(int) mummyX].visited = true;
				if (mummyY -1 == playerY && mummyX == playerX){
					return true;
				}
				else if(mummyY - 1 == originalY && mummyX == originalX){
					for(Coordinate[] x:ordered){
						for(Coordinate y:x){
							y.visited = false;
						}
					}
					return false;
				}
				else {
					ordered[(int)mummyY-1][(int)mummyX].setStatus('V');
					if (findPath(1,mummyX,mummyY-1,playerX,playerY) == true){return true;}
					else if (findPath(2,mummyX,mummyY-1,playerX,playerY) == true){return true;}
					else if (findPath(3,mummyX,mummyY-1,playerX,playerY) == true){return true;}
					else{
						for(Coordinate[] x:ordered){
							for(Coordinate y:x){
								y.visited = false;
							}
						}
						return false;
					}
				}
				}
				else {
					
					return false;
				}
			}
		 else{
			
			 return false;}
		}
		
		else if (direction == 2){
		if (mummyX + 1 < Maze.length){
			if(ordered[(int) mummyY][(int) mummyX].getRight() == false && ordered[(int) mummyY][(int) mummyX+1].visited == false) {
				ordered[((int) mummyY)][(int) mummyX+1].visited = true;
				if (mummyY == playerY && mummyX + 1== playerX){
					return true;
				}
				else if(mummyY == originalY && mummyX +1 == originalX){
					for(Coordinate[] x:ordered){
						for(Coordinate y:x){
							y.visited = false;
						}
					}
					return false;
				}
				else {
					ordered[(int)mummyY][(int)mummyX+1].setStatus('V');
					if (findPath(0,mummyX+1,mummyY,playerX,playerY) == true){return true;}
					else if (findPath(1,mummyX+1,mummyY,playerX,playerY) == true){return true;}
					else if (findPath(2,mummyX+1,mummyY,playerX,playerY) == true){return true;}
					else{
						for(Coordinate[] x:ordered){
							for(Coordinate y:x){
								y.visited = false;
							}
						}
						return false;}
				}
			}
			
			else{
				
				return false;}

		} else {
			
			return false;}
		}
		else if (direction == 3){
		if (mummyX - 1 >= 0){
			if(ordered[(int) mummyY][(int) mummyX].getLeft() == false && ordered[(int) mummyY][(int) mummyX-1].visited == false) {
				ordered[(int) mummyY][(int) mummyX-1].visited = true;
				if (mummyY == playerY && mummyX - 1== playerX){
					return true;
				}
				else if(mummyY  == originalY && mummyX -1 == originalX){
					for(Coordinate[] x:ordered){
						for(Coordinate y:x){
							y.visited = false;
						}
					}
					return false;
				}
				else {
					
					ordered[(int)mummyY][(int)mummyX-1].setStatus('V');
					if (findPath(0,mummyX-1,mummyY,playerX,playerY) == true){return true;}
					else if (findPath(1,mummyX-1,mummyY,playerX,playerY) == true){return true;}
					else if (findPath(3,mummyX-1,mummyY,playerX,playerY) == true){return true;}
					else{
						for(Coordinate[] x:ordered){
							for(Coordinate y:x){
								y.visited = false;
							}
						}	
						return false;}
				}
			}else {
				
				return false;}
		}
		else {
			
			return false;}
	}
		else return false;
}
	
	/** 
	 * This method assigns the appropriate images to the mummy according to the character the user chose
	 * in the beginning. Since there are only two unique characters made thus far, if the character picks
	 * any character other than character 1, they will get the same enemy and the same avatar. 
	 */
	public void characterSelected(int characterselected){
		if (characterselected == 1){
			enemyRight = new Image("/images/creeperR.png");
			enemyLeft = new Image("/images/creeperL.png");
			enemyUp = new Image("/images/creeperU.png");
			enemyDown = new Image("/images/creeperD.png");
			
		}
		else if (characterselected == 2){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 3){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 4){
			enemyRight = new Image("/images/mummyRIGHT.png");
			enemyLeft = new Image("/images/mummyLEFT.png");
			enemyUp = new Image("/images/mummyUP.png");
			enemyDown = new Image("/images/mummyDOWN.png");
		}
		else if (characterselected == 5){
			enemyRight = new Image("/images/guardianR.png");
			enemyLeft = new Image("/images/guardianL.png");
			enemyUp = new Image("/images/guardianU.png");
			enemyDown = new Image("/images/guardianD.png");
		}
	}

	/**
	 * This method checks of the player and mummy have collided and will update the player lives accordingly. 
	 * It will also move the player to the beginning position as well as print a statement explaining what 
	 * happened to the player into the counsel. 
	 */
	public boolean checkCollision(boolean staffCollected) {
		if (staffCollected == false) {
			if (playerInstance.getX() == this.getX() && playerInstance.getY() == this.getY()) {
				playerInstance.updateLives(-1);
				System.out.println("Hit by Mummy. Player returned to start. Number of lives is " + playerInstance.getLives());
				playerInstance.setX(0);
				playerInstance.setY(0);
				playerInstance.playerImg.setImage(playerInstance.playerR);
				playerInstance.playerImg.relocate(0,0);
				this.setY(0);
				this.setX(Maze.length-1);
				enemy.setImage(enemyRight);
				enemy.relocate(this.getX() * this.enemy.getFitHeight(), this.getY() * this.enemy.getFitHeight());
				return true;
			}
			else {return false;}
		}
		else if (staffCollected == true) {
			if (playerInstance.getX() == this.getX() && playerInstance.getY() == this.getY()) {
				this.setY(0);
				this.setX(Maze.length-1);
				System.out.println("Killed the Mummy. Mummy has been moved to (" + this.getX() + "," + this.getY() + ")");
				this.playerInstance.updateMummyKilled();
				enemy.setImage(enemyRight);
				enemy.relocate(this.getX() * this.enemy.getFitHeight(),this.getY() * this.enemy.getFitHeight());
				return true;
			}
			else {return false;}
		}
		else {return false;}
	}
	
	/**
	 * Print the location
	 */
	public void printLocation(){
		System.out.println("Mummy 1 is at "+ super.Location());
	}
	
	/* 
	 * Moves the mummy GUI location in the direction listed in the method name. It is called in MazeGUI 
	 * when it is given a random direction. 
	 */
	public void goDown() {
		if (this.getY()+1 < Maze.length) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(0) == false) {
				enemy.setImage(enemyDown);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() + enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()+1);
			}
		}
	}
	
	public void goUp() {
		if (this.getY() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(2) == false) {
				enemy.setImage(enemyUp);
				enemy.relocate(enemy.getLayoutX(), enemy.getLayoutY() - enemy.getBoundsInLocal().getHeight());
				this.setY(this.getY()-1);
			}
		}
	}
	
	public void goLeft() {
		if (this.getX() - 1 >= 0) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(3) == false) {
				enemy.setImage(enemyLeft);
				this.setX(this.getX()-1);
				enemy.relocate(enemy.getLayoutX() - enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
	
			}
		}
	}
	
	public void goRight() {
		if (this.getX() + 1 < Maze.width) {
			Coordinate[][] ordered = Maze.order(maze.CoordinateList);
			if(ordered[(int) this.getY()][(int) this.getX()].checkWall(1) == false) {
				enemy.setImage(enemyRight);
				enemy.relocate(enemy.getLayoutX()+ enemy.getBoundsInLocal().getWidth(), enemy.getLayoutY());
				this.setX(this.getX()+1);
			}
		}
	}
	
	@Override
	public void setMaze(Maze aMaze) {
		this.maze = aMaze;
		tryStartCoord();
		super.setX(startX);
		super.setY(startY);
		this.ordered = Maze.order(aMaze.CoordinateList);
	}
}
