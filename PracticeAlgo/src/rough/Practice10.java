package rough;

public class Practice10 {

	static void longestsubarray(int arr[], int k)
	{
		if(arr.length==0||k==0)
		{
			return ;
		}
		int max=0;
		int end=0;
		int start=0;
		int d=0;
		while(end<arr.length)
		{
			if(arr[end]==0)
			{
				d++;
			}
			if(d>k)
			{
				if(arr[start]==0)
				{
					d--;
				}
				start++;
			}
			max=Math.max(max, end-start+1 );
			end++;
		}
		System.out.println(max);
	}
	
	public static void firstKmiss(int arr[])
	{
		if(arr.length==0)
		{
			return ;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0 &&arr[i]<arr.length && arr[i]!=i+1)
			{
				int d=arr[i]-1;
				int temp=arr[d];arr[d]=arr[i];arr[i]=temp;
			}
		}
		
		for(Integer h: arr)
		{
			System.out.println(h);
		}
		
	}
	
	 public static void main(String[] args) {
		    int[] arr = {-2, 11, 1, -3, 2, 8, 4};
		    firstKmiss(arr);
		  //  System.out.println(ArrayApp.firstKMissingPositiveNumbers(arr, 5));
		  }
}
