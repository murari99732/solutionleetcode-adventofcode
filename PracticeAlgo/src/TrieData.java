import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Pointer {
	Pointer[] point = new Pointer[27];
	boolean isVisited = false;
}

public class TrieData {
	static Pointer root = new Pointer();

	static boolean powerforfour(int value, int i) {
		if (i > value) {
			return false;
		}
		if (value % 2 != 0) {
			return false;
		}
		if (i * i * i * i == value) {
			return true;
		}
		return powerforfour(value, i + 1);

	}

	static void insert(String word) {
		int i = 0;
	
		while (i < word.length()) {
			int value = word.charAt(i) - 'A';
			if (root.point[value] == null) {
				root.point[value] = new Pointer();
			} else {
				root = root.point[value];
				i++;
			}
		}
		root.isVisited = true;

	}

	static boolean search(String word) {
		int i = 0;
		Pointer temp = root;
		while (i < word.length()) {
			int value = word.charAt(i) - 'a';
			if (temp.point[i] == null) {
				return false;
			} else {
				temp = temp.point[i];
				i++;
			}
		}
		return temp.isVisited;

	}

	static boolean searchValue(String word) {
		int i = 0;
	
		while (i < word.length()) {

			if (word.charAt(i) != '.') {
				int val = word.charAt(i) - 'a';
				if (root.point[val] == null) {
					return false;
				}
				root = root.point[val];
				i++;

			} else if (word.charAt(i) == '.') {
				root = root.point[i];
				i++;
				continue;
			}

		}
		return root.isVisited;

	}

	static boolean startswith(String word) {
		int i = 0;
		Pointer temp = root;
		while (i < word.length()) {
			int val = word.charAt(i) - 'a';
			if (temp.point[val] == null) {
				return false;
			} else {
				temp = temp.point[val];
				i++;
			}
		}
		return true;
	}

	static void palindrome(String word) {
		String value = word.toLowerCase();
		value = value.replaceAll("[^a-z0-9]", "");

		System.out.println(palindromeUtils(value, 0, value.length() - 1));

	}

	private static boolean palindromeUtils(String value, int i, int length) {
		if (i > length) {
			return true;
		}
		if (value.charAt(i) != value.charAt(length)) {
			return false;
		}
		return palindromeUtils(value, i + 1, length - 1);
	}

	static boolean checkCapital(String s) {
		if (s.charAt(0) - 65 <= 26 && s.charAt(1) - 65 <= 26) {
			for (int i = 2; i < s.length(); i++) {
				if (s.charAt(i) - 65 >= 26) {
					return false;
				}
			}
		} else if (s.charAt(0) - 65 <= 26) {
			for (int i = 2; i < s.length(); i++) {
				if (s.charAt(i) - 65 <= 26) {
					return false;
				}
			}
		} else {
			for (int i = 2; i < s.length(); i++) {
				if (s.charAt(i) - 65 <= 26) {
					return false;
				}
			}
		}
		return true;
	}

	static int stairs(int value, int ar[]) {
		if (value == 1) {
			return 1;
		}
		if (value == 2) {
			return 1;
		}
		int f = stairs(value - 1, ar);
		int g = stairs(value - 2, ar);

		return f + g;
	}

	static List<String> list = new ArrayList<>();

	static int wordDictionary(HashSet<String> hashSet, String s, int i, int count, String word) {
		if (i >= s.length()) {
			return count;
		}
		word = word + s.charAt(i);
		if (hashSet.contains(word)) {
			list.add(word);
			count = count + 1;
			word = "";
		}
		int d = wordDictionary(hashSet, s, i + 1, count, word);

		return d;
	}

	static int profit = 0;

	static int maxprofit(int arr[], int i, boolean isbuy) {
		if (i > arr.length) {
			return 0;
		}
		if (isbuy == false) {
			int v = maxprofit(arr, i + 1, true) - arr[i];
			int u = maxprofit(arr, i + 1, false);
			profit = Math.max(v, u);
		} else {
			int v = maxprofit(arr, i + 2, false) + arr[i];
			int u = maxprofit(arr, i + 1, true);
			profit = Math.max(v, u);
		}
		return profit;
	}

	static TreeValue construct(int post[], int inorder[], int start, int end) {
		if (end < start) {
			return null;
		}
		TreeValue tree = createnode(post[end]);
		int val = getValue(inorder, post[end]);
		tree.right = construct(post, inorder, val, end);
		tree.left = construct(post, inorder, start, val - 1);

		return tree;
	}

	private static int getValue(int[] inorder, int end) {
		int i = 0;
		for (i = 0; i < inorder.length; i++) {
			if (inorder[i] == end) {
				return i;
			}
		}
		return i;
	}

	private static TreeValue createnode(int i) {
		TreeValue tree = new TreeValue();
		tree.value = i;
		return tree;
	}

	static int addDigit(int value, int sum) {
		if (value < 9) {
			return sum;
		}

		return addDigit(value / 10, sum + value % 10);

	}

	static void binarySearchRotated(int arr[], int value, int start, int end) {

		int curr = 0;
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] > arr[end]) {
				end = mid;
			} else if (arr[mid] < value) {
				start = mid + 1;
			} else {
				System.out.println("found");
				break;
			}
		}

	}

	static void getunpair(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}
		int val = sum & (-sum);
		int b[] = new int[2];
		for (int i = 0; i < arr.length; i++) {

		}
	}

	static int rem = 0;

	static String binarysumvalue(int a, int b, int i, String w) {
		if (i == 0) {
			return w;
		}
		int val = rem + a % 10 + b % 10;
		if (val == 2) {
			w = '0' + w;
			rem = 1;
		} else if (val == 3) {
			w = '0' + w;
			rem = 1;
		} else if (val == 1) {
			w = '1' + w;
			rem = 0;
		} else if (val == 0) {
			w = '0' + w;
			rem = 0;
		}
		a = a / 10;
		b = b / 10;
		return binarysumvalue(a, b, i - 1, w);

	}

	static int binaryvalue(int pow, int x) {
		if (x == 0) {
			return 1;
		}
		int v = binaryvalue(pow, x / 2);
		if (x % 2 == 0) {
			return v * v;
		} else {
			return x * v * v;
		}
	}

	static void reverse(String word) {
		String val[] = word.split(" ");
		String words = reverseutils(val, val.length - 1, 0, "");
		System.out.println(words);
	}

	private static String reverseutils(String[] val, int length, int i, String string) {
		if (length == 0) {
			return string;
		}
		string = string + val[length] + " ";
		return reverseutils(val, length - 1, i, string);

	}

	static void repetitive(int arr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
		}
	}

	static int pow = 1;

	static int power(int x, int n, int i, int a[]) {
		if (n == i) {
			return pow;
		}
		pow = pow * x;
		if (a[i] == 0) {
			a[i] = power(x, n, i + 1, a);
		}
		return a[i];
	}

	private static void snakeladder(int[] arr) {

		int d = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < i + 6 && j < arr.length; j++) {
				if (arr[j] == 39) {
					System.out.println(d);
					break;
				}
				d++;

			}
		}

	}

	private static int[] getmatrix(int[][] m, int rowend, int coloumnend) {

		int rowstart = 0;
		int columnstart = 0;
		int arr[] = new int[m.length * m.length];
		int k = 0;
		while (rowstart < rowend && columnstart < coloumnend) {
			for (int i = columnstart; i < coloumnend; i++) {
				arr[k++] = m[rowend][i];

			}
			rowend--;
			if (rowend >= rowstart) {
				for (int i = coloumnend; i >= columnstart - 1; i--) {
					arr[k++] = m[rowend][i];
				}
				rowend--;
			} else {
				break;
			}
		}
		return arr;

	}

	static void snakeladder() {

	}

	static void binarysearch(int arr[], int value) {
		int start = 0;
		int end = arr.length - 1;
		int ds = 0;
		int es = 0;
		int flag = 0;
		while (start < end) {
			int m = (start + end) / 2;
			if (arr[m] == value) {
				if (flag == 1) {

					if (arr[m + 1] == value) {
						es = m;
						start = m;
					} else if (arr[m - 1] == value) {
						end = m;
					}
				}
				if (flag == 0) {
					ds = m;
					flag = 1;
					start = m;
				}

				continue;

			} else if (arr[m] > value) {
				end = m;
			} else if (arr[m] < value) {
				start = m;
			}
		}
	}

	static void triplet(int arr[], int value) {
		int i = 0;
		int end = arr.length - 1;
		Arrays.sort(arr);
		int sum = 0;
		while (i < end - 2) {
			int start = i + 1;
			while (start < end) {
				if (arr[i] + arr[start] + arr[end] == value) {
					System.out.println("found");
					start++;
					end--;
				} else if (arr[i] + arr[start] + arr[end] > value) {
					end--;
				} else {
					start++;
				}
			}
			i++;
		}

	}

	static void perimeter(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (b[i][j] == false) {
					DFS(b, m, i, j);
				}
			}
		}

	}

	private static void DFS(boolean[][] b, int[][] m, int i, int j) {
		if (i < m.length && j > m.length) {
			return;
		}
		b[i][j] = true;
		if (safesearch(b, m, i + 1, j)) {
			DFS(b, m, i + 1, j);
		}
		if (safesearch(b, m, i, j + 1)) {
			DFS(b, m, i, j + 1);
		}
		if (safesearch(b, m, i + 1, j - 1)) {
			DFS(b, m, i + 1, j - 1);
		}
		if (safesearch(b, m, i + 1, j + 1)) {
			DFS(b, m, i + 1, j + 1);
		}

	}

	private static boolean safesearch(boolean[][] b, int[][] m, int i, int j) {
		if (i > 0 && i < m.length && j > 0 && j < m.length && b[i][j] == false) {
			return true;
		}
		return false;
	}

	static int rev = 0;

	static void sumvalue(int arr[], int length, int sum, int br[], int c) {
		if (length == -1) {
			return;
		}

		sum = arr[length] + rev + 1;
		if (sum < 9) {
			rev = 0;

		} else {
			rev = sum / 10;
			sum = sum % 10;

		}
		br[c] = sum;
		System.out.print(sum + " ");
		sumvalue(arr, length - 1, sum, br, c + 1);

	}

	public static void main(String[] args) {
		insert("ABC");
		insert("ADA");
		insert("ADB");
		searchValue(".DB");

	}

}