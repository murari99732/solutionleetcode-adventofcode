package queueimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Recursion {

	static ArrayList<String> subsequence(String a) {
		if (a.length() == 0) {
			ArrayList<String> dc = new ArrayList<String>();
			dc.add("");
			return dc;
		}
		ArrayList<String> ab = subsequence(a.substring(1));
		ArrayList<String> bc = new ArrayList<String>();
		String abc = p[a.charAt(0) - '0'];
		for (int i = 0; i < abc.length(); i++) {
			char df = (char) (abc.charAt(i) - 'A');
			for (String it : ab) {
				bc.add(it + df);
			}
		}
		return bc;
	}

	static String p[] = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQR" };

	static ArrayList<String> keypad(String a) {
		if (a.length() == 0) {
			ArrayList<String> dc = new ArrayList<String>();
			dc.add("");
			return dc;
		}
		ArrayList<String> ab = keypad(a.substring(1));
		String dc = p[Math.abs(a.charAt(0) - '0')];
		ArrayList<String> df = new ArrayList<String>();
		for (int k = 0; k < dc.length(); k++) {
			char pt = dc.charAt(k);
			for (String st : ab) {
				df.add(st + pt);
			}
		}
		return df;
	}

	static void keypadmatrix(String a, String b) {
		if (a.length() == 0) {
			System.out.println(b);
			return;
		}
		char c = a.charAt(0);

		String dc = p[Math.abs(a.charAt(0) - '0')];
		for (int i = 0; i < dc.length(); i++) {
			char pt = dc.charAt(i);
			keypadmatrix(a.substring(1), b + pt);

		}

	}

	static void printstairs(int d, String ans) {
		if (d < 1) {
			System.out.println(ans);
			return;
		}
		printstairs(d - 1, ans + d + " ");
		printstairs(d - 2, ans + d + " ");
	}

	static ArrayList<String> printstairs(int val, ArrayList<String> ar) {
		if (val < 1) {
			ar.add("");
			return ar;
		}
		ArrayList<String> ab = printstairs(val - 1, ar);
		ArrayList<String> bc = printstairs(val - 2, ar);
		for (String g : ab) {
			ar.add(g + val);
		}
		for (String h : bc) {
			ar.add(h + val);
		}
		return ar;
	}

	static void matrix(int m[][], int x, int y, String ans) {
		if (x < 0 || y < 0 || x > m.length || y > m.length) {
			return;
		} else {

		}
		matrix(m, x + 1, y, ans + m[x][y] + " ");
		matrix(m, x, y + 1, ans + m[x][y] + " ");
	}

	static void printmazejump(int m[][], int x, int y) {
		if (x == m.length || y == m.length) {
			System.out.println(m);
			return;
		}
		for (int i = 0; i < m.length - x; i++) {
			printmazejump(m, i, y);
		}
		for (int i = 0; i < m.length - y; i++) {
			printmazejump(m, x, i);
		}
	}

	static void printpermutation(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			String ab = a.substring(0, i);
			String bc = a.substring(i + 1);
			printpermutation(ab + bc, ans + c + " ");
		}
	}

	static void printencoding(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		printencoding(a.substring(1), ans + a.charAt(0) + " ");
		if (a.length() > 2)
			printencoding(a.substring(2), ans + a.charAt(0) + a.charAt(1) + " ");

	}

	static void floodfill(int m[][], int x, int y, String ans, boolean b[][]) {
		if (x < 0 || y < 0 || x > m.length || y > m.length || b[x][y]) {
			return;
		} else {
			if (x == m.length || y == m.length) {
				System.out.println(ans);
			}
		}
		b[x][y] = true;
		floodfill(m, x + 1, y, ans + m[x][y], b);
		floodfill(m, x, y + 1, ans + m[x][y], b);
		floodfill(m, x - 1, y, ans + m[x][y], b);
		floodfill(m, x, y - 1, ans + m[x][y], b);
		b[x][y] = false;
	}

	static ArrayList<Character> ar = new ArrayList<Character>();

	static void printabb(int val, String a) {
		if (val == 0 || a.length() == 0) {
			System.out.println(ar);
			return;
		}
		ar.add(a.charAt(0));
		printabb(val - 1, a.substring(1));
		ar.remove(ar.size() - 1);
		ar.add((char) ('0' + 1));
		printabb(val - 1, a.substring(1));
		ar.remove(ar.size() - 1);
	}

	static void printabbrevation(String val, String ans, Integer bns) {
		if (val.length() == 0) {
			System.out.println(ans + " ->  " + bns);
			System.out.println();
			return;
		}
		printabbrevation(val.substring(1), ans + val.charAt(0) + " ", bns);
		printabbrevation(val.substring(1), ans, bns + 1);

	}

	static void maximuscore(String a[], int i, Map<Character, Integer> set, String store[], ArrayList<String> ar) {
		maximuscore(a, i + 1, set, store, ar);
		String dc = a[i];
		boolean flag = true;
		Map<Character, Integer> temp = set;
		for (int j = 0; j < dc.length(); j++) {
			if (set.containsKey(dc.charAt(j))) {
				int val = set.get(dc.charAt(j));
				if (val == 0) {
					flag = false;
				} else {
					set.put(dc.charAt(j), val - 1);
				}
			} else {
				flag = false;
			}

		}
		set = temp;
		if (flag == true) {
			ar.add(dc);
			maximuscore(a, i + 1, set, store, ar);
			ar.remove(ar.size() - 1);
		}

	}

	static void lexograph() {
		for (int i = 1; i <= 9; i++) {
			lexoutil(i, 4000000);
		}
	}

	private static void lexoutil(int i, int j) {
		if (i >= j) {
			return;
		}
		System.out.println(i);
		for (int k = 0; k < 9; k++) {
			lexoutil(i * 10 + k, j);
		}

	}

	static void friendpairing(int arr[], int i, String ans, boolean b[]) {
		if (i == arr.length) {
			System.out.println(ans);
			return;
		}
		if (b[i] == false) {
			b[i] = true;
			friendpairing(arr, i + 1, ans + arr[i] + "-> ", b);
			for (int j = i + 1; j < arr.length; j++) {
				if (b[j] == false) {
					b[j] = true;
					friendpairing(arr, i + 1, ans + "{ " + arr[i] + "  " + arr[j] + " }", b);
					b[j] = false;
				}
			}
			b[i] = false;
		} else {
			friendpairing(arr, i + 1, ans, b);
		}
	}

	static void subsetvalue(String a, String ans, String bns) {
		if (a.length() == 0) {
			System.out.println(ans + " " + bns);
			return;
		}
		subsetvalue(a.substring(1), ans + a.charAt(0) + " ", bns);
		subsetvalue(a.substring(1), ans, bns + a.charAt(0) + " ");
	}

	static void recu(String ab, int ans, String abs) {
		if (ab.length() == 0) {
			System.out.println(abs + " " + ans);

			return;
		}
		recu(ab.substring(1), ans, abs + ab.charAt(0) + " ");
		recu(ab.substring(1), ans + 1, abs);
	}

	static void crossword(char c[][], String words[], int index) {
		String word = words[index];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[i][j] != '+' || c[i][j] == word.charAt(0)) {

				}
			}
		}
	}

	static void pairingfriend(int friend[], int index, String ans, boolean b[]) {
		if (index == friend.length) {
			System.out.println(ans);
			return;
		}
		if (b[index] == false) {
			b[index] = true;
			pairingfriend(friend, index + 1, ans + " { " + friend[index] + " } ", b);
			for (int i = index + 1; i < friend.length; i++) {
				if (b[i] == false) {
					b[i] = true;
					pairingfriend(friend, index + 1, " {" + ans + friend[i] + "} ", b);
					b[i] = false;
				}
			}
			b[index] = false;
		} else {
			pairingfriend(friend, index + 1, ans, b);
		}
	}

	static void ksubset(int arr[], int index, ArrayList<ArrayList<Integer>> ar, String ans, boolean b[]) {
		if (index == arr.length) {
			System.out.println(ar);

			return;
		}
		if (b[index] == false) {
			b[index] = true;
			for (int i = 0; i < ar.size(); i++) {
				ar.get(i).add(arr[index]);
				ksubset(arr, index + 1, ar, ans, b);
				ar.get(i).remove(ar.get(i).size() - 1);
			}
			b[index] = false;
		}
	}

	static void heera(int arr[], int index, ArrayList<Integer> ar, ArrayList<Integer> br, boolean b[]) {
		if (index == arr.length) {
			System.out.println(" A:: " + ar + " B:: " + br);
			System.out.println();
			return;
		}

		if (b[index] == false) {
			b[index] = true;
			ar.add(arr[index]);
			heera(arr, index + 1, ar, br, b);
			ar.remove(ar.size() - 1);
			br.add(arr[index]);
			heera(arr, index + 1, ar, br, b);
			br.remove(br.size() - 1);
			b[index] = false;
		}

	}

	static void partitionk(int arr[], int index, ArrayList<ArrayList<Integer>> ar, boolean b[]) {
		if (index == arr.length) {
			System.out.println(ar);

			return;
		}
		if (b[index] == false) {
			b[index] = true;
			for (int i = 0; i < ar.size(); i++) {
				ar.get(i).add(arr[index]);
				partitionk(arr, index + 1, ar, b);
				ar.get(i).remove(ar.get(i).size() - 1);
			}
			b[index] = false;
		}

	}

	static void palindromixpermutation(String a, String index) {
		if (a.length() == 0) {
			System.out.println(index);
			return;
		}
		palindromixpermutation(a.substring(1), index + a.charAt(0) + " ");
		palindromixpermutation(a.substring(1), index);
	}

	static boolean isPalindrome(String str) {

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

	static void plaindromicpartition(String a, String index) {

		if (a.length() == 0) {
			System.out.println(index);
			return;
		}

		for (int i = 0; i < a.length(); i++) {
			String temp = a.substring(0, i);
			if (isPalindrome(temp)) {
				plaindromicpartition(a.substring(i + 1), index + temp + " ");
			} else {
				plaindromicpartition(a.substring(i + 1), index);
			}

		}

	}

	static void wordpattern(String a, String word, HashMap<Character, String> hashmap, String ans) {

		if (word.length() == 0) {
			System.out.println(ans);
			System.out.println(hashmap);
			return;
		}
		if (!hashmap.containsKey(a.charAt(0))) {
			for (int i = 0; i < word.length(); i++) {
				char c = a.charAt(0);

				hashmap.put(c, word.substring(0, i + 1));
				wordpattern(a.substring(1), word.substring(i + 1), hashmap, ans + word.substring(0, i + 1));

			}

		}
	}

	static void dictionary(String w, Set<String> set, String ans) {
		if (w.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < w.length(); i++) {
			String temp = w.substring(0, i + 1);
			if (set.contains(temp)) {
				dictionary(w.substring(i + 1), set, ans + temp + " ");
			}
		}
	}

	static String reverse(String ab) {
		if (ab.length() == 0) {
			return " ";
		}
		String bc = reverse(ab.substring(1));
		return bc + ab.charAt(0);
	}

	static void printper(String a, int num[], int j, ArrayList<Integer> ans) {
		if (j == num.length) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			ans.add(num[j]);
			printper(a, num, j + 1, ans);
			ans.remove(ans.size() - 1);

		}
	}

	static void python(int arr[], int j, int index, int box[], String ans) {
		if (j > 2) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < box.length; i++) {
			if (box[i] == 0) {
				box[i] = j;
				python(arr, j + 1, index, box, ans + j + " ");
				box[i] = 0;
			}
		}
	}

	static int sum = 0;

	static void coin(int arr[], int i, ArrayList<Integer> ans) {

		if (i == arr.length) {
			if (sum == 12) {
				System.out.println(ans);

			}
			return;
		}
		sum = sum + arr[i];
		ans.add(arr[i]);
		coin(arr, i + 1, ans);
		sum = sum - arr[i];
		ans.remove(ans.size() - 1);
		coin(arr, i + 1, ans);
	}

	static void currency(int arr[], int i, int value, String ans) {
		if (i == arr.length) {

			return;
		}
		if (sum == 12) {
			System.out.println(ans);
		}
		for (int j = 0; j < arr.length; j++) {
			if (sum <= 12) {
				sum = sum + arr[j];
				currency(arr, j, value, ans + arr[j]);
				sum = sum - arr[j];
			}
		}
	}

	static void wordskselection(String ab, String ans) {

		if (ab.length() == 0) {
			if (ans.length() == 3) {
				System.out.println(ans);
			}
			return;
		}

		wordskselection(ab.substring(1), ans + ab.charAt(0));
		wordskselection(ab.substring(1), ans);

	}

	static int max = Integer.MAX_VALUE;

	static void dunedin(int m[][], int value, int x, int y) {
		if (x == m.length - 1 && y == m.length - 1) {
			max = Math.min(max, value);
		}
		if (x > m.length - 1 || y > m.length - 1 || x < 0 || y < 0) {
			return;
		}

		dunedin(m, value + m[x][y], x + 1, y);
		dunedin(m, value + m[x][y], x, y + 1);
	}

	public static String validIPAddress(String IP) {

		String split[] = IP.split(".");
		for (int i = 0; i < split.length; i++) {
			if (Character.isDigit(split[i].charAt(i))) {
				if (i == 0) {
					if (split[i].charAt(i) == '0') {
						return "Neither";
					}
				}
				if (Integer.parseInt(split[i]) > 255 || Integer.parseInt(split[i]) < 0) {
					return "Neither";
				}
			}
		}
		return "IP4";

	}

	static class Edge {
		int src;
		int destination;
		int value;
	}

	static void graph(ArrayList<Edge>[] ar, int src, int dest, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean b[] = new boolean[ar.length];
		q.add(src);
		while (!q.isEmpty()) {
			int temp = q.poll();

			for (Edge it : ar[temp]) {

			}

		}
	}

	static class Cordinate {
		int x;
		int y;

		public Cordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static void lostbutwon(int m[][]) {
		Queue<Cordinate> q = new LinkedList<Recursion.Cordinate>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 2) {
					q.add(new Cordinate(i, j));
				}
			}
		}
		q.add(new Cordinate(-1, -1));

		int days = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (size > 0) {
				Cordinate c = q.poll();
				if (c.x + 1 == 1) {
					q.add(new Cordinate(c.x + 1, c.y));
				}
				if (c.y + 1 == 1) {
					q.add(new Cordinate(c.x, c.y + 1));
				}
				size--;
			}
			days++;
		}
	}

	static void divisiblesubset(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			String top = a.substring(0, i + 1);
			if (isPalindrome(top)) {
				String stop = a.substring(i + 1);
				divisiblesubset(stop, ans + top + " ");
			}
		}
	}

	static void longestdivis(int arr[], int i, String ans) {
		if (i == arr.length - 1) {
			System.out.println(ans);
			return;
		}
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[i] % arr[j] == 0 || arr[j] % arr[i] == 0) {
				longestdivis(arr, j, ans + " { " + arr[i] + " " + arr[j] + " }");
			} else {
				longestdivis(arr, j, ans);
			}
		}
	}

	static ArrayList<String> ac = new ArrayList<>();
	static ArrayList<String> bc = new ArrayList<String>();

	static void partion(String a, ArrayList<Character> ans, ArrayList<Character> bns) {
		if (a.length() == 0) {
			System.out.println("ANS::  " + ans + "   BNS:: " + bns);
			return;

		}
		ans.add(a.charAt(0));
		partion(a.substring(1), ans, bns);
		ans.remove(ans.size() - 1);
		bns.add(a.charAt(0));
		partion(a.substring(1), ans, bns);
		bns.remove(bns.size() - 1);
	}

	static void partition(String a, ArrayList<ArrayList<Character>> ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ans.size(); i++) {
			ans.get(i).add(a.charAt(0));
			partition(a.substring(1), ans);
			ans.get(i).remove(ans.get(i).size() - 1);
		}
	}

	static void sortarray(int arr[]) {
		int br[] = new int[arr.length];
		int start = -1;
		int mid = 0;
		int end = arr.length;
		while (mid < end) {
			if (arr[mid] == 0) {
				int temp = arr[start + 1];
				arr[start + 1] = arr[mid];
				arr[mid] = temp;
				start++;
			}
			if (arr[mid] == 1) {
				mid++;
			}
			if (arr[mid] == 2) {
				int temp = arr[end - 1];
				arr[end - 1] = arr[mid];
				arr[mid] = temp;
				end--;

			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void wordladder(String begin, String end, String arr[], int i) {
		char c = begin.charAt(0);
		char d = end.charAt(0);
		for (int j = 0; j < arr.length; j++) {
			if (d != c) {
				if (arr[j].contains(Character.toString(d))) {
					wordladder(d + begin.substring(1), end.substring(1), arr, j);
				}
			}
		}
	}

	static class Graph {
		int src;
		int dest;
		int weight;

		public Graph(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public Graph() {
			// TODO Auto-generated constructor stub
		}
	}

	static ArrayList<Graph>[] list;

	static void construct(int value) {
		list = new ArrayList[value];
	}

	static void DFS(ArrayList<Edge>[] pt) {
		boolean b[] = new boolean[pt.length];
		for (int i = 0; i < pt.length; i++) {
			if (b[i] == false) {
				DFSutil(pt, i, b, 54);
			}
		}
	}

	private static boolean DFSutil(ArrayList<Edge>[] pt, int i, boolean[] b, int j) {

		if (i == j) {
			System.out.println("found");
			return true;
		}

		b[i] = true;
		for (Edge it : pt[i]) {
			if (b[it.destination] == false) {
				boolean dc = DFSutil(pt, it.destination, b, j);
				if (dc == true) {
					return true;
				}
			}
		}
		return false;

	}

	static void BFS(ArrayList<Edge>[] edge) {
		boolean b[] = new boolean[edge.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(edge[0].get(0).src);
		while (!q.isEmpty()) {
			int temp = q.poll();
			b[temp] = true;

			for (Edge it : edge[temp]) {
				if (b[it.destination] == false) {
					q.add(it.destination);
				}
			}
		}
	}

	static void biperatite(ArrayList<Edge>[] ar) {
		int flag[] = new int[3];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int temp = q.poll();
			flag[temp] = 1;
			for (Edge it : ar[temp]) {
				if (it.destination == 0) {
					it.destination = -flag[temp];
					q.add(it.destination);
				}
				if (it.destination == it.src) {
					System.out.println(false);
					return;
				}

			}

		}
	}

	static class Vertices {
		int src;
		int weight;
		String value;

		public Vertices(int src, int weight, String value) {
			super();
			this.src = src;
			this.weight = weight;
			this.value = value;
		}

	}

	static void dijsktra(ArrayList<Edge>[] ar) {
		boolean b[] = new boolean[ar.length];
		PriorityQueue<Vertices> pr = new PriorityQueue<Recursion.Vertices>((e, d) -> {
			return e.weight - d.weight;
		});
		pr.add(new Vertices(0, 0, ""));
		while (!pr.isEmpty()) {
			Vertices temp = pr.poll();
			b[temp.src] = true;
			for (Edge it : ar[temp.src]) {
				if (b[it.destination] == false) {
					pr.add(new Vertices(it.destination, temp.weight + it.value, it.destination + "@" + temp.src));
				}
			}
		}
	}

	static void DFSutility(ArrayList<Edge>[] edge, int i, boolean b[], boolean visited[]) {
		b[i] = true;
		visited[i] = true;
		for (Edge it : edge[i]) {
			if (b[it.destination] == false) {
				DFSutility(edge, it.destination, b, visited);
			}
		}
		visited[i] = false;

	}

	static class Vertices1 {
		int i;
		String name;

		public Vertices1(int i, String name) {
			super();
			this.i = i;
			this.name = name;
		}

	}

	static void matrixdic(ArrayList<Edge>[] ar, ArrayList<String> set) {
		boolean b[] = new boolean[ar.length];
		Queue<Vertices1> q = new LinkedList<Recursion.Vertices1>();
		q.add(new Vertices1(0, "ABC"));
		while (!q.isEmpty()) {
			Vertices1 v = q.poll();
			String val = v.name;
			b[v.i] = true;

			for (int i = 0; i < set.size(); i++) {
				int d = 0;
				if (b[i] == false) {
					for (int j = 0; j < set.get(i).length(); j++) {
						if (val.charAt(j) != set.get(j).charAt(j)) {
							d++;
						}
					}
					if (d == 1) {
						q.add(new Vertices1(i, set.get(i)));
					}

				}
			}

		}
	}

	static class Flights {
		int i;
		int weight;
		String src;

		public Flights(int i, int weight, String src) {
			super();
			this.i = i;
			this.weight = weight;
			this.src = src;
		}

	}

	static void cheapestflight(ArrayList<Edge>[] ar) {
		PriorityQueue<Flights> queue = new PriorityQueue<Recursion.Flights>((a, b) -> {
			return a.weight - b.weight;
		});
		boolean b[] = new boolean[ar.length];
		queue.add(new Flights(0, 0, ""));
		while (!queue.isEmpty()) {
			Flights f = queue.poll();
			b[f.i] = true;
			for (Edge e : ar[f.i]) {
				if (b[e.destination] == false) {
					queue.add(new Flights(e.destination, f.weight + e.value, ""));
				}
			}

		}

	}

	static int dc = 0;

	static void searchinsert(int arr[], int value, int start, int end) {

		if (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] > value) {
				dc = mid;
				searchinsert(arr, value, start, mid - 1);
			} else if (arr[mid] < value) {
				dc = mid;
				searchinsert(arr, value, mid + 1, end);
			} else {
				System.out.println(value + " found at " + dc);

			}

		}
	}

	static void keylock(ArrayList<Edge>[] edge) {
		boolean b[] = new boolean[edge.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int temp = q.poll();
			b[temp] = true;
			for (Edge at : edge[temp]) {
				if (b[at.destination] == false) {
					q.add(at.destination);
				}
			}
		}
	}

	static boolean subsequence(String a, String ab) {
		if (a.length() == 0) {
			return false;
		}
		if (ab.length() == 0) {

			return true;
		}
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			boolean cd = false;
			boolean bd = false;
			if (c == ab.charAt(0)) {
				cd = subsequence(a.substring(i + 1), ab.substring(1));
			} else {
				bd = subsequence(a.substring(i + 1), ab);
			}
			return cd || bd;
		}
		return false;
	}

	static void checksub(String word, String pattern, String ans) {
		if (word.length() == 0) {
			if (ans.equals(pattern)) {
				System.out.println(true);
			}
			return;
		}
		checksub(word.substring(1), pattern, ans + word.charAt(0));
		checksub(word.substring(1), pattern, ans);
	}

	static int add = 0;

	static void coinchangeproblem(int arr[], int i, int value, String ans, boolean b[]) {

		if (i == arr.length) {

			return;
		}

		if (value == 12) {

			System.out.println(ans);

		}
		if (b[i] == false) {
			b[i] = true;
			for (int j = i + 1; j < arr.length; j++) {

				if (value <= 12) {

					coinchangeproblem(arr, j, value + arr[i], ans + arr[j], b);

				}

			}
			b[i] = false;
		}
	}

	static class Shape {
		int height;
		int weight;

		public Shape(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Shape [height=" + height + ", weight=" + weight + "]";
		}

	}

	static void queueconstruction() {
		PriorityQueue<Shape> p = new PriorityQueue<Recursion.Shape>((a, b) -> {
			int vala = a.height;
			int valb = b.height;
			int wala = a.weight;
			int walb = b.weight;
			if (wala < walb && vala < valb) {
				return vala - valb;
			}
			if (wala > walb && vala < valb) {
				return vala - valb;
			}
			if (wala == walb) {
				return vala - valb;
			}
			if (vala == valb) {
				if (wala > walb) {
					return walb = wala;
				}
			}

			return 0;
		});
		p.add(new Shape(7, 0));
		p.add(new Shape(4, 4));
		p.add(new Shape(7, 1));
		p.add(new Shape(5, 0));
		p.add(new Shape(6, 1));
		p.add(new Shape(5, 2));

		System.out.println(p);

	}

	static void lcs(String a, String b, String ans) {
		if (a.length() == 0 || b.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				char c = a.charAt(i);
				char d = b.charAt(j);
				if (c == d) {
					lcs(a.substring(i + 1), b.substring(j + 1), ans + c + "");
				} else {
					lcs(a.substring(i + 1), b.substring(j + 1), ans);
				}
			}
		}
	}

	static int codesimplified(String a, String b, int i, int j) {
		if (i == 0) {
			return 0;
		}
		if (j == 0) {
			return 0;
		}
		if (a.charAt(i - 1) == b.charAt(j - 1)) {
			return 1 + codesimplified(a, b, i - 1, j - 1);
		}
		return Math.max(codesimplified(a, b, i - 1, j), codesimplified(a, b, i, j - 1));
	}

	static int substringvalue(String a, String b, int c, int d, int count, int arr[][]) {
		if (c == 0) {
			return count;
		}
		if (d == 0) {
			return count;
		}
		if (arr[c][d] == 0) {
			int cadd = 0;
			if (a.charAt(c - 1) == b.charAt(d - 1)) {
				cadd = substringvalue(a, b, c - 1, d - 1, count + 1, arr);
			}
			add = Math.max(cadd, add);

			arr[c][d] = Math.max(substringvalue(a, b, c - 1, d, 0, arr),
					Math.max(substringvalue(a, b, c, d - 1, 0, arr), add));
		}
		return arr[c][d];
	}

	static void kpart(String a, int i, String ans, boolean b[]) {
		if (i == a.length()) {
			System.out.println(ans);
			return;
		}
		if (b[i] == false) {
			b[i] = true;
			kpart(a, i + 1, ans + " (  " + a.charAt(i) + "  ) ", b);
			for (int j = i + 1; j < a.length(); j++) {
				if (b[j] == false) {
					b[j] = true;
					kpart(a, j, ans + " (  " + a.charAt(i) + "  " + a.charAt(j) + "  ) ", b);
					b[j] = false;
				}
			}
			b[i] = false;
		} else {
			kpart(a, i + 1, ans, b);
		}
	}

	static void twowrd(String arr, int i, String ans, String bns) {
		if (arr.length() == i) {
			System.out.println(ans + " " + bns);
			return;
		}
		twowrd(arr, i + 1, ans + arr.charAt(i), bns);
		twowrd(arr, i + 1, ans, bns + arr.charAt(i));
	}

	static void kwordval(String arr, int i, ArrayList<ArrayList<String>> ar, boolean b[]) {

		if (i == arr.length()) {
			System.out.println(ar);
			return;
		}

		for (int j = 0; j < ar.size(); j++) {
			ar.get(j).add(Character.toString(arr.charAt(i)));
			kwordval(arr, i + 1, ar, b);
			ar.get(j).remove(ar.get(j).size() - 1);
		}

	}

	static int count = 0;

	static void count(int arr[], int i, int val, int val2, HashSet<Integer> set) {
		if (i == arr.length) {
			if (val == val2) {
				count++;
			}
			return;
		}

		count(arr, i + 1, val + arr[i], val2, set);
		count(arr, i + 1, val, val2 + arr[i], set);
	}

	static void hashmap(int arr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!hashmap.containsKey(arr[i])) {
				hashmap.put(arr[i], 0);
			} else {
				int value = hashmap.get(arr[i]);

			}
		}
	}

	static void palindromeval(String a, int i, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int j = 0; j < a.length(); j++) {
			String val = a.substring(0, j + 1);
			if (isPalindrome(val)) {
				String right = a.substring(j + 1);
				palindromeval(right, i, ans + val + " ");
			}
		}
	}

	static void valueget(int arr[], int i, int val, int val2, String ANS, String BNS) {
		if (i == arr.length) {
			if (val == val2) {
				System.out.println(ANS + "->" + BNS);
			}
			return;
		}
		valueget(arr, i + 1, val, val2 + arr[i], ANS + arr[i] + " ", BNS);
		valueget(arr, i + 1, val + arr[i], val2, ANS, BNS + arr[i] + " ");
	}

	static void ksubset2(int arr[], int i, ArrayList<ArrayList<Integer>> ar) {
		if (i == arr.length) {
			int dc = 0;
			for (int j = 0; j < ar.size(); j++) {
				int sum = 0;
				if (ar.get(j).size() != 0)
					for (int k = 0; k < ar.get(j).size() - 1; j++) {
						sum = sum + ar.get(j).get(k);
					}
				if (dc == 0) {
					dc = sum;
				} else {
					if (dc != sum) {
						return;
					} else {
						System.out.println("found");
					}
				}
			}
			return;
		}

		for (int j = 0; j < ar.size(); j++) {
			ar.get(j).add(arr[i]);
			ksubset2(arr, i + 1, ar);
			ar.get(j).remove(ar.get(j).size() - 1);
		}

	}

	static void patternmatching(String val, int indx, String word, HashMap<Character, String> hash) {
		if (word.length() == 0) {
			if (val.length() == 0) {
				System.out.println(hash);
			}
			return;
		}
		if (hash.containsKey(val.charAt(0))) {
			String ab = hash.get(val.charAt(0));
			if (val.length() > ab.length()) {
				if (val.contains(ab)) {
					patternmatching(val.substring(ab.length()), indx, word, hash);
				}
			}

		} else
			for (int i = 0; i < word.length(); i++) {
				hash.put(val.charAt(0), word.substring(0, i + 1));
				patternmatching(val.substring(1), indx + 1, word.substring(i + 1), hash);
				hash.remove(val.charAt(0));
			}
	}

	static void wordbreaking(String a, Set<String> set, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			if (set.contains(a.substring(0, i + 1))) {
				wordbreaking(a.substring(i + 1), set, ans + a.substring(0, i + 1) + " ");
			}
		}
	}

	static void per(String a, int arr[], int j, String ans) {
		System.out.println(ans);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = a.charAt(0);
				per(a.substring(1), arr, j, ans + a.charAt(0) + " ");
				arr[i] = 0;
			}
		}
	}

	static void coinchangepr(int arr[], int i, String ans, int value) {
		if (i == arr.length) {

			return;
		}
		if (value > 12) {
			return;
		}
		if (value == 12) {
			System.out.println(ans);
		}
		for (int j = 0; j < arr.length; j++) {

			if (value <= 12) {
				coinchangepr(arr, j, ans + arr[j] + " ", value + arr[j]);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> at = new ArrayList<Integer>();
		at.add(0);
		ArrayList<Integer> bt = new ArrayList<Integer>();
		bt.add(0);
		ArrayList<Integer> ct = new ArrayList<Integer>();
		ct.add(0);
		ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
		ar.add(at);
		ar.add(bt);
		ar.add(ct);

		Set<String> set = new HashSet<String>();
		set.add("I");
		set.add("LOVE");
		set.add("TIETO");
		set.add("EVRY");
		set.add("TIETOEVRY");
		set.add("LOVETIETOEVRY");
		palindromeval("ABACABADE", 0, "");

	}
}
