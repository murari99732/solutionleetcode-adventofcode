import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

class NarrayTree {
	int value;
	NarrayTree nt[];

	public NarrayTree(int svalue) {
		nt = new NarrayTree[svalue];
	}

	public NarrayTree() {

	}
}

public class Narray {
	static List<Double> ar;

	static void display(String a, String b, int i, int j) {

		for (int k = i; k < a.length(); k++) {
			print(a.charAt(k), b, "", 0, ar);
		}
	}

	private static void print(char charAt, String b, String string, int i, List<Double> ar2) {

		if (i > b.length()) {
			return;
		}

	}

	public static void main(String[] args) {
		// pancakesorting("3241", 0, 3);
		// System.out.println(ar);
		ar = new ArrayList<Double>();

		time("1234", 0, "1234".length() - 1);
		Collections.sort(ar, Collections.reverseOrder());
		System.out.println(ar);
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i) < 24) {
				System.out.println(ar.get(i));
				break;
			}
		}

	}

	static void time(String word, int start, int end) {
		if (start == end) {
			word = word.substring(0, 2) + "." + word.substring(2, word.length());
			ar.add(Double.valueOf(word));
		} else {
			for (int i = start; i <= end; i++) {
				word = swap(word, start, i);
				time(word, i + 1, end);
				word = swap(word, start, i);
			}
		}

	}

	static void largestcommonfactor(int arr[]) {
		int parent[] = new int[1000];
		Arrays.fill(parent, -1);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 2; j < Math.sqrt(arr[i]); j++) {
				if (arr[i] % j == 0) {
					union(i, j, parent);
					union(i, arr[i] / j, parent);
				}
			}
		}
		int count = 0;
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < parent.length; i++) {
			hashmap.put(parent[i], hashmap.getOrDefault(parent[i], 0) + 1);
		}
	}

	private static void union(int i, int j, int[] parent) {
		int x = find(i, parent);
		int y = find(i, parent);
		if (x != y) {
			parent[y] = x;
		}

	}

	private static int find(int i, int[] parent) {
		if (parent[i] == -1) {
			return i;
		}
		parent[i] = find(parent[i], parent);
		return parent[i];
	}

	static void pancakesorting(String st, int l, int r) {
		if (l > r) {
			return;
		}
		if (l == r) {
			// ar.add(Integer.parseInt(st));
			System.out.print(st + " ");
		}
		for (int i = l; i <= r; i++) {
			String pstr = swap(st, l, i);
			pancakesorting(pstr, i + 1, r);

		}
	}

	static void permutate(String str, int l, int r) {
		if (l == r)
			System.out.print(str + " ");
		else {
			for (int i = l; i <= r; i++) {
				String pstr = swap(str, l, i);
				permutate(pstr, l + 1, r);
				// str = swap(str, l, i);
			}
		}
	}

	private static String swap(String s, int start, int i) {
		char ch[] = s.toCharArray();
		char temp = s.charAt(start);
		ch[start] = s.charAt(i);
		ch[i] = temp;
		return String.valueOf(ch);
	}

	static void rand10() {
		double v = 0;
		while (v < 3.1335208196544630 || v > 3.1335208196544634) {
			Random r = new Random();
			double val = r.nextDouble();
			int st = r.nextInt(4);
			v = val + st;

		}
		System.out.println(v);
	}

	static void minimumcost(int days[], int cost[], int i) {
		for (int j = 0; j < cost.length; i++) {
			int costvalue = minimumd(j, cost);
			minimumcost(days, cost, j + 1);
		}
	}

	private static int minimumd(int j, int[] cost) {

		return 0;
	}

	static void sortparity(int arr[]) {
		int start = 0;
		int mid = 0;
		int end = arr.length - 1;
		while (start < arr.length && end > start) {
			if (arr[start] % 2 == 0) {
				start++;
			} else {
				while (end > start && arr[end] % 2 != 0) {
					end--;
				}
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
				end--;
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static void goat(String st) {
		ArrayList<String> ar = new ArrayList<String>();
		String[] arr = st.split(" ");
		int k = 3;
		for (int i = 0; i < arr.length; i++) {
			String word = arr[i];
			if (word.charAt(0) == 'a' || word.charAt(0) == 'o' || word.charAt(0) == 'i' || word.charAt(0) == 'e'
					|| word.charAt(0) == 'u') {
				int l = k;
				String c = "";
				while (l != 0) {
					c = c + "a";
					l--;
				}
				word = word + "m" + c;
				ar.add(word);
				k++;
			} else {
				String ps = word.substring(1, word.length() - 1) + word.charAt(0);
				int l = k;
				String c = "";
				while (l != 0) {
					c = c + "a";
					l--;
				}
				ps = ps + "m" + c;
				ar.add(ps);
				k++;
			}
		}
		System.out.println(ar);
	}

	static void dailytemperature(int arr[]) {
		int brr[] = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			if (arr[st.peek()] > arr[i]) {
				st.push(i);
			} else if (arr[st.peek()] < arr[i]) {
				while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
					int cp = st.pop();
					int curr = arr[cp];
					int diff = arr[i] - curr;
					brr[cp] = diff;
				}
				st.push(i);
			}
		}

		while (!st.isEmpty()) {
			int cp = st.pop();
			brr[cp] = Integer.MAX_VALUE;
		}
		Arrays.stream(brr).forEach(a -> System.out.print(a + " "));
	}

	static void rotatelist(Node node, int k) {
		Node curr = node;

		while (curr != null && k != 0) {
			curr = curr.left;
			k--;
		}

		Node str = curr.left;
		curr.left = null;
		Node start = str;
		while (start != null) {
			start = start.left;
		}
		start.left = curr;

	}

	static Node newNode(int key) {
		Node node = new Node();
		node.data = key;
		node.left = node.right = null;
		return (node);
	}

	private static int calculate(Node tree, int sum) {
		if (tree == null) {
			return 0;
		}
		sum = sum + tree.data;
		int d = calculate(tree.left, sum);
		int c = calculate(tree.right, sum);
		return d + c;
	}

	static int counter = 0;
	static HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

	static void add(int value) {

		hashmap.put(value, counter++);

	}

	static int find(TreeValue tree, int sum) {
		if (tree == null) {
			return 0;
		}

		// int value = calculate(tree, sum);

		find(tree.left, sum);
		find(tree.right, sum);
		return 0;
	}

	static void palindromepairs(String arr[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			String reverse = reverse(arr[i], 0, arr[i].length());
			map.put(reverse, i);
		}

		for (int i = 0; i < arr.length; i++) {
			String word = arr[i];
			String prefix = word.substring(1, word.length());
			String suffix = word.substring(0, word.length() - 1);
			if (map.containsKey(prefix)) {
				System.out.println(map.get(prefix) + " " + i);
			} else if (map.containsKey(suffix)) {
				System.out.println(map.get(suffix) + " " + i);
			} else if (map.containsKey(word)) {
				System.out.println(map.get(word) + " " + i);
			}
		}

	}

	private static String reverse(String string, int i, int length) {
		String word = "";
		for (int j = string.length() - 1; j >= 0; j--) {
			word = word + string.charAt(j);
		}
		return word;
	}

	static void validparnethes(String word) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		Stack<Integer> se = new Stack<Integer>();
		for (int i = 1; i < word.length(); i++) {
			if (se.isEmpty() && st.isEmpty()) {
				System.out.println("false");
				return;
			}
			if (word.charAt(i) == '(') {
				st.push(i);
			} else if (word.charAt(i) == ')') {
				st.pop();
			} else if (word.charAt(i) == '*') {
				se.push(i);
			} else {
				if (st.isEmpty()) {
					if (word.charAt(i) == ')') {
						se.pop();
					}
				}
			}

		}

		if (st.isEmpty()) {
			System.out.println("true");
		} else if (st.size() == 1 && se.size() == 1) {
			if (word.charAt(st.peek()) == '(') {
				int d = se.peek();
				int e = st.peek();
				if (e > d) {
					System.out.println(false);
					return;
				}
			}
			System.out.println(true);
			return;
		} else {
			System.out.println(false);
			return;
		}

	}

	static void getValue(String input, int i, Set<String> set, ArrayList<String> ar) {
		String val = input.replaceAll("\\D+", "");

	}

	static TreeValue construct(String value, int i) {
		TreeValue tree = null;
		if (value.charAt(i) != '(' || value.charAt(i) != ')') {
			tree = createNode(value.charAt(i));
		}
		if (value.charAt(i) == ')') {
			tree.left = construct(value, i + 1);
		}
		if (value.charAt(i) == '(') {
			tree.right = construct(value, i + 1);
		}
		return tree;

	}

	private static TreeValue createNode(char charAt) {

		return null;
	}

}
