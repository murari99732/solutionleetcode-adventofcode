package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import LeetCode.Advent3.Cordinate;

public class Codebix {

	static void findword(String ans) {

		boolean flag = true;
		if (ans.charAt(0) >= 'A' && ans.charAt(0) <= 'Z') {
			flag = true;
		}

		boolean flag1 = false;
		if (ans.charAt(0) >= 'a' && ans.charAt(0) <= 'z') {
			flag1 = true;
		}
		for (int i = 1; i < ans.length(); i++) {
			if (flag == true && ans.charAt(i) >= 'A' && ans.charAt(i) <= 'Z') {
				flag = true;
			} else if (ans.charAt(i) >= 'a' && ans.charAt(i) <= 'z') {
				flag = false;

			}
			if (flag1 == true && ans.charAt(i) >= 'a' && ans.charAt(i) <= 'z') {
				flag1 = true;
			} else if (ans.charAt(i) >= 'A' && ans.charAt(i) <= 'Z') {
				flag1 = false;
			}
		}

		if (flag1 == true || flag == true) {
			System.out.println("correct");
			return;
		}
		boolean df = true;
		if (flag1 == false && flag == false) {

			if (ans.charAt(0) >= 'A' && ans.charAt(0) <= 'Z') {
				df = false;
			}
			for (int j = 1; j < ans.length(); j++) {
				if (ans.charAt(j) >= 'A' && ans.charAt(j) <= 'Z') {
					df = true;
					break;
				}
			}

		}
		if (df == false) {
			System.out.println("correct");
		} else {
			System.out.println("not correct");
		}
	}

	static int climb(int n, int arr[]) {
		if (n <= 2) {
			return 1;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		System.out.println("step" + n);
		int a = climb(n - 1, arr);
		int b = climb(n - 2, arr);
		int c = climb(n - 3, arr);
		arr[n] = a + b + c;
		return a + b + c;
	}

	static void findwords(String word, String pattern, Set<String> set) {

		if (word.length() == 0) {
			System.out.println(pattern);
			return;
		}

		for (int i = 0; i < word.length(); i++) {
			String a = word.substring(0, i + 1);
			if (set.contains(a)) {
				findwords(word.substring(i + 1), pattern + a + " ", set);
			}

		}
	}

	static int max = 0;

	static void maximumprofit(int arr[], int i, boolean flag, int sum) {
		if (arr.length <= i) {
			max = Math.max(max, sum);
			return;
		}
		if (flag == true) {
			maximumprofit(arr, i + 2, false, sum + arr[i]);
			maximumprofit(arr, i + 1, true, sum);
		} else {
			maximumprofit(arr, i + 1, true, sum - arr[i]);
			maximumprofit(arr, i + 1, false, sum);
		}
	}

	static Tree inorderpost(int pre[], int inorder[], int start, int end) {
		if (start > end) {
			return null;
		}
		Tree root = createnode(pre[max++]);
		if (start == end) {
			return root;
		}
		int index = getindex(root.data, inorder, start, end);
		root.left = inorderpost(pre, inorder, start, index);
		root.right = inorderpost(pre, inorder, index + 1, end);
		return root;
	}

	private static int getindex(int data, int[] inorder, int start, int end) {

		int index = 0;
		for (int i = start; i < end; i++) {
			if (inorder[i] == data) {
				return i;
			}
			index++;
		}

		return -1;
	}

	private static Tree createnode(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	static void adddigits() {

		int sum = 2019;
		while (sum != 0) {
			int v = 0;
			while (sum != 0) {
				v = v + sum % 10;
				sum = sum / 10;
			}
			sum = v;
			if (sum > 0 && sum < 10) {
				System.out.println(sum);
				break;
			}
		}

		System.out.println(sum);
	}

	static void binarysorting(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[start] < arr[mid] && arr[mid] > arr[end]) {
				start = mid;
			} else if (arr[start] > arr[mid] && arr[mid] < arr[end]) {
				end = mid;
			}
			if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
				System.out.println(arr[mid]);
				break;
			}
		}

	}

	static class Edge {
		int src;
		int des;

		public Edge(int src, int des) {
			super();
			this.src = src;
			this.des = des;
		}

	}

	static class Node {
		int src;
		String ans;

		public Node(int src, String ans) {
			super();
			this.src = src;
			this.ans = ans;
		}
	}

	static void findallpath(ArrayList<ArrayList<Integer>> ar) {

		ArrayList<Edge>[] list = new ArrayList[ar.size()];

		for (int i = 0; i < ar.size(); i++) {
			for (int j = 0; j < list.length; j++) {
				list[i].add(new Edge(i, ar.get(i).get(j)));
			}
		}

		Queue<Node> q = new LinkedList<Codebix.Node>();
		boolean b[] = new boolean[ar.size()];
		q.add(new Node(list[0].get(0).src, ""));
		while (!q.isEmpty()) {
			Node n = q.poll();
			b[n.src] = true;
			for (Edge it : list[n.src]) {
				if (b[it.des] == false) {
					q.add(new Node(it.des, n.ans + it.src + " "));
				}

			}

		}
		dfsutility(list, 0, b);

	}

	private static void dfsutility(ArrayList<Edge>[] list, int i, boolean[] b) {
		b[i] = true;

		for (Edge it : list[i]) {
			if (b[it.des] == false) {
				dfsutility(list, it.des, b);
			}
		}
	}

	static void singlenumber(int brr[]) {
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 1, 2);
		int val = arr.stream().reduce(0, (a, b) -> a ^ b);
		System.out.println(val);
		int a = val & (-val);
		System.out.println(a);

		Map<Boolean, List<Integer>> map = arr.stream().collect(Collectors.partitioningBy(b -> (b & a) == 0));
		Optional<Integer> v = map.get(false).stream().reduce((n, m) -> n ^ m);
		Optional<Integer> w = map.get(true).stream().reduce((n, m) -> n ^ m);
		System.out.println(v + " " + w);

	}

	static LeetCode.CloneLinked.LinkedList delete(LeetCode.CloneLinked.LinkedList list) {
		if (list == null) {
			return null;
		}
		if (list.data == 2) {
			list.next = list.next.next;
		}
		list.next = delete(list.next);
		return list;

	}

	private static void binaryvalue(String a, String b, int sum, int carry, String val) {
		if (a == null && b == null) {
			if (carry == 0) {
				System.out.println(val);
			} else {
				System.out.println(val + 1);
			}
			return;
		}

		if (a.length() == 0 || b.length() == 0) {
			if (carry == 0) {
				System.out.println(val);
			} else {
				System.out.println(val + 1);
			}
			return;
		}
		sum = (a != null ? Integer.parseInt(String.valueOf(a.charAt(0))) : 0)
				+ (b != null ? Integer.parseInt(String.valueOf(b.charAt(0))) : 0) + carry;
		if (sum == 2) {
			val = val + 0 + " ";
			carry = 1;
		} else if (sum == 3) {
			val = val + 1 + " ";
			carry = 1;
		} else {
			val = val + sum + " ";
		}

		binaryvalue(a.length() > 0 ? a.substring(1) : "0", b.length() > 0 ? b.substring(1) : "0", sum, carry, val);

	}

	static void topkfrquent() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 5, 6, 2, 3, 4, 6, 4, 1, 1, 1, 1, 1, 1, 1, 3, 4,
				2, 2, 7, 1, 9, 8, 7, 6, 8);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>((a, b) -> {

			if (map.get(a) != map.get(b)) {
				return map.get(b) - map.get(a);
			} else {
				return b - a;
			}

		});
		for (Integer it : map.keySet()) {
			pr.add(it);
		}

		Map<Integer, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		collect.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByKey()).limit(4)
				.forEach(System.out::println);

		// System.out.println(pr.poll() + " " + pr.poll() + " " + pr.poll());

	}

	static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int v = power(x, n - 1) * x;
		return v;
	}

	static int powervalue(int x, int n) {
		if (n == 0) {
			return 1;
		}

		if (n % 2 == 0) {
			return powervalue(x, n / 2) * powervalue(x, n / 2);

		} else {
			return powervalue(x, n / 2) * powervalue(x, n / 2) * x;
		}

	}

	static void reverseword(String words) {

		String a = "";
		for (int i = 0; i < words.length(); i++) {
			String dc = "";
			while (words.charAt(i) != ' ' && i + 1 != words.length()) {
				dc = dc + words.charAt(i);
				i++;
			}
			a = " " + dc + a;
		}
		System.out.println(a);
	}

	static void reversebit(int val) {
		System.out.println(Integer.toBinaryString(val));
		boolean flag = false;
		int dp = 0;
		int j = 0;
		for (int i = 31; i >= 0; i--) {
			int v = 1 << i;

			if (flag) {
				if ((v & val) == 0) {
					System.out.print(0 + " ");

				} else {
					int ft = (i << j);
					dp = dp | ft;
					System.out.print(1 + " ");
				}
				j++;
			} else if ((v & val) == 0) {

			} else {
				flag = true;
				int ft = (i << j);
				dp = dp | ft;
				System.out.print(1 + " ");
				j++;
			}

		}
		System.out.println(dp);
	}

	static void distinctsubset(int arr[], int i, String ans) {
		if (i == arr.length) {
			System.out.println(ans);
			return;
		}
		distinctsubset(arr, i + 1, ans + arr[i]);
		distinctsubset(arr, i + 1, ans);
	}

	static void distincsub(int arr[], int i, ArrayList<Integer> ar) {
		if (i == arr.length) {
			System.out.println(ar);
			return;
		}
		ar.add(arr[i]);
		distincsub(arr, i + 1, ar);
		ar.remove(ar.size() - 1);
		distincsub(arr, i + 1, ar);
	}

	static class DoubleLinkedList {
		int data;
		DoubleLinkedList next;
		DoubleLinkedList prev;
		DoubleLinkedList child;

	}

	static void flatten(DoubleLinkedList list) {
		DoubleLinkedList root = list;
		while (root.next != null) {
			root = root.next;
		}

		DoubleLinkedList start = list;
		while (start != null) {
			if (start.child != null) {
				root.next = start.child;
			}
			while (root.next != null) {
				root = root.next;
			}
			start = start.next;
		}
	}

	static class Tree {
		int data;
		int height;
		Tree left;
		Tree right;
	}

	static void maximumwidth(Tree tree) {
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(tree);
		while (!q.isEmpty()) {
			int size = q.size();
			System.out.println(size);
			while (size > 0) {
				Tree t = q.poll();
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
				size--;
			}
		}
	}

	static void sum(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(12 - arr[i])) {
				System.out.println(arr[i] + " " + (12 - arr[i]));
			}
			set.add(arr[i]);
		}

		/*
		 * for (int i = 0; i < arr.length; i++) { int v = arr[i]; int d = i + 1; int e =
		 * arr.length - 1; while (d < e) { if (v + arr[d] + arr[e] > 12) { e--;
		 * 
		 * } else if (v + arr[d] + arr[e] > 12) { d++; } else {
		 * System.out.println(arr[i] + " " + arr[d] + " " + arr[e]); d++; e--;
		 * 
		 * } }
		 * 
		 * }
		 */

	}

	static void islandperimeters(int m[][]) {

		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != 1) {
					DFSUTIL(m, i, j, ar);
				}
			}
		}
		System.out.println(ar);

	}

	static void hammingdistance(int a, int b) {
		int c = a ^ b;
		String d = Integer.toBinaryString(c);
		for (int i = 0; i < d.length(); i++) {
			if (d.charAt(i) == '1') {
				System.out.println(1);
			}
		}

	}

	private static void DFSUTIL(int[][] m, int i, int j, ArrayList<Integer> ar) {
		if (i >= m.length || j >= m.length || i < 0 || j < 0 || m[i][j] == 1) {
			return;
		}
		ar.add(m[i][j]);
		m[i][j] = 1;
		DFSUTIL(m, i + 1, j, ar);
		DFSUTIL(m, i, j + 1, ar);
		DFSUTIL(m, i - 1, j, ar);
		DFSUTIL(m, i, j - 1, ar);
	}

	static int carry = 0;

	static int addvalue(int arr[], int i) {
		if (i == arr.length) {
			return 1;
		}
		int sum = arr[i] + addvalue(arr, i + 1);

		if (sum >= 10) {
			arr[i] = sum % 10;
		} else {
			arr[i] = sum;
		}
		return sum / 10;

	}

	private static void snakeladderutils(int[] m, int i, Queue<Integer> q) {
		q.add(m[i]);
		int d = 0;
		int max = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int v = q.poll();
				if (v == 29) {
					max = Math.min(d, max);

				}

				for (int j = v + 1; j <= v + 6 && j < 30; j++) {
					if (m[j] == -1) {
						q.add(j);
					} else {
						q.add(m[j]);
					}
				}
				size--;
			}
			d++;
		}
		System.out.println(max);

	}

	static class Point {
		int src;
		int parent;

		public Point(int src, int parent) {
			super();
			this.src = src;
			this.parent = parent;
		}

	}

	static void findcycle(ArrayList<Edge>[] ar, int i, boolean b[]) {

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(ar[0].get(0).src, -1));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (Edge it : ar[p.src]) {
				if (b[it.des] == false) {
					q.add(new Point(it.des, p.src));
				} else if (it.des != p.parent) {
					System.out.println(true + " cycle");
					break;
				}
			}
		}

	}

	static void prison(int arr[], int val) {
		int d = arr.length - 2;
		int v = (int) Math.pow(2, d);
		val = val % v;

		for (int i = 0; i < val; i++) {
			int brr[] = new int[arr.length];
			brr[0] = 0;
			brr[arr.length - 1] = 0;
			for (int j = 1; j < arr.length - 1; j++) {
				if (arr[j - 1] == 0 && arr[j + 1] == 0 || arr[j - 1] == 1 && arr[j + 1] == 1) {
					brr[j] = 1;
				} else if (arr[j - 1] == 1 && arr[j + 1] == 0 || arr[j - 1] == 0 && arr[j + 1] == 1) {
					brr[j] = 0;
				}
			}
			Arrays.stream(arr).forEach(ab -> System.out.print(ab + " "));
			arr[i] = brr[0];
			System.out.println();
		}

	}

	static void traversal(Tree tree) {
		int height = getheight(tree);

		for (int i = height; i >= 0; i--) {
			getlevel(tree, i);
			System.out.println();
		}
	}

	private static void getlevel(Tree tree, int i) {
		if (tree == null) {
			return;
		}
		if (i == 0) {
			System.out.print(tree.data + " ");
		}

		getlevel(tree.left, i - 1);
		getlevel(tree.right, i - 1);

	}

	private static int getheight(Tree tree) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int a = getheight(tree.left);
		int b = getheight(tree.right);

		return Math.max(a, b) + 1;
	}

	static void gethieghtlevel(Tree tree) {
		Queue<Tree> q = new LinkedList<Codebix.Tree>();
		q.add(tree);
		Stack<Integer> st = new Stack<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			while (size < 0) {
				Tree t = q.poll();
				st.push(t.data);
			}
		}
	}

	static class Prior {
		int src;
		String path;
		int weight;

		public Prior(int src, String path, int weight) {
			super();
			this.src = src;
			this.path = path;
			this.weight = weight;
		}

	}

	static class Pode {
		int src;
		int des;
		int weight;

		public Pode(int src, int des, int weight) {
			super();
			this.src = src;
			this.des = des;
			this.weight = weight;
		}

	}

	static void minimumspaniingtree(ArrayList<Pode>[] pode) {
		PriorityQueue<Prior> p = new PriorityQueue<Prior>((a, b) -> {

			return b.weight - a.weight;
		});
		p.add(new Prior(pode[0].get(0).src, "", pode[0].get(0).weight));
		boolean b[] = new boolean[pode.length];
		while (!p.isEmpty()) {
			int size = p.size();
			while (size > 0) {
				Prior temp = p.poll();
				b[temp.src] = true;
				for (Pode pi : pode[temp.src]) {
					if (b[pi.des] == false) {
						p.add(new Prior(pi.des, temp.path + pi.src + " ", pi.weight));
					}

				}
			}

		}

	}

	static void findwordsearch(char c[][], ArrayList<String> word) {

		ArrayList<ArrayList<String>> store = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < word.size(); i++) {
			for (int j = 0; j < word.size(); j++) {
				for (int k = 0; k < word.size(); k++) {
					if (word.get(i).charAt(0) == c[j][k]) {
						ArrayList<String> cr = new ArrayList<String>();
						wordserch(store, cr, c, j, k, word.get(i), 0);
					}
				}
			}

		}

	}

	private static void wordserch(ArrayList<ArrayList<String>> store, ArrayList<String> cr, char[][] c, int j, int k,
			String string, int count) {
		if (j > c.length || k > c.length || j < 0 || k < 0 || c[j][k] != string.charAt(k)) {
			return;
		}
		if (string.length() == count) {
			cr.add(string);
			return;
		}
		char t = c[j][k];
		c[j][k] = '*';
		wordserch(store, cr, c, j + 1, k, string, count + 1);
		wordserch(store, cr, c, j, k + 1, string, count + 1);
		c[j][k] = t;

	}

	static class Trie {
		boolean flag;
		Trie label[] = new Trie[26];

	}

	static void findvalue(char c[][], ArrayList<String> ar) {
		Trie root = new Trie();
		for (int i = 0; i < ar.size(); i++) {
			push(root, ar.get(i));
		}
		ArrayList<String> st = new ArrayList<>();
		for (int j = 0; j < c.length; j++) {
			for (int k = 0; k < c.length; k++) {
				if (root.label[c[j][k]] != null) {
					wordfindval(root, st, c, j, k, "");
				}
			}
		}
	}

	private static void wordfindval(Trie root, ArrayList<String> st, char[][] c, int j, int k, String word) {
		if (j < 0 || k < 0 || c.length > j || c.length > k || root.label[c[j][k] - 'A'] == null) {
			return;
		}
		if (root.flag == true) {
			st.add(word);
			word = "";
		}
		root = root.label[c[j][k] - 'A'];
		word = word + c[k][j];
		wordfindval(root, st, c, j + 1, k, word);
		wordfindval(root, st, c, j, k + 1, word);

	}

	private static void push(Trie root, String string) {

		Trie temp = root;

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int n = c - 'A' - 1;
			if (temp.label[n] == null) {
				temp.label[n] = new Trie();
			}
			temp = temp.label[n];
		}
		temp.flag = true;

	}

	static void numberoffriends(int m[][]) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean b[] = new boolean[m.length];
		int d = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 1) {
					getmap(m, i, j);
					d++;
				}

			}
		}
		System.out.println(d);
	}

	private static void getvalue(int[][] m, int i, Queue<Integer> q, boolean[] b) {
		b[i] = true;

		for (int j = 0; j < m.length; j++) {
			if (m[i][j] != 0 && b[j] == false) {
				getvalue(m, j, q, b);
			}
		}
	}

	static void getmap(int m[][], int x, int y) {
		if (x >= m.length || y >= m.length || x < 0 || y < 0 || m[x][y] != 1) {
			return;
		}
		m[x][y] = 2;
		getmap(m, x + 1, y);
		getmap(m, x, y + 1);
		getmap(m, x - 1, y);
		getmap(m, x, y - 1);
		getmap(m, x + 1, y + 1);
		getmap(m, x + 1, y - 1);
		getmap(m, x - 1, y + 1);
		getmap(m, x - 1, y - 1);
	}

	static void topologicalsort(ArrayList<Edge>[] ar) {
		Stack<Integer> st = new Stack<Integer>();
		boolean b[] = new boolean[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (b[i] == false) {
				topoutil(ar, i, b, st);
			}
		}
	}

	private static void topoutil(ArrayList<Edge>[] ar, int i, boolean[] b, Stack<Integer> st) {
		b[i] = true;
		for (Edge it : ar[i]) {
			if (b[it.des] == false) {
				topoutil(ar, it.des, b, st);
			}
		}
		st.push(i);

	}

	static class Tode {
		int src;
		int level;

		public Tode(int src, int level) {
			super();
			this.src = src;
			this.level = level;
		}

	}

	static void isgraphbipartite(ArrayList<Edge>[] ar) {

		int flag[] = new int[ar.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(ar[0].get(0).src);
		while (!q.isEmpty()) {
			int v = q.poll();
			flag[v] = 1;
			for (Edge it : ar[v]) {
				if (flag[it.des] == 0) {
					flag[it.des] = -flag[it.src];
					q.add(it.des);
				} else if (flag[it.des] == flag[it.src]) {
					System.out.println(true);
					break;
				}
			}
		}

	}

	static void bipartite(ArrayList<Edge>[] ar) {
		int flag[] = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (flag[i] != 0) {
				continue;
			}
			Queue<Tode> q = new LinkedList<Codebix.Tode>();
			q.add(new Tode(ar[0].get(0).src, 0));
			while (!q.isEmpty()) {
				int size = q.size();
				while (size > 0) {
					Tode t = q.poll();
					flag[t.src] = t.level;
					for (Edge it : ar[t.src]) {
						if (flag[it.des] == 0) {
							q.add(new Tode(it.des, t.level + 1));
						} else if (flag[it.des] == flag[it.src]) {
							System.out.println(true);
							return;
						}
					}
					size--;
				}
			}
		}
	}

	static class Bode {

		String src;
		String des;

		public Bode(String src, String des) {
			super();

			this.src = src;
			this.des = des;
		}
	}

	static class Rode {
		int id;
		String src;
		String path;

		public Rode(int id, String src, String path) {
			super();
			this.id = id;
			this.src = src;
			this.path = path;
		}
	}

	static void iternatry(ArrayList<Bode>[] ar) {
		String b[] = new String[ar.length];
		Queue<Rode> q = new LinkedList<Codebix.Rode>();
		q.add(new Rode(0, "JFK", ""));
		while (!q.isEmpty()) {
			Rode r = q.poll();
			if (r.src.equals("SJC")) {
				System.out.println(r.path);
				return;
			}

			for (int j = 0; j < ar.length; j++) {
				if (ar[j].get(0).src.equals(r.src)) {
					q.add(new Rode(r.id + 1, ar[j].get(0).des, r.path + ar[j].get(0).src + " "));
				}
			}

		}
	}

	static void printMajority(int a[], int size) {
		/* Find the candidate for Majority */
		int cand = findCandidate(a, size);

		/* Print the candidate if it is Majority */
		if (isMajority(a, size, cand))
			System.out.println(" " + cand + " ");
		else
			System.out.println("No Majority Element");
	}

	/* Function to find the candidate for Majority */
	static int findCandidate(int a[], int size) {
		int maj_index = 0, count = 1;
		int i;
		for (i = 1; i < size; i++) {
			if (a[maj_index] == a[i])
				count++;
			else
				count--;
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	/*
	 * Function to check if the candidate occurs more than n/2 times
	 */
	static boolean isMajority(int a[], int size, int cand) {
		int i, count = 0;
		for (i = 0; i < size; i++) {
			if (a[i] == cand)
				count++;
		}
		if (count > size / 2)
			return true;
		else
			return false;
	}

	static void majority(int arr[]) {
		int c = findmaj(arr, 1, 1);
		int d = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == c) {
				d = d + 1;
			}
		}
		if (arr.length / 3 < d) {
			System.out.println(c);
		}

		int f = finbj(arr, 1, 1, c);
		System.out.println(f);

	}

	private static int finbj(int[] arr, int i, int j, int c) {

		for (int k = 1; k < arr.length; k++) {
			if (arr[k] == arr[i] && arr[k] != c) {
				j++;
			} else {
				j--;
			}
			if (j == 0 && arr[k] != c) {
				i = arr[k];
				j = 1;
			}
		}

		return i;
	}

	private static int findmaj(int[] arr, int i, int j) {

		for (int k = 1; k < arr.length; k++) {
			if (arr[k] == arr[i]) {
				j++;
			} else {
				j--;
			}
			if (j == 0) {
				i = arr[k];
				j = 1;
			}
		}

		return i;
	}

	static void printpermuation(int arr[], int count) {
		if (count > 2) {

			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = count;
				printpermuation(arr, count + 1);
				arr[i] = 0;
			}
		}
		System.out.println();
	}

	static void printcombi(int arr[], int count, int i) {
		if (count > 2) {

			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
			return;
		}
		for (int k = i; k < arr.length; k++) {
			if (arr[k] == 0) {
				arr[k] = count;
				printcombi(arr, count + 1, k);
				arr[k] = 0;
			}
		}
	}

	static void square(int n, int i, String ans) {

	}

	static void partiton(String w, int i, ArrayList<ArrayList<String>> brr) {
		if (w.length() == i) {
			System.out.println(brr);
			return;
		}

		for (int j = 0; j < brr.size(); j++) {
			brr.get(j).add(w.charAt(i) + " ");
			partiton(w, i + 1, brr);
			brr.get(j).remove(brr.get(j).size() - 1);
		}

	}

	static void permu(int i, int[] arr) {
		if (i > 2) {
			Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
			System.out.println();
			return;
		}
		for (int j = 0; j < 3; j++) {
			if (arr[j] == 0) {
				arr[j] = i;
				permu(i + 1, arr);
				arr[j] = 0;
			}
		}
	}

	static void squarevalue(int n, int val, String ans) {
		if (val > 12) {
			return;
		}

		for (int j = 1; j <= n; j++) {
			val = val + j * j;
			if (val == 12) {
				System.out.println(ans + j * j);
			}
			if (val > 12) {
				System.out.println(ans + j * j);
			}
			squarevalue(n, val, ans + j * j + " ");
		}
	}

	static void coinsv(int arr[], int i, int val, String ans) {
		if (val > 12) {
			return;
		} else if (val == 12) {
			System.out.println(ans);
			return;
		}
		for (int j = 0; j < arr.length; j++) {
			val = val + arr[j];
			coinsv(arr, j, val, ans + arr[j] + " ");
			val = val - arr[j];

		}
	}

	static void squareval(int n, int i, int val, String ans) {
		if (val == 12) {
			System.out.println(ans);
			return;
		}
		if (val > 12 || n == 0) {
			return;
		}
		for (int j = 1; j < n; j++) {
			val = val + j * j;
			squareval(n - j, j, val, ans + j * j + " ");
			val = val - j * j;
		}
	}

	static void clonegraph(ArrayList<Edge> ar[]) {
		HashMap<Integer, ArrayList<Edge>> map = new HashMap<Integer, ArrayList<Edge>>();
		boolean b[] = new boolean[ar.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int n = q.poll();
			b[n] = true;
			for (Edge it : ar[n]) {
				if (b[it.des] == false) {
					if (map.containsKey(it.src)) {
						ArrayList<Edge> temp = map.get(n);
						temp.add(new Edge(it.src, it.des));
						map.put(n, temp);
					} else if (!map.containsKey(it.src)) {
						ArrayList<Edge> temp = new ArrayList<Codebix.Edge>();
						temp.add(new Edge(it.src, it.des));
						map.put(n, temp);
					}
					q.add(it.des);
				}
			}
		}
		System.out.println(map.get(0).get(0).src + "" + map.get(0).get(0).des + "" + map.get(0).get(1).src);
	}

	static class LinkedList1 {
		int value;
		LinkedList1 next;
		LinkedList1 random;
	}

	static void clonelinked(LinkedList1 list) {

		HashMap<LinkedList1, LinkedList1> map = new HashMap<LinkedList1, Codebix.LinkedList1>();
		LinkedList1 prev = null;
		while (list != null) {
			LinkedList1 tr = cratenode(list.value);
			if (prev != null) {
				prev.next = tr;
			}
			prev = prev.next;
			map.put(list, prev);
			list = list.next;
		}

		LinkedList1 prev1 = null;
		while (list != null) {
			if (list.random != null) {
				prev1.random = map.get(list.random);
			}
			prev1 = prev1.next;
			list = list.next;
		}

	}

	static LinkedList1 cratenode(int l) {
		return null;
	}

	static class Yode {
		int value;
		ArrayList<Yode> neihbour;

		public Yode(int value) {
			super();

			neihbour = new ArrayList<Codebix.Yode>();
		}

	}

	static void cloningvalue(Yode yode) {
		Map<Yode, Yode> map = new HashMap<Codebix.Yode, Codebix.Yode>();
		Queue<Yode> q = new LinkedList<Codebix.Yode>();
		q.add(yode);
		while (!q.isEmpty()) {
			Yode y = q.poll();
			for (Yode it : y.neihbour) {
				if (!map.containsKey(y)) {
					Yode yt = new Yode(it.value);
					map.put(it, yt);
				}
				map.get(it).neihbour.add(map.get(it));

			}
		}
	}

	static void sumoftree(Tree tree, ArrayList<Integer> ar, int sum) {
		if (tree == null) {
			return;
		}
		sum = sum * 10 + tree.data;
		if (tree.left == null && tree.right == null) {
			ar.add(sum);
			return;
		}
		sumoftree(tree.left, ar, sum);
		sumoftree(tree.right, ar, sum);
		sum = sum / 10 - tree.data;

	}

	static void findeepset(Tree tree, int height) {
		if (tree == null) {
			return;
		}
		height = height + 1;
		if (tree.left == null && tree.right == null) {
			max = Math.max(max, height);
			return;
		}
		findeepset(tree.left, height);
		findeepset(tree.right, height);

	}

	static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static void knightonchess(int board[][], int x, int y, int count, int dex, int dey) {
		if (x == dex && y == dey) {
			System.out.println(count);
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board.length) {
			return;
		}
		if (board[x][y] == -1) {
			return;
		}
		board[x][y] = -1;

		for (int i = 0; i < 8; i++) {
			knightonchess(board, x + xMove[i], y + yMove[i], count + 1, dex, dey);
		}
		board[x][y] = 0;

	}

	static void getseumthird(int arr[]) {

		int v = 0;
		for (int j = 0; j < arr.length; j++) {
			v = v ^ arr[j];
		}
		int d = v & -v;
		int e = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] + d == 0) {
				e++;
			}
		}

	}

	static void dunzen(int m[][], int x, int y, int health) {
		if (x == m.length - 1 && y == m.length - 1) {
			System.out.println(health);
			return;
		}
		if (x >= m.length || y >= m.length || x < 0 || y < 0) {
			return;
		}
		if (m[x][y] == Integer.MAX_VALUE) {
			return;
		}

		int c = m[x][y];
		m[x][y] = Integer.MAX_VALUE;
		dunzen(m, x + 1, y, health + c);
		dunzen(m, x, y + 1, health + c);
		dunzen(m, x, y - 1, health + c);
		dunzen(m, x - 1, y, health + c);
		m[x][y] = c;
	}

	static void hindex(int arr[]) {
		int i = 0;
		int max = 0;
		while (i < arr.length - 1) {
			int v = arr[i];
			if (v >= arr[(arr.length - 1) - i]) {
				max = v;
			}
			i++;
		}
		System.out.println(max);
	}

	static boolean searchvalue(Tree tree) {
		if (tree == null) {
			return false;
		}
		if (tree.data == 2) {
			return true;
		}
		boolean a = searchvalue(tree.left);
		boolean b = searchvalue(tree.right);
		return a || b;

	}

	static class Flight {
		int src;
		int des;
		int distance;

		public Flight(int src, int des, int distance) {
			super();
			this.src = src;
			this.des = des;
			this.distance = distance;
		}

	}

	static class Reach {
		int src;
		int distance;
		String path;

		public Reach(int src, int distance, String path) {
			super();
			this.src = src;
			this.distance = distance;
			this.path = path;
		}

	}

	static void cheapestflight(ArrayList<Flight> ar[]) {
		boolean b[] = new boolean[ar.length];
		PriorityQueue<Reach> q = new PriorityQueue<Codebix.Reach>((a, c) -> {
			return a.distance - c.distance;
		});
		q.add(new Reach(0, 0, ar[0].get(0).src + " "));
		while (!q.isEmpty()) {
			Reach r = q.poll();
			b[r.src] = true;
			if (r.src == 3) {
				System.out.println(r.path + " " + r.distance);
				return;
			}
			for (Flight it : ar[r.src]) {

				if (b[it.des] == false) {
					q.add(new Reach(it.des, r.distance + it.distance, r.path + it.src + " "));
				}
			}
		}

	}

	static void orange(int m[][]) {

	}

	static void rotten(int m[][], int x, int y) {

		if (x > m.length || y > m.length || x < 0 || y < 0) {
			return;
		}
		if (m[x][y] == 2) {
			return;
		}
		m[x][y] = 1;
		rotten(m, x - 1, y);
		rotten(m, x, y - 1);

	}

	static void display(int arr[], int i, int j, ArrayList<Integer> ar) {
		if (j > arr.length) {
			System.out.println(ar);
			return;
		}

		for (int k = i; k < arr.length; k++) {
			if (arr[k] % j == 0) {
				ar.add(arr[k]);
				display(arr, i + 1, arr[k], ar);
				ar.remove(ar.size() - 1);

			}

		}
	}

	private static ArrayList<Integer> getvalue(int[] is, int i, ArrayList<Integer> arrayList) {
		if (i == is.length) {

			return arrayList;
		}

		ArrayList<Integer> pt = getvalue(is, i + 1, arrayList);
		if (is[i] == 3) {
			pt.add(i);
		}
		return pt;

	}

	static void subsequnce(int arr[], int i, ArrayList<Integer> ar) {
		if (arr.length == i) {
			System.out.println(ar);
			return;
		}
		ar.add(arr[i]);
		subsequnce(arr, i + 1, ar);

		ar.remove(ar.size() - 1);
		subsequnce(arr, i + 1, ar);

	}

	static void substring(String s, String val) {
		if (s.length() == 0) {
			System.out.println(val);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String dc = s.substring(0, i);
			String fc = s.substring(i + 1);
			substring(dc + fc, val + c + " ");
		}
	}

	static void abbervition(String a, String dc, int count) {
		if (a.length() == 0) {
			System.out.println(dc + count);
			return;
		}
		if (count > 0) {
			abbervition(a.substring(1), dc + count + a.charAt(0), 0);
			abbervition(a.substring(1), dc, count + 1);
		} else {
			abbervition(a.substring(1), dc + a.charAt(0), 0);
			abbervition(a.substring(1), dc, count + 1);
		}
	}

	static void gold(int m[][], int x, int y, ArrayList<Integer> ar) {
		if (x > m.length || y > m.length || x < 0 || y < 0 || m[x][y] <= 0) {
			return;
		}
		ar.add(m[x][y]);
		m[x][y] = -1;
		gold(m, x + 1, y, ar);
		gold(m, x, y + 1, ar);
		gold(m, x - 1, y, ar);
		gold(m, x, y - 1, ar);
	}

	static void goldie(int m[][]) {
		int max = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				gold(m, i, j, ar);
				int val = ar.stream().reduce(0, (a, b) -> a + b);
				max = Math.max(val, max);

			}
		}
	}

	static void matching(char c[][], String words[], int i) {
		if (words.length == i) {
			System.out.println();
			return;
		}

		String word = words[i];
		for (int j = 0; j < c.length; j++) {
			for (int k = 0; k < c.length; k++) {
				if (c[j][k] == word.charAt(0) || c[j][k] == '-') {
					if (isvalidforhorizontal(c, j, k, word)) {
						ArrayList<Cordinate> ar = new ArrayList<Advent3.Cordinate>();
						getplaced(c, j, k, word, ar);
						matching(c, words, i + 1);
						ungerplace(c, j, k, word, ar);
					}
				}

			}
		}

	}

	private static void ungerplace(char[][] c, int j, int k, String word, ArrayList<Cordinate> ar) {

		for (int i = k; i < k + word.length(); k++) {
			for (Cordinate it : ar) {
				if (it.x != j && it.y != i) {
					c[j][k] = '+';
				}
			}
		}

	}

	private static void getplaced(char[][] c, int j, int k, String word, ArrayList<Cordinate> ar) {
		int p = 0;
		for (int i = k; i < k + word.length(); i++) {
			if (c[i][j] == '-') {
				c[j][i] = word.charAt(p++);
			} else if (c[i][k] == word.charAt(p++)) {
				ar.add(new Cordinate(i, k, 0));
				continue;
			}
		}

	}

	private static boolean isvalidforhorizontal(char[][] c, int j, int k, String word) {
		int length = word.length();
		if (k - 1 != 0 && c[j][k - 1] != '+') {
			return false;
		}
		int p = 0;
		if (k + length + 1 != c.length && c[j][length + k] != '+') {
			return false;
		}
		for (int i = k; i < k + length; i++) {
			if (c[i][k] != '-' && c[i][k] != word.charAt(p++)) {
				return false;
			}
		}
		return true;
	}

	static void ksubset(String s, int i, ArrayList<ArrayList<Character>> ch) {
		if (s.length() == 0) {
			System.out.println(ch);
			return;
		}
		for (int j = 0; j < ch.size(); j++) {
			ch.get(j).add(s.charAt(0));
			ksubset(s.substring(1), j, ch);
			ch.get(j).remove(ch.get(j).size() - 1);
		}
	}

	static void twosubset(String ch, int i, String ans, String bns) {
		if (i == ch.length()) {
			System.out.println(ans + "                                " + bns);
			return;
		}
		twosubset(ch, i + 1, ans + ch.charAt(i), bns);
		twosubset(ch, i + 1, ans, bns + ch.charAt(i));
	}

	static void palindromic(String ans, int i, String val) {

		for (int j = 0; j < ans.length(); j++) {
			String dc = ans.substring(0, j + 1);
			if (true) {
				palindromic(ans.substring(j + 1), i, val + " " + dc);
			}
		}

	}

	static void permutation(int box[], int i, int d) {
		if (d >= 3) {
			Arrays.stream(box).forEach(a -> System.out.print(a + " "));
			System.out.println();
			return;
		}
		for (int j = 0; j < box.length; j++) {
			if (box[j] == 0) {
				box[j] = d;
				permutation(box, i, d + 1);
				box[j] = 0;
			}
		}
	}

	static void permutationside(int b[], int i, int j) {
		if (j > 2) {
			Arrays.stream(b).forEach(a -> System.out.print(a + " "));
			System.out.println();
			return;
		}
		for (int k = i; k < b.length; k++) {
			if ((b[k] == 0)) {
				b[k] = j;
				permutationside(b, k, j + 1);
				b[k] = 0;
			}
		}
	}

	static void arrangement(int arr[], int j, int k, int brr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (brr[i] == 0) {
				brr[i] = arr[i];
				arrangement(arr, j + 1, k, brr);
				brr[i] = 0;
			}
		}
		arrangement(arr, 0, k + 1, brr);
	}

	static void largestdiv(int arr[], int i, Set<Integer> ar) {
		if (i == arr.length) {
			System.out.println(ar);
			return;
		}
		for (int j = i; j < arr.length; j++) {
			if (arr[j - 1] % arr[j] == 0 || arr[j] % arr[j - 1] == 0) {
				ar.add(arr[j]);
				ar.add(arr[j - 1]);
				largestdiv(arr, i + 1, ar);
				ar.remove(arr[j]);
				ar.remove(arr[j - 1]);
			} else {
				largestdiv(arr, i + 1, ar);
			}
		}
	}

	static ArrayList<Integer> list = new ArrayList<>();
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int size = 0;

	static void insert(int value) {
		list.add(value);
		map.put(value, size);
		size++;
		System.out.println(list);

	}

	static void delete(int val) {
		int index = map.get(val);
		int temp = list.get(list.size() - 1);
		list.remove(index);
		list.add(index, temp);
		list.remove(list.size() - 1);
		map.put(temp, index);
		size--;
		map.remove(val);
		System.out.println(list);
	}

	static void random() {
		Random r = new Random();
		int v = r.nextInt(list.size());
		System.out.println(list.get(v));
	}

	static void sort(int arr[]) {
		int mid = 0;
		int start = 0;
		int end = arr.length - 1;
		while (mid < end) {
			if (arr[mid] == 0) {
				if (mid != start) {
					int temp = arr[start];
					arr[start] = arr[mid];
					arr[mid] = temp;
				}
				mid++;
				start++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				if (mid != end) {
					int temp = arr[end];
					arr[end] = arr[mid];
					arr[mid] = temp;
				}

				end--;
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static class Store {
		int id;
		String src;
		String path;

		public Store(int id, String src, String path) {
			super();
			this.id = id;
			this.src = src;
			this.path = path;
		}
	}

	static void wordladder(ArrayList<String> ar) {
		Queue<Store> q = new LinkedList<Store>();
		q.add(new Store(0, "HOT", ""));
		while (!q.isEmpty()) {
			Store poll = q.poll();
			if (poll.src.equals("CPG")) {
				System.out.println(poll.path + "CPG");
				return;
			}
			for (int j = 0; j < ar.size(); j++) {
				if (j != poll.id && isonlyword(ar.get(j), poll.src)) {
					q.add(new Store(j, ar.get(j), poll.path + poll.src + " "));
				}
			}
		}
	}

	private static boolean isonlyword(String string, String src) {
		return true;
	}

	private static void findpos(int[] arr, int i) {
		int a = 0;
		int b = arr.length - 1;
		while (a < b) {
			int mid = a + (b - a) / 2;
			if (arr[mid] < i) {
				a = mid;
			} else if (arr[mid] > i) {
				b = mid;
			} else if (arr[mid] == i) {
				System.out.println(mid);
				break;
			}
			if (Math.abs(b - a) == 1 && (arr[mid] < arr[mid + 1] || arr[mid] > arr[mid - 1])) {
				System.out.println(b);
				break;
			}

		}

	}

	private static void getdfs(ArrayList<ArrayList<Integer>> ar) {

		boolean b[] = new boolean[ar.size()];
		for (int i = 0; i < ar.size(); i++) {
			if (b[i] == false) {
				dfsutility(b, ar, i);
			}

		}

	}

	private static void dfsutility(boolean[] b, ArrayList<ArrayList<Integer>> ar, int i) {

		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> br = ar.get(i);
		for (int j = 0; j < br.size(); j++) {
			q.add(br.get(j));
		}
		while (!q.isEmpty()) {
			int v = q.poll();
			b[v] = true;
			ArrayList<Integer> cr = ar.get(v);
			for (int k = 0; k < cr.size(); k++) {
				if (b[cr.get(k)] == false) {
					q.add(cr.get(k));
				}
			}
		}
	}

	static void getdfsval(ArrayList<Edge>[] ar) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(ar[0].get(0).src);
		while (!q.isEmpty()) {
			int b = q.poll();
			for (Edge it : ar[b]) {
				q.add(it.des);
			}
		}
	}

	static void isubqunce(String a, String b) {
		if (a.length() == 0) {
			if (b.equals("ABC")) {
				System.out.println("found");
			}
			return;
		}
		isubqunce(a.substring(1), b + a.charAt(0));
		isubqunce(a.substring(1), b);
	}

	static int fibonacci(int n, int arr[], int i) {
		if (n < 2) {
			return n;
		}
		if (arr[n] == 0) {
			arr[n] = fibonacci(n - 1, arr, i) + fibonacci(n - 2, arr, i);
		}

		return arr[n];
	}

	static void fibonacciebothway(int arr[], int i) {
		arr[0] = 0;
		arr[1] = 1;
		for (int j = 2; j <= i; j++) {
			arr[j] = arr[j - 1] + arr[j - 2];

		}
		System.out.println(arr[i]);
	}

	static int stairs(int n, int arr[]) {
		if (n < 3) {
			return n;
		}
		if (arr[n] == 0)
			arr[n] = stairs(n - 1, arr) + stairs(n - 2, arr) + stairs(n - 3, arr);
		return arr[n];
	}

	static int stairsmin(int n, int arr[]) {
		if (n < 3) {
			return 1;
		}
		if (arr[n] == 0)
			arr[n] = Math.min(stairsmin(n - 1, arr), Math.min(stairsmin(n - 2, arr), stairsmin(n - 3, arr))) + 1;
		return arr[n];
	}

	static void longestsubsequnce(int arr[], int n) {
		int brr[] = new int[arr.length + 1];
		Arrays.fill(brr, 1);

		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && brr[i] < brr[j] + 1) {
					brr[i] = brr[j] + 1;
					max = Math.max(brr[i], max);
				}
			}
		}
		System.out.println(max);
	}

	static void maximumsum(int arr[], int n) {
		int max = 0;
		int brr[] = new int[arr.length];
		for (int j = 0; j < arr.length; j++) {
			brr[j] = arr[j];
		}
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {
				if (arr[j] > arr[i] && brr[i] + arr[j] > brr[j]) {
					brr[j] = brr[i] + arr[i];
					max = Math.max(max, brr[j]);
				}
			}
		}
		System.out.println(max);

	}

	static void longestsubsequnce(int m[][], String a, String b) {
		int max = 0;
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == a.charAt(j - 1)) {
					m[i][j] = m[i - 1][j - 1] + 1;
					max = Math.max(max, m[i][j]);

				} else {
					m[i][j] = m[i - 1][j - 1];
				}
			}
		}

		System.out.println(max);

	}

	static int longest(String a, String b, int i) {
		if (a.length() == 0 || b.length() == 0) {
			return 0;
		}
		if (a.charAt(0) == b.charAt(0)) {
			return longest(a.substring(1), b.substring(1), 0) + 1;
		}
		int c = longest(a.substring(1), b, i);
		int d = longest(a, b.substring(1), i);
		return Math.max(c, d);
	}

	static int count = 0;

	static int longestvalue(String a, String b, int count) {
		if (a.length() == 0 || b.length() == 0) {
			return count;
		}

		if (a.charAt(0) == b.charAt(0)) {
			count = longestvalue(a.substring(1), b.substring(1), count + 1);
		}
		return Math.max(count, Math.max(longestvalue(a.substring(1), b, 0), longestvalue(a, b.substring(1), 0)));
	}

	static void longestmin(String a, String b) {
		int m[][] = new int[a.length()][b.length()];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					m[i][j] = m[i - 1][j - 1] + 1;
				} else {
					m[i][j] = 0;
				}

			}
		}

	}

	static int minimumedit(String a, String b, int count) {
		if (a.length() == 0 && b.length() == 0) {
			return 0;
		}
		if (a.length() == 0) {
			return b.length();
		}
		if (b.length() == 0) {
			return a.length();
		}

		if (a.charAt(0) == b.charAt(0)) {
			return minimumedit(a.substring(1), b.substring(1), 0) + 0;
		}
		return Math.min(minimumedit(a.substring(1), b, count + 1), minimumedit(a, b.substring(1), count + 1)) + 1;
	}

	static int palindrome(String a, int i, int j, int count) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}

		if (a.charAt(i) == a.charAt(j)) {
			count = 2 + palindrome(a, i + 1, j - 1, count);
		}
		return Math.max(count, Math.max(palindrome(a, i + 1, j, count), palindrome(a, i, j - 1, count)));
	}

	static void palindromedp(String a) {
		int max = 0;
		int m[][] = new int[a.length()][a.length()];
		for (int i = a.length() - 2; i >= 0; i--) {
			for (int j = i; j < m.length; j++) {
				if (i == j) {
					m[i][j] = 1;
				} else {
					if (a.charAt(i) == a.charAt(j)) {
						m[i][j] = 2 + m[i + 1][j - 1];
						max = Math.max(max, m[i][j]);
					} else {
						m[i][j] = Math.max(m[i][j - 1], m[i + 1][j]);
					}
				}
			}
		}
		System.out.println(max);
	}

	static void stairsvariable(int arr[], int i, int val, String path) {
		if (i == 10) {
			System.out.println(path + " :                     " + val);
			return;
		} else if (i > 10) {
			return;
		}

		int d = arr[val];
		for (int j = 1; j <= d; j++) {
			if (i + j < 11) {
				int dc = arr[i + j];
				val = val + j;
				stairsvariable(arr, dc, val, path + d + " ");
			}
		}

	}

	static void dpstaircase(int arr[]) {
		int dp[] = new int[arr.length];
		dp[arr.length - 1] = 1;
		for (int j = arr.length - 2; j >= 0; j--) {
			int c = arr[j];
			for (int i = 1; i < c; i++) {
				dp[j] += arr[j + i];
			}

		}
	}

	static void minimumdp(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[arr.length] = 1;
		for (int j = arr.length - 1; j >= 0; j--) {
			int c = arr[j];
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= c && i + j < dp.length; i++) {
				min = Math.min(min, dp[i + j]);
			}
			dp[j] = min + 1;
		}
		System.out.println(dp[1]);
	}

	static void dpminim(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		dp[m.length - 1][m.length - 1] = m[m.length - 1][m.length - 1];
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp.length - 1; j >= 0; j--) {
				if (i == dp.length - 1) {
					dp[i][j] = m[i][j] + dp[i][j + 1];
				} else if (j == dp.length - 1) {
					dp[i][j] = m[i][j] + dp[i + 1][j];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}

			}
		}
	}

	static void maximumgold(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		dp[m.length - 1][m.length - 1] = m[m.length - 1][m.length - 1];
		int max = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (j == m.length - 1) {
					dp[i][j] = m[i][j];
				} else if (i < 1) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + m[i][j];
				} else if (i == m.length - 1) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + m[i][j];
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1])) + m[i][j];
				}
				max = Math.max(dp[i][j], max);
			}

		}
	}

	static void targetsum(int sum, int arr[]) {
		boolean dp[][] = new boolean[arr.length][sum + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (arr[i] == j) {
					dp[i][j] = true;
				} else {
					if (i != 0 && dp[i - 1][j] == true) {
						dp[i][j] = true;
					} else if (dp[i - 1][j - arr[i]]) {
						dp[i][j] = true;
					}
				}

			}
		}
	}

	static void coin(int m[][], int sum) {

	}

	static boolean isplaindrome(String str) {

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters toc compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

	static int longestpalind(String s, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (s.charAt(i) == s.charAt(j)) {
			int len = j - i + 1;
			if (longestpalind(s, i + 1, j - 1) == len) {
				return j - i + 1;
			}
		}
		return 0;
	}

	static void knapsack(int profit[], int weight[], int sum) {
		int dp[][] = new int[weight.length + 1][sum + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				int including = 0;
				int excluding = 0;
				if (j < weight[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					if (j <= weight[i]) {
						including = dp[i - 1][j - weight[i]] + profit[i];
					} else {
						excluding = dp[i - 1][j];
					}
					dp[i][j] = Math.max(including, excluding);
				}
			}
		}
	}

	static void unbounded(int profit[], int weight[], int sum) {
		int dp[][] = new int[weight.length + 1][sum + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (weight[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int include = 0;
					int exclude = 0;
					if (j <= weight[i]) {
						include = dp[i][j - weight[i]] + profit[i];
					}
					exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				}

			}
		}
	}

	static void adjacent(int arr[], int i, String ans, boolean flag) {

		int brr[] = new int[arr.length];
		brr[0] = arr[0];
		if (arr[0] > arr[1]) {
			brr[1] = arr[0];
		} else {
			brr[1] = arr[1];
		}
		int max = 0;
		for (int j = 2; j < arr.length; j++) {
			brr[j] = Math.max(brr[j - 1], brr[j - 2] + arr[j]);
			max = brr[j];

		}
		System.out.println(max);
	}

	static void painthouse(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			int min = 0;
			for (int j = 0; j < m.length; j++) {
				if (i != 0 && j == 0) {
					dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + m[i][j];
				} else if (i != 0 && j == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + m[i][j];
				} else if (i != 0 && j == 2) {
					dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + m[i][j];
				} else {
					dp[i][j] = m[i][j];
				}
			}
		}
		IntStream.range(0, 3).mapToObj(a -> dp[2][a]).forEach(a -> System.out.print(a + " "));
		Optional<Integer> d = IntStream.range(0, 3).mapToObj(a -> dp[2][a]).reduce((a, b) -> Math.min(a, b));
		System.out.println(d);
	}

	static void adjacentsum(int arr[]) {
		int including = arr[0];
		int excluding = 0;
		for (int i = 1; i < arr.length; i++) {
			int newincluding = arr[i] + excluding;
			excluding = Math.max(including, excluding);
			including = newincluding;
		}
		System.out.println(including + " " + excluding);
	}

	static void paint(int m[][]) {
		int green = m[0][0];
		int red = m[0][1];
		int blue = m[0][2];
		for (int i = 1; i < m.length; i++) {

			int ngreen = Math.max(red, blue) + green;
			int nred = Math.max(green, blue) + red;
			int nblue = Math.max(green, red) + blue;
			green = ngreen;
			red = nred;
			blue = nblue;
		}
		System.out.println(green + " " + red + " " + blue);

	}

	static void minimumcoins(int arr[]) {
		int dp[][] = new int[4][6];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= 6; i++) {
				if (arr[i] < j) {
					dp[i][j] = dp[i - 1][j];

				} else {
					int include = Integer.MAX_VALUE;
					int exclude = Integer.MAX_VALUE;
					if (arr[i] >= j) {
						exclude = dp[i - 1][j];
					}
					include = Math.min(dp[i][j - arr[i]] + 1, exclude);
					dp[i][j] = include;
				}
			}
		}
	}

	static void maxrod(int arr[], int sum) {
		int dp[][] = new int[arr.length + 1][sum + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				int include = Integer.MAX_VALUE;
				int exclude = Integer.MAX_VALUE;
				if (arr[i] > j) {
					include = dp[i - 1][j];
				} else {
					if (arr[i] >= j) {
						exclude = dp[i][j - arr[i]] + 1;
					}
					include = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				}
			}
		}
	}

	static void numberofpalind(String a) {
		boolean dp[][] = new boolean[a.length()][a.length()];
		int p = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				if (i == j) {
					dp[i][j] = true;
					p++;
				} else if (i == j + 1) {
					if (a.charAt(i) == a.charAt(j)) {
						dp[i][j] = true;
						p++;
					}
				} else if (i > j + 1) {
					if (a.charAt(i) == a.charAt(j) && dp[i - 1][j - 1]) {
						dp[i][j] = true;
						p++;
					}
				}

			}
		}

	}

	static void palindrome(String a) {
		boolean dp[][] = new boolean[a.length()][a.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = i; j < a.length(); j++) {
				if (i == j) {
					dp[i][j] = true;
				} else if (i == j + 1) {
					if (a.charAt(i) == a.charAt(j)) {
						dp[i][j] = true;
					}
				} else if (i > j + 1) {
					if (a.charAt(i) == a.charAt(j) && dp[i][j]) {
						dp[i][j] = true;
						System.out.println(j - i + 1);
					}
				}
			}
		}
	}

	static void minimumpath(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[arr.length] = 1;
		for (int i = dp.length - 1; i >= 0; i--) {
			int temp = arr[i];
			int min = 0;
			for (int j = 0; j < temp; j++) {
				min = Math.min(dp[j], min);
			}
			dp[i] = min + 1;
		}

	}

	static class Get {
		int src;
		String path;

		public Get(int src, String path) {
			super();
			this.src = src;
			this.path = path;
		}

	}

	static void minimimumjumpqueue(int arr[]) {
		Queue<Get> q = new LinkedList<Codebix.Get>();
		q.add(new Get(arr[0], ""));
		while (!q.isEmpty()) {
			Get g = q.poll();
			for (int i = 0; i < g.src; i++) {
				if (g.src + i < arr.length) {
					q.add(new Get(arr[g.src + i], g.path + g.src + " "));
				}
			}
		}
	}

	static void bfs(int m[][]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(m[0][0]);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int i = 0; i < m.length; i++) {
				if (m[v][i] != 0) {
					q.add(m[v][i]);
				}
			}
		}
	}

	static void coinsval(int arr[], int v, String val) {
		if (v > 12) {
			return;
		}
		if (v == 12) {
			System.out.println(val);
			return;
		}

		for (int j = 0; j < arr.length; j++) {

			v = v + arr[j];
			coinsval(arr, v, val + arr[j] + " ");
			v = v - arr[j];

		}
	}

	static void substringpalindrome(String a) {
		int b[][] = new int[a.length()][a.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = i; j < a.length(); j++) {
				if (i == j) {
					b[i][j] = 1;
				} else if (a.charAt(i) == a.charAt(j + 1)) {
					b[i][j] = 2;
				} else {
					if (a.charAt(i) == a.charAt(j) && b[i - 1][j - 1] != 0) {
						b[i][j] = b[i][j] + b[i - 1][j - 1];

					}
				}
			}
		}
	}

	static void patternmatching(String pattern, String word) {
		int dp[][] = new int[pattern.length()][word.length()];
		for (int i = pattern.length() - 1; i >= 0; i--) {
			for (int j = word.length() - 1; j >= 0; j--) {
				if (i == pattern.length() - 1 && j == pattern.length() - 1) {
					dp[i][j] = 1;
				}
				if (pattern.charAt(i) == '?') {
					dp[i][j] = dp[i + 1][j - 1];
				} else if (pattern.charAt(i) == '*') {
					int d = 0;
					for (int k = i; k < pattern.length(); k++) {
						d = Math.max(d, dp[i][k]);
					}
					dp[i][j] = d;
				} else {
					if (pattern.charAt(i) == pattern.charAt(j)) {
						if (dp[i + 1][j - 1] == 1) {
							dp[i][j] = 1;
						}
					}
				}

			}

		}
	}

	static class Cordinate1 {
		int x;
		int y;

		public Cordinate1(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Cordinate1() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Cordinate1 [x=" + x + ", y=" + y + "]";
		}

	}

	static void sorting(ArrayList<Cordinate1> ar) {

		Collections.sort(ar, (a, b) -> {
			int ab = a.y;
			int cb = b.y;
			if (ab == cb) {
				return a.x - b.x;
			} else {
				return b.y - a.y;
			}

		});
		System.out.println(ar);
	}

	static void randompick(int arr[]) {
		int sum = Arrays.stream(arr).sum();
		int d = 0;
		for (int i = 0; i < 1000; i++) {
			Random r = new Random();
			int v = r.nextInt(sum);
			int g = arr[0];
			if (v >= 0 && g > v) {
				d++;
			}

		}
		System.out.println(d);
	}

	static int longestsubstring(String a, String b, int count) {
		if (a.length() == 0 || b.length() == 0) {
			return count;
		}
		if (a.charAt(0) == b.charAt(0)) {
			return longestsubstring(a.substring(1), b.substring(1), count + 1);
		}
		return Math.max(count,
				Math.max(longestsubstring(a.substring(1), b, 0), longestsubstring(a, b.substring(1), 0)));
	}

	static void invertbinarytree(Tree node) {
		if (node == null) {
			return;
		}
		Tree temp = node.left;
		node.left = node.right;
		node.right = temp;
		invertbinarytree(node.left);
		invertbinarytree(node.right);
	}

	static void inverttree(Tree tree) {
		Queue<Tree> q = new LinkedList<Codebix.Tree>();
		q.add(tree);
		while (!q.isEmpty()) {
			Tree t = q.poll();
			Tree temp = t.left;
			t.left = t.right;
			t.right = temp;
			if (t.left != null) {
				q.add(t.left);
			}
		}
	}

	private static void kcloset(ArrayList<Cordinate1> ar) {

		Collections.sort(ar, (a, b) -> {
			int v = a.x * a.x;
			int w = a.y * a.y;
			int z = (int) Math.sqrt(v + w);
			int x = b.x * b.x;
			int y = b.y * b.y;
			int s = (int) Math.sqrt(x + y);
			return z - s;

		});
		ar.stream().limit(2).forEach(System.out::println);

		System.out.println(ar);

	}

	static void numberofbits(int v) {
		int d = 0;
		while (v != 0) {
			int dc = v & -v;
			v = v - dc;
			d++;
		}
		System.out.println(d);
	}

	static class Nt {
		int src;
		String path;

		public Nt(int src, String path) {
			super();
			this.src = src;
			this.path = path;
		}

	}

	static void possiblebapiration(ArrayList<Edge>[] ar) {
		int b[] = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (b[i] != 0) {
				continue;
			}
			Queue<Nt> q = new LinkedList<Codebix.Nt>();
			q.add(new Nt(ar[0].get(0).src, ""));
			while (!q.isEmpty()) {
				Nt n = q.poll();
				for (Edge it : ar[n.src]) {
					if (b[it.des] == 0) {
						b[it.des] = -b[it.src];
						q.add(new Nt(it.des, n.path + it.src + " "));
					} else if (b[it.des] == b[it.src]) {
						return;
					}

				}
			}
		}

	}

	static void bipartitevalue(ArrayList<Edge>[] ar) {
		int b[] = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (b[i] == 0) {
				continue;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(ar[i].get(0).src);
			int level = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				while (size < 0) {
					int ip = q.poll();
					if (b[ip] == 0) {
						b[ip] = level;
					} else {
						if (b[ip] != level) {
							return;
						}
					}

					for (Edge it : ar[ip]) {
						if (b[it.des] == 0) {
							b[it.des] = level;
							q.add(it.des);
						}
					}

				}
				level++;
			}

		}
	}

	static void equalnumberofzer(int arr[], int i, int val, String path) {
		if (arr.length == i) {
			if (val == 0) {
				System.out.println(path);

			}
			return;
		}
		equalnumberofzer(arr, i + 1, val + arr[i], path + arr[i] + " ");
		equalnumberofzer(arr, i + 1, val, path);
	}

	static void equalwothoutrec(int arr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(0, -1);
		int sum = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum = sum + -1;
			} else {
				sum = sum + arr[i];
			}
			if (hashmap.containsKey(sum)) {
				int last = hashmap.get(sum);
				max = Math.max(max, i - last);
			} else {
				hashmap.put(sum, i);
			}
		}
		System.out.println(max);
	}

	static void intersection(int arr[], int brr[]) {
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapb = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			mapa.put(arr[i], i);
		}
		for (int i = 0; i < brr.length; i++) {
			mapb.put(brr[i], i);
		}
		int d = 0;
		for (Integer it : mapa.keySet()) {
			if (mapb.containsKey(it)) {
				int a = mapa.get(it);
				int b = mapb.get(it);
				if (a <= b) {
					System.out.println(it + " " + a + " " + b);
					d++;
				}
			}
		}
		System.out.println(d);
	}

	static int recursionit(int ar[], int br[], int i, int j, HashMap<String, Integer> map) {

		String key = i + "bval" + j;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int count = 0;
		if (ar[i] == br[i]) {
			count = 1 + recursionit(ar, br, i + 1, j + 1, map);
		} else {
			count = count + Math.max(recursionit(ar, br, i + 1, j, map), recursionit(ar, br, i, j + 1, map));
		}

		map.put(key, count);
		return count;
	}

	static Tree preorder(int arr[], int start, int end) {

		Tree tree = createnode(arr[start]);
		int mid = 0;
		for (int i = start; i < end; i++) {
			if (arr[start] > arr[i]) {
				mid = i;
				break;
			}
		}
		tree.left = preorder(arr, start, mid - 1);
		tree.right = preorder(arr, mid, end);
		return tree;
	}

	private static void intersection(Cordinate1[] c, Cordinate1[] d) {
		ArrayList<Cordinate1> ar = new ArrayList<Codebix.Cordinate1>();
		int i = 0;
		int j = 0;
		while (i < c.length && j < d.length) {
			Cordinate1 at = c[i];
			Cordinate1 bt = d[j];
			if (bt.x < at.x && bt.y < at.x) {
				ar.add(new Cordinate1(bt.x, bt.y));
				ar.add(new Cordinate1(at.x, at.y));
			} else if (at.x < bt.x && at.y < bt.x) {
				ar.add(new Cordinate1(at.x, at.y));
				ar.add(new Cordinate1(bt.x, bt.y));
			} else if (at.x <= bt.x && at.y <= bt.x) {
				ar.add(new Cordinate1(at.x, bt.y));
			} else if (at.x >= bt.x && bt.y <= at.x) {
				ar.add(new Cordinate1(bt.x, at.y));
			} else if (at.x <= bt.x && at.y >= bt.x) {
				ar.add(new Cordinate1(at.x, bt.y));
			} else if (bt.x <= at.x && bt.y >= at.x) {
				ar.add(new Cordinate1(bt.x, at.y));
			}
			i++;
			j++;

		}
		ArrayList<Cordinate1> br = new ArrayList<>();

		IntStream.range(0, ar.size()).mapToObj(a -> a == 0 ? br.add(ar.get(a)) : processgh(br, a, ar.get(a)))
				.forEach(a -> System.out.println(a));
		// System.out.println(collect);

	}

	static ArrayList<Cordinate1> processgh(ArrayList<Cordinate1> br, int index, Cordinate1 curr) {
		Cordinate1 dr = br.get(br.size() - 1);
		if (dr.x < curr.x && dr.y >= curr.x) {
			br.remove(br.size() - 1);
			br.add(new Cordinate1(dr.x, curr.y));
		} else if (dr.x < curr.x && dr.y > curr.x) {

		} else if (dr.x < curr.x && dr.y < curr.x) {
			br.add(new Cordinate1(curr.x, curr.y));
		} else {

		}
		return br;
	}

	static void crodiantevalue(Cordinate1[] c, Cordinate1[] d) {

		ArrayList<Cordinate1> ar = new ArrayList<Codebix.Cordinate1>();
		if (c[0].x > d[0].x) {
			ar.add(new Cordinate1(c[0].x, c[0].y));
		} else {

		}
	}

	static void sortfrequncy(char c[]) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i < c.length; i++) {
			map.put(c[i], map.getOrDefault(c[i], 0) + 1);
		}
		PriorityQueue<Character> p = new PriorityQueue<Character>((a, b) -> {

			int v = map.get(a);
			int u = map.get(b);
			return v - u;
		});
		System.out.println(p);

	}

	static int getmatrixval(int m[][], int x, int y, int sum) {
		if (x == m.length - 1 && y == m.length - 1) {
			return m[x][y];
		}
		if (x == m.length - 1) {
			return m[x][y];
		}
		if (y == m.length - 1) {
			return m[x][y];
		}
		int a = getmatrixval(m, x + 1, y, sum);
		int b = getmatrixval(m, x, y + 1, sum);
		int c = getmatrixval(m, x + 1, y + 1, sum);
		if (a == 0 || b == 0 || c == 0) {
			return 1;
		} else {
			return Math.min(a, Math.min(b, c)) + 1;
		}

	}

	static void getmaxval(int m[][]) {
		int d[][] = new int[m.length][m.length];
		int max = 0;
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length - 1 && j == m.length - 1) {
					d[i][j] = m[i][j];
				} else if (i == m.length - 1) {
					d[i][j] = m[i][j];
				} else if (j == m.length - 1) {
					d[i][j] = m[i][j];
				} else {
					int a = d[i + 1][j];
					int b = d[i][j + 1];
					int c = d[i + 1][j + 1];
					d[i][j] = Math.min(a, Math.min(b, c)) + 1;
					max = d[i][j];
				}
			}
		}
		System.out.println(max);
	}

	static int smallest(Tree tree, int val) {
		if (tree == null) {
			return -1;
		}
		if (tree.left == null && tree.right == null) {
			return 1;
		}
		int a = smallest(tree.left, val);
		int b = smallest(tree.right, val);
		if (b == 3 || a == 3) {
			System.out.println(tree.data);
			return tree.data;
		}

		return Math.max(a, b) + 1;

	}

	static void onlinestock(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while (i != arr.length) {
			if (st.isEmpty()) {
				st.push(arr[i]);
				arr[i] = 1;
			} else if (st.peek() > arr[i]) {
				st.push(arr[i]);
				arr[i] = 1;
			} else {
				int sum = 0;
				while (!st.isEmpty() && st.peek() < arr[i]) {
					int b = st.pop();
					sum = sum + 1;
				}
				st.push(arr[i]);
				arr[i] = sum + 1;

			}
			i++;
		}

		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static class Load {
		int val;
		int level;

		public Load(int val, int level) {
			super();
			this.val = val;
			this.level = level;
		}

	}

	static void node(int arr[]) {
		Stack<Load> st = new Stack<Codebix.Load>();
		int i = 0;
		while (i < arr.length) {
			if (st.isEmpty()) {
				st.push(new Load(arr[i], 1));
				arr[i] = 1;
			} else if (st.peek().val > arr[i]) {
				st.push(new Load(arr[i], 1));
				arr[i] = 1;
			} else {
				int l = 0;
				while (st.peek().val < arr[i]) {
					Load lt = st.pop();
					l = l + lt.level;
				}
				st.push(new Load(arr[i], l + 1));
				arr[i] = l + 1;
			}
			i++;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

	}

	static void findpermuat(HashMap<Character, Integer> hm, String w, int i, String ans) {
		if (i == w.length()) {
			if (hm.size() == 0) {
				System.out.println(ans);
			}
			return;
		}
		if (hm.size() == 0) {
			System.out.println(ans);
			return;
		}

		if (hm.containsKey(w.charAt(i))) {
			int d = hm.get(w.charAt(i));
			if (d - 1 == 0) {
				hm.remove(w.charAt(i));
				findpermuat(hm, w, i + 1, ans + w.charAt(i) + " ");
				hm.put(w.charAt(i), d);
			} else {
				hm.put(w.charAt(i), d - 1);
				findpermuat(hm, w, i + 1, ans + w.charAt(i) + " ");
				hm.put(w.charAt(i), d);
			}
		} else {
			findpermuat(hm, w, i + 1, ans);
		}
	}

	static void anagram(String pattern, String word) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			hm.put(pattern.charAt(i), hm.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		finadllana(word, hm, "");
	}

	static String pattern = "ABC";

	static void finadllana(String word, HashMap<Character, Integer> hm, String ans) {

		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}
		char a = word.charAt(0);
		if (hm.containsKey(a)) {
			int val = hm.get(a);
			if (val - 1 == 0) {
				hm.remove(a);
			} else {
				hm.put(a, val - 1);
			}
			if (hm.size() == 0) {
				for (int i = 0; i < pattern.length(); i++) {
					hm.put(pattern.charAt(i), hm.getOrDefault(pattern.charAt(i), 0) + 1);
				}
			}
			finadllana(word.substring(1), hm, ans + a + " ");
			hm.put(a, val + 1);

		} else {
			finadllana(word.substring(1), hm, ans);

		}

	}

	static void hashmapvale(String word, String pattern) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		int length = pattern.length();
		int i = 0;
		int j = 0;
		while (i < word.length()) {
			if (i - j > pattern.length() - 1) {
				if (map.containsKey(word.charAt(j)))
					temp.put(word.charAt(j), temp.getOrDefault(word.charAt(j), 0) - 1);
				j++;

			}
			if (map.containsKey(word.charAt(i))) {
				temp.put(word.charAt(i), temp.getOrDefault(word.charAt(i), 0) + 1);
				if (temp.equals(map)) {
					System.out.println(true);
				}
			}
			i++;

		}
	}

	static void linkedlistoddeven(LinkedList1 list) {

		LinkedList1 temp = list;
		LinkedList1 even = null;
		LinkedList1 odd = null;
		LinkedList1 heven = null;
		LinkedList1 hodd = null;
		while (list != null) {
			if (list.value % 2 == 0) {
				if (heven == null) {
					heven = list;
					even = heven;
				} else {
					even.next = list;
					even = even.next;
					list = list.next;
				}
			} else {
				if (hodd == null) {
					hodd = list;
					odd = hodd;
				} else {
					odd.next = list;
					odd = odd.next;
					list = list.next;
				}
			}
		}
		hodd.next = heven;

	}

	static void maximumsubarray(int arr[], int i, boolean flag) {
		if (i == arr.length && flag == true) {
			return;
		}
		if (i == arr.length && flag == false) {
			i = 0;
			flag = true;
		}
		count = count + arr[i];
		max = Math.max(max, count);
		if (count < 0) {

			count = 0;
		}
		maximumsubarray(arr, i + 1, flag);

	}

	static Trie trie = new Trie();

	static boolean push(String w, int i, Trie root) {
		if (i == w.length()) {
			return root.flag;
		}
		if (w.charAt(i) == '*') {
			for (int j = 0; j < 26; j++) {
				if (root.label[j] != null) {
					boolean f = push(w, i + 1, root.label[j]);
					if (f == true) {
						return true;
					}
				}
			}
		} else {
			boolean f = push(w, i + 1, root.label[w.charAt(i) - 'A' + 1]);
			if (f == true) {
				return true;
			}
		}
		return false;
	}

	static void add(Trie trie, String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int b = c - 'a' + 1;
			if (trie.label[b] == null) {
				trie.label[b] = new Trie();
			}
			trie = trie.label[b];
		}
		trie.flag = true;
	}

	static boolean serahc(Trie trie, String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int b = c - 'a' + 1;
			if (trie.label[b] == null) {
				return false;
			}
			trie = trie.label[i];
		}
		return trie.flag;
	}

	static void maximumvalue(int arr[], int i, int val, String ds) {
		if (i == arr.length) {
			System.out.println(ds);
			return;
		}
		if (count == 2) {
			maximumvalue(arr, i + 1, val, ds + arr[i] + " ");
		} else if (arr[i] > arr[i + 1]) {
			val = arr[i];
			count++;
			maximumvalue(arr, i + 1, val, ds);
		} else {
			val = arr[i];
			maximumvalue(arr, i + 1, val, ds + arr[i] + " ");
		}
	}

	static void maximumval(int arr[], int val) {
		int i = 0;
		int d = 0;
		int t = 0;
		while (i < arr.length - 1) {
			if (arr[i] > arr[i + 1] && t <= val) {
				t++;

			} else {
				d = d * 10 + arr[i];
			}
			i++;
		}
		System.out.println(d);
	}

	static void maximumvalue(int arr[]) {
		int i = 0;
		int j = arr.length;
		while (i < j) {
			int mid = i + (j - i) / 2;

			if (arr[mid] == arr[mid + 1]) {
				i = mid;
			} else if (arr[mid] == arr[mid - 1]) {
				j = mid;
			} else {
				System.out.println(arr[mid]);
				break;
			}
		}
	}

	static void fldoodmill(int m[][], int x, int y, int count) {
		if (x >= m.length || y >= m.length || x < 0 || y < 0) {
			return;
		}
		if (m[x][y] != 0) {
			return;
		}

		m[x][y] = count++;
		fldoodmill(m, x + 1, y, count);
		fldoodmill(m, x, y + 1, count);
		fldoodmill(m, x - 1, y, count);
		fldoodmill(m, x, y - 1, count);
		fldoodmill(m, x + 1, y + 1, count);

	}

	static void trust(Cordinate1[] cr) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < cr.length; i++) {
			set.add(cr[i].x);
		}
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cr.length; i++) {
			if (!set.contains(cr[i].y))
				hashmap.put(cr[i].y, hashmap.getOrDefault(cr[i].y, 0) + 1);
		}
		System.out.println(hashmap);
	}

	static void validperfect(int v, int i) {
		if (i * i > v) {
			System.out.println(false);
			return;
		}
		if (i * i == v) {
			System.out.println("true");
			return;
		}
		validperfect(v, i + 1);
	}

	public static final int FIVE_SECONDS = 5000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;

	static void straightline(Cordinate1[] c) {
		for (int i = 0; i < c.length - 1; i++) {
			Cordinate1 a = c[i];
			Cordinate1 b = c[i + 1];
			if (b.x - a.x != b.y - b.y) {
				System.out.println(false);
				return;
			}
		}
	}

	static int val = 0;

	static void cousins(Tree tree, int data, int flag) {
		if (tree == null) {
			return;
		}
		if (tree.data == data) {
			val = flag;
		}
		cousins(tree.left, data, flag + 1);
		cousins(tree.right, data, flag + 1);

	}

	static void cousionsbro(Tree tree) {
		Queue<Tree> q = new LinkedList<Codebix.Tree>();
		q.add(tree);
		int val = 0;
		int height = 0;
		int exclude = 0;
		boolean flag = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				Tree t = q.poll();
				if (flag == true && val == height + 1 && tree.data != exclude) {
					System.out.println(tree.data);
				}
				if (t.left != null && t.left.data == 12) {
					flag = true;
					exclude = tree.right.data;
					height = val;
				} else if (t.right != null && t.right.data == 12) {
					flag = true;
					exclude = tree.left.data;
					height = val;
				}
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			val++;
		}
	}

	static void painthouse2(int arr[][]) {
		int maxa = arr[0][0];
		int maxb = arr[0][1];
		int maxc = arr[0][2];
		for (int i = 1; i < arr.length; i++) {
			int ma = arr[i][0] + Math.max(maxb, maxc);
			int mb = arr[i][1] + Math.max(maxa, maxb);
			int mc = arr[i][2] + Math.max(maxa, maxb);
			maxa = ma;
			maxb = mb;
			maxc = mc;

		}
	}

	static void majorityelement(int arr[], int i) {
		int val = 1;
		int vc = arr[0];
		while (i < arr.length) {
			if (vc == arr[i]) {
				val++;
			} else {
				val--;
			}
			if (val == 0) {
				vc = arr[i];
				val = 1;
			} else {

			}
			i++;

		}
		System.out.println(vc);
	}

	static int robber(int arr[], int i, int profit, String path, HashMap<Integer, Integer> map) {
		if (i == arr.length) {
			return 0;
		}
		if (map.containsKey(i)) {
			return map.get(i);
		}

		int a = arr[i] + robber(arr, i + 1, profit + arr[i], path + arr[i] + " ", map);
		int b = robber(arr, i + 1, profit, path, map);
		map.put(i, Math.max(a, b));
		return Math.max(a, b);
	}

	static void bitmani(int i) {
		int d = 0;
		while (d != 4) {
			int c = 1 << d;
			int df = i ^ c;
			i = df;
			d++;
		}

		System.out.println(i + 1);
	}

	static void cancosntruct(String word, String pattern) {
		int i = 0;
		while (i < word.length()) {
			if (!pattern.contains(String.valueOf(word.charAt(i)))) {
				System.out.println(false);
				return;
			}
			int c = pattern.indexOf(String.valueOf(word.charAt(i)));
			pattern = pattern.substring(0, c) + pattern.substring(c + 1);
			i++;
		}
		System.out.println(true);
		return;

	}

	static void construct(String pattern, String word) {
		int[] arr = new int[26];
		char c[] = pattern.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int d = c[i] - 'A' + 1;
			int val = arr[d];
			arr[d] = val++;
		}
		char d[] = word.toCharArray();
		for (int i = 0; i < d.length; i++) {
			int p = d[i] - 'A' + 1;
			int dal = arr[p];
			if (dal == 0) {
				System.out.println(false);
				return;
			}
			arr[p] = dal - 1;
		}
		System.out.println(true);
	}

	static void jewels(String stone, String jewels) {

		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for (int i = 0; i < jewels.length(); i++) {
			hashmap.put(jewels.charAt(i), hashmap.getOrDefault(jewels.charAt(i), 0) + 1);
		}
		int v = 0;
		for (int i = 0; i < stone.length(); i++) {
			if (hashmap.containsKey(stone.charAt(i))) {
				v++;
			}
		}
		System.out.println(v);

	}

	static boolean findvalue(Tree tree, int arr[], int i) {
		if (tree == null) {
			return false;
		}
		if (tree.data != arr[i]) {
			return false;
		}
		if (tree.left == null && tree.right == null && arr[i] == tree.data) {
			return true;
		}
		return findvalue(tree.left, arr, i + 1) || findvalue(tree.right, arr, i + 1);

	}

	static HashMap<Integer, Integer> hasmap = new HashMap<Integer, Integer>();

	static void unique(int val) {

		hasmap.put(val, map.getOrDefault(val, 0) + 1);

		hasmap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue()).filter(a -> a.getValue() == 1)
				.limit(1).forEach(System.out::println);

	}

	static ArrayDeque<Integer> ar = new ArrayDeque<Integer>();

	static int matrixchain(int arr[], int start, int end) {

		if (start >= end) {
			return 0;
		}
		int it = Integer.MIN_VALUE;
		for (int i = start; i < end - 1; i++) {
			int a = matrixchain(arr, start, i);
			int b = matrixchain(arr, i + 1, end);
			int c = arr[start - 1] * arr[i] * arr[end];
			it = Math.max(it, a + b + c);
		}
		return it;
	}

	static void uniquevalue(int arr[]) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				ar.add(arr[i]);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			if (map.get(arr[i]) > 1 && ar.contains(arr[i])) {
				int j = ar.indexOf(arr[i]);
				ar.remove(j);
			}
		}
		System.out.println(ar);

	}

	static void maximumsquare(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length - 1 && j == m.length - 1) {
					dp[i][j] = m[i][j];
				} else if (i == m.length - 1) {
					dp[i][j] = m[i][j];
				} else if (j == m.length - 1) {
					dp[i][j] = m[i][j];
				} else {
					dp[i][j] = Math.min(m[i][j + 1], Math.min(m[i + 1][j + 1], m[i + 1][j]));
				}
			}
		}
	}

	static int editdistance(String a, String b, int count) {
		if (a.length() == 0 && b.length() == 0) {
			return count;
		}
		if (a.length() == 0) {
			return b.length();
		}
		if (b.length() == 0) {
			return a.length();
		}

		if (a.charAt(0) == b.charAt(0)) {
			return editdistance(a.substring(1), b.substring(1), count);
		}
		return Math.min(editdistance(a.substring(1), b, count), editdistance(a, b.substring(1), count)) + 1;
	}

	static int longestsubseq(String a, String b) {
		if (a.length() == 0 && b.length() == 0) {
			return 0;
		}
		if (a.length() == 0 || b.length() == 0) {
			return 0;
		}
		int dc = 0;
		if (a.charAt(0) == b.charAt(0)) {
			dc = 1 + longestsubseq(a.substring(1), b.substring(1));
		}
		return Math.max(dc, Math.max(longestsubseq(a.substring(1), b), longestsubseq(a, b.substring(1))));

	}

	static void suarraysum(int arr[], int i, int sum, String ans) {
		if (arr.length == i) {
			if (sum % 5 == 0)
				System.out.println(ans);
			return;
		}

		suarraysum(arr, i + 1, sum + arr[i], ans + arr[i] + " ");
		suarraysum(arr, i + 1, sum, ans);
	}

	static void subarrayHash(int arr[], int i) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum = sum + arr[j];
			if (map.containsKey(sum % 5)) {
				i = 0;
				for (i = map.get(sum % 5) + 1; i <= j; i++) {
					System.out.print(+arr[i] + " ");
				}
				System.out.println();

			} else {
				map.put(sum % 5, j);
			}
		}
	}

	static void jump(int arr[]) {
		int bc[] = new int[arr.length + 1];
		bc[arr.length] = arr[arr.length - 1];
		for (int j = arr.length - 1; j >= 0; j--) {
			int k = arr[j];
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= k; i++) {
				if (i + j <= arr.length) {
					min = Math.min(min, bc[j + i]);
				}
			}
			bc[j] = min + 1;

		}
		System.out.println(bc[0]);
	}

	static HashMap<Integer, LRU> hashmap = new HashMap<>();
	static ArrayDeque<LRU> q = new ArrayDeque<LRU>();

	static class LRU {
		int id;
		String value;

		public LRU(int id, String value) {
			super();
			this.id = id;
			this.value = value;
		}

	}

	static void getfromcache(int id) {
		if (hashmap.containsKey(id)) {
			LRU temp = hashmap.get(id);
			q.remove(temp);
			q.addFirst(temp);
		}

	}

	static void push(LRU val) {

		if (hashmap.containsKey(val.id)) {
			LRU temp = hashmap.get(val.id);
			hashmap.remove(temp.id);
			hashmap.put(val.id, val);
			q.addFirst(val);
		} else {
			if (q.size() == 3) {
				LRU pt = q.removeLast();
				hashmap.remove(pt.id);
				hashmap.put(val.id, val);
				q.addFirst(val);
			} else {
				q.addFirst(val);
				hashmap.put(val.id, val);
			}

		}
	}

	static void maximumprofit(int arr[], int i, int value, int count, String ans, boolean flag) {
		if (count > 3) {
			max = Math.max(max, value);
			System.out.println(ans);
			return;
		}
		for (int j = i; j < arr.length; j++) {
			if (flag == false) {
				maximumprofit(arr, i + 1, value + arr[i], count + 1, ans + " { " + arr[i] + " ", true);
				maximumprofit(arr, i + 1, value, count, ans, false);
			} else {
				maximumprofit(arr, i + 1, value - arr[i], count + 1, ans + arr[i] + "} ", false);
				maximumprofit(arr, i + 1, value, count, ans, true);
			}
		}
	}

	static void combi(int arr[], int i, int d) {
		if (d >= 3) {
			Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
			System.out.println();
			return;
		}
		for (int j = i; j < arr.length; j++) {
			if (arr[j] == 0) {
				arr[i] = d;
				combi(arr, j, d + 1);
				arr[i] = 0;
			}
		}
	}

	static void transaction(int arr[], int i, int val, int count, String ans, boolean flag) {
		if (i > arr.length - 1) {

			return;
		}
		if (count > 3) {
			max = Math.max(max, val);
			System.out.println(ans);
			return;
		}
		if (flag == false) {
			transaction(arr, i + 1, val + arr[i], count + 1, ans + " <- " + arr[i] + " ", true);
			transaction(arr, i + 1, val, count, ans, false);
		} else {
			transaction(arr, i + 1, val - arr[i], count + 1, ans + arr[i] + " ->", false);
			transaction(arr, i + 1, val, count, ans, true);
		}
	}

	static void bitwise(int m, int n) {
		int d = 0;
		while (n != m) {
			n = n >> 1;
			m = m >> 1;
			d++;
		}
		System.out.println(1 << d);
	}

	static void subarray(int arr[], int sum, boolean m[][]) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 11; j++) {
				if (j == 0) {
					m[i][j] = true;
				} else {
					if (arr[i] < j) {
						m[i][j] = m[i - 1][j];
					} else if (arr[i] >= j) {
						if (m[i - 1][j - arr[i]]) {
							m[i][j] = true;

						} else {
							m[i][j] = false;
						}
						if (m[i][5]) {
							System.out.println(true);
						}
					}

				}

			}
		}

	}

	static void equalsub(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (map.containsKey(sum % 15)) {
				System.out.println(true);
				map.put(sum, j++);
			} else {
				map.put(sum, j);
			}

		}
	}

	static void column(int m[][]) {
		int max = 0;
		for (int i = 0; i < m.length; i++) {
			int r = 0;
			int j = m.length - 1;
			while (j != 0 && m[i][j] != 0) {
				r++;
				r = j;
				r = Math.max(max, r);
			}
		}
		System.out.println(max);

	}

	static Tree binarytree(int pre[], int start, int end) {
		Tree tree = createnode(pre[start]);
		int d = 0;
		for (int i = start + 1; i <= end; i++) {
			if (pre[start] < pre[i]) {
				d = i;
				break;
			}
		}
		tree.left = binarytree(pre, start, d);
		tree.right = binarytree(pre, d + 1, end);
		return tree;

	}

	static int minimumstepv(int n, HashMap<String, Integer> map, int count) {
		if (n < 2) {
			return n;
		}
		String key = n + "a";
		if (map.containsKey(key)) {
			return map.get(key);
		}
		System.out.println(n);
		int d = minimumstepv(n - 1, map, count + 1);
		int c = minimumstepv(n - 2, map, count + 1);
		map.put(key, Math.min(d, c) + 1);
		return Math.min(d, c) + 1;

	}

	static int minimstep(int n) {
		if (n < 2) {
			return 1;
		}
		int a = minimstep(n - 1);
		int b = minimstep(n - 2);
		return Math.min(a, b) + 1;
	}

	static void minimumsteptabu(int n) {
		int arr[] = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			if (i <= 1) {
				arr[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j < 3; j++) {
					if (i - j > 0) {
						min = Math.min(min, arr[i - j]);
					}

				}
				arr[i] = min + 1;
			}
		}
		System.out.println(arr[10]);
	}

	static void sortedsubarray(int arr[], int v) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int mid = i + (j - i) / 2;
			if (arr[mid] > arr[i] && v > arr[i] && v < arr[mid]) {
				j = mid;
			} else if (arr[mid] < arr[i] && v < arr[i] && arr[mid] > v) {
				j = mid;
			} else if (arr[mid] < arr[i] && v > arr[i] && arr[mid] > v) {
				j = mid;
			} else if (arr[mid] > arr[j] && v > arr[mid] && v > arr[j]) {
				i = mid;
			} else if (arr[mid] > arr[j] && v > arr[mid] && v < arr[j]) {
				i = mid;
			} else if (arr[mid] > v) {
				j = mid;
			} else if (arr[mid] < v) {
				i = mid;
			} else {
				if (arr[mid] == v) {
					System.out.println("founded  " + i + " " + j);
					break;
				}
			}

		}
	}

	static String cf = "";

	static int longestcommon(String a, String b, ArrayList<String> ans) {
		if (a.length() == 0 || b.length() == 0) {
			if (ans.size() != 0)
				cf = ans.get(ans.size() - 1);
			return 0;
		}
		int dc = 0;
		if (a.charAt(0) == b.charAt(0)) {
			ans.add(String.valueOf(a.charAt(0)));
			dc = 1 + longestcommon(a.substring(1), b.substring(1), ans);
			ans.remove(ans.size() - 1);
		}
		return Math.max(dc, Math.max(longestcommon(a.substring(1), b, ans), longestcommon(a, b.substring(1), ans)));

	}

	static void numberofisland(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					getisland(m, b, i, j);
				}
			}
		}
	}

	private static void getisland(int[][] m, boolean[][] b, int i, int j) {
		if (i >= m.length || j >= m.length || i < 0 || j < 0 || m[i][j] != 0) {
			return;
		}
		m[i][j] = 1;
		getisland(m, b, i + 1, j);
		getisland(m, b, i, j + 1);
		getisland(m, b, i - 1, j);
		getisland(m, b, i, j - 1);

	}

	static void getinsland(int m[][], boolean b[], int i) {
		b[i] = true;
		for (int j = 0; j < m.length; j++) {
			if (b[j] == false) {
				getinsland(m, b, j);
			}
		}
	}

	static void backspacequal(String a, String b) {
		String bc = removegst(a);
		String dc = removegst(b);
		System.out.println(bc + " " + dc);

	}

	static String removegst(String a) {
		int i = a.length() - 1;
		String b = "";
		while (i >= 0) {
			int dc = 0;
			if (a.charAt(i) == '#') {
				while (a.charAt(i) == '#') {
					dc++;
					i--;
				}

				while (dc != 0) {
					dc--;
					i--;
				}

			} else {
				b = b + a.charAt(i);
				i--;
			}
		}
		return b;
	}

	static void matrixadd(String a, Cordinate1[] c) {

		for (int i = 0; i < c.length; i++) {
			Cordinate1 temp = c[i];
			if (temp.x > 0) {
				String bd = a.substring(a.length() - temp.y);
				String dc = a.substring(a.length(), a.length() - temp.y);
				a = bd + dc;
			} else {
				String bd = a.substring(temp.y);
				String dc = a.substring(temp.y, a.length());
				a = dc + bd;
			}
		}
		System.out.println(a);

	}

	static void lastweight(int arr[]) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			p.add(arr[i]);
		}
		while (p.size() != 1) {
			int a = p.poll();
			int b = p.poll();
			p.add(a - b);
		}
		System.out.println(p);
	}

	static void knapsackprob(int profit[], int weights[], int price) {
		int dp[][] = new int[weights.length + 1][price + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				int including = Integer.MAX_VALUE;
				int excluding = Integer.MAX_VALUE;
				if (weights[i] < j) {
					dp[i][j] = dp[i - 1][j];
				} else if (weights[i] >= j) {
					excluding = dp[i - 1][j - weights[i]] + profit[j];
				}
				dp[i][j] = Math.max(excluding, dp[i - 1][j]);

			}
		}

	}

	static void rodcutting(int profit[], int weight[], int price) {
		int dp[][] = new int[profit.length][price + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < price; j++) {
				if (weight[i] < j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int including = Integer.MAX_VALUE;
					int excluding = Integer.MAX_VALUE;
					if (weight[i] >= j) {
						including = dp[i][j - weight[i]] + profit[i];
					}
					dp[i][j] = Math.max(excluding, dp[i - 1][j]);
				}
			}
		}
	}

	static void decodeways(String arr, int i, String ans) {
		if (arr.length() == 0) {
			System.out.println(ans);
			return;
		}
		decodeways(arr.substring(1), i + 1, ans + ('A' + arr.charAt(0) - 1));
		if (arr.length() > 2) {
			String dc = arr.substring(0, 2);
			char bc = (char) (Integer.parseInt(dc) + 'A' - 1);
			decodeways(arr.substring(0, 2), i, ans + bc);
		}
	}

	static void tabulation(String a) {
		int dp[] = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			if (i == 0) {
				dp[i] = 1;
			} else {
				String c = String.valueOf(a.charAt(i)) + String.valueOf(a.charAt(i - 1));
				if (Integer.parseInt(c) < 26) {
					dp[i] = dp[i - 1] + 2;
				} else {
					dp[i] = dp[i - 1] + 1;
				}

			}

		}
		System.out.println(dp[a.length() - 1]);
	}

	static void insertion(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			int d = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[d]) {
					int temp = arr[d];
					arr[d] = arr[j];
					arr[j] = temp;
					d = j;
				}

			}

		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void bubblesort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void sortval(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int mid = i + (j - i) / 2;

			if (arr[mid] < 4) {
				i = mid;
			} else if (arr[mid] > 4) {
				j = mid;
			} else {
				System.out.println("found");
				return;
			}

		}
	}

	static LinkedList<Integer> linked = new LinkedList<Integer>();

	static void add(int v) {
		linked.add(v);
	}

	static void delete() {
		linked.removeFirst();
	}

	static void intersectionvalue(Integer arr[], Integer brr[]) {

		Set<Integer> set = Arrays.stream(arr).collect(Collectors.toSet());
		Set<Integer> b = Arrays.stream(brr).filter(a -> set.contains(a)).collect(Collectors.toSet());
		System.out.println(b);

	}

	static void countdates(int year, int date, int month) {
		int dyear = year - 1970;
		long count = IntStream.range(1970, year).filter(a -> a % 4 == 0).count();
		System.out.println(count);
		long days = count * 366;
		long valx = dyear - count;
		long valy = valx * 365;
		System.out.println(valx + valy);
		if (year % 4 == 0) {
			int day = getmonth(month, true, date);
			long getd = day + valx + valy;
			System.out.println(getd % 7);

		} else {
			int day = getmonth(month, false, date);
			long getd = day + valx + valy;
			System.out.println(getd % 7);
		}

	}

	static class Month {
		int month;
		int day;

		public Month(int month, int day) {
			super();
			this.month = month;
			this.day = day;
		}
	}

	static Month months[] = { new Month(1, 31), new Month(2, 28), new Month(3, 31), new Month(4, 30) };

	private static int getmonth(int month, boolean b, int date) {
		Month value = months[month];
		int days = 0;
		for (int i = 0; i < months.length; i++) {

			if (months[i].month == value.month) {
				days = days + date;
				return days;

			}
			if (months[i].month == 2) {
				if (b == false) {
					days = days + months[i].day + 1;
				}
			}
			days = days + months[i].day;
		}
		return 0;
	}

	static void concanetedword(String words, Set<String> set, String ans) {
		if (words.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < words.length(); i++) {
			String dc = words.substring(0, i + 1);
			if (set.contains(dc)) {
				concanetedword(words.substring(i + 1), set, ans + dc + " ");
			}
		}
	}

	static void keyboard(int len) {

		int nearestprime = nearestprime(len, 2);
		if (nearestprime > 0) {
			int nearest = nearestprime;
			int count = nearest + 1;
			int temp = nearest * 2;
			while (temp != 0 && len % temp == 0) {
				nearest = nearest + 2;
				temp = 2 * temp;
			}
			int val = len / temp;

			System.out.println(count + val);

		} else {
			System.out.println(len);
		}

	}

	private static int nearestprime(int len, int f) {
		if (len / 2 <= f) {
			return -1;
		}
		if (len % f == 0) {
			return f;
		}
		int d = nearestprime(len, f + 1);
		if (d != -1) {
			return d;
		} else {
			return d;
		}
	}

	static void logestvalueparanthesis(String a, int i, Stack<Character> st, String ans) {

		int count = 0;
		while (i < a.length()) {
			if (a.charAt(i) == '(') {
				count++;
				st.push(a.charAt(i));
			} else if (a.charAt(i) == ')') {
				if (st.isEmpty()) {
					max = Math.max(max, count);
					count = 0;
				} else {
					while (!st.isEmpty()) {
						st.pop();
						count++;
					}
				}
			}
			i++;
		}
		max = Math.max(max, count);
		System.out.println(max);

	}

	static void permuatte(String a, int i, int count, String ans) {
		if (a.length() == i) {
			System.out.println(count);
			System.out.println(ans);
			return;
		}
		for (int j = i; j < a.length(); j++) {
			if (Character.isAlphabetic(a.charAt(i))) {
				char dc = a.charAt(i);
				if (Character.isUpperCase(dc)) {
					char bc = Character.toLowerCase(dc);
					String dcd = a;
					a = a.substring(0, i) + bc + a.substring(i + 1);
					permuatte(a, i + 1, count + 1, ans + a + "     <-");
					a = dcd;
				} else {
					permuatte(a, i + 1, count, ans);
				}

			} else {
				permuatte(a, i + 1, count + 1, ans);
			}
		}
	}

	static void countofsmaller(int arr[], int i, Tree curr) {
		Tree tree = createnode(arr[i]);

	}

	static void happynumber(int number) {
		Set<Integer> set = new HashSet<Integer>();

		while (number > 10) {

			int f = 0;
			String dc = "";
			while (number != 0) {
				int digit = number % 10;
				dc = digit + dc;
				f = f + digit * digit;
				number = number / 10;
			}
			number = f;
			if (set.contains(number)) {
				System.out.println(false);
			}
			set.add(f);
		}
		System.out.println(number);

	}

	static void rectangleare(Cordinate1 fl, Cordinate1 fh, Cordinate1 sl, Cordinate1 sh) {

		int rect1 = Math.abs(fl.x - fh.x);
		rect1 = rect1 * (Math.abs(fl.y - fh.y));
		int rect2 = Math.abs(sl.x - sh.x) * Math.abs(sl.y - sh.y);

		int areax = Math.max(fl.x, sl.x);
		int areax2 = Math.min(fh.x, sh.x);
		int bc = Math.min(areax - areax2, 0);

	}

	static int distinctsubsequnce(String a, String b) {
		if (a.length() == 0) {
			return 1;
		}
		if (b.length() == 0) {
			return 0;
		}
		int c = 0;
		if (a.charAt(0) == b.charAt(0)) {
			return distinctsubsequnce(a.substring(1), b.substring(1));
		}
		return distinctsubsequnce(a.substring(1), b) + distinctsubsequnce(a, b.substring(1));
	}

	static void minimumpathsum(int m[][], int x, int y, int path) {
		if (m.length == x && m.length == y) {
			System.out.println(path);
			return;
		}
		if (x > m.length || y > m.length || x < 0 || y < 0 || m[x][y] == -2) {
			return;
		}
		int f = m[x][y];
		m[x][y] = -2;
		path = path + f;
		minimumpathsum(m, x + 1, y, path);
		minimumpathsum(m, x, y + 1, path);
		m[x][y] = f;
	}

	static void minimumsum(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length - 1 && j == m.length - 1) {
					dp[i][j] = m[i][j];
				} else if (i == m.length - 1) {
					dp[i][j] = dp[i][j + 1] + m[i][j];
				} else if (j == m.length - 1) {
					dp[i][j] = dp[i + 1][j] + m[i][j];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
				}
			}
		}
	}

	static void anagram1(String word, String pattern) {
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> mobile = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			hashmap.put(pattern.charAt(i), hashmap.getOrDefault(pattern.charAt(i), 0) + 1);
			mobile.put(pattern.charAt(i), mobile.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		findana(word, 0, hashmap, mobile);

	}

	private static void findana(String word, int j, HashMap<Character, Integer> hashmap2,
			HashMap<Character, Integer> mobile) {
		if (j == word.length()) {

			return;
		}

		if (hashmap2.containsKey(word.charAt(j))) {
			HashMap<Character, Integer> mobile1 = hashmap2;
			int v = hashmap2.get(word.charAt(j));
			if (v - 1 == 0) {
				hashmap2.remove(word.charAt(j));
			} else {
				hashmap2.put(word.charAt(j), v - 1);
			}
			if (hashmap2.size() == 0) {
				System.out.println("found");
				hashmap2.putAll(mobile);
			}
			findana(word, j + 1, hashmap2, mobile);

		}

		else {
			hashmap2.clear();
			hashmap2.putAll(mobile);
			findana(word, j + 1, hashmap2, mobile);
		}
	}

	static void findallanagram(String word, String pattern) {
		HashMap<Character, Integer> hashmap2 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> mobile = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			hashmap2.put(pattern.charAt(i), hashmap2.getOrDefault(pattern.charAt(i), 0) + 1);
			mobile.put(pattern.charAt(i), mobile.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int j = 0;
		while (j < word.length()) {
			if (hashmap2.containsKey(word.charAt(j))) {
				HashMap<Character, Integer> mobile1 = hashmap2;
				int v = hashmap2.get(word.charAt(j));
				if (v - 1 == 0) {
					hashmap2.remove(word.charAt(j));
				} else {
					hashmap2.put(word.charAt(j), v - 1);
				}
				if (hashmap2.size() == 0) {
					System.out.println("found");
					hashmap2.putAll(mobile);
				}

			} else {
				hashmap2.clear();
				hashmap2.putAll(mobile);
			}
			j++;
		}

	}

	static void validparenthisis(String a) {
		Stack<Character> st = new Stack<Character>();
		Stack<Character> star = new Stack<Character>();
		int i = 0;
		while (i < a.length()) {
			if (a.charAt(i) == '(') {
				st.push('(');
			} else if (a.charAt(i) == '*') {
				star.push('*');
			} else {
				if (!st.isEmpty()) {
					st.pop();
				} else {
					if (!star.isEmpty()) {
						star.pop();
					} else {
						System.out.println("something fishy fishy");
						return;
					}
				}
			}
			i++;

		}

		while (!st.isEmpty() && !star.isEmpty()) {
			star.pop();
			st.pop();
		}
		if (st.isEmpty()) {
			System.out.println("Waoo");
		}

		else {
			System.out.println("not applicable");
		}
	}

	static void maximumdepth(Tree tree) {
		if (tree == null) {
			return;
		}
	}

	static void cordigt(Cordinate1 c[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < c.length; i++) {
			hashmap.put(c[i].y, hashmap.getOrDefault(c[i].y, 0) + 1);
		}
		Optional<Entry<Integer, Integer>> findAny = hashmap.entrySet().stream().findAny();
		if (findAny.get().getValue() == c.length - 1) {
			System.out.println("found");
		} else {
			System.out.println("no celebrity");
		}
	}

	static void celebrityprob(int m[][]) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < m.length; i++) {
			st.push(i);
		}
		while (st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			if (m[a][b] == 1 && m[b][a] == 0) {
				st.push(b);
			}

		}

	}

	static void stock3(int arr[], int i, int value, boolean flag, String ans, int count) {
		if (arr.length == i) {
			if (count == 4)
				System.out.println(ans);
			return;
		}
		if (flag == true) {
			stock3(arr, i + 1, value + arr[i], false, ans + arr[i] + " ", count + 1);
			stock3(arr, i + 1, value, flag, ans, count);
		} else {
			stock3(arr, i + 1, value - arr[i], true, ans + arr[i] + " ", count + 1);
			stock3(arr, i + 1, value, flag, ans, count);
		}
	}

	static void sortlink(LinkedList1 list) {
		LinkedList1 head = list;
		LinkedList1 tail = list;
		int i = 1;
		while (list != null) {

			if (i % 2 == 1) {
				if (head == null) {
					head = list;
					tail = head;
					list = list.next;
				} else {
					tail.next = list;
					tail = tail.next;
					list = list.next;
				}
			}
			if (i % 2 == 0) {
				if (head == null) {
					head = list;
					tail = head;
					list = list.next;
				} else {
					tail.next = list;
					tail = tail.next;
					list = list.next;
				}
			}
			i++;
		}
		LinkedList1 rec = recursive(list);
	}

	private static LinkedList1 recursive(LinkedList1 list2) {

		LinkedList1 prev = null;
		while (list2 != null) {
			LinkedList1 next = list2.next;
			list2.next = prev;
			prev = list2;
			list2 = next;
		}
		return prev;
	}

	private static LinkedList1 recursiserevrs(LinkedList1 list) {
		if (list.next == null || list == null) {
			return list;
		}
		LinkedList1 temp = recursiserevrs(list.next);
		list.next.next = list;
		return temp;

	}

	static void sortarraybyparity(int arr[]) {
		int i = 0;
		int j = 0;

		while (j < arr.length) {
			if (arr[j] % 2 == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			j++;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

	}

	static boolean remote(char c) {

		int d = c - 'A' + 1;
		if (trie.label[d].flag) {
			trie = trie.label[d];
			return true;
		} else {
			return false;
		}
	}

	static void insert(List<String> list) {
		list.stream().forEach(a -> insertdata(a));
	}

	private static void insertdata(String a) {
		Trie root = new Trie();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			int d = c - 'A' + 1;
			if (root.label[d] == null) {
				root = new Trie();
			}
			root = root.label[d];
		}
		root.flag = true;
	}

	static void sumofleftleaves(Tree tree, boolean flag, int val) {
		if (tree == null) {
			return;
		}
		if (tree.left == null && tree.right == null && flag == true) {
			val = val + tree.data;
			max = max + val;
		}
		sumofleftleaves(tree.left, true, val + tree.data);
		sumofleftleaves(tree.right, false, val);

	}

	static void minimumcost(int days[], int j, int ticket[], int val, String ans) {
		if (days.length == j) {
			System.out.println(ans);
			return;
		}
		int v = ticket[0];
		minimumcost(days, j + 1, ticket, val, ans);
	}

	static void getcordinate(List<Cordinate1> list) {

		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			arr.add(list.get(i).x);
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).x, i);
		}

		Collections.sort(arr);
		int ar[] = new int[arr.size()];
		for (int i = 0; i < list.size(); i++) {
			Cordinate1 ct = list.get(i);
			int k = 0;
			int l = list.size();
			int f = -1;
			while (k < l) {
				int mid = (k + l) / 2;
				if (arr.get(mid) < ct.y) {
					k = mid;
				} else if (arr.get(mid) > ct.x) {
					l = mid;
				} else {
					f = mid;
				}
			}
			if (f == -1) {
				int bc = list.get(i).x;
				int dc = map.get(bc);
				ar[dc] = -1;
			} else {

				int bc = list.get(f).x;
				int dc = map.get(bc);
				ar[dc] = f;

			}

		}

	}

	static void pancakesorting(int arr[]) {
		int d = 0;
		for (int i = 0; i < arr.length; i++) {
			int value = (arr.length - d);
			int c = value;
			int place = 0;
			for (int j = 0; j < arr.length - d; j++) {
				if (arr[j] == c) {
					place = j;
					break;
				}
			}
			int temp = arr[place];
			arr[place] = arr[0];
			arr[0] = temp;

			int replace = arr[0];
			arr[0] = arr[arr.length - 1 - d];
			arr[arr.length - 1 - d] = replace;
			d++;

		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void largest(int arr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			hashmap.put(i, arr[i]);
		}
		int i = 0;
		while (i < 4) {
			int val = -1;
			if (i == 0) {
				int max = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] < 3 && max < arr[j] && hashmap.containsKey(j)) {
						max = arr[j];
						val = j;
					}
				}
				if (val == -1) {
					System.out.println("cannot be made");
					return;

				} else {
					System.out.print(max + " ");
					hashmap.remove(val);
				}
			}
			if (i == 1) {
				int max = 0;
				int vald = -1;
				for (int j = 0; j < arr.length; j++) {
					if (val == 2 && arr[j] < 5 && max < arr[j] && hashmap.containsKey(j)) {
						max = arr[j];
						vald = j;
					} else if (val < 2 && arr[j] < 10 && max < arr[j] && hashmap.containsKey(j)) {
						max = arr[j];
						vald = j;
					}
				}
				if (vald == -1) {
					System.out.println("cannot be made");
					return;
				} else {
					System.out.print(max + " :");
					hashmap.remove(vald);
				}
			}
			if (i == 2) {
				int max = 0;
				int vald = -1;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] < 10 && max < arr[j] && hashmap.containsKey(j)) {
						max = arr[j];
						vald = j;
					}
				}
				if (vald == -1) {
					System.out.println("cannot be made");
					return;
				} else {
					System.out.print(max + " ");
					hashmap.remove(vald);
				}
			}
			if (i == 3) {
				int max = 0;
				int vald = -1;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] < 10 && max < arr[j] && hashmap.containsKey(j)) {
						max = arr[j];
						vald = j;
					}
				}
				if (vald == -1) {
					System.out.println("cannot be made");
					return;
				} else {
					System.out.print(max + " ");
					hashmap.remove(vald);
				}
			}
			i++;
		}
	}

	static class Val {
		boolean flag;
		int count;

		public Val(boolean flag, int count) {
			super();
			this.flag = flag;
			this.count = count;
		}

	}

	static void longestconsecutive(int m[]) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < m.length; i++) {
			map.put(m[i], true);
		}

		for (Integer it : map.keySet()) {
			if (map.get(it - 1) != null) {
				map.put(it, false);
			}
		}
		System.out.println(map);
		for (Integer it : map.keySet()) {
			int v = 0;
			while (map.get(it + 1) != null) {
				it = it + 1;
				v++;
			}
			max = Math.max(v, max);
		}
		System.out.println(max);

	}

	static String value[] = { "abc", "def", "ghi", "jkl" };

	static void letter(String a, String ans) {

		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		int c = Integer.parseInt(Character.toString(a.charAt(0)));
		String v = value[c];
		for (int i = 0; i < v.length(); i++) {
			char d = v.charAt(i);
			letter(a.substring(1), ans + d + " ");
		}

	}

	static void serialzie(Tree tree, int arr[], int i) {
		if (tree == null) {
			arr[i] = -1;
			return;
		}
		arr[i] = tree.data;
		serialzie(tree.left, arr, i + 1);
		serialzie(tree.right, arr, i + 1);

	}

	static Tree desizrli(int brr[], int start, int end) {
		if (start < end) {
			return null;
		}
		Tree tree = createnode(brr[start]);
		int d = 0;
		for (int i = start; i < end; i++) {
			if (brr[i] == -1) {
				d = i;
				break;
			}
		}
		tree.left = desizrli(brr, start, d);
		tree.right = desizrli(brr, d + 1, end);
		return tree;

	}

	static void peakelement(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = arr.length - 1;

		while (i >= 0) {
			if (i == arr.length - 1) {
				st.push(arr[i]);
			} else {
				if (st.peek() > arr[i]) {
					int d = arr[i];
					arr[i] = st.peek();
					st.push(d);
				} else if (st.peek() < arr[i]) {
					while (!st.isEmpty() && st.peek() < arr[i]) {
						st.pop();
					}
					if (st.isEmpty()) {

						st.push(arr[i]);
						arr[i] = -1;
					} else {
						int d = arr[i];
						arr[i] = st.peek();
						st.push(d);
					}
				}

			}
			i--;
		}

		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void maximumwater(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int a = arr[i];
			int b = arr[j];
			int min = Math.min(a, b);
			int ds = (j - i) * min;
			System.out.print(ds + " ");
			if (a < b) {
				i++;
			} else {
				j--;
			}

		}
	}

	static void getsmallest(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while (i < arr.length) {
			if (st.isEmpty()) {
				st.push(arr[i]);
			} else if (st.peek() > arr[i]) {
				st.push(arr[i]);
			}
			i++;
		}
		st.stream().forEach(a -> System.out.print(a + " "));
	}

	static void largestelement(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = arr.length - 1;
		while (i >= 0) {
			if (st.isEmpty()) {
				st.push(arr[i]);
			} else if (arr[i] > st.peek()) {
				while (st.peek() < arr[i]) {
					st.pop();
				}
				int v = st.peek();
				st.push(arr[i]);
				arr[i] = v;
			} else if (st.peek() > arr[i]) {
				int v = st.peek();
				st.push(arr[i]);
				arr[i] = v;
			}
			i--;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void largestele(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while (i < arr.length) {
			if (st.isEmpty()) {
				st.push(i);
			} else if (arr[i] > arr[st.peek()]) {
				while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
					int v = st.pop();
					arr[v] = arr[i];
				}
				st.push(i);
			} else if (arr[i] < arr[st.peek()]) {
				while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					int v = arr[st.peek()];
					st.push(i);
					arr[i] = v;
				} else {
					st.push(i);
					arr[i] = -1;

				}
			}
			i++;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

	}

	static Queue<Integer> queue1 = new LinkedList<Integer>();
	static Queue<Integer> queue2 = new LinkedList<Integer>();

	static void push(int v) {
		if (!queue1.isEmpty())
			queue1.add(v);
		else {
			queue2.add(v);
		}
	}

	static void pop() {
		if (!queue1.isEmpty()) {
			while (!queue1.isEmpty() && queue1.size() != 1) {
				queue2.add(queue1.poll());
			}
			int a = queue1.poll();
			System.out.println(a);
		} else {
			while (!queue2.isEmpty() && queue2.size() != 1) {
				queue1.add(queue2.poll());
			}
			int a = queue2.poll();
			System.out.println(a);
		}
	}

	static void postfixevalution(String a) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Character> expression = new Stack<Character>();

		int i = 0;
		while (i < a.length()) {
			if (Character.isDigit(a.charAt(i))) {
				st.push(Integer.parseInt(String.valueOf(a.charAt(i))));
			} else {

				if (a.charAt(i) != '(' && a.charAt(i) != ')') {
					if (!expression.isEmpty()) {
						int v = checkpriority(a.charAt(i));
						int w = checkpriority(expression.peek());
						if (v > w) {
							expression.push(a.charAt(i));
						} else {
							int ab = st.pop();
							int bc = st.pop();
							char dc = expression.pop();
							if (dc == '+') {
								st.push(ab + bc);
								expression.push(a.charAt(i));
							} else if (dc == '-') {
								st.push(ab - bc);
								expression.push(a.charAt(i));
							} else if (dc == '*') {
								st.push(ab * bc);
								expression.push(a.charAt(i));
							} else if (dc == '+') {
								st.push(ab / bc);
								expression.push(a.charAt(i));
							}
						}
					} else {
						expression.push(a.charAt(i));
					}

				}
			}
			i++;
		}

		while (!st.isEmpty() && !expression.isEmpty()) {

			int ab = st.pop();
			int bc = st.pop();
			char dc = expression.pop();
			if (dc == '+') {
				st.push(ab + bc);

			} else if (dc == '-') {
				st.push(ab - bc);

			} else if (dc == '*') {
				st.push(ab * bc);

			} else if (dc == '+') {
				st.push(ab / bc);

			}

		}
		System.out.println(st.peek());

	}

	private static int checkpriority(char charAt) {

		if (charAt == '+') {
			return 1;
		} else if (charAt == '-') {
			return 1;
		} else if (charAt == '*') {
			return 2;

		} else {
			return 2;
		}

	}

	static void complete(String s) {
		Stack<Character> st = new Stack<Character>();
		int i = 0;
		boolean flag = true;
		while (i < s.length()) {
			if (!Character.isDigit(s.charAt(i))) {
				if (s.charAt(i) == '(') {
					st.push(s.charAt(i));
					if (i + 1 < s.length() && s.charAt(i + 1) == '(') {
						flag = true;
					}
				} else if (s.charAt(i) == ')') {
					st.pop();
					if (flag == true) {
						if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
							System.out.println(true);
							return;
						}
					}

				}

			}
			i++;

		}
		System.out.println(false);
		return;
	}

	static void stockspan(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		int brr[] = new int[arr.length];
		int k = 0;
		while (i < arr.length) {
			if (st.isEmpty()) {
				st.push(i);
				brr[k++] = i + 1;
			} else if (arr[i] >= arr[st.peek()]) {
				while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
					st.pop();
				}
				if (st.isEmpty()) {
					st.push(i);
					brr[k++] = i + 1;
				} else {
					int d = st.peek();
					st.push(i);
					brr[k++] = i - d;

				}
			} else if (arr[i] <= arr[st.peek()]) {
				int d = st.peek();
				st.push(i);
				brr[k++] = i - d;
			}
			i++;

		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
		System.out.println();
		Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
	}

	static void largehistogram(int arr[]) {
		Stack<Integer> front = new Stack<Integer>();
		Stack<Integer> back = new Stack<Integer>();
		int brr[] = new int[arr.length];
		int crr[] = new int[arr.length];
		int i = 0;
		int k = 0;
		while (i < arr.length) {
			if (front.isEmpty()) {
				front.push(i);
				brr[k++] = i + 1;
			} else if (arr[front.peek()] <= arr[i]) {
				int v = front.peek();
				front.push(i);
				brr[k++] = i - v;
			} else if (arr[front.peek()] >= arr[i]) {
				while (!front.isEmpty() && arr[front.peek()] >= arr[i]) {
					front.pop();
				}
				if (front.isEmpty()) {
					brr[k++] = i + 1;
					front.push(i);
				} else {
					int v = front.peek();
					front.push(i);
					brr[k++] = i - v;
				}
			}
			i++;

		}

		int j = arr.length - 1;
		int p = 0;
		while (j > 0) {
			if (back.isEmpty()) {
				back.push(j);
				crr[p++] = j + 1;
			} else if (arr[back.peek()] <= arr[j]) {
				int v = back.peek();
				back.push(j);
				crr[p++] = v - j;
			} else if (arr[back.peek()] >= arr[j]) {
				while (!back.isEmpty() && arr[back.peek()] >= arr[j]) {
					back.pop();
				}
				if (back.isEmpty()) {
					crr[p++] = j + 1;
					back.push(j);
				} else {
					int v = back.peek();
					back.push(j);
					crr[p++] = v - j;
				}
			}
			j--;

		}

		for (int m = 0; m < arr.length; m++) {
			int v = crr[m] - brr[m];
			arr[m] = v * arr[m];
		}
		Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
		System.out.println();
		Arrays.stream(crr).forEach(a -> System.out.print(a + " "));
		System.out.println();
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

	}

	static void maximumwindow(int arr[]) {
		ArrayDeque<Integer> ar = new ArrayDeque<Integer>();
		int i = 3;
		int j = 0;
		for (int k = 0; k < 3; k++) {
			if (k == 0) {
				ar.add(k);
			} else {
				while (!ar.isEmpty() && arr[ar.peekLast()] < arr[k]) {
					ar.pollLast();
				}
				ar.addLast(k);
			}
		}
		System.out.println(arr[ar.peekFirst()]);

		while (i < arr.length) {
			System.out.println(arr[ar.peekFirst()]);
			if (i - ar.peekFirst() < 3) {
				while (!ar.isEmpty() && arr[ar.peekLast()] < arr[i]) {
					ar.pollLast();
				}
				ar.addLast(i);

			} else if (i - ar.peekFirst() == 3) {
				ar.pollFirst();

			}
			i++;
		}

	}

	static void celbirty(int m[][]) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < m.length; i++) {
			st.push(i);
		}
		while (!st.isEmpty()) {
			int a = st.pop();
			int b = st.pop();
			if (m[a][b] == 1) {
				st.push(b);
			} else if (m[b][a] == 1) {
				st.push(a);
			}

		}
		if (st.size() == 1) {
			System.out.println(st.pop());
		}
	}

	static void mergingproblem(List<Cordinate1> c) {
		
		for (Cordinate1 it : c) {

		}

	}

	public static void main(String... args) throws Exception {

		maximumwindow(new int[] { 2, 9, 3, 8, 1, 1, 1, 1, 1, });
	}
}
