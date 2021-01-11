package tree;

import java.util.ArrayList;
import java.util.LinkedList;

class TrieValue {
	boolean flag;
	TrieValue child[] = new TrieValue[26];
}

public class Trie<K, V> {
	
	static TrieValue tree = new TrieValue();

	static void push(String val) {

		int i = 0;
		while (val.length() != i) {
			int temp = val.charAt(i) - 'a';
			if (tree.child[temp] != null) {
				tree = tree.child[temp];
			} else {
				tree.child[temp] = new TrieValue();
			}
			i++;
		}
		tree.flag = true;

	}

	static boolean search(String val) {
		int i = 0;
		while (val.length() != i) {
			int temp = val.charAt(i) - 'a';
			if (tree.child[temp] != null) {
				tree = tree.child[temp];
			} else {
				return false;
			}
		}
		return tree.flag;
	}

	static boolean searchmodified(String val, int i, TrieValue tree) {
		if (tree == null) {
			return false;
		}
		if (i == val.length()) {
			return tree.flag;
		}
		char c = val.charAt(i);
		if (c == '.') {
			for (int j = 0; j < 26; j++) {
				if (searchmodified(val, i, tree.child[j])) {
					return true;
				}
			}
		} else {
			if (searchmodified(val, i + 1, tree.child[c - 'a'])) {
				return true;
			}
		}

		return false;
	}

	static boolean powertwo(int value, int match, int count) {
		if (match == value) {
			return true;
		}
		if (match > value) {
			return false;
		}
		match = (int) Math.pow(2, count);
		boolean f = powertwo(value, match, count + 1);
		return f;
	}

	public static void main(String[] args) {
		boolean d = powertwo(17, 0, 0);

		System.out.println(d);
	}

	class PashMap {
		K key;
		V value;

		public PashMap() {
			// TODO Auto-generated constructor stub
		}

		public PashMap(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	LinkedList<PashMap> list[];
	int size;

	public Trie() {

		init(4);

	}

	private void init(int v) {
		list = new LinkedList[v];
		size = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<PashMap>();
		}
	}

	void put(K key, V value) {

		int v = hashing(key);
		int g = findbucket(list, v, key);
		if (g == -1) {
			list[v].add(new PashMap(key, value));
			size++;
		} else {
			PashMap p = list[v].get(g);
			p.value = value;
			list[v].add(p);
		}
		double lamabada = size * 1.0 / list.length;
		if (lamabada > 2.0) {
			rehash();
		}
	}

	private void rehash() {
		LinkedList<PashMap> [] pl=list;
		init(pl.length*2);
		for(int i=0;i<pl.length;i++)
		{
			for(PashMap p:pl[i])
			{
				put(p.key, p.value);
			}
		}
		
	}

	void containskey(K key) {
		int v = hash(key);
		int f = getbucket(key, v);
		if (f == -1) {
			System.out.println(false);
		}
	}

	void keyset() {
		ArrayList<K> ar = new ArrayList<K>();
		for (int i = 0; i < list.length; i++) {
			for (PashMap p : list[i]) {
				ar.add(p.key);
			}
		}
	}

	private int getbucket(K key, int v) {
		for (PashMap p : list[v]) {
			if (p.key == key) {
				return 1;
			}
		}
		return -1;
	}

	private int hash(K key) {
		int val = key.hashCode();
		return val % list.length;
	}

	private int findbucket(LinkedList<PashMap>[] list2, int v, K key) {
		int di = 0;
		for (PashMap map : list2[v]) {
			if (map.key.equals(key)) {
				return di;
			}
			di++;
		}
		return -1;
	}

	private int hashing(K key) {
		int val = key.hashCode();
		return val % list.length;
	}

}
