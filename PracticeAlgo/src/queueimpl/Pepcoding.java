package queueimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Pepcoding {

	static void climbingstairs(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}

	static void climbingrandom(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[arr.length] = 1;
		for (int i = arr.length - 1; i >= 0; i--) {

			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				dp[i] = dp[i] + dp[i + j];
			}

		}
		System.out.println(dp[0]);
	}

	static void climbingrandommin(int arr[]) {
		Integer dp[] = new Integer[arr.length + 1];
		dp[arr.length] = 0;
		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] > 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= arr[i] && j + i < dp.length; j++) {
					if (dp[j + i] != null)
						min = Math.min(dp[j + i], min);
				}
				dp[i] = min + 1;
			}
		}
		System.out.println(dp[0]);
	}

	static void mincost(int m[][]) {
		int dp[][] = new int[m.length + 1][m.length + 1];

		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length && j == m.length) {
					dp[i][j] = m[i][j];
				} else if (i == m.length) {
					dp[i][j] = m[i][j + 1] + dp[i][j];
				} else if (j == m.length) {
					dp[i][j] = m[i + 1][j] + dp[i][j];
				} else {
					dp[i][j] = Math.max(m[i + 1][j], m[i][j + 1]) + dp[i][j];
				}

			}
		}
	}

	static void goldmine(int m[][]) {
		int dp[][] = new int[m.length][m.length];

		for (int i = m.length; i >= 0; i--) {
			for (int j = m.length; j >= 0; j--) {
				if (j == m.length) {
					dp[i][j] = m[i][j];
				} else if (i == m.length) {
					dp[i][j] = Math.min(m[i][j + 1], m[i - 1][j + 1]) + dp[i][j];
				} else if (i == 0) {
					dp[i][j] = Math.min(m[i][j + 1], m[i + 1][j + 1]) + dp[i][j];
				} else {
					dp[i][j] = Math.min(m[i][j + 1], Math.min(m[i - 1][j + 1], m[i + 1][j + 1])) + dp[i][j];
				}
			}
		}
	}

	static void targetsum(int arr[], int i, int value, String ans) {
		if (i == arr.length) {
			if (value == 10) {
				System.out.println(ans);
			}
			return;
		}
		targetsum(arr, i + 1, value + arr[i], ans + arr[i] + " ");
		targetsum(arr, i + 1, value, ans);
	}

	static void targetsum(int m[], int val) {
		boolean dp[][] = new boolean[m.length + 1][val + 1];
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m.length; j++) {
				if (dp[i][j - 1] == true) {
					dp[i][j] = true;
				} else {
					if (m[i] >= j) {
						dp[i][j] = dp[i - 1][j - m[i]];
					}
				}

			}
		}
	}

	static void coinchangepro(int arr[], int val) {
		int dp[][] = new int[arr.length + 1][val + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < val; j++) {
				if (arr[i] >= j) {
					dp[i][j] = dp[i][j - arr[i]] + 1;
				}
			}
		}
	}

	static void helper(int coins[], int value) {

		int dp[][] = new int[coins.length + 1][value];

		for (int i = 0; i < dp.length; i++) {
			int ab = Integer.MAX_VALUE;
			int bc = Integer.MAX_VALUE;
			for (int j = 1; j < value + 1; j++) {

				if (dp[i][j] >= j) {
					ab = 1 + dp[i][j - coins[i]];
				}
				bc = dp[i - 1][j];
				dp[i][j] = Math.min(bc, ab);

			}
		}

	}

	static void totalcoin(int arr[], int value) {
		int dp[][] = new int[arr.length + 1][value + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= value; j++) {
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
				if (arr[i] >= j) {
					b = dp[i - 1][j - arr[i]];
				} else {
					a = dp[i - 1][j];
				}
				dp[i][j] = a + b;
			}
		}
	}

	static void knapsack(int arr[], int val, int value[]) {
		int dp[][] = new int[arr.length + 1][val + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= val; j++) {
				int min = 0;
				if (arr[i] >= j) {
					min = dp[i - 1][j - arr[i]] + value[i];

				}
				dp[i][j] = Math.min(min, dp[i - 1][j]);
			}
		}

	}

	static void display(int val) {

		int f = 0;
		int d = 1;
		for (int j = 1; j < val; j++) {
			int dc = d;
			d = d + f;
			f = dc;

		}
		System.out.println(f + " " + d);

	}

	static void alphabet(String ab, String ans) {
		if (ab.length() == 0) {
			System.out.println(ans);
			return;
		}
		char c = ab.charAt(0);
		alphabet(ab.substring(1), ans + (char) (c + 'A' - 1) + " ");
		if (ab.length() > 2 && c != '0') {
			String bc = ab.substring(0, 2);
			int dc = Integer.parseInt(bc);
			alphabet(ab.substring(2), ans + (char) (dc + 'A' - 1) + " ");

		}

	}

	static void getvalue(String value) {

		int i = 2;

		int brr[] = new int[value.length() + 1];
		brr[0] = 1;
		brr[1] = 2;
		while (value.length() != i) {
			int dc = value.charAt(i - 1);
			int ec = value.charAt(i);
			if (ec != 0) {
				if (dc * 10 + ec < 26) {
					brr[i] = brr[i - 2] + brr[i - 1];
				} else {
					brr[i] = brr[i - 1];
				}
			} else {
				brr[i] = brr[i - 2];
			}
			i++;
		}
		System.out.println(brr[value.length() - 1]);

	}

	static void adjacent(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[0] = arr[0];
		dp[1] = arr[0] > arr[1] ? arr[0] : arr[1];

		String ans = "";
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
			ans = ans + dp[i] + " ";
		}
		System.out.println(dp[arr.length - 1]);
		System.out.println(ans);

	}

	static int paint(int m[][]) {
		int dp[][] = new int[m.length][m.length];

		for (int i = 0; i < m.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]);
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		return Math.min(dp[m.length][0], dp[m.length][1]);

	}

	static void paintmany(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			dp[0][i] = m[0][i];
		}
		for (int k = 1; k < m.length; k++)
			for (int i = 1; i < m.length; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < m.length; j++) {
					if (k != j)
						min = Math.min(dp[i - 1][j], min);
				}
				dp[i][k] = min + m[i][k];
			}
	}

	static void longestsub(int arr[]) {
		int br[] = new int[arr.length];
		Arrays.fill(br, 1);
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && br[i] < br[j] + 1) {
					br[i] = br[j] + 1;
					max = Math.max(max, br[i]);
				}
			}

		}
		System.out.println(max);
	}

	static void kpalindrome(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			String ab = a.substring(0, i + 1);
			if (ab.length() % 2 == 0) {
				kpalindrome(ab.substring(i + 1), ans + ab + " ");
			}

		}
	}

	static void palindromicsubs(String a) {
		boolean b[][] = new boolean[a.length()][a.length()];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				if (i == j) {
					b[i][j] = true;
				} else if (i == j + 1) {
					if (a.charAt(i) == a.charAt(j)) {
						b[i][j + 1] = true;
					} else {
						b[i][j + 1] = false;
					}
				} else if (j > i) {

					if (a.charAt(i) == a.charAt(j)) {
						if (b[i + 1][j - 1]) {
							b[i][j] = true;
						}
					}
				}
			}
		}

	}

	static void palindromelongest(String a) {
		int dp[][] = new int[a.length()][a.length()];
		Arrays.fill(dp[0], -1);
		int max = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = i; j < a.length(); j++) {
				if (i == j) {
					dp[i][j] = 1;
				} else if (i == j + 1) {
					if (a.charAt(i) == a.charAt(j + 1))
						dp[i][j + 1] = 2;
				} else {
					if (a.charAt(i) == a.charAt(j)) {
						if (dp[i + 1][j - 1] != -1) {
							dp[i][j] = dp[i + 1][j - 1] + 2;
							max = Math.max(max, dp[i][j]);
						}
					}
				}
			}
		}
		System.out.println(max);

	}

	static void getcostpath(int m[][]) {

		int dp[][] = new int[m.length][m.length];
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length - 1 && j == m.length - 1) {
					dp[i][j] = m[i][j];
				} else if (i == m.length - 1) {
					dp[i][j] = dp[i][j + 1] + dp[i][j];
				} else if (j == m.length - 1) {
					dp[i][j] = dp[i + 1][j] + dp[i][j];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + dp[i][j];
				}
			}
		}
	}

	static void display(int m[][], int x, int y, String ans) {
		if (x == m.length || y == m.length) {
			System.out.println(m[x][y]);
		}
		if (m[x + 1][y] > m[x][y + 1]) {
			display(m, x + 1, y, ans + m[x][y]);
		} else {
			display(m, x, y + 1, ans);
		}
	}

	static void getmindest(int arr[]) {
		int dp[] = new int[arr.length];
		int dc = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < arr[i] && j < dp.length; j++)
				if (i == arr.length) {
					dp[i] = 1;
				} else {
					if (arr[i] > 0) {
						min = Math.min(min, dp[i + j]);
					}
				}
			dp[i] = min + 1;
		}

	}

	static void kmax(int arr[]) {
		int dp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < i + arr[i] && j < arr.length; j++) {
				dp[j] = Math.min(dp[i], dp[j] + 1);
			}
		}
	}

	static class Pair {
		int x;
		int y;
		String value;

		public Pair(int x, int y, String value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

	}

	static void octoberandnov(int m[][]) {

		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0, ""));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x == m.length && p.y == m.length) {
				System.out.println(p.value);
			} else if (p.x == m.length) {
				q.add(new Pair(p.x, p.y + 1, p.value + "H"));
			} else if (p.y == m.length) {
				q.add(new Pair(p.x, p.y, p.value + "V"));
			} else {
				if (m[p.x][p.y + 1] > m[p.x][p.y + 1]) {

				} else {

				}
			}
		}

	}

	static void countdistinct(String a) {
		int dp[] = new int[a.length() + 1];
		dp[0] = 1;
		for (int i = 1; i < a.length(); i++) {
			int d = 0;
			for (int j = 0; j < i; j++) {
				if (a.charAt(i) == a.charAt(j)) {
					if (d == 0) {
						d = j;
					}
				}
				if (d == 0)
					dp[i] = 2 * dp[i - 1];
				else {
					dp[i] = 2 * dp[i - 1] - dp[d - 1];
				}
			}
		}
	}

	static int nstairs(int n) {
		if (n < 2) {
			System.out.println(n);
			return n;
		}

		int a = nstairs(n - 1);
		int b = nstairs(n - 2);
		int c = nstairs(n - 3);
		return a + b + c;
	}

	static void npairs(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[arr.length - 1] = arr[arr.length];
		for (int i = arr.length - 2; i >= 0; i--) {
			int sum = 0;
			for (int j = 1; j < arr[i] + i && j < arr.length; j++) {
				sum = sum + dp[i + j];
			}
			dp[i] = dp[i] + sum;
		}

	}

	static void minimumpar(int arr[]) {
		int dp[] = new int[arr.length + 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < arr[i] + i; j++) {
				min = Math.min(dp[i + j], min);
			}
			dp[i] = min + 1;
		}

	}

	static void minimumcostpath(int m[][]) {

		int dp[][] = new int[m.length][m.length];
		for (int i = m.length - 1; i >= 0; i--) {
			for (int j = m.length - 1; j >= 0; j--) {
				if (i == m.length && j == m.length) {
					dp[i][j] = m[i][j];
				} else if (i == m.length) {
					dp[i][j] = m[i][j + 1];
				} else if (j == m.length) {
					dp[i][j] = m[i + 1][j];
				} else {
					dp[i][j] = Math.min(m[i + 1][j], m[i][j + 1]) + m[i][j];
				}
			}
		}
	}

	static void targetsum(int arr[]) {
		boolean dp[][] = new boolean[arr.length + 1][8];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < 8; j++) {
				if (dp[i][j - 1] == true) {
					dp[i][j] = true;
				} else {
					if (arr[i] >= j) {
						dp[i][j] = dp[i - 1][j - arr[j]];
					} else if (arr[i] == j) {
						dp[i][j] = true;
					}
				}
			}
		}
	}

	static void coinch(int ar[], int val) {
		int dp[][] = new int[ar.length + 1][val + 1];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < val; j++) {
				int ab = Integer.MAX_VALUE;
				int bc = Integer.MAX_VALUE;
				if (ar[j] < i) {
					dp[i][j] = dp[i - 1][j];
				} else {
					if (ar[j] >= i) {
						ab = 1 + dp[i][j - ar[i]];
					}
				}
			}
		}
	}

	static void knapsack(int arr[], int value, int max) {

		knapsack(arr, value, max + arr[value]);
		knapsack(arr, value, max);
	}

	static void countpallindromc(String ans) {
		boolean dp[][] = new boolean[ans.length()][ans.length()];
		for (int i = 0; i < ans.length(); i++) {
			for (int k = 0, j = i; j < ans.length(); k++, j++) {
				if (i == j) {
					dp[i][k] = true;
				} else if (i == j + 1) {
					if (ans.charAt(i) == ans.charAt(j))
						dp[i][k] = true;
					else
						dp[i][k] = false;
				} else {
					if (ans.charAt(i) == ans.charAt(j) && dp[i][j - 1])
						dp[i][k] = true;
					else
						dp[i][k] = false;
				}

			}
		}
	}

	static int pladp(String a, int x, int y) {
		if (x > y) {
			return 0;
		}
		if (x == y) {
			return 1;
		}
		int d = 0;
		if (a.charAt(x) == a.charAt(y)) {
			d = 2 + pladp(a, x + 1, y - 1);
		}
		return Math.max(d, Math.max(pladp(a, x + 1, y), pladp(a, x, y - 1)));
	}

	static int substring(String abs, int x, int y, int count) {
		if (x > y) {
			return count;
		}
		if (x == y) {
			return 1;
		}
		if (abs.charAt(x) == abs.charAt(y)) {
			int len = y - x + 1;
			if (len == substring(abs, x + 1, y - 1, count)) {
				return 2 + substring(abs, x + 1, y - 1, count);
			}
		}
		return 0;
	}

	static void ksubs(String dc) {
		boolean b[][] = new boolean[dc.length()][dc.length()];
		for (int i = 0; i < b.length; i++) {
			for (int f = 0, j = i; j < b.length; f++, j++) {
				if (i == j) {
					b[i][f] = true;
				} else if (i == j + 1) {
					if (dc.charAt(i) == dc.charAt(j)) {
						b[i][f] = true;
					}
				} else {
					if (dc.charAt(i) == dc.charAt(j)) {

					}
				}
			}
		}
	}

	static void printminimum(int m[][]) {
		Queue<Pair> q = new LinkedList<Pepcoding.Pair>();
		q.add(new Pair(0, 0, ""));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x == m.length && p.y == m.length) {
				System.out.println(p.value);
			} else if (p.x == m.length) {
				q.add(new Pair(p.x, p.y + 1, p.value + "V"));
			} else if (p.y == m.length) {
				q.add(new Pair(p.x + 1, p.y, p.value + "H"));
			} else {
				if (m[p.x][p.y + 1] > m[p.x + 1][p.y]) {
					q.add(new Pair(p.x, p.y + 1, p.value + "H"));
				}
			}
		}
	}

	static void countdistincta(String ab) {

		HashMap<Character, String> hash = new HashMap<Character, String>();
		int dp[] = new int[ab.length() + 1];
		dp[0] = 1;
		hash.put('.', "");
		for (int i = 1; i < dp.length; i++) {
			char c = ab.charAt(i - 1);
			boolean flag = false;
			int dc = 0;
			for (int j = 0; j < i; j++) {
				if (ab.charAt(j) == ab.charAt(i)) {
					flag = true;
					if (dc == 0) {
						dc = j;
					}
				}
			}
			if (flag == false) {
				dp[i] = dp[i - 2] * 2;
			} else if (flag == false && dc != 0) {
				dp[i] = dp[i - 2] * 2 - dp[dc - 1];
			}
		}
	}

	static class Value {
		int x;
		int y;
		int val;

		public Value(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

	}

	static void knapsacke(int arr[], int val, int price[]) {
		int dp[][] = new int[arr.length + 1][val + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= val; j++) {
				int db = 0;
				int cb = 0;
				if (arr[i] < j) {
					db = dp[i - 1][j];
				}
				if (arr[i] >= j) {
					cb = dp[i - 1][j - arr[i]] + price[i];
				}
				dp[i][j] = Math.max(db, cb);

			}
		}

		Queue<Value> q = new LinkedList<>();
		q.add(new Value(dp.length, dp.length, 0));
		while (!q.isEmpty()) {
			Value v = q.poll();
			if (v.x == 0 || v.y == 0) {
				System.out.println(v.val);
			} else {
				if (dp[v.x][v.y] == dp[v.x - 1][v.y]) {
					q.add(new Value(v.x - 1, v.y, val));
				} else {
					int vd = dp[v.x][v.y];
					int dc = v.y - v.y;
					q.add(new Value(v.x - 1, v.y - dc, val));
				}
			}
		}

	}

	static void longestpalin(String ab) {
		boolean b[][] = new boolean[ab.length() + 1][ab.length() + 1];
		b[b.length][b.length] = true;
		for (int i = ab.length() - 1; i >= 0; i--) {
			for (int j = ab.length() - 1; j >= 0; j--) {
				if (ab.charAt(i) == '?') {
					b[i][j] = b[i + 1][j];
				} else if (ab.charAt(i) == '.') {
					if (b[i + 1][j]) {
						b[i][j] = true;
					} else if (b[i][j + 1]) {
						b[i][j] = true;
					}
				} else {
					if (ab.charAt(i) == ab.charAt(j)) {
						if (b[i][j + 1]) {
							b[i][j] = true;
						}
					}
				}
			}
		}

	}

	static void catlan(int val) {
		int dp[] = new int[val];
		for (int i = 0; i < val; i++) {
			if (i == 0 || i == 1) {
				dp[i] = 1;
			} else {
				int d = 0;
				int e = i;
				int sum = 0;
				while (d != i && e != 0) {
					sum = sum + dp[d] * dp[e];
					d++;
					e--;
				}
				dp[i] = sum;
			}
		}
		System.out.println(dp[val - 1]);
	}

	static void dpsearch(int word[], int pr[], int value) {
		int dp[][] = new int[word.length + 1][value];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < value; j++) {
				int dc = 0;
				int dpc = 0;
				if (word[i] >= j) {
					dc = dp[i][j - word[i]] + pr[i];
				} else {
					dpc = dp[i][j - 1];
				}
				dp[i][j] = Math.max(dc, dpc);
			}
		}
	}

	static void solutin(String word, String value, int count, int pos) {
		if (pos == word.length()) {
			System.out.println(value);
			return;
		}
		if (count > 0)
			solutin(word, value + count + word.charAt(pos), 0, pos + 1);
		else
			solutin(word, value + word.charAt(pos), count, pos + 1);
		solutin(word, value, count + 1, pos + 1);
	}

	static void murariexp(String a, int i, int count, char prav, String val, int diff) {
		if (a.length() == i) {
			System.out.println(val);
			String bs = "";
			int count1 = diff;
			for (int j = val.length() - 1; j >= 0; j--) {
				if (count1 != 0) {
					if (j == val.length() - 1 && !Character.isDigit(val.charAt(j))) {
						count1--;
					} else if (!Character.isDigit(val.charAt(j)) && !Character.isDigit(val.charAt(j + 1))) {
						count1--;
					}
				} else
					bs = val.charAt(j) + bs;
			}
			System.out.println(bs);
			return;
		}
		if (prav != a.charAt(i))
			if (count == 0)
				murariexp(a, i + 1, 0, a.charAt(i), val + a.charAt(i), diff);
			else
				murariexp(a, i + 1, 0, a.charAt(i), val + (count + 1) + a.charAt(i), diff);

		else if (i + 1 == a.length()) {
			if (count == 0)
				murariexp(a, i + 1, 0, a.charAt(i), val + a.charAt(i), diff);
			else
				murariexp(a, i + 1, 0, a.charAt(i), val + (count + 1), diff);
		} else
			murariexp(a, i + 1, count + 1, prav, val, diff);
	}

	static void remix(String a, int c, int l, HashSet<Character> set, String value) {
		if (l == a.length()) {
			if (c == a.length()) {
				System.out.println(value);
				return;
			}
			System.out.println(value);
			return;
		}
		if (!set.contains(a.charAt(l))) {
			set.add(a.charAt(l));
			for (int j = 0; j < a.length(); j++) {

				remix(a, c, j, set, value + a.charAt(c) + " ");

			}
			set.remove(a.charAt(l));
		}
	}

	static void transform(String word, String pattern, int i) {
		if (word.length() == 0 && pattern.length() == 0) {
			System.out.println(1);
			return;
		}
		if (word.length() == 0 || pattern.length() == 0) {
			return;
		}

		if (word.charAt(0) == pattern.charAt(0)) {
			transform(word.substring(1), pattern.substring(1), i);

		}
		transform(word.substring(1), pattern, i);

	}

	static void patternmatch(String word, HashSet<String> set, String value) {
		if (word.length() == 0) {
			System.out.println(value);
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			String first = word.substring(0, i + 1);
			if (set.contains(first)) {
				patternmatch(word.substring(i + 1), set, value + first + " ");
			}
		}
	}

	static void pepcoding(String word, Map<String, Boolean> set, String value) {
		int v = 0;
		for (int i = 1; i < word.length(); i++) {

			for (int j = 0; j < i; j++) {
				value = value + word.charAt(j);
				if (set.containsKey(value)) {
					boolean bc = set.get(value);
					if (bc == false) {
						v++;
						set.put(value, true);
						value = "";
					}
				}
			}
		}
		System.out.println(v);
	}

	static void maximumsquare(int m[][]) {
		int dp[][] = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					dp[i][j] = 0;
				} else if (i == 0 || j == 0) {
					dp[i][j] = m[i][j];
				} else {
					dp[i][j] = Math.min(m[i][j + 1], Math.min(m[i + 1][j], m[i][j - 1])) + 1;
				}
			}
		}
	}

	static void slices(int arr[]) {
		int dp[] = new int[arr.length];
		for (int i = 2; i < arr.length; i++) {
			for (int j = i - 2; j < i; j++) {
				if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
					dp[i] = dp[i - 1] + 1;
				}
			}
		}
		System.out.println(dp[arr.length - 1]);
	}

	static void greatvalue(int arr[]) {
		int i = 0;
		int sum = 0;
		int max = 0;
		while (arr.length > i) {
			sum = sum + arr[i];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
			i++;
		}
		System.out.println(max);
	}

	static void kmp(String word, String pattern) {
		int i = 0;
		int j = 0;
		String w="";
		while (word.length()  != i && pattern.length() != j) {
			w =w+ word.charAt(i);
			if (word.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0)
					j = j - 1;
				else {
					i++;
				}
			}
			if (pattern.length() == j) {
				System.out.println(w);
				System.out.println("found");
				return;
			}
		}
		System.out.println(w);
		System.out.println(false);

	}

	public static void main(String[] args) {
		kmp("onionionsdp", "onions");
	}
}
