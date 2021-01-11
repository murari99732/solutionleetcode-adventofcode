package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	int vertices;
	List<Integer> adjacencyList[];

	TopologicalSort(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList();
		}
	}

	void addEdge(int v, int u) {
		adjacencyList[v].add(u);

	}

	void prims(int g[][]) {
		int vertices=5;
		int[] key = new int[5];
		boolean[] b = new boolean[5];
		int[] parent = new int[5];
		for (int i = 0; i < vertices; i++) {
			key[i] = Integer.MAX_VALUE;
			b[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < vertices - 1; i++) {
			int min = minimumValue(key, b);
			b[min] = true;

			for (int j = 0; j < vertices; j++) {
				if (g[min][j] != 0 && b[j] == false && key[j] > g[min][j]) {
					key[j] = g[min][j];
					parent[j] = min;

				}
			}
		}

		print(parent, key, g);

	}

	
public void topologicalSorting()
{
	
	boolean[] b= new boolean[vertices];
	Stack<Integer> st= new Stack<>();
	for(int i=0;i<vertices;i++)
	{
		b[i]=false;
	}
	
	for( int i=0;i<vertices;i++)
	{
		if(b[i]==false)
		addv(i,st, b);
	}
	while(!st.isEmpty())
	{
		int d=st.pop();
		System.out.println("pop::"+d);
	}
}
	
	private void addv(int i, Stack<Integer> st, boolean[] b) {
	
		b[i]=true;
		
		Iterator<Integer> it= adjacencyList[i].iterator();
		while(it.hasNext())
		{
			int d= it.next();
			if(b[d]==false)
			{
				addv(d,st,b);
			}
		}
		st.push(i);
		
	
}

	public void dijsktra(int g[][]) {
		int vertices=5;
		int key[] = new int[vertices];
		int parent[] = new int[vertices];
		boolean[] b = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			key[i] = Integer.MAX_VALUE;
			b[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < vertices - 1; i++) {
			int min = minimumValue(key, b);
			b[min] = true;
			for (int j = 0; j < vertices; j++) {
				if (g[min][j] != 0 && b[j] == false) {
					int newdistance = key[min] + g[min][j];
					if (newdistance < key[j]) {
						key[j] = newdistance;
						parent[j] = min;
					}
				}
			}
		}
		print(parent, key, g);
	}

	private void print(int[] parent, int[] key, int[][] g) {
		int vertices=5;
		for (int i = 1; i < vertices; i++) {
			System.out.println(parent[i] + ":::::" + i + "::::" + g[i][parent[i]]);
		}

	}

	private int minimumValue(int[] key, boolean[] b) {
		int vertices=5;
		int min = Integer.MAX_VALUE;
		int minValue = 0;
		for (int i = 0; i < vertices; i++) {
			if (b[i] == false && key[i] < min) {
				min = key[i];
				minValue = i;

			}
		}
		return minValue;
	}

	void BFSRex(int source) {
		boolean[] b = new boolean[vertices];

		BFSUtility(source, b);
	}

	void BFSMatrix(int g[][], int source) {
		boolean[] b = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		b[source] = true;
		while (queue.size() != 0) {
			for (int i = 0; i < vertices - 1; i++) {
				int d = queue.poll();
				System.out.println(d);
				for (int j = 0; j < vertices - 1; j++) {
					if (b[j] == false && g[d][j] != 0) {
						queue.add(j);
						b[j] = true;
					}
				}
			}
		}
	}

	private int minimum(Queue<Integer> queue, boolean[] b) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void BFSUtility(int source, boolean[] b) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		b[source] = true;
		queue.add(source);
		while (queue.size() != 0) {
			int d = queue.poll();
			System.out.println("value =" + d);

			Iterator<Integer> i = adjacencyList[d].iterator();
			while (i.hasNext()) {
				int e = i.next();
				if (b[e] == false) {
					BFSUtility(e, b);

				}
			}
		}

	}

	void BFS(int source) {
		boolean[] b = new boolean[vertices];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		b[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			int d = queue.poll();
			System.out.println("value =" + d);

			Iterator<Integer> i = adjacencyList[d].iterator();
			while (i.hasNext()) {
				int e = i.next();
				if (b[e] == false) {
					b[e] = true;
					queue.add(e);

				}
			}
		}

	}

	public void toposort() {
		boolean[] b = new boolean[vertices];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < vertices; i++) {
			b[i] = false;
		}
		for (int i = 0; i < vertices; i++) {
			if (b[i] == false) {
				sortutility(i, st, b);
			}

		}
		while (st.empty() == false)
			System.out.print(st.pop() + " ");

	}

	private void sortutility(int i, Stack<Integer> st, boolean[] b) {
		b[i] = true;
		Iterator<Integer> it = adjacencyList[i].iterator();
		while (it.hasNext()) {
			int f = it.next();
			if (b[f] == false) {
				sortutility(f, st, b);
			}

		}
		st.push(i);

	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		int graph[][] = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 } };
		g.convert(graph);
	}

	private void convert(int[][] graph) {
		
		ArrayList<ArrayList<Integer>> ar= new ArrayList<>();
		
		for( int i=0;i<graph.length;i++)
		{ArrayList<Integer> ab= new ArrayList<>();
			for(int j=0;j<graph[0].length;j++)
			{
				ab.add(graph[i][j]);
			}
			ar.add(i,ab);
		}
		for(int i=0;i<ar.size();i++)
		{
			
				System.out.println(ar.get(i));
			
		}
	}

}
