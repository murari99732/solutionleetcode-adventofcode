package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import tree.Graph;
import tree.TreeValue;

public class Tree {
	static class Node {
		int data;
		int height;
		Node left;
		Node right;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(int data, int height, Node left, Node right) {
			super();
			this.data = data;
			this.height = height;
			this.left = left;
			this.right = right;
		}

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	static Node createNode(int data) {
		Node n = new Node(data);
		return n;

	}

	static void display(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		display(node.left);
		display(node.right);
	}

	static int sum(Node node) {
		if (node == null) {
			return 0;
		}

		return node.data + sum(node.left) + sum(node.right);
	}

	static int sum = 0;

	static void sumvalue(Node node) {
		if (node == null) {
			return;
		}

		sumvalue(node.left);
		sumvalue(node.right);
		sum = sum + node.data;
	}

	static int diff(Node node) {

		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int d = diff(node.left);
		int e = diff(node.right);
		return node.data - (d + e);

	}

	static int diif(Node node) {
		if (node == null) {
			return 0;
		}
		return node.data - diif(node.left) - diif(node.right);
	}

	static int getnumbernodes(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + getnumbernodes(node.left) + getnumbernodes(node.right);
	}

	static int getleafnodes(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int f = getleafnodes(node.left);
		int g = getleafnodes(node.right);
		return f + g;
	}

	static int getheight(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int f = getheight(node.left);
		int g = getheight(node.right);
		return 1 + Math.max(f, g);
	}

	static int printatlevel(Node node, int height) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int a = printatlevel(node.left, height);
		int b = printatlevel(node.right, height);
		if (a == height) {
			System.out.print(node.left.data + " ");
		}
		if (b == height) {
			System.out.println(node.right.data + " ");
		}
		return 1 + Math.max(a, b);
	}

	static void getlevel(Node node, int level, int count) {
		if (node == null) {
			return;
		}
		if (count == level) {
			System.out.print(node.data + " ");
		}
		getlevel(node.left, level + 1, count);
		getlevel(node.right, level + 1, count);

	}

	static void level(Node node) {
		if (node == null) {
			return;
		}
		int height = getheight(node);
		for (int i = 0; i < height; i++) {
			getlevel(node, 0, i);
			System.out.println();
		}
	}

	static void levelorder(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				Node n = q.poll();
				System.out.print(n.data + " ");
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
				size--;
			}
			System.out.println();
		}
	}

	static void reversetree(Node node) {
		if (node == null) {
			return;
		}
		int height = getheight(node);
		for (int i = height - 1; i >= 0; i--) {
			getlevel(node, 0, i);
			System.out.println();
		}

	}

	static void reversetreequeue(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		Stack<Node> st = new Stack<Tree.Node>();
		while (!q.isEmpty()) {
			Node n = q.poll();
			st.push(n);
			if (n.right != null) {
				q.add(n.right);
			}
			if (n.left != null) {
				q.add(n.left);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop().data + " ");
		}
	}

	static int count = 0;

	static void leftview(Node node, int data) {
		if (node == null) {
			return;
		}
		if (data == count) {
			System.out.println(node.data);
			count++;
		}
		leftview(node.right, data + 1);
		leftview(node.left, data + 1);
	}

	static void inorder(Node node) {
		Stack<Node> st = new Stack<Tree.Node>();
		st.push(node);
		while (!st.isEmpty()) {
			Node n = st.pop();
			System.out.print(n.data + " ");
			if (n.right != null) {
				st.push(n.right);
			}
			if (n.left != null) {
				st.push(n.left);
			}
		}
	}

	static void preorder(Node node) {
		Stack<Node> st = new Stack<Tree.Node>();
		st.push(node);
		while (node != null) {
			st.push(node);
			node = node.left;
		}

		while (!st.isEmpty()) {
			System.out.println("size::: " + st.size());
			System.out.println();

			System.out.print(st.pop().data + " ");
			Node p = st.peek();
			if (p.right != null) {
				st.push(p.right);
				Node temp = st.peek();
				while (temp != null) {
					st.push(temp.left);
					temp = temp.left;
				}
			}
		}

	}

	static void mirrortree(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			int data = node.left.data;
			node.left.data = node.right.data;
			node.right.data = data;
		}
		mirrortree(node.left);
		mirrortree(node.right);

	}

	static boolean identical(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		return node1.data == node2.data && identical(node1.left, node2.left) && identical(node1.right, node2.right);
	}

	static int getlevelNode(Node node, int data, int val) {
		if (node == null) {
			return -1;
		}
		if (node.data == data) {
			return val;
		}
		int a = getlevelNode(node.left, data, val + 1);
		int b = getlevelNode(node.right, data, val + 1);
		return a != -1 ? a : b;
	}

	static void printtop(Node node) {

		TreeMap<Integer, Integer> hashmap = new TreeMap<>();
		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.poll();

			hashmap.put(temp.height, temp.data);

			if (temp.left != null) {
				temp.left.height = temp.height - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = temp.height + 1;
				q.add(temp.right);
			}

		}
		System.out.println(hashmap);

	}

	public static void bottomView(Node node) {
		if (node == null) {
			return;
		}

		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;

			m.put(hd, temp.data);

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

	static void boundary(Node node) {
		bottomView(node);
		printtop(node);

	}

	static void verticalorder(Node node) {
		if (node == null) {
			return;
		}

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (map.containsKey(temp.height)) {
				ArrayList<Integer> ar = map.get(temp.height);
				ar.add(temp.data);
				map.put(temp.height, ar);
			} else {
				ArrayList<Integer> ar = new ArrayList<>();
				ar.add(temp.data);
				map.put(temp.height, ar);
			}
			if (temp.left != null) {
				temp.left.height = temp.height - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = temp.height + 1;
				q.add(temp.right);
			}
		}
		System.out.println(map);
		ArrayList<Integer> br = new ArrayList<>();
		for (Integer it : map.keySet()) {
			int sum = 0;
			for (int i = 0; i < map.get(it).size(); i++) {
				sum = sum + map.get(it).get(i);
			}
			br.add(sum);
		}
		System.out.println(br);

	}

	static void sumlevel(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		q.add(node);
		map.put(0, node.data);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			while (size > 0) {
				Node temp = q.poll();
				sum = sum + temp.data;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				size--;
			}
			map.put(level + 1, sum);
			level++;
		}
		System.out.println(map);
	}

	static boolean searchelement(Node node) {
		if (node == null) {
			return false;
		}
		if (node.data == 4) {
			return true;
		}
		boolean a = searchelement(node.left);
		boolean b = searchelement(node.right);

		return a || b;
	}

	static void printspiral(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();
		Queue<Node> p = new LinkedList<Tree.Node>();
		q.add(node);
		while (!p.isEmpty() || !q.isEmpty()) {
			while (!q.isEmpty()) {
				Node temp = q.poll();
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					p.add(temp.left);
				}
				if (temp.right != null) {
					p.add(temp.right);
				}
			}
			System.out.println();
			while (!p.isEmpty()) {
				Node temp = p.poll();
				System.out.print(temp.data + " ");
				if (temp.right != null) {
					q.add(temp.right);
				}
				if (temp.left != null) {
					q.add(temp.left);
				}
			}
			System.out.println();
		}
	}

	static boolean isormophic(Node first, Node sec) {
		if (first == null && sec == null) {
			return true;
		}
		if (first.left == sec.left && first.right == sec.right || first.left == sec.right && sec.left == first.right) {
			return true;
		}
		return isormophic(first.left, sec.left) || isormophic(first.right, sec.right);

	}

	static void getwidth(Node node, int width, int level) {
		if (node == null) {
			return;
		}
		if (width == level) {
			count++;
		}
		getwidth(node.left, width, level + 1);
		getwidth(node.right, width, level + 1);
	}

	static Node prev = null;

	static void doubletree(Node node) {
		if (node == null) {
			return;
		}
		doubletree(node.left);

		doubletree(node.right);
		Node pt = createNode(node.data);
		pt.left = node.left;
		node.left = pt;

	}

	static Node createbinarytree(int pre[], int ino[], int i, int j) {
		if (i > j) {
			return null;
		}
		Node curr = createNode(pre[i]);
		int index = getindex(ino, pre[i]);
		curr.left = createbinarytree(pre, ino, i, index);
		curr.right = createbinarytree(pre, ino, index + 1, j);
		return curr;
	}

	private static int getindex(int[] ino, int i) {
		int j = 0;
		for (j = 0; j < ino.length; j++) {
			if (ino[j] == i) {
				return j;
			}
		}
		return 0;
	}

	static int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int a = diameter(node.left);
		int b = diameter(node.right);
		if (Math.abs(a - b) < 2) {
			return Integer.MAX_VALUE;
		}
		return (a > b ? a : b) + 1;
	}

	static void checksum(Node node, ArrayList<Integer> ar, int sum) {
		if (node == null) {
			return;
		}
		ar.add(node.data);
		sum = sum + node.data;
		if (node.left == null && node.right == null)
			if (sum == 11) {
				System.out.println(ar);
				System.out.println("found");
			}
		checksum(node.left, ar, sum);
		checksum(node.right, ar, sum);
		ar.remove(ar.size() - 1);
		sum = sum - node.data;
	}

	static void checksummanually(Node node, int sum) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (sum + node.data == 11) {
				System.out.println("dound");
			}
		}
		checksummanually(node.left, sum + node.data);
		checksummanually(node.right, sum + node.data);
	}

	static void printallpath(Node node, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}
		ar.add(node.data);
		if (node.left == null && node.right == null) {
			System.out.println(ar);
		}
		printallpath(node.left, ar);
		printallpath(node.right, ar);
		ar.remove(ar.size() - 1);
	}

	static void printallpatharray(Node node, int arr[], int i) {
		if (node == null) {
			return;
		}
		arr[i] = node.data;
		if (node.left == null && node.right == null) {
			Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

		}
		printallpatharray(node.left, arr, i + 1);
		printallpatharray(node.right, arr, i + 1);
	}

	static void maximumsum(Node node, ArrayList<Integer> ar, int sum) {
		if (node == null) {
			return;
		}
		ar.add(node.data);
		sum = sum + node.data;
		if (node.left == null && node.right == null) {
			count = Math.max(count, sum);
			System.out.println(ar);
		}
		maximumsum(node.left, ar, sum);
		maximumsum(node.right, ar, sum);
		ar.remove(ar.size() - 1);
		sum = sum - node.data;
	}

	static void getsumnumber(Node node, int sum) {
		if (node == null) {
			return;
		}
		sum = sum * 10 + node.data;
		if (node.left == null && node.right == null) {
			System.out.println(sum);
		}
		getsumnumber(node.left, sum);
		getsumnumber(node.right, sum);
		sum = sum / 10 - node.data;
	}

	static void minheight(Node node, int value) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			count = Math.min(count, value);

		}
		minheight(node.left, value + 1);
		minheight(node.right, value + 1);

	}

	static int d = 0;

	static void sumofallleaf(Node node, int sum) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sum = sum + node.data;
			d = d + node.data;
		}
		sumofallleaf(node.left, sum);
		sumofallleaf(node.right, sum);
	}

	static int suma = 0;

	static void reverseorder(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();
		Stack<Integer> st = new Stack<Integer>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			st.push(n.data);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}

	}

	static void inorderpart1(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();

		Stack<Node> st = new Stack<Node>();
		st.push(node);
		while (!st.isEmpty()) {
			Node n = st.pop();
			System.out.print(n.data + " ");
			if (n.right != null) {
				st.push(n.right);
			}
			if (n.left != null) {
				st.push(n.left);
			}
		}

	}

	static void preorderpart1(Node node) {
		Queue<Node> q = new LinkedList<Tree.Node>();
		Stack<Integer> st = new Stack<Integer>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			st.push(n.data);
			if (n.right != null) {
				q.add(n.right);
			}
			if (n.left != null) {
				q.add(n.left);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}

	}

	static void postorder1(Node node) {
		if (node == null) {
			return;
		}

	}

	private static void preordervalue(Node node) {
		if (node == null) {
			return;
		}
		preordervalue(node.left);
		preordervalue(node.right);

		System.out.print(node.data + " ");

	}

	static void mirrortreeval(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirrortree(node.left);
		mirrortree(node.right);
	}

	static void spiraltree(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> st = new Stack<Tree.Node>();
		st.push(node);
		Stack<Node> ts = new Stack<Tree.Node>();
		while (!st.isEmpty() || !ts.isEmpty()) {

			while (!st.isEmpty()) {
				Node temp = st.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					ts.push(temp.left);
				}
				if (temp.right != null) {
					ts.push(temp.right);
				}
			}

			while (!ts.isEmpty()) {
				Node temp = ts.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null) {
					st.push(temp.right);
				}
				if (temp.left != null) {
					st.push(temp.left);
				}
			}

		}
	}

	static void createdouble(Node node) {
		if (node == null) {
			return;
		}
		createdouble(node.left);
		createdouble(node.right);
		Node n = createNode(node.data);
		n.left = node.left;
		node.left = n;
	}

	static Node pretoino(int pre[], int in[], int start, int end) {
		if (start > end) {
			return null;
		}
		Node node = createNode(pre[count]);
		int index = getindex(pre[count], in, start, end);
		count = count + 1;
		node.left = pretoino(pre, in, start, index - 1);
		node.right = pretoino(pre, in, index + 1, end);

		return node;
	}

	private static int getindex(int i, int[] in, int start, int end) {
		for (int j = start; j < end; j++) {
			if (in[j] == i) {
				return j;
			}
		}
		return -1;
	}

	static int getdiamter(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int a = getdiamter(node.left);
		int b = getdiamter(node.right);
		count = Math.max(count, a + b) + 1;

		return Math.max(a, b) + 1;
	}

	static int heightbalance(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int a = heightbalance(node.left);
		int b = heightbalance(node.right);
		if (a == -1 || b == -1) {
			return -1;
		}
		if (Math.abs(a - b) > 2) {
			System.out.println("imbalance");
			return -1;
		}
		return Math.max(a, b) + 1;
	}

	static void checkifroot(Node node, int sum, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}
		ar.add(node.data);

		if (node.left == null && node.right == null) {
			System.out.println(ar);
		}
		checkifroot(node.left, sum, ar);
		checkifroot(node.right, sum, ar);
		ar.remove(ar.size() - 1);

	}

	static void sumtree(Node node, int sum) {
		if (node == null) {
			return;
		}
		sum = sum * 10 + node.data;
		if (node.left == null && node.right == null) {
			System.out.println(sum);
		}
		sumtree(node.left, sum);
		sumtree(node.right, sum);
	}

	static int minheight(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int a = minheight(node.left);
		int b = minheight(node.right);
		return Math.max(a, b) + 1;
	}

	static int getsumofallleaf(Node node) {
		if (node == null) {
			return -1;
		}
		if (node.left == null && node.right == null) {
			System.out.println(" leaf: " + node.data);
			return node.data;
		}
		int a = getsumofallleaf(node.left);
		int b = getsumofallleaf(node.right);
		if (node.left != null && node.right != null) {
			int bc = a != -1 ? a : 0;
			int cd = b != -1 ? b : 0;
			return bc + cd;
		}
		int bc = a != -1 ? a : 0;
		int cd = b != -1 ? b : 0;
		return bc + cd;

	}

	static void sumofleft(Node node, boolean flag, int sum, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}
		if (flag == true) {
			ar.add(node.data);
			sum = sum + node.data;
		}
		if (node.left == null && node.right == null && flag == true) {
			System.out.println(ar + " sum-> " + sum);
		}
		sumofleft(node.left, true, sum, ar);
		sumofleft(node.right, false, sum, ar);
		if (flag == true) {
			ar.remove(ar.size() - 1);
		}

	}

	static void checksumofleaf(Node node, int level) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (count == 0) {
				count = level + 1;
			} else if (count != level + 1) {
				System.out.println(false);
			}
		}
		checksumofleaf(node.left, level + 1);
		checksumofleaf(node.right, level + 1);

	}

	static void deepestleftNode(Node node, boolean flag, int level) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && flag == true && level % 2 != 0) {
			count = Math.max(count, level);
		}
		deepestleftNode(node.left, true, level + 1);
		deepestleftNode(node.right, false, level + 1);
	}

	static int removeallnode(Node node, int level) {
		if (node == null) {
			return 0;
		}
		int n = removeallnode(node.left, level + 1);
		int m = removeallnode(node.right, level + 1);
		if (node.left == null && node.right == null && level == 4) {
			return 1;
		} else if (node.left == null && node.right == null && level < 4) {
			node = null;
			return 0;
		}

		if (m == 0) {
			node.right = null;
			return 0;
		}
		if (n == 0) {
			node.left = null;
			return 0;
		} else {
			return 1;
		}
	}

	static int removesum(Node node, int sum) {
		if (node == null) {
			return -1;
		}
		int a = removesum(node.left, sum + node.data);
		int b = removesum(node.right, sum + node.data);
		if (node.left == null && node.right == null && sum > 5) {
			return sum;
		} else if (node.left == null && node.right == null && sum < 5) {
			node = null;
			return -1;
		} else if (a == -1) {
			node.left = null;
			return -1;
		} else if (b == -1) {
			node.right = null;
			return -1;
		} else {
			return sum;
		}
	}

	static void givensequence(Node node, int arr[], int i) {
		if (node == null) {
			return;
		}
		if (node.data != arr[i]) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (i == arr.length - 1) {
				System.out.println(true);
			}
		}
		givensequence(node.left, arr, i + 1);
		givensequence(node.right, arr, i + 1);
	}

	static void givensequncelist(Node node, ArrayList<Integer> ar, ArrayList<Integer> br) {
		if (node == null) {
			return;
		}
		ar.add(node.data);
		if (node.left == null && node.right == null) {
			if (ar.equals(br)) {
				System.out.println("found");
			}
		}
		givensequncelist(node.left, ar, br);
		givensequncelist(node.right, ar, br);
		ar.remove(ar.size() - 1);
	}

	static Node ancestor(Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == 9) {
			return node;
		}
		Node a = ancestor(node.left);
		Node b = ancestor(node.right);
		if (a != null) {
			node.right = null;
			return node;
		} else if (b != null) {
			node.left = null;
			return node;
		}

		return a != null ? a : b;
	}

	static Node ancestorvalue(Node node, ArrayList<Integer> ar) {
		if (node == null) {
			return null;
		}
		if (node.data == 8) {
			return node;
		}
		Node a = ancestorvalue(node.left, ar);
		Node b = ancestorvalue(node.right, ar);
		if (a != null) {
			ar.add(node.data);
			return a;
		} else if (b != null) {
			ar.add(node.data);
			return b;
		}
		return a != null ? a : b;
	}

	static boolean flag = false;

	static Node parenttree(Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == 8) {
			return node;
		}
		Node a = parenttree(node.left);
		Node b = parenttree(node.right);
		if (a != null && flag == false) {

			flag = true;
			return node;
		} else if (b != null && flag == false) {
			flag = true;
			return node;
		} else if (a != null) {
			node.data = a.data;
			return node;
		} else if (b != null) {
			node.data = b.data;
			return node;
		}
		return a != null ? a : b;
	}

	static Node sibling(Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == 4) {
			return node;
		}
		if (node.data == 5) {
			return node;
		}
		Node a = sibling(node.left);
		Node b = sibling(node.right);
		if (a != null && b != null) {
			System.out.println("found");
			return null;
		}
		return a != null ? a : b;
	}

	static void siblingnot(Node node, int first, int sec) {
		int heightf = getlevel(node, first);
		int heighs = getlevel(node, sec);
		if (heightf != heighs) {
			System.out.println("No not sibling");
			return;
		} else {
			getsiblig(node, first, sec, heighs);
		}
	}

	private static int getsiblig(Node node, int first, int sec, int heighs) {
		if (node == null) {
			return 0;
		}
		if (node.data == first) {
			return node.data;
		}
		if (node.data == sec) {
			return node.data;
		}
		int a = getsiblig(node.left, first, sec, heighs + 1);
		int b = getsiblig(node.right, first, sec, heighs + 1);
		if (a != 0) {
			if (node.right.data != sec) {
				System.out.println("found");
			} else {
				System.out.println("sibling");
			}

		} else if (b != 0) {
			if (node.left.data != first) {
				System.out.println("found");
			} else {
				System.out.println("sibling");
			}
		}
		return a != 0 ? a : b;

	}

	private static int getlevel(Node node, int first) {
		if (node == null) {
			return 0;
		}
		if (node.data == first) {
			return first + 1;
		}
		int a = getlevel(node.left, first + 1);
		int b = getlevel(node.right, first + 1);
		if (a != 0) {
			return a;
		} else if (b != 0) {
			return b;
		}
		return a != 0 ? a : b;
	}

	static Node lca(Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == 9) {
			return node;
		}
		if (node.data == 7) {
			return node;
		}
		Node a = lca(node.left);
		Node b = lca(node.right);
		if (a != null && b != null) {
			System.out.println(node.data);
			return node;
		}
		return a != null ? a : b;
	}

	static void distancebetween(Node node, int a, int b) {
		Node node1 = lca(node);
		display(node1);
		int height = getlevelheight(node1, a, 0);
		int heighta = getlevelheight(node1, b, 0);
		System.out.println(height + " " + heighta);
	}

	private static int getlevelheight(Node node1, int b, int level) {
		if (node1 == null) {
			return 0;
		}
		if (node1.data == b) {
			return level;
		}
		int a = getlevelheight(node1.left, b, level + 1);
		int c = getlevelheight(node1.right, b, level + 1);
		return a != 0 ? a : c;
	}

	static void printallnode(Node node, int level) {
		if (node == null) {
			return;
		}
		if (level + 1 == 2) {
			System.out.println(node.data);
		}
		printallnode(node.left, level + 1);
		printallnode(node.right, level + 1);
	}

	static int printall(Node node, int level) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {

			return 1;
		}
		int a = printall(node.left, level);
		int b = printall(node.right, level);
		if (a == 1) {
			System.out.println(node.data);
		}
		if (b == 1) {
			System.out.println(node.data);
		}
		if (a > 0) {

			return a + 1;
		}
		if (b > 0) {
			return b + 1;
		}
		return a > 0 ? a : b;
	}

	static void printkdistance(Node node, int k) {
		Node f = node;
		Node n = getNodefromN(node, k);
		display(n);
		leveldisplay(n, 0);
		System.out.println();
		display(f);

	}

	private static int printbefore(Node f, int data, int level) {

		if (f == null) {
			return -1;
		}
		if (f.data == data) {
			return 0;
		}
		int a = printbefore(f.left, data, level);
		int b = printbefore(f.right, data, level);
		if (a != -1) {
			if (level == 1) {
				System.out.println(f.data);
			} else {

			}
		}
		if (b != -1) {
			if (level == 1) {
				System.out.println(f.data);
			}
		}
		return -1;
	}

	private static void leveldisplay(Node n, int i) {
		if (n == null) {
			return;
		}
		if (i == 2) {
			System.out.print(n.data + " ");
		}
		leveldisplay(n.left, i + 1);
		leveldisplay(n.right, i + 1);

	}

	private static Node getNodefromN(Node node, int k) {
		if (node == null) {
			return null;
		}
		if (node.data == k) {
			return node;
		}
		Node a = getNodefromN(node.left, k);
		Node b = getNodefromN(node.right, k);
		if (a != null) {
			return a;
		}
		if (b != null) {
			return b;
		}
		return null;
	}

	static void leafnode(Node node, int data) {
		int d = getleeafnode(node, data, 0);
		System.out.println(d);

	}

	private static int getleeafnode(Node node, int data, int level) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}

		int a = getleeafnode(node.left, data, level);
		int b = getleeafnode(node.right, data, level);
		if (node.data == data) {
			System.out.println(a);
			System.out.println(b);
		}
		if (a != -1) {
			return a + 1;
		}
		if (b != -1) {
			return b + 1;
		}
		return -1;

	}

	static void nodesumevalue(Node node, int summ, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}
		sum = sum + node.data;
		ar.add(node.data);
		if (node.left == null && node.right == null) {
			if (sum > 9) {
				System.out.println(ar);
			}
		}
		nodesumevalue(node.left, summ, ar);
		nodesumevalue(node.right, summ, ar);
		ar.remove(ar.size() - 1);
	}

	static Node averageofeachlevel(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return node;
		}
		Node a = averageofeachlevel(node.left);
		Node b = averageofeachlevel(node.right);

		int dc = a != null ? a.data : 0;
		int bc = b != null ? b.data : 0;
		node.data = (dc + bc) / 2;

		return node;
	}

	static void sumpathprint(Node node, int sum, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}

		ar.add(node.data);
		sumpathprint(node.left, sum, ar);
		sumpathprint(node.right, sum, ar);
		sum = 0;
		for (int i = ar.size() - 1; i >= 0; i--) {
			sum = sum + ar.get(i);
			if (sum == 6) {
				for (int j = i; j < ar.size(); j++) {
					System.out.print(ar.get(j) + " ");
				}
			}
		}
		ar.remove(ar.size() - 1);
	}

	static int maximumsum(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int a = maximumsum(node.left);
		int b = maximumsum(node.right);
		int maxone = Math.max(node.data, a + b + node.data);
		count = Math.max(count, maxone);
		return Math.max(a, b) + node.data;
	}

	static int sumbetweentwoleaf(Node node, int sum, ArrayList<Integer> ar) {
		if (node == null) {
			return 0;
		}
		ar.add(node.data);
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int a = sumbetweentwoleaf(node.left, sum, ar);
		int b = sumbetweentwoleaf(node.right, sum, ar);
		if (a != 0 || b != 0) {
			System.out.println(ar);
		}
		ar.remove(ar.size() - 1);

		return node.data;
	}

	static void leafpr(Node node, ArrayList<Integer> ar) {
		if (node == null) {
			return;
		}
		ar.add(node.data);
		if (node.left == null && node.right == null) {
			System.out.println(ar);
		}
		leafpr(node.left, ar);
		leafpr(node.right, ar);
		ar.remove(ar.size() - 1);
	}

	static void leafn(Node node) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar = getleafval(node, ar);
		int max = 0;
		for (int i = 0; i < ar.size(); i++) {
			for (int j = 0; j < ar.size(); j++) {
				max = Math.max(max, getheightleaf(node, ar.get(i), ar.get(j)));
			}
		}
		System.out.println(max);
		System.out.println(ar);
	}

	private static int getheightleaf(Node node, Integer a, Integer b) {
		Node n = getlca(node, a, b);
		int dis1 = getdistance(n, a, 0);
		int dis2 = getdistance(n, b, 0);
		count = Math.max(count, dis1 + dis2);

		return count;
	}

	private static int getdistance(Node node, Integer a, int level) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int b = getdistance(node.left, a, level);
		int c = getdistance(node.right, a, level);

		if (flag == true) {
			return Math.min(a, b);
		}
		if (node.data == a) {
			flag = true;
			return Math.min(c, b) + 1;
		}

		return Math.min(b, c) + 1;
	}

	private static Node getlca(Node node, Integer a, Integer b) {
		if (node == null) {
			return null;
		}
		if (node.data == a) {
			return node;
		}
		if (node.data == b) {
			return node;
		}
		Node cd = getlca(node.left, a, b);
		Node bc = getlca(node.right, a, b);
		if (cd != null && bc != null) {
			return node;
		}
		return cd != null ? cd : bc;
	}

	private static ArrayList<Integer> getleafval(Node node, ArrayList<Integer> ar) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			ar.add(node.data);
		}
		getleafval(node.left, ar);
		getleafval(node.right, ar);
		return ar;
	}

	static void checksub(Node node) {

		String a = checktree(node);
		System.out.println(b);
	}

	static String b = "";

	private static String checktree(Node node) {
		if (node == null) {
			return "";
		}
		b = b + node.data;
		checktree(node.left);
		checktree(node.right);
		return b;
	}

	static boolean nodecheck(Node node, Node sub) {
		if (node == null) {
			return false;
		}
		boolean flag = checkequal(node, sub);
		return nodecheck(node.left, sub) || nodecheck(node.right, sub);
	}

	private static boolean checkequal(Node node, Node sub) {
		if (node == null && sub == null) {
			return true;
		}
		if (node == null || sub == null) {
			return false;
		}

		return checkequal(node.left, sub.left) || checkequal(node.right, sub.right);
	}

	static void dbms(Node node) {
		Queue<Node> r = new LinkedList<Tree.Node>();
		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		while (!q.isEmpty()) {

			int size = q.size();
			while (size > 0) {
				Node p = q.poll();
				while (p != null) {
					System.out.print(p.data + " ");
					if (p.left != null) {
						q.add(p.left);
					}
					p = p.right;

				}
				size--;
			}
			System.out.println();

		}

	}

	static Node checksum(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return node;
		}
		Node a = checksum(node.left);
		Node b = checksum(node.right);
		if (b != null && a != null) {
			if (a.data + b.data == node.data) {
				node.data = node.data + a.data + b.data;
				return node;
			}
		} else if (b != null) {
			if (b.data == node.data) {
				node.data = node.data + b.data;
				return node;
			}
		} else if (a != null) {
			if (a.data == node.data) {
				node.data = node.data + a.data;
				return node;
			}
		}

		return null;

	}

	static Node checksumbelowchild(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return node;
		}
		Node a = checksumbelowchild(node.left);
		Node b = checksumbelowchild(node.right);
		if (a != null && b != null) {
			if (a.data + b.data == node.data) {
				return node;
			}
		} else if (a != null) {
			if (a.data == node.data) {
				return node;
			}
		} else if (b != null) {
			if (b.data == node.data) {
				return node;
			}
		}

		return null;

	}

	static int max = 0;

	static int sumleaf(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int a = sumleaf(node.left);
		int b = sumleaf(node.right);
		max = Math.max(a + b + node.data, max);
		return Math.max(a, b) + node.data;
	}

	static void nextpoiner(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			int size = q.size();
			Node prev = null;
			while (size > 0) {
				Node n = q.poll();
				if (prev != null) {
					prev.right = node;
				}
				prev = node;

				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
				size--;
			}
		}

	}

	static void getrightnode(Node node, boolean flag, int data) {

		if (node == null) {
			return;
		}
		if (node.data == data && flag == true) {
			System.out.println("found");
		}
		getrightnode(node.left, false, data);
		getrightnode(node.right, true, data);

	}

	static void connect(Node node) {
		if (node == null) {
			return;
		}
		connect(node.left);
		if (prev != null) {
			prev.right = node;
		}
		prev = node;
		connect(node.right);
	}

	static void convertbinary(Node node) {
		if (node == null) {
			return;
		}

		convertbinary(node.left);
		if (prev == null) {
			prev = node;
		} else {
			prev.left = node;
			prev = node;
		}
		if (node.right != null) {
			node.right = prev;
		}

		convertbinary(node.right);

	}

	static void closetleaf(Node node) {
		Node head = node;
		int height = getNode(node, 3, 0);
		ArrayList<Integer> br = new ArrayList<Integer>();
		flag = false;
		getparent(node, 3, br);
		System.out.println(br);

	}

	private static Node getparent(Node node, int i, ArrayList<Integer> ar) {
		if (node == null) {
			return null;
		}

		Node a = getparent(node.left, i, ar);
		Node b = getparent(node.right, i, ar);
		if (flag == true && a != null) {
			ar.add(node.data);
			return node;
		}
		if (flag == true && b != null) {
			ar.add(node.data);
			return node;
		}
		if (node.data == i) {
			flag = true;
			ar.add(node.data);
			return node;
		}
		return a != null ? a : b;

	}

	private static int getNode(Node node, int i, int level) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int a = getNode(node.left, i, level);
		int b = getNode(node.right, i, level);
		if (flag == true) {
			return Math.min(a, b);
		}
		if (node.data == i) {
			flag = true;
			return Math.min(a, b) + 1;
		}

		return Math.min(a, b) + 1;
	}

	static Node createbinary(Node node, int value) {
		if (node.data < value) {
			prev = node;
			node.left = createbinary(node.left, value);
		} else if (node.data > value) {
			prev = node;
			node.right = createbinary(node.right, value);
		} else {
			if (node.left == null && node.right == null) {
				if (prev.left == node) {
					prev.left = null;
				} else if (prev.right == node) {
					prev.right = null;
				}

			} else if (node.left == null) {

				Node temp = node.right;
				prev.right = temp;
				node.right = null;
			} else if (node.right == null) {
				Node temp = node.left;
				prev.left = temp;
				node.left = null;

			} else {
				Node temp = getprior(node);
				node.data = temp.data;
				prev.right = node;
				prev = node;
				node.right = createbinary(node.left, node.data);
			}
		}
		return node;
	}

	private static Node getprior(Node node) {
		if (node.right != null) {
			node = node.right;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	static boolean checkvalueexist(Node node, int value) {
		if (node == null) {
			return false;
		}
		if (node.data > value) {
			checkvalueexist(node.left, value);
		} else if (node.data < value) {
			checkvalueexist(node.right, value);
		} else {
			return true;
		}
		return checkvalueexist(node, value);
	}

	static void parentnode(Node node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			if (node.data > 2) {
				prev = node;
				node = node.left;
			} else if (node.data < 2) {
				prev = node;
				node = node.right;
			} else {
				System.out.println(prev.data);
			}
		}
	}

	static void inordervalue(Node node) {
		if (node == null) {
			return;
		}
		inordervalue(node.left);
		System.out.print(node.data + " ");
		inordervalue(node.right);
	}

	static void getinvalue(Node node, int data) {
		if (node == null) {
			return;
		}

		while (node != null) {
			if (node.data > data) {
				prev = node;
				node = node.left;
			} else if (node.data < data) {
				prev = node;
				node = node.right;
			} else {
				Node temp = getleft(prev);
				System.out.print(temp.data + " ");
				break;

			}
		}
	}

	static void findlca(Node node, int a, int b) {
		if (node == null) {
			return;
		}
		while (node != null) {
			if (node.data > a && node.data > b) {
				node = node.left;
			} else if (node.data < a && node.data < b) {
				node = node.right;
			} else {
				System.out.println(node.data);
				break;
			}
		}

	}

	private static Node getleft(Node prev2) {
		if (prev2.left != null) {
			prev = prev.left;
		}
		while (prev.right != null) {
			prev = prev.right;
		}
		return prev;
	}

	static void getkthsmallest(Node node) {
		if (node == null) {
			return;
		}

		getkthsmallest(node.left);
		count++;
		if (count == 3) {
			System.out.println(node.data);
		}
		getkthsmallest(node.right);
	}

	static Node headlinked = null;

	static void sorteddouble(Node node) {
		if (node == null) {
			return;
		}
		sorteddouble(node.left);
		if (headlinked == null) {
			headlinked = node;
			prev = headlinked;
		} else {
			prev.right = node;
			prev = node;
		}
		sorteddouble(node.right);

	}

	static void constructbst(int arr[]) {
		Arrays.sort(arr);
		Node n = createbstinorder(arr, 0, arr.length - 1);
		System.out.println();
		display(n);
	}

	private static Node createbstinorder(int[] arr, int i, int length) {
		if (i > length) {
			return null;
		}
		int mid = (i + length) / 2;
		Node n = createNode(arr[mid]);
		n.left = createbstinorder(arr, i, mid - 1);
		n.right = createbstinorder(arr, mid + 1, length);
		return n;

	}

	static void removebst(Node node, int dat2, int dat1) {
		if (node == null) {
			return;
		}
		while (node != null) {
			if (node.data > dat2) {

			}
		}
	}

	static Node displayleft(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return node;
		}
		Node a = displayleft(node.left);
		Node b = displayleft(node.right);
		if (a != null && b != null) {
			Node bc = createNode(node.data);
			bc.left = node.left;
			node.left = bc;

			return node;
		}
		if (a != null) {
			Node bc = createNode(a.data);
			a.left = bc;
			return a;
		}
		if (b != null) {
			Node bc = createNode(b.data);
			b.left = bc;
			return b;
		}
		return null;

	}

	static Node transformback(Node node) {
		if (node == null) {
			return null;
		}
		prev = node;
		Node a = transformback(node.left);
		Node b = transformback(node.right);
		if (a != null) {
			a.data = prev.data;
			a = a.left;
			return a;
		}
		if (b != null) {
			b.data = prev.data;
			b = b.left;
			return b;
		}
		return null;
	}

	static void pathsum(Node tree, int sum, HashMap<Integer, Integer> map) {
		if (tree == null) {
			return;
		}
		sum = sum + tree.data;
		if (map.containsKey(12 - sum)) {
			int target = map.get(12 - sum);
		}
		map.put(sum, map.get(0) + 1);
		pathsum(tree.left, sum, map);
		pathsum(tree.right, sum, map);

	}

	static void vertical(Node node) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		Queue<Node> q = new LinkedList<Tree.Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node val = q.poll();
			int height = val.height;
			if (map.containsKey(height)) {
				ArrayList<Integer> pr = map.get(height);
				pr.add(val.data);
			} else {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				ar.add(val.data);
				map.put(height, ar);
			}

			if (val.left != null) {
				val.left.height = height - 1;
				q.add(val.left);
			}
			if (val.right != null) {
				val.right.height = height + 1;
				q.add(val.right);
			}
		}
		System.out.println(map);

	}

	static Node bsttree(Node tree) {
		if (tree == null) {
			return null;
		}
		Node a = bsttree(tree.left);
		Node b = bsttree(tree.right);
		if (a != null && a.data < tree.data && b != null && b.data > tree.data) {
			tree.height = Math.max(a.height, b.height) + 1;
			return tree;
		} else if (a != null && a.data < tree.data && b == null) {
			tree.height = a.height + 1;
			return tree;
		} else if (b != null && b.data < tree.data && a == null) {
			tree.height = b.height + 1;
			return tree;
		} else {
			if (a != null && b != null) {
				tree.height = Math.max(a.height, b.height);
			} else if (a != null) {
				tree.height = a.height;
			} else if (b != null) {
				tree.height = b.height;
			}
			return tree;
		}
	}

	static int min = 0;

	static Node maximumbinarytree(Node node) {
		if(node==null)
		{
			return null;
		}
		Node a = maximumbinarytree(node.left);
		Node b = maximumbinarytree(node.right);
		if (a != null && b != null) {
			int bc = a.data + b.data;
			min = Math.max(bc, min);
			min = Math.max(min, bc + node.data);
			node.data = min;
			return node;
		} else if (a != null) {
			min=Math.max(min, node.data);
			min=Math.max(min, a.data);
			min = Math.max(min, a.data + node.data);
			node.height=min;
			return node;
		}
		else if(b!=null)
		{
			min=Math.max(min, node.data);
			min=Math.max(min, b.data);
			min = Math.max(min, b.data + node.data);
			node.height=min;
			return node;
		}
		else
		{
			min=Math.max(min, node.data);
			return node;
		}
	}

	
	
	public static void main(String[] args) {
		Node node = createNode(8);
		node.left = createNode(3);
		node.right = createNode(10);

		node.left.left = createNode(1);
		node.left.right = createNode(6);
		node.right.right = createNode(14);
		node.left.right.left = createNode(4);
		node.left.right.right = createNode(7);
		node.right.right.left = createNode(13);
		// node.left.left.left = createNode(8);
		Node a = maximumbinarytree(node);
		System.out.println(min);

	}

}
