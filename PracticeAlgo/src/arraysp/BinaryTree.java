package arraysp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class Tree {
		int data;
		int height;
		Tree left;
		Tree right;
	}

	static Tree createNewNode(int i) {
		Tree tr = new Tree();
		tr.data = i;
		return tr;
	}

	static int sum(Tree tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return tree.data;
		}
		int d = sum(tree.left);
		int e = sum(tree.right);
		int df = 0;
		if (d != -1 && e != -1) {
			return tree.data + d + e;
		}
		return df;
	}

	static int diff(Tree tree) {
		if (tree == null) {
			return 0;
		}

		int d = sum(tree.left);
		int e = sum(tree.right);
		int df = 0;
		if (d != Integer.MAX_VALUE && e != Integer.MAX_VALUE) {
			return (d + e) - tree.data;
		}
		return df;
	}

	static int size(Tree tree, int count) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return count + 1;
		}
		int d = size(tree.left, count);
		int e = size(tree.right, count);
		return d + e;
	}

	static int height(Tree tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int d = height(tree.left);
		int e = height(tree.right);
		return Math.max(d, e) + 1;
	}

	static void print(Tree tree, int val) {
		if (tree == null) {
			return;
		}

		if (val == 0) {
			System.out.print(tree.data + " ");
		}
		print(tree.left, val - 1);
		print(tree.right, val - 1);
	}

	static void printlevel(Tree tree) {
		int size = size(tree, 0);
		for (int i = 0; i < size; i++) {
			print(tree, i);
			System.out.println();
		}
	}

	static void recursionprint(Tree tree) {
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(tree);
		while (!q.isEmpty()) {
			Tree temp = q.poll();
			System.out.println(temp.data + " ");
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	static int max = 0;

	static void leftview(Tree tree, int count) {
		if (tree == null) {
			return;
		}
		if (max == count) {
			System.out.print(tree.data + " ");
			max++;
		}
		leftview(tree.right, count + 1);
		leftview(tree.left, count + 1);
	}

	static void inorder(Tree tree) {
		Stack<Tree> stack = new Stack<BinaryTree.Tree>();
		stack.add(tree);
		while (!stack.isEmpty()) {
			Tree temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);

			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	static void preorder(Tree tree) {
		Stack<Tree> stack = new Stack<BinaryTree.Tree>();
		stack.add(tree);
		while (tree.left != null) {
			if (tree.left != null)
				stack.push(tree.left);
			tree = tree.left;
		}
		while (!stack.isEmpty()) {
			Tree temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				stack.add(temp.left);
			}
			if (temp.right != null) {
				stack.add(temp.right);
			}

		}
	}

	static void postorder(Tree tree) {
		if (tree == null) {
			return;
		}
		Stack<Tree> st = new Stack<BinaryTree.Tree>();
		Stack<Tree> pt = new Stack<BinaryTree.Tree>();
		st.add(tree);
		while (!st.isEmpty()) {
			Tree tr = st.pop();
			pt.push(tr);
			if (tr.right != null) {
				st.push(tr.right);
			}
			if (tr.left != null) {
				st.push(tr.left);
			}

		}
		while (!pt.isEmpty()) {
			System.out.print(pt.pop().data + " ");
		}
	}

	static int level(Tree tree, int count, int dc) {
		if (tree == null) {
			return -1;
		}

		if (tree.data == count) {
			return dc;
		}
		int d = level(tree.left, count, dc + 1);
		int e = level(tree.right, count, dc + 1);
		if (d != -1) {
			return d;
		} else {
			return e;
		}
	}

	static void topview(Tree tree) {
		TreeMap<Integer, ArrayList<Integer>> hasmap = new TreeMap<Integer, ArrayList<Integer>>();

		Queue<Tree> q = new LinkedList<BinaryTree.Tree>();
		q.add(tree);
		while (!q.isEmpty()) {
			Tree temp = q.poll();
			if (!hasmap.containsKey(temp.height)) {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				ar.add(temp.data);
				hasmap.put(temp.height, ar);
			} else {
				ArrayList<Integer> ar = hasmap.get(temp.height);
				ar.add(temp.data);
				hasmap.put(temp.height, ar);
			}
			int height = temp.height;
			if (temp.left != null) {
				temp.left.height = height - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.height = height + 1;
				q.add(temp.right);
			}
		}
		System.out.println(hasmap);

	}

	static boolean search(Tree tree, int data) {
		if (tree == null) {
			return false;
		}
		if (tree.data == data) {
			return true;
		}
		return search(tree.left, data) || search(tree.right, data);
	}

	static ArrayList<Integer> ar = new ArrayList<Integer>();
	static ArrayList<Integer> br = new ArrayList<Integer>();
	static int sum = 0;

	static void printvalue(Tree tree, int v, int u, String ans) {
		if (tree == null) {
			return;
		}
		sum = sum + tree.data;
		ar.add(tree.data);
		if (sum > 18) {
			System.out.println(ar);
		}
		printvalue(tree.left, v + tree.data, u, ans + tree.data + " ");
		printvalue(tree.right, v, tree.data + u, ans + tree.data + " ");
		sum = sum - tree.data;
		ar.remove(ar.size() - 1);

	}

	static int width = 0;

	static void prinetelement(Tree tree, int count) {
		if (tree == null) {
			return;
		}
		if (2 == count) {
			width = width + 1;
		}
		prinetelement(tree.left, count + 1);
		prinetelement(tree.right, count + 1);

	}

	static int width(Tree tree) {
		if (tree == null) {
			return 0;
		}

		int a = width(tree.left);
		int b = width(tree.right);

		if (a == 1 || b == 1) {
			System.out.println(tree.data);
			width++;
		}
		return Math.max(a, b) + 1;
	}

	static void createdouble(Tree tree) {
		if (tree == null) {
			return;
		}
		createdouble(tree.left);
		createdouble(tree.right);
		Tree temp = createNewNode(tree.data);
		tree.left = temp;
		tree = tree.left;

	}

	static int getdiameter(Tree tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int a = getdiameter(tree.left);
		int b = getdiameter(tree.right);
		if (a != 0 && b != 0)
			max = Math.max(a + b + 1, max);
		return Math.max(a, b) + 1;
	}

	static int heightbalance(Tree tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int d = heightbalance(tree.left);
		int e = heightbalance(tree.right);
		if (Math.abs(d - e) > 2) {
			return -3;
		}
		if (d == -3 || e == -3) {
			return -3;
		}
		return Math.max(d, e) + 1;

	}

	static void matchsum(Tree tree) {
		if (tree == null) {
			return;
		}
		sum = sum + tree.data;
		ar.add(tree.data);
		if (tree.left == null && tree.right == null) {
			if (sum > 10) {
				System.out.println(ar);
			}

		}
		matchsum(tree.left);
		matchsum(tree.right);
		sum = sum - tree.data;
		ar.remove(ar.size() - 1);
	}

	static void pritnleaf(Tree tree, String ans, String ts) {
		if (tree == null) {

			return;
		}
		ar.add(tree.data);
		if (tree.left == null && tree.right == null) {
			System.out.println(ar);

		}
		pritnleaf(tree.left, ans + tree.data + " ", ts);
		pritnleaf(tree.right, ans, ts + tree.data + " ");
		ar.remove(ar.size() - 1);
	}

	static void maxsumleaf(Tree tree) {
		if (tree == null) {
			return;
		}
		sum = sum * 10 + tree.data;
		if (tree.left == null && tree.right == null) {
			ar.add(sum);
		}
		maxsumleaf(tree.left);
		maxsumleaf(tree.right);
		sum = (sum - tree.data) / 10;
	}

	static void minheight(Tree tree, int count) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null) {
			max = max + tree.data;
			return;
		}
		minheight(tree.left, count + 1);
		minheight(tree.right, count + 1);

	}

	static void sumleft(Tree tree, boolean flag) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && flag == true) {
			max = max + tree.data;
		}
		sumleft(tree.left, true);
		sumleft(tree.right, false);
	}

	static void checklevel(Tree root, int count) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (max == 0) {
				max = count;
			}
			if (max != count) {
				System.out.println(false);
			} else {
				System.out.println(true);
			}
		}
		checklevel(root.left, count + 1);
		checklevel(root.right, count + 1);
	}

	static void checkvalid(Tree tree, Set<Integer> set, Set<Integer> pet) {
		if (tree == null)
			return;
		pet.add(tree.data);
		if (pet.equals(set)) {
			System.out.println(true);
		}

		checkvalid(tree.left, set, pet);
		checkvalid(tree.right, set, pet);
	}

	static boolean checkvalid(Tree tree, int arr[], int index) {
		if (tree == null) {
			return false;
		}
		if (arr[index] != tree.data) {
			return false;
		}

		return checkvalid(tree.left, arr, index + 1) || checkvalid(tree.right, arr, index + 1);
	}

	static Tree ancestor(Tree tree, int value) {
		if (tree == null) {
			return null;
		}
		if (tree.data == value) {
			return tree;
		}
		Tree t1 = ancestor(tree.left, value);
		Tree t2 = ancestor(tree.right, value);
		if (t1 != null) {
			ar.add(tree.data);
			return tree;
		} else if (t2 != null) {
			ar.add(tree.data);
			return tree;
		}
		return t1 == null ? t2 : t1;
	}

	static int getvaluereturn(Tree tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.data == 11) {
			return -2;
		}
		int r = getvaluereturn(tree.left);
		int l = getvaluereturn(tree.right);
		if (r == max || l == max) {
			return max;
		}
		if (l != -1) {
			max = tree.data;
			return tree.data;
		} else if (r != -1) {
			max = tree.data;
			return tree.data;
		}
		return r != -1 ? r : l;
	}

	static Tree siblingvalue(Tree tree, int value) {
		if (tree == null) {
			return null;
		}
		if (tree.data == value) {
			return tree;
		}
		Tree t = siblingvalue(tree.left, value);
		Tree s = siblingvalue(tree.right, value);
		if (max != 0) {
			return t != null ? t : s;
		}
		if (t != null) {
			max = tree.right.data;
			return tree;
		} else if (s != null) {
			max = tree.left.data;
			return tree;
		}
		return t != null ? t : s;
	}

	static int sax = 0;

	static void siblingornot(Tree tree, int val, int val2, int count) {
		if (tree == null) {
			return;
		}
		if (val == tree.data) {
			max = count;
		}
		if (val == tree.data) {
			sax = count;
		}
		siblingornot(tree.left, val, val2, count + 1);
		siblingornot(tree.right, val, val2, count + 1);
	}

	static Tree lowest(Tree tree, int i, int j) {
		if (tree == null) {
			return null;
		}
		if (tree.data == i)
			return tree;
		if (tree.data == j) {
			return tree;
		}
		Tree tr = lowest(tree.left, i, j);
		Tree pr = lowest(tree.right, i, j);
		if (tr != null && pr != null) {
			max = tree.data;
			return tree;
		}
		return tr != null ? tr : pr;
	}

	static void distanceprint(Tree tree) {
		if (tree == null) {
			return;
		}
		ar.add(tree.data);
		if (tree.left == null && tree.right == null) {

			boolean flag = false;
			for (int i = 0; i < ar.size(); i++) {
				if (ar.get(i) == 7) {
					flag = true;
					max = i;
				}
			}
			if (flag)
				System.out.println(ar.get(max) + "->" + ar.get(max - 1) + " " + ar.get(max + 1));
		}
		distanceprint(tree.left);
		distanceprint(tree.right);
		ar.remove(ar.size() - 1);
	}

	static int kdistancefromleaf(Tree tree, int k) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 0;
		}
		Integer a = kdistancefromleaf(tree.left, k);
		Integer b = kdistancefromleaf(tree.right, k);
		if (a != -1 && a == k || b != -1 && b == k) {
			System.out.print(tree.data + " ");
		}
		return Math.max(a, b) + 1;
	}

	static class DoubleLinkedList {
		int data;
		DoubleLinkedList next;
		DoubleLinkedList prev;
	}

	static Tree prev;
	static Tree head;

	static void doublelinked(Tree tree) {
		if (tree == null) {
			return;
		}

		doublelinked(tree.left);
		if (head == null) {
			head = tree;
			prev = head;
		} else {
			prev.left = tree;
			tree.right = prev;
			prev = tree;

		}
		doublelinked(tree.right);
	}

	private static DoubleLinkedList createdouble(int val) {
		DoubleLinkedList ls = new DoubleLinkedList();
		ls.data = val;
		return ls;
	}

	static void pointernext(Tree tree) {
		if (tree == null) {
			return;
		}
		pointernext(tree.left);
		if (prev != null) {
			prev.left = tree;
		}
		prev = tree;
		pointernext(tree.right);
	}

	static void checksum(Tree tree) {
		if (tree == null) {
			return;
		}
		if (tree.left != null && tree.right != null && tree.data != tree.left.data + tree.right.data) {
			System.out.println(false);
		}
		checksum(tree.left);
		checksum(tree.right);
	}

	static int checksumfrombottom(Tree tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return tree.data;
		}
		int a = checksumfrombottom(tree.left);
		int b = checksumfrombottom(tree.right);
		if (a == -2 || b == -2) {
			return -2;
		}
		if (tree.data != a + b) {
			return -2;
		} else
			return tree.data;
	}

	static void maximumsumleaf(Tree tree) {
		if (tree == null) {
			return;
		}
		sum = sum + tree.data;
		if (tree.left == null && tree.right == null) {
			ar.add(sum);
		}
		maximumsumleaf(tree.left);
		maximumsumleaf(tree.right);
		sum = sum - tree.data;
	}

	static void maximumsumpath(Tree tree) {
		if (tree == null) {
			return;
		}
		ar.add(tree.data);
		maximumsumpath(tree.left);
		maximumsumpath(tree.right);

		int sum=0;
		for (int i = ar.size() - 1; i >= 0; i--) {
			sum = sum + ar.get(i);
			max = Math.max(max, sum);
		}
		ar.remove(ar.size() - 1);
	}
	
	

	public static void main(String[] args) {
		Tree root = createNewNode(5);
		root.left = createNewNode(2);
		root.right = createNewNode(3);

		// pritnleaf(root, "", "");

		maximumsumpath(root);
		System.out.println(max);

	}
}
