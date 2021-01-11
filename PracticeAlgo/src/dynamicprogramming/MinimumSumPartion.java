package dynamicprogramming;

public class MinimumSumPartion {

	public int minsum(int arr[], int sumArray)
	{
		if(arr.length==0)
		{
			return 0;
		}
		if(sumArray%2!=0)
		{
			return 0;
		}
			
		int sum=sumArray/2;
		boolean[][] b= new boolean[arr.length][sum];
		for(int i=0;i<sum;i++)
		{
			b[0][i]=true;
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<sum;j++)
			{
				if(b[i-1][j])
				{
					b[i][j]=true;
				}
				else
				{
					b[i][j]=b[i-1][j-arr[i-1]];
				}
			}
		}
		
		int d=0;
		for(int j=sum ;j<=0;j--)
		{
			if(b[arr.length][j]==true)
			{
				d=j;
				break;
			}
		}
		int de=sumArray-d;
		return de;
	}
	public static void main(String[] args) {

	}
}
