package queueproblem;

import java.util.Arrays;

public class QueueExample {
	static int arr[] = new int[5];

	static int rear = 0;
	static int front = 0;
	static int size = 0;

	static void insert(int value) {
		if (size == 0) {
			arr[rear++] = value;
			size++;
		} else {
			merge(arr, rear, value);

		}
	}

	private static void merge(int[] arr2, int rear2, int value) {
		if (arr2[rear - 1] < value) {
			arr2[rear++] = value;
		} else {
			int i = 0;
			while (arr2[i] < value) {
				i++;
			}

			int newarr[] = new int[rear2 + 1];
			for (int it = 0; it < rear2 + 1; it++) {
				if (it < i ) {
					newarr[it] = arr[it];
				} else if (it == i ) {
					newarr[it] = value;
				} else {
					newarr[it] = arr[it - 1];
				}
			}
			arr2=newarr;
			rear++;
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		insert(2);
		insert(5);
		insert(4);

	}

}
