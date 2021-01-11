package backtracking;

public class FloodFill {

	
	public static void main(String[] args) {
		int g[][]= {{1,1,1,1,1,1},
				{1,1,2,2,1,1},
				{1,2,2,2,2,1},
				{2,2,2,2,2,2},
							
		};
		floodfil(g,g.length,g[0].length);
	}

	private static void floodfil(int[][] g, int col, int row) {
	boolean[] b= new boolean[g[0].length];
	for(int i=0;i<g[0].length;i++)
	{
		b[i]=false;
	}
	int prev=g[2][2];
		floodfilutil(g,2,2,3,prev);
		
	
		
		
	}

	private static void floodfilutil(int[][] g, int i, int j, int k, int prev) {
		if(g[i][j]!=prev && i==g.length && j==g[0].length)
		{
			return;
		}
		g[i][j]=k;
		floodfilutil(g,i+1,j,k,prev);
		floodfilutil(g,i-1,j,k,prev);
		floodfilutil(g,i,j+1,k,prev);
		floodfilutil(g,i,j-1,k,prev);
		
	}

}
