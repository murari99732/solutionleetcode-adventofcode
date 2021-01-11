package dynamicprogramming;

public class EqualSumPartition {

	public static boolean partiton(int arr[], int n, int sum)
	{
		if(sum==0 && n==0)
		{
			return true;
		}
		if(sum==0|| n==0)
		{
			return false;
		}
		boolean b[][]= new boolean[n][sum];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<sum;j++)
			{
				if(b[i - 1][j]) {
			          b[i][j] = true;
			        }
				else
				{
					if(j >= arr[i])
					{
					    b[i][j] = b[i - 1][j - arr[i]]; 
					}
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
	}
}
