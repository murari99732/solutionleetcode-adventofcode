package backtracking;
public class RatMazeProblem {
  
  final int N = 4;
  
  public boolean printMazePath(int[][] maze) {
    int[][] finalPath = new int[N][N];
    
    if(!printMazePathUtil(maze, 0, 0, finalPath)) {
      System.out.println("Rat Can't reach to End");
      return false;
    }
    
    printPath(finalPath);
    return true;
  }
  
  private boolean printMazePathUtil(int[][] maze, int x, int y, int[][] sol) {
    
    if(x == N - 1 && y == N - 1 && maze[x][y] == 1) {
      sol[x][y] = 1;
      return true;
    }
    
    if(isSafe(maze, x, y)) {
      sol[x][y] = 1;
      
      if(printMazePathUtil(maze, x + 1, y, sol)) {
        return true;
      }
      
      if(printMazePathUtil(maze, x, y + 1, sol)) {
        return true;
      }
      
      sol[x][y] = 0;
    }
    
    return false;
  }
  
  private boolean isSafe(int[][] maze, int x, int y) {
    if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1) {
      return true;
    }
    
    return false;
  }
  
  private void printPath(int[][] mat) {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        System.out.print(mat[i][j] + " ");
      }
      
      System.out.println();
    }
  }
  


  public static void main(String[] args) {

    RatMazeProblem rat = new RatMazeProblem(); 
    int maze[][] = {{1, 1, 1, 1}, 
                     {1, 1, 1, 1}, 
                     {1, 1, 1, 1}, 
                     {0, 0, 0, 1} 
                    }; 
        
    rat.printMazePath(maze); 
        
  }

}