package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeRecursion {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("MICRO");
		set.add("SOFT");
		set.add("HIRI");
		set.add("ING");
		set.add("MICROSOFT");

		coins(new int[] { 1, 2, 3, 5 }, "", 0);
	}

	static void coins(int arr[], String ans, int value) {
		if (value == 12) {
			System.out.println(ans);
			return;
		}
		if(value>12)
		{
			return;
		}

		for (int j = 0; j < arr.length; j++) {
			value = arr[j] + value;
			coins(arr, ans+arr[j], value);
			value=value-arr[j];
		

		}
	}

	static void duplicate(String a, String ans, int i, int d) {
		if (d == 3) {
			if (i == 2) {
				System.out.println(ans);
			}
			return;
		}
		duplicate(a, ans + a.charAt(i), i + 1, d + 1);
		duplicate(a, ans + "-", i, d + 1);
	}

	static void kswap(int k, int arr[], int i, int j) {
		if (k == 10) {
			for (int l = 0; l < arr.length; l++) {
				System.out.print(arr[l] + " ");
			}
			System.out.println();
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		kswap(k + 1, arr, i + 1, j - 1);
	}

	static void combi(int i, int j, String ans) {
		if (i == 4) {
			System.out.println(ans);
			return;
		}
		combi(i + 1, j + 1, ans + j);
		combi(i + 1, j, ans + "-");
	}

	static void permutationval(int arr[], int i, int d) {
		if (i >= d) {

		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 0) {
				arr[j] = d;
				permutationval(arr, i, d + 1);
				arr[j] = 0;
			}
		}
	}

	static void combination(int i, int d, String ans) {
		if (i >= 4) {
			if (d == 2)
				System.out.println(ans);
			return;
		}
		combination(i + 1, d + 1, ans + d);
		combination(i + 1, d, ans + "-");

	}

	static void printpermutation(int arr[], int i, int d) {
		if (i < d) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");

			}
			System.out.println();
			return;
		}
		for (int j = 0; j < 4; j++) {
			if (arr[j] == 0) {
				arr[j] = d;
				printpermutation(arr, i, d + 1);
				arr[j] = 0;
			}
		}

	}

	static void wordbreakpro(String pattern, Set<String> set, String ans) {
		if (pattern.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < pattern.length(); i++) {
			String w = pattern.substring(0, i + 1);
			if (set.contains(w))
				wordbreakpro(pattern.substring(i + 1), set, ans + w + " ");
		}
	}

	static void patternmatching(String pattern, String word, HashMap<Character, String> map) {
		if (pattern.length() == 0 && word.length() == 0) {
			System.out.println(map);

			return;
		}
		if (word.length() == 0) {
			return;
		}
		if (pattern.length() == 0) {
			return;
		}

		char c = pattern.charAt(0);
		if (!map.containsKey(c)) {
			for (int i = 0; i < word.length(); i++) {
				String bc = word.substring(0, i + 1);
				String d = pattern.substring(1);
				map.put(c, bc);
				patternmatching(d, word.substring(i + 1), map);
				map.remove(c);
			}
		} else {
			String dc = map.get(c);
			if (word.contains(dc)) {
				String fc = word.substring(dc.length());
				patternmatching(pattern.substring(1), fc, map);
			}
		}
	}

	static void kequalsubset(int arr[], int i, ArrayList<ArrayList<Integer>> list) {
		if (arr.length == i) {

			return;
		}

		for (int j = 0; j < list.size(); j++) {
			list.get(j).add(arr[i]);
			kequalsubset(arr, i + 1, list);
			list.get(j).remove(list.get(j).size() - 1);
		}
	}

	static void palindromk(String ab, String ac) {
		if (ab.length() == 0) {
			System.out.println(ac);
			return;
		}
		for (int j = 0; j < ab.length(); j++) {
			String a = ab.substring(0, j + 1);
			String b = ab.substring(j + 1);
			if (isPalindrome(a)) {
				palindromk(b, ac + a + " ");
			}
		}
	}

	static void pratitionksubset(String a, int i, ArrayList<ArrayList<Character>> ar) {
		if (a.length() == i) {
			System.out.println(ar);
			return;
		}

		for (int j = 0; j < ar.size(); j++) {
			ar.get(j).add(a.charAt(i));
			pratitionksubset(a, i + 1, ar);
			ar.get(j).remove(ar.get(j).size() - 1);

		}
	}

	static void enemypairing(String a, int i, String ans, boolean b[]) {
		if (i == a.length()) {
			System.out.println(ans);
			return;
		}
		if (b[i] == false) {
			b[i] = true;
			enemypairing(a, i + 1, ans + "{" + a.charAt(i) + "}", b);
			for (int j = i + 1; j < a.length(); j++) {
				if (b[j] == false) {
					b[j] = true;
					enemypairing(a, i + 1, ans + a.charAt(i) + "->" + a.charAt(j), b);
					b[j] = false;
				}
			}
			b[i] = false;
		} else {
			enemypairing(a, i + 1, ans, b);
		}
	}

	static void printabb(String abc, int i, String ans, int count) {
		if (i == abc.length()) {
			System.out.println(ans + count);
			return;
		}
		char c = abc.charAt(i);
		if (count > 0) {
			printabb(abc, i + 1, ans + count + c, 0);
			printabb(abc, i + 1, ans, count + 1);
		} else {
			printabb(abc, i + 1, ans + c, 0);
			printabb(abc, i + 1, ans, count + 1);
		}
	}

	static void printsubsequnce(int arr[], int i, String ans) {
		if (arr.length == i) {
			System.out.println(ans);
			return;
		}
		printsubsequnce(arr, i + 1, ans + arr[i]);
		printsubsequnce(arr, i + 1, ans);
	}

	static ArrayList<Integer> recursionarray(int arr[], int i, ArrayList<Integer> ar) {
		if (arr.length == i) {
			return ar;
		}
		if (arr[i] == 2) {
			ar.add(i);
		}
		ArrayList<Integer> br = recursionarray(arr, i + 1, ar);

		return br;

	}

	static void tugwar(int arr[], int i, ArrayList<Integer> ar, ArrayList<Integer> br) {
		if (arr.length == i) {
			long count = ar.stream().count();
			long sg = br.stream().count();
			if (count - sg == 0 || count - sg == 1 || count - sg == -1) {
				int add = ar.stream().collect(Collectors.summingInt(Integer::intValue));
				int bdd = br.stream().collect(Collectors.summingInt(Integer::intValue));
				System.out.println(add + " " + bdd + " ar-> " + ar + "  br->" + br);
			}
			return;

		}
		ar.add(arr[i]);
		tugwar(arr, i + 1, ar, br);
		ar.remove(ar.size() - 1);
		br.add(arr[i]);
		tugwar(arr, i + 1, ar, br);
		br.remove(br.size() - 1);
	}

	static void wordebreak(String pattern, String match, Set<String> set) {
		if (match.length() == 0) {
			System.out.println(pattern);
			return;
		}
		for (int i = 0; i < match.length(); i++) {
			String l = match.substring(0, i + 1);
			String r = match.substring(i + 1);
			if (set.contains(l)) {
				wordebreak(pattern + l + " ", r, set);
			}
		}
	}

	static void patternmatching(String a, HashMap<Character, String> map, String word) {
		if (a.length() == 0) {
			System.out.println(map);
			return;
		}
		char c = a.charAt(0);
		if (!map.containsKey(c)) {
			for (int k = 0; k < word.length(); k++) {

				String wc = word.substring(0, k + 1);
				map.put(c, wc);
				patternmatching(a.substring(1), map, word.substring(k + 1));
				map.remove(c);

			}

		} else {
			String bc = map.get(c);
			if (word.contains(bc)) {
				patternmatching(a.substring(1), map, word.substring(bc.length() + 1));
			} else {
				return;
			}
		}

	}

	static int sum(List<Integer> list) {
		return list.stream().collect(Collectors.summingInt(Integer::intValue));
	}

	static void ksubset(int arr[], int i, int sum, List<List<Integer>> list) {
		if (i == arr.length - 1) {
			long d = list.stream().filter(ab -> ab.size() != 0).count();
			if (d > 2) {
				List<Integer> collect = list.stream().filter(ab -> ab.size() != 0).map(ab -> sum(ab))
						.collect(Collectors.toList());
				int v = collect.stream().collect(Collectors.summingInt(Integer::intValue));
				if (v > 12) {
					System.out.println(list);
				}
			}
			return;
		}

		for (int j = 0; j < list.size() - 1; j++) {
			list.get(j).add(arr[i]);
			ksubset(arr, i + 1, sum, list);
			list.get(j).remove(list.get(j).size() - 1);
		}
	}

	static void palindromic(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < a.length(); i++) {
			String bc = a.substring(0, i + 1);
			if (isPalindrome(bc)) {

				palindromic(a.substring(i + 1), ans + bc + " ");
			}
		}
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

	static void palidromic(String a, String ans) {
		if (0 == a.length()) {
			System.out.println(ans);
			return;
		}
		palidromic(a.substring(1), ans + a.charAt(0));
		palidromic(a.substring(1), ans);
	}

	static void badshah(String a, int i, List<List<String>> list) {
		if (a.length() == i) {
			long ba = list.stream().filter(ab -> ab.size() != 0).count();
			if (ba > 2) {
				list.stream().filter(ab -> ab.size() != 0).forEach(cd -> System.out.print(cd + " "));
			}
			System.out.println();
			return;
		}

		for (int j = 0; j < list.size(); j++) {
			list.get(j).add(String.valueOf(a.charAt(i)));
			badshah(a, i + 1, list);
			list.get(j).remove(list.get(j).size() - 1);
		}

	}

	static void partiton(String a, List<List<String>> list) {

		if (a.length() == 0) {
			System.out.println(list);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).add(String.valueOf(a.charAt(0)));
			partiton(a.substring(1), list);
			list.get(i).remove(list.get(i).size() - 1);
		}
	}

	static void twopartition(String a, int i, String ans, String bns) {
		if (a.length() == i) {
			System.out.println(ans + " " + bns);
			return;
		}
		twopartition(a, i + 1, ans + a.charAt(i), bns);
		twopartition(a, i + 1, ans, bns + a.charAt(i));
	}

	static void friendspairing(int arr[], int i, String ans, boolean flag[]) {
		if (i == arr.length) {
			System.out.println(ans);
			return;
		}

		if (flag[i] == false) {
			flag[i] = true;
			friendspairing(arr, i + 1, ans + "{" + arr[i] + "}", flag);
			for (int j = i + 1; j < arr.length; j++) {
				if (flag[j] == false) {
					flag[j] = true;
					friendspairing(arr, i + 1, ans + "{" + arr[i] + "-" + arr[j] + "}", flag);
					flag[j] = false;
				}

			}
			flag[i] = false;
		} else {
			friendspairing(arr, i + 1, ans, flag);
		}
	}

	static void checkvalue(HashMap<Character, Integer> map, boolean flag[], int value, String a, String b, String c) {
		if (value == flag.length) {
			int v = Stream.of(a).map(ab -> Integer.parseInt(ab)).collect(Collectors.summingInt(Integer::intValue));
			int w = Stream.of(a).map(ab -> Integer.parseInt(ab)).collect(Collectors.summingInt(Integer::intValue));
			int u = Stream.of(a).map(ab -> Integer.parseInt(ab)).collect(Collectors.summingInt(Integer::intValue));
			if (v + w == u) {
				System.out.println("find");

			}
			return;
		}

		for (Character it : map.keySet()) {
			if (map.get(it) == -1) {
				for (int i = 0; i < 9; i++) {
					if (safetoput(flag, i, map, it)) {
						flag[i] = true;
						map.put(it, i);
						checkvalue(map, flag, value + 1, a, b, c);
						map.remove(it);
						flag[i] = false;
					}

				}
			}
		}

	}

	private static boolean safetoput(boolean[] flag, int i, HashMap<Character, Integer> map, Character it) {
		if (flag[i] == true) {
			return false;
		}
		if (map.get(it) != -1) {
			return false;
		}
		return true;
	}

	static void solvecrossword(char c[][], int i, int j, String words[], int index, boolean v[][]) {

		for (j = 0; j < c.length; j++) {
			String word = words[index];
			if (horizonatllyvisit(c, i, j, word)) {
				Set<Integer> ar = new HashSet<Integer>();
				placehorizonatlly(c, i, j, word, ar);
				solvecrossword(c, i, j, words, index + 1, v);
				unplacehorizonatlly(c, i, j, word, ar);

			} else if (verticallyvisit(c, i, j, word)) {

			}
		}

	}

	private static void unplacehorizonatlly(char[][] c, int i, int j, String word, Set<Integer> ar) {
		for (int k = 0; k < word.length(); k++) {
			if (!ar.contains(k + j)) {
				c[i][j + k] = 0;
			}
		}
		ar.clear();

	}

	private static void placehorizonatlly(char[][] c, int i, int j, String word, Set<Integer> ar) {
		for (int k = 0; k < word.length(); k++) {
			if (c[i][j + k] == 0) {
				c[i][j + k] = word.charAt(k);
				ar.add(k);
			} else if (c[i][j + k] == word.charAt(k)) {

			}
		}

	}

	private static boolean verticallyvisit(char[][] c, int i, int j, String word) {
		if (c[i][j] != '0') {
			return false;
		}
		int length = word.length();
		if (j == 0) {
			for (int k = i; k < length; k++) {
				if (c[k][j] != 0 && word.charAt(k) != c[k][j]) {
					return false;
				}
			}
			if (i != word.length()) {
				if (c[length][j] != '*') {
					return false;
				}
			}
		} else {
			if (c[i - 1][j] != '*') {
				return false;
			}
			for (int k = i; k < length; k++) {
				if (c[k][j] != 0 && word.charAt(k) != c[k][j]) {
					return false;
				}
			}
			if (i != word.length()) {
				if (c[length][j] != '*') {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean horizonatllyvisit(char[][] c, int i, int j, String word) {
		if (c[i][j] != '0') {
			return false;
		}
		int length = word.length();
		if (j == 0) {
			for (int k = j; k < length; k++) {
				if (c[i][k] != 0 && word.charAt(k) != c[i][k]) {
					return false;
				}
			}
			if (j != word.length()) {
				if (c[i][length] != '*') {
					return false;
				}
			}
		} else {
			if (c[i][j - 1] != '*') {
				return false;
			}
			for (int k = j; k < length; k++) {
				if (c[i][k] != 0 && word.charAt(k) != c[i][k]) {
					return false;
				}
			}
			if (j != word.length()) {
				if (c[i][length] != '*') {
					return false;
				}
			}
		}
		return true;
	}

	static void goldmine(int m[][]) {
		int sum = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != -1) {
					ArrayList<Integer> ar = new ArrayList<Integer>();
					goldminevalue(m, i, j, ar);
					int v = ar.stream().collect(Collectors.summingInt(Integer::intValue));
					System.out.println(v);
				}
			}
		}
		System.out.println(sum);
	}

	private static void goldminevalue(int[][] m, int i, int j, ArrayList<Integer> ar) {
		if (i >= m.length || j >= m.length || i < 0 || j < 0 || m[i][j] == 0 || m[i][j] == -1) {
			return;
		}
		ar.add(m[i][j]);
		m[i][j] = -1;
		goldminevalue(m, i + 1, j, ar);
		goldminevalue(m, i, j + 1, ar);
		goldminevalue(m, i - 1, j, ar);
		goldminevalue(m, i, j - 1, ar);

	}

	private static int goldmineutils(int[][] m, int i, int j) {
		if (i > m.length || j > m.length || i < 0 || j < 0 || m[i][j] == 0) {
			return 0;
		}
		int a = goldmineutils(m, i + 1, j);
		int b = goldmineutils(m, i, j + 1);
		int c = goldmineutils(m, i - 1, j);
		int d = goldmineutils(m, i, j - 1);

		return a + b + c + d;
	}

	static void printlexo(int a) {
		if (a >= 400000) {
			return;
		}
		System.out.println(a);
		for (int i = 0; i <= 9; i++) {
			printlexo(a * 10 + i);
		}
	}

	static void gameofexecution(int arr[], int k, int d, int v) {
		if (v == 1) {
			System.out.println(arr[0]);
			return;
		}
		if (k == d) {
			int t = 0;
			int z = 0;
			for (int j = k; j < arr.length - 1; j++) {
				arr[z++] = arr[j + 1];
			}
			int s = 0;
			while (s != k) {
				arr[z++] = t++;
				s++;
			}
			v = v - 1;
			k = 0;
		}
		gameofexecution(arr, k + 1, d, v);
	}

	static void printword(String words[], int i, HashMap<Character, Integer> map, int[] value, String ans, int val) {
		if (words.length == i) {
			System.out.println(ans);
			return;
		}

		printword(words, i + 1, map, value, ans, val);
		String word = words[i];
		boolean flag = true;
		int sum = 0;
		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(j);
			if (map.containsKey(c)) {
				int v = map.get(c);
				if (v - 1 == -1) {
					map.put(c, v - 1);
					flag = false;
				} else {
					map.put(c, v - 1);
				}
				sum = sum + value[c - 'a'];
			}
		}
		if (flag == true) {
			printword(words, i + 1, map, value, ans + word + "", val + sum);
		}

		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(j);
			if (map.containsKey(c)) {
				int v = map.get(c);
				if (v - 1 == -1) {
					map.put(c, v + 1);
				} else {
					map.put(c, v + 1);
				}

			}
		}

	}

	private static void printpep(String string, int i, int j, String word) {

		if (string.length() == i) {
			if (j == 0) {
				System.out.println(word);
				return;
			}
			System.out.println(word + i);
			return;
		}

		if (j == 0) {
			printpep(string, i + 1, j + 1, word);
			printpep(string, i + 1, j, word + string.charAt(i));
		} else {
			printpep(string, i + 1, j + 1, word);
			printpep(string, i + 1, 0, word + i + string.charAt(i));
		}
	}

}
