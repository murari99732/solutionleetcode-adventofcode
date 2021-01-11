package rough;

public class Practice1 {

 static	int m[][];
static	int n=5;
	
static	int sum(int x, int y)
	{
		if(x==n-1 && y== n-1)
		{
			return m[x][y];
		}
		int add=0;
		if(x<n-1 && y<n-1)
		{
			add=m[x][y]+Math.max(sum(x+1,y), sum(x, y+1));
			
		}
		else if( x==n-1)
		{
			add= m[x][y]+sum(x,y+1);
		}
		else
		{
			add= m[x][y]+sum(x+1,y);
		}
			
		return add;
	}
	
	public static void main(String[] args) {
		Practice1 p= new Practice1();
		 m = new int[][] {{1,2,3,4,4},{1,2,3,4,4},{1,2,3,4,4},{1,2,3,4,4},{1,2,3,4,4},};
		System.out.println(p.sum(0,0));
	
	}
}
