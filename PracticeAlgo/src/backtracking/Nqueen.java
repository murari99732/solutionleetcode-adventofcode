package backtracking;

public class Nqueen {
	  
	  final int N;
	  
	  Nqueen(int N) {
	    this.N = N;
	  }
	  
	  public boolean queenProblem() {
	    int[][] sol = new int[N][N];
	    
	    if(!queenProblemUtil(0, sol)) {
	      System.out.println("N-Queen Placement not possible");
	      return false;
	    }
	    
	    printQueenPlacement(sol);
	    return true;
	  }
	  
	  private boolean queenProblemUtil(int col, int[][] sol) {
	    
	    if(col >= N) {
	      return true;
	    }
	    
	    for(int row = 0; row < N; row++) {
	      
	      if(isSafeToPlaceQueen(row, col, sol)) {
	        sol[row][col] = 1;
	        
	        if(queenProblemUtil(col + 1, sol)) {
	          return true;
	        }
	        
	        sol[row][col] = 0;
	      }  
	    }

	    return false;
	  }
	  
	  private boolean isSafeToPlaceQueen(int row, int col, int[][] sol) {
	    int i, j;
	    
	    for(i = 0; i < col; i++) {
	      if(sol[row][i] == 1) {
	        return false;
	      }
	    }
	    
	    for(i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
	      if(sol[i][j] == 1) {
	        return false;
	      }
	    }
	    
	    for(i = row, j = col; i < N && j >= 0 ; i++, j--) {
	      if(sol[i][j] == 1) {
	        return false;
	      }
	    }
	    
	    return true;
	  }
	  
	  private void printQueenPlacement(int[][] mat) {
	    for(int i = 0; i < N; i++) {
	      for(int j = 0; j < N; j++) {
	        System.out.print(mat[i][j] + " ");
	      }
	      
	      System.out.println();
	    }
	  }

	  public static void main(String[] args) {
	    
	    int n = 10;
	    Nqueen prob = new Nqueen(n);
	    prob.queenProblem();
	  }

	}