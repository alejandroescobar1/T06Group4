/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote The Character class is an abstract parent class to Mummies and Player. All shared functions and variables are
 * 			created here but some methods are left abstract as their implementation differs between the mummy and the player class.
 */
package application;
public abstract class Character{
	
    protected Maze maze;
    private double X;
    private double Y;
    //public abstract void updatePosition(String direction);
    public abstract void goLeft();
    public abstract void goRight();
    public abstract void goUp();
    public abstract void goDown();
    
    /** 
     * Constructor 
     */
    public Character(Maze aMaze,double aY, double aX){
        this.maze = aMaze; 
        this.X = aX;
        this.Y = aY;
    }
    
    /* 
     * Setter and getters
     */
    public void setMaze(Maze aMaze){
        this.maze = aMaze;
    }
    public double getX() {
		return this.X;
	}

	public double getY() {
		return this.Y;
	}
	public void setX(double newX) {
		this.X = newX;
	}
	
	public void setY(double newY) {
		this.Y = newY;
	}
	
	/**
	 * Returns the player's location in String form 
	 */
    public String Location(){
        return "("+(int)this.getX()+","+(int)this.getY()+")";
    }
}