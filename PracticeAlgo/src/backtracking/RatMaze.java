package backtracking;
// https://www.youtube.com/watch?v=jFksL23Z4g4
public class RatMaze {
static int n;
	static void maze(int g[][], int x, int y)
	{
		int dup[][]= new int [5][5];
		mazeutility(g,0, 0, dup);
		
	}
	private static boolean mazeutility(int[][] maze, int x, int y, int[][] dup) {
		if(x==4 && y==4 && maze[x][y]==1)
		{
			dup[x][y]=1;
			return true;
		}
		if(safeMaze(maze,x,y))
		{
		if(mazeutility(maze, x, y+1, dup))
		{
			return true;
		}
		if(mazeutility(maze, x+1, y, dup))
		{
			return true;
		}
		dup[x][y]=0;
		}
		return false;
	}
	private static boolean safeMaze(int[][] maze, int x, int y) {
		if(x>=0 && x<n && y>=0 && y<n && maze[x][y]==1)
		{
			return true;
		}
		return false;
	}
	static  void printSolution(int sol[][]) 
	    { 
	        for (int i = 0; i < n; i++) { 
	            for (int j = 0; j < n; j++) 
	                System.out.print( 
	                    " " + sol[i][j] + " "); 
	            System.out.println(); 
	        } 
	    } 
	  
	 public static void main(String args[]) 
	    { 
	        RatMaze rat = new RatMaze(); 
	        int maze[][] = { { 1, 0, 0, 0 }, 
	                         { 1, 1, 0, 1 }, 
	                         { 0, 1, 0, 0 }, 
	                         { 1, 1, 1, 1 } }; 
	  
	        n = maze.length; 
	        rat.maze(maze,n,n); 
	    } 
}
