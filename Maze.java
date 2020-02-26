import java.util.*; 

public class Maze {
	 private int length;
	 private int width;
	 private  ArrayList<Coordinate> CoordinateList;

	 private static char[][] CoordinateList2D;
	 
	 
	 private boolean[][] down;
	 private boolean[][] up;
	 private boolean[][] right;
	 private boolean[][] left;
	 private boolean[][] visited;

	 
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
				 CoordinateList.get(i).setLetter((char)(i+65));
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
			
		 GenerateWalls();

		 }
	 public boolean SameSet() {
		 
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
		 	Maze newMaze = new Maze(5,5);
		 	//test - to print out status of each coordinates
			for (int i=0;i<newMaze.CoordinateList.size();i++) {
				System.out.println(newMaze.CoordinateList.get(i).toString());
				

			}
			for (int row=0;row<5;row++) {
			for (int col =0;col<5;col++) {
		        if((((col+1) % 5) == 0) ){
		        	System.out.println(CoordinateList2D[row][col]);	
		        }
		        else{System.out.print(CoordinateList2D[row][col]);}
		        
			}
			
			}	
			

	  
	    } 

}