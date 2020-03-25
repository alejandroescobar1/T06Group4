package application;
public abstract class Character{
    protected Maze maze;
    private double X;
    private double Y;
    public abstract void updatePosition(String direction);
    public abstract void goLeft();
    public abstract void goRight();
    public abstract void goUp();
    public abstract void goDown();
    public Character(Maze aMaze,double aY, double aX){
        this.maze = aMaze; 
        this.X = aX;
        this.Y = aY;
    }
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
    public String Location(){
        return "("+(int)this.getX()+","+(int)this.getY()+")";
    }
}