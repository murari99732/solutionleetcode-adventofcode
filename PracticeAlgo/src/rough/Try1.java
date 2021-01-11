package rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Try1 {

	
	static void help(int arr[], int br[])
	{
	
		for(int i=0;i<br.length;i++)
		{
			if(br[i]!=i)
			{
				int j=br[i];
				int temp=br[i];
				br[i]=br[j];
				br[j]=temp;
				int temp1=arr[i];
				arr[i]=arr[j];
				arr[j]=temp1;
			}
		}
		for(int i=0;i<br.length;i++)
		{
			System.out.println(arr[i]);
		}
	
	}
	
	static void longestspanning(int arr[], int brr[]) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int sumb = 0;
		int max = 0;
		int ending = 0;
		while (start < arr.length - 1 && end < brr.length - 1) {
			sum = sum + arr[start];
			sumb = sumb + arr[end];
			if (sum == sumb) {
				max = Math.max(start - ending + 1, max);
				start++;
				end++;
				ending--;
			}
			while(sumb<sum)
			{
				
			}

		}
	}

	public static void delete(int arr[], int value) {
		int end = 0;
		int start = 0;
		int mul = 1;
		int max = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		while (end < arr.length - 1 && start <= end) {
			mul = mul * arr[end];
			if (mul > value) {
				mul = mul / arr[start];
				start++;

			}
			if (mul < value) {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				System.out.println();
				System.out.println(mul + " " + value);
				System.out.println(arr[end]);
				System.out.println(arr[start]);
				for (int j = end; j >= start; j--) {

					ar.add(0, arr[j]);
				}
				list.add(new ArrayList<Integer>(ar));
				end++;
			}
		}
		System.out.println(list);
	}

	static void smallest(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		int f = -1;
		int g = -1;
		while (start < arr.length && end >= 0 && start <= end) {
			if (arr[start] > arr[start + 1] && f < 0) {
				f = start;
			}
			if (arr[end - 1] > arr[end] && g < 0) {
				g = end;
			}

			end--;
			start++;

		}
		int ar[] = new int[g - f + 1];
		int k = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(arr[f], arr[i]);
			max = Math.max(max, arr[g]);
		}
		System.out.println(min + " " + max);

	}

	public static void subArrayWithProductMultiplicationLessThanGivenNumber(int[] arr, int val) {
		int multiplicationOfElements = 1;
		int start = 0;
		List<List<Integer>> solution = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			multiplicationOfElements = multiplicationOfElements * arr[i];

			while (multiplicationOfElements >= val) {
				multiplicationOfElements = multiplicationOfElements / arr[start];
				start++;
			}

			List<Integer> list = new ArrayList<>();

			for (int j = i; j >= start; j--) {
				list.add(0, arr[j]);

				solution.add(new ArrayList<>(list));
			}
		}
		delete(arr, val);

		System.out.println();
		System.out.println(solution);
	}

	public static void triplet(int arr[], int sum) {
		Arrays.sort(arr);
		int i = 0;

		while (i < arr.length - 2) {
			int end = arr.length - 1;
			int k = i + 1;
			while (k <= end) {
				int add = arr[k] + arr[end] + arr[i];
				if (add > sum) {
					end--;
				} else if (add < sum) {
					k++;
				}

				else {
					System.out.println(arr[i] + " " + arr[k] + " " + arr[end]);
					end--;
					k++;
				}

			}
			i++;
		}
	}

	public static void triplet1(int arr[], int sum) {

		int i = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (i < end && mid >= i && mid <= end) {
			mid = (i + end) / 2;
			if (arr[i] + arr[mid] + arr[end] > sum) {
				end--;
			} else if (arr[i] + arr[mid] + arr[end] < sum) {
				i++;
			} else {
				System.out.println(arr[i] + " " + arr[end] + " " + arr[mid]);
				i++;
				end--;
			}
		}

	}

	static void triplet2(int arr[], int sum) {
		Arrays.sort(arr);
		int i = 0;
		while (i < arr.length - 2) {
			int d = sum - arr[i];
			for (int j = i + 1; j < arr.length - 1; j++) {
				int s = arr[j] + arr[j + 1];
				if (s == d) {
					System.out.println("true");
				}
			}
			i++;
		}
	}

	public static void quardople(int arr[], int n) {
		Arrays.sort(arr);
		int start = 0;
		while (start < n - 3) {
			int i = start + 1;
			int end = arr.length - 1;

			while (i < end) {
				int mid = (i + end) / 2;
				int add = arr[start] + arr[i] + arr[mid] + arr[end];
				if (add > n) {
					end--;
				} else if (add < n) {
					i++;

				} else {
					System.out.println(true + " " + arr[start] + " " + arr[i] + " " + arr[end] + " " + arr[mid]);
					i++;
					end--;
				}

			}
			start++;

		}
	}

	static void square(int A[]) {
		int start = 0;

		int end = A.length - 1;
		while (start < A.length && start <= end) {
			int d = A[start] * A[start];
			if (A[end] * A[end] > d) {
				A[end] = A[end] * A[end];
				if (A[end + 1] < A[end]) {

					int de = A[end + 1];
					A[end + 1] = A[end];
					A[end] = de;

				}
				end--;

			}
			if (A[end] * A[end] < d) {
				int de = A[start] * A[start];
				int temp = de;
				A[start] = A[end];
				A[end] = temp;

			}
			if (A[end + 1] < A[end]) {

				int de = A[end + 1];
				A[end + 1] = A[end];
				A[end] = de;

			}
			end--;
		}
		System.out.println(10);

	}

	public static void removeduplicate(int arr[]) {

		int k = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[k++] = arr[i];
			}

		}
		for (int j = 0; j < k; j++) {
			System.out.println(arr[j]);
		}
	}

	public static void quicksort(int arr[]) {
		int start = 1;
		int end = arr.length - 1;
		int pivot = 0;

		while (start <= end) {

			while (arr[pivot] > arr[start]) {
				start++;
			}
			while (arr[pivot] < arr[end]) {
				end--;
			}
			if (arr[start] > arr[end]) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}

		}
		if (end - start > 0) {
			int temp = arr[end];
			arr[end] = arr[pivot];
			arr[pivot] = temp;

		}

	}

	public static void frequency(List<Integer> arr) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			m.put(arr.get(i), m.getOrDefault(arr.get(i), 0) + 1);
		}

		Collections.sort(arr, (n1, n2) -> {
			int f = m.get(n1);
			int g = m.get(n2);
			if (f < g) {
				return f - g;
			}
			return arr.indexOf(n1) - arr.indexOf(n2);

		});
		System.out.println(arr);
	}

	static void shuffle(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			Random rand = new Random();
			int d = rand.nextInt(arr.length);
			int temp = d;
			d = arr[i];
			arr[i] = temp;
		}
	}

	static void max(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = 0;
		while (end < arr.length) {
			sum = sum + arr[end];

			if ((end - start + 1) > k) {
				sum = sum - arr[start];
				start++;
			}
			max = Math.max(sum, max);
			end++;
		}
		System.out.println(max);
	}

	public static void maxElementOfKSizeSubArray(int[] arr, int k) {
		if (arr.length == 0 || k <= 0 || k > arr.length) {
			return;
		}

		Deque<Integer> queue = new LinkedList<>();
		int i;
		for (i = 0; i < k; i++) {
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		for (; i < arr.length; i++) {
			System.out.print(arr[queue.peek()] + " ");

			while (!queue.isEmpty() && i - k >= queue.peek()) {
				queue.removeFirst();
			}

			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		System.out.print(arr[queue.peek()]);
	}

	public static void maximumk(int arr[], int k) {
		Deque<Integer> queue = new LinkedList<Integer>();
		int i = 0;
		for (i = 0; i < k; i++) {
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}
			queue.addLast(i);
		}

		for (int j = i; j < arr.length; j++) {
			System.out.println(queue.peek());
			while (arr[j] > arr[queue.peek()] && j - k > queue.peek()) {
				queue.removeFirst();
			}
			while (arr[j] < arr[queue.peekLast()]) {
				queue.removeLast();
			}
			queue.addLast(arr[j]);
		}
	}

	public static void maximumsum(int arr[]) {
		int start = 0;
		int sum = 0;
		int max = 0;
		while (start < arr.length) {
			sum = sum + arr[start];
			if (sum < 0) {
				sum = 0;
			}
			max = Math.max(sum, max);
			start++;

		}
		System.out.println(max);
	}

	static void smallestsubarry(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = Integer.MAX_VALUE;
		while (start < arr.length - 1 && start >= end) {
			sum = sum + arr[start];

			if (sum == k) {
				max = Math.min(max, start - end + 1);
				end++;
				start++;
			}
			while (sum > k) {
				sum = sum - arr[end];
				end++;
			}
			start++;
		}
		System.out.println(max);
	}

	static void maximumsubarrya(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = 0;
		while (start < arr.length) {
			sum = sum + arr[start];

			if (sum == k) {
				System.out.println(start - end + 1);
				break;
			}
			while (sum > k) {
				sum = sum - arr[end];

				end++;
				if (sum == k) {
					System.out.println(start - end + 1);
					break;
				}

			}
			start++;
		}

	}

	static void findfirstrepeat(int arr[], int d) {

		Map<Integer, Integer> hashset = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hashset.containsKey(arr[i])) {
				hashset.put(arr[i], hashset.get(arr[i]));
			} else
				hashset.put(arr[i], i);

		}
		if (hashset.containsKey(d)) {
			System.out.println(hashset.get(d));
		}

		HashSet<Integer> has = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (has.contains(arr[i])) {
				System.out.println("value " + arr[i]);
				break;
			} else {
				has.add(arr[i]);
			}
		}

	}

	static void findAdjacentvalue(int arr[], int value, int position) {

		int b[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int d = Math.abs(arr[i] - value);
			if (d % position == 0) {
				int c = d / position;
				b[c] = arr[i];
			}
		}
		for (int kl : b) {
			System.out.println(kl);
		}

	}

	static void equilbirium(int arr[]) {

		int start = 0;

		while (start < arr.length) {
			int i = 0;
			int sumc = 0;
			int startc = 0;
			while (i < start) {
				sumc = sumc + arr[i];
				i++;
			}
			i = start + 1;
			while (i < arr.length) {
				startc = startc + arr[i];
				i++;
			}
			if (sumc == startc) {
				System.out.println(true);
			}
			start++;
		}
	}

	static void detuchebank(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		int k = 0;
		int l = 0;
		int m = 0;
		int mid = 0;
		while (i < arr.length) {
			if (arr[i] == 1) {

			}

		}
		System.out.println();

	}

	public static void flag(int arr[]) {

		int i = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (mid <= end) {

			switch (arr[mid]) {
			case 0:
				if (arr[mid] != arr[i]) {
					int temp = arr[i];
					arr[i] = arr[mid];
					arr[mid] = temp;
				}
				i++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				if (arr[mid] != arr[end]) {
					int temp = arr[end];
					arr[end] = arr[mid];
					arr[mid] = temp;
				}
				end--;
			}
		}
	}

	public static void deque(int arr[], int k) {
		Deque<Integer> dequeue = new LinkedList<Integer>();
		int i = 0;
		for (i = 0; i < k; i++) {
			while (!dequeue.isEmpty() && arr[i] > dequeue.peek()) {
				dequeue.removeLast();
			}
			dequeue.addLast(arr[i]);
		}

		for (; i < arr.length; i++) {
			while (!dequeue.isEmpty() && i - k <= dequeue.peek()) {
				dequeue.removeFirst();
			}
			while (!dequeue.isEmpty() && arr[i] > arr[dequeue.peekLast()]) {
				dequeue.removeLast();
			}
		}
	}

	static void largestsubset(int arr[]) {
		int start = 0;
		int end = 0;
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

	static void happynumber(int d) {

		HashSet<Integer> has = new HashSet<Integer>();
		while (d != 1) {

			int sum = extracted(d);
			if (!has.contains(sum)) {
				has.add(sum);
			} else {
				System.out.println(false);
				return;
			}
			d = sum;
		}

	}

	private static int extracted(int d) {
		int sum = 0;
		while (d > 0) {

			int num = d % 10;
			d = d / 10;
			sum = sum + num * num;

		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = { 10,5,4,3};
		int arr1[]= {0,3,2,1};
		// largestsubset(arr);
		help(arr,arr1);

	}
}
