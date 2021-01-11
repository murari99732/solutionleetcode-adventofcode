import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class TreeValue {
	TreeValue left;
	TreeValue right;
	int height;
	int value;
}

public class Binary {

	static int getwidth(TreeValue tree, int i, int count, int val) {
		if (tree == null) {
			return 0;
		}
		if (i == count) {

			return val + 1;
		}
		return getwidth(tree.left, i + 1, count, val) + getwidth(tree.right, i + 1, count, val);
	}

	static TreeValue createdoubletree(TreeValue tree) {
		if (tree == null) {
			return null;
		}

		TreeValue curr = createNode(tree.value);
		tree.left = curr;
		curr.left = createdoubletree(tree.left);
		curr.right = createdoubletree(tree.right);

		return curr;
	}

	static int dmheight(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		int max = 0;
		int h = getHeightofTree(tree.left);
		int k = getHeightofTree(tree.right);
		int e = dmheight(tree.left);
		int f = dmheight(tree.right);
		max = Math.max(k + h, max);
		return Math.max(max, Math.max(dmheight(tree.left), dmheight(tree.right)));
	}

	static class Tree {
		int data;
		Tree left;
		Tree right;
	}

	static TreeValue singlechild(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue temp = singlechild(tree.left);
		TreeValue stemp = singlechild(tree.right);
		if (temp != null && stemp == null || temp == null && stemp != null) {
			System.out.println("Single child::" + tree.value);
		}
		return tree;
	}

	static TreeValue deletev(TreeValue tree, int value) {

		if (tree == null) {
			return null;
		}
		if (tree.value == value) {
			return tree;
		}

		TreeValue l = deletev(tree.left, value);
		TreeValue r = deletev(tree.right, value);
		if (l != null) {
			if (l.left != null) {
				tree.left = l;
				return tree;
			} else if (l.right != null) {
				tree.right = l;
				return tree;
			}
		}
		return l != null ? l : r;
	}

	static TreeValue search(TreeValue tree, int value) {
		if (tree == null) {
			return createdoubletree(tree);
		}
		if (tree.value > value) {
			tree.left = search(tree.left, value);
		}
		if (tree.value < value) {
			tree.right = search(tree.right, value);
		}
		return tree;
	}

	static TreeValue delete(TreeValue tree) {
		if (tree.value < value) {
			tree.left = delete(tree.left);
		} else if (tree.value > value) {
			tree.right = delete(tree.right);
		} else {
			if (tree.left == null || tree.right == null) {
				TreeValue node = null;
				node = tree.left == null ? tree.left : tree.right;
				if (node == null) {
					return null;
				} else {
					return node;
				}
			} else {
				TreeValue temp = getsuccessor(tree);
				tree.right = temp;
				return tree;

			}
		}
		return null;

	}

	static TreeValue delete3(TreeValue tree, int data) {
		if (tree.value > data) {
			tree.left = delete3(tree.left, data);
		} else if (tree.value < data) {
			tree.right = delete3(tree.right, data);
		} else {
			if (tree.left == null || tree.right == null) {
				TreeValue root = null;
				root = tree.left == null ? tree.left : tree.right;
				if (root == null) {
					return null;
				} else {
					return root;
				}
			} else {
				TreeValue root = getsuccessor(tree);
				tree.value = root.value;
				tree.right = delete3(tree, root.value);
				return tree;
			}
		}
		return tree;

	}

	private static TreeValue getsuccessor(TreeValue tree) {

		if (tree.right != null) {
			while (tree.left != null) {
				tree = tree.left;
			}
		}
		return tree;
	}

	static TreeValue binarytree(TreeValue tree) {

		TreeValue temp = createdoubletree(tree);
		temp.left = binarytree(tree.left);
		if (prev == null) {

		}
		temp.right = binarytree(tree.right);
		return null;
	}

	public static void main(String[] args) {
		TreeValue root = createNode(-7);
		root.left = createNode(4);
		root.left.left = createNode(5);
		root.left.right = createNode(14);
		root.right = createNode(3);
		root.right.left = createNode(2);
		root.right.right = createNode(9);

//		tree.left.left = createNode(5);
//		tree.left.right = createNode(10);
//		tree.right.left = createNode(7);
//		tree.right.right = createNode(8);
//		tree.right.left.left = createNode(10);
//		tree.right.left.left.left = createNode(25);
//		tree.right.left.left.left.left = createNode(35);
		iterative(root);
		// System.out.println("lowest" + " ");
		// printleafnodeatgiven(tree, 1);

		// printalltree(root);
		System.out.println("........................................");
		int arr[] = new int[5];

		// System.out.println(getsumofleaf(tree, 0));
		System.out.println("........................................");
		TreeValue t = deletev(root, 5);
		printalltree(t);

		// System.out.println(ar);
		// System.out.println(max);
		// System.out.println(dia);
		// System.out.println(art);

		// process(tr, tree);
		// System.out.println(getSibling(tree, 5, 6));
		// getremoveallnode(tree, 0, 2);
		// System.out.println(diameterValue(tree));
		// System.out.println(isbalancedTreeOrNot(tree));

	}

	static TreeValue insert(TreeValue tree, int value) {
		if (tree == null) {
			return createNode(value);
		}
		if (value > tree.value) {
			insert(tree.left, value);
		} else {
			insert(tree.right, value);
		}
		return tree;
	}

	static int getmaximumsum(TreeValue tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int a = getmaximumsum(tree.left);
		int b = getmaximumsum(tree.right);

		if (a != -1 && b != -1) {
			max = Math.max(a, b) + tree.value;
		}
		max = Math.max(max, tree.value);
		return max;

	}

	static int maximumtree(TreeValue tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int d = maximumtree(tree.left);
		int e = maximumtree(tree.right);
		if (d != -1 && e != -1) {
			max = Math.max(d + e, max);
		}
		return Math.max(d, e);
	}

	static int subtree(TreeValue tree, TreeValue temp) {
		if (tree == null && temp == null) {
			return 0;
		}
		if (tree == null || temp == null) {
			return -26;
		}
		if (tree.left == null && tree.right == null && temp.left == null && temp.right == null) {
			if (tree.left == temp.left && tree.right == temp.right)
				return tree.value;
			else {
				return -26;
			}
		}
		int s = subtree(tree.left, temp.left);
		int t = subtree(tree.right, temp.right);
		if (tree.value != temp.value) {
			return -26;
		} else {
			return tree.value;
		}

	}

	static void diagonalsum(TreeValue tree) {
		if (tree == null) {
			return;
		}
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		while (tree != null) {
			queue.add(tree.right);
			tree = tree.right;
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeValue curr = queue.poll();
				if (curr.left != null) {
					queue.add(curr.left);
					curr = curr.left;
				}
				size--;
			}

		}

	}

	static int sumbotoom(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int d = sumbotoom(tree.left);
		if (d == -26) {
			return -26;
		}
		int e = sumbotoom(tree.right);
		if (e == -26) {
			return -26;
		}
		if (d + e != tree.value) {
			return -26;
		}
		return tree.value;
	}

	static boolean sumvalue(TreeValue tree) {
		if (tree == null) {
			return true;
		}
		if (tree.left != null && tree.right != null) {
			int d = tree.left.value;
			int e = tree.right.value;
			if (tree.value != d + e) {
				return false;
			}

		}
		return sumvalue(tree.left) || sumvalue(tree.right);

	}

	static void queuevalue(TreeValue tree) {
		if (tree == null) {
			return;
		}
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeValue temp = queue.poll();
				if (curr != null) {
					curr.left = temp;
					curr = curr.left;
				} else {
					curr = temp;
				}
			}
		}
	}

	static DoubleLinkedList list = new DoubleLinkedList();
	static DoubleLinkedList prev;
	static TreeValue curr;

	static void getrightnodevalue(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (tree.value == value) {
			System.out.println(curr.right);
		}
		getrightnodevalue(tree.left, value);

		curr = tree;
		getrightnodevalue(tree.right, value);

	}

	static TreeValue getrightnode(TreeValue tree, int value) {
		if (tree == null) {
			return null;
		}
		if (tree.value == value) {
			return tree;
		}
		TreeValue left = getrightnode(tree.left, value);
		TreeValue right = getrightnode(tree.right, value);
		if (left != null) {
			System.out.println(tree.right.value);
			return tree.right;
		}

		return left != null ? left : null;
	}

	static void nextpointer(TreeValue tree) {
		if (tree == null) {
			return;
		}
		nextpointer(tree.left);
		if (curr.left != null) {
			curr.left.value = tree.value;
			curr = curr.left;
		} else {
			curr = tree;
		}
		nextpointer(tree.right);

		nextpointer(tree.right);
	}

	static void binarytreetodouble(TreeValue tree) {
		if (tree == null) {
			return;
		}
		binarytreetodouble(tree.left);
		DoubleLinkedList curr = createLinkedList(tree.value);
		if (prev != null) {
			prev.next = curr;
			curr.prev = prev;
			prev = prev.next;

		} else {
			list = curr;
			prev = list;
		}
		binarytreetodouble(tree.right);

	}

	static int BSTTree(TreeValue tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}

		int d = BSTTree(tree.left);
		if (d == -26) {
			return -26;
		}
		int e = BSTTree(tree.right);
		if (e == -26) {
			return -26;
		}
		if (d < tree.value && e > tree.value) {
			return tree.value;
		} else {
			return -26;
		}
	}

	static void serialize(TreeValue tree, int arr[], int i) {
		if (tree == null) {
			arr[i] = -1;
			return;
		}
		arr[i] = tree.value;
		serialize(tree.left, arr, i + 1);
		serialize(tree.right, arr, i + 1);

	}

	static TreeValue desirialze(int arr[], int i, TreeValue tree) {
		if (arr[i] == -1) {
			tree = null;
			return null;
		}
		TreeValue curr = createNode(arr[i]);
		curr.left = desirialze(arr, i + 1, tree);
		curr.right = desirialze(arr, i + 1, tree);
		return curr;
	}

	static int getclosetleaf(TreeValue tree, int dis, int value) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int a = getclosetleaf(tree.left, dis, value);
		int b = getclosetleaf(tree.right, dis, value);
		if (a == 1 && tree.right != null && tree.right.value == value) {
			min = Math.min(a + 1, min);
		}
		if (b == 1 && tree.left != null && tree.left.value == value) {
			min = Math.min(b + 1, min);
		}
		if (tree.value == value) {
			min = Math.min(min, Math.min(a, b));
		}
		if (a == 1 || b == 1) {
			return Math.max(a, b) + 1;
		}
		return Math.max(a, b);
	}

	static int distleafo(TreeValue tree, int dis, ArrayList<Integer> ar) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int c = distleafo(tree.left, dis, ar);
		int d = distleafo(tree.right, dis, ar);
		if (c == dis) {
			ar.add(tree.value);
		}
		if (d == dis) {
			ar.add(tree.value);
		}
		if (c != -1 || d != -1) {
			return Math.max(c, d) + 1;
		}

		return Math.max(c, d);
	}

	static int distleaf(TreeValue tree, int dis) {
		if (tree == null) {
			return -1;
		}

		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int c = distleaf(tree.left, dis);
		int d = distleaf(tree.left, dis);
		if (c == dis) {
			System.out.println(tree.value);
		}
		if (d == dis) {
			System.out.println(tree.value);
		}
		if (c != -1 || d != -1) {
			return Math.max(c, d) + 1;
		}

		return Math.max(c, d);
	}

	static int dist(TreeValue tree, int a, int dis) {
		if (tree == null) {
			return -1;
		}
		if (tree.value == a) {
			return dis + 1;
		}
		int c = dist(tree.left, a, dis + 1);
		if (c != -1) {
			return c;
		}
		return dist(tree.right, a, dis + 1);
	}

	static TreeValue findlcavalue(TreeValue tree, int a, int b) {
		if (tree == null) {
			return null;
		}
		if (tree.value == a) {
			return tree;
		}
		if (tree.value == b) {
			return tree;
		}
		TreeValue c = findlcavalue(tree.left, a, b);
		TreeValue d = findlcavalue(tree.right, a, b);
		if (c != null && d != null) {
			return tree;
		}
		return c != null ? c : d;
	}

	static int aresiblingornot(TreeValue tree, int value, int check) {
		if (tree == null) {
			return -1;
		}
		if (tree.value == value) {
			return 0;
		}
		int c = aresiblingornot(tree.left, value, check);
		int d = aresiblingornot(tree.right, value, check);
		if (c == 0) {
			if (tree.right != null && tree.right.value == check) {
				return 0;
			} else {
				return -1;
			}
		} else if (d == 0) {
			if (tree.left != null && tree.left.value == check) {
				return 0;
			} else {
				return -1;
			}
		}
		return Math.max(d, c);
	}

	static int getsibling(TreeValue tree, int value) {
		if (tree == null) {
			return -1;
		}
		if (tree.value == value) {
			return 0;
		}
		int left = getsibling(tree.left, value);
		int right = getsibling(tree.right, value);
		if (left == 0) {
			System.out.println(tree.right.value);
			return tree.right.value;
		}
		if (right == 0) {
			System.out.println(tree.left.value);
			return tree.left.value;
		}
		return Math.max(left, right);
	}

	static int getparent(TreeValue tree, int val) {
		if (tree == null) {
			return -1;
		}

		if (tree.value == val) {
			return 0;
		}
		int d = getparent(tree.left, val);
		int e = getparent(tree.right, val);
		if (d == 0 || e == 0) {
			return tree.value;
		}
		return Math.max(d, e);
	}

	static void printpurana(TreeValue tree, int arr[], int i, int val) {
		if (tree == null) {
			return;
		}
		arr[i] = tree.value;
		if (arr[i] == val) {
			Arrays.stream(arr).forEach(a -> System.out.println(a));
		}
		printpurana(tree.left, arr, i + 1, val);
		printpurana(tree.right, arr, i + 1, val);
	}

	static int printancestor(TreeValue tree, int value) {
		if (tree == null) {
			return 0;
		}
		if (tree.value == value) {
			System.out.print(tree.value + " ");
			return tree.value;
		}
		int a = printancestor(tree.left, value);
		int b = printancestor(tree.right, value);
		if (a != 0 || b != 0) {
			System.out.print(tree.value + " ");
			return tree.value;
		}
		return 0;

	}

	static int sequncevalue(TreeValue tree, int arr[], int i) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null && tree.value == arr[i]) {
			return -1;
		}
		int d = sequncevalue(tree.left, arr, i + 1);
		int c = sequncevalue(tree.right, arr, i + 1);
		if (d == -1 || c == -1) {
			if (tree.value == arr[i]) {
				return -1;
			}
		}
		return 0;
	}

	static boolean sequence(TreeValue tree, int arr[], int brr[], int i) {
		if (tree == null) {
			return false;
		}
		arr[i] = tree.value;
		if (arr[i] != brr[i]) {
			return false;
		}
		if (tree.left == null && tree.right == null && arr[i] == brr[i]) {
			return true;
		}
		return sequence(tree.right, arr, brr, i + 1) || sequence(tree.left, arr, brr, i + 1);
	}

	static int dm(TreeValue tree) {
		if (tree == null) {
			return 0;
		}

		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int k = dm(tree.left);
		int p = dm(tree.right);
		dia = Math.max(k + p, dia);
		return Math.max(k, p) + 1;
	}

	static void delete(TreeValue tree, int sum) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && sum + 1 > 3) {
			tree = null;
		}
		delete(tree.left, sum + 1);
		delete(tree.right, sum + 1);
	}

	static void getdeepestval(TreeValue tree, boolean isleft, int count) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && isleft == true && count + 1 > max) {
			max = count + 1;
		}
		getdeepestval(tree.left, true, count + 1);
		getdeepestval(tree.right, true, count + 1);
	}

	static void getsumofleaf(TreeValue tree, boolean isleft) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && isleft == true) {
			sum = sum + tree.value;
		}
		getsumofleaf(tree.left, false);
		getsumofleaf(tree.right, true);
	}

	static int getsumofleaf(TreeValue tree, int sum) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			sum = sum + tree.value;
			return sum;
		}
		return getsumofleaf(tree.left, sum) + getsumofleaf(tree.right, sum);
	}

	static int minheightvalue(TreeValue tree) {
		if (tree == null) {
			return Integer.MAX_VALUE;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int d = minheightvalue(tree.left);
		int e = minheightvalue(tree.right);
		return Math.min(d, e) + 1;

	}

	static int max = 0;
	static int min = Integer.MAX_VALUE;

	static void getminmax(TreeValue tree) {
		if (tree == null) {
			return;
		}
		max = Math.max(tree.value, max);
		min = Math.min(tree.value, min);
		getminmax(tree.left);
		getminmax(tree.right);
	}

	static int sum2 = 0;

	static void getsum(TreeValue tree, int arr[], int i) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			sum2 = sum2 + i * 10 + tree.value;

		}
		getsum(tree.left, arr, i * 10 + tree.value);
		getsum(tree.right, arr, i * 10 + tree.value);

	}

	static int getMaximumsum(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int m = getMaximumsum(tree.left);
		int n = getMaximumsum(tree.right);
		return tree.value + Math.max(m, n);
	}

	static void printalltreevalue(TreeValue tree, int[] ar, int i) {
		if (tree == null) {
			return;
		}
		ar[i] = tree.value;
		if (tree.left == null && tree.right == null) {
			System.out.println();
			Arrays.stream(ar).forEach(a -> System.out.print(a + " "));
		}
		printalltreevalue(tree.left, ar, i + 1);
		printalltreevalue(tree.right, ar, i + 1);

	}

	static Stack<Integer> stop = new Stack<Integer>();

	static void printalltree(TreeValue tree) {
		if (tree == null) {
			return;
		}
		stop.push(tree.value);
		if (tree.left == null && tree.right == null) {
			System.out.println();
			stop.stream().forEach(a -> System.out.print(a + " "));
		}
		printalltree(tree.left);
		printalltree(tree.right);
		stop.pop();
	}

	static int avlheight(TreeValue tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int l = avlheight(tree.left);
		int h = avlheight(tree.right);
		int diff = Math.abs(l - h) + 1;
		if (diff > 4) {
			return -1;
		}
		return Math.max(l, h) + 1;
	}

	static int dia = 0;

	static int diameternew(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int h = diameternew(tree.left);
		int k = diameternew(tree.right);
		dia = Math.max(h + k + 1, dia);
		return Math.max(h, k) + 1;

	}

	static void printheight(TreeValue tree, int start, int end, int count) {
		if (tree == null) {
			return;
		}
		if (count >= start && count <= end) {
			System.out.print(tree.value + " ");
		}
		printheight(tree.left, start, end, count + 1);
		printheight(tree.right, start, end, count + 1);
	}

	static void spiral(TreeValue tree) {
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		int even = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (even % 2 == 0 && size > 0) {
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
			while (even % 2 != 0 && size > 0) {
				TreeValue curr = queue.poll();
				System.out.print(curr.value + " ");
				if (curr.right != null) {
					queue.add(curr.right);
				}
				if (curr.left != null) {
					queue.add(curr.left);
				}
				size--;
			}
			even++;
		}
	}

	static TreeValue createNode(int data) {
		TreeValue tree = new TreeValue();
		tree.left = null;
		tree.value = data;
		return tree;
	}

	static void iterative(TreeValue tree) {
		if (tree == null) {
			return;
		}
		iterative(tree.left);
		System.out.print(tree.value + " ");
		iterative(tree.right);

	}

	static TreeValue recursivepreorder(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		System.out.print(tree.value + " ");
		recursivepreorder(tree.left);

		recursivepreorder(tree.right);
		return tree;
	}

	static void iterativeinorder(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.add(tree);
		while (!st.isEmpty()) {
			TreeValue curr = st.pop();
			if (curr.left != null) {
				st.add(curr.left);
			}
			System.out.print(curr.value + " ");
			if (curr.right != null) {
				st.add(curr.right);
			}
		}
	}

	public static void inorder(TreeValue node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	static int sum = 0;

	static void add(TreeValue tree) {
		if (tree == null) {
			return;
		}

		int height = getHeight(tree.left);
		for (int i = height; i >= 0; i--) {
			printValue(tree, i);
			System.out.println();
		}

	}

	private static void printValue(TreeValue tree, int i) {
		if (tree == null) {
			return;
		}
		if (i == 0) {
			System.out.print(tree.value + " ");
		}
		printValue(tree.left, i - 1);
		printValue(tree.right, i - 1);

	}

	private static int getHeight(TreeValue tree) {
		if (tree == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
	}

	static void queueinorder(TreeValue tree) {
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		q.add(tree);
		System.out.println();
		while (!q.isEmpty()) {
			TreeValue curr = q.poll();

			System.out.print(curr.value + " ");
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
		}
	}

	static int sumvalue(TreeValue tree, int sum) {
		if (tree == null) {
			return 0;
		}

		sum = sum + 1;
		if (tree.left == null && tree.right == null) {
			return sum;
		}
		int d = sumvalue(tree.left, sum);
		int e = sumvalue(tree.right, sum);
		return Math.max(d, e);
	}

	static void createDoubleOfTree(TreeValue tree) {
		if (tree == null) {
			return;
		}
		createDoubleOfTree(tree.left);
		createDoubleOfTree(tree.right);
		TreeValue curr = createNode(tree.value);
		tree.left = curr;
		tree = curr;
	}

	static int indexValue = 0;

	static void inorderToPreorder(int pre[], int inorder[], int start, int last) {
		TreeValue tree = createNode(pre[indexValue++]);

	}

	static int minimudistance(TreeValue tree, int dis) {
		if (tree == null) {
			return Integer.MAX_VALUE;
		}
		if (tree.left == null & tree.right == null) {
			return 0;
		}
		int rt = minimudistance(tree.left, dis + 1);
		int lt = minimudistance(tree.right, dis + 1);
		return Math.min(rt, lt) + 1;

	}

	static void givenValue(TreeValue tree, int max, int min, int length) {
		if (tree == null) {
			return;
		}
		if (max < length && min > length) {
			System.out.println(tree.value + " ");
		}
		givenValue(tree.left, max, min, length + 1);
		givenValue(tree.right, max, min, length + 1);
	}

	static int sumValue(TreeValue tree, int sum) {
		if (tree == null) {
			return sum;
		}
		sum = sum + tree.value;
		sumValue(tree.left, sum);
		sumValue(tree.right, sum);
		return sum;
	}

	static boolean checkIdentical(TreeValue tree, TreeValue subtree) {
		if (tree == null && subtree == null) {
			return true;
		}
		if (tree == null || subtree == null) {
			return false;
		}
		if (tree.value != subtree.value) {
			return false;
		}
		if (tree.value == subtree.value) {
			return checkIdentical(tree.left, subtree.left) || checkIdentical(tree.right, subtree.right);
		}
		return checkIdentical(tree.left, subtree) || checkIdentical(tree.right, subtree);
	}

	static Integer sumoverall(TreeValue tree, int value) {
		if (tree == null) {
			return value;
		}
		int sum = 0;
		int d = sumoverall(tree.left, sum + tree.value);
		int c = sumoverall(tree.right, sum + tree.value);
		if (value != d + c) {
			return -1;
		}
		return value;
	}

	static boolean sum1(TreeValue tree, int sum) {
		if (tree == null) {
			return true;
		}
		if (tree.left != null && tree.right != null)
			if (tree.value != tree.left.value + tree.right.value) {
				return false;
			}
		return sum1(tree.left, sum) && sum1(tree.right, sum);

	}

	static DoubleLinkedList prt = null;

	static void rightmost(TreeValue tree) {
		if (tree == null) {
			return;
		}
		if (tree.left != null) {
			while (tree.right != null) {
				tree = tree.right;
			}
		}
		System.out.println(tree.value);

	}

	static DoubleLinkedList doubletree(TreeValue tree) {
		if (tree == null) {
			return prt;
		}
		doubletree(tree.left);
		DoubleLinkedList value = null;
		if (prt == null) {
			value = createLinkedList(tree.value);
			prt = value;
		} else {
			DoubleLinkedList temp = createLinkedList(tree.value);
			prt.next = temp;
			temp.prev = prt;
			prt = temp;
		}
		doubletree(tree.right);
		return prt;

	}

	private static DoubleLinkedList createLinkedList(int value2) {
		DoubleLinkedList db = new DoubleLinkedList();
		db.value = value2;
		return db;
	}

	static boolean bst(TreeValue tree) {
		if (tree == null) {
			return true;
		}

		if (!bst(tree.left)) {
			return false;
		}

		if (prt != null && prt.value > tree.value) {
			return false;
		}

		return bst(tree.right);
	}

	static void serialize(TreeValue tree) {
		if (tree == null) {
			art.add(-1);
		}
		art.add(tree.value);
		serialize(tree.left);
		serialize(tree.right);
	}

	static TreeValue desirialize(TreeValue tree, int i) {
		if (i == art.size()) {
			return null;
		}
		tree = createNode(art.get(i));
		tree.left = desirialize(tree.left, i + 1);
		tree.right = desirialize(tree.right, i + 1);
		return tree;

	}

	static ArrayList<Integer> art = new ArrayList<Integer>();

	static void findLeafNode(TreeValue tree) {
		if (tree == null) {
			return;
		}

		findLeafNode(tree.left);

		findLeafNode(tree.right);

	}

	static LinkedHashMap<Integer, Boolean> hashmap = new LinkedHashMap<Integer, Boolean>();

	static void printDistancefromcloset(TreeValue tree) {
		if (tree == null) {
			return;
		}
		hashmap.put(tree.value, false);
		if (tree.left == null && tree.right == null) {
			hashmap.put(tree.value, true);
		}
		printDistancefromcloset(tree.left);
		printDistancefromcloset(tree.right);
	}

	public static void printAllElementsAtKDistanceFromLeafNode(TreeValue node, int k) {
		if (node == null || k < 0) {
			return;
		}

		int arr[] = new int[20];
		boolean visited[] = new boolean[20];

		printAllElementsAtKDistanceFromLeafNodeUtil(node, k, arr, visited, 0);
	}

	public static void printAllElementsAtKDistanceFromLeafNodeUtil(TreeValue node, int k, int[] arr, boolean[] visited,
			int count) {
		if (node == null) {
			return;
		}

		arr[count] = node.value;
		visited[count] = false;

		if (node.left == null && node.right == null && count - k >= 0 && visited[count - k] == false) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}

		printAllElementsAtKDistanceFromLeafNodeUtil(node.left, k, arr, visited, count + 1);
		printAllElementsAtKDistanceFromLeafNodeUtil(node.right, k, arr, visited, count + 1);
	}

	static ArrayList<Integer> ar = new ArrayList<Integer>();

	static void printleafnodeatgiven(TreeValue tree, int dis) {
		if (tree == null) {
			return;
		}
		st.push(tree.value);
		stack.push(tree.value);
		ar.add(tree.value);
		if (tree.left == null && tree.right == null && st.size() > dis && stack.size() > dis && ar.size() > dis) {
			System.out.print(ar.get(ar.size() - dis - 1) + " ");
			System.out.println();
			System.out.print(st.get(ar.size() - dis - 1) + " ");
			System.out.println();
			System.out.print(stack.get(ar.size() - dis - 1) + " ");
			System.out.println();
		}
		printleafnodeatgiven(tree.left, dis);
		printleafnodeatgiven(tree.right, dis);
		st.pop();

	}

	static void printatGivenNode(TreeValue tree, int dis) {

		TreeValue tr = givenNode(tree, dis);
		printValue1(tree, dis);

	}

	private static void printValue1(TreeValue tree, int dis) {
		if (tree == null) {
			return;
		}
		if (dis == 0) {
			System.out.print(tree.value + " value ");
			return;
		}
		printValue1(tree.left, dis - 1);
		printValue1(tree.right, dis - 1);

	}

	static TreeValue givenNode(TreeValue tree, int data) {
		if (tree == null) {
			return tree;
		}
		if (data == tree.value) {
			return tree;
		}
		TreeValue tr = givenNode(tree.left, data);
		if (tr != null) {
			return tr;
		}
		tr = givenNode(tree.right, data);
		return tr;
	}

	static TreeValue lcs1(TreeValue tree, int i, int j) {
		if (tree == null) {
			return null;
		}
		if (tree.value == i || tree.value == j) {
			return tree;
		}
		TreeValue lt = lcs1(tree.left, i, j);
		TreeValue rt = lcs1(tree.right, i, j);
		if (lt != null && rt != null) {
			return tree;
		}
		return lt != null ? lt : rt;

	}

	private static void lsc(TreeValue distance2, int i, int j) {
		int f = getDistance(distance2, i, 0);
		int g = getDistance(distance2, j, 0);
		System.out.println(f - g);
	}

	private static int getDistance(TreeValue distance2, int i, int dis) {
		if (distance2 == null) {
			return dis;
		}
		if (distance2.value == i) {
			return dis;
		}
		int g = getDistance(distance2.left, i, dis + 1);
		if (g != 0) {
			return g;
		}
		g = getDistance(distance2.right, i, dis + 1);
		return g;

	}

	static void lcs(TreeValue tree, int rvalve, int lvalve) {

	}

	static TreeValue distance(TreeValue tree, int rvalve, int lvalve) {
		if (tree == null) {
			return null;
		}
		distance(tree.left, rvalve, lvalve);
		distance(tree.right, rvalve, lvalve);
		if (distance(tree, rvalve) && distance(tree, lvalve) && iflag) {
			System.out.println(tree.value);
			iflag = false;
			tree.left = null;
			tree.right = null;
			return tree;
		}
		return tree;

	}

	private static boolean distance(TreeValue tree, int rvalve) {
		if (tree == null) {
			return false;
		}
		if (tree.value == rvalve) {
			return true;
		}
		return distance(tree.left, rvalve) || distance(tree.right, rvalve);
	}

	static TreeValue tr = null;
	static boolean iflag = true;

	static TreeValue lowestcommon(TreeValue tree, int rvalve, int lvalve) {
		if (tree == null) {
			return tr;
		}

		lowestcommon(tree.left, rvalve, lvalve);
		lowestcommon(tree.right, rvalve, lvalve);
		if (getcommon(tree, lvalve) && getcommon(tree, rvalve) && iflag == false) {
			System.out.println(tree.value + " ");
			tr = tree;
			iflag = true;
			return tr;
		}
		return tr;

	}

	private static boolean getcommon(TreeValue tree, int rvalve) {

		if (tree == null) {
			return false;
		}
		if (tree.value == rvalve) {
			return true;
		}

		return getcommon(tree.left, rvalve) || getcommon(tree.right, rvalve);
	}

	static boolean cousins(TreeValue tree, int rvalve, int lvalve, int level) {
		int d = getLevel(tree, rvalve, 0);
		int e = getLevel(tree, lvalve, 0);
		if (d != e) {
			return false;
		}
		return isibling(tree, rvalve, lvalve);
	}

	private static boolean isibling(TreeValue tree, int rvalve, int lvalve) {
		if (tree == null) {
			return false;
		}
		if (tree.left.value == rvalve && tree.right.value != lvalve
				|| tree.right.value == rvalve && tree.left.value != lvalve) {
			return true;
		}

		return isibling(tree.left, rvalve, lvalve) || isibling(tree.right, rvalve, lvalve);
	}

	private static int getLevel(TreeValue tree, int rvalve, int positin) {

		if (tree == null) {
			return 0;
		}
		if (rvalve == tree.value) {
			return positin;
		}
		int c = getLevel(tree.left, rvalve, positin + 1);
		if (c != 0) {
			return c;
		}
		c = getLevel(tree.right, rvalve, positin + 1);

		return c;
	}

	static boolean getSibling(TreeValue tree, int rvalue, int lvalue) {
		if (tree == null) {
			return false;
		}
		if (tree.left.value == lvalue && tree.right.value == rvalue
				|| tree.right.value == lvalue && tree.left.value == rvalue) {
			return true;
		}
		return getSibling(tree.left, rvalue, lvalue) || getSibling(tree.right, rvalue, lvalue);

	}

	static TreeValue temp = null;

	static void getSibling(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (tree.left.value == value) {
			temp = tree;
			if (temp.right != null) {
				System.out.println(temp.right.value);
				return;
			}
		}
		getSibling(tree.left, value);
		getSibling(tree.right, value);

	}

	static boolean printanc(TreeValue tree, int val) {
		if (tree == null) {
			return false;
		}
		if (val == tree.value) {
			return true;
		}
		if (printanc(tree.left, val) || printanc(tree.right, val)) {
			System.out.println(tree.value);
			return true;
		}
		return false;
	}

	static void printancestore(TreeValue tree, int val) {
		if (tree == null) {
			return;
		}

		if (val == tree.value) {
			System.out.println(val);
			return;
		}
		printancestore(tree.left, val);
		printancestore(tree.right, val);

	}

	static boolean getValue(TreeValue tree, int arr[], int index) {
		if (tree == null) {
			return false;
		}
		if (arr[index] != tree.value) {
			return false;
		}
		if (tree.left == null && tree.right == null && arr[index] == tree.value) {
			return true;
		}
		return getValue(tree.left, arr, index + 1) || getValue(tree.right, arr, index + 1);

	}

	static void getSequence(TreeValue tree, Stack<Integer> st) {
		if (tree == null) {
			return;
		}
		stack.add(tree.value);
		if (tree.left == null && tree.right == null) {
			boolean b = stack.equals(st);
			if (b == true) {
				System.out.println(true);
			}
		}
		getSequence(tree.left, st);
		getSequence(tree.right, st);
		stack.pop();
	}

	static void removesmallervalue(TreeValue tree, int dist, int from) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && dist + tree.value < from) {
			tree = null;

		}
		removesmallervalue(tree.left, tree.value + dist, from);
		removesmallervalue(tree.right, tree.value + dist, from);
	}

	static void getremoveallnode(TreeValue tree, int dist, int from) {
		if (tree == null) {
			return;
		}

		getremoveallnode(tree.left, dist + 1, from);
		getremoveallnode(tree.right, dist + 1, from);
		if (tree.left == null && tree.right == null && dist > from) {
			tree = null;
		}
	}

	static void getOddelevelDeppest(TreeValue tree, boolean isTrue, int dis) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && isTrue == true && dis % 2 != 0 && distance < dis) {
			distance = dis;
		}

		getOddelevelDeppest(tree.left, true, dis);
		getOddelevelDeppest(tree.right, false, dis);
	}

	static void getdeepest(TreeValue tree, boolean isTrue, int dis) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && dis > distance && isTrue == true) {
			distance = dis;

		}
		getdeepest(tree.left, true, dis + 1);
		getdeepest(tree.right, false, dis + 1);
	}

	static boolean samelevel(TreeValue tree, int dis) {
		if (tree == null) {
			return true;
		}
		if (tree.left == null && tree.right == null) {
			if (distance == 0) {
				distance = dis;
				return true;
			}
			return distance == dis;
		}
		return samelevel(tree.left, dis + 1) || samelevel(tree.right, dis + 1);
	}

	static int getminimumheight(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		return Math.min(getminimumheight(tree.left), getminimumheight(tree.right));
	}

	static void sumleft(TreeValue tree, boolean istrue) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && istrue == true) {
			distance = distance + tree.value;
		}
		sumleft(tree.left, true);
		sumleft(tree.left, false);
	}

	static void sumofleafit(TreeValue tree) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			distance = distance + tree.value;
		}
		sumofleafit(tree.left);
		sumofleafit(tree.right);
	}

	static int sumofleaf(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		return sumofleaf(tree.left) + sumofleaf(tree.right);
	}

	static void deeplevel(TreeValue tree, int level) {
		if (tree == null) {
			return;
		}

		if (tree.left == null && tree.right == null && level % 2 != 0) {

			if (Math.max(distance, level) > distance) {
				distance = Math.max(distance, level);
				System.out.println(tree.value);
			}
		}
		deeplevel(tree.left, level + 1);
		deeplevel(tree.right, level + 1);
	}

	static int deepestleaf(TreeValue tree, boolean isTrue, int level) {
		if (tree == null) {
			return distance;
		}
		if (tree.left == null && tree.right == null && isTrue == true) {
			distance = Math.max(distance, level);
			return distance;
		}
		int d = deepestleaf(tree.left, true, level + 1);
		d = deepestleaf(tree.left, false, level + 1);
		return d;
	}

	static int distance = 0;

	static boolean samelevelleaf(TreeValue tree, int level) {
		if (tree == null) {
			return true;
		}
		if (tree.left == null && tree.right == null) {
			if (distance == 0) {
				distance = level;
				return true;
			}
			if (distance == level) {
				return true;
			}
			return false;
		}
		return samelevelleaf(tree.left, level + 1) && samelevelleaf(tree.right, level + 1);
	}

	static int findsumleave(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		return findsumleave(tree.left) + findsumleave(tree.right);
	}

	static int findsumleave1(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.value;
		}
		int c = findsumleave(tree.left);
		int d = findsumleave(tree.right);
		return findsumleave(tree.left) + findsumleave(tree.right);
	}

	static void findsumleftLeave(TreeValue tree) {
		if (tree == null) {
			return;
		}

		findsumleftLeave(tree.left);
		if (tree.left == null && tree.right == null) {
			value = value + tree.value;
		}
		findsumleftLeave(tree.right);
	}

	static int value = 0;

	static boolean checkiterativesum(TreeValue tree, int sum) {
		if (tree == null) {
			return false;
		}
		value = value + tree.value;
		st.push(tree.value);
		if (tree.left == null && tree.right == null && value == sum) {
			Integer sum1 = st.stream().reduce(0, (a, b) -> a + b);
			st.stream().forEach(a -> System.out.println(a));
			return true;
		}
		checkiterativesum(tree.left, sum);
		checkiterativesum(tree.right, sum);
		int d = st.pop();
		value = value - d;
		return true;
	}

	static boolean checkgivensum(TreeValue tree, int sum) {
		if (tree == null) {
			return false;
		}
		if (tree.left == null && tree.right == null && tree.value == sum) {
			return true;
		}
		return checkgivensum(tree.left, sum - tree.value) || checkgivensum(tree.right, sum - tree.value);
	}

	static boolean isbalancedTreeOrNot(TreeValue tree) {
		if (tree == null) {
			return false;
		}
		int ht = getHeight(tree.left);
		int mt = getHeight(tree.right);
		if (Math.abs(mt - ht) > 3) {
			return true;
		}
		isbalancedTreeOrNot(tree.left);
		isbalancedTreeOrNot(tree.right);
		return false;

	}

	static int diameterValue(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		int heightl = getHeight(tree.left);
		int heightr = getHeight(tree.right);
		return Math.max(heightl + heightr + 1, Math.max(diameterValue(tree.left), diameterValue(tree.right)));

	}

	static int index = 0;

	static TreeValue inordertopostorder(TreeValue tree, int preorder[], int start, int end, int inorder[]) {
		if (start == end) {
			return tree;
		}
		int getvalue = getleftright(preorder[index++], inorder, start, end);
		tree.left = inordertopostorder(tree.left, preorder, start, getvalue, inorder);
		tree.right = inordertopostorder(tree.right, preorder, getvalue, end, inorder);
		return tree;
	}

	private static int getleftright(int data, int[] inorder, int start, int end) {
		if (start > end) {
			return -1;
		}
		int d = 0;
		for (int i = 0; i < end; i++) {
			if (data == inorder[i]) {
				return i;
			}
		}
		return 0;
	}

	static void maketree(TreeValue tree) {
		if (tree == null) {
			return;
		}
		maketree(tree.left);
		maketree(tree.right);
		TreeValue curr = createNode(tree.value);
		TreeValue next = tree.left;
		tree.left = curr;
		curr.left = next;
	}

	static void printbetweenqueue(TreeValue tree, int from, int to) {
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		q.add(tree);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				TreeValue curr = q.poll();
				if (from >= level && level <= to) {
					System.out.print("vl::" + curr.value);
				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
			level++;
		}
	}

	static void printbetween(TreeValue tree, int from, int to, int md) {
		if (tree == null) {
			return;
		}
		if (from >= md && md <= to) {
			System.out.print("vl::" + tree.value);

		}
		printbetween(tree.left, from, to, md + 1);
		printbetween(tree.right, from, to, md - 1);
	}

	static void spiralform(TreeValue tree) {
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		boolean flag = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				if (flag == true) {
					TreeValue curr = queue.poll();
					System.out.print(curr.value + " ");
					if (curr.left != null) {
						queue.add(curr.left);
					}
					if (curr.right != null) {
						queue.add(curr.right);
					}

				}
				size--;
			}
			flag = false;
			while (size > 0) {
				if (flag == false) {
					TreeValue curr = queue.poll();
					System.out.print(curr.value + " ");
					if (curr.right != null) {
						queue.add(curr.right);
					}
					if (curr.left != null) {
						queue.add(curr.left);
					}

				}
				size--;
			}
			flag = true;
		}
	}

	static void topView(TreeValue tree) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<TreeValue> queue = new LinkedList<TreeValue>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			TreeValue curr = queue.poll();
			int height = curr.height;
			{
				map.put(height, curr.value);
			}
			if (curr.left != null) {
				curr.left.height = height - 1;
				queue.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.height = height + 1;
				queue.add(curr.right);
			}
		}
		map.entrySet().stream().forEach(a -> System.out.println(a.getKey() + " " + a.getValue()));
	}

	static int givenNode(TreeValue tree, int value, int level) {

		if (tree == null) {
			return 0;
		}
		if (tree.value == value) {
			return level;
		}
		int c = givenNode(tree.left, value, level + 1);

		int d = givenNode(tree.right, value, level + 1);
		return d;

	}

	static boolean identical(TreeValue tree, TreeValue map) {
		if (tree == null && map == null) {
			return true;
		}
		if (tree == null || map == null) {
			return false;
		}
		return tree.value == map.value || identical(tree.left, map.left) || identical(tree.left, map.left);
	}

	static TreeValue mirrortree(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		mirror(tree.left);
		mirror(tree.right);
		return tree;
	}

	static void print(TreeValue tree, int value) {
		int height = getHeightofTree(tree);
		for (int i = 0; i < height; i++) {
			printatGivenLevel(tree, i);
		}
		System.out.println();
	}

	static void printRightView(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (value == sum) {
			System.out.print(tree.value + " ");
			sum = sum + 1;
		}
		printLeftView(tree.right, value + 1);
		printLeftView(tree.left, value + 1);
	}

	static void printLeftView(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (value == sum) {
			System.out.print(tree.value + " ");
			sum = sum + 1;
		}
		printLeftView(tree.left, value + 1);
		printLeftView(tree.right, value + 1);
	}

	static void printatGivenLevel(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (value == 0) {
			System.out.print(tree.value + " ");
		}
		printatGivenLevel(tree.left, value - 1);
		printatGivenLevel(tree.right, value - 1);
	}

	static int getHeightofTree(TreeValue tree) {
		if (tree == null) {
			return 0;
		}

		return 1 + Math.max(getHeightofTree(tree.left), getHeightofTree(tree.right));
	}

	static int getLeaf(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		return getLeaf(tree.left) + getLeaf(tree.right);
	}

	static int getNoodes(TreeValue tree, int val) {
		if (tree == null) {
			return val;
		}

		int c = getNoodes(tree.left, val + 1);

		int d = getNoodes(tree.right, c);
		return d;
	}

	static int getDiff(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		return tree.value - getDiff(tree.left) - getDiff(tree.right);
	}

	static int sum(TreeValue tree, int add) {
		if (tree == null) {
			return 0;
		}

		return tree.value + sum(tree.left) +

				sum(tree.right);

	}

	static int sum(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		return tree.value + sum(tree.left) + sum(tree.right);
	}

	static void postorder(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		Stack<TreeValue> ft = new Stack<TreeValue>();
		ft.add(tree);
		while (!ft.isEmpty()) {
			TreeValue curr = ft.pop();
			st.push(curr);
			if (curr.right != null) {
				ft.push(curr.right);
			}
			if (curr.left != null) {
				ft.push(curr.left);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop().value + " ");
		}

	}

	static void preoderPractice(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		TreeValue tr = tree;
		while (tr != null) {
			st.push(tr);
			tr = tr.left;
		}
		while (!st.isEmpty()) {
			TreeValue curr = st.pop();
			System.out.print(curr.value + " ");
			if (curr.right != null) {

				st.push(curr.right);
			}

		}
	}

	static void inorderPratice(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.push(tree);
		while (!st.isEmpty()) {
			TreeValue curr = st.pop();
			System.out.print(curr.value + " ");
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
		}

	}

	static void getSum(TreeValue tree) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			st.add(tree.value);
		}
		getSum(tree.left);
		getSum(tree.right);
	}

	static int minheight(TreeValue tree) {
		if (tree == null) {
			return 0;
		}
		ds = Math.min(ds, Math.max(minheight(tree.left), minheight(tree.right)) + 1);
		return ds;
	}

	static void minmax(TreeValue tree) {
		if (tree == null) {
			return;
		}
		sum = Math.max(sum, tree.value);
		ds = Math.min(ds, tree.value);
		minmax(tree.left);
		minmax(tree.right);
	}

	static int ds = Integer.MAX_VALUE;

	static void sumleaf(TreeValue tree) {
		if (tree == null) {
			return;
		}
		st.push(tree.value);
		if (tree.left == null && tree.right == null) {
			Integer sum = st.stream().reduce(0, (a, b) -> a + b);
			ds = Math.max(sum, ds);

		}

		sumleaf(tree.left);
		sumleaf(tree.right);

		st.pop();

	}

	static boolean diameter(TreeValue node) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = getHeight(node.left);
		rh = getHeight(node.right);

		if (Math.abs(lh - rh) <= 1 && diameter(node.left) && diameter(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	static void DFS(TreeValue tree) {
		if (tree == null) {
			return;
		}
		System.out.print(tree.value + " ");
		DFS(tree.left);
		DFS(tree.right);
	}

	static void makeInIndia(int pre[], int inorder[]) {
		TreeValue tree = new TreeValue();
		for (int i = 0; i < pre.length; i++) {
			tree = createNode(pre[i]);

		}
	}

	static void doubleTree(TreeValue tree) {
		if (tree == null) {
			return;
		}

		doubleTree(tree.left);
		doubleTree(tree.right);
		TreeValue next = tree.left;
		TreeValue curr = createNode(tree.value);
		tree.left = curr;
		curr.left = next;
		tree = tree.left;

	}

	static int getwidthatparticular(TreeValue tree, int value, int count) {
		if (tree == null) {
			return count;
		}
		if (value == 0) {
			return 1;
		}

		return getwidthatparticular(tree.right, value - 1, count) + getwidthatparticular(tree.left, value - 1, count);
	}

	static boolean isomorphic(TreeValue tree, TreeValue map) {
		if (tree == null && map == null) {
			return true;
		}
		if (tree == null || map == null) {
			return false;
		}
		if ((tree.left.value == map.left.value && tree.right.value == map.right.value)
				|| (tree.left.value == map.right.value && tree.right.value == map.left.value)) {
			return true;
		}
		return isomorphic(tree.left, map.left) || isomorphic(tree.right, map.right) || isomorphic(tree.left, map.right);
	}

	static void printbetweenvalues(TreeValue tree, int value, int till) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.add(tree);
		boolean flag = false;
		while (!st.isEmpty()) {
			TreeValue tr = st.pop();
			if (tr.value == value && flag == false) {
				if (tr.right != null) {
					st.add(tr.right);
				}
				if (tr.left != null) {
					st.add(tr.left);
				}
			} else if (tr.value == value && flag == true) {

			}
		}
	}

	static Stack<Integer> stack = new Stack<Integer>();

	static void twogivenLevel(TreeValue tree, int value, int dest, Stack<Integer> st) {
		if (tree == null) {
			return;
		}
		if (value == tree.value) {
			st.push(tree.value);
		}
		twogivenLevel(tree.left, value, dest, st);
		twogivenLevel(tree.right, value, dest, st);
		if (dest == tree.value) {

		}
	}

	static void spiralorder(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		Stack<TreeValue> ft = new Stack<TreeValue>();
		ft.add(tree);
		boolean flag = true;
		while (!ft.isEmpty()) {
			while (flag == false && !ft.isEmpty()) {
				TreeValue tr = ft.pop();
				System.out.print(tr.value + " ");
				if (tr.left != null) {
					st.add(tr.left);

				}
				if (tr.right != null) {
					st.add(tr.right);
				}
			}
			flag = true;
			while (flag == true && !st.isEmpty()) {
				TreeValue tr = st.pop();
				System.out.print(tr.value + " ");
				if (tr.right != null) {
					ft.add(tr.right);

				}
				if (tr.left != null) {
					ft.add(tr.left);
				}
			}
			flag = false;
		}
	}

	static boolean findnode(TreeValue tree, int value) {
		if (tree == null) {
			return false;
		}
		if (tree.value == value) {
			return true;
		}
		return findnode(tree.left, value) || findnode(tree.right, value);
	}

	static void getSumLevelWise(TreeValue tree) {
		Stack<TreeValue> q = new Stack<TreeValue>();
		q.add(tree);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		boolean flag = true;
		while (!q.isEmpty()) {
			int size = q.size();
			int add = 0;
			if (flag == true) {
				while (size > 0) {
					TreeValue curr = q.pop();
					System.out.print(curr.value + " ");
					add = add + curr.value;
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}

					size--;
				}
				flag = false;
			} else {
				while (size > 0) {
					TreeValue curr = q.pop();
					System.out.print(curr.value + " ");
					add = add + curr.value;
					if (curr.right != null) {
						q.add(curr.right);
					}
					if (curr.left != null) {
						q.add(curr.left);
					}

					size--;
				}
				flag = true;
			}
			ar.add(add);
		}

	}

	static void vertical(TreeValue tree) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		q.add(tree);
		while (!q.isEmpty()) {
			TreeValue temp = q.poll();
			int curr = temp.height;
			if (map.get(curr) == null) {
				map.put(curr, temp.value);
			} else {
				int ar = map.get(curr);
				ar = ar + temp.value;
				map.put(curr, ar);

			}
			if (temp.left != null) {
				temp.left.height = curr - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = curr + 1;
				q.add(temp.right);
			}
		}
		map.entrySet().stream().forEach(a -> System.out.println(a.getKey() + " " + a.getValue()));
	}

	static void printriyansidebottom(TreeValue tree, int height) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			System.out.print(tree.value + " ");
		}
		if (height == sum) {
			System.out.print(tree.value + " ");
			sum = sum + 1;
		}
		printriyansidebottom(tree.left, height + 1);
		printriyansidebottom(tree.right, height + 1);

	}

	void printbottim(TreeValue tree, int height) {
		TreeMap<Integer, Integer> hashmap = new TreeMap<Integer, Integer>();
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		q.add(tree);
		while (!q.isEmpty()) {
			TreeValue tr = q.poll();
			int curr = tr.height;
			hashmap.put(curr, tr.value);
			if (tr.left != null) {
				tr.left.height = curr - 1;
				q.add(tr.left);
			}
			if (tr.right != null) {
				tr.right.height = curr + 1;
				q.add(tr.right);
			}
		}

	}

	static void printTop(TreeValue tree, int height) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		q.add(tree);
		hashmap.put(tree.height, tree.value);
		while (!q.isEmpty()) {
			TreeValue curr = q.poll();
			int hd = curr.height;
			if (hashmap.get(hd) == null) {
				hashmap.put(tree.height, tree.value);
			}
			if (curr.left != null) {
				curr.left.height = hd - 1;
				q.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.height = hd + 1;
				q.add(curr.right);
			}
		}

	}

	static int getLevelNode(TreeValue tree, int value, int position) {
		if (tree == null) {
			return position;
		}
		if (value == tree.value) {
			return position;
		}
		int d = getLevelNode(tree.left, value, position + 1);
		if (d != 0) {
			return d;
		}
		d = getLevelNode(tree.right, value, position + 1);
		return d;
	}

	static TreeValue mirror(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		mirror(tree.left);
		mirror(tree.right);
		return tree;
	}

	static void postorderiterate(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.push(tree);
		Stack<Integer> temp = new Stack<Integer>();
		while (!st.isEmpty()) {
			TreeValue curr = st.pop();
			temp.add(curr.value);
			if (curr.left != null) {
				st.push(curr.left);
			}
			if (curr.right != null) {
				st.push(curr.right);
			}
		}
		while (!temp.isEmpty()) {
			System.out.print(temp.pop() + " ");
		}

	}

	static void inorderIterate(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.push(tree);
		while (!st.isEmpty()) {
			while (tree != null) {
				st.push(tree);
				tree = tree.left;
			}

			TreeValue tv = st.pop();
			System.out.print(tv.value + " ");
			if (tv.right != null) {
				st.add(tv.right);
			}
		}
	}

	static void onlyRight(TreeValue tree, int value) {
		for (int i = 0; i < value; i++) {
			printValue(tree, i);
		}
	}

	static void onlyLeft(TreeValue tree, int value) {
		if (tree == null) {
			return;
		}
		if (value == sum) {
			System.out.print(tree.value + " ");
			sum = sum + 1;

		}
		onlyLeft(tree.left, value + 1);
		onlyLeft(tree.right, value + 1);
	}

	static void recursiveprinttree(TreeValue tree) {
		Queue<TreeValue> q = new LinkedList<TreeValue>();
		Stack<Integer> st = new Stack<Integer>();
		q.add(tree);
		while (!q.isEmpty()) {
			TreeValue t = q.poll();
			st.push(t.value);
			if (t.right != null) {
				q.add(t.right);
			}
			if (t.left != null) {
				q.add(t.left);
			}
		}

		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println();
	}

	static int countleaves(TreeValue tree, int add) {
		if (tree == null) {
			return add;
		}
		if (tree.left == null && tree.right == null) {

			add = add + 1;
		}

		int dc = countleaves(tree.left, add);
		dc = countleaves(tree.right, dc);
		return dc;
	}

	static void inorderIterative(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.push(tree);
		while (!st.isEmpty()) {
			TreeValue curr = st.peek();
			System.out.print(curr.value + " ");
			st.pop();
			if (curr.right != null) {

				st.push(curr.right);
			}

			if (curr.left != null) {
				st.push(curr.left);
			}

		}
	}

	static void preorderiterattive(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		st.add(tree);
		while (!st.isEmpty()) {
			TreeValue curr = st.peek();
			System.out.print(curr.value + " ");
			st.pop();
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}

		}
	}

	static Stack<Integer> st = new Stack<Integer>();
	static int add = 0;

	static void printsum(TreeValue tree, int sum) {
		if (tree == null) {
			return;
		}
		add = add + tree.value;
		st.push(add);
		if (add == sum) {
			for (int i = 0; i < st.size(); i++) {
				System.out.println(st.get(i));
			}
		}
		printsum(tree.left, sum);
		printsum(tree.right, sum);
		add = add - tree.value;
		st.pop();
	}

	static void preoprderrecursive(TreeValue tree) {
		Stack<TreeValue> st = new Stack<TreeValue>();
		TreeValue temp = tree;
		while (temp != null || st != null) {
			if (temp != null) {
				st.push(temp);
				temp = temp.left;
			} else {
				TreeValue curr = st.peek().right;
				if (curr == null) {
					TreeValue tr = st.pop();
					System.out.print(tr.value + " ");
					if (!st.isEmpty() && tr.right == null) {
						System.out.print(st.pop().value + " ");
					}
				} else {
					temp = curr;
				}
			}
		}

	}

}
