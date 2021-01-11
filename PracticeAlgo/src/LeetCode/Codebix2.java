package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import LeetCode.Codebix.Cordinate1;

public class Codebix2 {

	static void merge(List<Cordinate1> list) {
		Collections.sort(list, (a, b) -> a.x - b.x);
		Stack<Cordinate1> st = new Stack<Codebix.Cordinate1>();
		for (int i = 0; i < list.size(); i++) {
			if (st.isEmpty()) {
				st.push(list.get(i));
			} else {
				Cordinate1 prev = st.peek();
				Cordinate1 curr = list.get(i);
				if (prev.x < curr.x && prev.y < curr.x) {
					st.push(curr);
				} else if (prev.x < curr.x && prev.y > curr.y) {
					st.pop();
					st.push(new Cordinate1(prev.x, prev.y));
				} else if (prev.x < curr.x && curr.x < prev.y && prev.y < curr.y) {
					st.pop();
					st.push(new Cordinate1(prev.x, curr.y));
				}

			}
		}
		System.out.println(st);

	}

	static void patternvalue(String a) {

		Stack<Character> st = new Stack<Character>();
		int b[] = new int[a.length()];
		int count = 0;
		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) == 'd') {
				while (i < a.length() && a.charAt(i) == 'd') {
					st.push('d');
					i++;
					count++;
				}
				int value = st.size();
				b[i] = value;
				int dc = count;
				while (dc != 0) {
					b[value - 1] = dc - 1;
					value--;
					dc--;
				}
			} else {

				b[i] = count;
				count++;
			}
		}
		Arrays.stream(b).forEach(ab -> System.out.print(ab + " "));
	}

	static Integer arr[] = new Integer[5];
	static int f = 0;
	static int end = arr.length - 1;
	static int size = end - f + 1;

	static void pusha(int v) {
		if (f <= end) {
			arr[f++] = v;
			size = end - f;
		}
	}

	static void pushb(int v) {
		if (f <= end) {
			arr[end--] = v;
			size = end - f;
		}
	}

	static void popa() {
		if (size < arr.length && f >= 0) {
			System.out.println(arr[f - 1]);
			arr[f - 1] = null;
			f--;
			size = end - f;

		}
	}

	static void popb() {
		if (size < arr.length && end < arr.length) {
			System.out.println(arr[end + 1]);
			arr[end + 1] = null;
			end++;
			size = end - f;

		}
	}

	static class Cache {
		int id;
		String value;

		public Cache(int id, String value) {
			super();
			this.id = id;
			this.value = value;
		}

		public Cache() {
			// TODO Auto-generated constructor stub
		}

	}

	static ArrayDeque<Cache> deque = new ArrayDeque<Codebix2.Cache>();
	static HashMap<Integer, Cache> map = new HashMap<Integer, Codebix2.Cache>();

	static void add(Cache c) {
		if (map.containsKey(c.id)) {
			map.remove(c.id);
			deque.remove(c);
			deque.addFirst(c);
			map.put(c.id, c);
		} else if (deque.size() == 3) {
			Cache cd = deque.removeLast();
			map.remove(cd.id);
			map.put(c.id, c);
			deque.addFirst(c);
		}

		else {
			map.put(c.id, c);
			deque.addFirst(c);
		}
	}

	static void get(int id) {
		if (map.containsKey(id)) {
			Cache it = map.get(id);
			deque.remove(it);
			deque.addFirst(it);

		} else {

		}
	}

	static void smallestcountofmatchingpattern(String pattern, String ans) {
		HashMap<Character, Integer> hasmap = new HashMap<Character, Integer>();
		int count = pattern.length();
		for (int i = 0; i < pattern.length(); i++) {
			hasmap.put(pattern.charAt(i), hasmap.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;
		int d = 0;
		while (i < ans.length()) {
			if (hasmap.containsKey(ans.charAt(i))) {
				map.put(ans.charAt(i), map.getOrDefault(ans.charAt(i), 0) + 1);
				int e = hasmap.get(ans.charAt(i));
				if (e == map.get(ans.charAt(i))) {
					d++;
				}
			}
			if (map.size() == hasmap.size() && d == count) {

				int size = map.size();
				while (map.size() == size && j < ans.length()) {
					System.out.println(i - j + 1 + " <-size");
					if (map.containsKey(ans.charAt(j))) {

						int v = map.get(ans.charAt(j));
						int f = hasmap.get(ans.charAt(j));
						if (v - 1 < f) {
							d--;
						}
						if (v - 1 == 0) {
							map.remove(ans.charAt(j));
						} else {
							map.put(ans.charAt(j), v - 1);
						}

					}
					j++;
				}
			}
			i++;

		}
	}

	static void patternmatching(String pattern, String word) {
		int i = 0;
		int j = 0;
		while (i < word.length()) {
			if (pattern.charAt(0) == word.charAt(i)) {
				int d = i;
				int f = 0;
				while (f < pattern.length() && pattern.charAt(f) == word.charAt(d)) {
					d++;
					f++;
				}
				if (pattern.length() == f) {
					System.out.println("found");
				}
			}
			i++;
		}
	}

	static void duplicatehashmap(String a, String b) {
		HashMap<Character, Integer> hasmap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			hasmap.put(a.charAt(i), hasmap.getOrDefault(a.charAt(i), 0) + 1);
		}
		for (int j = 0; j < b.length(); j++) {

			if (hasmap.containsKey(b.charAt(j)) && hasmap.get(b.charAt(j)) > 0) {
				System.out.println(b.charAt(j));
				int k = hasmap.get(b.charAt(j));
				hasmap.put(b.charAt(j), k - 1);
			}
		}
	}

	static void longestsequnce(int[] a) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], true);
		}
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]) && map.get(a[i])) {
				int d = 1;
				int b = a[i] + 1;
				int c = a[i] - 1;
				int min = 0;
				int max = 0;
				map.put(a[i], false);
				while (map.containsKey(b) && map.get(b)) {
					d++;
					map.put(b, false);
					max = b;
					b = b + 1;

				}
				while (map.containsKey(c) && map.get(c)) {
					d++;
					map.put(c, false);
					min = c;
					c = c - 1;

				}
				if (max == 0)
					System.out.println(min + "         " + a[i] + "        " + d);
				else if (min == 0) {
					System.out.println(a[i] + "         " + max + "        " + d);
				} else {
					System.out.println(min + "         " + max + "        " + d);
				}
			}

		}

	}

	static ArrayList<Integer> p = new ArrayList();

	static void push(int a) {
		p.add(a);
		int size = p.size() - 1;
		int val = size / 2;
		while (val <= 0 && size != 0 && p.get(val) > p.get(size)) {
			int temp = p.get(val);
			int demp = p.get(size);
			p.remove(val);
			p.add(val, demp);
			p.remove(size);
			p.add(size, temp);
			size = val;
			val = val / 2;
		}

	}

	static void poll() {
		System.out.println(p.remove(0));
		p.add(0, p.remove(p.size() - 1));
		int size = 0;
		int lsize = size * 2 + 1;
		int rsize = size * 2 + 2;
		while (lsize < p.size() && rsize < p.size()) {
			int left = p.get(lsize);
			int right = p.get(rsize);
			if (left < p.get(size)) {
				int store1 = p.get(size);
				int store2 = p.get(lsize);
				p.remove(lsize);
				p.add(lsize, store1);
				p.remove(size);
				p.add(size,store2);

				size = lsize;
				lsize = size * 2 + 1;
				rsize = size * 2 + 2;
			} else if (right < p.get(size)) {
				int store1 = p.get(size);
				int store2 = p.get(rsize);
				p.remove(rsize);
				p.add(rsize, store1);
				p.remove(size);
				p.add(size, store2);
				size = rsize;
				lsize = size * 2 + 1;
				rsize = size * 2 + 2;
			}
		}

	}

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		poll();
		poll();

	}
}
