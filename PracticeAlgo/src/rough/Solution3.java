package rough;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution3 {

	
	void checkdistance(int m[][], int i, int j)
	{
		boolean[] b= new boolean[5];
		
		for(int k=0;k<5;k++)
		{
			DFSutk(b,k,m);
		}
	}
	
	private void DFSutk(boolean[] b, int k, int[][] m) {
		b[k]=true;
		int d=0;
		for(int i=0;i<5;i++)
		{
			if(k!=i)
			{
				d++;
			}
		}
		
	}

	void checkConnected(int m[][], int i, int j)
	{
	
		
		boolean[] b = new boolean[5];
		for(int k=0;k<5;k++)
		{
			b[k]=false;
		}
      for(int k=0;k<5;k++)
      {
    	  if(b[k]==false)
    	  {
    		  DFS(b,k,m);
    	  }
    	  
    	  for(int n=0;n<5;n++)
    	  {
    		  if(b[n]!=false)
    		  {
    			  System.out.println("not connected");
    		  }
    	  }
    	  Arrays.fill(b, false);
      }
	}

	private void checkConnected(int source, int destination, LinkedList<Integer> adjacencyList[])
	{
		
		boolean b[]= new boolean[5];
		for(int i=0;i<5;i++)
		{
			b[i]=false;
		}
		Stack<Integer> st= new Stack<Integer>();
		st.add(source);
		DFS1(st,destination,adjacencyList,b);
	}
	
	private void DFS1(Stack<Integer> st, int destination, LinkedList<Integer>[] adjacencyList,boolean []b) {
		
		st.peek();
		int d=st.pop();
		b[d]=true;
		if(d==destination)
		{
		return;
		}
		Iterator<Integer> it=adjacencyList[d].iterator();
		while(it.hasNext())
		{
			int df=it.next();
			if(b[df]==false)
			{
				b[df]=true;
				st.push(df);
			}
		}
	}

	private void DFS(boolean[] b, int k, int[][] m) {
		
		b[k]=true;
		
		for(int i=0;i<5;i++)
		{
			if(b[i]==false)
			{
				DFS(b, i, m);
			}
		}
		
	}
	
}
