package arraysp;

import java.util.Arrays;

public class FirstMissingPos {

	public static void missing(int ar[], int n, int i) {

		
		while (i < n) {
			if (ar[i] > 0 && ar[i] < n + 1 && ar[i] != i + 1) {
				int otherIndex = ar[i] - 1;

				int x = ar[i];
				ar[i] = ar[otherIndex];
				ar[otherIndex] = x;
			} else {
				i++;
			}
		}

		for (int j = 0; j < n; j++) {
			if (ar[j] != j + 1)
				System.out.println(j + 1);
		}
	}

	public static int reverseArray(int ar[], int n, int br[],int i) {
	
		if (n == 0) {
			return 0;
		}

		int d = reverseArray(ar, n - 1, br,i+1);

		br[i] = ar[n - 1];
		i++;
		return d;
	}

	public static void kmissing(int ar[], int n) {

		int i = 0;
		while (i < n) {
			if (ar[i] > 0 && ar[i] < n + 1 && ar[i] != i + 1) {
				int otherIndex = ar[i] - 1;

				int x = ar[i];
				ar[i] = ar[otherIndex];
				ar[otherIndex] = x;
			} else {
				i++;
			}
		}

		for (int j = 0; j <= n; j++) {
			if (ar[j] != j + 1)
				System.out.println(ar[j]);
		}
	}

	public static void max1 (int arr[], int n)
	{
		int b[]= new int[n+1];
		for(int j=0;j<n;j++)
		{
			b[j]=1;
		}
		
			for(int j=0;j<=arr.length;j++)
			if(arr[j]==1 && arr[j+1]==1 && b[j]+1>b[j])
			{
				b[j]=b[j]+1;
			}
		
		for(int j=0;j<n;j++)
		{
			System.out.println(b[j]);
		}
	}
	
	static int longestsubarry(int arr[], int k)
	{
		
		if(arr.length==0||k==0)
		{
			return 0;
		}
		int max=0;
		int start=0;
		int end=0;
		int i=0;
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
		max=Math.max(end-start+1, max);
		end++;
	}
		
		return max;	
	}
	
	public static void main(String[] args) {
		int ar[] = { 0,1,0,1,1,1,0,1 };
		int br[] = new int[ar.length];
		System.out.println(longestsubarry(ar, 2));
		//for (int d : br) {
		//	System.out.println(d);
		//}
	}
}
