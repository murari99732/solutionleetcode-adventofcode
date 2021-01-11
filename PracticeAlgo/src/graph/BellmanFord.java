package graph;

import java.util.ArrayList;

public class BellmanFord {

	void bellman(int g[][])
	{int parent[]= new int[5];
		boolean []b= new boolean[5];
		int[] ar= new int[5];
		for( int i =0;i<5;i++)
		{
		
			ar[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(g[i][j]!=0 && ar[j]!=Integer.MAX_VALUE )
				{
					int newdistance=g[i][j]+ar[i];
					if(newdistance<ar[j])
					{
						ar[j]=newdistance;
						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
