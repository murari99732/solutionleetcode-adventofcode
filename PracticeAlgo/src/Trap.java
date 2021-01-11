import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Trap<K, V> {
	private class Map {
		K key;
		V value;

		public Map() {
			// TODO Auto-generated constructor stub
		}

		public Map(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	LinkedList<Map>[] list;
	int size;
	int n;

	Trap() {
		size = 0;
		n = 10;
		list = new LinkedList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList();
		}
	}

	void push(K key, V value) {
		int bi = getbucket(key);
		int indexval = getwithin(bi, key);
		if (indexval != -1) {
			Map m = list[bi].get(indexval);
			m.value = value;
		} else {
			Map m = new Map(key, value);
			list[bi].add(m);
			size++;
		}
		int lambada = size / list.length;
		if (lambada > 2) {
			rehash();
		}
	}

	private void rehash() {

		int d = n * 2;
		n = d;
		LinkedList<Map> m[] = list;
		for (int i = 0; i < n; i++) {
			for (Map j : list[i]) {
				push(j.key, j.value);
			}
		}

	}

	public boolean containskey(K key) {
		int bi = getbucket(key);
		int indexval = getwithin(bi, key);
		if (indexval != -1) {
			return true;
		}
		return false;
	}

	V remove(K key, V value) {
		int bi = getbucket(key);
		int indexval = getwithin(bi, key);
		if (indexval != -1) {
			Map m = list[bi].remove(indexval);
			size--;
			return m.value;
		}
		return null;
	}

	private int getwithin(int bi, K key) {

		int d = 0;
		for (Map it : list[bi]) {
			if (it.key == key) {
				return d;
			}
			d++;
		}

		return -1;
	}

	private int getbucket(K key) {
		int d = key.hashCode();
		return d / list.length;
	}

	static void count(HashMap<String, String> map) {
		HashMap<String, ArrayList<String>> tree = new HashMap<>();
		for (String man : map.keySet()) {
			String curr = map.get(man);
			if (tree.containsKey(curr)) {
				ArrayList<String> brr = tree.get(curr);
				brr.add(curr);
				tree.put(man, brr);
			} else {
				ArrayList<String> crr = new ArrayList<String>();
				crr.add(curr);
				tree.put(man, crr);
			}

		}
		System.out.println(tree);
	}

	static void destsource(HashMap<String, String> city) {
		HashMap<String, Boolean> check = new HashMap<String, Boolean>();
		for (String entry : city.keySet()) {
			String fc = city.get(entry);
			check.put(fc, false);
			if (check.containsKey(entry) == false) {
				check.put(entry, true);
			}
		}
		String src = "Murari";
		for (String move : check.keySet()) {
			if (check.get(move) == true) {
				src = move;
				break;
			}
		}
		src = "Murari";
		ArrayList<String> ar = new ArrayList<>();
		while (true) {
			if (city.containsKey(src)) {
				ar.add(src);
				src = city.get(src);
			} else {
				break;
			}
		}
		System.out.println(ar);

	}

	static void pairs(int arr[]) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hash = new HashMap<>();
		HashMap<Integer, Integer> store = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.add(arr[i]);
			hash.put(arr[i], false);
		}
		for (Integer iterate : hash.keySet()) {
			int value = iterate;
			for (Integer ar : map) {
				if (hash.get(ar) == false && (value + ar) % 10 == 0) {
					store.put(value, ar);
					hash.put(value, true);
					hash.put(ar, true);
				}
			}
		}
		System.out.println(store);
		System.out.println(hash);
	}

	static void pairsvalue(int arr[], int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int val : arr) {
			int a = val % 10;
			int d = map.getOrDefault(a, 0);
			map.put(a, d + 1);

		}

		for (int value : arr) {
			int a = value % 10;

			if (a == 0) {
				if (map.get(a) % 2 == 1) {
					System.out.println("false");
					break;
				}
			} else if (a * 2 == k) {
				if (map.get(a) % 2 == 1) {
					System.out.println("false");
					break;
				}
			} else {
				int d = map.get(a);
				int e = map.get(k - a);
				if ((d + e) % 2 == 1) {
					System.out.println("false");
					break;
				}
			}

		}

		System.out.println(map);
	}

	static void distinct(int arr[], int k) {

		int i = 0;
		while (i < arr.length) {
			int d = k;
			Set<Integer> set = new HashSet<>();
			while (i < arr.length && d != 0) {
				set.add(arr[i]);
				d--;
				i++;
			}
			System.out.println(set.size());
		}
	}

	static void distincthash(int arr[], int k) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int i = 0;
		while (i < arr.length) {

			int d = 4;
			int lastindex = i;
			while (d != 0) {
				hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
				d--;
				i++;
			}
			int value = hashmap.get(arr[lastindex]);
			if (value - 1 != 0) {

			}

		}
	}

	static void largestsubarray(int arr[], int i, String ans, int value, int count) {
		if (arr.length == i) {

			return;
		}
		if (value == 0 && !ans.equals("")) {
			System.out.println(ans);
			System.out.println(count);
			System.out.println();
		}
		largestsubarray(arr, i + 1, ans + arr[i] + "->", value + arr[i], count + 1);
		largestsubarray(arr, i + 1, ans, value, count);

	}

	static int max = 0;

	static void largestsub(int arr[], int j) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (!map.containsKey(sum))
				map.put(sum, i);
			else {
				int g = map.get(sum);
				max++;
			}

		}
		System.out.println(max);
	}

	static void minsubstring(String str, String value) {
		HashMap<Character, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < value.length(); i++) {
			hashmap.put(value.charAt(i), hashmap.getOrDefault(value.charAt(i), 0) + 1);
		}
		HashMap<Character, Integer> crashmap = hashmap;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			if (crashmap.size() == 0) {
				max = Math.max(max, i - min);
				min = Integer.MAX_VALUE;
				crashmap = hashmap;
			}
			if (crashmap.containsKey(str.charAt(i))) {
				min = Math.min(i, min);
				int d = crashmap.get(str.charAt(i));
				if (d - 1 == 0) {
					crashmap.remove(str.charAt(i));
				} else {
					crashmap.put(str.charAt(i), d - 1);
				}
			}
		}
		System.out.println(max);
	}

	static void longestnonrepeating(String a) {
		int count = 0;
		ArrayList<Character> hashmap = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			if (!hashmap.contains(a.charAt(i))) {
				count++;
				max = Math.max(count, max);
				hashmap.add(a.charAt(i));
			} else {
				char c = a.charAt(i);

				for (int j = 0; j < hashmap.size(); j++) {
					if (hashmap.get(j) == c) {
						hashmap.remove(j);
						count = 0;
						break;
					}
					hashmap.remove(j);

				}

			}
		}
	}

	static void countsub(String s, String ans, int count, Set<Character> set) {
		if (s.length() == 0) {
			System.out.println(ans);
			max = Math.max(max, count);
			return;
		}
		char c = s.charAt(0);

		if (!set.contains(c)) {
			set.add(c);
			String sub = s.substring(1);
			countsub(sub, ans + c + " ", count + 1, set);

		} else {
			countsub(s, ans + " ", count, set);
		}
	}

	static void kdistinct(String a, int k) {
		HashMap<Character, Integer> hashmap = new HashMap<>();
		ArrayList<Character> ar = new ArrayList<Character>();
		int bt = Integer.MAX_VALUE;
		for (int i = 0; i < a.length(); i++) {
			if (hashmap.size() == k) {
				System.out.println(i - bt);

			}
			ar.add(a.charAt(i));
			bt = Math.min(bt, i);
			hashmap.put(a.charAt(i), hashmap.getOrDefault(a.charAt(i), 0) + 1);
			if (hashmap.size() > 2) {
				for (int m = 0; m < ar.size(); m++) {
					if (hashmap.size() <= 2) {
						bt = m;
						break;
					} else {

						int n = hashmap.get(ar.get(m));
						if (n - 1 == 0) {
							hashmap.remove(ar.get(m));
						} else {
							hashmap.put(ar.get(m), n - 1);
						}
					}
				}
			}

		}
	}

	static void maximumcon(int arr[], int i) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int j = 0;
		while (i < arr.length) {
			if (arr[i] != 1) {
				count++;
			}
			while (count > 2) {
				if (arr[j] != 1) {
					count--;
				}
				j++;
			}
			max = Math.max(max, i - j + 1);
			i++;
		}

	}

	static void context(int arr[]) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int j = 0; j < arr.length - 1; j++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int i = j + 1; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				if (max - min == i - j) {
					System.out.println(i + " -> " + j);
				}
			}
		}
	}

	static void kmostunique(String value, String ans) {
		if (value.length() == 0) {
			System.out.println(ans);
			return;
		}
		char c = value.charAt(0);
		String temp = value.substring(1);
		kmostunique(temp, ans + c);
		kmostunique(temp, ans);
	}

	static void getvalue(int arr[], int value) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			int dc = 0;
			if (map.containsKey(sum - value)) {
				dc = map.get(sum - value);
			}
			max = Math.max(max, i - dc);
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(max);
	}

	static void zeroone(int arr[]) {
		int sum = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum = sum + -1;
			} else {
				sum = sum + 1;
			}
			if (hashMap.containsKey(sum)) {
				int value = hashMap.get(sum);
				max = Math.max(max, i - value);
			} else {
				hashMap.put(sum, i);
			}
		}
		System.out.println(max);
	}

	static void kdivisble(int arr[], int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			int div = sum / k;
			int temp = sum;
			while (div != 0) {
				temp = sum - (k * div);
				if (map.containsKey(temp)) {
					int index = map.get(temp);
					max = Math.max(max, i - index);
				}
				div--;
			}
			map.put(sum, i);
		}
		System.out.println(max);
	}

	static void kdisticnt(int arr[], int k) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			int rem = sum % k;
			if (map.containsKey(rem)) {
				max = Math.max(i - map.get(rem), max);
			} else {
				map.put(rem, i);
			}
		}
		System.out.println(max);
	}

	static void longestsubarray(int arr[]) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				sum = sum - 1;
			} else {
				sum = sum + arr[i];
			}
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			}
			map.put(sum, i);
		}
		System.out.println(max);
	}

	static void fraction(int value, int div) {
		HashMap<Integer, Integer> hasmap = new HashMap<>();
		String ans = "";
		int k = 0;
		int rem = value % div;
		while (value != 0) {

			if (rem > value) {
				value = rem * 10;
			}
			rem = rem % div;
			value = value / div;
			ans = ans + value;
			if (hasmap.containsKey(rem)) {
				break;
			} else {
				hasmap.put(rem, k++);
			}
		}
		System.out.println(ans);
	}

	static void min(int arr[], int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		int i = 0;
		while (i < k) {
			p.add(arr[i]);
			i++;
		}
		for (int j = k + 1; j < k; j++) {
			if (p.peek() < arr[j]) {
				p.poll();
				p.add(arr[j]);
			}

		}
		System.out.println(p.peek());
	}

	PriorityQueue<Integer> p = new PriorityQueue<Integer>();

	static void topfrequentword(int arr[]) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		PriorityQueue<Entry<Integer, Integer>> pr = new PriorityQueue<>((a, b) -> {
			int d = a.getValue();
			int e = b.getValue();
			return e - d;
		});
		for (int i = 0; i < arr.length; i++) {
			hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0) + 1);
		}
		int k = 0;
		for (Entry<Integer, Integer> e : hashmap.entrySet()) {
			pr.add(e);
			if (k == 3) {
				break;
			}
			k++;
		}
		System.out.println(pr);

	}

	static void makeonerope(int arr[]) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			p.add(arr[i]);
		}
		int sum = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 1; i < arr.length; i++) {
			p.add(p.peek()+sum);
			
			
		}
		sum = 0;
		for (int i = 0; i < ar.size(); i++) {
			sum = sum + ar.get(i);
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		makeonerope(new int[] { 3, 4, 7, 2 });
	}

}
