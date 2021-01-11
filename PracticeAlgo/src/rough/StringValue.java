package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringValue {
	public static void main(String[] args) {
		String value = "babccdadd";
		permutation(value, "abd");

	}

	static void reverser(String value) {
		char a[] = value.toCharArray();
		String words = "";
		String temp = "";
		for (int i = 0; i < value.length(); i++) {
			while (a[i] != ' ' && value.length() - 1 > i) {
				temp = a[i] + temp;
				i++;
			}
			words = words + temp;
			temp = "";
		}
		System.out.println(words);
	}

	private static void frequent(String value) {

		String text = value.replaceAll("[^A-Za-z0-9]", " ");
		String words[] = text.split(" +");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word.toLowerCase(), map.getOrDefault(word, 0) + 1);
		}
		TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
			int freq1 = map.get(e1);
			int freq2 = map.get(e2);

			if (freq1 != freq2) {
				return freq2 - freq1;
			}

			return e1.compareTo(e2);
		});

		TreeMap<String, Integer> most = new TreeMap<>((e2, e3) -> {
			int freq1 = map.get(e2);
			int freq2 = map.get(e3);
			if (freq1 != freq2) {
				return freq2 - freq1;
			}
			return e2.compareTo(e2);
		});

		most.putAll(mostFrequentMap);
		List<String> list = new ArrayList<String>();

		int topfreq = most.firstEntry().getValue();
		while (most != null) {
			Map.Entry<String, Integer> entry = most.pollFirstEntry();
			if (entry.getValue() == topfreq) {
				list.add(entry.getKey());
			} else {
				break;
			}
		}

		System.out.println(list);
	}

	static void nonrepeated(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int end = 0;
		int max = 0;
		while (start < s.length()) {
			if (map.containsKey(s.charAt(start))) {
				while (end <= start && map.containsKey(s.charAt(start))) {
					map.remove(s.charAt(end));
					end++;

				}
			}
			map.put(s.charAt(start), start);
			max = Math.max(max, start - end + 1);
			start++;

		}
		System.out.println(max);
	}

	static void printeachfirst(String v) {
		for (int i = 0; i < v.length(); i++) {
			if (v.charAt(i) != ' ') {
				if (i == 0) {
					System.out.println(v.charAt(i));
				} else if (v.charAt(i - 1) == ' ') {
					System.out.println(v.charAt(i));
				}
			}
		}
	}

	static void frequency(String words) {
		String value = words.replaceAll("[^A-Za-z0-9]", " ");
		String word[] = value.split(" +");
		Map<String, Integer> map = new HashMap<>();
		for (String w : word) {
			map.put(w.toLowerCase(), map.getOrDefault(w, 0) + 1);
		}
		TreeMap<String, Integer> tree = new TreeMap<>((e1, e2) -> {
			int freq = map.get(e1);
			int freq1 = map.get(e2);
			while (freq != freq1) {
				return freq1 - freq;
			}
			return e1.compareTo(e2);
		});

		List<String> list = new ArrayList<>();
		int m = tree.firstEntry().getValue();
		while (tree != null) {
			Map.Entry<String, Integer> entry = tree.pollFirstEntry();
			if (entry.getValue() == m) {
				list.add(entry.getKey());
			} else {
				break;
			}
		}

	}

	static void permutation(String a, String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		while (start != b.length()) {
			map.put(b.charAt(start), map.getOrDefault(b.charAt(start), 0) + 1);
			start++;
		}
		start = 0;
		int d = 0;
		char ad = ' ';
		while (start < a.length()) {
			if (!map.containsKey(a.charAt(start))) {
				d = 0;
				start++;
			} else {

				map.put(a.charAt(start), map.get(a.charAt(start)) - 1);
				int f = map.get(a.charAt(start));
				if (f == 0) {
					d++;
					ad = a.charAt(start);
					map.put(a.charAt(start), map.get(a.charAt(start)) + 1);
				}
				if (d == map.size()) {
					System.out.println(true);
				}

				start++;
			}

		}
	}

	static void maximum(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		while (start < s.length()) {
			map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
			
		}

	}

}
