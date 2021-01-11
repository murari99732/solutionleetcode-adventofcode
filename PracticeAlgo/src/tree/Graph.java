package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graph {

	public static void main(String[] args) {

		int arr[] = { 3, 2, 5, 5, 3, 2, 10, 2 };

		smallestsubarray(arr, 12);

	}

	static void smallestsubarray(int arr[], int sum) {
		int start = 0;
		int end = 0;
		int add = 0;
		int max = 0;
		while (start < arr.length && end <= start) {
			add = add + arr[start];
			if (add == sum) {
				System.out.println(true+" "+start+" "+end);
			}
			while (add > sum) {
				add = add - arr[end];
				end++;
				if (add == sum) {
					System.out.println(true+" "+start+" "+end);
				}

			}

			start++;

		}
	

	}

	static void maxsubarrayblock(int arr[], int k) {
		Deque<Integer> queue = new LinkedList<Integer>();
		int start = 1;
		int end = 0;
		queue.add(arr[0]);
		System.out.print(queue.peek() + " ");
		while (start < arr.length) {
			if (queue.peek() > arr[start] && queue.size() < k) {
				queue.addLast(arr[start]);
				System.out.print(queue.peekFirst() + " ");
			} else if (queue.peek() < arr[start] && queue.size() < k) {
				while (!queue.isEmpty()) {
					queue.pop();
				}
				queue.addFirst(arr[start]);
				System.out.print(queue.peekFirst() + " ");
			} else if (queue.size() >= k || start - end < 3) {
				queue.removeFirst();
				System.out.print(queue.peekFirst() + " ");
			}
			start++;
		}
	}

	static void maxSubArray(int arr[]) {
		int start = 0;
		int end = 0;
		int max = 0;
		int sum = 0;
		while (start < arr.length) {
			sum = sum + arr[start];
			max = Math.max(sum, max);
			if (sum < 0) {
				sum = 0;
				end = start;
			}
			start++;
		}
		System.out.println(max);
	}

	static void frequency(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
		}
		Collections.sort(arr, (a, b) -> {
			int freq1 = map.get(a);
			int freq2 = map.get(b);
			if (freq1 != freq2) {
				return freq2 - freq1;
			}
			return arr.indexOf(a) - arr.indexOf(b);
		});

		System.out.println(arr);
	}

	static void square(int ar[]) {
		TreeSet<Integer> hashset = new TreeSet<Integer>(Collections.reverseOrder());
		for (int i = 0; i < ar.length; i++) {
			hashset.add(ar[i] * ar[i]);
		}
		System.out.println(hashset);
	}

	static void triplet1(int arr[], int sum) {
		int start = 0;
		int end = arr.length;
		Arrays.sort(arr);

		while (start < end) {
			int add = 0;
			int i = start + 1;
			add = sum - arr[i];
			int g = end;
			while (i < g) {
				if (arr[i] + arr[g] == add) {
					System.out.println(true);
				} else if (arr[i] + arr[g] > add) {
					i++;
				} else {
					end--;
				}
			}
			start++;

		}
	}

	static void multiplication(int arr[], int value) {
		int start = 0;
		int end = 0;
		int mul = 1;
		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		while (start < arr.length) {
			mul = mul * arr[start];
			while (mul > value) {
				mul = mul / arr[end];
				end++;
			}
			if (value == mul) {
				System.out.println(true);
			} else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				for (int i = start; i >= end; i--) {
					a.add(0, arr[i]);
					ar.add(new ArrayList<Integer>(a));
				}
			}

		}
	}

	static void maximumtwozero(int arr[], int position) {
		int max = 0;
		int start = 0;
		int end = 0;
		int curr = 0;
		while (start < arr.length) {
			if (arr[start] == 0) {
				curr++;
			}
			while (curr > 2) {
				if (arr[end] == 0) {
					curr--;
				}
				end++;
			}

			max = Math.max(max, start - end + 1);
			start++;
		}
		System.out.println(max);
	}

	static void reverse(int arr[]) {
		int s = 0;
		int e = arr.length - 1;
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			e--;
			s++;

		}
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void kmissing(int arr[], int n) {
		int i = 0;

		while (i < n) {
			if (arr[i] > 0 && arr[i] < n && arr[i] != i + 1) {
				int swap = arr[i] - 1;
				int temp = arr[swap];
				arr[swap] = arr[i];
				arr[i] = temp;
			}
			i++;

		}
		HashSet<Integer> set = new HashSet<Integer>();
		int p = 0;
		for (int j = 0; j < n; j++) {
			if (!set.contains(arr[j])) {
				set.add(arr[j]);
			} else {
				System.out.println(arr[j]);
				p++;
			}
		}
		System.out.println(p);

	}

	private static void delete(int[] price, int position) {

		int d = 0;
		for (int k : price)
			System.out.print(k + " ");
		System.out.println();
		for (int i = 0; i < price.length; i++) {
			if (i < position) {
				price[i] = price[i];
			} else if (i > position) {
				price[i - 1] = price[i];
			}

		}

		for (int k : price)
			System.out.print(k + " ");

	}

	static void insert(int arr[], int value) {
		for (int k : arr)
			System.out.print(k + " ");
		System.out.println();
		int brr[] = new int[arr.length + 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			brr[i + 1] = arr[i];
		}
		brr[0] = value;

		for (int k : brr)
			System.out.print(k + " ");
	}

	static void reduced(int arr[]) {
		TreeMap<Integer, Integer> tree = new TreeMap<>((a, b) -> {
			if (a > b) {
				return a - b;
			} else {
				return 0;
			}
		});

		for (int i = 0; i < arr.length; i++) {
			tree.put(arr[i], i);
		}
		System.out.print(tree + " ");
	}

	static void triangle(int m[][], int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				m[i][j] = m[i + 1][j] + m[i + 1][j + 1];
			}
		}
	}

	static void spiralmatrix(int matrix[][], int row_ending, int column_ending) {

		int row_starting = 0;
		int column_starting = 0;

		while (row_starting < row_ending && column_starting < column_ending) {

			for (int i = column_starting; i < column_ending; i++) {
				System.out.print(matrix[row_starting][i]);
			}
			row_starting++;

			for (int i = row_starting; i < row_ending; i++) {
				System.out.println(matrix[i][column_ending - 1]);
			}
			column_ending--;

			if (column_ending > column_starting) {
				for (int i = column_ending - 1; i > column_starting; i--) {
					System.out.print(matrix[row_ending][i]);
				}
				row_ending--;
			}
			if (row_starting < row_ending) {
				for (int i = row_ending - 1; i >= row_starting; i--) {
					System.out.print(matrix[i][column_starting]);
				}
				column_starting++;
			}

		}

	}

	static void rotatematrix90(int m[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 2; j >= 0; j--) {
				System.out.print(m[j][i]);
			}
			System.out.println();
		}
	}

	static void triangle(int arr[]) {
		int start = 0;

		while (start < arr.length) {
			if (start + 1 != 0) {

			}
		}
	}

	static void arrayrotatedpivot(int arr[], int pivot, int value) {
		int start = arr.length - pivot;
		if (arr[start] <= value && arr[arr.length - 1] >= value) {
			int i = start;
			int j = arr.length - 1;

			while (i < j) {
				int mid = (i + j) / 2;
				if (arr[mid] == value) {
					System.out.println(arr[mid] + " found");
					break;
				} else if (arr[mid] > value) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}

			}
		} else {
			int first = 0;
			start = start - 1;
			while (first < start - 1) {
				int mid = (first + start) / 2;

				if (arr[mid] == value) {
					System.out.println(arr[mid] + " found");
				} else if (arr[mid] > value) {
					start = mid - 1;
				} else {
					first = mid + 1;
				}
			}
		}
	}

	static void thirdlargetsnumber(int arr[], int k) {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			pr.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if (pr.peek() > arr[i]) {
				pr.poll();
				pr.add(arr[i]);
			}
		}
	}

	static void noelementadjacent(int arr[]) {
		int start = 0;
		while (start < arr.length) {
			if (start != start + 1) {

			}

		}
	}

	static void commonelement(int arr[], int brr[], int crr[]) {
		HashSet<Integer> hashset = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hashset.add(arr[i]);
		}
		for (int i = 0; i < brr.length; i++) {
			hashset.add(brr[i]);
		}
		for (int i = 0; i < crr.length; i++) {
			hashset.add(crr[i]);
		}
		System.out.println(hashset);
	}

	static void stock(int arr[]) {
		int start = 0;
		int sum = 0;
		while (start < arr.length - 1) {

			int d = 0;
			while (start + 1 < arr.length && arr[start] > arr[start + 1]) {

				start++;
				d = start;
			}
			d = arr[d];
			int e = 0;
			while (start + 1 < arr.length && arr[start] < arr[start + 1]) {

				start++;
				e = start;
			}
			sum = sum + arr[e] - d;

		}
		System.out.println(sum);
	}

	static void contigousarray(int arr[]) {
		int start = 0;
		int end = 0;
		int max = 0;
		while (start < arr.length - 2) {
			while (Math.abs(arr[end] - arr[start]) < arr.length) {
				max = Math.max(start - end + 1, max);
				start++;
			}
			end = start;
			start++;
		}
		System.out.println(max);
	}

	static void counttriplet(int arr[], int sum) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length;
		while (start < arr.length - 3) {
			int add = sum - arr[start];
			int d = start + 1;
			int e = end;
			while (d < e) {
				if (add == arr[d] + arr[e]) {
					System.out.println("true");
					break;
				} else if (add < arr[d] + arr[e]) {
					e--;
				} else {
					d++;
				}
			}
			start++;
		}
	}

	static void zigzag(int arr[]) {
		int start = 0;
		while (start + 1 < arr.length && start < arr.length) {
			int i = start + 1;
			if (arr[start] > arr[i]) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start = start + 2;
			} else {
				start = start + 2;
			}
			int d = start + 1;
			if (start + 1 < arr.length && arr[start] < arr[d]) {
				int temp = arr[start];
				arr[start] = arr[d];
				arr[d] = temp;
				start = start + 2;
			} else {
				start = start + 2;
			}

		}
		for (int k : arr) {
			System.out.print(k + " ");
		}
	}

	static void search(int arr[], int pivot, int value) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			int d = mid + pivot;
			System.out.print(arr[d] + " ");
			if (arr[d] == value) {
				System.out.println("waoo finally find out");
			} else if (arr[d] < value) {
				start++;
			} else {
				end--;
			}
		}
	}

	static void sprint(int arr[][], int k, int l) {

		int m = 0;
		int n = 0;
		while (m < k && n < l) {
			for (int i = 0; i < l; i++) {
				System.out.print(arr[m][i] + " ");
			}
			m++;
			for (int j = m; j < k; j++) {
				System.out.print(arr[j][l - 1] + " ");
			}
			l--;
			if (n < l) {
				for (int i = l - 1; i >= n; i--) {
					System.out.print(arr[k - 1][i] + " ");
				}
				k--;
			}
			if (m < k) {
				for (int i = k - 1; i >= m; i--) {
					System.out.print(arr[i][n] + " ");
				}
				n++;
			}

		}

	}

	static void spiralPrint(int m, int n, int a[][]) {
		int i, k = 0, l = 0;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

	static void rotatematrix(int arr[][]) {
		for (int i = 3; i >= 0; i--) {

			for (int j = 0; j < 4; j++) {
				int d = arr[j][i];
				System.out.print(d + " ");

			}
			System.out.println();
		}

	}

	static void spiralmatrix(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			} else {
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	static void maxdiff(int arr[]) {
		int start = 0;
		int end = 0;
		int max = 0;
		while (end < arr.length - 1) {
			while (end < arr.length && arr[start] <= arr[end]) {
				end++;
			}
			max = Math.max(max, arr[end - 1] - arr[start]);
			while (end + 1 < arr.length && arr[end] > arr[end + 1]) {
				start = end;
				end++;
			}
		}
		System.out.println(max);
	}

	static void movezero(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			if (arr[start] == 0) {
				if (arr[end] != 0) {
					int temp = arr[end];
					arr[end] = arr[start];
					arr[start] = temp;
				}

				end--;
			} else {
				start++;
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}

	}

	static void mergeelements(int arr[]) {
		int sum = 0;
		int k = 0;
		for (int i = 3; i < 5; i++) {
			sum = sum + arr[i];
			arr[k++] = sum;
		}
		System.out.println(arr.length);
	}

	static int findMinOps(int[] arr, int n) {
		int ans = 0; // Initialize result

		// Start from two corners
		for (int i = 0, j = n - 1; i <= j;) {
			// If corner elements are same,
			// problem reduces arr[i+1..j-1]
			if (arr[i] == arr[j]) {
				i++;
				j--;
			}

			// If left element is greater, then
			// we merge right two elements
			else if (arr[i] > arr[j]) {
				// need to merge from tail.
				j--;
				arr[j] = arr[j] + arr[j + 1];
				ans++;
			}

			// Else we merge left two elements
			else {
				i++;
				arr[i] = arr[i] + arr[i - 1];
				ans++;
			}
		}

		return ans;
	}

	static void sumcloset(int arr[]) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		int min = Integer.MAX_VALUE;
		while (start < end) {
			int min1 = arr[start] + arr[end];
			if (arr[start] + arr[end] == 0) {
				System.out.println(arr[start] + " " + arr[end]);
			} else if (min1 > arr[start] + arr[end]) {
				min = arr[start] + arr[end];
				start++;
				end--;
				min = Math.min(Math.abs(arr[start] + arr[end]), min);

			} else {
				end--;
			}
		}
		System.out.println(min);
	}

	static void biotnicarray(int arr[]) {
		int start = 0;
		int end = 0;
		boolean flag = false;
		int max = 0;
		while (start < arr.length - 1) {
			if (flag == false && arr[start] < arr[start + 1]) {
				flag = true;
				end = start;
			}
			while (flag && start < arr.length && arr[end] <= arr[start]) {
				start++;
			}
			if (flag == true) {
				max = Math.max(max, start - end);
				flag = false;
			}
			start++;

		}
		System.out.println(max);
	}

	static void lostElement(int arr[], int brr[]) {
		int start = 0;
		int first = 0;
		while (start < arr.length && first < brr.length) {
			if (arr[start] == arr[first]) {
				start++;
				first++;
			} else {
				System.out.println();
				break;
			}
		}
	}

	static void repeatin(int arr[], int l) {
		int start = 0;
		int d = 0;
		while (start < l) {
			if (arr[start] > 0 && arr[start] < l && arr[start] != arr[arr[start] - 1]) {
				int temp = arr[start] - 1;
				int h = arr[temp];
				arr[temp] = arr[start];
				arr[start] = h;

			} else {

				start++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				System.out.println(arr[i]);
			}
		}

	}

	static void minimumpair(int arr[]) {
		Arrays.sort(arr);
		int start = 0;
		int min = Integer.MAX_VALUE;
		while (start + 1 < arr.length && start < arr.length) {
			min = Math.min(min, arr[start + 1] - arr[start]);
			start++;
		}
		System.out.println(min);
	}

	static void kmissing(int arr[]) {
		int start = 0;
		while (start < arr.length) {
			if (arr[start] > 0 && arr[start] < arr.length && arr[start] != start + 1) {
				int temp = arr[start] - 1;
			}
		}
	}

	static void dutchflag(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (mid < end) {
			if (arr[mid] == 0) {
				while (arr[start] == 0)
					start++;
				int emp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = emp;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				while (arr[end] == 2) {
					end--;
				}
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;

			}
		}
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void seggragte(int arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[end] == 0) {
				while (arr[start] != 1) {
					start++;
				}
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;

			}
			end--;
		}
		for (int k : arr) {
			System.out.println(k);
		}
	}

	static void triplet(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}

		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				if (arr[l] + arr[r] == arr[i]) {
					System.out.println(arr[l] + " " + arr[r] + " " + arr[i]);
				} else if (arr[l] + arr[r] > arr[i]) {
					r--;
				} else {
					l++;
				}
			}
		}
	}

	static void isTrip(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				if (arr[l] + arr[r] == arr[i]) {
					System.out.println(arr[l] + " " + arr[r] + " " + arr[i]);
					break;
				} else if (arr[l] + arr[r] > arr[i]) {
					l++;
				} else {
					r--;
				}
			}
		}

	}

	static boolean isTriplet(int arr[], int n) {
		// Square array elements
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];

		// Sort array elements
		Arrays.sort(arr);

		// Now fix one element one by one and find the other two
		// elements
		for (int i = n - 1; i >= 2; i--) {
			// To find the other two elements, start two index
			// variables from two corners of the array and move
			// them toward each other
			int l = 0; // index of the first element in arr[0..i-1]
			int r = i - 1; // index of the last element in arr[0..i-1]
			while (l < r) {
				// A triplet found
				if (arr[l] + arr[r] == arr[i])
					return true;

				// Else either move 'l' or 'r'
				if (arr[l] + arr[r] < arr[i])
					l++;
				else
					r--;
			}
		}

		// If we reach here, then no triplet found
		return false;
	}

	static void countIncreseSubArray(int arr[]) {
		int start = 0;
		int end = 0;
		ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>();
		while (end < arr.length) {
			int d = 0;
			while (end + 1 < arr.length && arr[end] < arr[end + 1]) {

				end++;
			}
			if (arr[end] > arr[end + 1]) {
				start = end;
			}
			ArrayList<Integer> a = new ArrayList<>();
			for (int i = start; i < end; i++) {
				a.add(0, arr[i]);
				ar.add(new ArrayList<Integer>(a));
			}

			end++;
		}
		System.out.println(ar);
	}

	static void peekelement(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int k = i + 1;
			if (arr[i] > arr[j] && arr[i] > arr[k]) {
				System.out.println(arr[i]);
			}
		}
	}

	static void fixedpoint(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr[i]) {
				System.out.println(arr[i] + "fixed point");
			}
		}
	}

	static void minimumdistance(int arr[], int a, int b) {
		int start = 0;
		int pos = Integer.MAX_VALUE;
		int end = arr.length;
		boolean flag = false;
		int position = 0;
		while (start < arr.length - 1) {

			if (arr[start] == a || arr[start] == b && flag == false) {
				position = arr[start] == a ? b : a;
				flag = true;
				end = start;
				start++;

			}
			if (flag && arr[start] == position) {
				pos = Math.min(pos, start - end + 1);
				flag = false;
				end = start;

			}
			start++;

		}
		System.out.println(pos);
	}

	private static void nbytwoElements(int arr[]) {
		Arrays.sort(arr);
		int start = 0;
		int end = 0;
		boolean flag = false;
		int value = 0;
		while (start <= arr.length) {
			if (start + 1 < arr.length && arr[start] == arr[start + 1]) {
				if (flag == false) {
					value = arr[start];
					end = start;
					flag = true;
				}
				start++;
			}
			if ((start - end + 1) % 2 != 0) {
				System.out.println(true + " " + value);
				break;
			}
			start++;
		}
	}

	static void replace(int arr[]) {

		arr[0] = -1;
		int start = 1;
		int max = 0;
		while (start < arr.length - 1) {
			max = Math.max(max, arr[start]);
			arr[start] = max;
			start++;
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void intersection(int[] arr, int[] br) {

		int start = 0;
		int start1 = 0;
		while (start <= arr.length - 1 && start1 <= br.length - 1) {
			while (start + 1 > arr.length && arr[start] == arr[start + 1]) {
				start++;
			}
			while (br[start1] == br[start1 + 1]) {
				start1++;
			}
			if (arr[start] == br[start1]) {
				System.out.print(arr[start] + " ");
				start++;
				start1++;
			} else if (arr[start] < br[start1]) {
				start++;
			} else {
				start1++;
			}
		}

	}

}
