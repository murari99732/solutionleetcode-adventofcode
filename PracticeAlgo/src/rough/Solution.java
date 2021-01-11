package rough;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		Solution I = new Solution();

		LinkedList<Integer>[] adjacencyList = new LinkedList[5];
		for (int i = 0; i < 5; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < 5; i++)

		{
			for (int j = 0; j < 5; j++) {
				adjacencyList[i].add(M[i][j]);
			}
		}

		primsList(adjacencyList);
	}

	public static void dijsktra(int m[][])

	{
		int keys[] = new int[m.length];
		int parent[] = new int[m.length];
		boolean[] b = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			b[i] = false;
			keys[i] = Integer.MAX_VALUE;
		}
		keys[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < m.length ; i++) {
			int min = minimum(keys, b);
			b[min] = true;
			for (int j = 0; j < m.length; j++) {
				if (m[min][j] != 0 && b[j] == false && m[min][j] < keys[j]) {
					if(keys[j]>m[min][j]+keys[i])
					keys[j] = m[min][j];
					parent[j] = i;
				}
			}
		}
		for (int i = 1; i < parent.length; i++) {
			System.out.println(parent[i] + "   " + i + "  " + m[i][parent[i]]);
		}
	}
	public static void prims(int m[][])

	{
		int keys[] = new int[m.length];
		int parent[] = new int[m.length];
		boolean[] b = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			b[i] = false;
			keys[i] = Integer.MAX_VALUE;
		}
		keys[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < m.length - 1; i++) {
			int min = minimum(keys, b);
			b[min] = true;
			for (int j = 0; j < m.length; j++) {
				if (m[min][j] != 0 && b[j] == false && m[min][j] < keys[j]) {
					keys[j] = m[min][j];
					parent[j] = i;
				}
			}
		}
		for (int i = 1; i < parent.length; i++) {
			System.out.println(parent[i] + "   " + i + "  " + m[i][parent[i]]);
		}
	}

	private static int minimum(int[] keys, boolean[] b) {
		int min = Integer.MAX_VALUE;
		int minivalue =0;
		for (int i = 0; i < 5; i++) {
			if (b[i] == false && min < keys[i]) {
				keys[i] = min;
				minivalue = i;
			}
		}
		return minivalue;
	}

	private static void DFS1(LinkedList<Integer>[] adjacencyList) {
		boolean[] b = new boolean[adjacencyList.length];
		for (int i = 0; i < adjacencyList.length; i++) {
			b[i] = false;
		}
		for (int i = 0; i < adjacencyList.length; i++) {
			if (b[i] == false) {
				DFSutility(b, i, adjacencyList);
			}
		}

	}
public void bellmanford(int m[][])
{
	int key[]= new int[m.length];
	for(int i=0;i<m.length;i++)
	{
		key[i]=Integer.MAX_VALUE;
	}
	key[0]=0;
	for(int i=0;i<m.length;i++)
	{
		for(int j=0;j<m.length;j++)
		{
			for(int k=0;k<m.length;k++)
			{
				if(key[k]>m[j][k]+key[j])
				{
					key[k]=m[j][k]+key[j];
					
				}
			}
		}
	}
}

public static void  warsahall(int m[][])
{
	int d[][]= new int[m.length][m.length];
	
	for(int i=0;i<m.length;i++)
	{
		for(int j=0;j<m.length;j++)
		{
			for(int k=0;k<m.length;k++)
			{
				
			}
		}
	}
}

	public static void primsList(LinkedList<Integer>[] adjacencyList)
	{
		boolean[] b= new boolean[adjacencyList.length];
		int keys[]= new int[adjacencyList.length];
		int parents[]= new int[adjacencyList.length];
		for(int i=0;i<adjacencyList.length;i++)
		{
			b[i]=false;
			keys[i]=Integer.MAX_VALUE;
		}
		keys[0]=0;
		parents[0]=-1;
		for(int i=0;i<adjacencyList.length;i++)
		primsList(b,i,keys, parents,adjacencyList);
	}
	
	private static void primsList(boolean[] b, int i, int[] keys, int[] parents, LinkedList<Integer>[] adjacencyList) {
		
		int min=minimum(keys,b);
		b[min]=true;
		
		Iterator<Integer> it=adjacencyList[min].iterator();
		while(it.hasNext())
		{
			int d= it.next();
			if(b[d]==false && d<keys[d])
			{
				keys[d]=d;
				primsList(b, d, keys, parents, adjacencyList);;
				
			}
		}
		
		
	}

	public void topologicalsorting(LinkedList<Integer>[] adjacencyList)
	{
		boolean[] b= new boolean[adjacencyList.length];
		Stack<Integer> st= new Stack<Integer>();
		
		for(int i=0;i<adjacencyList.length;i++)
		{
		
				topoUtil(i,b,st,adjacencyList);
			
		}
	}
	
	private void topoUtil(int i, boolean[] b, Stack<Integer> st, LinkedList<Integer>[] adjacencyList) {

		Iterator<Integer> it= adjacencyList[i].iterator();
		while(it.hasNext())
		{
			int d=it.next();
			
			{
				topoUtil(d, b, st, adjacencyList);
			}
		}
		st.push(i);
		
	}

	private static void DFSutility(boolean[] b, int i, LinkedList<Integer>[] adjacencyList) {
		b[i] = true;

		System.out.println("value without " + i);
		Iterator<Integer> it = adjacencyList[i].iterator();
		while (it.hasNext()) {
			int d = it.next();
			if (b[d] == false && d == 1) {
				DFSutility(b, d, adjacencyList);
			}
		}
	}

	public void BFS(int[][] m) {
		boolean b[] = new boolean[m.length];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < m.length; i++) {
			b[i] = false;
		}

		for (int i = 0; i < m.length; i++) {
			if (b[i] == false)
				q.add(i);
			BFS(b, i, m, q);
		}
	}

	private void BFS(boolean[] b, int i, int[][] m, Queue<Integer> q) {

		int d = q.poll();
		b[d] = true;
		System.out.println("bfs value.." + d);

		for (int j = 0; j < m.length; j++) {
			if (b[i] == false) {
				BFS(b, i, m, q);
			}
		}

	}

	private void countIslands(int[][] m) {

		boolean b[] = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			b[i] = false;
		}

		for (int i = 0; i < m.length; i++) {
			if (b[i] == false)
				DFS(b, i, m);
		}

	}

	private void DFS(boolean[] b, int i, int m[][]) {
		b[i] = true;
		System.out.println("value " + i);

		for (int j = 0; j < 5; j++) {
			if (b[j] == false && m[i][j] == 1) {
				DFS(b, j, m);
			}
		}

	}
}