package application;
import java.util.*; 

public class Maze {
	 static int length;
	 static int width;
	 ArrayList<Coordinate> CoordinateList;
	 public ArrayList<ArrayList<Coordinate>> CoordinateList2D2;
	 static char[][] CoordinateList2D;
	 
	 
	 /*protected boolean[][] down;
	 protected boolean[][] up;
	 protected boolean[][] right;
	 protected boolean[][] left;
	 protected boolean[][] visited;*/

	 
	 public Maze(int length, int width) {
		 this.CoordinateList=new ArrayList<Coordinate> ();
		 this.CoordinateList2D2 = new ArrayList<ArrayList<Coordinate>>();
		 Maze.length=length;
		 Maze.width=width;
		 char newLetter = 65;
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
		 //randomly generate wall i.e. change 'e' to 'w' but have to be sure the wall doesn't form
		 //a closed path, i.e. at least one of direction should be opened(for entering)
		/* down = new boolean[length][width];
		 up = new boolean[length][width];
		 right = new boolean[length][width];
		 left = new boolean[length][width];		 
	        for (int x = 0; x < length; x++) {
	            for (int y = 0; y < width; y++) {
	            	down[x][y] = true;
	                up[x][y]  = true;
	                right[x][y] = true;
	                left[x][y]  = true;
	            }
	        }
	        up[0][0]=false;
	        down[length-1][width-1]=false;
			//convert to 2D Array
			CoordinateList2D=new char[length][width];
			for (int row=0;row<width;row++) {
			for (int col =0;col<length;col++) {
				CoordinateList2D[row][col]=CoordinateList.get(row*length+col).getLetter();}}*/
			
			//Hardcoded Walls and Coordinate List
				//ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
			//for (ArrayList<Coordinate> x :this.CoordinateList2D2) {
			///	if (x.contains(temp)){
					
			//	}
			
			}

		 //GenerateWalls();
		
		 
	 public ArrayList<Coordinate> getCoordinateList() {
		
		return CoordinateList;
	}

	public boolean SameSet() {
		 return true;
	 }
	 public void GenerateWalls()
	 {
				//generate a random integer between 1-size of maze( directions)
				//Random ran = new Random();
				int Welldown=0;
				//using the random number above, 1: check left(x-1), 2:right(x+1),3:up(y+1) 4:down(y-1)
				//for (int row=0;row<this.width;row++) {
				//for (int col =0;col<this.length;col++) {
				//while(Welldown<(length*width-1)) {
				//while any of the internal walls has true value
					while(CoordinateList2D2.size() > 1) {	
					//0-4 for length of 5
						Random ran = new Random();
					int randomrow=ran.nextInt(length);
					int randomcol=ran.nextInt(width);
					int randomdir=ran.nextInt(4);
					
					
					
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
					Welldown++;
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
					
					}
				Welldown++;}

				
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
					
					}
						
				Welldown++;}
				
				
				
				
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
					
					}
				Welldown++;	}
				
				
				} }
				
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
				
				
	public static void PrintMaze(ArrayList<Coordinate> list) {
		Coordinate[][] ordered = order(list);
		for (int i = 0; i < length; i++){
			String bottom = "";
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
			newMaze.PrintMaze(newMaze.CoordinateList);
			

	  
	    } 

}