package linked;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pepcoding {

	static void histogram(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int brr[] = new int[arr.length];
		brr[0] = -1;
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			{
				if (arr[st.peek()] > arr[i]) {

					while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
						st.pop();

					}
					st.push(i);
					brr[i] = -1;
				} else if (arr[st.peek()] < arr[i]) {
					brr[i] = st.peek();
					st.push(i);
				}
			}
		}
		Arrays.stream(brr).forEach(a -> System.out.print(a + " "));

	}

	static void slidingwindow(int arr[]) {
		ArrayDeque<Integer> pr = new ArrayDeque<Integer>();

		for (int i = 0; i < 3; i++) {
			while (!pr.isEmpty() && arr[i] > arr[pr.peekFirst()]) {
				pr.removeLast();
			}
			pr.add(i);
		}
		for (int i = 3; i < arr.length; i++) {
			System.out.print(arr[pr.peekFirst()] + " ");
			while (!pr.isEmpty() && i - pr.peekFirst() >= 3) {
				pr.removeFirst();
			}
			while (!pr.isEmpty() && arr[i] > arr[pr.peekFirst()]) {
				pr.removeLast();
			}
			pr.add(i);
		}

	}

	static void infixevalution(String a) {

		Stack<Integer> st = new Stack<Integer>();
		Stack<Character> at = new Stack<Character>();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '(') {
				at.push(a.charAt(i));
			} else if (Character.isDigit(a.charAt(i))) {
				st.push(Integer.parseInt(Character.toString(a.charAt(i))));
			} else if (a.charAt(i) == ')') {
				while (!at.isEmpty() || at.peek() != '(') {
					char c = at.peek();
					int v = st.peek();
					int u = st.peek();
					st.push(summmation(v, u, c));
				}
				at.pop();
			} else {
				while (!st.isEmpty() || st.peek() != '(' || precedence(at.peek()) >= precedence(a.charAt(i))) {
					char c = at.peek();
					int v = st.peek();
					int u = st.peek();
					st.push(summmation(v, u, c));
				}
			}
		}
	}

	private static Integer summmation(int v, int u, char c) {
		if (c == '+') {
			return v + u;
		}
		if (c == '-') {
			return v - u;
		}
		if (c == '*') {
			return v * u;
		}
		if (c == '/') {
			return v / u;
		}
		return null;
	}

	private static int precedence(char charAt) {
		if (charAt == '-') {
			return 1;
		}
		if (charAt == '+') {
			return 1;
		}
		if (charAt == '*') {
			return 2;
		}
		if (charAt == '/') {
			return 2;
		}
		return 0;
	}

	static void infixprefix(String a) {
		Stack<String> st = new Stack<String>();
		Stack<Character> ct = new Stack<Character>();

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '(') {
				ct.push('(');
			} else if (Character.isDigit(a.charAt(i))) {
				st.push(Character.toString(a.charAt(i)));
			} else if (a.charAt(i) == ')') {
				while (!ct.isEmpty() || ct.peek() != '(') {
					String ab = st.pop();
					String bc = st.pop();
					st.push(ct.pop() + ab + bc);
				}
				st.pop();
			} else {
				while (!ct.isEmpty() || ct.peek() != '(' || precedence(ct.peek()) >= precedence(a.charAt(i))) {
					st.push(ct.pop() + st.pop() + st.pop());
				}
			}
		}
	}

	static class Edge {
		int src;
		int dest;

		public Edge(int src, int dest) {
			super();
			this.src = src;
			this.dest = dest;
		}

	}

	static class Vertices {
		int id;
		boolean b;

		public Vertices(int id, boolean b) {
			super();
			this.id = id;
			this.b = b;
		}

	}

	static void display(ArrayList<Edge>[] ar) {
		boolean b[] = new boolean[ar.length];
		Queue<Vertices> q = new java.util.LinkedList<Vertices>();
		for (int i = 0; i < ar.length; i++) {
			q.add(new Pepcoding.Vertices(i, false));
			while (q.isEmpty()) {
				Vertices cd = q.poll();
				cd.b = true;
				b[cd.id] = true;
				for (Edge it : ar[cd.id]) {
					if (b[it.dest] == false) {
						q.add(new Vertices(it.dest, false));
					}
				}

			}
		}

	}

	static void celebrityproblem(int arr[][]) {
		Stack<Integer> st = new Stack<Integer>();
		st.add(0);
		while (!st.isEmpty()) {
			int val = st.pop();
			int dc = 0;
			for (int i = 0; i < arr.length; i++) {
				if (val != i && arr[val][i] == 1) {
					st.push(i);
					break;
				}
				dc++;
				if (dc == i) {
					System.out.println(arr[val][i]);
				}
			}
		}
	}

	static void postfix(String a) {
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isDigit(a.charAt(i))) {
				st.push(Character.toString(a.charAt(i)));
			} else {
				String pf = process(st.pop(), st.pop(), a.charAt(i));
				st.push(pf);
			}
		}

	}

	private static String process(String pop, String pop2, char charAt) {

		if (charAt == '-') {
			return "pop-pop2";
		}
		if (charAt == '+') {
			return "pop+pop2";
		}
		if (charAt == '*') {
			return "pop*pop2";
		}
		if (charAt == '/') {
			return "pop/pop2";
		}
		return null;

	}

	static class Cordinates {
		int x;
		int y;

		public Cordinates(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void increasing(String a) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) == 'i') {
				st.push(i);
			}
		}

		int brr[] = new int[a.length()];
		int i = 0;
		int prev = 0;
		while (!st.isEmpty()) {
			int d = st.pop();
			int e = d;
			while (d != prev) {
				brr[i++] = d;
				d--;
			}
			prev = e;

		}
		Arrays.stream(brr).forEach(b -> System.out.print(b + " "));

	}

	static void rightelement(int arr[]) {

		Stack<Integer> st = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				System.out.print(-1 + " ");
				st.push(arr[i]);
			} else {
				while (!st.isEmpty() && st.peek() < arr[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					System.out.print(-1 + " ");
					st.push(arr[i]);
				} else {

					System.out.print(st.peek() + " ");
					st.push(arr[i]);
				}
			}
		}
	}

	static void nextgreaterelementright(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				st.push(i);
			} else {
				while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
					arr[st.pop()] = arr[i];
				}
				st.push(i);
			}
		}
		while (!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void stock(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int brr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				st.push(arr[i]);
				brr[i] = i + 1;
			} else {
				while (!st.isEmpty() && arr[i] > st.peek()) {
					st.pop();
				}
				if (st.isEmpty()) {
					brr[i] = i + 1;
					st.push(arr[i]);
				} else {
					brr[i] = st.peek();
					st.push(arr[i]);
				}
			}
		}
		Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
	}

	static void histo(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int brr[] = new int[arr.length];
		int crr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				brr[i] = -1;
				st.push(i);
			} else {
				while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
					st.pop();
				}
				if (st.isEmpty()) {
					brr[i] = -1;
					st.push(i);
				} else {
					brr[i] = st.peek();
					st.push(i);
				}

			}
		}
		Stack<Integer> at = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				crr[i] = arr.length;
				st.push(i);
			} else {
				while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
					st.pop();
				}
				if (st.isEmpty()) {
					crr[i] = arr.length;
					st.push(i);
				} else {
					crr[i] = st.peek();
					st.push(i);
				}

			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int str = 0;
			int ds = crr[i] - brr[i] - 1;
			str = ds * arr[i];
			max = Math.max(arr[i], str);
		}

		System.out.println(max);

	}

	static void maximumslidingw(int arr[]) {
		ArrayDeque<Integer> ar = new ArrayDeque<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (i < 3) {
				while (!ar.isEmpty() && arr[ar.peekFirst()] < arr[i]) {
					ar.removeLast();
				}
				ar.addLast(i);
			} else {
				System.out.print(arr[ar.peek()] + " ");
				if (i - ar.getFirst() == 2) {
					ar.removeFirst();
				}
				while (!ar.isEmpty() && arr[ar.peekFirst()] < arr[i]) {
					ar.removeLast();
				}
				while (!ar.isEmpty() && arr[ar.peekLast()] < arr[i]) {
					ar.removeLast();
				}
				ar.addLast(i);

			}
		}
	}

	static void evalute(String a) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Character> ct = new Stack<Character>();

		for (int i = 0; i < a.length(); i++) {
			if (Character.isDigit(a.charAt(i))) {
				st.push(Integer.parseInt(Character.toString(a.charAt(i))));
			} else if (a.charAt(i) == '(') {
				ct.push(a.charAt(i));
			} else if (a.charAt(i) == ')') {
				while (!ct.isEmpty() && ct.peek() != '(' && precdence(ct.peek()) <= precdence(a.charAt(i))) {
					int dc = st.pop();
					int bc = st.pop();
					st.push(processthevalue(dc, bc, ct.peek()));
				}
				ct.pop();
			} else {
				while (!ct.isEmpty() && precdence(ct.peek()) <= precdence(a.charAt(i))) {
					int dc = st.pop();
					int bc = st.pop();
					st.push(processthevalue(dc, bc, ct.peek()));
				}
				ct.push(a.charAt(i));
			}
		}
	}

	private static Integer processthevalue(int dc, int bc, Character peek) {
		if (peek == '+') {
			return dc + bc;
		}
		if (peek == '-') {
			return dc - bc;
		}
		if (peek == '/') {
			return dc / bc;
		}
		if (peek == '*') {
			return dc * bc;
		}

		return null;
	}

	private static int precdence(char charAt) {
		if (charAt == '+') {
			return 1;
		}
		if (charAt == '-') {
			return 1;
		}
		if (charAt == '/') {
			return 2;
		}
		if (charAt == '*') {
			return 2;
		}
		return 0;
	}

	static void infixtopostfix(String arr) {
		Stack<Character> st = new Stack<Character>();
		Stack<String> at = new Stack<String>();
		for (int i = 0; i < arr.length(); i++) {
			if (Character.isDigit(arr.charAt(i))) {
				at.push(Character.toString(arr.charAt(i)));
			} else if (arr.charAt(i) == '(') {
				st.push(arr.charAt(i));
			} else if (arr.charAt(i) == ')') {
				while (arr.charAt(i) != '(') {
					at.push(st.pop() + at.pop() + at.pop());
				}
				at.pop();
			} else {
				while (!st.isEmpty() && precdence(st.peek()) <= precdence(arr.charAt(i))) {
					at.push(st.pop() + at.pop() + at.pop());
				}
				st.push(arr.charAt(i));
			}
		}
	}

	static void celebirty(int m[][]) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < m.length; i++) {
			st.push(i);
		}

		while (!st.isEmpty() && st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			if (m[a][b] == 1) {
				st.push(b);
			} else {
				st.push(a);
			}
		}

	}

	public static final int FIVE_SECONDS = 5000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;

	static void permuattion(String abc, String ans) {
		if (abc.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < abc.length(); i++) {
			char t = abc.charAt(i);
			String post = abc.substring(0, i);
			String create = abc.substring(i + 1);
			permuattion(post + create, ans + t);
		}
	}

	static void towerhanoi(int n, int n1, int n2, int n3) {
		if (n == 0) {
			return;
		}
		towerhanoi(n - 1, n1, n3, n2);
		System.out.println(n + "{ " + n1 + "-> " + n2 + " }");
		towerhanoi(n - 1, n3, n2, n1);
	}

	static void getKeypad(String abc, String ans, String store[]) {
		if (abc.length() == 0) {
			System.out.println(ans);
			return;
		}
		char a = abc.charAt(0);
		String word = store[Integer.parseInt(Character.toString(a))];
		for (int i = 0; i < word.length(); i++) {
			char w = word.charAt(i);
			getKeypad(abc.substring(1), ans + w, store);

		}

	}

	static void getstairs(int val, String ans) {
		if (val < 0) {
			System.out.println(ans);
			return;
		}
		getstairs(val - 1, ans + 1 + " ");
		getstairs(val - 2, ans + 2 + " ");
		getstairs(val - 3, ans + 2 + " ");
	}

	static void getmaxe(int m[][], int x, int y, String ans) {
		if (x > m.length || x < 0 || y > m.length || y < 0) {
			return;
		}
		if (m.length == x && m.length == y) {
			System.out.println(ans);
			return;
		}
		getmaxe(m, x + 1, y, ans + m[x][y]);
		getmaxe(m, x, y + 1, ans + m[x][y]);
	}

	static void getmazest(int m[][], int x, int y, String ans) {

		for (int i = 0; i < m.length - x; i++) {
			getmazest(m, x + i, y, ans + m[x][y] + "");
		}
		for (int i = 0; i < m.length - y; i++) {
			getmazest(m, x, y + i, ans + m[x][y] + "");
		}
		for (int i = 0; i < m.length - y; i++) {
			getmazest(m, x + i, y + i, ans + m[x][y] + "");
		}

	}

	static void printpermuation(String abc, String ans, ArrayList<String> ar) {
		if (abc.length() == 0) {
			System.out.println(ar);
			return;
		}
		for (int i = 0; i < abc.length(); i++) {
			char a = abc.charAt(i);
			ar.add(Character.toString(a));
			printpermuation(abc.substring(0, i) + abc.substring(i + 1), ans + a + " ", ar);
			ar.remove(ar.size() - 1);
		}
	}

	static void printencoding(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		int val = Integer.parseInt(Character.toString(a.charAt(0)));
		printencoding(a.substring(1), ans + (char) (val + 'a' - 1) + " ");
		if (a.length() >= 2) {
			int dal = Integer.parseInt(Character.toString(a.charAt(1)));
			if (Integer.parseInt(Character.toString(a.charAt(0))) * 10 + dal < 26) {
				printencoding(a.substring(2),
						ans + (char) ((Integer.parseInt(Character.toString(a.charAt(0))) * 10 + dal) + 'a' - 1) + " ");
			}

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

	static void getsum(int arr[], int i, String ans, int value) {
		if (i == arr.length) {
			if (value == 9)
				System.out.println(ans);
			return;
		}
		getsum(arr, i + 1, ans + arr[i] + " ", value + arr[i]);
		getsum(arr, i + 1, ans, value);
	}

	static void nqueen(int m[][]) {
		if (m.length == 0) {
			return;
		}

		for (int i = 0; i < m.length; i++) {
			DFSutility(m, i);
		}
	}

	private static void DFSutility(int[][] m, int i) {
		if (i > m.length) {
			return;
		}

		for (int j = 0; j < m.length; j++) {
			if (safevisit(m, i, j)) {
				m[i][j] = 1;
				DFSutility(m, i + 1);
				m[i][j] = 0;
			}
		}

	}

	private static boolean safevisit(int[][] m, int i, int j) {

		for (int x = 0; x < i; x++) {
			if (m[x][j] == 1) {
				return false;
			}
		}
		for (int x = 0; x < j; x++) {
			if (m[j][x] == 1) {
				return false;
			}
		}

		for (int x = i, y = j; x >= 0 && y >= 0; x--, y--) {
			if (m[x][y] == 1) {
				return false;
			}
		}
		return false;
	}

	static void sudoku(int m[][], int x, int y) {
		int dx = 0;
		int dy = 0;
		if (y == m.length) {
			dx = x + 1;
			dy = 0;
		} else {
			dx = x;
			dy = y + 1;
		}

		if (m[x][y] == -1) {
			sudoku(m, dx, dy);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (safevisit(m, x, y, i)) {
					m[x][y] = i;
					sudoku(m, dx, dy);
					m[x][y] = 0;
				}
			}
		}
	}

	private static boolean safevisit(int[][] m, int x, int y, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public static long taskOfPairing(List<Long> freq) {
		if (freq.size() <= 1 && freq.size() <= (10 ^ 5)) {
			return 0L;
		}

		ArrayList<Long> count = new ArrayList<Long>();
		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i) >= 1 && freq.get(i) <= Math.pow(10, 5)) {
				if (freq.get(i) % 2 == 0) {
					count.add(freq.get(i) / 2);
				} else {
					count.add((freq.get(i) - 1) / 2);
					if (i < freq.size() - 1 && freq.get(i + 1) % 2 != 0) {
						count.add(1L);
						Long dg = freq.get(i + 1);
						freq.add(i + 1, dg - 1);
						freq.remove(i + 2);
					}
				}
			}
		}
		System.out.println(count);
		Long sum = 0L;
		for (int i = 0; i < count.size(); i++) {
			sum = sum + count.get(i);
		}
		System.out.println(sum);
		return sum;

	}

	public static long countPairs(List<Integer> arr) {
		Long count = 0L;

		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i; j < arr.size(); j++) {
				int x = arr.get(i) & arr.get(j);
				boolean f = x != 0 && ((x & (x - 1)) == 0);
				if (f == true) {
					count++;
				}
			}
		}
		System.out.println(count);
		return count;

	}

	static void printabb(int i, String ans) {
		if (i == 0) {
			System.out.println(ans);
			return;
		}
		printabb(i - 1, ans + 0);
		printabb(i - 1, ans + 1);

	}

	static void encoding(String word, String and, int pt) {

		if (word.length() == 0) {
			System.out.println(and + " " + pt);
			return;
		}

		encoding(word.substring(1), and + word.charAt(0), pt + 0);
		encoding(word.substring(1), and, pt + 1);

	}

	static void printabbrevation(String val, String ans, Integer bns) {
		if (val.length() == 0) {
			System.out.println(ans);
			System.out.println();
			return;
		}

		if (bns > 0) {
			printabbrevation(val.substring(1), ans + bns + val.charAt(0), bns);
		}
		printabbrevation(val.substring(1), ans + val.charAt(0) + " ", bns);
		printabbrevation(val.substring(1), ans, bns + 1);

	}

	static void value(int arr, String pep, String ans) {

		if (arr == 0) {
			System.out.println(ans);
			return;
		}
		value(arr - 1, pep.substring(1), ans + pep.charAt(0));
		if (ans.length() != 0 && Character.isDigit(ans.charAt(ans.length() - 1)))
			value(arr - 1, pep.substring(1),
					"" + (Integer.parseInt(Character.toString(ans.charAt(ans.length() - 1))) + 1));
		else
			value(arr - 1, pep.substring(1), ans + 1);

	}

	static int climbingstairs(int stairs, int arr[], int count) {
		if (stairs == 1 || stairs == 2 || stairs == 3) {
			return 1;
		}
		if (arr[stairs] != 0) {
			return arr[stairs];
		}
		System.out.println(stairs);
		int a = climbingstairs(stairs - 1, arr, count + 1);
		int b = climbingstairs(stairs - 2, arr, count + 2);
		int c = climbingstairs(stairs - 3, arr, count + 3);
		arr[stairs] = a + b + c;
		return a + b + c;

	}

	static void kp(int n, String word, String value) {
		if (n == 0) {
			System.out.println(value);
			return;
		}
		kp(n - 1, word.substring(1), value + word.charAt(0));
		if (Character.isDigit(value.charAt(value.length() - 1))) {
			int value1 = value.charAt(value.length() - 1);
			value = value.substring(value.length() - 2) + (value1 + 1);
			kp(n - 1, word.substring(1), value);
		} else {
			kp(n - 1, word.substring(1), value + 1);
		}
	}

	static void lexo(int value) {
		for (int i = 1; i <= 9; i++) {
			DFSut(i, value);
		}
	}

	private static void DFSut(int i, int value) {

		if (i > value) {
			return;
		}
		System.out.println(i);
		for (int j = 0; j <= 9; j++) {
			DFSut(i * 10 + j, value);
		}

	}

	static void goldmine(int m[][]) {
		boolean b[][] = new boolean[m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (b[i][j] == false) {
					ArrayList<Integer> bag = new ArrayList<Integer>();
					traverse(b, i, j, m, bag);
				}
			}
		}
	}

	private static void traverse(boolean[][] b, int i, int j, int[][] m, ArrayList<Integer> bag) {
		if (i < 0 || j < 0 || i > m.length || j > m.length) {
			return;
		}
		b[i][j] = false;
		bag.add(m[i][j]);
		traverse(b, i + 1, j, m, bag);
		traverse(b, i, j + 1, m, bag);

	}

	static void crosswordpuzzle(String word[], int idx, char c[][]) {

		String w = word[idx];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[i][j] == w.charAt(0) || c[i][j] == '-') {
					if (ishorizonatllyplaced(w, c, i, j)) {
						placehorizontally(w, c, i, j);
						crosswordpuzzle(word, idx + 1, c);

					}
				}
			}
		}

	}

	private static void placehorizontally(String w, char[][] c, int i, int j) {

		int l = 0;
		for (int k = i; k <= i + w.length(); k++) {
			if (c[k][j] == '+') {
				c[k][j] = w.charAt(l++);
			} else {
				l++;
			}
		}

	}

	private static boolean ishorizonatllyplaced(String w, char[][] c, int i, int j) {
		int length = w.length();
		if (i == 0) {
			if (i + length != '+') {
				return false;
			}
		} else {
			if (i - 1 != '+') {
				return false;
			} else {
				if (i + length != '+') {
					return false;
				}
			}
		}
		for (int k = i; k < i + length; k++) {
			if (c[k][j] != '-' || c[k][j] != w.charAt(k)) {
				return false;
			}
		}

		return true;
	}

	static void friendspairing(int arr[], int i, String ans, boolean b[]) {

		if (i == arr.length) {
			System.out.println(ans);
			return;
		}

		if (b[i] == false) {
			b[i] = true;
			friendspairing(arr, i + 1, ans + " " + arr[i] + " ", b);
			for (int j = i + 1; j < arr.length; j++) {
				if (b[j] == false) {
					b[j] = true;
					friendspairing(arr, j, ans + "(" + arr[i] + "-" + arr[j] + ")", b);
					b[j] = false;
				}

			}
			b[i] = false;
		} else {
			friendspairing(arr, i + 1, ans, b);
		}
	}

	static void partitionksubset(int arr[], int i, ArrayList<Integer> ar, ArrayList<Integer> br) {
		if (i == arr.length) {
			System.out.println(ar);
			System.out.println(br);
			return;
		}
		ar.add(arr[i]);
		partitionksubset(arr, i + 1, ar, br);
		ar.remove(ar.size() - 1);
		br.add(arr[i]);
		partitionksubset(arr, i + 1, ar, br);
		br.remove(br.size() - 1);
	}

	static void part(int arr[], int i, ArrayList<ArrayList<Integer>> ar) {
		for (int j = 0; j < ar.size(); j++) {
			ArrayList<Integer> br = ar.get(i);
			br.add(arr[i]);
			part(arr, i + 1, ar);
			ar.get(i).get(ar.get(i).size() - 1);
//			strgt.clear();
//			j = 0;
//			int gtl[] = new int[height.length];
//			strgt.push(j);
//			j=j+1;
//			while (!strgt.isEmpty() && j != height.length) {
//				if (height[j] < height[strgt.peek()]) {
//					gtl[j] = strgt.peek();
//					strgt.push(j);
//				} else {
//					while (!strgt.empty() && height[j] > height[strgt.peek()]) {
//						strgt.pop();
//					}
//					if (!strgt.empty()) {
//						gtl[j] = strgt.peek();
//						strgt.push(j);
//					} else
//						strgt.push(j);
//				}
//				j++;
//			}
//			
		}
	}

	public static void trap(int[] height) {

		Stack<Integer> strgt = new Stack<Integer>();
		int gtr[] = new int[height.length];

		int j = height.length - 1;
		strgt.push(j);
		j = j - 1;
		while (!strgt.isEmpty() && j != 0) {
			if (height[j] < height[strgt.peek()]) {
				gtr[j] = strgt.peek();
				strgt.push(j);
			} else {
				while (!strgt.empty() && height[j] > height[strgt.peek()]) {
					strgt.pop();
				}
				if (!strgt.empty()) {
					gtr[j] = strgt.peek();
					strgt.push(j);
				} else
					strgt.push(j);
			}
			j--;
		}
		while (!strgt.empty() && height[j] > height[strgt.peek()]) {
			strgt.pop();
		}
		if (!strgt.empty()) {
			gtr[j] = strgt.peek();
			strgt.push(j);
		} else
			strgt.push(j);

		Arrays.stream(gtr).forEach(a -> System.out.print(a + " "));
		System.out.println();
		int min = Integer.MAX_VALUE;
		int i = 0;
		int sum = Math.min(gtr[0], height[0]);
		i++;
		sum = sum * sum;
		while (j < height.length) {
			while (i < gtr[j]) {
				sum = sum - height[i];
				i++;
			}

			i = j;
			i = 0;
		}
		System.out.println(sum);
	}

	static void coins(int arr[], int i, int sum, String ans) {
		if (sum == 12) {
			System.out.println(ans);
			return;
		}

		if (arr.length == i || sum > 12) {

			return;
		}

		for (int j = 0; j < arr.length; j++) {
			sum = sum + arr[j];
			coins(arr, j, sum, ans + arr[j]);
			sum = sum - arr[j];
		}
	}

	static void arrayit(int arr[], int d, String ans) {
		if (d >= 5) {
			System.out.println(ans);
			return;
		}

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 0) {
				arr[j] = d;
				arrayit(arr, d + 1, ans + j + " ");
				arr[j] = 0;
			}
		}
	}

	static void arraybit(int arr[], int j, int d) {
		if (d > 3) {
			for (int p = 0; p < arr.length; p++) {
				System.out.print(arr[p] + " ");

			}
			System.out.println();
			return;
		}
		for (int k = j; k < arr.length; k++) {
			if (arr[k] == 0) {
				arr[k] = d;
				arraybit(arr, k, d + 1);
				arr[k] = 0;
			}
		}
	}

	static void kar(int arr[], int i, int value, String sum) {
		if (value == 12) {
			System.out.println(sum);
			return;
		}
		if (value > 12 || arr.length == i) {
			return;
		}
		for (int j = 0; j < arr.length; j++) {

			value = value + arr[j];
			kar(arr, j, value, sum + arr[j] + " ");
			value = value - arr[j];
		}
	}

	static void distinct(Character a[], int i, int d, String dc) {
		if (d >= i) {
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
			return;
		}
		for (int j = 0; j < a.length; j++) {
			if (a[j] == null) {
				a[j] = dc.charAt(d);
				distinct(a, i, d + 1, dc);
				a[j] = null;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		distinct(new Character[4], 5, 0, "ABCDE");

	}
}
