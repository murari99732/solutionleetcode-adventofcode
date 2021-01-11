package rough;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Cordidnate {
	int x;
	int y;

	public Cordidnate(int x, int y) {

		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
}

public class PrintFirstString {

	static void first(String c) {

		char d[] = c.toCharArray();
		int i = 0;
		int end = c.length() - 1;
		int k = 0;

		int g = 0;
		if (i < c.length() && end >= 0) {

			while (d[i] == ' ') {
				i++;
				k++;
			}

			while (d[end] == ' ') {
				g++;
				end--;
			}
		}

		for (int l = k; l < d.length - g; l++) {
			System.out.println(d[l]);
		}
		System.out.println(new String(d, k, (d.length - 1) - g));

	}

	static void reverse(String s) {
		int i = 0;
		char c[] = s.toCharArray();
		String word = "";
		String full = " ";
		while (i < c.length) {
			while (c[i] != ' ' && i < c.length - 1) {
				if (c[i] == ' ') {
					word = word + c[i];
					i++;
				} else {
					word = word + c[i];
					i++;
				}
			}
			word = word + c[i];
			full = " " + word + full + " ";
			word = "";
			i++;

		}
		System.out.println(full);
	}

	static void kdistinct(String s, int k) {
		int start = 0;
		int max = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (start < s.length()) {
			map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);

			while (map.size() > k) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				if (map.containsValue(0)) {
					map.remove(s.charAt(end));
				}
				end++;
			}
			max = Math.max(max, start - end + 1);
			start++;
		}
		System.out.println(max);
	}

	static void longestsubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int max = 0;
		while (start < s.length()) {
			if (map.containsKey(s.charAt(start))) {
				map.put(s.charAt(start), start);
				end++;
			}
			map.put(s.charAt(start), start);

			max = Math.max(max, start - end + 1);
			start++;
		}
		System.out.println(max);
	}

	static void delete(String s, String t) {

		String d = word(s);
		String c = word(t);
		if (d.equals(c)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	private static String word(String s) {
		String t = "";
		int start = 0;
		int end = s.length() - 1;
		while (end >= 0) {
			int d = 0;
			while (s.charAt(end) == '#') {
				d++;
				end--;
			}
			while (d != 0) {
				d--;
				end--;
			}
			t = s.charAt(end) + t;
			end--;
		}
		return t;
	}

	static void permutation(String s, String value) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < value.length(); i++) {
			map.put(value.charAt(i), 1);
		}
		int start = 0;
		int end = 0;

		while (start < s.length() - 1 && end <= start) {
			if (map.get(s.charAt(start)) < 0) {
				map.put(s.charAt(start), 1);
				end++;
			}
			map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
			int d = 0;
			if (map.get(s.charAt(start)) == 0) {
				d++;
			}
			if (d == 0) {
				System.out.println(true);
			}

			start++;
		}

	}

	static void equation(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		int i = 0;
		int end = s.length() - 1;
		int d = 0;
		int p = s.length() - 1;
		char cd[] = s.toCharArray();
		while (i < end) {
			while (!set.contains(s.charAt(i))) {
				d++;
				i++;
			}
			while (!set.contains(s.charAt(end))) {
				end--;
				p--;
			}

			char temp = cd[p];
			cd[p] = cd[d];
			cd[d] = temp;
			i++;
			end--;

		}
		System.out.println(new String(cd));
	}

	static void train(String s, int v) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		char c = s.charAt(start);
		int max = 0;
		while (start < s.length()) {

			while (map.size() > v) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				if (map.containsValue(0)) {
					map.remove(s.charAt(end));
				}
				end++;
			}
			max = Math.max(max, start - end + 1);
			map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
			start++;
		}

	}

	static void mathcing(String s, String value) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < value.length(); i++) {
			map.put(value.charAt(i), map.getOrDefault(value.charAt(i), 0) + 1);

		}
		int start = 0;
		int end = 0;
		int d = 0;
		int min = Integer.MAX_VALUE;
		while (end < s.length() - 1) {

			if (map.containsKey(s.charAt(end))) {

				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
			}
			if (map.get(s.charAt(end)) == 0) {
				d++;
			}
			if (map.get(s.charAt(end)) < 0) {
				map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
				start++;
			}

			if (d == map.size()) {
				min = Math.min(min, end - start + 1);
				start++;
			}
			end++;
		}
		System.out.println(min);
	}

	public static void queue(String s, String v) {
		ArrayList<Character> ar = new ArrayList<>();
		for (int i = 0; i < v.length(); i++) {
			ar.add(v.charAt(i));
		}
		Deque<Integer> deque = new LinkedList<Integer>();
		int i = 0;
		for (i = 0; i < v.length(); i++) {
			while (!deque.isEmpty() && !ar.contains(v.charAt(i))) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		for (; i < s.length(); i++) {

			if (!deque.isEmpty() && i - deque.peekFirst() > v.length()) {

				deque.removeFirst();
			}
			while (!deque.isEmpty() && !ar.contains(s.charAt(i))) {
				System.out.println(s.charAt(deque.removeLast()));

			}
			deque.addLast(i);
		}

	}

	static void island(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m.length - 1; j++) {
				b[i][j] = false;
			}
		}
		int d = 0;
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m.length - 1; j++) {
				if (b[i][j] == false && m[i][j] == 1) {
					d++;
					getcheck(m, i, j, b);
				}

			}
		}
		System.out.println(d);
	}

	private static void getcheck(int[][] m, int i, int j, boolean[][] b) {

		b[i][j] = true;

		if (safeVisit(m, i + 1, j, b))
			getcheck(m, i + 1, j, b);

		if (safeVisit(m, i, j + 1, b)) {
			getcheck(m, i, j + 1, b);
		}
		if (safeVisit(m, i - 1, j, b)) {
			getcheck(m, i - 1, j, b);
		}
		if (safeVisit(m, i, j - 1, b)) {
			getcheck(m, i, j - 1, b);
		}

	}

	private static boolean safeVisit(int[][] m, int i, int j, boolean[][] b) {
		if (i > 0 && i < m.length && j > 0 && j < m.length && b[i][j] == false && m[i][j] == 1) {
			return true;
		}
		return false;
	}

	static void rot(int m[][]) {
		Queue<Cordidnate> q = new LinkedList<Cordidnate>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 2) {
					q.add(new Cordidnate(i, j));
				}
			}
		}
		boolean flag=false;
		int d=0;
		q.add(new Cordidnate(-1, -1));
		while (!q.isEmpty()) {
			while (q.peek().x != -1 && q.peek().y != 1) {
				Cordidnate c = q.remove();
				if (safeVisit(c.x, c.y - 1, m)) {
					q.add(new Cordidnate(c.x, c.y - 1));
					if(flag==false)
					{
						flag=true;
						d++;
					}
				}
				if (safeVisit(c.x - 1, c.y, m)) {
					q.add(new Cordidnate(c.x - 1, c.y));
					if(flag==false)
					{
						flag=true;
						d++;
					}
				}
				if (safeVisit(c.x + 1, c.y, m)) {
					q.add(new Cordidnate(c.x + 1, c.y));
					if(flag==false)
					{
						flag=true;
						d++;
					}
				}
				if (safeVisit(c.x, c.y + 1, m)) {
					q.add(new Cordidnate(c.x, c.y + 1));
					if(flag==false)
					{
						flag=true;
						d++;
					}
				}
			}
			
			q.remove();
			flag=false;
			if(!q.isEmpty())
			q.add(new Cordidnate(-1, -1));
		}
		System.out.println(d);

	}

	private static boolean safeVisit(int x, int i, int[][] m) {
		if (x > 0 && x < m.length && i > 0 && i < m.length && m[i][x] == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 } };
		island(mat);
	}
}
