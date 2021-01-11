package LeetCode;

import java.util.ArrayDeque;
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

	public static void main(String[] args) {

	}
}
