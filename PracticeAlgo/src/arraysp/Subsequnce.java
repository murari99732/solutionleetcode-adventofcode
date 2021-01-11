package arraysp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsequnce {

	public static void difference(int arr[], int target, int interval) {
		int start = 0;
		while (start < arr.length) {
			if (start == target) {
				System.out.println("return");
			}
			int diff = Math.abs(arr[start] - target);
			start = start + diff;
		}
	}

	public static void checkpair(int arr[], int sum) {

		int start = 0;
		while (start < arr.length - 1) {
			if (arr[start] + arr[start + 1] == sum) {
				System.out.println("true");
			}
			start++;
		}

	}

	public static void search(int arr[], int value) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start < arr.length && end >= 0) {
			int mid = (start + end) / 2;
			if (arr[mid] == value) {
				System.out.println("true");
			}
			if (arr[mid] > value) {
				end = mid - 1;
			}
			if (arr[mid] < value) {
				start = mid + 1;
			}
		}
	}

	public static void firstrepeattarget(int arr[], int target, int interval) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int end = 0;
		while (end < arr.length) {

			if (Math.abs(target - arr[end]) % interval == 0) {
				int d = (target - arr[end]) / interval;
				ar.add(d);
			}
			end++;
		}
		System.out.println(ar);
	}

	public static void firstrepeat(int arr[], int k) {

		ArrayList<Integer> ar = new ArrayList<Integer>();

		int value = 0;
		int i = 0;
		int start = i + 1;
		while (i < arr.length && start < arr.length) {

			value = arr[start] - arr[i];
			if (value < k) {
				start++;
			} else {
				ar.add(arr[start]);
				i = start;

			}

		}
		System.out.println(ar);

	}

	public static void repeated(int arr[]) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int end = 0;
		while (end < arr.length - 1) {
			while (end < arr.length && arr[end] == arr[end + 1]) {
				end++;
			}
			ar.add(arr[end]);
			end++;
		}
		System.out.println(ar);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 5, 6 };
		// firstrepeattarget(arr1, 110, 20);
		// repeated(arr1);
		search(arr, 3);
	}
}