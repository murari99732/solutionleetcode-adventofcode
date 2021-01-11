package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DynamicProgramming {

	static int arr[] = new int[11];

	static void fibonacci(int value) {
		int a = 0;
		int b = 1;
		for (int i = 2; i < value; i++) {
			int c = a + b;
			System.out.println(c);
			a = b;
			b = c;
		}
	}

	static int fibonacci1(int value) {
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < value; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[value - 1];
	}

	static int fibonacci2(int value) {
		if (value < 2) {
			return value;
		}
		if (arr[value] == 0) {
			arr[value] = fibonacci2(value - 1) + fibonacci2(value - 2);
		}
		return arr[value];
	}

	static int reachStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (arr[n] == 0) {
			arr[n] = reachStairs(n - 1) + reachStairs(n - 2) + reachStairs(n - 3);
		}
		return arr[n];
	}

	static int reachstairs1(int n) {
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}
		return arr[n - 1];
	}

	static int minstep(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		if (arr[n] == 0) {
			arr[n] = Math.min(minstep(n - 1), Math.min(minstep(n - 2), minstep(n - 3))) + 1;
		}
		return arr[n];
	}

	static void minstep1(int value) {
		int a = 1;
		int b = 1;
		int c = 2;
		int d = 0;
		while (value != 0 && value > 0) {
			d++;
			if (value > 2) {
				value = value - c;
			} else if (value < 2) {
				value = value - b;
			} else {
				value = value - a;
			}
		}
		System.out.println(d);

	}

	static void subsequncelongest(int arr[]) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int start = i;
			int pt = start;
			int d = 0;
			while (start < arr.length) {

				if (arr[start] >= arr[pt]) {
					d++;
					pt = start;
				}
				start++;

			}
			max = Math.max(d, max);

		}
		System.out.println(max);
	}

	static void longestSubsequence(int arr[]) {
		int brr[] = new int[arr.length];
		Arrays.fill(brr, 1);
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && brr[j] + 1 > brr[i]) {
					brr[i] = brr[j] + 1;
					max = Math.max(max, brr[j]);
				}
			}
		}
		System.out.println(max);
	}

	static void maximumsum(int arr[]) {
		int brr[] = new int[arr.length];
		Arrays.fill(brr, 0);
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && brr[j] > brr[i]) {
					brr[i] = brr[j] + brr[i];
					max = Math.max(max, brr[i]);
				}
			}
		}
		System.out.println(max);
	}

	static void maximumLongest(int arr[]) {
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int d = 0;
			int st = 0;
			if (arr[i + 1] < arr.length) {
				st = arr[i + 1];
				for (int j = i + 1; j < arr.length; j++) {
					if (st < arr[j]) {
						d++;
						st = arr[j];
						max = Math.max(max, d);
					}
				}
			}
		}
		System.out.println(max);
	}

	static void maximumLogestValue(int arr[]) {
		int brr[] = new int[arr.length];
		int d = 0;
		for (int k : arr) {
			brr[d++] = k;
		}
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && brr[i] < brr[j] + arr[i]) {
					brr[i] = brr[j] + arr[i];
					max = Math.max(brr[i], max);
				}
			}
		}
		System.out.println(max);
	}

	static int br[] = new int[5];

	static int logestsubsequence(String a, String b, int length, int length1, Integer arr[][]) {
		if (length == 0) {
			return 0;
		}
		if (length1 == 0) {
			return 0;
		}

		if (arr[length][length1] == null)
			if (a.charAt(length - 1) == b.charAt(length1 - 1)) {
				arr[length][length1] = 1 + logestsubsequence(a, b, length - 1, length1 - 1, arr);
			} else
				arr[length][length1] = Math.max(logestsubsequence(a, b, length - 1, length1, arr),
						logestsubsequence(a, b, length, length1 - 1, arr));

		return arr[length][length1];
	}

	static int logestsubsequence1(String a, String b, Integer arr[][]) {
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					arr[i][j] = 1 + arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}

			}
		}
		return arr[a.length() - 1][b.length() - 1];

	}

	static int substring(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		int max = 0;
		int m[][] = new int[s.length() + 1][t.length() + 1];
		for (int i = 1; i < s.length(); i++) {
			for (int j = 1; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					m[i][j] = 1 + m[i - 1][j - 1];
					max = Math.max(m[i][j], max);

				} else {
					m[i][j] = 0;
				}

			}
		}
		System.out.println(max);
		return max;

	}

	static int reverseSequence(String word, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		if (word.charAt(start) == word.charAt(end)) {
			int ring = end - start - 1;
			if (ring == reverseString(word, start + 1, end - 1)) {
				return 2 + ring;
			}
		}
		return Math.max(reverseSequence(word, start + 1, end), reverseSequence(word, start, end - 1));
	}

	static int a[][] = new int[5][5];

	static int reverseDp(String s, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		if (a[start][end] == 0) {
			if (s.charAt(start) == s.charAt(end)) {
				int ring = end - start + 1;
				if (ring == reverseDp(s, start + 1, end - 1)) {
					a[start][end] = 2 + ring;
					return a[start][end];
				}
			}
		}
		a[start][end] = Math.max(reverseSequence(s, start + 1, end), reverseSequence(s, start, end - 1));

		return a[start][end];
	}

	static int reverseString(String word, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		if (word.charAt(start) == word.charAt(end)) {
			return 2;
		}
		return reverseString(word, start + 1, end - 1);

	}

	static void knapsack(int[] wt, int pr[], int capacity) {
		int arr[][] = new int[wt.length][capacity + 1];
		for (int i = 0; i < capacity; i++) {

			arr[0][i] = 0;
			if (wt.length < i) {
				arr[i][0] = 0;
			}
		}

		for (int i = 1; i <= wt.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				int profit = 0;
				if (wt[i] < j) {
					profit = pr[i] + arr[i - 1][j - wt[i]];
					arr[i][j] = Math.max(profit, arr[i - 1][j]);
				}
			}
		}
		System.out.println(arr[wt.length - 1][capacity - 1]);

	}

	static void largestSubsequnce(int arr[], int sum) {
		boolean b[][] = new boolean[arr.length][sum + 1];
		for (int i = 0; i < arr.length; i++) {
			b[i][0] = true;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (b[i - 1][j] == true) {
					b[i][j] = true;
				} else {
					if (arr[j] < sum) {
						b[i][j] = b[i - 1][j - arr[i]];
					}
				}
			}
		}
	}

	static void partition(int arr[], int value) {
		value = value / 2;
		boolean b[][] = new boolean[arr.length][value];
		for (int i = 0; i < arr.length; i++) {
			b[i][0] = false;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < value; j++) {
				if (b[i - 1][j] == true) {
					b[i][j] = true;
				} else {
					if (arr[i] > value) {
						b[i][j] = b[i - 1][j - arr[i]];
					}
				}
			}
		}
	}

	static void maximumcuttingrod(int arr[], int profit[], int values) {
		if (arr.length == 0 || profit.length == 0) {
			return;
		}
		int a[][] = new int[arr.length + 1][values + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < values; j++) {
				int inclusive = Integer.MAX_VALUE;
				int exclusive = Integer.MAX_VALUE;
				if (arr[i] >= j) {

					inclusive = profit[i] + a[i][j - arr[i]];

				} else {
					exclusive = a[i - 1][j];
				}
				a[i][j] = Math.max(inclusive, exclusive);
			}
		}
	}

	static void minjump(int arr[]) {
		int start = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

		int d = arr.length;
		int min = 0;
		int end = arr.length;
		int length = 0;
		int e = 0;

		queue.add(arr[start]);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			length = length + curr;
			if (length >= arr.length) {
				System.out.println("finaly found  " + e);
				break;
			}
			while (curr != 0 && length <= arr.length) {
				queue.add(arr[start]);
				start++;
				curr--;

			}
			e++;
		}

	}

	static void subset(int arr[], int value) {
		int b[][] = new int[arr.length][value + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < value; j++) {

				int including = 0;
				int excluding = 0;
				if (arr[i] > j) {
					including = b[i - 1][j - arr[i]];

				} else {
					excluding = b[i - 1][j];
				}
				b[i][j] = including + excluding;

			}
		}
	}

	static void maximumconsicutive(int arr[]) {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>(Collections.reverseOrder());
		int max = 0;

		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[0] > arr[1] ? arr[0] : arr[1];
		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);

		}
		for (int k : dp) {
			System.out.println(k);
		}
	}

	static int min = 0;

	static int chaining(int arr[], int i, int j) {
		if (i >= j) {
			return 0;
		}

		for (int k = i; k < j - 1; k++) {
			int value = chaining(arr, i, k);
			int value1 = chaining(arr, k + 1, j);
			int cost = arr[i - 1] * arr[k] * arr[j];
			min = Math.min(value + value1 + cost, min);
		}
		return min;
	}

	static int max = 0;

	static int demat(int arr[], int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (m[i][j] == -1) {

			for (int k = i; k < j - 1; k++) {
				int cost = demat(arr, i, k) + demat(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
				max = Math.max(cost, max);
				m[i][j] = max;
			}
		}
		return m[i][j];
	}

	static int m[][] = null;

	private static boolean ispalindrome(int[] arr2, int i, int j) {
		while (i < j) {
			if (arr[i] != arr[j]) {
				return false;
			}
			i++;
			j--;
		}
		return false;
	}

	public static void main(String[] args) {
int x=9;
swap(x, 23);
System.out.println(x);
		

	}
	static void swap(int x ,int y)
	{
		x=23;
		y=45;
	}

	static int multiplicationChaining(int arr[], int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (m[i][j] == -1)
			for (int k = i; k < j - 1; k++) {
				int cost = multiplicationChaining(arr, i, k) + multiplicationChaining(arr, k + 1, j)
						+ arr[i - 1] * arr[j] * arr[k];
				max = Math.max(cost, max);
				m[i][j] = max;
			}
		return m[i][j];
	}
	
	static int palindrome(int arr[], int i, int j)
	{
		if(i>=j)
		{
			return 0;
		}
		
		if(ispalindrome(arr, i, j))
		{
			return 0;
		}
		for(int k=i;k<j-1;k++)
		{
			int count=1+palindrome(arr, i-1, j)+palindrome(arr, i, j-1)+palindrome(arr, i-1, j-1);
			max=Math.min(count, max);
		}
		return max;
		
	}
	static void minjumps(int arr[])
	{
		int b[]= new int[arr.length];
		for(int i=2;i<arr.length;i++)
		{
			b[i]=Math.max(b[i-2]+arr[i], b[i-1]);
		}
	}

}
