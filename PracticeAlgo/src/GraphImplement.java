import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StarNode {
	char c;
	boolean isVisited;

	public StarNode(char value) {
		c = value;
		isVisited = false;
	}

}

public class GraphImplement {
	LinkedList[] list = new LinkedList[10];
	StarNode star[];
	int m[][];
	int vertex = 20;
	Stack<Integer> st;
	int i = 0;

	public GraphImplement() {
		for (int i = 0; i < 10; i++) {
			list[i] = new LinkedList();
		}
		star = new StarNode[vertex];
		m = new int[vertex][vertex];
		st = new Stack<Integer>();
	}

	void addedgelinked(int start, int end) {
		list[start].add(end);
	}

	void addVertex(char value) {
		star[i++] = new StarNode(value);
	}

	void addedge(int start, int end) {
		m[start][end] = 1;
		m[end][start] = 1;
	}

	void DFS() {
		star[0].isVisited = true;
		st.push(0);
		while (!st.isEmpty()) {
			int d = st.peek();
			int f = getvalue(d);
			if (f == -1) {
				st.pop();
			} else {
				st.push(f);
				star[f].isVisited = true;
				display(f);
			}
		}
	}

	private int getvalue(int d) {
		for (int i = 0; i < 5; i++) {
			if (m[d][i] == 1 && star[i].isVisited == false) {
				return i;
			}
		}
		return -1;
	}

	void display(int i) {
		System.out.print(star[i].c + " ");
	}

	static void prison(Integer arr[], int v, int i) {
		if (i == v) {
			return;
		}
		int start = 1;

		while (start < arr.length - 1) {
			if (arr[start - 1] == 1 && arr[start + 1] == 1 || arr[start - 1] == 0 && arr[start + 1] == 0) {
				arr[start] = 1;
			} else if (arr[start - 1] == 0 && arr[start + 1] == 1 || arr[start - 1] == 1 && arr[start + 1] == 0) {
				arr[start] = 0;
			}
			start++;

		}

		prison(arr, v, i + 1);

	}

	static void levelordertraversal(TreeValue tree) {
		if (tree == null) {
			return;
		}
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size < 0) {
				TreeValue curr = queue.poll();
				System.out.print(curr.value + " ");
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				size--;
			}
		}
	}

	static TreeValue levelordertraverstall(TreeValue tree, int node) {
		if (tree == null) {
			return null;
		}
		if (tree.left == null && tree.right == null) {
			return tree;
		}
		levelordertraverstall(tree.left, node);
		levelordertraverstall(tree.right, node);
		return tree;
	}

	static void levelvalue(TreeValue tree) {
		if (tree == null) {
			return;
		}
		int height = getheight(tree);
		for (int i = height; i >= 0; i--) {
			printvalue(tree, i);
		}
	}

	private static void printvalue(TreeValue tree, int i2) {
		if (tree == null) {
			return;
		}
		if (i2 == 0) {
			System.out.print(tree.value + " ");
		}
		printvalue(tree.left, i2 - 1);
		printvalue(tree.right, i2 - 1);

	}

	private static int getheight(TreeValue tree) {
		if (tree == null) {
			return 0;
		}

		return 1 + Math.max(getheight(tree.left), getheight(tree.right));
	}

	static void mst(int m[][]) {
		boolean b[] = new boolean[m.length];
		int key[] = new int[m.length];
		int parent[] = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < m.length; i++) {
			int min = getmin(b, key, i);
			b[min] = true;
			for (int j = 0; j < m.length - 1; j++) {
				if (m[i][j] != 0 && b[j] == false && m[min][j] < key[j]) {
					key[j] = m[min][j];
					parent[min] = j;
				}
			}
		}
	}

	private static int getmin(boolean[] b, int[] key, int i2) {

		int j = 0;
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			if (key[i] < max && b[i] == false) {
				max = key[i];
				j = i;
			}
		}

		return j;
	}

	static int d = 0;

	static void arrangingcoins(int i, int j, int s, int value) {

		for (i = 0; i < value; i++) {
			d = d + 1;
			int e = d;
			while (e != 0) {
				s = s + 1;
				if (s == value) {
					System.out.println(i + " ");
					break;
				}
				e--;
			}

		}
	}

	static void arrangingcoins(int value) {

		int d = 0;
		for (int i = 0; i < value; i++) {
			int v = (i * (i + 1)) / 2;
			if (v < value) {
				d = v;
			}
			 if(v==value)
			{
				System.out.println(i);
				break;
			}
			 if(v>value)
			 {
				 System.out.println(i-1);
				 break;
			 }
		}

	}

	public static void main(String[] args) {
		arrangingcoins(15);

	}

}
