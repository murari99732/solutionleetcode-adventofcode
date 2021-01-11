package stringPr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class PrintFirstCahar {

	public static void main(String[] args) {
		String str = "badeabcaae";
		String pattern = "aabc";
		minsubstring(str, pattern);
	}

	private static void minsubstring(String s, String value) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < value.length(); i++) {
			map.put(value.charAt(i), map.getOrDefault(value.charAt(i), 0) + 1);
		}

		int start = 0;
		int end = 0;
		int max = 0;
		int de = Integer.MAX_VALUE;
		while (end < s.length()) {

			char currentChar = s.charAt(end);

			if (map.containsKey(currentChar)) {
				map.put(currentChar, map.get(currentChar) - 1);
				
			}

			if (map.get(currentChar) != null && map.get(currentChar) >= 0) {
				max++;
				
			}

			if (max == map.size()) {
				de = Math.min(de, end - start + 1);
				System.out.println(de);
				start =end;
				map.put(currentChar, 1);
				for(Map.Entry<Character, Integer> mp:map.entrySet())
				{
					mp.setValue(1);
				}
			}
			else
			{
				end++;
			}

			
		}
		System.out.println(de);
	}

	private static void longestSubstring(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		while (end < s.length()) {
			map.put(s.charAt(end), map.getOrDefault(end, 0) + 1);

			int d = end - start + 1 - 2;
			if (d > k) {
				start++;
			}

		}
	}

	private static void longestKsubstring(String s, int k) {
		int start = 0;
		int end = 0;
		int max = 0;
		char c[] = s.toCharArray();
		int d = 0;
		while (end < s.length() - 1) {

			System.out.println(c[start]);
			System.out.println(c[start + 1]);
			while (c[end + 1] != c[start] && d <= k) {

				d++;
				end++;

			}

			if (d < k && c[end + 1] == c[start]) {
				d++;
				end++;
				continue;
			}
			if (d == k && c[end + 1] == c[start]) {
				d++;

			}

			max = Math.max(max, end - start + 1);
			if (d > k) {
				d = 0;
				start++;
				end = start;
				end++;
			}

		}
		System.out.println(max);
	}

	private static boolean isVowel(char c) {
		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U')
			return true;

		return false;
	}

	public static String reverseVowelsInString(String str) {
		int start = 0;
		int end = str.length() - 1;

		char[] charArr = str.toCharArray();

		while (start < end) {
			if (!isVowel(charArr[start])) {
				start++;
				continue;
			}

			if (!isVowel(charArr[end])) {
				end--;
				continue;
			}

			char c = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = c;

			start++;
			end--;
		}

		return String.valueOf(charArr);
	}

	static void anagram(String dictionary, String value) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 1);
		map.put('b', 1);
		map.put('c', 1);
		int end = 0;
		int start = 0;
		while (end < dictionary.length()) {

			if (map.containsKey(dictionary.charAt(end)) && map.get(dictionary.charAt(end)) > 0) {
				map.put(dictionary.charAt(end), 0);
				end++;
			} else if (map.containsKey(dictionary.charAt(end)) && map.get(dictionary.charAt(end)) == 0) {

				map.put(dictionary.charAt(start), 1);
				start++;

			} else if (end - start + 1 == 3) {
				System.out.println(true);
			}

			end++;
		}

	}

	static void backspace(String a, String b) {
		int c = a.length();
		int d = b.length();
		a = removespace(a);
		b = removespace(b);
		if (a.equals(b))

		{
			System.out.println("true");
		} else {
			System.out.println(false);
		}
	}

	private static boolean remeove(String a, String b) {
		int d = a.length() - 1;
		int c = b.length() - 1;
		while (d >= 0 && c >= 0) {
			int dc = 0;
			while (a.charAt(d) == '#') {
				dc++;
				d--;
			}
			if (dc != 0) {
				d = d - dc;
			}
			dc = 0;
			while (b.charAt(c) == '#') {
				dc++;
				c--;
			}
			if (dc != 0) {
				c = c - dc;
			}

			if (a.charAt(d) != b.charAt(c)) {
				return false;
			}
			d--;
			c--;
		}
		return true;

	}

	private static String removespace(String a) {
		char c[] = a.toCharArray();
		int start = 0;
		int d = 0;
		int end = 0;
		while (start < a.length()) {

			if (c[start] == '#') {
				c[end--] = c[start];
				start++;

			} else {
				end = start;
				start++;

			}
		}
		int start1 = 1;

		for (int i = 1; i < c.length; i++) {
			if (c[i] != c[i - 1]) {
				if (c[i] != '#')
					c[start1++] = c[i];
			}
		}

		return new String(c, 0, start1);

	}

	static void non(String c) {
		Map<Character, Integer> hm = new HashMap<>();
		int start = 0;
		int end = 1;
		int max = 0;

		int p = 0;
		hm.put(c.charAt(start), start);
		while (end < c.length() - 1) {

			if (!hm.containsKey(c.charAt(end))) {
				max = Math.max(max, end - start + 1);
				hm.put(c.charAt(end), end);
				end++;
			}
			if (hm.containsKey(c.charAt(end))) {
				start = hm.get(c.charAt(end));
				hm.put(c.charAt(end), end);
				start++;
				end++;
			}

		}
		System.out.println(max);
	}

	private static void disticnt(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int max = 0;

		while (end < s.length()) {
			map.put(s.charAt(end), map.getOrDefault(end, 0) + 1);
			if (map.size() <= k) {
				max = Math.max(max, end - start + 1);
			}
			while (map.size() > k) {
				int d = map.get(s.charAt(start));
				map.put(s.charAt(start), d - 1);
				if (map.get(s.charAt(start)) == 0) {
					map.remove(s.charAt(start));
				}
				start++;

			}
			end++;
		}
	}

	private static void kdisticnt(String s, int i) {
		char a[] = s.toCharArray();
		int distance = 0;
		int end = 0;
		char d = ' ';
		int k = 0;
		int max = 0;
		int start = 0;
		while (end < s.length()) {
			d = a[end];
			if (d != a[start]) {
				k++;
			}
			distance = end - start + 1;
			if (k == i) {
				max = Math.max(max, distance);
			}
			if (k > i) {

				start = end;
				distance = 0;

			}
			end++;
		}
		System.out.println(max);
	}

	public static void reverse(String s) {
		char c[] = s.toCharArray();
		String p = "";
		for (int j = s.length() - 1; j > 0; j--) {
			p = p + c[j];
		}
		System.out.println(p);
	}

	public static void reverse1(String s) {
		Stack<Character> st = new Stack<Character>();
		char c[] = s.toCharArray();
		int i = 0;
		int end = c.length - 1;
		for (int j = 0; j < s.length(); j++) {
			st.push(c[j]);
		}
		System.out.println(st);
	}

	private static void replace(String s, char c, char d) {

		char t[] = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (t[i] == c) {
				t[i] = d;
			}
		}
		System.out.println(new String(t));

	}

	static void uniqueCharcters(String s) {
		int de = 0;
		char[] c = s.toCharArray();
		char[] d = new char[c.length];
		Set<Character> ar = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!ar.contains(c[i]) && c[i] != ' ') {
				de++;
				ar.add(c[i]);
			}
		}
		System.out.println(de);
	}

	static void reverseword(String str) {
		char c[] = str.toCharArray();
		String s = " ";
		String finalString = "";
		for (int i = 0; i < str.length(); i++) {
			if (c[i] == ' ') {
				finalString = s + finalString + " ";
				s = " ";
			} else {
				s = s + c[i];
			}
		}
		finalString = s + finalString + " ";
		System.out.println(finalString);

	}

	private static void deverseindividual(String str) {

		String finalStr = "";
		String tempStr = "";
		char c[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {

			if (c[i] == ' ') {
				finalStr = finalStr + tempStr + " ";
				tempStr = "";
			} else {
				tempStr = str.charAt(i) + tempStr;
			}
		}
		finalStr = finalStr + tempStr;
		System.out.println(finalStr);
	}

	private static void reverseindividual(String s) {
		char t[] = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			int d = i;
			int c = i;
			while (t[i] != ' ' && t[i] != '\0') {
				d++;
				i++;
			}
			for (int j = d; j >= c; j--) {
				System.out.println(t[j]);
			}

		}

	}

	private static void trim(String s) {
		char[] c = s.toCharArray();
		int i = 0;
		int end = s.length() - 1;
		int start = 0;

		int f = 0;
		while (c[i] == ' ') {
			f++;
			i++;
		}
		int d = 0;
		while (c[end] == ' ') {
			d++;
			end--;
		}

		System.out.println(s.substring(f, s.length() - d));
		System.out.println(s.trim());

	}

	private static void charcters(String s) {

		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (c[i] != ' ') {
				if (i == 0) {
					System.out.println(c[i]);
				} else if (c[i - 1] == ' ') {
					System.out.println(c[i]);
				}
			}
		}
	}
}
