import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class NodeGraph {
	char label;
	boolean isvisited;
	int distance;

	public NodeGraph(char value, int distance) {
		label = value;
		isvisited = false;
		this.distance = distance;
	}
}

class QST {
	public QST(int i, int j) {
		x = i;
		y = j;
	}

	int x;
	int y;
}

class LinkedList {
	int value;
	LinkedList next;
}

class Free {
	Free[] label = new Free[26];
	boolean isword;
}

public class Help {
	public static void main(String[] args) {
		subarraydivided(new int[] { 4, 5, 0, -2, -3, 1 }, 5);
	}

	static void jumpgame(int arr[]) {
		int brr[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			brr[i]=Integer.MAX_VALUE;
		}
		brr[0]=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < i + arr[i] && j <= arr.length; j++) {
				brr[j]=Math.min(brr[i]+1, brr[j]);
			}
		}
	}

	static void subarraydivided(int arr[], int data) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		int sum1 = 0;
		hashmap.put(0, 1);
		int last = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 = sum1 + arr[i];
			int sum = sum1 % data;
			if (hashmap.containsKey(sum)) {
				int value = hashmap.get(sum);
				value = value + last;
				hashmap.put(sum, value);
			} else {
				hashmap.put(sum, 1);
			}
		}
		System.out.println(hashmap);
	}

	static int checkdistance(String s, String w, int l, int m, int max) {
		if (l == 0 && m == 0) {
			return 0;
		}
		if (l == 0) {
			return m;
		}
		if (m == 0) {
			return l;
		}
		if (s.charAt(l) == w.charAt(m)) {
			return checkdistance(s, w, l - 1, m - 1, max);
		}

		int c = checkdistance(s, w, l + 1, m, max);
		int d = checkdistance(s, w, l, m + 1, max);
		return 1 + Math.max(c, d);
	}

	static int maximalsquare(int m[][], int i, int j) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			return 0;
		}
		if (i == 0 || j == 0) {
			return m[i][j];
		}
		int max = 0;
		max = 1 + Math.min(maximalsquare(m, i - 1, j),
				Math.min(maximalsquare(m, i, j - 1), maximalsquare(m, i - 1, j - 1)));
		return max;
	}

	static void firstunique(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		DoubleLinkedList link = createNode(0);
		DoubleLinkedList last = createNode(0);
		link.next = last;
		last.prev = link;
		DoubleLinkedList temp = null;
		for (Entry<Integer, Integer> hm : map.entrySet()) {
			if (hm.getValue() == 1) {
				temp = link.next;
				DoubleLinkedList curr = createNode(hm.getKey());
				link.next = curr;
				curr.next = temp;
				temp.prev = curr;
				curr.prev = link;

			}
		}

	}

	static void checkfirstunique(int arr[], DoubleLinkedList start) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		DoubleLinkedList end = start;
		while (end != null) {
			end = end.next;
		}
		for (Entry<Integer, Integer> hm : map.entrySet()) {
			if (hm.getValue() == 1) {

			}
		}

	}

	private static DoubleLinkedList createNode(int i) {
		DoubleLinkedList linkedList = new DoubleLinkedList();
		linkedList.value = i;
		return linkedList;
	}

	static boolean check(int arr[], int i, TreeValue tree) {
		if (tree == null) {
			return false;
		}

		if (tree.value != arr[i])
			return false;

		if (tree.left == null && tree.right == null && tree.value == arr[i]) {
			return true;
		}
		if (!check(arr, i + 1, tree.left)) {
			return false;
		}
		return check(arr, i + 1, tree.right);
	}

	static void checkvalue(int arr[], int i, TreeValue tree, int brr[]) {
		if (tree == null) {
			return;
		}
		arr[i] = tree.value;
		if (tree.left == null && tree.right == null) {
			if (arr.equals(brr)) {
				System.out.println("true");
			}
			return;
		}
		checkvalue(arr, i + 1, tree.left, brr);
		checkvalue(arr, i + 1, tree.right, brr);

	}

	static int matrixchain(int arr[], int start, int end) {
		if (end < start) {
			return 0;
		}
		int min1 = 0;
		for (int i = start; i < end; i++) {
			int d = matrixchain(arr, start, i + 1);
			int e = matrixchain(arr, i + 1, end);
			int min = d + e + arr[start - 1] * arr[i] * arr[end];
			if (min1 == 0) {
				System.out.println();
			}
		}
		return 1;
	}

	static void checkjewels(String stone, String jewels) {
		HashMap<Character, Integer> hash = new HashMap<>();

		for (int i = 0; i < jewels.length(); i++) {
			hash.put(jewels.charAt(i), hash.getOrDefault(jewels.charAt(i), 0) + 1);
		}
		int sum = 0;
		for (int i = 0; i < stone.length(); i++) {
			sum = sum + hash.get(stone.charAt(i));
		}
		System.out.println(sum);
	}

	static void checkhashmap(String a, String b) {
		HashMap<Character, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < b.length(); i++) {
			hashmap.put(b.charAt(i), hashmap.getOrDefault(b.charAt(i), 0) + 1);
		}
		for (int i = 0; i < a.length(); i++) {
			if (hashmap.containsKey(a.charAt(i))) {
				int value = hashmap.get(a.charAt(i));

				if (value - 1 < 0) {
					System.out.println("cant be formaed");
					break;
				}
				hashmap.put(a.charAt(i), value - 1);
			} else {
				System.out.println("cant be formaed");
				break;
			}
		}
	}

	static int robber(int arr[], int start, boolean take) {
		if (start < arr.length) {

			return 0;
		}
		int max = 0;
		int dc = 0;
		for (int i = 0; i < arr.length; i++) {

			if (take == false)
				max = robber(arr, i + 2, true) + arr[i];
			else

				dc = robber(arr, i, false);
		}
		return Math.max(max, dc);
	}

	static void majorityelement(int arr[]) {
		int max = 1;
		int j = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (j == arr[i]) {
				max++;
			} else {
				max--;
			}
			if (max == 0) {
				j = arr[i];
				max = 1;
			}
		}
		System.out.print(j + " " + max);
	}

	static void greatrelement(int arr[]) {
		int br[] = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < max) {
				st.push(i);
			} else {
				int maxv = 0;
				while (!st.isEmpty() && max > maxv) {
					int curr = st.pop();
					maxv = br[curr];
					br[curr] = arr[i];
				}
				st.push(i);
			}
		}
		while (!st.isEmpty()) {
			br[st.pop()] = -1;
		}
		Arrays.stream(br).forEach(a -> System.out.print(a + " "));
	}

	static void colorhouse(int m[][]) {
		int br[][] = new int[m.length][m.length];
		int min = Integer.MAX_VALUE;
		int value = 0;

		for (int i = 0; i < m.length; i++) {
			br[0][i] = m[0][i];
			if (min > br[0][i]) {
				min = br[0][i];
				value = i;
			}
		}

		for (int i = 1; i < m.length; i++) {

			for (int j = 0; j < m.length; j++) {
				int minx = Integer.MAX_VALUE;
				for (int k = 0; k < m.length; k++) {
					if (j != k) {
						minx = Math.min(br[i - 1][k], minx);
					}

				}
				br[i][j] = m[i][j] + minx;

			}
		}
		for (int i = 0; i < m.length; i++) {
			System.out.print(br[2][i] + " ");
		}

	}

	static boolean checklevel(TreeValue tree, int lvalue, int rvalue) {
		if (tree == null) {
			return false;
		}
		if (tree.left.value == lvalue && tree.right.value == rvalue
				|| tree.left.value == rvalue && tree.right.value == lvalue) {
			return true;
		}
		return checklevel(tree.left, lvalue, rvalue) || checklevel(tree.right, lvalue, rvalue);
	}

	static void print(TreeValue tree, int distance) {
		if (tree == null) {
			return;
		}
		if (tree.value != onevalue && distance == 0) {
			System.out.println(tree.value);
		}
		print(tree.left, distance - 1);
		print(tree.right, distance - 1);

	}

	static int onevalue = 0;

	static int binarytree(TreeValue tree, int distance, int value) {
		if (tree == null) {
			return 0;
		}
		if (tree.left.value == value || tree.right.value == value) {
			onevalue = tree.value;
			return value;
		}
		binarytree(tree.left, distance, value + 1);
		binarytree(tree.right, distance, value + 1);
		return value;
	}

	static boolean straightline(List<QST> list) {
		QST prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (Math.abs(prev.x - list.get(i).x) != Math.abs(prev.y - list.get(i).y)) {
				System.out.println("not a straight line");
				return false;
			}
			prev = list.get(i);
		}
		return true;
	}

	static void getsquare(int value, int start, int end) {
		if (start > value / 2) {
			System.out.println("false");
			return;
		}
		int mid = (start + (value / 2)) / 2;

		if (mid * mid == value) {
			System.out.println(true + " " + mid);
			return;
		} else if (value > mid * mid) {
			getsquare(value, mid + 1, end);
		} else {
			getsquare(value, start, mid);
		}

	}

	static void judge(List<List<Integer>> list) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		HashSet<Integer> hashset = new HashSet<Integer>();
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			hashset.add(list.get(i).get(0));
			hashmap.put(list.get(i).get(1), hashmap.getOrDefault(list.get(i).get(1), 0) + 1);
		}
		for (Entry<Integer, Integer> hm : hashmap.entrySet()) {
			int v = hm.getKey();
			if (!hashset.contains(v)) {
				int c = hm.getValue();
				if (c == list.size() - 1) {
					System.out.println(hm.getKey());
				}
			}
		}

	}

	static void floodfill(int m[][], int value) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				DFSvalue(m, i, j, value);
			}
		}

	}

	private static void DFSvalue(int[][] m, int i, int j, int value) {
		if (i > m.length || i < 0 || j > m.length || j < 0) {
			return;
		}
		if (m[i][j] == '0') {
			m[i][j] = value;
		}
		DFSvalue(m, i + 1, j, value);
		DFSvalue(m, i, j + 1, value);

	}

	static int sum = 0;

	public static void mergeSort(int[] arr, int start, int end) {

		if (start != end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}

	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;

		int[] temp = new int[end - start + 1];

		for (int l = start; l <= mid; l++) {
			for (int m = mid + 1; m < end; m++) {
				if (arr[m] > arr[l]) {
					sum++;
				}
			}
		}

		while ((i <= mid) && (j <= end)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];

			}

		}

		while (i <= mid) {
			temp[k++] = arr[i++];

		}

		while (j <= end) {
			temp[k++] = arr[j++];

		}

		for (i = start; i <= end; i++) {
			arr[i] = temp[i - start];
		}

	}

	static void singlelement(int arr[]) {

		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid >= 0 && mid % 2 == 0 && mid < arr.length && arr[mid] == arr[mid - 1]) {

			} else if (mid >= 0 && mid < arr.length && arr[mid] == arr[mid + 1]) {
				int curr = end - (mid);
				if (curr % 2 != 0) {
					start = mid + 1;
				}
			}
			if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
				System.out.println(mid);
				break;
			}

		}
		System.out.println(arr[start] + " " + arr[end]);

	}

	public static int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		int lo = 0, hi = n - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if ((mid % 2 == 0 && mid + 1 < n && nums[mid] == nums[mid + 1])
					|| (mid % 2 == 1 && mid - 1 >= 0 && nums[mid] == nums[mid - 1]))
				lo = mid + 1;
			else
				hi = mid;

			if (mid - 1 >= 0 && mid + 1 < n && nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
				return nums[mid];
		}
		return nums[lo];
	}

	static void deuplicate(int nums[]) {
		int len = nums.length;
		int low = 0;
		int high = len - 1;

		while (low < nums.length - 1) {
			int mid = (low + high) / 2;
			if ((mid >= 0 && mid < nums.length && nums[mid - 1] == nums[mid] && mid % 2 == 0)
					|| (mid >= 0 && mid < nums.length && nums[mid - 1] == nums[mid] && mid % 2 == 1)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
	}

	static void countdp(int arr[]) {
		int temp[] = new int[arr.length];
		int j = 0;
		temp[j] = 0;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(arr[i], max);
			if (arr[i - 1] > arr[i] || max < arr[i]) {
				temp[i] = temp[j] + 1;
				arr[i] = max;
			} else {
				temp[i] = temp[j];
			}
			j++;
		}
		System.out.println(temp[arr.length - 1]);
	}

	static void count(int arr[]) {
		int i = 0;
		int j = 1;
		int count = 0;
		while (j - i == 1 && j < arr.length) {
			if (arr[i] > arr[j]) {
				count++;
			}
			i++;
			j++;
		}
		System.out.println(count);
	}

	static void removekdigitsvalue(int a[], int k) {

		int c = a[0];
		int sum = a[0];
		for (int i = 1; i < a.length; i++) {
			if (c < a[i]) {
				sum = sum * 10 + a[i];
				c = a[i];
			} else if (c > a[i] && k != 0) {
				sum = sum / 10;
				c = a[i - 2];
				sum = sum * 10 + a[i];
				k--;
			}

		}
		System.out.println(sum);

	}

	static StringBuilder removekdigits(StringBuilder word, int start, int i) {
		if (i == 0) {
			int max = 0;
			word = word.deleteCharAt(start);
			max = Math.max(Integer.parseInt(word.toString()), max);
			return word;
		}
		StringBuilder st = word;
		for (int j = 0; j < word.length() - 1; j++) {
			removekdigits(word, j + 1, i - 1);
		}
		st = word;
		return word;
	}

	static void add(Free root, String word) {
		Free temp = root;
		for (int i = 0; i < word.length(); i++) {
			int value = word.charAt(i) - 'a';
			if (temp.label[value] == null) {
				temp.label[value] = new Free();
			}
			temp = temp.label[value];
		}
		temp.isword = true;
	}

	static void circulararry(int arr[]) {
		int start = 0;
		int sum = 0;
		int st = 0;
		int max = 0;
		while (start < arr.length * 2) {
			sum = sum + arr[start % arr.length];
			if (sum < 0) {
				sum = 0;
				st = start;
			}
			max = Math.max(sum, max);
			start++;
		}
		System.out.println(max);
	}

	static void maximumsum(int arr[]) {
		int start = 0;
		int end = arr.length;
		int sum = 0;
		int send = 0;
		int max = 0;
		while (start < end) {
			sum = sum + arr[start];
			if (sum < 0) {
				sum = 0;
				send = start;
			}
			max = Math.max(sum, max);

			start++;
		}

		System.out.println(max);
	}

	static void evenodd(LinkedList list) {
		LinkedList temp = list;
		LinkedList even = null;
		LinkedList evene = null;
		LinkedList odd = null;
		LinkedList odde = null;
		while (temp != null) {
			if (temp.value % 2 != 0) {
				if (odd == null) {
					odd = temp;
					odde = odd;
				} else {
					odde.next = temp;
					odde = odde.next;

				}
				temp = temp.next;
			} else {
				if (even == null) {
					even = temp;
					evene = even;
				} else {
					evene.next = temp;
					evene = evene.next;

				}
				temp = temp.next;
			}
		}

		odde.next = even;
		evene.next = null;
	}

	static void anagram(String find, String word) {
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		for (int i = 0; i < find.length(); i++) {
			hashmap.put(find.charAt(i), hashmap.getOrDefault(find.charAt(i), 0) + 1);
		}
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (start < word.length() - 1) {
			int diff = Math.abs(end - start) + 1;

			if (diff > find.length()) {
				int value = map.get(word.charAt(end));
				map.put(word.charAt(end), value - 1);
				if (value - 1 == 0) {
					map.remove(word.charAt(end));

				}
				if (diff == find.length()) {
					if (map.equals(hashmap)) {
						System.out.println(true);
					}
				}

				end++;
			} else {
				map.put(word.charAt(start), map.getOrDefault(word.charAt(start), 0) + 1);

				if (map.equals(hashmap)) {
					System.out.println(true);
				}
				start++;
			}
			if (diff == find.length()) {
				if (map.equals(hashmap)) {
					System.out.println(true);
				}
			}
		}
	}

	static void stockmin(int arr[]) {
		Stack<QST> stack = new Stack<QST>();
		int max = arr[0];
		stack.add(new QST(arr[0], 1));
		for (int i = 1; i < arr.length; i++) {
			if (max > arr[i]) {
				stack.push(new QST(arr[i], 1));
			} else {
				int min = 0;
				int temp = 0;
				while (!stack.isEmpty() && min < max) {
					QST curr = stack.pop();
					min = curr.x;
					temp = temp + curr.y;
				}
				max = arr[i];
				System.out.println(temp);
				stack.push(new QST(arr[i], temp));

			}
		}
		stack.forEach(a -> System.out.print(a.x + " " + a.y + " "));
	}

	static void nextgreaterelement(int arr[]) {
		int max = arr[0];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		int br[] = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			if (max > arr[i]) {
				st.push(i);
			} else {
				int min = 0;
				while (!st.isEmpty() && max > min) {
					int t = st.pop();
					min = arr[i];
					br[t] = arr[i];
				}
				max = min;
				st.push(i);
			}
		}
		for (int i = 0; i < br.length; i++) {
			if (br[i] == 0) {
				br[i] = -1;
			}
		}
		Arrays.stream(br).forEach(a -> System.out.print(a + " "));
	}

	static void stock(int arr[]) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		for (int i = 1; i < arr.length; i++) {
			int c = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					c++;
				}
			}
			hm.put(i, c);
		}

	}

	static void kthsmallest(TreeValue tree, int k) {
		if (tree == null) {
			return;
		}

		kthsmallest(tree.left, k - 1);
		if (k == 0) {
			System.out.println(tree.value);
			return;
		}
		kthsmallest(tree.right, k - 1);
	}

	static void countsquare(int m[][]) {
		if (m.length == 0) {
			return;
		}

		int sum = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				int count = count(m, i, j);
				sum = sum + count;
			}
		}
	}

	private static int count(int[][] m, int i, int j) {
		if (i < 0 || j < 0 || j > m.length || i > m.length || m[i][j] == 0) {
			return 0;
		}
		int d = 1 + Math.min(count(m, i - 1, j), Math.min(count(m, i - 1, j - 1), count(m, i, j - 1)));
		return d;
	}

	static void countmax(int m[][]) {
		if (m.length == 0) {
			return;
		}
		int g[][] = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				int max = minvalue(m, i, j, g);
			}
		}
	}

	private static int minvalue(int[][] m, int i, int j, int g[][]) {
		if (i <= 0 || j <= 0 || m[0].length == 1 || m[i][j] == 0)
			return 0;
		if (g[i][j] == 0) {

			return 1 + Math.min(minvalue(m, i - 1, j, g),
					Math.min(minvalue(m, i, j - 1, g), minvalue(m, i - 1, j - 1, g)));
		}
		return g[i][j];
	}

	static void interval(List<QST> list, List<QST> secondlist) {

		List<QST> store = new ArrayList<>();
		QST prev = null;
		int i = 0;
		while (list != null && secondlist != null) {
			QST fcurr = list.get(i);
			QST scurr = secondlist.get(i);
			QST st = null;

			if (fcurr.x > scurr.x) {
				st.x = scurr.x;
			} else {
				st.x = fcurr.x;
			}
			if (fcurr.y > scurr.x) {
				st.y = fcurr.y;
			} else {
				st.y = scurr.y;
			}
			QST q = check(st, prev);
			store.add(q);
			prev = st;
			i++;
		}

	}

	private static QST check(QST st, QST prev) {
		QST curr = null;
		if (prev == null) {
			return st;
		} else {
			if (st.x > prev.x) {
				curr.x = prev.x;
			} else {
				curr.x = st.x;
			}
			if (st.y > prev.y) {
				curr.y = st.y;

			} else {
				curr.y = prev.y;
			}
		}
		return curr;

	}

	static void uncrossedline(int arr[], int sarr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		HashMap<Integer, Integer> secondmap = new HashMap<>();
		for (int i = 0, j = 0; i < arr.length || j < arr.length; i++, j++) {
			hashmap.put(arr[i], i);
			secondmap.put(sarr[j], j);
		}
		int max = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> mp : hashmap.entrySet()) {
			int value = mp.getKey();
			int loc = mp.getValue();
			if (secondmap.containsKey(value)) {
				int d = secondmap.get(value);
				if (max < d && d > loc) {
					max = d;
					ar.add(value);
				}
			} else {
				ar.add(value);
			}

		}
		System.out.println(ar);

	}

	static void minimmumsum(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		int sum = 0;
		int i = 0;

	}

	static void continigious(int arr[]) {

		int b[] = new int[arr.length];
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] == 0) {
					b[i] = b[j] + 1;
				} else {
					b[i] = b[j];
				}
				if (b[i] > max) {
					max = b[i];
					System.out.println(arr[j]);
				}

			}
		}
		System.out.println(b[arr.length - 1]);

	}

//	static void team(List<List<Integer>> list) {
//
//		int[] flag = new int[3];
//		Queue<Integer> q = new <Integer>();
//		q.add(0);
//		ArrayList<Integer> ar = new ArrayList<Integer>();
//		while (!q.isEmpty()) {
//			int curr = q.poll();
//
//			Iterator<Integer> it = list.get(curr).iterator();
//			while (it.hasNext()) {
//				int b = it.next();
//				if (flag[b] == 0) {
//					q.add(b);
//					flag[b] = -flag[curr];
//				} else {
//					System.out.println("true");
//					return;
//				}
//
//			}
//
//		}
//
//	}
//
//	static void kclosest(QST q, List<QST> list, int value) {
//
//		PriorityQueue<Integer> pr = new PriorityQueue<Integer>(list.size(), Collections.reverseOrder());
//		for (int i = 0; i < list.size(); i++) {
//			QST curr = list.get(i);
//			pr.add((int) Math.sqrt(curr.y * curr.y + curr.x * curr.x));
//		}
//		while (!pr.isEmpty() && value != 0) {
//			System.out.println(pr.poll());
//			value--;
//		}
//
//	}
//
//	static String reverse(String s, int i, int j) {
//		if (i == j) {
//			return s;
//		}
//		s = swap(s, i, j);
//		return reverse(s, i + 1, j - 1);
//	}
//
//	static int longestCommonsequnce(String s, String t, int l, int v, int count) {
//		if (l == 0 || v == 0) {
//			return count;
//		}
//		int p = 0;
//		if (s.charAt(v - 1) == t.charAt(l - 1)) {
//
//			p = longestCommonsequnce(s, t, l - 1, v - 1, count + 1);
//		}
//		return Math.max(longestCommonsequnce(s, t, l - 1, v, count),
//				Math.max(longestCommonsequnce(s, t, l, v, count), p));
//	}
//
//	static void divisible(int arr[], List<Integer> list, int start, int end) {
//		for (int i = end; i < arr.length; i++) {
//			if (arr[i] % arr[start] == 0) {
//				list.add(arr[i]);
//				divisible(arr, list, end, start + 1);
//				list.add(arr[i]);
//			}
//		}
//
//	}
//
//	static void permutate(String s, int l, int r) {
//		if (l == r) {
//			System.out.println(s);
//
//		}
//		for (int i = l; i <= r; i++) {
//			s = swap(s, l, i);
//
//			permutate(s, i + 1, r);
//			s = swap(s, l, i);
//		}
//	}
//
//	private static String swap(String a, int i, int j) {
//		char temp;
//		char[] charArray = a.toCharArray();
//		temp = charArray[i - 1];
//		charArray[i - 1] = charArray[j];
//		charArray[j] = temp;
//		return String.valueOf(charArray);
//	}
//
//	static void subsequnce(int arr[], List<Integer> list, List<List<Integer>> store, int i) {
//		if (i == arr.length) {
//			store.add(list);
//			return;
//		}
//		list.add(arr[i]);
//		subsequnce(arr, list, store, i + 1);
//		list.add(arr[arr.length - 2]);
//		subsequnce(arr, list, store, i + 1);
//
//	}
//
//	static boolean powertwo(int value, int i) {
//		if (i == value || value % i != 0) {
//			return false;
//		}
//
//		if (i * i == value) {
//			return true;
//		}
//		return powertwo(value, i + 1);
//	}
//
//	static boolean subsequnce(String value, String word, int vl, int wl, String d) {
//		if (vl == 0 && wl != 0) {
//			return false;
//		}
//		if (word.length() - 1 == d.length() || wl == 0) {
//			return true;
//		}
//
//		if (word.charAt(wl) != 0 && value.charAt(wl) != 0 && value.charAt(vl) == word.charAt(wl)) {
//			return subsequnce(value, word, vl - 1, wl - 1, d);
//		}
//		return subsequnce(value, word, vl - 1, wl, d);
//
//	}
//
//	static void getvalue(int arr[], int val) {
//		int start = 0;
//		int end = arr.length - 1;
//		int d = 0;
//		while (start < end) {
//			int m = (start + end) / 2;
//			if (arr[m] < val) {
//				start = m;
//			} else if (arr[m] > val) {
//				end = m - 1;
//			} else {
//				System.out.println(m + " ");
//				break;
//			}
//			d = m;
//		}
//		System.out.println(d);
//	}
//
//	static void sort(int arr[]) {
//
//		int i = 0;
//		int end = arr.length - 1;
//		int mid = 0;
//		while (mid < end) {
//
//			if (arr[mid] == 0) {
//
//				if (arr[i] != 0) {
//					int temp = arr[i];
//					arr[i] = arr[mid];
//					arr[mid] = temp;
//				}
//				i++;
//				mid++;
//			}
//			if (arr[mid] == 1) {
//				mid++;
//			}
//			if (arr[mid] == 2) {
//				if (arr[end] != 2) {
//					int temp = arr[end];
//					arr[end] = arr[mid];
//					arr[mid] = temp;
//				}
//				end--;
//				mid++;
//			}
//		}
//		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
//	}
//
//	LinkedList<NodeGraph>[] list;
//	int v = 0;
//
//	public Help() {
//		list = new LinkedList[10];
//		for (int i = 0; i < 10; i++) {
//			list[i] = new LinkedList<NodeGraph>();
//		}
//		v = 0;
//	}
//
//	static List<List<Integer>> listvalue = new ArrayList<List<Integer>>();
//
//	static void subset(int arr[], int i, List<Integer> list) {
//		if (i == arr.length) {
//			listvalue.add(list);
//			return;
//		}
//		list.add(arr[i]);
//		subset(arr, i + 1, list);
//		list.add(arr[arr.length - 1]);
//		subset(arr, i + 1, list);
//	}
//
//	static int longestsubsequence(int arr[], int list) {
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (arr[i] % longestsubsequence(arr, list) == 0) {
//
//			} else {
//
//			}
//		}
//		return 0;
//	}
//
//	void addEdge(int distance, char c) {
//		list[v++].add(new NodeGraph(c, distance));
//	}
//
//	void findcheap() {
//
//		boolean b[] = new boolean[10];
//		int key[] = new int[v];
//		int parent[] = new int[v];
//		for (int i = 0; i < v; i++) {
//			key[i] = Integer.MAX_VALUE;
//		}
//		key[0] = 0;
//		parent[0] = -1;
//		for (int i = 0; i < v; i++) {
//			int min = getminvalue(key, i, b);
//			b[min] = true;
//			Iterator<NodeGraph> it = list[min].iterator();
//			while (it.hasNext()) {
//				NodeGraph curr = it.next();
//				if (b[curr.label] == false) {
//					int distance = curr.distance + list[min].get(min).distance;
//					if (key[curr.distance] < distance) {
//						key[curr.distance] = distance;
//
//					}
//				}
//			}
//		}
//
//	}
//
//	private int getminvalue(int[] key, int i, boolean b[]) {
//		int max = Integer.MAX_VALUE;
//		int min = 0;
//		for (int j = 0; j < v; j++) {
//			if (b[i] == false && key[i] < max) {
//				max = key[i];
//				min = i;
//			}
//		}
//		return min;
//	}

}