package rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class MissingKPositive {

	static void kpositive(int arr[], int value) {
		int start = 0;
		int end = 0;
		int d = 0;
		int max = 0;
		int k = 0;
		while (end < arr.length) {

			if (k > value) {
				while (end < start && k == value) {
					if (arr[start] == 0) {
						k--;
					}
					start++;

				}
			}
			if (k <= value) {
				if (arr[end] == 0)
					k++;

				max = Math.max(max, end - start + 1);
			}
			end++;
		}
		System.out.println(max);
	}

	static void duplicatepair(int arr[]) {
		int start = 0;
		int d = 0;
		while (start < arr.length - 1) {
			if (arr[start] != arr[arr[start] - 1]) {
				d++;
			}
			start++;
		}
		System.out.println(d);
	}

	static void cyclic(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != i + 1) {
				int swap = arr[i] - 1;
				int temp = arr[swap];
				arr[swap] = arr[i];
				arr[i] = temp;
			} else {
				i++;
			}
		}
		for (int j : arr) {
			System.out.println(j);
		}
	}

	static boolean circulararray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {

			boolean b = arr[i] < 0 ? true : false;
			int fast;
			int slow;
			while (true) {
				slow = move(arr, i, b);
				if (slow == -1) {
					break;
				}
				fast = move(arr, i, b);
				if (fast == -1) {
					break;
				}

				fast = move(arr, i, b);
				if (fast == -1) {
					break;
				}
				if (fast == slow) {
					return true;
				}
			}

		}
		return false;
	}

	static void getMultiplication(int arr[], int n) {
		int start = 0;
		int end = 0;
		int mul = 1;
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		while (start < arr.length - 1) {
			mul = arr[start] * mul;
			while (mul > n) {
				mul = mul / arr[end];
				end++;
			}

			start++;

			if (n > mul) {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				for (int i = start; i >= end; i--) {
					ar.add(0, arr[i]);
					a.add(new ArrayList<Integer>(ar));
				}

			}

		}
		System.out.println(a);
	}

	static void minimumsubarray(int arr[]) {
		int start = 1;
		int end = arr.length - 2;
		int fvalue = 0;
		int svalue = 0;
		while (start < end) {
			if (arr[start - 1] > arr[start]) {
				fvalue = start - 1;
				break;
			}
			if (arr[end + 1] < arr[end]) {
				svalue = end + 1;
				break;
			}
			start++;
			end--;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int d = 0;
		int g = 0;
		for (int i = fvalue; i < svalue; i++) {

			min = Math.min(min, arr[i] > arr[min] ? i : min);

			max = Math.max(max, arr[i] > arr[min] ? i : min);
		}

		for (int i = fvalue; i < svalue; i++) {
			arr[i++] = arr[fvalue];
		}

	}

	private static void triplet(int arr[], int s) {
		int start = 0;
		int end = 0;
		while (start < end) {
			int mid = ((start + 1) + end) / 2;
			if (s < arr[mid]) {

			}
		}
	}

	static void square(int arr[]) {
		int b[] = new int[arr.length];
		int start = 0;
		int end = arr.length - 1;
		int j = arr.length - 1;
		while (start < end) {
			if (arr[start] * arr[start] < arr[end] * arr[end]) {
				b[j--] = arr[end] * arr[end];
				end--;
			} else {
				b[j--] = arr[start] * arr[start];
				start++;
			}
		}
		for (int k : b) {
			System.out.println(k);
		}
	}

	private static int move(int[] arr, int i, boolean b) {

		boolean a = arr[i] < 0 ? true : false;
		if (a != b) {
			return -1;
		}
		int moves = i + arr[i] % arr.length;
		if (moves == arr[i]) {
			return -1;
		}
		if (moves < 0) {
			moves = arr.length - i + arr[i];
		}

		return moves;
	}

	static void removeduplicate(int arr[]) {
		int start = 0;
		int d = 0;
		while (start <= arr.length - 1) {
			if (arr[start] != arr[start + 1]) {
				arr[d++] = arr[start];
			}

			start++;

		}
		for (int h : arr) {
			System.out.println(h);
		}
	}

	static void frequency(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
		}

		Collections.sort(arr, (n1, n2) -> {
			int freq1 = map.get(n1);
			int freq2 = map.get(n2);
			if (freq1 > freq2) {
				return freq1 - freq2;
			}
			return arr.indexOf(n1) - arr.indexOf(n2);
		});

	}

	static void shuffle(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			Random r = new Random();
			int d = r.nextInt(i);
			int temp = arr[i];
			arr[d] = arr[i];
			arr[i] = temp;
		}
	}

	static void maximumsubarray(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = 0;
		while (end < arr.length - 1) {
			if (end - start + 1 <= k) {
				sum = sum + arr[end];
				max = Math.max(max, sum);
				end++;
			} else {
				sum = sum - arr[start];
				start++;
			}
		}
		System.out.println(sum);
	}

	static void maximumsub(int arr[], int k) {
		Deque<Integer> dequeue = new LinkedList<Integer>();
		int max = 0;
		int start = 0;
		int end = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		while (end < arr.length) {
			if (end - start + 1 <= k) {
				if (dequeue.isEmpty()) {
					dequeue.push(arr[start]);

				} else if (arr[end] > dequeue.peekFirst()) {
					while (!dequeue.isEmpty()) {
						dequeue.removeLast();
					}
					dequeue.push(arr[end]);
				} else if (arr[end] < dequeue.peekFirst() && arr[end] > dequeue.peekLast()) {
					while (arr[end] > dequeue.peekLast()) {
						dequeue.removeLast();
					}
					dequeue.push(arr[end]);
				}
				max = Math.max(max, dequeue.peekFirst());
				ar.add(max);
				end++;
			} else {
				dequeue.removeFirst();
				start++;

			}
		}
		System.out.println(ar);

	}

	static void kadanes(int arr[]) {
		int end = 0;
		int start = 0;
		int max = 0;
		int sum = 0;

		while (start < arr.length - 1) {
			sum = sum + arr[start];
			max = Math.max(max, sum);
			start++;
			if (sum < 0) {
				sum = 0;
				continue;
			}

		}
		System.out.println(max);
	}

	static void smallestarray(int arr[], int sum) {
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int value = 0;

		while (start < arr.length) {
			value = value + arr[start];

			if (value == sum) {
				min = Math.min(start - end + 1, min);
				value = value - arr[end];
				end++;
			}

			while (value > sum) {
				value = value - arr[end];
				end++;
				if (value == sum) {
					min = Math.min(start - end + 1, min);
					value = value - arr[end];

				}

			}
			start++;

		}
		System.out.println(min);
	}

	static void maximum(int arr[], int sum) {
		int start = 0;
		int end = 0;
		int value = 0;
		int max = 0;
		while (start < arr.length && start >= end) {
			value = value + arr[start];
			max = Math.max(value, max);
			if (start - end + 1 >= sum) {
				value = value - arr[end];
				end++;
			}
			start++;
		}
		System.out.println(max);
	}

	static void eachwindow(int arr[], int window) {
		int start = 0;
		int end = 0;
		int value = 0;
		Deque<Integer> dequeue = new LinkedList<Integer>();
		while (start < arr.length) {

			if (start - end + 1 < window) {
				if (dequeue.isEmpty()) {
					value = value + arr[start];
					dequeue.add(value);
					start++;
				} else {
					while (start - end + 1 < window) {
						value = value + arr[start];
						if (value > dequeue.peek()) {
							dequeue.remove();
							dequeue.add(value);
						}
						start++;
					}
					System.out.println(dequeue.peek());
				}
			} else if (start - end + 1 >= window) {
				while (start - end + 1 > window) {
					value = value - arr[end];
					end++;
				}

			}

		}
		System.out.println(dequeue);
	}

	static void subarray(int arr[], int sum) {
		int start = 0;
		int end = 0;
		int value = 0;
		while (start < arr.length && end <= start) {
			value = value + arr[start];
			if (value == sum) {
				System.out.println(start + " " + end);

			} else {
				start++;
			}
			while (value > sum) {
				value = value - arr[end];
				end++;
				if (value == sum) {
					System.out.println(start + " " + end);

				}

			}

		}
	}

	static void multiplication(int arr[], int n) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mul = arr[start] * arr[end];
			if (mul < n) {
				end--;
			} else if (mul > n) {
				start++;
			} else {
				System.out.println(arr[start] + " " + arr[end]);
				start++;
				end--;
			}
		}
	}

	static void multiplication1(int arr[], int n) {
		int start = 0;
		int end = arr.length - 1;

		Map<Integer, Integer> map = new HashMap<>();
		while (start < arr.length) {
			map.put(start, arr[start]);
			start++;
		}
		start = 0;
		while (start < arr.length) {
			int mul = n / arr[start];
			if (map.containsValue(mul)) {
				System.out.println(arr[start] + " " + mul);
			}
			start++;
		}
	}

	static void union(int arr[], int arr1[]) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int start = 0;
		int start1 = 0;
		while (start < arr.length && start1 < arr1.length) {
			while (arr[start] == arr[start + 1]) {
				start++;
			}
			while (arr[start1] == arr[start1 + 1]) {
				start1++;
			}
			if (arr[start] > arr1[start1]) {
				ar.add(arr1[start1]);
				start1++;
			} else if (arr[start] < arr1[start1]) {
				ar.add(arr[start]);
				start++;
			} else {
				ar.add(arr[start]);
				start++;
				start1++;
			}
		}

	}

	static void nonrepeating(int arr[]) {
		int start = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<Integer>();
		while (start < arr.length) {
			if (!q.contains(arr[start])) {
				q.add(arr[start]);
			} else if (q.contains(arr[start])) {
				q.remove();
			}
			start++;
		}
		System.out.println(q.peek());
	}

	static void nonrep(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0;
		while (start < arr.length) {

			map.put(arr[start], map.getOrDefault(arr[start], 0) + 1);
			if (map.containsValue(2)) {
				System.out.println(arr[start]);
				break;
			}
			System.out.println(map);
			start++;
		}

	}

	static void firstoccurrence(int arr[], int v) {
		int start = 1;
		while (start < arr.length - 1) {
			if (arr[start] == v) {
				if (Math.abs(arr[start] - arr[start + 1]) == 1 && Math.abs(arr[start - 1] - arr[start]) == 1) {
					System.out.println(start + " " + arr[start]);
					break;
				}
			}
			start++;
		}
	}

	static void findpair(int arr[], int value) {
		int start = 1;
		while (start < arr.length) {
			int sum = arr[start] + arr[start - 1];
			if (sum == value) {
				System.out.println(arr[start] + " " + arr[start - 1]);
			}
			start++;
		}
	}

	static void middle(int arr[]) {
		int start = 0;

		while (start <= arr.length) {
			int end = start + 1;
			int sum = 0;
			int sumf = 0;
			int d = end - 1;
			while (d < end && d >= 0) {
				sum = sum + arr[d];
				d--;
			}
			d = end + 1;
			while (d < arr.length) {
				sumf = sumf + arr[d];
				d++;
			}
			if (sumf == sum) {
				System.out.println(true);
				break;
			}
			start++;

		}
	}

	public static int getEquilibriumPoint(int[] a) {
		if (a.length == 0) {
			return -1;
		}

		int sum = 0;
		int sum_so_far = 0;

		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}

		for (int i = 0; i < a.length; i++) {
			sum = sum - a[i];
			if (sum == sum_so_far) {
				return i;
			}
			sum_so_far = sum_so_far + a[i];
		}

		return -1;
	}

	static void dutch(int arr[]) {

		int mid = 0;
		int start = 0;
		int end = arr.length - 1;
		while (mid < end && start <= mid) {
			if (arr[mid] == 0) {
				if (arr[start] != 0) {
					int temp = arr[start];
					arr[start] = arr[mid];
					arr[mid] = temp;
				}
				mid++;
				start++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				if (arr[end] != 2) {
					int temp = arr[end];
					arr[end] = arr[mid];
					arr[mid] = temp;
				}
				mid++;
				end--;
			}
		}
		for (int k : arr) {
			System.out.print(" " + k);
		}

	}

	static void largest(int arr[]) {
		int start = 0;
		int sum = 0;
		int max = 0;
		while (start < arr.length) {
			sum = sum + arr[start];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
			start++;
		}
		System.out.println(max);
	}

	public static void largestContiguousSubArrayNegative(int[] a) {
		int max_so_far, current_max;
		max_so_far = current_max = a[0];

		for (int i = 1; i < a.length; i++) {
			current_max = Math.max(a[i], current_max + a[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}

		System.out.println(max_so_far);
	}

	static void insert(int arr[], int value) {

		for (int i = arr.length - 1; i > 0; i--) {
			int d = i - 1;
			System.out.println(i + " " + d);
			arr[i] = arr[i - 1];
		}
		arr[0] = value;

	}

	static void position(int arr[], int position, int value) {
		int d = 0;
		for (int i = arr.length - 1; i > position; i--) {

			arr[i] = arr[i - 1];
		}
		arr[position] = value;
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void mindistance(int arr[], int x, int y) {

		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int d = Integer.MAX_VALUE;
		int e = Integer.MAX_VALUE;
		while (start < arr.length) {

		}
		System.out.println(min);

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2 };
		// System.out.println(getEquilibriumPoint(arr));
		// kpositive(arr, 2);
		mindistance(arr, 1, 2);
		// largestContiguousSubArrayNegative(arr);
	}
}
