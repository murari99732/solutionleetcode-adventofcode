import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pepcoding {
	static class Edge {
		int src;
		int destination;
		int value;

		public Edge(int src, int destination, int value) {
			super();
			this.src = src;
			this.destination = destination;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		ArrayList<Pepcoding.Edge>[] ar = new ArrayList[10];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<Pepcoding.Edge>();
		}
		ar[0].add(new Pepcoding.Edge(0, 1, 36));
		ar[1].add(new Pepcoding.Edge(1, 2, 21));
		ar[2].add(new Pepcoding.Edge(3, 4, 41));
		ar[3].add(new Pepcoding.Edge(4, 5, 17));
		ar[4].add(new Pepcoding.Edge(5, 6, 14));
		ar[5].add(new Pepcoding.Edge(6, 7, 19));
		ar[6].add(new Pepcoding.Edge(7, 8, 14));
		ar[7].add(new Pepcoding.Edge(8, 9, 19));
		ar[8].add(new Pepcoding.Edge(9, 10, 19));
		ar[9].add(new Pepcoding.Edge(2, 3, 19));
		boolean b[] = new boolean[10];
		printallpath(ar, 0, 10, b, "");

	}

	static void smallestpath(ArrayList<Pepcoding.Edge>[] ar, int i, int count, boolean b[]) {
		if (i == ar.length - 1) {
			System.out.println(count);
			return;
		}
		b[i] = true;
		for (Edge a : ar[i]) {
			if (b[a.destination] == false) {
				smallestpath(ar, a.destination, count + 1, b);
			}
		}
		b[i] = false;
	}

	private static boolean dfs(ArrayList<Pepcoding.Edge>[] ar, int i, int j, String ans, boolean b[]) {

		if (i == ar.length - 1) {
			return false;
		}
		if (i == j) {
			return true;
		}

		b[i] = true;

		for (Edge arr : ar[i]) {
			if (b[arr.destination] == false) {

			}
		}

		return false;
	}

	static void bfs(ArrayList<Pepcoding.Edge>[] arr, int i, boolean b[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		while (!q.isEmpty()) {
			int d = q.poll();
			for (Edge e : arr[d]) {
				if (b[e.destination] == false) {
					q.add(e.destination);
				}
			}
		}
	}

	static void printgetstrongly(ArrayList<Pepcoding.Edge>[] ar) {
		boolean b[] = new boolean[ar.length];
		ArrayList<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < ar.length; i++) {
			if (b[i] == false) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				int count = 0;
				DFSUtility(ar, i, b, list, count);
				if (ar.length - 1 == count) {
					System.out.println(false);
					return;
				}

			}
		}

	}
	static void Dij(ArrayList<Edge>[] ar, String ans, int i,int count)
	{
		boolean b[]= new boolean[ar.length];
		PriorityQueue<Edge> p= new PriorityQueue<Edge>((a,c)-> {return c.value-a.value;});
		p.add(ar[0].get(0));
		while(!p.isEmpty())
		{
			Edge d=p.poll();
			b[d.src]=true;
			int des=d.destination;
			for(Edge edge:ar[des]);
			{
				if(b[des]==false)
				{
			
				}
			}
			
		}
		
	}

	private static void DFSUtility(ArrayList<Edge>[] ar, int i, boolean[] b, ArrayList<Integer> list, int count) {
		
		count=count+1;
		b[i] = true;
		list.add(i);
		for(Edge edge:ar[i])
		{
			if(b[edge.destination]==false)
			{
				DFSUtility(ar, edge.destination, b, list, count);
			}
		}

	}

	static void printallpath(ArrayList<Pepcoding.Edge>[] arr, int i, int j, boolean b[], String ans) {
		if (i == 9) {
			return;
		}
		if (i == j) {
			PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
			if (pr.size() > 3) {
				pr.add(i);
				pr.peek();
			} else {
				if (pr.peek() > i) {
					pr.poll();
					pr.add(i);
					System.out.println(pr.peek());
				}
			}
			System.out.print(ans + " ");
			return;
		}

		for (Edge ar : arr[i]) {
			if (b[ar.destination] == false) {
				b[ar.destination] = true;
				printallpath(arr, i, j, b, ans + ar.src + " ");
				printallpath(arr, ar.destination, j, b, ans);
				b[ar.destination] = false;
			}
		}
	}
}
