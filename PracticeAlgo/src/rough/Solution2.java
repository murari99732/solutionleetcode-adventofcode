package rough;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution2 {
	
	static class Edge
	{
		int vertices;
		int dist;
	}
	
	public void snake(int m[], int n)
	{
		boolean[] b=new boolean[n];
		Queue<Edge> q= new LinkedList<Solution2.Edge>();
		Edge e= new Edge();
		e.dist=0;
		e.vertices=0;
		q.add(e);
		while(!q.isEmpty())
		{
			Edge edge= q.poll();
			int v=edge.vertices;
			b[v]=true;
			for(int i=0;i<n;i++)
			{
				if(b[i]==false)
				{
					Edge f= new Edge();
					f.dist=v+1;
					if(m[i]!=-1)
					{
						f.vertices=m[i];
					}
					else
					{
						f.vertices=i;
					}
					q.add(f);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}