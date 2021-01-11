package backtracking;

import java.util.LinkedList;

public class problem {

	static LinkedList<Integer>[]   DFS(int g[][])
	{

		int l =g[0].length;
		LinkedList<Integer> ar[] = new LinkedList[l]; ;
		for(int i=0;i<g.length;i++)
		{
			ar[i]= new LinkedList<Integer>();
		}
		
		for(int i=0;i<g.length;i++)
		{
			for(int j=0;j<g[0].length;j++)
			{
				if (g[i][j] == 1) { 
					ar[i].add(j);
                } 
			}
		}
		return ar;
	}
	static void printArrayList(LinkedList<Integer>[]adjListArray) {
// Print the adjacency list 
		for (int v = 0; v < adjListArray.length; v++) {
			System.out.print(v);
			for (int u=0;u<adjListArray[0].get(v);u++) {
				System.out.print(" -> "+adjListArray[v].get(u)); 
			}
			System.out.println();
		}
	}

// Driver Code 
	public static void main(String[] args) {
// Given Adjacency Matrix 
		int[][] a = { { 0, 0, 1 }, { 0, 0, 1 }, { 1, 1, 0 } };

// function to convert adjacency 
// list to adjacency matrix 
		LinkedList<Integer> adjListArray []= DFS(a);
		System.out.println("Adjacency List: ");

		printArrayList(adjListArray);
	}
}