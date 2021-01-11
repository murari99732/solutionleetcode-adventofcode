package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Practice {

	int vertices;
	List<Integer> adjacencyList[];

	public Practice(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
       
		
	}
	void add(int v, int u)
	{
		adjacencyList[v].add(u);
	}

	void bellmanford(int g[][])
	{
		boolean[] b= new boolean[vertices];
		int a[]= new int[vertices];
		for(int i=0;i<vertices;i++)
		{
			a[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(g[i][j]+a[i]>a[j] && a[i]!=Integer.MAX_VALUE)
				{
					a[j]=g[i][j];
				}
			}
		}
		
	
	}
	
	void topologicalSorting()
	{
		boolean[] b= new boolean[vertices];
		Stack<Integer> st= new Stack<Integer>();
		
		for(int i=0;i<vertices;i++)
		{
			topoutility(b,st, i);
		}
		while(!st.isEmpty())
		{
			int d= st.pop();
			System.out.println(d);
		}
		
	}
	
	private void topoutility(boolean[] b, Stack<Integer> st, int i) {
	b[i]=true;
		Iterator<Integer> it= adjacencyList[i].iterator();
		while (it.hasNext()) {
			int is=  it.next();
			if(b[is]==false)
			{
				topoutility(b, st, is);
			}
			
		}
		st.push(i);
		
	}
	void dijsktra(int g[][])
	{
		int keys[]= new int[vertices];
		int parent[]= new int[vertices];
		boolean[] b= new boolean[vertices];
		for(int i=0;i<vertices;i++)
		{
			b[i]=false;
			keys[i]=Integer.MAX_VALUE;
		}
		keys[0]=0;
		parent[0]=-1;
		for(int i=0;i<vertices-1;i++)
		{
			int d= minimumvalue(keys, b);
			b[d]=true;
			for(int j=0;j<vertices;j++)
			{
				if(g[d][j]!=0 && b[j]==false && keys[j]!=Integer.MAX_VALUE)
				{
					int newd=g[d][j]+keys[d];
					if(newd<keys[j])
					{
						keys[j]=newd;
						parent[j]=d;
					}
				}
			}
			
		}
		
	}
	
	void prims(int g[][])
	{
		int keys[]= new int[vertices];
		int parent[]= new int[vertices];
		boolean[] b= new boolean[vertices];
		for(int i=0;i<vertices;i++)
		{
			b[i]=false;
			keys[i]=Integer.MAX_VALUE;
		}
		keys[0]=0;
		parent[0]=-1;
		for(int i=0;i<vertices-1;i++)
		{
			int min= minimumvalue(keys, b);
			b[min]=true;
			for(int j=0;j<vertices;j++)
			{
				if(g[min][j]!=0 && b[j]==false && keys[j]>g[min][j])
				{
					keys[j]=g[min][j];
					parent[j]=min;
				}
			}
		}
	}
	
	private int minimumvalue(int[] keys, boolean[] b) {
	
		int minv=0;
		int min= Integer.MAX_VALUE;
		for(int i=0;i<vertices;i++)
		{
			if(b[i]==false && keys[i]<min)
			{
				min=keys[i];
				minv=i;
				
			}
			return minv;
		}
		
		return 0;
	}
	void BFS(int sources)
	{
		Queue<Integer> queue= new LinkedList<>();
		boolean[] b= new boolean[vertices];
		queue.add(sources);
		while(queue.size()!=0)
		{
			int d= queue.poll();
			System.out.println(d);
			b[d]=true;
			
			Iterator<Integer> it= adjacencyList[d].iterator();
			while(it.hasNext())
			{
				int de=it.next();
				if(b[de]==false)
				{
					b[de]=true;
					queue.add(de);
				}
			}
		}
	}
	
	void DFS(int sources)
	{
		Stack<Integer> st= new Stack<Integer>();
		boolean[] b= new boolean[vertices];
	    DFSutility(sources, st, b);
	}
	
	private void DFSutility(int sources, Stack<Integer> st, boolean[] b) {
       st.push(sources);
       while(!st.isEmpty())
       {
    	   int s=st.pop();
    	   System.out.println("value:"+s);
    	   Iterator<Integer> df= adjacencyList[s].iterator();
    	   while(df.hasNext())
    	   {
    		   int gh=df.next();
    		   if(b[gh]==false)
    		   {
    			   DFSutility(gh, st, b);
    		   }
    	   }
       }
	}
	public static void main(String[] args) {

	}

}
