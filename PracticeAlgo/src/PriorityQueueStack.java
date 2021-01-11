import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class cod {
	int x;
	int y;

	public cod(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class PriorityQueueStack {

	static int arr[] = new int[10];
	static int size = 0;

	static void insert(int value) {
		arr[size] = value;
		int parent = (size - 1) / 2;
		int index = size;
		while (parent >= 0 && arr[index] > arr[parent]) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
			index = parent;
			parent = (parent - 1) / 2;

		}
		size++;
	}

	static void delete() {
		arr[0] = arr[size - 1];
		int start = 0;
		int child1 = (start + 1) * 2;
		int child2 = (start + 2) * 2;
		if (arr[child1] > arr[start]) {
			start = child1;
		}
		if (arr[child2] > arr[start]) {
			start = child2;
		}

		int temp = arr[start];

	}

	static void kthlargest(int arr[], int value) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		if (queue.size() != 0) {
			queue.add(value);
		} else {
			if (value < queue.peek()) {
				queue.poll();
				queue.add(value);
			}
		}

	}

	static void topfrequent(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pr = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> {
			return a.getValue() - b.getValue();

		});

		pr.addAll(map.entrySet());

	}

	static void kclosetpoint(List<cod> list, int k) {
		PriorityQueue<cod> pr = new PriorityQueue<cod>((a, b) -> {

			int x = a.x * a.x + a.y * a.y;
			int y = b.x * b.x + b.y * b.y;
			if (x != y) {
				return y - x;
			}
			return 0;

		});

		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			if (pr.size() < 3) {
				pr.add(new cod(x, y));
			} else {
				int value = x * x + y * y;
				if (value < pr.peek().x * pr.peek().y) {
					pr.poll();
					pr.add(new cod(x, y));
				}
			}
		}
		while (!pr.isEmpty()) {
			cod c = pr.poll();
			System.out.println(c.x + " " + c.y);
		}

	}

	static void ropecost(int arr[]) {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pr.add(arr[i]);
		}
		int sum = 0;
		while (!pr.isEmpty()) {
			int value = pr.poll() + pr.poll();
			sum = sum + value;
			pr.add(value);

		}

	}

	static void largest(String word, int k) {
		Queue<Character> q = new LinkedList<Character>();
		int start = 0;
		int end = 0;
		int max = 0;
		while (start < word.length()) {

			while (q.contains(word.charAt(start))) {

				while (end < start) {
					q.remove();
					end++;
				}

			}
			q.add(word.charAt(start));
			max = Math.max(start - end + 1, max);
			start++;

		}
		System.out.println(max);
	}

	static void comparetwostring(String a, String b) {
		String c = withoutx(a);
		String d = withoutx(b);
		if (c.equals(d)) {
			System.out.println(true);
		}

	}

	private static String withoutx(String a) {

		int start = 0;
		int end = a.length() - 1;
		int i = 0;
		String b = "";
		while (end >= start) {

			while (a.charAt(end) == '#') {
				i++;
				end--;
			}
			if (i != 0) {
				i--;
				end--;
			} else {
				b = a.charAt(end) + b;
				end--;
			}

		}

		return b;

	}

	static void anagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int end = 0;
		while (start < s.length())
			map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);

		start = 0;

		while (start < t.length()) {
			while (map.containsKey(t.charAt(start))) {
				int value = map.get(t.charAt(start));

				if (value == 0 && map.size() == 0) {
					System.out.println(start - end + 1);
				}
				map.put(t.charAt(start), value - 1);
				start++;
			}
			if(!map.containsKey(t.charAt(start)))
			{
				while (!map.containsKey(t.charAt(end))) {
					int value = map.get(t.charAt(end));

					if (value == 0 && map.size() == 0) {
						System.out.println(start - end + 1);
					}
					map.put(t.charAt(start), value + 1);
					end++;
				}
			}
		}

	}

	public static void main(String[] args) {
		String str = "abc##d";
		String b = "ad#d";

		comparetwostring(str, b);
	}

}
