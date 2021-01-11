package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void mergeSort(List<Integer> arr, int start, int end) {
		if (start != end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(List<Integer> arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;

		int[] temp = new int[end - start + 1];

		while ((i <= mid) && (j <= end)) {
			if (arr.get(i) < arr.get(j))
				temp[k++] = arr.get(i++);
			else
				temp[k++] = arr.get(j++);
		}

		while (i <= mid) {
			temp[k++] = arr.get(i++);
		}

		while (j <= end) {
			temp[k++] = arr.get(j++);
		}

		for (i = start; i <= end; i++) {
			arr.remove(i);
			int e = temp[i - start];
			arr.add(i, e);
		}
	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(5);
		a.add(2);
		a.add(3);
		a.add(4);

		System.out.print("Input: ");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}

		mergeSort(a, 0, a.size() - 1);

		System.out.println();

		System.out.print("Output: ");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
	}

}
