import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Stream;

class Node {
	int data;
	int height;
	Node left;
	Node right;
}

public class Tree {

	Node create(Node node, int v) {
		if (node == null) {
			node = createNewNode(v);
		} else {

		}
		return node;
	}

	private Node createNewNode(int v) {

		Node node = new Node();
		node.data = v;

		return node;
	}

	void inpost(Node n) {
		if (n == null) {
			return;
		}
		inpost(n.left);
		System.out.print(n.data + " ");
		inpost(n.right);
	}

	void prepost(Node n) {
		if (n == null) {
			return;
		}
		System.out.print(n.data + " ");
		prepost(n.left);

		prepost(n.right);
	}

	static void post(Node n) {
		if (n == null) {
			return;
		}

		post(n.left);

		post(n.right);
		System.out.print(n.data + " ");
	}

	void levelorder(Node n) {

		if (n == null) {
			return;
		}
		int size = getsize(n);

		for (int i = size; i > 0; i--) {
			printNode(n, i);
			System.out.println();
		}

	}

	void queuevalue(Node n) {
		if (n == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}

		}

	}

	void queueLevel(Node n) {
		if (n == null) {
			return;
		}
		Stack<Node> st = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		st.add(n);
		queue.add(n);
		while (!st.isEmpty()) {
			Node curr = queue.remove();
			System.out.print(curr.data + " ");
			if (curr.right != null) {
				st.push(curr.right);
				queue.add(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
				queue.add(curr.left);
			}
		}
		while (st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	private void printNode(Node n, int i) {
		if (n == null) {
			return;
		}
		if (i == 1) {
			System.out.print(n.data + " ");
			return;
		}
		printNode(n.left, i - 1);
		printNode(n.right, i - 1);

	}

	void leftSubTree(Node n) {
		if (n == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (q != null) {
			Node node = q.remove();
			System.out.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			} else {
				q.add(node.right);
			}
		}
	}

	static int getsize(Node n) {
		if (n == null) {
			return 0;
		}
		return Math.max(getsize(n.left), getsize(n.right)) + 1;
	}

	int maxlevel = 0;

	void leftview(Node n, int level) {
		if (n == null) {
			return;
		}
		if (maxlevel <= level) {
			maxlevel++;
			System.out.println(n.data);
		}
		leftview(n.right, level + 1);
		leftview(n.left, level + 1);
	}

	int f;

	int level1(Node n, int value, int level) {

		if (n == null) {
			return 0;
		}

		if (n.data == value) {
			System.out.println(true + " " + level);
			f = level;
		}
		level(n.left, value, level + 1);
		level(n.right, value, level + 1);
		return f;
	}

	static void topview(Node n) {
		if (n == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		queue.add(n);
		int d = 0;

		while (!queue.isEmpty()) {
			Node curr = queue.remove();
			int hd = curr.height;

			map.put(hd, curr.data);

			if (curr.left != null) {

				curr.left.height = hd - 1;

				queue.add(curr.left);
			}

			if (curr.right != null) {

				curr.right.height = hd + 1;

				queue.add(curr.right);
			}

		}
		System.out.println(map);

	}

	void boundary(Node n) {
		if (n == null) {
			return;
		}

		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node cur = q.remove();
			int hd = cur.height;
			if (!tree.containsKey(hd)) {
				tree.put(hd, cur.data);
			}
			if (cur.left == null && cur.right == null) {
				tree.put(cur.data, cur.data);
			}
			if (cur.left != null) {
				cur.left.height = hd - 1;
				q.add(cur.left);
			}
			if (cur.right != null) {
				cur.right.height = hd + 1;
				q.add(cur.right);
			}
		}

		System.out.println(tree);
	}

	static void sideLeft(Node n) {
		if (n == null) {
			return;
		}
		if (n.left != null) {
			System.out.println(n.data);
			sideLeft(n.left);

		} else if (n.right != null) {
			System.out.println(n.data);
			sideLeft(n.right);
		}

	}

	static void sideRight(Node n) {
		if (n == null) {
			return;
		}
		if (n.right != null) {
			System.out.println(n.data);
			sideRight(n.right);

		} else if (n.left != null) {
			System.out.println(n.data);
			sideRight(n.left);
		}

	}

	void vertically(Node n) {
		Queue<Node> q = new LinkedList<Node>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		q.add(n);
		while (!q.isEmpty()) {
			Node curr = q.remove();

			if (map.containsKey(curr.height)) {

				ArrayList<Integer> h = map.get(curr.height);
				h.add(curr.data);
				map.put(curr.height, h);

			} else {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				ar.add(curr.data);
				map.put(curr.height, ar);
			}
			if (curr.right != null) {
				curr.right.height = curr.height - 1;
				q.add(curr.right);
			}
			if (curr.left != null) {
				curr.left.height = curr.height + 1;
				q.add(curr.left);
			}

		}
		for (Entry<Integer, ArrayList<Integer>> ar : map.entrySet()) {
			ArrayList<Integer> arr = ar.getValue();
			int sum = 0;
			for (int i = 0; i < arr.size(); i++) {
				sum = sum + arr.get(i);

			}
			System.out.println(ar.getKey() + " " + sum);
		}

	}

	static void leftview1(Node n, int level) {
		Queue<Node> q = new LinkedList<Node>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		q.add(n);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (!map.containsKey(curr.height)) {
				map.put(curr.height, curr.data);
			}
			if (curr.left != null) {
				curr.left.height = curr.height - 1;
				q.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.height = curr.height + 1;
				q.add(curr.right);
			}
		}
		System.out.println(map);
	}

	static int h = 0;

	static void rightview(Node node, int level) {
		if (node == null) {
			return;
		}
		if (h <= level) {
			System.out.print(node.data + " ");
			h++;
		}
		rightview(node.right, level + 1);
		rightview(node.left, level + 1);
	}

	static void inorder(Node node) {
		Stack<Node> st = new Stack<Node>();
		while (node != null) {
			st.add(node);
			System.out.println(node.data);
			node = node.left;
		}

		while (!st.isEmpty()) {
			Node curr = st.pop();

			if (curr.right != null) {
				Node temp = curr.right;
				while (temp != null) {
					st.push(temp);
					System.out.println(temp.data);
					temp = temp.left;
				}
			}
		}
	}

	static void postorder(Node node) {
		Stack<Node> st = new Stack<Node>();
		Stack<Node> stack = new Stack<Node>();
		st.add(node);
		while (!st.isEmpty()) {
			Node curr = st.pop();

			if (curr.right != null) {
				st.add(curr.right);
			}
			if (curr.left != null) {
				st.add(curr.left);
			}
			stack.push(curr);
		}
		while (!stack.isEmpty()) {
			Node node1 = stack.pop();
			System.out.println(node1.data);
		}
	}

	static int g = 0;

	static int level(Node node, int level, int de) {
		if (node == null) {
			return 0;
		}
		if (node.data == level) {
			g = de;
		}
		level(node.left, level, de + 1);
		level(node.right, level, de + 1);
		return g;
	}

	static void levelMost(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		q.add(node);
		while (!q.isEmpty()) {
			Node curr = q.poll();

			map.put(curr.height, curr.data);

			if (curr.left != null) {
				curr.left.height = curr.height - 1;
				q.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.height = curr.height + 1;
				q.add(curr.right);
			}
		}
		System.out.println(map);
	}

	static void boundary1(Node node) {
		printLeft(node, 0);
		printright(node, 0);
	}

	static int max = 0;

	private static void printLeft(Node node, int i) {
		if (node == null) {
			return;
		}
		if (i >= max) {
			System.out.print(node.data + " ");
			max++;
		}
		printLeft(node.left, i + 1);
		printLeft(node.right, i + 1);

	}

	static int min = 0;

	private static void printright(Node node, int i) {
		if (node == null) {
			return;
		}
		if (i >= min) {
			System.out.print(node.data + " ");
			min++;
		}
		printright(node.right, i + 1);
		printright(node.left, i + 1);

	}

	static void vertical(Node node) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (!map.containsKey(curr.height)) {
				ArrayList<Integer> ar = new ArrayList<>();
				ar.add(curr.data);
				map.put(curr.height, ar);
			} else {
				ArrayList<Integer> ar = map.get(curr.height);
				ar.add(curr.data);
				map.put(curr.height, ar);

			}

			if (curr.left != null) {
				curr.left.height = curr.height - 1;
				queue.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.height = curr.height + 1;
				queue.add(curr.right);
			}
		}
	}

	static void sumLevel(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node pd = new Node();
		pd.data = -1;

		queue.add(pd);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int f = 0;
		int sum = 0;
		while (!queue.isEmpty()) {

			Node curr = queue.poll();
			if (curr.data > 0) {
				sum++;
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			} else {
				f = Math.max(f, sum);
				sum = 0;
				if (!queue.isEmpty()) {
					queue.add(pd);
				}
			}

		}
		System.out.println(f);
	}

	static void spiral(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node pd = new Node();
		pd.data = -1;
		while (!queue.isEmpty()) {

			Node curr = queue.poll();
			if (curr.data > 0) {

				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			} else {

				if (!queue.isEmpty()) {
					queue.add(pd);
				}
			}

		}
	}

	static void spiral1(Node n) {
		Stack<Node> st = new Stack<Node>();
		Stack<Node> st1 = new Stack<Node>();
		st.add(n);
		System.out.println();
		while (!st.isEmpty() || !st1.isEmpty()) {
			while (!st.isEmpty()) {
				Node curr = st.pop();
				System.out.print(curr.data + " ");

				if (curr.left != null) {
					st1.push(curr.left);
				}
				if (curr.right != null) {
					st1.push(curr.right);
				}
			}
			System.out.println();
			while (!st1.isEmpty()) {
				Node curr = st1.pop();
				System.out.print(curr.data + " ");

				if (curr.right != null) {
					st.push(curr.right);
				}
				if (curr.left != null) {
					st.push(curr.left);
				}
			}
			System.out.println();
		}
	}

	static void print(Node node, int d, int e) {
		int f = 0;
		System.out.println();
		for (int i = d; i <= e; i++) {
			d = 0;
			f = Math.max(f, print(node, i));
			System.out.println(f);
		}
		System.out.println(f);
	}

	static int d = 0;

	private static int print(Node node, int i) {
		if (node == null) {
			return 0;
		}
		if (i == 1) {
			d++;

		}
		print(node.left, i - 1);
		print(node.right, i - 1);
		return d;
	}

	public void printBetweenTwoLevels(Node node, int min, int max) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int l = 1;

		while (true) {
			int size = q.size();
			if (size == 0 || l > max) {
				break;
			}
			while (size > 0) {
				Node t = q.remove();
				if (l >= min && l <= max) {
					System.out.print(t.data + " ");
				}
				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}
			l++;
		}
	}

	static int mirrorstructre(Node node, int level) {

		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		}
		return mirrorstructre(node.left, level - 1) + mirrorstructre(node.right, level - 1);

	}

	static void createdoubletree(Node node) {
		if (node == null) {
			return;
		}
		createdoubletree(node.left);
		createdoubletree(node.right);

	}

	static int heightiterative(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int height = 0;
		while (true) {
			int size = q.size();
			if (size == 0) {
				return 0;
			}
			while (size > 0) {
				Node t = q.remove();
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
				size--;
			}
			height = height + 1;

		}

	}

	void diameter(Node node) {
		if (node == null) {
			return;
		}
		int n = getsize(node.left);
		int m = getsize(node.right);
		diameter(node.left);
		diameter(node.left);
		System.out.println(n + m);
	}

	boolean heightBalance(Node n) {
		if (n == null) {
			return true;
		}

		heightBalance(n.left);
		heightBalance(n.right);
		if (getsize(n) > 2) {
			return false;
		} else {
			return true;
		}

	}

	static int mt = 0;

	static int heightofdim(Node n) {
		if (n == null) {
			return 0;
		}
		if (n.left == null && n.right == null) {
			return 1;
		}
		int max = heightofdim(n.left);
		int min = heightofdim(n.right);
		mt = Math.max(max + min, mt);
		return mt;
	}

	static int max1 = 0;

	static int diameterNode(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int n = diameterNode(node.left);
		int m = diameterNode(node.right);
		max1 = Math.max(max1, n + m + 1);
		return Math.max(n, m) + 1;

	}

	static int add = 0;

	static void balance(Node node, int sum) {
		if (node == null) {
			return;
		}
		Stack<Integer> st = new Stack<Integer>();
		add = add + node.data;
		st.add(node.data);
		if (add == sum) {
			System.out.println(true);
		}
		balance(node.left, sum);
		balance(node.right, sum);
		add = add - node.data;
		st.pop();

	}

	static boolean sumamatche(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null && node.data == data) {
			return true;
		}
		return sumamatche(node.left, data - node.data) || sumamatche(node.right, data - node.data);
	}

	static Stack<Integer> st = new Stack<Integer>();

	static void leftotree(Node node) {
		if (node == null) {
			return;
		}

		st.push(node.data);

		leftotree(node.left);
		if (node.left == null && node.right == null) {
			System.out.print(st + " ");
		}
		leftotree(node.right);

		st.pop();

	}

	static int arr[] = new int[10];

	static void leaf(Node n, int level) {
		if (n == null) {
			return;
		}
		arr[level] = n.data;
		if (n.left == null && n.right == null) {
			printarray(arr, level);
		}
		leaf(n.left, level + 1);
		leaf(n.right, level + 1);

	}

	static int hd = Integer.MAX_VALUE;

	static void getmaxsum(Node n, int level) {
		if (n == null) {
			return;
		}
		arr[level] = n.data;
		if (n.left == null && n.right == null) {
			int d = sum(arr, level);
			hd = Math.max(hd, d);
		}
		getmaxsum(n.left, level + 1);
		getmaxsum(n.right, level + 1);
	}

	private static void printarray(int[] arr2, int level) {
		for (int j : arr2) {
			System.out.print(j + " ");
		}
	}

	private static int sum(int[] arr2, int level) {

		int sum = 0;
		for (int j : arr2) {
			sum = sum + j;
		}
		return sum;
	}

	static int sum = 0;

	static void maximumsum(Node n, int sum) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null && hd < sum + n.data) {
			hd = sum + n.data;
		}
		maximumsum(n.left, sum + n.data);

		maximumsum(n.right, sum + n.data);

	}

	static int jk = 0;

	static void leafnodeadd(Node n, int sum) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			jk = jk + n.data;
		}

		leafnodeadd(n.left, sum + 1);
		leafnodeadd(n.right, sum + 1);
	}

	static int sum12 = Integer.MIN_VALUE;

	static void leftnode(Node n, int sum) {

		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			sum12 = Math.max(sum12, sum);
		}
		leftnode(n.left, sum + 1);
		leftnode(n.right, sum + 1);

	}

	static void oddleftdeep(Node n, int data) {
		if (n == null) {
			return;
		}
		st.push(n.data);
		if (n.data == data) {
			st.pop();
			System.out.print("value::" + "" + st.peek() + ": ");
		}

		oddleftdeep(n.left, data);
		oddleftdeep(n.right, data);
		if (n.data == data) {
			st.pop();
			System.out.print("value::" + "" + st.peek() + ": ");

		}

		st.pop();

	}

	static void sibling(Node n, int data, int value) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.left != null) {
				q.add(curr.left);
				if (curr.left.data == data && curr.right.data == value) {
					System.out.println(true);
				}
			}
			if (curr.right != null) {
				q.add(curr.right);
				if (curr.right.data == data && curr.left.data == value) {
					System.out.println(true);
				}
			}
		}
	}

	static int cousion(Node n, int value1, int value, int position) {
		if (n == null) {
			return 0;
		}
		if (n.data == value1 || n.data == value) {
			return position;
		}
		int l = cousion(n.left, value1, value, position + 1);
		int r = cousion(n.right, value1, value, position + 1);

		return l + r;
	}

	static void sum(Node n) {
		if (n == null) {
			return;
		}
		if (n.left != null) {
			sum(n.left);
			System.out.println(n.data);
		} else {
			sum(n.right);
			System.out.println(n.data);
		}

	}

	static void finddistance(Node node, int data, int data1) {
		if (node == null) {
			return;
		}
		Node lic = getLowestCommon(node, data, data1);
		int distance = getheight(lic, data, 0);
		int distance1 = getheight(lic, data1, 0);
		System.out.println(distance + distance1);
	}

	private static int getheight(Node lic, int data, int i) {
		if (lic == null) {
			return 0;
		}
		if (lic.data == data) {
			i = i + 1;
		}
		getheight(lic.left, data, i + 1);
		getheight(lic.right, data, i + 1);
		return i;
	}

	private static Node getLowestCommon(Node node, int data, int data1) {
		if (node == null) {
			return null;
		}

		if (node.data == data) {
			return node;
		}
		if (node.data == data1) {
			return node;
		}
		Node l = getLowestCommon(node.left, data, data1);
		Node r = getLowestCommon(node.right, data, data1);
		if (l != null && r != null) {
			return node;
		}

		return l != null ? l : r;
	}

	private static Node create(int data) {
		Node n = new Node();
		n.data = data;
		return n;
	}

	static void dis(Node n, int value, int k) {
		Node d = kdistance(n, value, k);
		printDis(d, k);

	}

	private static Node printDis(Node d2, int k) {
		if (d2 == null) {
			return null;
		}
		if (k == 0) {
			System.out.println(d2.data);
			return d2;
		}
		printDis(d2.left, k - 1);
		printDis(d2.right, k - 1);
		return d2;

	}

	static Node kdistance(Node n, int value, int k) {
		if (n == null) {
			return null;
		}
		if (value == n.data) {
			return n;
		}
		Node p = kdistance(n.left, value, k);
		if (p != null) {
			return p;
		}
		p = kdistance(n.right, value, k);
		return p;
	}

	static int kdistancefromleaf(Node node, Node k, int kt) {
		if (node == null) {
			return -1;
		}
		if (node == k) {
			return 0;
		}
		int p = kdistancefromleaf(node.left, k, kt);
		if (p != -1) {
			if (p + 1 == kt) {
				System.out.println(node.data);
			} else {
				print(node.right, kt - 2 - p);
			}
			return p;
		}
		int f = kdistancefromleaf(node.right, k, kt);
		if (f != -1) {
			if (f + 1 == kt) {
				System.out.println(node.data);
			} else {
				print(node.left, kt - 2 - f);
			}
			return f;
		}
		return f;
	}

	static void distanceFromLeaf(Node node, int k) {
		int[] ar = new int[20];
		Boolean b[] = new Boolean[20];
		printLeaf(ar, b, node, k, 0);

	}

	private static void printLeaf(int[] ar, Boolean[] b, Node node, int k, int count) {
		if (node == null) {
			return;
		}
		ar[count] = node.data;
		b[count] = false;
		if (node.left == null && node.right == null && count - k > 0 && b[count - k] == false) {
			System.out.println(ar[count - k]);
			b[count - k] = true;
		}
		printLeaf(ar, b, node.left, k, count + 1);
		printLeaf(ar, b, node.right, k, count + 1);

	}

	static void serilazie(List<Integer> list, Node n) {
		if (n == null) {
			list.add(-1);
			return;
		}
		list.add(n.data);
		serilazie(list, n.left);
		serilazie(list, n.right);
	}

	static Node deseralize(List<Integer> list, Node n, int count) {
		if (list.get(count) == -1) {
			return null;
		}
		n = create(list.get(count));
		n.left = deseralize(list, n.left, count + 1);
		n.right = deseralize(list, n.right, count + 1);
		return n;
	}

	static boolean isbinary(Node n) {
		if (n == null) {
			return true;
		}

		if (n.left.data > n.data || n.right.data < n.data || n.right.data < n.left.data) {
			return false;
		}
		return isbinary(n.left) || isbinary(n.right);

	}

	static Node prev = null;
	static Node head = null;

	static void DLLtoBinary(Node node) {
		if (node == null) {
			return;
		}
		DLLtoBinary(node.left);

		if (prev == null) {
			head = node;
			prev = node;
		} else {
			node.left = prev;
			prev.right = node;
			prev = node;
		}

		DLLtoBinary(node.right);
	}

	static void matchnext(Node node, int data) {
		if (node == null) {
			return;
		}
		Boolean flag = false;
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (true) {
			int size = q.size();
			if (size == 0 && flag == true) {
				break;
			}
			flag = false;
			Node prev = null;
			while (size != 0) {
				Node curr = q.remove();

				if (flag == true) {

				}
				if (curr.data == data) {
					prev = curr;
					flag = true;
				}

				if (curr.left != null) {
					curr = curr.left;
				}
				if (curr.right != null) {
					curr = curr.right;
				}
				size--;
			}
		}
	}

	static int count = 0;

	static void smallest(Node tree, int val) {

		if (tree == null) {
			return;
		}
		smallest(tree.left, val);
		if (count == val) {
			System.out.println(tree.data);
		}
		count++;

		smallest(tree.right, val);

	}

	public static void main(String[] args) {

		Tree a = new Tree();
		Node root = a.createNewNode(10);
		root.left = a.createNewNode(8);
		root.right = a.createNewNode(18);
		root.left.left = a.createNewNode(3);
		root.left.right = a.createNewNode(4);
		root.right.left = a.createNewNode(16);
		root.right.right = a.createNewNode(56);
		root.left.left.left = a.createNewNode(2);
		root.left.left.left.left = a.createNewNode(1);

		System.out.print("Inorder: ");
		a.inpost(root);
		System.out.println();

		System.out.print("PreOrder: ");
		a.prepost(root);
		System.out.println();

		System.out.println();

		System.out.println();
		smallest(root, 6);

	}
}
