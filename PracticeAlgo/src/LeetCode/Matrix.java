package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

	static void findval(int m[][], int val) {
		int j = 0;
		for (int i = m.length - 1; i >= 0; i--) {
			if (val < m[0][i]) {
				j = i;
			} else if (val == m[0][i]) {
				System.out.println("finalyy");
			}
		}
		for (int k = 0; k < m.length; k++) {
			if (val < m[k][j]) {

			}
		}
	}

	static void findvalue(int m[][], int value, int i, int j) {

		while (i < j) {
			int v = (i + j) / 2;
			if (m[0][v] > value) {
				j = v - 1;
			} else if (m[0][v] < value) {
				i = v + 1;
			} else {
				System.out.println(" found at " + m[0][v]);
				break;
			}
		}
		int k = m.length;
		int l = 0;
		while (l < k) {
			int v = (l + k) / 2;
			if (m[v][j] > value) {
				k = v - 1;
			} else if (m[v][j] < value) {
				l = v + 1;
			} else {
				System.out.println("found at" + m[v][j]);
				break;
			}
		}
		findvalue(m, value, l, j);

	}

	static void display(int m[][]) {
		int k = 0;
		Queue<Node> q = new LinkedList<Node>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 2) {
					q.add(new Node(i, j));

				}
			}
		}
		int md = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {

				Node n = q.poll();
				if (n.x - 1 >= 0 && m[n.x - 1][n.y] == 1) {
					m[n.x - 1][n.y] = 2;
					q.add(new Node(n.x - 1, n.y));
				}
				if (n.y - 1 >= 0 && m[n.x][n.y - 1] == 1) {
					m[n.x][n.y - 1] = 2;
					q.add(new Node(n.x, n.y - 1));
				}
				if (n.y + 1 < m.length && m[n.x][n.y + 1] == 1) {
					m[n.x][n.y + 1] = 2;
					q.add(new Node(n.x, n.y + 1));
				}
				if (n.x - 1 >= 0 && n.y - 1 >= 0 && m[n.x - 1][n.y - 1] == 1) {
					m[n.x - 1][n.y - 1] = 2;
					q.add(new Node(n.x - 1, n.y - 1));
				}
				size--;
			}
			md++;
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(md);
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static void printuniquerow(boolean b[][]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < b.length; i++) {
			String ab = "";
			for (int j = 0; j < b.length; j++) {
				if (b[i][j] == true) {
					ab = ab + 'a';
				} else {
					ab = ab + 'b';
				}
			}
			if (!map.containsKey(ab)) {
				map.put(ab, i);
			}
		}
		System.out.println(map.values());
	}

	static void printmatrix(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (i < j) {
					m[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void printspiral(int m[][]) {
		int rowstart = 0;
		int rowend = m.length;
		int coloumnstart = 0;
		int coloumnend = m.length;
		while (rowstart < rowend && coloumnstart < coloumnend) {
			if (coloumnstart < coloumnend) {
				for (int i = coloumnstart; i < coloumnend; i++) {
					System.out.print(m[rowstart][i] + " ");
				}
				rowstart = rowstart + 1;
			}
			if (rowstart < rowend) {
				for (int j = rowstart; j < rowend; j++) {
					System.out.print(m[j][coloumnend - 1] + " ");
				}
				coloumnend = coloumnend - 1;
			}

			if (coloumnstart < coloumnend) {
				for (int j = coloumnend - 1; j >= coloumnstart; j--) {
					System.out.print(m[rowend - 1][j] + " ");
				}
				rowend = rowend - 1;
			}
			if (rowstart < rowend) {
				for (int j = rowend - 1; j >= rowstart; j--) {
					System.out.print(m[j][coloumnstart] + " ");
				}
				coloumnstart = coloumnstart + 1;
			}
		}
	}

	static void rotate(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[j][i] + "  ");
			}
			System.out.println();
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[j][i] + " ");
			}
			System.out.println();
		}
	}

	static void multiply(int m[][], int n[][]) {
		if (m[0].length != n.length) {
			System.out.println(false);
			return;
		}
		int c[][] = new int[m.length][n[0].length];
		for (int k = 0; k < m.length; k++) {
			int v = 0;
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					c[k][j] = c[k][j] + m[k][i] * n[i][j];
				}
			}
		}
	}

	static void move90(int m[][]) {
		int i = 0;
		int j = 0;
		int k=0;
		int l=0;
		while(i<m.length && j<m.length)
		{
			if(m[i][j]==0)
			{
				k=i;
				l=j;
				j++;
			}else
			{
				if(k-i==0 &&l-j<0)
				{
					i++;
				}
			}
			
		}

	}

	public static void main(String[] args) {
		int m[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	}

}
