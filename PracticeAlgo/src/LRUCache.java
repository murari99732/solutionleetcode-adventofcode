import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;

class Cache {
	int value;
	String data;

	public Cache() {
	}

	public Cache(int value, String data) {
		super();
		this.value = value;
		this.data = data;
	}

}

class Shift {
	int x;
	int y;
}

public class LRUCache {

	static HashMap<Integer, Cache> map = new HashMap<Integer, Cache>();
	static Deque<Cache> queue = new LinkedList<Cache>();

	

	static List<String> list = new ArrayList<String>();
	static List<String> slist = new ArrayList<String>();

	static String parantheise(String word, int j, int end) {
		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == '-' || word.charAt(i) == '+') {
				list.add(parantheise(word, j, i));
				slist.add(parantheise(word, i + 1, word.length() - 1));
				for (String k : list) {
					for (String s : slist) {

					}
				}

			}
		}
		return null;
	}

	static int d = 0;

	static void smaller(int arr[]) {
		TreeValue tree = new TreeValue();
		tree.value = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			insert(tree, i);
		}
	}
	public static void main(String[] args) {
		System.out.println(longestsubsequence("AEBCEFD", "AABCEFGH", 7, 8, 0));
	}
	static int longestsubsequence(String st, String pt, int i, int j, int count) {
		if (i == 0 || j == 0) {
			return count;
		}
		if (st.charAt(i - 1) == pt.charAt(j - 1)) {
			return longestsubsequence(st, pt, i - 1, j - 1, count + 1);
		}
		return Math.max(count,Math.max(longestsubsequence(st, pt, i - 1, j, 0), longestsubsequence(st, pt, i, j - 1, 0)));
	}

	private static void insert(TreeValue tree, int i) {
		boolean isconnected = false;
		TreeValue curr = new TreeValue();
		curr.value = i;
		int val = 0;
		while (!isconnected) {
			if (curr.value < tree.value) {
				tree.height++;
				if (tree.left != null) {
					TreeValue ct = tree.left;
					tree.left = curr;
					curr.left = ct;
					isconnected = true;
				}
			} else {
				val = tree.right.height;

			}
		}
	}

	static void value(int value) {
		while (value > 9) {
			int d = value;
			int sum = 0;
			while (d != 0) {
				int c = d % 10;
				sum = sum + c * c;
				d = d / 10;
			}
			if (sum == 1) {
				System.out.println(true);
				return;
			}
			value = sum;
		}
		System.out.println(false);
	}

	static void createvalue(int arr[]) {
		TreeValue tree = new TreeValue();
		tree = createNode(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {
			int count = insertnode(tree, arr[i]);
		}
	}

	private static int insertnode(TreeValue tree, int i) {
		int count = 0;
		boolean isconnected = false;
		TreeValue curr = new TreeValue();
		curr = createNode(i);
		while (tree != null) {
			if (tree.value < curr.value) {
				tree.value++;
				tree.left = curr;
				isconnected = true;

			} else {
				count = tree.value;

				tree.right = curr;
				isconnected = true;
			}
		}
		return 0;
	}

	static TreeValue smallernumber(int arr[], TreeValue tree, int i, int height) {
		if (i == arr.length - 1) {
			return tree;
		}
		if (arr[i] > arr[i + 1]) {
			tree.left.value = tree.value + 1;

		}
		if (arr[i] < arr[i + 1]) {
			tree.right = smallernumber(arr, tree.right, i + 1, height);
		}
		return tree;
	}

	static boolean isfunction(int value) {
		if (value % 2 != 0) {
			return false;
		}
		if (value % 2 == 0) {
			value = value / 2;
		}
		if (value == 2 || value == 1) {
			return true;
		}
		return isfunction(value);

	}

	static void convert(String word, int i, List<String> list) {
		if (i == word.length()) {
			return;
		}
		char val = 0;
		if (word.charAt(i) > 64 && word.charAt(i) < 92) {
			int valval = (word.charAt(i) - 64);
			val = (char) (96 + valval);
		} else if (word.charAt(i) < 98 && word.charAt(i) < 122) {
			int valval = (word.charAt(i) - 96);
			val = (char) (64 + valval);
		}
		String st = "";
		if (i == 0) {
			st = val + word.substring(1, word.length());
		} else if (word.length() == i) {
			st = word.substring(0, word.length() - 1) + val;
		} else {
			st = word.substring(0, i - 1) + val + word.substring(i + 1, word.length());
		}
		list.add(st);
		convert(word, i + 1, list);

	}

	static void longestvalid(String w) {
		Stack<Character> st = new Stack<Character>();
		int i = 0;
		int count = 0;
		int max = 0;
		while (i < w.length()) {
			if (w.charAt(i) == ')') {
				if (!st.isEmpty()) {
					count = count + 2;
					max = Math.max(count, max);
					st.pop();
				} else {
					max = Math.max(count, max);
					count = 0;

				}
			} else {
				st.push('(');
			}
			i++;
		}
		System.out.println(max);
	}

	static int max = 0;
	static HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	static String vc = "";

	static boolean concantedword(String word, int i, String value, String svalue, boolean flag, HashSet<String> set) {
		if (i > word.length()) {
			return false;
		}
		if (vc.length() == word.length()) {
			return true;
		}
		String w = value + word.charAt(i);
		vc = vc + word.charAt(i);
		if (set.contains(w)) {
			word = word.substring(i, word.length());
		}
		return concantedword(word, i + 1, value, svalue, flag, set);

	}

	static void weekdays(int days, int month, int year) {
		int yearvalue = year - 1971;
		int value = yearvalue / 4;
		int svalue = yearvalue - value;
		int week = 0;
		if (month > 2) {
			getdays(year, month);
			int day = getdaysValue(month, days);
			week = value * 366 + svalue * 365 + day;
		} else {
			int day = getdaysValue(month, days);
			week = value * 366 + svalue * 365 + day;
		}
		int getval = week % 7;
		System.out.println((getval + 5) % 7);
	}

	private static int getdaysValue(int month, int days) {

		int sum = 0;
		for (Entry<Integer, Integer> hm : hashMap.entrySet()) {
			if (hm.getKey() <= month) {
				sum = sum + hm.getValue();
			}
		}
		return sum + days;

	}

	static void getdays(int year, int month) {
		if (year % 4 == 0) {
			hashMap.put(2, 29);

		} else {
			hashMap.put(2, 28);
		}
	}

	static int maximumBSt(TreeValue tree, int width, Stack<Integer> st) {
		if (tree == null) {
			return 0;
		}
		st.push(tree.value);
		if (tree.left == null && tree.right == null && max < width) {
			max = width;
			return max;
		}
		return Math.max(maximumBSt(tree.left, width + tree.value, st), maximumBSt(tree.right, width + tree.value, st));
	}

	static void insertion(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static int minimumdp(int m[][], int i, int j, int value, boolean b[][], HashMap<String, Integer> hashmap) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			return Integer.MAX_VALUE;
		}
		if (i == m.length - 1 && j == m.length - 1) {
			return m[i][j];
		}
		int c = 0;
		String s = i + "#" + j;
		if (hashmap.containsKey(s)) {
			return hashmap.get(s);
		}
		if (i >= 0 && i < m.length && j >= 0 && j < m.length) {
			c = m[i][j] + Math.min(minimumpath(m, i + 1, j, value, b), minimumpath(m, i, j + 1, value, b));
		} else if (i >= 0 && i < m.length) {
			c = m[i][j] + minimumpath(m, i, j + 1, value + m[i][j], b);
		} else if (j >= 0 && j < m.length) {
			c = m[i][j] + minimumpath(m, i + 1, j, value + m[i][j], b);
		}
		return c;

	}

	static int minimumpath(int m[][], int i, int j, int value, boolean b[][]) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			return Integer.MAX_VALUE;
		}
		if (i == m.length - 1 && j == m.length - 1) {
			return value;
		}
		int c = 0;
		if (i >= 0 && i < m.length && j >= 0 && j < m.length) {
			c = Math.min(minimumpath(m, i + 1, j, value, b), minimumpath(m, i, j + 1, value + m[i][j], b));
		} else if (i >= 0 && i < m.length) {
			c = minimumpath(m, i, j + 1, value + m[i][j], b);
		} else if (j >= 0 && j < m.length) {
			c = minimumpath(m, i + 1, j, value + m[i][j], b);
		}
		return c;

	}

	static int uniquepaths(int m[][], int i, int j, int arr[][]) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			return 0;
		}
		if (i == m.length - 1 && j == m.length - 1) {
			return 1;
		}
		if (arr[i][j] == 0) {
			int d = uniquepaths(m, i + 1, j, arr);
			int e = uniquepaths(m, i, j + 1, arr);
			arr[i][j] = d + e;
		}
		return arr[i][j];
	}

	static int eggproblem(int floor, int egg, int start) {
		if (start > floor) {
			return Integer.MAX_VALUE;
		}
		if (egg == 0) {
			return Integer.MAX_VALUE;
		}
		int max = 0;
		for (int i = start; i <= floor; i++)
			max = Math.max(eggproblem(floor, egg - 1, i - 1), eggproblem(floor, egg, floor - i));
		return max;

	}

	static void peek(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < arr[mid + 1] && arr[mid - 1] < arr[mid]) {
				System.out.println();
			} else {

			}
		}
	}

	static void lastweight(int arr[]) {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			pr.add(arr[i]);
		}
		while (pr.size() != 1) {
			int d = pr.poll();
			int e = pr.poll();
			if (d > e) {
				pr.add(d - e);
			} else if (d < e) {
				pr.add(e - d);
			}
		}
		System.out.println(pr.peek());
	}

	static void shiftvalue(String word, List<Shift> shift) {
		for (int i = 0; i < shift.size(); i++) {
			int x = shift.get(i).x;
			int y = shift.get(i).y;
			if (x == 0) {
				while (y != 0) {
					word = shiftdigit(-1, word);
					y--;
				}
			} else {
				while (y != 0) {
					word = shiftdigit(-1, word);
					y--;
				}

			}

		}
		System.out.println(word);
	}

	private static String shiftdigit(int i, String word) {
		if (i == -1) {
			char c = word.charAt(0);
			String cs = word.substring(1, word.length());
			word = cs + c;
		} else {
			char c = word.charAt(word.length());
			String cs = word.substring(0, word.length() - 1);
			word = c + cs;
		}
		return word;
	}

	static int minimum(int value, int dis) {
		if (value < 0) {
			return Integer.MAX_VALUE;
		}
		if (value == 1) {
			return dis;
		}
		int d = Math.min(minimum(value - 1, dis + 1),
				Math.min(minimum(value - 2, dis + 1), minimum(value - 3, dis + 1)));
		return d;
	}

	static int minimumvalue(int value) {
		if (value == 0) {
			return Integer.MAX_VALUE;
		}
		value = value - 1;
		int d = 0;
		if (value % 3 == 0) {
			d = minimumvalue(value / 3);
		}
		int e = 0;
		if (value % 2 == 0) {
			e = minimumvalue(value / 2);
		}
		return 1 + Math.min(d, e);
	}

	static void island(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				b[i][j] = false;
			}
		}
		int k = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (b[i][j] == false) {
					if (m[i][j] == 1 && DFS(m, i, j, b)) {
						k++;
					}
				}
			}
		}
	}

	private static boolean DFS(int[][] m, int i, int j, boolean[][] b) {
		if (i < 0 || i > m.length || j > 0 || j > m.length || b[i][j] == true || m[i][j] == 0)
			return false;

		b[i][j] = true;
		boolean bc = DFS(m, i + 1, j, b) || DFS(m, i, j + 1, b);
		return bc;
	}

	static TreeValue preorderleft(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		TreeValue tree = createNode(arr[start]);
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] > tree.value) {
				break;
			}
		}
		tree.left = preorderleft(arr, start, i);
		tree.right = preorderleft(arr, i + 1, end);
		return tree;

	}

	private static TreeValue createNode(int i) {
		TreeValue tree = new TreeValue();
		tree.value = i;
		return tree;
	}

	static void leftmostcoloumn(int board[][]) {
		int start = 0;
		int column = 0;

		for (int j = board.length - 1; j >= 0; j--) {
			if (board[0][j] != 0) {
				column = j;
			}
		}
		for (int i = 1; i < board.length; i++) {
			for (int j = column; j >= 0; j--) {
				if (board[i][j] != 0 && column > j) {
					column = j;
				}
			}
		}
		System.out.println(column);

	}

	static void subarray(int arr[], int value) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		int sum = 0;
		hashmap.put(0, 1);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (hashmap.containsKey(Math.abs(sum - value))) {
				int val = hashmap.get(Math.abs(sum - value));
				count++;
				hashmap.put(Math.abs(sum - value), value + 1);
			} else {
				hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);
			}
		}

	}

	static int maximumstock(int arr[], int i, boolean issell) {
		if (i == arr.length) {
			return 0;
		}
		int maxv = 0;
		for (int j = 0; j < arr.length; j++) {
			if (issell == false) {
				int max = maximumstock(arr, j + 1, true) - arr[i];
				int min = maximumstock(arr, j, false);
				maxv = Math.max(max, min);
			} else {
				int max = maximumstock(arr, j + 1, false) + arr[i];
				int min = maximumstock(arr, j, true);
				maxv = Math.max(max, min);
			}
		}
		return maxv;
	}

	static void putEntryIntoCache(int value, String data) {
		if (map.containsKey(value)) {
			queue.remove(new Cache(value, data));
			queue.addFirst(new Cache(value, data));

		} else {
			map.put(value, new Cache(value, data));
			if (queue.size() < 3) {
				queue.addFirst(new Cache(value, data));
			} else if (queue.size() == 3) {
				queue.removeLast();
				queue.addFirst(new Cache(value, data));
			}

		}
	}

	static String getFromCache(int value) {
		if (map.containsKey(value)) {
			queue.remove(map.get(value));
			queue.addFirst(map.get(value));
			return map.get(value).data;
		} else

			return null;
	}

}
