package dynamicprogramming;

import java.util.ArrayList;

public class LongestSubsequence {

	public static void main(String[] args) {
		int a[] = { 3, 2, 3, 1, 4, 3, 2, 1, 1 };
		ArrayList<Integer> ar = new ArrayList<Integer>();
		subsequence(a, a.length);
	}

	private static void subsequence(int a[], int n) {
		int maximum=0;
		int b[]= new int[n];
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[j]>a[i] && b[j]+1>b[i])
				{
					b[i]=b[j]+1;
					maximum=	Math.max(maximum, b[i]);
				}
			}
		}
	
System.out.println(maximum);
	}

	static void long1(int a[], int length) {
		
		int lis[]= new int[length];
		for(int i=1;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(a[i]>a[j] && lis[i]+1>lis[j])
				{
					lis[j]=lis[i]+1;
				}
			}
		}
		
	}
}
