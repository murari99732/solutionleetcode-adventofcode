package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class TreeValue<K, V> {
	class Hash {
		K key;
		V value;
	}

	LinkedList<Hash>[] list;
	int size;

	public TreeValue() {
		init(4);
		size = 0;
	}

	private void init(int i) {
		list = new LinkedList[i];
		for (int j = 0; j < list.length; j++) {
			list[j] = new LinkedList<Hash>();
		}

	}

	void push(K key, V value) {
		int f = gethashing(key);
		int g = bucketlist(key, f);
		if (g == -1) {
			list[f].add(new Hash());
		} else {
			Hash p = list[f].get(g);
			p.key = key;
			p.value = value;
			list[f].add(p);

		}
		int lambada = size / list.length;
		if (lambada > 2)
			rehash();
	}

	private void rehash() {
		LinkedList<Hash>[] pl = list;
		for (int i = 0; i < pl.length; i++) {
			for (Hash e : list[i]) {
				push(e.key, e.value);
			}
		}

	}

	private int bucketlist(K key, int f) {
		int d = 0;
		for (Hash a : list[f]) {
			if (a.key == key) {
				return d;
			}
			d++;
		}
		return 0;
	}

	private int gethashing(K key) {
		int a = key.hashCode();
		return a % ar.size();
	}

	static class Tree {
		int value;
		Tree left;
		Tree right;
	}

	static ArrayList<Integer> ar = new ArrayList<Integer>();

	static boolean add(TrieValue t, String value, int i) {
		if (t == null) {
			return false;
		}
		if (i == value.length()) {
			return t.flag;
		}
		char c = value.charAt(i);
		if (c == '.') {
			for (int j = 0; j < 26; j++) {
				if (add(t.child[j], value, i + 1)) {
					return true;
				}
			}
		} else {
			if (add(t.child[i - 'a'], value, i + 1)) {
				return true;
			}
		}
		return false;
	}

	static void getValue(Tree tree) {
		if (tree == null) {
			return;
		}
		ar.add(tree.value);
		getValue(tree.left);
		getValue(tree.right);
		int sum = 0;
		for (int i = ar.size() - 1; i >= 0; i--) {
			sum = sum + ar.get(i);
			if (sum == 9) {
				for (int j = i; j < ar.size(); j++) {
					System.out.println(ar.get(j));
				}
			}
		}
		ar.remove(ar.size() - 1);

	}

	static int climbing(int value, int arr[]) {
		if (value < 3) {
			return value;
		}
		if (arr[value] < 0) {
			return arr[value];
		}
		int v = climbing(value - 1, arr);
		int m = climbing(value - 2, arr);
		int n = climbing(value - 3, arr);
		arr[value] = Math.min(v, Math.min(m, n)) + 1;
		return Math.min(v, Math.min(m, n)) + 1;
	}

	static int max = 0;

	static void stock(int arr[], int i, String ans, int profit, boolean flag) {
		if (i == arr.length) {
			// System.out.println(ans);
			max = Math.max(max, profit);
			// System.out.println(max);
			return;
		}

		if (flag == false) {
			stock(arr, i + 1, ans + arr[i] + "+", profit - arr[i], true);
			stock(arr, i + 1, ans, profit, true);
		} else {
			stock(arr, i + 1, ans + arr[i] + "-", profit + arr[i], false);
			stock(arr, i + 1, ans, profit, false);
		}

	}

	static void getword(String word, Set<String> set, String ans) {
		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int j = 0; j < word.length(); j++) {
			String left = word.substring(0, j + 1);
			if (set.contains(left)) {
				getword(word.substring(j + 1, word.length()), set, ans + left + " ");
			}
		}
	}

	static Tree print(int pre[], int inorder[], int i, int j) {
		if (i > j) {
			return null;
		}
		Tree root = createTree(inorder[i]);
		int end = getval(i, pre);
		root.left = print(pre, inorder, i, end);
		root.right = print(pre, inorder, j + 1, inorder.length);
		return root;
	}

	private static int getval(int i, int[] pre) {
		for (int j = 0; j < pre.length; j++) {
			if (pre[j] == i) {
				return j;
			}
		}
		return 0;
	}

	private static Tree createTree(int i) {
		Tree tree = new Tree();
		tree.value = i;
		return tree;
	}

	static void adddigits(int value) {
		int sum = 0;
		boolean flag = false;
		while (sum > 9 && flag == false) {
			int v = value / 10;
			sum = sum + v;
			value = value % 10;
			if (value <= 9) {
				value = sum + value;
			}
			flag = true;

		}
		System.out.println(sum);
	}

	static int min = Integer.MAX_VALUE;

	static void minimumrotated(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (arr[mid] > arr[j]) {
				min = Math.min(min, arr[mid]);
				i = mid + 1;
			} else if (arr[mid] < arr[i]) {
				min = Math.min(min, arr[mid]);
				j = mid - 1;
			}
		}
	}

	static void adjacencylist(List<Edge> ar[]) {
		boolean b[] = new boolean[ar.length];
		for (int i = 0; i < ar.length; i++) {
			DFS(ar, i, b);
		}
	}

	private static void DFS(List<Edge>[] ar2, int i, boolean[] b) {
		b[i] = true;
		for (Edge e : ar2[i]) {
			if (b[e.destination] == false) {
				DFS(ar2, e.destination, b);
			}
		}

	}

	static class Edge {
		int src;
		int destination;
		int value;

		public Edge() {
			// TODO Auto-generated constructor stub
		}

		public Edge(int src, int destination) {
			super();
			this.src = src;
			this.destination = destination;
		}

	}

	static void binary(int a, int b) {
		int value = 0;
		int sum = 0;
		int carry = 0;
		while (a != 0 || b != 0) {
			int va = a != 0 ? a % 10 : 0;
			int wa = b != 0 ? b % 10 : 0;
			sum = carry + va + wa;
			if (sum > 1) {
				value = value * 10 + 1;
				carry = 1;
			} else {
				value = value * 10 + sum;
				carry = 0;
			}
			sum = 0;
			a = a / 10;
			b = b / 10;

		}
		System.out.println(value);
	}

	static void topfrequent(int arr[], int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			p.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if (p.peek() < arr[i]) {
				p.poll();
				p.add(arr[i]);
			}
		}
		System.out.println(p.peek());

	}

	static void topfrequentword(int arr[], int k) {
		TreeMap<Integer, Integer> hasmap = new TreeMap<Integer, Integer>((a, b) -> {
			return a - b;
		});
		for (int i = 0; i < arr.length; i++) {
			hasmap.put(arr[i], hasmap.getOrDefault(arr[i], 0) + 1);
		}
		int d = 0;
		for (Entry<Integer, Integer> has : hasmap.entrySet()) {
			if (d == 2) {
				System.out.println(hasmap.get(has.getKey()));
			}
			d++;
		}
	}

	static void powerx(int count, int value) {
		if (count == 0) {
			System.out.println(value);
			return;
		}
		powerx(count - 1, value * 2);
	}

	static void subsetarrayList(int arr[], int i, ArrayList<Integer> ar) {
		if (i == arr.length - 1) {
			System.out.println(ar);
			return;
		}
		ar.add(arr[i]);
		subsetarrayList(arr, i + 1, ar);
		ar.remove(ar.size() - 1);
		subsetarrayList(arr, i + 1, ar);
	}

	static void subset(int arr[], int i, String value) {
		if (i == arr.length - 1) {
			Set<String> set = new HashSet<String>();
			if (!set.contains(value)) {
				set.add(value);

			}
			return;

		}
		subset(arr, i + 1, value + arr[i] + " ");
		subset(arr, i + 1, value);
	}

	static void bitmanipulation(int value) {
		boolean flag = false;
		int temp;
		int j = 0;
		for (int i = 31; i >= 0; i--) {
			int d = 1 << i;
			if (flag == false) {
				if ((d & value) != 0) {
					flag = true;
				}
			} else {
				if ((d & value) != 0) {
					temp = 1 << j;
				} else {
					temp = 0 << j;
				}
				j--;

			}
		}
	}

	static void angle(int hour, int min) {

		int val = hour * 30;
		int str = (int) (0.5 * min);
		int tem = (min / 5) * 30;
		System.out.println(Math.abs(val + str - tem));
	}

	static void reverse(String word) {
		String temp = "";
		String val = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			if (word.charAt(i) != ' ') {
				temp = word.charAt(i) + temp;
			} else {
				val = val + temp + " ";
				temp = "";
			}
			if (i == 0) {
				val = val + temp + " ";
			}
		}
		System.out.println(val);
	}

	static int add(Node temp) {
		if (temp == null) {
			return 1;
		}
		int t = temp.data + add(temp.next);
		temp.data = t % 10;
		return t / 10;
	}

	private static Node insert(Node node) {
		if (node == null) {
			return null;
		}
		int c = add(node);
		if (c == 1) {
			Node head = null;
			head.next = node;
			return node;
		}
		return node;
	}

	Node alternative(Node node, int k) {
		Node temp = node;
		Node prev = null;
		Node next = null;
		int i = 0;
		while (temp != null && i != k) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			i++;
		}
		i = 0;
		while (temp != null && i != k) {
			temp = temp.next;
			i++;
		}
		if (temp.next != null) {
			temp.next = alternative(temp.next, k);
		}
		return prev;
	}

	Node group(Node head, int i) {
		if (head == null) {
			return null;
		}
		int d = i;
		Node node = head;
		Node prev = null;
		Node next = null;
		while (node != null && d != 0) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			d--;
		}
		if (next != null)
			head.next = group(node, i);
		return prev;
	}

	static void swapnodes(Node list, int value, int word) {
		Node temp = list;
		Node prev = null;
		Node next = null;
		while (temp.next != null) {
			if (temp.data == value) {
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		Node prevn = prev.next;
		prevn.next = null;
		while (temp.next != null) {
			if (temp.data == word) {
				break;
			}
			next = temp;
			temp = temp.next;
		}
		Node nnext = temp.next;
		temp.next = null;
		prev.next = temp;
		temp.next = prevn;

	}

	static Node recursive(Node node) {
		Node temp = node;
		Node prev = null;
		Node next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;

		}
		return prev;
	}

	static Node last(Node list) {
		Node node = list;
		while (node.next.next != null) {
			node = node.next;
		}
		Node temp = node.next;

		node.next = null;
		temp.next = list;
		return temp;
	}

	static Node push(Node list1) {
		int i = 0;
		Node list = list1;
		while (list.next != null) {
			if (i % 2 != 0) {
				list = list.next;
			} else {
				list.next = list.next.next;
			}
			i++;
		}
		return list1;
	}

	static class Node {
		int data;
		Node next;
	}

	public Node getNewNode(int key) {
		Node a = new Node();
		a.next = null;
		a.data = key;
		return a;
	}

	/*
	 * insert method is used to insert the element in Linked List
	 */
	public Node insert(int key, Node node) {

		if (node == null)
			return getNewNode(key);
		else
			node.next = insert(key, node.next);

		return node;
	}

	/*
	 * It'll print the complete linked list
	 */
	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	static class DoubleLinkedList {
		int value;
		DoubleLinkedList next;
		DoubleLinkedList prev;
		DoubleLinkedList child;

	}

	static void flatten(DoubleLinkedList list) {
		Stack<DoubleLinkedList> st = new Stack<TreeValue.DoubleLinkedList>();
		st.add(list);
		while (list != null) {
			if (list.child != null) {
				DoubleLinkedList child = list.child;
				if (list.next != null) {
					st.add(list.next);
					list.next.prev = null;
				}
				list.next = child;
				child.prev = list;
				list.child = null;
			}
		}
	}

	static void maximumvalue(int arr[], int i, int v, String ans) {
		if (i == 0) {
			System.out.println(ans);
			return;
		}
		maximumvalue(arr, i - 1, v + arr[i], ans + arr[i] + " ");
		maximumvalue(arr, i - 2, v + arr[i], ans + arr[i] + " ");
		maximumvalue(arr, i - 3, v + arr[i], ans + arr[i] + " ");

	}

	static void maximumwidth(Tree tree) {
		Queue<Tree> q = new LinkedList();
		q.add(tree);
		while (!q.isEmpty()) {
			int size = q.size();
			max = Math.max(size, max);
			while (size > 0) {
				Tree curr = q.poll();
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}

		}
	}

	static void increasing(int v) {
		if (v == 0) {
			return;
		}
		System.out.println(v);
		increasing(v - 1);
		System.out.println(v);
	}

	static int factorial(int v) {
		if (v == 0) {
			return 1;
		}
		int d = factorial(v - 1);
		return d * v;
	}

	static int maximum(int arr[], int i) {
		if (arr.length == i) {
			return 0;
		}
		int v = maximum(arr, i + 1);

		max = Math.max(v, arr[i]);

		return max;
	}

	static int firstoccurence(int arr[], int i) {
		if (i == arr.length) {
			return -1;
		}
		if (arr[i] == 5) {
			return i;
		}

		int v = firstoccurence(arr, i + 1);

		return v;
	}

	static int lastoccurence(int arr[], int i) {
		if (i == arr.length) {
			return -1;
		}

		int v = lastoccurence(arr, i + 1);
		if (arr[i] == 5) {
			return i;
		}
		return v;
	}

	static ArrayList<Integer> indexvalue(int arr[], int i, int v, ArrayList<Integer> ar) {
		if (i == arr.length) {
			System.out.println(ar);
			return ar;
		}
		ArrayList<Integer> b = indexvalue(arr, i + 1, v, ar);

		if (arr[i] == v) {
			b.add(i);
		}
		return b;
	}

	static ArrayList<String> getsusbsequnce(String a, int i, ArrayList<String> ar) {
		if (a.length() == 0) {
			ar.add("");
			return ar;
		}
		ArrayList<String> br = getsusbsequnce(a.substring(1), i, ar);
		for (String ac : br) {
			br.add(ac + "");
			br.add(ac + a.charAt(0));
		}
		return br;
	}

	static void subsequnce(String a, int i, String ans, ArrayList<Character> ct) {
		if (a.length() == 0) {
			System.out.println(ct);
			return;
		}
		ct.add(a.charAt(0));
		subsequnce(a.substring(1), i, ans + a.charAt(0) + " ", ct);
		ct.remove(ct.size() - 1);
		subsequnce(a.substring(1), i, ans, ct);
	}

	static void keypadremix(String a, String b[], String ans) {
		String word = b[a.charAt(0) - '0'];
		for (int j = 0; j < word.length(); j++) {
			keypadremix(a.substring(1), b, ans + b[j] + " ");
		}
	}

	static ArrayList<String> keydpad(String a, String b[], ArrayList<String> arr) {
		char c = a.charAt(0);
		String temp = a.substring(1);
		ArrayList<String> br = keydpad(temp, b, arr);
		String word = b[c];
		for (int i = 0; i < word.length(); i++) {
			char cd = word.charAt(i);
			for (String gc : br) {
				arr.add(cd + gc);
			}
		}
		return arr;
	}

	static void mazevalue(int m[][], int x, int y, String ans) {
		if (x > m.length || x < 0 || y > m.length || y < 0) {
			return;
		}
		if (x == m.length || y == m.length) {
			System.out.println(ans);
			return;
		}
		mazevalue(m, x + 1, y, ans + m[x][y]);
		mazevalue(m, x, y + 1, ans + m[x][y]);

	}

	static void permutate(String a, String ans) {
		if (0 == a.length()) {
			System.out.println(ans);
			return;
		}
		for (int j = 0; j < a.length(); j++) {
			char c = a.charAt(j);
			String ab = a.substring(0, j);
			String bc = a.substring(j + 1);
			permutate(ab + bc, ans + c + " ");
		}
	}

	static void encoding(String ab, String ans) {
		if (ab.length() == 0) {
			System.out.println(ans);
			return;
		}
		int c = Integer.parseInt(ab.substring(0, 1));

		encoding(ab.substring(1), ans + (char) (c + 'A' - 1) + " ");
		if (ab.length() > 2) {

			int bc = Integer.parseInt(ab.substring(0, 2));
			if (bc < 26) {
				encoding(ab.substring(2), ans + (char) (bc + 'A' - 1) + " ");
			}

		}
	}

	static void floodfill(int m[][], int i, int j, String ans, boolean b[][]) {
		if (i < 0 || i > m.length - 1 || j < 0 || j > m.length - 1 || b[i][j] == true || m[i][j] == 1) {
			return;
		}
		if (i == m.length - 1 && j == m.length - 1) {
			System.out.println(ans);
			return;
		}
		b[i][j] = true;
		floodfill(m, i + 1, j, ans, b);
		floodfill(m, i, j + 1, ans, b);
		b[i][j] = false;
	}

	static void subset(int arr[], int i, String ans, int value) {
		if (i == arr.length) {
			if (value == 9) {
				System.out.println(ans);
			}
			return;
		}
		subset(arr, i + 1, ans + arr[i] + " ", value + arr[i]);
		subset(arr, i + 1, ans, value);
	}

	static void snakeladders(int arr[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int d = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int v = q.poll();
				if (v == arr.length) {
					System.out.println(d + 1);
					return;
				}

				for (int i = v + 1; i < v + 6 && i < arr.length - 1; i++) {
					if (arr[i] == 0) {
						q.add(i);
					} else {
						q.add(arr[i]);
					}
				}
				size--;
			}
			d++;
		}
	}

	static void addone(int arr[]) {
		int brr[] = new int[arr.length];
		int curr = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			curr = arr[i] + 1 + curr;
			curr = curr / 10;
			brr[i] = curr % 10;
		}
	}

	static void helpful(int val1, int val2) {
		int sum = (val1 | val2);
		int d = 0;
		while (sum != 0) {
			int diff = (sum & -sum);
			sum = sum - diff;
			d++;
		}
		System.out.println(d);
	}

	static void twovalue(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}

		int diff = sum & -sum;
		int j = 0;
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((diff & arr[i]) == 0) {
				j = j ^ arr[i];
			} else {
				k = k ^ arr[i];
			}
		}

		System.out.println(j + " " + k);
	}

	static void prisoncells(int arr[], int n) {
		int d = n % arr.length;
		while (d != 0) {
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i - 1] == 1 && arr[i + 1] == 1) {
					arr[i] = 1;
				} else if (arr[i - 1] == 0 && arr[i + 1] == 0) {
					arr[i] = 1;
				} else {
					arr[i] = 0;
				}
			}
			d--;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void reversetraverse(Tree tree) {

		Queue<Tree> q = new LinkedList<TreeValue.Tree>();
		q.add(tree);
		ArrayList<ArrayList<Tree>> br = new ArrayList<ArrayList<Tree>>();
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Tree> ar = new ArrayList<TreeValue.Tree>();
			while (size > 0) {
				Tree temp = q.poll();
				ar.add(temp);
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				size--;
			}
			br.add(ar);
		}
	}

	static void MST(int m[][]) {
		int key[] = new int[m.length];
		int parent[] = new int[m.length];
		boolean b[] = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int i = 0; i < m.length; i++) {
			int minval = getmin(b, m, i);
			b[minval] = true;
			for (int j = 0; j < m.length; j++) {
				if (b[j] == false && m[minval][j] != 0 && m[minval][j] < key[j]) {
					key[j] = m[minval][j];
					parent[j] = minval;
				}
			}
		}
	}

	private static int getmin(boolean[] b, int[][] m, int i) {
		int max = -1;
		int valiue = Integer.MAX_VALUE;
		for (int j = 0; j < m.length; j++) {
			if (b[j] == false && valiue > m[i][j]) {
				valiue = m[i][j];
				max = j;
			}
		}
		return max;
	}

	static void minimumpathmeasure(ArrayList<Edge>[] ar, int src, int dest, String ans, boolean b[]) {
		if (src == dest) {
			max = Math.max(ans.length(), max);
			min = Math.min(ans.length(), min);
			return;
		}

		b[src] = true;
		for (Edge it : ar[src]) {
			if (b[it.destination] == false) {
				minimumpathmeasure(ar, it.src, dest, ans + it.destination + " ", b);
			}
		}
		b[src] = false;
	}

	static void constructor() {
		LinkedList<Edge>[] list = new LinkedList[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<TreeValue.Edge>();
		}
		list[0].add(new Edge());

	}

	static void BFS(Edge edge, ArrayList<Edge>[] ar) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		boolean b[] = new boolean[ar.length];
		queue.add(0);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			b[temp] = true;
			for (Edge it : ar[temp]) {
				if (b[it.destination] == false) {
					queue.add(it.destination);
				}
			}
		}
	}

	static void bipartite(ArrayList<Edge>[] ar) {
		int b[] = new int[ar.length];
		Queue<Integer> q = new LinkedList();
		q.add(0);
		while (q.isEmpty()) {
			int val = q.poll();
			if (b[val] != 0) {
				continue;
			}
			for (Edge e : ar[val]) {
				if (b[e.destination] == 0) {
					b[e.destination] = -b[val];
				}
			}
		}

	}

	static void playgame(int m[][]) {

	}

	static void sudoku(int c[][], int x, int y) {
		if (x == c.length && y == c.length) {
			return;
		}
		int dx = x;
		int dy = y;
		if (y == c.length) {
			dx = x + 1;
			dy = 0;
		} else {
			dx = x;
			dy = y + 1;
		}
		if (c[x][y] != -1) {
			sudoku(c, dx, dy);
		} else {
			for (int i = 1; i < 9; i++) {
				if (true) {
					c[x][y] = i;
					sudoku(c, dx, dy);
					c[x][y] = -1;
				}
			}
		}

	}

	static void nqueenutility(int m[][], int x) {

		if (x >= m.length) {
			System.out.println(m);
			return;
		}

		for (int i = 0; i < m.length; i++) {
			if (safevisit(m, x, i) == false) {
				m[x][i] = 1;
				nqueenutility(m, x + 1);
				m[x][i] = 0;
			}
		}

	}

	private static boolean safevisit(int[][] m, int x, int i) {

		for (int j = i; j >= 0; j--) {
			if (m[x][j] == 1) {
				return true;
			}
		}

		for (int j = x, k = i; k >= 0 && j >= 0; k--, j--) {
			if (m[j][k] == 1) {
				return true;
			}
		}
		for (int j = x, k = i; k < m.length && j >= 0; k++, j--) {
			if (m[j][k] == 1) {
				return true;
			}
		}

		return false;
	}

	static void print(int count, String value, String dec, int dc) {
		if (value.length() == 0) {
			System.out.println(dec);
			return;
		}
		if (dc == 0)
			print(count + 1, value.substring(1), dec + value.charAt(0), dc);
		else {
			print(count + 1, value.substring(1), dec + dc + value.charAt(0), dc);
		}
		print(count + 1, value.substring(1), dec, dc + 1);
	}

	static void help(int i, int value) {
		if (value < i) {
			return;
		}
		System.out.println(i);
		for (int j = 0; j < 9; j++) {
			help(10 * i + j, value);
		}
	}

	static void gold(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];

		for (int i = 0; i <= m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (b[i][j] == false)
					getgold(m, i, j, 0, b);
			}
		}

	}

	static void getgold(int m[][], int x, int y, int value, boolean b[][]) {
		if (x < 0 || x > m.length || y < 0 || y > m.length || b[x][y] == true) {
			return;
		}
		b[x][y] = true;
		value = value + m[x][y];
		max = Math.max(max, value);
		getgold(m, x + 1, y, value, b);
		getgold(m, x, y + 1, value, b);
		getgold(m, x - 1, y, value, b);
		getgold(m, x, y - 1, value, b);
	}

	static void getdonein(int arr[], int val) {
		// array mei 20 value daldijye and val ko 2 mean kr dijiye as 2 gb
		int div = arr.length / val;
		int count = 0;
		ArrayList<ArrayList<Integer>> finalarray = new ArrayList<ArrayList<Integer>>();
		Collections.sort(finalarray, (a, b) -> {
			return b.get(0) - a.get(0);
		});

		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> store = new ArrayList<Integer>();
			store.add(arr[i]);
			if (count == val - 1) {
				finalarray.add(new ArrayList<Integer>(store));

				count = 0;
			}
			count++;
		}
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>();

		for (int i = 0; i < finalarray.size(); i++) {
			pr.add(finalarray.get(i).get(0));
			finalarray.get(i).remove(0);
		}

		ArrayList<Integer> finalstore = new ArrayList<Integer>();
		while (!finalarray.isEmpty()) {
			for (int i = 0; i < finalarray.size(); i++) {
				if (pr.peek() <= finalarray.get(i).get(0)) {
					finalstore.add(pr.poll());
					pr.add(finalarray.get(i).get(0));
					finalarray.get(i).remove(0);
				}
			}

		}
		System.out.println(finalstore);

	}

	static void friendpairing(int arr[], int i, String a, boolean b[]) {
		if (i == arr.length) {
			System.out.println(a);
			return;
		}
		friendpairing(arr, i + 1, a + arr[i] + "-", b);
		b[i] = true;
		for (int j = i + 1; j < arr.length; j++) {
			if (b[j] == false)
				b[j] = true;
			friendpairing(arr, i + 1, a + "{" + arr[i] + "-" + arr[j] + "}", b);
			b[j] = false;
		}
		b[i] = false;

	}

	static void subsetval(int arr[], int i, String ans, String val) {
		if (i == arr.length) {
			System.out.println(ans + " " + val);
			return;
		}
		subsetval(arr, i + 1, ans + arr[i], val);
		subsetval(arr, i + 1, ans, val + arr[i]);
	}

	static void getpalindrome(String val, String ans) {
		if (val.length() == 0) {
			int i = 0;
			boolean flag = false;
			int j = ans.length() - 1;
			while (i < j) {
				if (ans.charAt(i) != ans.charAt(j)) {
					flag = true;
				}
				i++;
				j--;
			}
			if (!flag) {
				System.out.println(ans);
			}
			return;
		}
		getpalindrome(val.substring(1), ans + val.charAt(0));
		getpalindrome(val.substring(1), ans);
	}

	static void palindromic(String a, String ans, int i) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int j = 0; j < a.length(); j++) {
			String ba = a.substring(0, j + 1);
			if (palindrome(ba)) {
				palindromic(a.substring(j + 1), ans + ba + " ", i);
			}
		}

	}

	static void equalsusbset(int arr[], int i, int val, String ans, ArrayList<Integer> ar) {
		if (i == arr.length) {
			System.out.println(ar);
			return;
		}
		ar.add(arr[i]);
		equalsusbset(arr, i + 1, val + arr[i], ans + arr[i] + " ", ar);
		ar.remove(ar.size() - 1);
		equalsusbset(arr, i + 1, val, ans, ar);
	}

	private static boolean palindrome(String ans) {
		int i = 0;
		boolean flag = true;
		int j = ans.length() - 1;
		while (i < j) {
			if (ans.charAt(i) != ans.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	static void wordpattern(String a, int j, String word, HashMap<Character, String> set, String ans) {

		char c = a.charAt(0);
		if (set.containsKey(c)) {
			String bc = set.get(c);
			if (bc.length() <= word.length()) {
				wordpattern(a.substring(1), j, word.substring(bc.length()), set, ans + word.substring(0, bc.length()));
			}

		} else {
			for (int i = 0; i < word.length(); i++) {
				set.put(c, word.substring(0, i));
				wordpattern(a.substring(1), j, word.substring(i), set, ans + word.substring(0, i));
				set.remove(set.size() - 1);
			}
		}
	}

	static void zmap(String a, String ans, Set<String> set) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			String bc = a.substring(0, i + 1);
			if (set.contains(bc)) {
				zmap(a.substring(i + 1), ans + bc + " ", set);
			}
		}
	}

	static void differnce(int arr[], int i, ArrayList<Integer> ar, ArrayList<Integer> br) {
		if (i == arr.length) {
			int diff = 0;
			for (int j = 0; j < ar.size(); j++) {
				diff = diff + ar.get(j);
			}
			int diffb = 0;
			for (int j = 0; j < br.size(); j++) {
				diffb = diffb + br.get(j);
			}
			min = Math.min(Math.abs(diffb - diff), min);
			return;
		}
		ar.add(arr[i]);
		differnce(arr, i + 1, ar, br);
		ar.remove(ar.size() - 1);
		br.add(arr[i]);
		differnce(arr, i + 1, ar, br);
		br.remove(br.size() - 1);
	}

	static void helpbox(int arr[], int i, int brr[], int j) {
		for (int k = 0; k < arr.length; k++) {
			arr[k] = brr[j];
			helpbox(arr, k, brr, j + 1);
			arr[k] = 0;
		}
	}

	static void wordsearch(char c[][], int x, int y, String a, int i, String value) {

		if (x > c[0].length || y > c.length || x < 0 || y < 0) {
			System.out.println(value);
			return;
		}
		if (value.equals(a)) {
			System.out.println(true);
		}

		if (c[x][y] == a.charAt(i)) {
			wordsearch(c, x + 1, y, a, i + 1, value + a.charAt(i));
			wordsearch(c, x, y + 1, a, i + 1, value + a.charAt(i));
			wordsearch(c, x - 1, y, a, i + 1, value + a.charAt(i));
			wordsearch(c, x, y - 1, a, i + 1, value + a.charAt(i));
		}
	}

	static void find(char c[][], Set<String> set) {
		ArrayList<ArrayList<String>> at = new ArrayList<>();
		ArrayList<String> ar = new ArrayList<>();
		boolean b[][] = new boolean[c.length][c[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if (b[i][j] == false) {
					wordsearchset(c, set, b, i, j, ar, "");
					at.add(ar);
				}
			}
		}
	}

	static void wordsearchset(char c[][], Set<String> set, boolean b[][], int x, int y, ArrayList<String> ar,
			String ans) {
		if (x == c[0].length - 1 || y == c.length - 1 || x == -1 || y == -1 || b[x][y]) {
			return;
		}
		if (set.contains(ans)) {
			System.out.println(ans);
			ar.add(ans);
		}
		b[x][y] = true;
		wordsearchset(c, set, b, x + 1, y, ar, ans + c[x][y]);
		wordsearchset(c, set, b, x, y + 1, ar, ans + c[x][y]);
		wordsearchset(c, set, b, x, y - 1, ar, ans + c[x][y]);
		wordsearchset(c, set, b, x - 1, y, ar, ans + c[x][y]);
		b[x][y] = false;

	}

	static void friendscircle(int arr[][]) {
		boolean b[] = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (b[i] == false)
				connectedcomponents(arr, i, b);
		}
	}

	private static void connectedcomponents(int[][] arr, int i, boolean[] b) {
		b[i] = true;
		for (int j = 0; j < arr[i].length; j++) {
			if (b[j] == false) {
				connectedcomponents(arr, j, b);
			}
		}

	}

	static void topologicalsorting(ArrayList<Edge>[] ar) {
		Stack<Integer> st = new Stack<Integer>();
		boolean b[] = new boolean[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (b[i] == false) {
				topologicalutil(ar, i, b, st);
			}
		}
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	private static void topologicalutil(ArrayList<Edge>[] ar2, int i, boolean[] b, Stack<Integer> st) {
		b[i] = true;
		for (Edge it : ar2[i]) {
			if (b[it.destination] == false) {
				topologicalutil(ar2, it.destination, b, st);
			}
		}
		st.push(i);

	}

	static void graphbipartite(ArrayList<Edge> ar[]) {
		int flag[] = new int[ar.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(ar[0].get(0).src);
		while (!q.isEmpty()) {
			int parent = q.poll();
			for (Edge it : ar[parent]) {
				if (flag[it.destination] == 0) {
					flag[it.destination] = -flag[parent];
					q.add(it.destination);
				} else {
					if (flag[it.destination] == flag[parent]) {
						System.out.println("cycle");
						return;
					}
				}
			}
		}
	}

	static class Vertices {
		int src;
		int dest;
	}

	static void reconstruct(ArrayList<Vertices> ar[]) {

		boolean b[] = new boolean[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (b[i] == false) {
				DFSUtility(ar, i, b);
			}
		}

	}

	private static void DFSUtility(ArrayList<Vertices>[] ar2, int i, boolean[] b) {
		b[i] = true;

		for (Vertices it : ar2[i]) {
			if (b[it.dest] == false) {
				DFSUtility(ar2, it.dest, b);
			}
		}

	}

	static void lexograph(ArrayList<ArrayList<String>> ar) {
		HashMap<String, PriorityQueue<String>> hasmp = new HashMap<String, PriorityQueue<String>>();
		for (ArrayList<String> st : ar) {
			String a = st.get(0);
			String b = st.get(1);
			PriorityQueue<String> pt = new PriorityQueue<String>();
			if (!hasmp.containsKey(a)) {
				pt.add(b);
				hasmp.put(a, pt);
			} else {
				PriorityQueue<String> ptr = hasmp.get(a);
				ptr.add(b);
				hasmp.put(a, ptr);
			}
		}

		ArrayList<String> str = new ArrayList<String>();
		DFSutilitylexo("ABC", hasmp, str);

	}

	private static void DFSutilitylexo(String string, HashMap<String, PriorityQueue<String>> hasmp,
			ArrayList<String> str) {
		PriorityQueue<String> pr = hasmp.get(string);
		while (!pr.isEmpty()) {
			String tr = pr.poll();
			str.add(tr);
		}
	}

	static void referal(int value, int sum, String ans) {
		if (sum == value) {
			System.out.println(ans);
		}
		if (sum > value) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i * i <= value; i++) {
			int cost = i * i;
			if (cost < value) {
				referal(value - cost, sum + cost, ans + cost + " ");
			}
		}
	}

	static class Plastic {
		int src;
		ArrayList<Plastic> pr = new ArrayList<TreeValue.Plastic>();
	}

	static void mapgetvalue(Plastic plastic) {
		Map<Plastic, Plastic> map = new HashMap<>();
		Queue<Plastic> q = new LinkedList<Plastic>();
		q.add(plastic);
		while (q.isEmpty()) {
			Plastic pl = q.poll();
			for (Plastic it : plastic.pr) {
				if (!map.containsKey(pl)) {
					map.put(pl, it);
					q.add(pl);
				}
				map.get(pl).pr.add(it);

			}
		}
	}

	static int treevalue(Tree tree) {
		if (tree == null) {
			return 0;
		}
		int d = treevalue(tree.left);
		int e = treevalue(tree.right);
		return tree.value + d + e;
	}

	public Tree createNewNode(int val) {
		Tree newNode = new Tree();
		newNode.value = val;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	static void treeadd(Tree tree, Integer ab, ArrayList<Integer> ar) {
		if (tree == null) {
			ar.add(ab);
			return;
		}
		treeadd(tree.left, ab * 10 + tree.value, ar);
		treeadd(tree.right, ab * 10 + tree.value, ar);
	}

	static int smallestdeepest(Tree tree, int count) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			max = Math.max(max, count);
			return max;
		}
		int dc = smallestdeepest(tree.left, count + 1);
		int fc = smallestdeepest(tree.right, count + 1);
		if (fc != -1 && dc != -1) {
			return tree.value;
		}
		if (fc != -1) {
			return fc;
		} else {
			return dc;
		}
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("FOR");
		set.add("GEEKS");
		set.add("GEEK");
		set.add("PRACTICE");
		set.add("IDE");
		set.add("MNO");
		// powerx(3, 1);
		Tree head = null;

//				.println(indexvalue(new int[] { 2, 1, 4, 2, 5, 3, 6, 8, 5, 3, 5, 9 }, 0, 5, new ArrayList<Integer>()));
		// ArrayList<String> bc= getsusbsequnce("ABCDEF", 0, new ArrayList<String>());
		// floodfill(new int[][] {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0},
		// {0,0,0,0,0}}, 0,0,"",new boolean [][] {});

		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		TreeValue a = new TreeValue();
		Tree root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);

		ArrayList<Integer> pt = new ArrayList<Integer>();
		treeadd(root, 0, pt);
		System.out.println(pt);

	}

}
