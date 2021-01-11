package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Print {

	static void print(int n) {
		if (n == 0) {
			System.out.println("working");
			return;
		}

		print(n - 1);
		System.out.println(n);

	}

	static int factoril(int n) {
		int arr[] = new int[10];
		arr[0] = 1;
		arr[1] = 1;
		// if (arr[n] == 0)
		// arr[n] = n * factoril(n - 1);

		for (int i = 1; i < n; i++) {
			arr[i] = i * arr[i - 1];
		}
		return arr[n - 1];
	}

	static void sort(LinkedList<Integer> arr, int n) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < n; i++) {

		}
		sort(arr, n - 1);
		System.out.println(arr.get(n));

	}

	static void bubblestack(Stack<Integer> st, int n, int curr) {
		if (n == 0) {
			return;
		}

		int d = st.pop();

		System.out.println("" + d);
		bubblestack(st, n - 1, curr + 1);
		// System.out.println(""+d);

	}

	private static void insert(Stack<Integer> st, int d) {
		if (st.size() == 0 || st.get(st.size() - 1) < d) {
			st.push(d);
			return;
		}
		int de = st.get(st.size() - 1);
		st.pop();
		insert(st, de);

	}

	public static int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0)
            return (kthGrammar(N - 1, K / 2) == 0) ? 1 : 0;
        else 
            return (kthGrammar(N - 1, (K + 1) / 2) == 0) ? 0 : 1; 
    }

	static void bubbleSort(int arr[], int n) {
		// Base case
		if (n == 1)
			return;

		// One pass of bubble sort. After
		// this pass, the largest element
		// is moved (or bubbled) to end.
		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				// swap arr[i], arr[i+1]
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}

		// Largest element is fixed,
		// recur for remaining array
		bubbleSort(arr, n - 1);
	}

	// Driver Method
	public static void main(String[] args) {
	

		System.out.println(kthGrammar(4,5));
		
	}
}
