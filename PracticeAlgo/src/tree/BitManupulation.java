package tree;

import java.util.HashSet;

public class BitManupulation {

	static void findUnqiueElement(int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum ^ a[i];
		}
		System.out.println(sum);
	}
	
	static void matrixunique(int g[][],int l, int k)
	{
		HashSet<String> hashset= new HashSet<String>();
		for(int i=0;i<l;i++)
		{
			String s="";
			for (int j = 0; j < k; j++) {
				s=s+String.valueOf(g[i][j]);
				if(!hashset.contains(s) && j==k-1)
				{
					hashset.add(s);
					
				    System.out.println(s); 
				}
				
			}
		}
	}
	
	static void evenorodd(int n)
	{
		int d=n^1;
		if(d>n)
		{
			System.out.println("even");
		}
		else if(d<n)
		{
			System.out.println("odd");
		}
	}

	public static void main(String[] args) {
	      int arr[][] = { {0, 1, 0, 0, 1}, 
                  {1, 0, 1, 1, 0}, 
                  {0, 1, 0, 0, 1}, 
                  {1, 1, 1, 0, 0} }; 
    
	      matrixunique(arr, 4, 5); 
	}
}
