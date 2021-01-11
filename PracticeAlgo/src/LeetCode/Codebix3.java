package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class Codebix3 {
	static class Node {
		int id;
		char src;
		char des;

		public Node(int id, char src, char des) {
			super();
			this.id = id;
			this.src = src;
			this.des = des;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	static class Rode {
		int id;
		char src;
		String path;
		int count;

		public Rode(char src, String path, int count) {
			super();
			this.src = src;
			this.path = path;
			this.count = count;
		}

		public Rode(int id, char src, String path, int count) {
			super();
			this.id = id;
			this.src = src;
			this.path = path;
			this.count = count;
		}

	}

	private static void parent(HashMap<Character, Character> map) {
		HashMap<Character, HashSet<Character>> store = new HashMap<Character, HashSet<Character>>();

		for (Character it : map.keySet()) {
			Character character = map.get(it);
			if (store.containsKey(character)) {
				HashSet<Character> hashSet = new HashSet<Character>();
				if (store.containsKey(it)) {
					hashSet = store.get(it);
					HashSet<Character> pet = store.get(character);
					hashSet.addAll(pet);
					hashSet.add(it);
					store.put(character, hashSet);
				} else {
					HashSet<Character> pet = store.get(character);
					hashSet.addAll(pet);
					hashSet.add(it);
					store.put(character, hashSet);
				}

			} else {
				HashSet<Character> set = new HashSet<Character>();
				if (store.containsKey(it)) {
					set = store.get(it);
					set.add(it);
					store.put(character, set);
				} else {
					set.add(it);
					store.put(character, set);
				}
			}
		}
		System.out.println(store);

	}

	static class Tap {
		Character src;
		String path;

		public Tap(Character src, String path) {
			super();
			this.src = src;
			this.path = path;
		}
	}

	private static void finddestination(HashMap<Character, Character> map) {
		ArrayList<Character> set = new ArrayList<Character>();
		for (Character it : map.keySet()) {
			set.add(it);
		}
		for (Character it : map.keySet()) {
			set.remove(map.get(it));
		}
		System.out.println(set);

		Queue<Tap> q = new LinkedList<Tap>();
		q.add(new Tap(set.get(0), set.get(0) + "->"));
		while (!q.isEmpty()) {
			Tap t = q.poll();
			if (map.containsKey(t.src)) {
				q.add(new Tap(map.get(t.src), t.path + t.src + "->"));
			} else {
				System.out.println(t.path);
				return;
			}
		}

	}

	private static void findpossiblediv(int[] arr, int i) {
		Set<Integer> map = new HashSet<Integer>();
		for (int j = 0; j < arr.length; j++) {
			int v = arr[j];
			if (map.contains(i - v % i)) {
				System.out.println(true);
				return;
			} else {
				map.add(v % i);
			}

		}
		System.out.println(false);

	}

	static void distinctelements(int arr[]) {
		HashMap<Integer, Integer> set = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			set.put(arr[i], set.getOrDefault(arr[i], 0) + 1);

		}
		int i = 4;
		int j = 0;
		while (i - 1 < arr.length) {
			System.out.println(set.size());
			set.put(arr[i], set.getOrDefault(arr[i], 0) + 1);
			int v = set.get(arr[j]);
			if (v - 1 == 0) {
				set.remove(arr[j]);
			} else {
				set.put(arr[j], v - 1);

				j++;

				i++;
			}

		}
	}

	static void largestvaluewithsumzero(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (map.containsKey(sum)) {
				int v = map.get(sum);
				IntStream.range(v + 1, i + 1).mapToObj(a -> arr[a]).forEach(a -> System.out.print(a + "  "));
				System.out.println();
				map.put(sum, i);
			} else {
				map.put(sum, i);
			}

		}
	}

	static void minimumwindow(String word, String pattern) {
		HashMap<Character, Integer> pat = new HashMap<>();
		int count = 0;
		for (int i = 0; i < pattern.length(); i++) {
			pat.put(pattern.charAt(i), pat.getOrDefault(pattern.charAt(i), 0) + 1);
			count++;
		}
		HashMap<Character, Integer> mat = new HashMap<>();
		int i = 0;
		int f = 0;
		int j = 0;
		while (i < word.length()) {
			while (f == count) {

				while (mat.size() == pat.size() || f == count) {

					if (mat.containsKey(word.charAt(j))) {
						System.out.println(word.substring(j, i + 1));
						int val = mat.get(word.charAt(j));
						if (val - 1 == 0) {
							mat.remove(word.charAt(j));
						} else {
							mat.put(word.charAt(j), val - 1);
						}
						f--;

					}
					j++;
				}
				continue;
			}
			if (pat.containsKey(word.charAt(i))) {
				mat.put(word.charAt(i), mat.getOrDefault(word.charAt(i), 0) + 1);
				int val = pat.get(word.charAt(i));
				int sval = mat.get(word.charAt(i));
				if (val <= sval) {
					f++;
				}
			}

			i++;
		}

	}

	public static void main(String[] args) {
		minimumwindow("BDCAHGSBACDHEABCDEH", "ABC");

	}

}
