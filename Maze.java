import java.util.*; 

public class Maze {
	 private int length;
	 private int width;
	 private  ArrayList<Coordinate> CoordinateList;

	 public static char[][] CoordinateList2D;
	 

	 public static boolean[][] down;
	 public static boolean[][] up;
	 public static boolean[][] right;
	 public static boolean[][] left;
	 public static boolean[][] visited;

	 private static String[][] LetterWitWalls;
	 
	 public Maze(int length, int width) {
		 this.CoordinateList=new ArrayList<Coordinate> ();
		 this.length=length;
		 this.width=width;
		 for(int i=0;i<(length);i++) {
			 for(int j=0;j<(width);j++) {
				 this.CoordinateList.add(new Coordinate(i,j,'w'));
			 }}
		 //randomly generate wall i.e. change 'e' to 'w' but have to be sure the wall doesn't form
		 //a closed path, i.e. at least one of direction should be opened(for entering)
			for (int i=0;i<CoordinateList.size();i++) {
				 CoordinateList.get(i).setLetter('E');
			}
		 down = new boolean[length][width];
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
				CoordinateList2D[row][col]=CoordinateList.get(row*length+col).getLetter();}}
			right[0][0] = false;
			right[0][1] = false;
			down[0][1] = false;
			up[1][1] = false;
			right[1][0] = false;
			down[1][0] = false;
			up[2][0] = false;
			down[2][0] = false; 
			up[3][0] = false;
			right[3][0] = false;
			down[3][1] = false;
			up[4][1] = false;
			right[4][0] = false; 
			down[4][0] = false; 
			up[5][0] = false;
			right[5][0]= false;
			right[5][1] = false;
			up[5][2] = false;
			down[4][2] = false;
			right[4][2] = false;
			down[4][3] = false; 
			up[5][3] = false;
			right[1][1] = false;
			right[1][2] = false;
			down[1][2] = false;
			up[2][2] = false; 
			right[2][1] = false;
			down[2][2] = false;
			up[3][2] = false;
			right[3][2] = false;
			right[0][2] = false; 
			right[0][3] = false;
			down[0][3] = false;
			up[1][3] = false;
			right[1][3] = false;
			right[1][4] = false;
			up[1][5] = false;
			down[0][5] = false;
			down[1][5] = false;
			up[2][5] = false;
			down[2][5] = false;
			up[3][5] = false;
			right[3][4] = false;
			up[3][4] = false;
			down[2][4] = false;
			right[2][3] = false;
			right[4][4] = false;
			down[4][5] = false;
			up[5][5] = false;
			down[3][5] = false;
			up[4][5] = false;
			right[4][4] = false;
			down[4][4] = false;
			up[5][4] = false;
			CoordinateList2D[0][0] = 'P';
		 //GenerateWalls();

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
					while(Welldown<(length*width+30000)) {	
					//0-4 for length of 5
						Random ran = new Random();
					int randomrow=ran.nextInt(length);
					int randomcol=ran.nextInt(width);
					int randomdir=ran.nextInt(4);
					if (randomdir==0 && randomrow+1<width) {
					if (CoordinateList2D[randomrow][randomcol]!=CoordinateList2D[randomrow+1][randomcol]&&
							down[randomrow][randomcol]==true&&up[randomrow+1][randomcol]==true) {
						//if there's more to the set, do it to the rest 
						/*for (int row=0;row<width;row++) {
							for (int col =0;col<length;col++) {
							 if (CoordinateList2D[row][col]==CoordinateList2D[randomrow+1][randomcol]&&
								row==randomrow+1) {;}
							}}*/
						
						
						CoordinateList2D[randomrow+1][randomcol]=CoordinateList2D[randomrow][randomcol];

							//knock down the up wall of randomrow+1 and down wall of randomrow(same)

						down[randomrow][randomcol]=false;
						up[randomrow+1]	[randomcol]=false;	
							
							}

					Welldown++;}
					
				if (randomdir==1&&(randomcol+1)<length) {
				if (CoordinateList2D[randomrow][randomcol]!=CoordinateList2D[randomrow][randomcol+1]&&
						right[randomrow][randomcol]==true&&left[randomrow][randomcol+1]==true) {
						
					CoordinateList2D[randomrow][randomcol+1]=CoordinateList2D[randomrow][randomcol];
						//knock down the right wall of randomcol and left wall of randomcol+1(same)
					right[randomrow][randomcol]=false;
					left[randomrow]	[randomcol+1]=false;
						}
	
				Welldown++;}
				if (randomdir==2&&randomrow-1>=0) {
				if (CoordinateList2D[randomrow][randomcol]!=CoordinateList2D[randomrow-1][randomcol]&&
						down[randomrow-1][randomcol]==true&&up[randomrow][randomcol]==true) {
					CoordinateList2D[randomrow-1][randomcol]=CoordinateList2D[randomrow][randomcol];
				//knock down the right wall of randomrow-1 and left wall of randomrow(same)
					down[randomrow-1][randomcol]=false;
					up[randomrow][randomcol]=false;		
						}

				Welldown++;}
				
				if (randomdir==3&&randomcol-1>=0) {
				if (CoordinateList2D[randomrow][randomcol-1]!=CoordinateList2D[randomrow][randomcol]&&
						right[randomrow][randomcol-1]==true&&left[randomrow][randomcol]==true) {
					CoordinateList2D[randomrow][randomcol-1]=CoordinateList2D[randomrow][randomcol];
				//knock down the down wall of randomrow-1 and up wall of randomrow(same)
					right[randomrow][randomcol-1]=false;
					left[randomrow][randomcol]=false;	
						}

				Welldown++;	}
				
					} 
				System.out.println(Welldown);

				}

	 public static void main(String[] args) 
	    { 
		 	Maze newMaze = new Maze(6,6);
		 	//test - to print out status of each coordinates
			for (int i=0;i<newMaze.CoordinateList.size();i++) {
				System.out.println(newMaze.CoordinateList.get(i).toString());
			
			

			}
			/*for (int row=0;row<5;row++) {
			for (int col =0;col<5;col++) {
		        if((((col+1) % 5) == 0) ){
		        	System.out.println(CoordinateList2D[row][col]);	
		        }
		        else{System.out.print(CoordinateList2D[row][col]);}
		        
			}*/
			newMaze.PrintMaze(6,6);
			
			}	
	    //} 
	 
	 //Print out the actual wall shapes(-,|,|,-) 
	 public static void PrintMaze(int length, int width) {
		
		 for(int i=0;i<width;i++) {
			 String BottomWell ="";
			 String Row ="|";
			 String TopWell ="";
			 for (int x=0;x<width;x++) {
				 if (up[i][x]==true) {
					 TopWell=TopWell+" ---";}
					 else {
						 TopWell=TopWell+"    ";
					 		}
				 Row=Row+ " " +CoordinateList2D[i][x];
				
				 
				 if (right[i][x]==true){
					
					 Row=Row+" |";
						 }
				 else {Row=Row+"  ";}
			 }
			 System.out.println(TopWell);
			 System.out.println(Row);
			 
			 //System.out.println(BottomWell);
		 }
		 System.out.println(" --- --- --- --- ---     ");

		 /*
		 LetterWitWalls=new String [length][width];
			for (int row=0;row<width;row++) {
			for (int col =0;col<length;col++) {
				//make sure it switch row every count of length(e.g.5)
				
				//first part-go by row increase
				//draw up up wall
				if (up[row][col]==true){
						
					System.out.println("__");
					}
				else {
					System.out.println(" ");
					}
				
				//go down 1 row with println and draw Letter with left and right wall/space append to it
				String LetterWithWall = "";
				if (left[row][col]==true) {
					LetterWithWall+="|";
				}
				else {
					LetterWithWall+=" ";
				}
				LetterWithWall+=CoordinateList2D[row][col];
				if (right[row][col]==true) {
					LetterWithWall+="|";
				}
				else {
					LetterWithWall+=" ";
				}				
				System.out.println(LetterWithWall);
				//
				
				//draw  up wall
				if (down[row][col]==true){
					System.out.println("__");
					}
				else {
					System.out.println(" ");
					}
				
				
				
				}
			}*/
	 }
}