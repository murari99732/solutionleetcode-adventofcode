package rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution6 {
	
	
	static void sum1(int arr[])
	{
		
	}
	
	static void sum(int arr[])
	{	int maximum=arr[0];
		int m[]=arr;
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i] && m[i]<m[j]+arr[i])
				{
					m[i]=m[j]+arr[i];
					maximum=	Math.max(maximum, m[i]);
				}
			}
		}
		System.out.println(maximum);
	}
	
	static void display(int arr[])
	{	int maximum=0;
		int m[]=new int[arr.length];
		for(int i=0;i<m.length;i++)
		{
			m[i]=1;
		}
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>arr[i] && m[i]<m[j]+1)
				{
					m[i]=m[j]+1;
					maximum=	Math.max(maximum, m[i]);
				}
			}
		}
		System.out.println(maximum);
	}
	
	public static void main(String[] args) {
		int a[] = { 3, 2, 3, 1, 4, 3, 2, 1, 1 };

		sum(a);
	}
}
