/**
 * @author T06 Group 4
 * @version Demo 3 GUI based game
 * @implNote This class generates the actual maze using randomized correct path to the finish coordinate and 
 * generating walls by preventing the passing of these walls.  
 */
package application;
import java.util.*; 

public class Maze {
	 static int length;
	 static int width;
	 ArrayList<Coordinate> CoordinateList;
	 public ArrayList<ArrayList<Coordinate>> CoordinateList2D2;
	 static char[][] CoordinateList2D;


	 /*
	  * Constructor
	  */
	 public Maze(int length, int width) {
		 this.CoordinateList=new ArrayList<Coordinate> ();
		 this.CoordinateList2D2 = new ArrayList<ArrayList<Coordinate>>();
		 Maze.length=length;
		 Maze.width=width;
		 char newLetter = 65;
		 // Here, a coordinate for every possible combination of i columns and j rows is generated
		 for(int i=0;i<(length);i++) {
			 for(int j=0;j<(width);j++) {
				 Coordinate tempCoor = new Coordinate(j,i,'e',newLetter,true,true,true,true);
				 this.CoordinateList.add(tempCoor);
				 ArrayList<Coordinate> tempList = new ArrayList<Coordinate>();
				 tempList.add(tempCoor);
				 this.CoordinateList2D2.add(tempList);
				 if (newLetter > 89) {newLetter = 65;}
				 else {newLetter++;}
			 }}
			}
		
		/*
		 * Getter for coordinate list.
		 */
	 public ArrayList<Coordinate> getCoordinateList() {
		
		return CoordinateList;
	}
	 /*
	  * Generates a list with the coordinates that have walls, and which relative direction the wall is in. This function for
	  * any given direction works such that it saves the coordinate of the attempted move and it not only checks if there is a
	  * wall from the given position to the desired position, but also tests if the reverse is true. For example, if the random 
	  * direction was down, it would check if there is a wall below the given coordinate as well as if there is a wall above the 
	  * coordinate above the given coordinate. This makes sure regardless of the wall's classification during  the generation of 
	  * all the coordinates, no walls will be able to be passed. The coordinates that do not have a wall in the defined direction are
	  * added to the remove list. 
	  */
	 public void GenerateWalls()
	 {
					while(CoordinateList2D2.size() > 1) {	
						Random ran = new Random();
					int randomrow=ran.nextInt(length);
					int randomcol=ran.nextInt(width);
					int randomdir=ran.nextInt(4);// randomly gives 1 of 4 numbers which are used as the random direction (1: left, 2: right, 3: up, 4: down)
					
					// RANDOM DIRECTION IS DOWN
					if (randomdir==0 && randomrow+1<width) {
					Coordinate myCoor;
					myCoor = new Coordinate(randomcol,randomrow,'e','x',false,false,false,false);
					Coordinate below = new Coordinate(randomcol,randomrow+1,'e','x',false,false,false,false);
					for(Coordinate x:CoordinateList) {
						if ((x.getX() == randomcol)&&(x.getY() == randomrow)) {
							myCoor = x;
						}
						if ((x.getX() == randomcol)&&(x.getY() == randomrow + 1)) {
							below = x;
						}
						
					}
					if ((myCoor.getDown() == true)&&(below.getUp() == true)&&(myCoor.getLetter() != below.getLetter())){
						myCoor.setDown(false);
						below.setUp(false);
						char newLetter = myCoor.getLetter();
						ArrayList<Coordinate> myList = new ArrayList<Coordinate>();
						ArrayList<Coordinate> removeList = new ArrayList<Coordinate>();
						for (ArrayList<Coordinate> y:CoordinateList2D2) {
							if (y.contains(myCoor)) {
								myList = y;
							}
							else if (y.contains(below)) {
								removeList = y;
							}
						}
						if (removeList != myList) {
						for(Coordinate c: removeList) {
							c.setLetter(newLetter);
							myList.add(c);
						}
						CoordinateList2D2.remove(removeList);}
					
					}
					}
					
				
				//RANDOM DIRECTION IS RIGHT
				if (randomdir==1&&(randomcol+1)<length) {
			
					Coordinate myCoor;
					myCoor = new Coordinate(randomcol,randomrow,'e','x',false,false,false,false);
					Coordinate beside = new Coordinate(randomcol+1,randomrow,'e','x',false,false,false,false);
					for(Coordinate x:CoordinateList) {
						if ((x.getX() == randomcol)&&(x.getY() == randomrow)) {
							myCoor = x;
						}
						if ((x.getX() == randomcol+1)&&(x.getY() == randomrow)) {
							beside = x;
						}
						
					}
					if ((myCoor.getRight() == true)&&(beside.getLeft() == true)&&(myCoor.getLetter() != beside.getLetter())){
						myCoor.setRight(false);
						beside.setLeft(false);
						char newLetter = myCoor.getLetter();
						ArrayList<Coordinate> myList = new ArrayList<Coordinate>();
						ArrayList<Coordinate> removeList = new ArrayList<Coordinate>();
						for (ArrayList<Coordinate> y:CoordinateList2D2) {
							if (y.contains(myCoor)) {
								myList = y;
							}
							else if (y.contains(beside)) {
								removeList = y;
							}
						}
						if (removeList != myList) {
						for(Coordinate c: removeList) {
							c.setLetter(newLetter);
							myList.add(c);
						}
						CoordinateList2D2.remove(removeList);}
					
					}}

				
				//RANDOM DIRECTION IS UP
				if (randomdir==2&&randomrow-1>=0) {
					Coordinate myCoor;
					myCoor = new Coordinate(randomcol,randomrow,'e','x',false,false,false,false);
					Coordinate above = new Coordinate(randomcol,randomrow-1,'e','x',false,false,false,false);
					for(Coordinate x:CoordinateList) {
						if ((x.getX() == randomcol)&&(x.getY() == randomrow)) {
							myCoor = x;
						}
						if ((x.getX() == randomcol)&&(x.getY() == randomrow - 1)) {
							above = x;
						}
						
					}
					if ((myCoor.getUp() == true)&&(above.getDown() == true)&&(myCoor.getLetter() != above.getLetter())){
						myCoor.setUp(false);
						above.setDown(false);
						char newLetter = myCoor.getLetter();
						ArrayList<Coordinate> myList = new ArrayList<Coordinate>();
						ArrayList<Coordinate> removeList = new ArrayList<Coordinate>();
						for (ArrayList<Coordinate> y:CoordinateList2D2) {
							if (y.contains(myCoor)) {
								myList = y;
							}
							else if (y.contains(above)) {
								removeList = y;
							}
						}
						if (removeList != myList) {
						for(Coordinate c: removeList) {
							c.setLetter(newLetter);
							myList.add(c);
						}
						CoordinateList2D2.remove(removeList);}
					
					}}
				
				
				
				
				//RANDOM DIRECTION IS LEFT
				if (randomdir==3&&randomcol-1>=0) {
					Coordinate myCoor;
					myCoor = new Coordinate(randomcol,randomrow,'e','x',false,false,false,false);
					Coordinate beside = new Coordinate(randomcol-1,randomrow,'e','x',false,false,false,false);
					for(Coordinate x:CoordinateList) {
						if ((x.getX() == randomcol)&&(x.getY() == randomrow)) {
							myCoor = x;
						}
						if ((x.getX() == randomcol-1)&&(x.getY() == randomrow)) {
							beside = x;
						}
						
					}
					if ((myCoor.getLeft() == true)&&(beside.getRight() == true)&&(myCoor.getLetter() != beside.getLetter())){
						myCoor.setLeft(false);
						beside.setRight(false);
						char newLetter = myCoor.getLetter();
						ArrayList<Coordinate> myList = new ArrayList<Coordinate>();
						ArrayList<Coordinate> removeList = new ArrayList<Coordinate>();
						for (ArrayList<Coordinate> y:CoordinateList2D2) {
							if (y.contains(myCoor)) {
								myList = y;
							}
							else if (y.contains(beside)) {
								removeList = y;
							}
						}
						if (removeList != myList) {
						for(Coordinate c: removeList) {
							c.setLetter(newLetter);
							myList.add(c);
						}
						CoordinateList2D2.remove(removeList);}
					
					}	}
				
				
				} }
	/*
	 * Creates a coordinate for every combination of i rows and j columns. This method also makes sure these values of i and j are
	 * within the range of the actual maze
	 */
	public static Coordinate[][] order(ArrayList<Coordinate> list){
		Coordinate[][] ordered = new Coordinate[length][width];
		for (int i = 0; i < length; i++){
			for (int j = 0;j<width;j++) {
				for (Coordinate c: list) {
					if (c.getX() == i&&c.getY() == j) {
						if (i == 0 && j == 0){
						c.setUp(false);
						}
						if(i==length-1 && j == width-1){
						c.setUp(false);
						}
						ordered[j][i] = c;
					}
				}
			}
		}
		return ordered;
	}
				
	/*
	 * Prints the maze in the console such that at every vertical boundary, a "|" is printed and for every coordinate's ceiling or floor, "---".
	 * This is done by once more, looping through all combinations of coordinates and using the getSomeDirection methods to move in that given
	 * direction and print the next row or column 
	 */
	public static void PrintMaze(ArrayList<Coordinate> list) {
		Coordinate[][] ordered = order(list);
		for (int i = 0; i < length; i++){
			String row ="|";
			String top ="";
			for (int j = 0;j<width;j++) {
				if (ordered[i][j].getUp() == true) {
					top = top +" ---";}
				 else {
					 top = top +"    ";
				}
				row = row + " " + ordered[i][j].getStatus();
				if (ordered[i][j].getRight() == true) {
					row = row+" |";
				 }
				else { row= row + "  ";}
				}
			System.out.println(top);
			System.out.println(row);
			}
		for (int n = 1; n<length; n++) {
			if (n == length-1){
				System.out.println(" ---");
			}
        	else if (n == length) {
        		System.out.println(" ---     ");
        	}
        	
        	else {
        		System.out.print(" ---");
        	}
        }
		}
	
	/*
	 * Main method that uses the coordinate list of coordinates and the direction from said coordinate that encounters a wall
	 * (saved in the form of the letter parameter for the Coordinate constructor) to construct and print a randomized maze
	 * with at least one solution
	 */
	 public static void main(String[] args) 
	    { 
		 char c = 90;
		 System.out.println(c);
		 	Maze newMaze = new Maze(15,15);
		 	//test - to print out status of each coordinates
			for (int i=0;i<newMaze.CoordinateList.size();i++) {
				System.out.println(newMaze.CoordinateList.get(i).toString());
			}
			newMaze.GenerateWalls();
			for(ArrayList<Coordinate> a : newMaze.CoordinateList2D2) {
				System.out.println(a.size());
				for (Coordinate z: a) {
					System.out.println(z.getLetter());
					System.out.println(z.toString());
					System.out.println(z.getRight());
				}
			}
			Maze.PrintMaze(newMaze.CoordinateList);
			

	  
	    } 

}