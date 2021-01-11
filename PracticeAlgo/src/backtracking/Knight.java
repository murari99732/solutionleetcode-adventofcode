package backtracking;

public class Knight {

	int g[][];
	private static final int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	public static void move(int g[][])
	{
		moveutil(g,1,0,0);
	}

	private static boolean moveutil(int g[][],int count, int row , int col) {
		if(count ==row*col)
		{
			return true;
		}
		
		for(int i=0;i<row;i++)
		{
			int nextX = row + xMoves[i];
			int nextY = col + yMoves[i];
			
			if(isvalid(nextX,nextY,g)&& g[nextX][nextY] == 0)
			{
				g[nextX][nextY]=1;
				if(moveutil(g,count+1,row, col))
				{
					return true;
				}
				g[nextX][nextY] = 0;
			}
		}
		return false;
	}

	private static boolean isvalid(int nextX, int nextY, int[][] g2) {
		if(nextX>=0 && nextX<=g2.length && nextY>=0 && nextY>g2.length)
		return true;
		return false;
	}
	
}
