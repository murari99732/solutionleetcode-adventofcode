package dynamicprogramming;

public class SubSetProblem {

	static boolean subset(int arr[], int n, int sum)
	{
		if(sum==0|| n==0)
		{
			return false;
		}
		
	int ab[][]= new int[n][sum];

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<sum;j++)
		{
			int d=0;
			if(arr[i]<j)
			{
				d=arr[i]+ab[i-1][j-arr[i]];
			}
			ab[i][j]=Math.max(d, ab[i-1][j]);
			if(ab[i][j]==sum)
			{
				return true;
			}
		}
	}
	
	return false;
	}
	public static void main(String[] args) {
		
	}
}
