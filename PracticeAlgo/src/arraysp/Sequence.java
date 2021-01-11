package arraysp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Sequence {

	public static void maxsumarray(int arr[], int k) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum < 0) {
				sum = 0;
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

	public static void subequal(int arr[], int k) {

		for (int i = 0; i < arr.length; i++) {
			int d = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (d < k) {
					d = d + arr[i] + arr[j];
				}
				if (d == k) {
					System.out.println("yes sum is there");
					d = 0;
					break;
				}

			}
		}
	}

	public static void subarrayequal(int arr[], int k) {
		int end = 0;
		int sum = 0;
		int start = 0;
		while (end < arr.length) {
			if (k > sum) {
				sum = sum + arr[end];
				end++;
			}
			if (k == sum) {
				System.out.println(end);
				System.out.println(start);
				sum = sum + arr[end];

			}
			while (k < sum && start < end) {
				sum = sum - arr[start];
				start++;

			}
		}
	}

	public static void maximumsum(int arr[], int k) {
		int d = 1;
		int sum = 0;
		int start = 0;
		int end = 0;
		int max = 0;

		while (end < arr.length) {
			if (d <= k) {
				sum = sum + arr[end];
				max = Math.max(sum, max);
				end++;
				d++;

			}

			if (d > k) {

				sum = sum - arr[start];
				start++;
				d--;
			}
		}
		System.out.println(max);

	}

	public static void smallest1(int arr[], int k) {
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while (end < arr.length) {
			if (sum == k) {
				sum = sum + arr[end];
				end++;
				System.out.println("it is equal");
			}
			while (sum > k) {
				sum = sum - arr[start];
				start++;
			}
			if (sum < k) {
				sum = sum + arr[end];
				end++;
			}

		}
		System.out.println(min);
	}

	public static void smallest(int arr[], int k) {

		int min = Integer.MAX_VALUE;
		int start = 0;
		int sum = 0;
		int count = 0;
		while (start < arr.length) {
			if (sum != k && sum < k) {
				count++;
				sum = sum + arr[start];
				start++;
			}
			if (sum == k) {
				min = Math.min(count, min);
				count = 0;
				System.out.println("Yes it is same");
				sum = 0;

			}
			if (sum > k) {
				start--;
				count = 0;
				sum = 0;
			}
		}
		System.out.println(min);
	}

	public static void subsequence(int arr[], int k) {
		Deque<Integer> dq = new LinkedList<Integer>();
		int end = 0;
		int start = 0;
		int l = 0;
		dq.push(arr[0]);
		while (end < arr.length) {
			if (start - end + 1 == k) {
				start = start + 1;
			}
			if (dq.peek() < arr[end] && start - end + 1 <= k) {
				dq.poll();
				dq.push(arr[end]);
				end++;
				l++;
			} else if (dq.peek() < arr[end] && start - end + 1 <= k) {
				dq.push(arr[end]);
				end++;
				l++;
			}

		}

	}

	public static void help(int arr[], int k) {
		int max = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i; j < i + k; j++) {
				max = Math.max(arr[j], arr[i]);

			}
			System.out.println(max);
		}

	}

	public static void insertionsort(int arr[]) {
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int k = 0;

			while (k <= 3) {
				if (dq.peek() < arr[i]) {
					dq.pop();
					k--;
				} else {
					dq.push(arr[i]);
					k++;
				}
			}
		}

	}

	public static void negativesubequal(int arr[], int k) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int fullsum = 0;
		for (int i = 0; i < arr.length; i++) {
			fullsum = arr[i] + fullsum;
			int value = fullsum - k;
			if (!hm.containsKey(value))
				hm.put(value, i);
			else {
				System.out.println(hm.get(value));
				System.out.println("presnet");
			}
		}
	}

	public static void negativeFindsmallest(int arr[], int sum) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int totalsum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			totalsum = totalsum + arr[i];
			int value = totalsum - sum;
			if (!hm.containsKey(value)) {
				hm.put(totalsum, i);
			} else if (hm.containsKey(value)) {
				int d = hm.get(value);
				int k = i - d;
				min = Math.min(min, k);
			}

		}
		System.out.println(min);
	}

	public static void maxmultiplication(int arr[]) {
		Arrays.sort(arr);
		int mul = arr[arr.length - 1] * arr[arr.length - 2];
		System.out.println(mul);

	}

	public static void checkmultiplication(int arr[], int mul) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] * arr[end] > mul) {
				end--;
			} else {
				start++;
			}
			if (arr[start] * arr[end] == mul) {
				System.out.println("solution");
			}

		}

	}
	public static void mul(int arr[], int d)
	{
		HashSet<Integer> hs= new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(hs.contains(d/arr[i]) && arr[i] % d==0)
			{
				System.out.println("iyes");
			}
			hs.add(arr[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 4, 1, 3, 10, 5, 7, 8, 2, 10, 3 };
		ArrayList<Integer> ar = new ArrayList<>();
		for (int j : a) {
			ar.add(j);
		}
		mul(a, 15);

	}
}
