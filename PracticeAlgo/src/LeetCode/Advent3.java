package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
			}
			else
			{
				System.out.println(t.path);
				return;
			}
		}

	}

	public static void main(String[] args) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('A', 'B');
		map.put('B', 'C');
		map.put('C', 'D');
		map.put('D', 'E');
		map.put('E', 'F');
		map.put('F', 'G');

		finddestination(map);
	}

}
