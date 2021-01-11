import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AutoComplete {

	static void complete(String v, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).substring(0, v.length()).equals(v)) {
				System.out.println(list.get(i));
			}
		}
	}

	static class wor {
		char a;
		int pos;
	}

	static void patternmatching(String word, String value) {
		Deque<wor> queue = new LinkedList<AutoComplete.wor>();
		wor x = new wor();
		x.a = word.charAt(0);
		x.pos = 0;
		queue.add(x);
		int start = 0;
		while (start < word.length()) {

		}
	}

	static void knuttmoris(String a, String b) {
		int arr[] = new int[b.length()];
		int start = 1;
		int end = 0;
		int k = 0;
		while (k < b.length() && start >= end) {
			if (start < arr.length && b.charAt(start) != b.charAt(k)) {
				arr[k] = end;
				start++;
				k++;
			} else {

				int val = 0;
				while (start < arr.length && b.charAt(start) == b.charAt(end)) {
					arr[k] = val++;
					end++;
					start++;
					k++;
				}
				int d = arr[end - 1];
				d = end;

			}
		}
		for (int g : arr) {
			System.out.println(g);
		}

	}

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		String c = s.next(); // Reading input from STDIN

		System.out.println("d");

	}

}
