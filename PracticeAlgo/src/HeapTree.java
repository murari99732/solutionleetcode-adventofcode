import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Word {
	int value;
	int frequency;

	public Word(int value, int frequency) {
		super();
		this.value = value;
		this.frequency = frequency;
	}

}

public class HeapTree {

	static int size = 0;
	static int arr[] = new int[20];

	static void insert(int data) {
		arr[size] = data;
		int index = size;
		int parent = (index - 1) / 2;
		while (parent >= 0 && arr[parent] > arr[index]) {
			int t = arr[parent];
			arr[parent] = arr[index];
			arr[index] = t;

			t = parent;
			index = parent;
			parent = (t - 1) / 2;

		}

		size++;
	}

	static void removeMax() {
		arr[0] = arr[size - 1];
		size = size - 1;
		maxify(0);
	}

	private static void maxify(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (arr[l] > arr[largest]) {
			largest = l;
		}
		if (arr[r] > arr[largest]) {
			largest = r;
		}

		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
		maxify(largest);

	}

	static void kthLargest(int n, int arr[]) {

		PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			pr.add(arr[i]);
		}
		for (int i = n; i < arr.length; i++) {
			if (arr[i] > pr.peek()) {
				pr.poll();
				pr.add(arr[i]);
			}
		}

		while (!pr.isEmpty()) {
			System.out.println(pr.poll());
		}
	}

	static void kfrequent(int value, int frquency) {

	}

	public static void main(String[] args) {

		int[] arr = { 10, 7, 11, 30, 20, 38, 2, 45 };
		int k = 3;

		ArrayList<Word> ar = new ArrayList<Word>();
		for (int i = 0; i < 10; i++) {
			ar.add(new Word(1, 2));
		}

		kfrequncy(ar);
		kthLargest(4, arr);

	}

	private static void kfrequncy(ArrayList<Word> ar) {
		PriorityQueue<Word> pr = new PriorityQueue<Word>((a, b) -> {
			if (a.frequency != b.frequency) {
				return b.frequency - a.frequency;
			}

			else {
				return b.frequency - a.frequency;
			}
		});
		pr.addAll(ar);
		System.out.println(pr);

	}

	private static void frequnecy(List<Integer> word) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer w : word) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
	}

}
