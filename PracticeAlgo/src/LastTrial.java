import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class LastTrial {

	static void permutation(String a, String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
		}
		int start = 0;
		while (start < b.length()) {
			while (map.containsKey(b.charAt(start))) {
				int p = map.get(b.charAt(start));
				map.put(b.charAt(start), p - 1);
				if (map.size() == 0) {
					System.out.println(true);
				}
				start++;
			}
			if (!map.containsKey(b.charAt(start))) {
				while (end < start - 1) {
					if (map.containsKey(b.charAt(end))) {
						map.put(b.charAt(end), map.getOrDefault(b.charAt(end), 0) + 1);
					}
					end++;
				}
			}

		}

	}

	static void printallanagram(String a, String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
		}
	}

	static void histogram1(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();

		st.add(arr[0]);
		int max = 0;
		while (!st.isEmpty()) {
			if (st.peek() > arr[start]) {
				st.push(start);
			}

			else if (st.peek() >= arr[start]) {
				int i = start;
				while (st.peek() >= arr[i]) {

					int value = st.pop();

					max = Math.max(max, (start - value) * arr[value]);
					i--;
				}
			}
			start++;
		}

	}

	static void insert(int arr[], int value) {
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = value;
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void insertbetween(int arr[], int position) {
		for (int i = arr.length - 1; i > position; i--) {
			arr[i] = arr[i - 1];
		}
		arr[position] = 23;
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void delete(int arr[], int position) {
		for (int i = 0; i < arr.length; i++) {
			if (i > position) {
				arr[i] = arr[i + 1];
			}
		}

		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void insertHeap(int arr[], int value, int size) {
		arr[size] = value;
		int parent = (size - 1) / 2;
		int index = size;
		while (arr[index] > arr[parent]) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
			int p = index;
			index = parent;
			parent = (p - 1) / 2;
		}
		size++;
	}

	public void deleteHeap(int arr[], int size) {
		int max = arr[0];
		arr[0] = arr[size - 1];
		rearrange(arr, size, 0);
	}

	private void rearrange(int[] arr, int size, int i) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		while (arr[i] < arr[r] || arr[i] < arr[l]) {
			int max = arr[l] < arr[r] ? l : r;
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			i = max;
		}

	}

	static void frequency(int arr[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int j : arr) {
			map.put(j, map.getOrDefault(j, 0) + 1);
		}

		map.entrySet().stream().forEach(t -> System.out.println(t.getValue()));

	}

	static void merge(int arr[], int i, int j) {
		if (i > j) {
			return;
		}
		int mid = (i + j) / 2;
		merge(arr, i, mid);
		merge(arr, mid + 1, j);
		mergesort(arr, i, mid, j);

	}

	private static void mergesort(int[] arr, int i, int mid, int j) {
		int k = 0;
		int start = i;
		int mid1 = mid + 1;
		int c[] = new int[j - i + 1];
		while (start <= mid && mid1 <= j) {
			if (arr[start] < arr[mid1]) {
				c[k++] = arr[start];
				start++;
			} else {
				c[k++] = arr[mid1];
				mid1++;
			}
		}
		while (start <= mid) {
			c[k++] = arr[start];
			start++;
		}
		while (mid1 <= j) {
			c[k++] = arr[mid1];
			mid1++;
		}
		k = 0;
		for (int kd : c) {
			arr[k++] = kd;
		}
	}

	static void quicksort(int arr[], int start, int end) {
		if (start < end) {
			int pivot = start + 1;
			int i = start;
			int j = end;

			while (i < j) {
				while (arr[pivot] < arr[i]) {
					i++;
				}
				while (arr[pivot] > arr[j]) {
					j--;
				}
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

			int temp = arr[i];
			arr[i] = arr[start];
			arr[start] = temp;
			quicksort(arr, start, end);
		}
	}

	static void contigoussum(int arr[]) {
		int start = 0;
		int max = 0;
		int sum = 0;
		while (start < arr.length) {
			sum = sum + arr[start];
			max = Math.max(sum, max);
			if (arr[start] < 0) {
				sum = 0;
			}
			start++;
		}
		System.out.println(max);
	}

	public static void largestContiguousSubArrayNegative(int[] a) {
		int max_so_far, current_max;
		max_so_far = current_max = a[0];

		for (int i = 1; i < a.length; i++) {
			current_max = Math.max(a[i], current_max + a[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}

		System.out.println(max_so_far);
	}

	static void equlibrium(int arr[], int start, int end) {
		if (start > end) {
			return;
		}
		int sum = 0;
		for (int k = 0; k < start; k++) {
			sum = sum + arr[k];
		}
		int sum2 = 0;
		for (int k = start + 1; k < end; k++) {
			sum = sum + arr[k];
		}
		if (sum == sum2) {
			System.out.println(true);
			return;
		}
		equlibrium(arr, start + 1, end);
	}

	static void unionsorted(int arr[], int brr[]) {
		int cr[] = new int[arr.length + brr.length];
		int start = 0;
		int startb = 0;
		int k = 0;
		while (start < arr.length && startb < brr.length) {
			while (arr[start] == arr[start + 1]) {
				start++;
			}

			while (brr[startb] == arr[startb + 1]) {
				startb++;
			}

			if (arr[start] < brr[startb]) {
				cr[k++] = arr[start];
				start++;
			} else if (brr[startb] < arr[start]) {
				cr[k++] = brr[startb];
				startb++;
			} else {
				cr[k++] = brr[startb];
				startb++;
				start++;
			}

		}
	}

	static void smallest(int arr[]) {
		int max = 0;
		int secondmax = 0;
		for (int i = 0; i < arr.length; i++) {

			if (secondmax < arr[i]) {
				secondmax = arr[i];
				if (max < secondmax) {
					int temp = max;
					max = secondmax;
					secondmax = temp;
				}

			}
		}

		System.out.println(secondmax + " " + max);

	}

	static void maximusubarray(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int value = 0;
		int max = 0;
		while (start < arr.length && start >= end) {
			if (value < k) {
				sum = sum + arr[start];
				max = Math.max(sum, max);
				value++;
			} else {
				sum = sum - arr[end];
				end++;
				value--;
			}
		}
		System.out.println(max);
	}

	static void removeallduplicate(int arr[]) {
		int d = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				arr[d++] = arr[i - 1];
		}
		for (int k = 0; k < d; k++) {
			System.out.println(arr[k]);
		}
	}

	static void maximum(int arr[], int brr[]) {
		int starta = 0;
		int startb = 0;
		int sum = 0;
		int sumb = 0;
		int end = 0;
		int endb = 0;
		int max = 0;
		while (starta < arr.length && startb < brr.length) {
			sum = sum + arr[starta];
			sumb = sumb + arr[startb];
			if (sumb == sum) {
				max = Math.max(end - starta + 1, max);
			} else if (sumb > sum) {
				starta++;
			} else if (sum < sumb) {
				startb++;
			} else {

			}

		}
	}

	static void pythagoras(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int sum = arr[end];
			int last = end - 1;
			while (start < last) {
				int value = arr[start] + arr[last];
				if (value == sum) {
					System.out.println("true");
					break;
				} else if (value < sum) {
					start++;
				} else {
					last--;
				}
			}
			end--;
			start = 0;
		}

	}

	static int arr[] = new int[10];
	static int start = 0;
	static int end = arr.length;
	static Stack<Integer> st = new Stack<Integer>();
	static Stack<Integer> ts = new Stack<Integer>();

	static void insertst(int value) {

		if (start + 1 != end) {
			ts.push(value);
			start++;
		}
	}

	static void insertts(int value) {

		if (start + 1 != end) {
			ts.push(value);
			end--;
		}
	}

	static void popst() {
		if (start != 0) {
			System.out.println(st.pop());
			start--;
		}
	}

	static void popts() {
		if (end != arr.length - 1) {
			System.out.println(st.pop());
			end++;
		}
	}

	static void value(int arr[]) {
		Arrays.sort(arr);

		int start = 0;
		int end = arr.length - 1;
		int max = Integer.MAX_VALUE;
		while (start < end) {
			int sum = arr[start] + arr[end];
			max = Math.min(sum - 0, max);

		}

	}

	static void rotatematrix(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = m.length - 1; j >= 0; j--) {
				System.out.print(m[j][i]);
			}
			System.out.println();
		}
	}

	static void patternmatch(String word, String pattern) {
		int start = 0;
		int pstart = 0;
		while (start < word.length() && pstart < pattern.length()) {
			if (word.charAt(start) != pattern.charAt(pstart)) {
				start++;
			} else {
				while (start < word.length() && pstart < pattern.length()
						&& word.charAt(start) == pattern.charAt(pstart)) {
					start++;
					pstart++;
				}
				if (pstart == pattern.length()) {
					System.out.println(start - pstart + " " + true);
					break;
				} else {
					pstart = 0;
				}
			}

		}

	}

	static void unique(int m[][]) {
		HashSet<String> hashSet = new HashSet<String>();
		for (int i = 0; i < m.length; i++) {
			String s = "";
			for (int j = 0; j < m[i].length; j++) {
				s = s + m[i][j];
				if (!hashSet.contains(s)) {
					System.out.println(s);
					hashSet.add(s);
				}
			}
		}
	}

	static void findelement(int m[][], int value) {
		int start = 0;
		int end = m.length - 1;

		int v = Arrays.binarySearch(m[0], value);
		if (v < 0) {
			v = Math.abs(v) - 2;
		}
		int d = Arrays.binarySearch(m[v], value);
		if (d < 0) {
			System.out.println(false);
		} else {
			System.out.println("found " + v + " " + d);
		}

	}

	static void find(int m[][], int value) {
		int start = 0;
		int end = m.length - 1;
		int r = 0;
		while (end > start) {
			if (m[end][0] < value) {
				r = end;
				break;
			}
			if (m[end][0] == value) {
				r = -1;
				System.out.println("found");
			}
			end--;

		}
		int d = 0;
		while (r != -1 && d < m.length) {

		}

	}

	static void numberisland(int m[][]) {
		boolean[][] b = new boolean[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

				if (b[i][j] != false) {
					connected(b, m, i, j);
				}

			}
		}
	}

	private static void connected(boolean[][] b, int[][] m, int i, int j) {
		if (m[i][j] != 1) {
			return;
		}

		b[i][j] = true;
		if (safevisit(b, m, i, j + 1)) {
			connected(b, m, i, j + 1);
		}
		if (safevisit(b, m, i + 1, j)) {
			connected(b, m, i + 1, j);
		}
		if (safevisit(b, m, i - 1, j)) {
			connected(b, m, i - 1, j);
		}
		if (safevisit(b, m, i, j - 1)) {
			connected(b, m, i, j - 1);
		}

	}

	private static boolean safevisit(boolean[][] b, int[][] m, int i, int j) {
		if (i > 0 && j > 0 && i < b.length && j < b.length && b[i][j] == false && m[i][j] == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] mat = { { 2, 7, 15 }, { 4, 9, 19 }, { 6, 10, 24 } };
		compression("aaaabbbcc");

	}

	static void compression(String a) {
		int start = 0;
		String b = "";
		while (start < a.length()-1) {
			int i = 0;
			while (start+1!=0&&a.charAt(start) == a.charAt(start + 1)) {
				i++;
				start++;
			}
			b = b+a.charAt(start)+i;
			start++;
		}
		System.out.println(b);
	}

	static void permutate(String a, int start, int end) {
		if (end <= start) {
			return;
		}

		permutate(a, start, end - 1);
		String b = swap(a, start, end);
		System.out.println(a);

	}

	private static String swap(String a, int start2, int end2) {
		char c[] = a.toCharArray();
		char temp = c[start2];
		c[start2] = c[end2];
		c[end2] = temp;
		return String.valueOf(c);

	}

	static void backtracking(String a, int l, int r) {
		if (l == r) {
			System.out.println(a);
			return;
		}
		for (int i = l; i <= r; i++) {
			a = swap(a, l, i);
			backtracking(a, l, i);
			a = swap(a, l, i);

		}
	}

	static void dictionary(List<String> list, String w, String f) {
		if (w.length() == 0) {
			System.out.println(f);
		}

		for (int i = 0; i < w.length(); i++) {
			String s = w.substring(0, i);
			if (list.contains(s)) {
				dictionary(list, w.substring(i), f + "" + s);
			}
		}

	}

	static void hudsonerror(String b) {
		String a = b.toUpperCase().replaceAll("[^A-Z0-9]", " ");
		System.out.println(a);
		String word[] = a.split(" +");
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length; i++) {
			map.put(word[i], map.getOrDefault(word[i], 0) + 1);
		}
		TreeMap<String, Integer> treemap = new TreeMap<String, Integer>((e1, e2) -> {
			int v = map.get(e1);
			int v1 = map.get(e2);
			if (v != v1) {
				return v1 - v;
			}

			return e1.compareTo(e2);
		});
		treemap.putAll(map);

		System.out.println(treemap.lastEntry());

	}

	static void matrixrot(int m[][]) {
		Queue<Matrix> q = new LinkedList<Matrix>();

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 2) {

					q.add(new Matrix(i, j));

				}
			}
		}
		q.add(new Matrix(-1, -1));
		boolean f = false;
		int count = 0;
		while (!q.isEmpty()) {
			Matrix mq = q.poll();

			while (mq.x != -1 && mq.y != -1) {
				if (true) {
					m[mq.x][mq.y + 1] = 2;
					if (f == false) {
						f = true;
						count++;
					}
				}
				if (m[mq.x + 1][mq.y] == 1) {
					m[mq.x + 1][mq.y] = 2;
					if (f == false) {
						f = true;
						count++;
					}
				}

			}

			if (!q.isEmpty()) {
				q.add(new Matrix(-1, -1));
				f = false;
			}
		}
	}

	static void maximumsquare(int m[][]) {
		int a[][] = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				a[i][j] = m[i][j];
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (a[i][j] == 0 || a[i][j] == 1) {
					m[i][j] = 0;
				} else if (a[i][j] != 0) {
					m[i][j] = 1 + Math.min(a[i][j - 1], a[i + 1][j]);
				}
			}
		}

	}

	static void maxsub(String a, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int max = 0;
		int end = 0;
		while (start < a.length()) {
			map.put(a.charAt(start), map.getOrDefault(a.charAt(start), 0) + 1);
			if (map.size() <= 2) {
				max = Math.max(max, start - end + 1);

			} else {
				while (map.size() > 2 && end <= start) {
					int value = map.get(a.charAt(end));
					if (value == 0) {
						map.remove(a.charAt(end));
					} else {
						map.put(a.charAt(end), value - 1);
						end++;
					}

				}
			}
			start++;
		}
		System.out.println(max);
	}

	static int histogram(int heights[]) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		int max = 0;
		int end = heights.length - 1;
		while (start < end) {
			if (arr[start] >= heights[st.peek()]) {
				st.push(start);
			} else {
				int d = start;
				if (!st.isEmpty() || arr[d] <= heights[st.peek()]) {
					int value = st.pop();
					int cap = arr[value] * d - start - 1;
					max = Math.max(cap, max);
				}
			}
			start++;
		}
		while (!st.isEmpty()) {
			int value = st.pop();
			int cap = arr[value] * value - start - 1;
			max = Math.max(cap, max);
		}
		return max;
	}

	static void vowel(String a) {

		String word = "";
		int start = 0;
		int end = a.length();
		while (start < end) {
			if (a.charAt(start) == 'a' || a.charAt(start) == 'e' || a.charAt(start) == 'o') {
				char temp = a.charAt(start);

			}
		}

	}

}

class Matrix {
	int x;
	int y;

	public Matrix(int x, int y) {
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
}