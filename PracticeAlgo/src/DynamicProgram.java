import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DynamicProgram {

	static void factorial(int n, String ans, int number) {
		if (n == 0) {
			System.out.println(ans + " " + number);
			return;

		}

		factorial(n - 1, ans + n + " ", number + n);
		factorial(n - 2, ans + n + " ", number + n);
	}

	static int factorialvalue(int n, int arr[]) {
		if (n < 2) {
			return n;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		int a = factorialvalue(n - 1, arr);
		int b = factorialvalue(n - 2, arr);
		arr[n] = a + b;
		return a + b;
	}

	static int stairs(int arr[], int n) {
		if (n < 2) {
			return 1;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		int c = stairs(arr, n - 1);
		int d = stairs(arr, n - 2);
		int e = stairs(arr, n - 3);
		arr[n] = Math.min(e, Math.min(d, c)) + 1;
		return Math.min(e, Math.min(d, c)) + 1;
	}

	static int longestsubsequence(String a, int i, String b, int j, Integer arr[][], int count) {

		if (a.length() == 0 || b.length() == 0) {
			return 0;
		}
		if (arr[i][j] == null) {

			if (a.charAt(0) == b.charAt(0)) {
				count = 1 + longestsubsequence(a.substring(1), i + 1, b.substring(1), j + 1, arr, count);
			}
			arr[i][j] = Math.max(longestsubsequence(a.substring(1), i + 1, b, j, arr, 0),
					Math.max(longestsubsequence(a, i, b.substring(1), j + 1, arr, 0), 0));
		}
		return arr[i][j];
	}

	static int min = 0;

	static int getvalue(int m[][], int i, int j, int value, boolean b[][]) {
		if (i < 0 || i > b.length - 1 || j < 0 || j > b.length - 1 || b[i][j] == true) {
			return 0;
		}
		if (m.length - 1 == i && m.length - 1 == j) {

			min = Math.min(value, min);
			System.out.println("value:: " + min);
		}
		b[i][j] = true;
		int d = m[i][j] + getvalue(m, i + 1, j, value, b);
		int e = m[i][j] + getvalue(m, i, j + 1, value, b);
		b[i][j] = false;
		return Math.min(d, e);
	}

	static int editdistance(String a, String b, int i, int j) {
		if (i == 0) {
			return b.length() - j;
		}
		if (j == 0) {
			return a.length() - i;
		}
		if (a.charAt(i) != a.charAt(j)) {
			return 1 + editdistance(a, b, i - 1, j - 1);
		}
		return Math.min(editdistance(a, b, i - 1, j), editdistance(a, b, i, j - 1));

	}

	static int palindromelongest(String a, int start, int end, Integer arr[][]) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}

		if (arr[start][end] == null) {
			if (a.charAt(start) == a.charAt(end)) {
				arr[start][end] = 2 + palindromelongest(a, start + 1, end - 1, arr);
			} else
				arr[start][end] = Math.max(palindromelongest(a, start + 1, end, arr),
						palindromelongest(a, start, end - 1, arr));
		}
		return arr[start][end];
	}

	static void display(int weight[], int i, int price[], int value, int count, int weightval) {
		if (weight[i] == weightval) {
			System.out.println(count);
			return;
		}
		if (weight[i] <= weightval) {
			display(weight, i + 1, price, value, count + price[i], weightval + weight[i]);
			display(weight, i + 1, price, value, count, weightval);
		}
	}

	static void targetsum(int arr[], int i, int sum, int value, String ans) {
		if (arr.length <= i || sum < value) {
			return;
		}
		if (value == sum) {
			System.out.println(ans);
			System.out.println();
		}
		for (int j = i; j < arr.length; j++) {
			targetsum(arr, j + 1, sum, value + arr[j], ans + arr[j] + " ");
			targetsum(arr, j + 1, sum, value, ans);
		}
	}

	static void targetsummem(int arr[], int price) {

		boolean dp[][] = new boolean[arr.length + 1][arr.length + 1];

		for (int i = 1; i < price; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
				} else {
					if (i > arr[j]) {
						dp[i][j] = dp[i - 1][i - arr[j]];
					}
				}
			}
		}

	}

	static void findtarget(int m[][], int arr[]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i] < j) {
					m[i][j] = m[i - 1][j];
				} else {
					m[i][j] = m[i - 1][j - arr[i]];
				}
			}
		}
	}

	static void getvalue(int arr[]) {
		int brr[] = new int[arr.length];
		int max = 0;
		if (arr[0] > arr[1]) {
			brr[1] = arr[0];

		} else {
			brr[1] = arr[1];
		}
		for (int i = 2; i < arr.length; i++) {
			max = Math.max(brr[i - 1], brr[i - 2] + arr[i]);
		}
		System.out.println(max);
	}

	static void knap(int arr[]) {
		int dp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 7; i++) {
				int max = 0;
				if (arr[i] >= j) {

				}
			}
		}
	}

	static void painthouse(int m[][]) {
		int flag = -1;
		int sum = 0;
		for (int i = 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			int e = 0;
			for (int j = 0; j < m.length; j++) {
				if (flag != j) {
					min = Math.min(min, m[i][j]);
					e = j;
				}
			}
			flag = e;
			sum = sum + min;
		}
		System.out.println(sum);
	}

	static void checkvalue(String a) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '(' || a.charAt(i) == '{' || a.charAt(i) == '[') {
				st.push(a.charAt(i));
			}
			if (st.size() > 0 && a.charAt(i) == ')' || a.charAt(i) == '}' || a.charAt(i) == ']') {

				char temp = st.peek();
				if (st.peek() == '(' && a.charAt(i) == ')') {
					st.pop();
				} else if (st.peek() == '{' && a.charAt(i) == '}') {
					st.pop();
				} else if (st.peek() == '[' && a.charAt(i) == ']') {
					st.pop();
				} else {
					System.out.println("unbalance");
					return;
				}
			} else if (st.isEmpty() && a.charAt(i) == ')' || a.charAt(i) == '}' || a.charAt(i) == ']') {
				System.out.println("unbalance");
				return;
			}
		}
		if (st.isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println(false);
		}

	}

	static void check(String a) {
		Stack<Character> st = new Stack<Character>();
		boolean flag = false;
		int g = 0;
		for (int i = 0; i < a.length() - 1; i++) {

			if (a.charAt(i) == '(' && a.charAt(i + 1) == '(') {
				flag = true;
				st.push(a.charAt(i));
				st.push(a.charAt(i + 1));
				g = i + 1;
			} else if (g != i) {
				st.push(a.charAt(i));
			}
			if (flag == true && a.charAt(i) == ')' && a.charAt(i + 1) == ')') {
				System.out.println("found" + false);
				return;

			} else if (a.charAt(i) == ')') {
				st.pop();
			}

		}
		System.out.println(true);
	}

	static void nextgreater(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				st.push(arr[i]);
			} else if (arr[i] < st.peek()) {
				System.out.print(st.peek() + " ");
				st.push(arr[i]);
			} else {
				while (!st.isEmpty() && arr[i] > st.peek()) {
					st.pop();
				}
				if (st.isEmpty()) {
					System.out.print(-1 + " ");
				} else
					System.out.print(st.peek() + " ");
				st.push(arr[i]);
			}
		}

	}

	static void stockspan(int arr[]) {

		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				st.push(i);
				System.out.print(i + " ");
			} else if (arr[i] > arr[st.peek()]) {
				while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
					st.pop();
				}

				if (!st.isEmpty())
					System.out.print(i - st.peek() + " ");
				else {
					System.out.print(i + " ");
				}
				st.push(i);
			} else if (arr[i] < arr[st.peek()]) {
				System.out.print(i - st.peek() + " ");
			}
		}

	}

	static void histogram(int arr[]) {

		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.add(-1);
		int i = 0;
		while (!st.isEmpty() && i != arr.length) {
			if (st.peek() == -1) {
				st.pop();
				st.add(i);
			} else if (arr[i] > arr[st.peek()]) {
				st.push(i);
			} else if (arr[i] < arr[st.peek()]) {
				while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
					int d = st.peek();
					int j = d;
					int val = arr[d];
					while (!st.isEmpty() && arr[st.peek()] == val) {
						j--;
						val = st.pop();
					}
					max = Math.max(max, (i - d) * arr[val]);

				}
				st.push(i);
			}
			i++;
		}
		int d = st.peek();
		int j = d;
		int val = arr[d];
		while (!st.isEmpty() && arr[st.peek()] == val) {
			j--;
			val = st.pop();
		}
		max = Math.max(max, (i - d) * arr[val]);
		System.out.println(max);

	}

	static void getsmallest(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int f[] = new int[arr.length];
		int g[] = new int[arr.length];
		st.push(-1);
		int fv = arr[0];
		boolean flag = false;
		for (int i = 1; i < arr.length; i++) {
			if (i == 1 && flag == false) {
				st.push(i);
				flag = true;
			}

		}
	}

	static void stockhistogram(int arr[]) {
		int a[] = new int[arr.length];
		int b[] = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				st.push(i);
				a[i] = -1;
			} else if (arr[st.peek()] > arr[i]) {
				while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					a[i] = st.peek();
					st.push(i);
				} else {
					a[i] = -1;
					st.push(i);
				}

			} else {
				if (!st.isEmpty()) {
					a[i] = st.peek();
					st.push(i);
				} else {
					a[i] = -1;
					st.push(i);
				}
			}

		}
		st = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				st.push(i);
				b[i] = arr.length;
			} else if (arr[st.peek()] > arr[i]) {
				while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					b[i] = st.peek();
					st.push(i);
				} else {
					b[i] = arr.length;
					st.push(i);
				}

			} else {
				if (!st.isEmpty()) {
					b[i] = st.peek();
					st.push(i);
				} else {
					b[i] = arr.length;
					st.push(i);
				}
			}

		}

		Arrays.stream(a).forEach(System.out::print);
		System.out.println();
		Arrays.stream(b).forEach(System.out::print);
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = b[i] - a[i] + 1;
			max = Math.max(val * arr[i], max);
		}
		System.out.println();
		System.out.println(max);
	}

	static void kwindow(int arr[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 4; i++) {
			q.add(arr[i]);

		}
		int sum = add(q);
		int max = 0;
		for (int i = 4; i < arr.length; i++) {

			sum = sum - (i - 4);
			q.add(arr[i]);
			sum = sum + arr[i];
			max = Math.max(sum, max);

		}
		System.out.println(max);
	}

	private static int add(Queue<Integer> q) {
		Queue<Integer> p = q;
		int add = 0;
		for (int i = 0; i < 4; i++) {
			add = add + p.poll();
		}

		return add;
	}

	public static void main(String[] args) {
		evalution("2+6/2");
	}

	static void evalution(String a) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Character> ct = new Stack<Character>();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isDigit(a.charAt(i))) {
				st.push(a.charAt(i) - '0');
			} else {
				if (a.charAt(i) == '(') {
					ct.push(a.charAt(i));
				} else if (a.charAt(i) == '+') {
					while (!ct.isEmpty() && ct.peek() != '(') {
						char c = ct.pop();
						int ab = st.pop();
						int cb = st.pop();
						if (ct.peek() == '-') {
							st.push(ab - cb);
						} else if (ct.peek() == '+') {
							st.push(ab + cb);
						} else if (ct.peek() == '*') {
							st.push(ab * cb);
						} else if (ct.peek() == '/') {
							st.push(ab / cb);
						}
					}
					ct.push(a.charAt(i));
				} else if (a.charAt(i) == '-') {
					while (!ct.isEmpty() && ct.peek() != '(') {
						char c = ct.pop();
						int ab = st.pop();
						int cb = st.pop();
						if (ct.peek() == '-') {
							st.push(ab - cb);
						} else if (ct.peek() == '+') {
							st.push(ab + cb);
						} else if (ct.peek() == '*') {
							st.push(ab * cb);
						} else if (ct.peek() == '/') {
							st.push(ab / cb);
						}
					}
					ct.push(a.charAt(i));
				} else if (a.charAt(i) == '*') {
					while (!ct.isEmpty() && ct.peek() != '(') {
						char c = ct.pop();
						int ab = st.pop();
						int cb = st.pop();
						if (ct.peek() == '*') {
							st.push(ab * cb);
						} else if (ct.peek() == '/') {
							st.push(ab / cb);
						}
					}
					ct.push(a.charAt(i));
				} else if (a.charAt(i) == '/') {
					while (!ct.isEmpty() && ct.peek() != '(') {
						char c = ct.pop();
						int ab = st.pop();
						int cb = st.pop();
						if (ct.peek() == '*') {
							st.push(ab * cb);
						} else if (ct.peek() == '/') {
							st.push(ab / cb);
						}
					}
					ct.push(a.charAt(i));
				} else if (a.charAt(i) == ')') {
					while (!ct.isEmpty() && ct.peek() != '(') {
						char c = ct.pop();
						int ab = st.pop();
						int cb = st.pop();
						if (ct.peek() == '-') {
							st.push(ab - cb);
						} else if (ct.peek() == '+') {
							st.push(ab + cb);
						} else if (ct.peek() == '*') {
							st.push(ab * cb);
						} else if (ct.peek() == '/') {
							st.push(ab / cb);
						}
					}
				}
			}
		}
		System.out.println(st.peek());
	}

	static void celebrity(int m[][]) {

		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < m.length; i++) {
			st.push(m[0][i]);
		}
		while (!st.isEmpty() && st.size() > 1) {
			int n = st.pop();
			int p = st.pop();
			if (m[n][p] == 1) {
				st.push(p);
			} else {
				st.push(n);
			}
		}
		int f = st.pop();
		for (int i = 0; i < m.length; i++) {
			if (m[f][i] != 0) {
				System.out.println(false);
				return;
			}
		}

	}

	static class Cordinates {
		int start;
		int end;

		public Cordinates() {
			// TODO Auto-generated constructor stub
		}

		public Cordinates(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	

	static void merge(List<DynamicProgram.Cordinates> list) {
		Collections.sort(list, (a, b) -> {
			return b.start - a.start;
		});

		Stack<DynamicProgram.Cordinates> st = new Stack<DynamicProgram.Cordinates>();
		
		for (Cordinates it : list) {
			if (st.isEmpty())
				st.add(it);

			else {
				Cordinates c = st.peek();
				if (c.start < it.start && c.end > it.end) {

				} else if (c.start > it.start && c.end > it.end) {
					st.pop();
					st.push(new Cordinates(it.start, c.end));
				} else if(c.start<it.start && it.end>c.end)
				{
					st.pop();
					st.push(new Cordinates(c.start, it.end));
				}
			}
		}
	}

}
