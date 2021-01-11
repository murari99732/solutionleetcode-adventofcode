package LeetCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class ImplArrays {
	   public static final int FIVE_SECONDS = 5000;
	    public static final int MAX_Y = 400;
	    public static final int MAX_X = 400;
	public static void main(String[] args) throws Exception {

		int arr[] = { 0, 1, 0, 0, 0, 0 };
		int brr[] = { 1, 0, 1, 0, 0, 1 };
		   Robot robot = new Robot();
	        Random random = new Random();
	        while (true) {
	            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
	            Thread.sleep(FIVE_SECONDS);
	        }

	}

	  static void longestCommonSum(int[] arr1, int[] arr2, int n) 
	    { 
	        // Find difference between the two 
	        int[] arr = new int[n]; 
	        for (int i = 0; i < n; i++)  
	            arr[i] = arr1[i] - arr2[i]; 
	  
	        // Creates an empty hashMap hM  
	        HashMap<Integer, Integer> hM = new HashMap<>(); 
	  
	        int sum = 0;     // Initialize sum of elements  
	        int max_len = 0; // Initialize result  
	  
	        // Traverse through the given array  
	        for (int i = 0; i < n; i++)  
	        {  
	            // Add current element to sum  
	            sum += arr[i];  
	  
	            // To handle sum=0 at last index  
	            if (sum == 0)  
	                max_len = i + 1;  
	  
	            // If this sum is seen before,  
	            // then update max_len if required  
	            if (hM.containsKey(sum))  
	                max_len = Math.max(max_len, i - hM.get(sum));  
	              
	            else // Else put this sum in hash table  
	                hM.put(sum, i);  
	        } 
	        System.out.println(max_len);
	    }  
	static void seggragtezandone(int arr[]) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			while (arr[left] == 0 && left < right) {
				left++;
			}

			while (arr[right] == 1 && left < right) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
	}

	static void seggragete(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			while (arr[left] % 2 == 0 && left < right) {
				left++;
			}

			while (arr[right] % 2 != 0 && left < right) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
	}

	static void getlongest(int arr[], int k) {
		int i = 0;
		int d = 0;
		int j = 0;
		int max = 0;
		while (i < arr.length) {
			if (arr[i] == 0) {
				d++;
			}
			if (d > k) {
				while (d > k && j < i) {
					if (arr[j] == 0) {
						d--;
					}
					j++;
				}
			}
			max = Math.max(max, i - j + 1);
			i++;
		}
		System.out.println(max);
	}

	static void sortcyclic(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
				int val = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[val];
				arr[val] = temp;
			} else
				i++;
		}
		for (int j = 0; j < arr.length; j++) {
			if (j + 1 != arr[j]) {

				System.out.println(j + 1);

			}
		}
	}

	private static void cycle(int[] arr) {

		int i = 0;
		while (i < arr.length) {
			boolean flag = false;
			int fast = i;
			int slow = i;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			if (arr[i] > 0) {
				flag = true;
			}
			while (true) {
				slow = getcycle(arr, slow, flag, ar);
				if (slow == -1) {
					break;
				}
				fast = getcycle(arr, fast, flag, ar);
				if (fast == -1) {
					break;
				}

				fast = getcycle(arr, fast, flag, ar);
				if (fast == -1) {
					break;
				}
				if (fast == slow) {
					return;
				}
			}
		}

	}

	private static int getcycle(int[] arr, int slow, boolean flag, ArrayList<Integer> ar) {
		if (arr[slow] > 0) {
			if (flag != true) {
				return -1;
			}
		}
		int val = slow + arr[slow];
		if (val == slow) {
			return -1;
		}
		if (val > 0) {
			val = val % arr.length;
		} else {
			val = arr.length + val;
		}
		return val;
	}

	static void findsorted(int arr[]) {
		int i = 0;
		int j = arr.length - 1;
		boolean flag = false;
		boolean ft = false;
		int k = 0;
		int l = 0;
		while (i < j) {
			if (arr[i] > arr[i + 1] && flag == false) {
				k = i;
				flag = true;
			}
			if (arr[j] < arr[j - 1] && ft == false) {
				l = j;
				ft = true;

			}
			if (flag == true && ft == true) {
				break;
			}
			i++;
			j--;

		}
		int brr[] = new int[j - i + 1];
		for (int m = 0; m < brr.length; m++) {
			brr[m] = arr[k++];
		}
		Arrays.sort(brr);

		int kl = 0;
		for (int jp = i; jp < j + 1; jp++) {
			arr[jp] = brr[kl++];
		}
		for (int v = 0; v < arr.length; v++) {
			System.out.print(arr[v] + " ");
		}
	}

	static void sortarray(int arr[], int val1) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int sum = val1;
			for (int j = i + 1; j < arr.length; j++) {
				int add = arr[i] + arr[j];
				sum = sum - add;

				int k = j + 1;
				int l = arr.length - 1;
				int val = 0;
				while (k < l) {
					val = arr[k] + arr[l];
					if (val > sum) {
						l--;
					} else if (val < sum) {
						k++;
					} else {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
						l--;
						k++;
					}
				}
			}
		}
	}

	static void sortedmanner(int arr[]) {
		int br[] = new int[arr.length];
		int i = 0;
		int j = arr.length - 1;
		int l = arr.length - 1;
		while (i < j) {
			int v = arr[i];
			int w = arr[j];
			if (v * v < w * w) {
				br[l--] = w * w;
				j--;
			} else {
				br[l--] = v * v;
				i++;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.println(br[k]);
		}
	}

	private static void sortbasedonfreq(ArrayList<Integer> arr) {

		int value = arr.get(0);
		int i = 1;
		while (i < arr.size()) {
			if (value == arr.get(i)) {
				arr.remove(i);
			} else {
				value = arr.get(i);
				i++;
			}
		}
		System.out.println(arr);
	}

	private static void shuffle(int[] arr) {
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			int val = r.nextInt(arr.length);
			int temp = arr[val];
			arr[val] = arr[i];
			arr[i] = temp;
		}
		Arrays.stream(arr).forEach(System.out::print);

	}

	static void maximumallarray(int arr[], int k) {
		ArrayDeque<Integer> ar = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!ar.isEmpty() && arr[ar.peekLast()] < arr[i]) {
				ar.pollLast();
			}
			ar.addFirst(i);
		}
		for (int i = k; i < arr.length; i++) {
			System.out.println(arr[ar.peek()]);
			while (!ar.isEmpty() && i - k >= ar.peek()) {
				ar.pollFirst();
			}
			while (!ar.isEmpty() && arr[ar.peekLast()] < arr[i]) {
				ar.pollLast();
			}
			ar.addLast(i);
		}

	}

	static void smallestsum(int arr[], int value) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(0, -1);

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (!hashmap.containsKey(sum - value)) {
				hashmap.put(sum, i);
			} else {
				int val = hashmap.get(sum - value);
				min = Math.min(i - val, min);
				hashmap.put(sum, i);
			}
		}
		System.out.println(min);
	}

	static void maximumsum(int arr[], int k) {
		int brr[] = new int[arr.length];
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		while (i < arr.length) {

			sum = sum + arr[i];

			while (i - j > k) {
				sum = sum - arr[j];
				j++;

			}
			max = Math.max(sum, max);
			i++;
		}
		System.out.println(max);
	}

	static void getvalue(int arr[], int sum) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(0, -1);
		int sum1 = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 = sum1 + arr[i];
			if (!hashmap.containsKey(sum1 - sum)) {
				hashmap.put(sum1, i);
			} else {
				int v = hashmap.get(sum1 - sum);
				for (int j = v + 1; j <= i; j++) {
					System.out.print(arr[j] + " ");

				}
				System.out.println();
				hashmap.put(sum1, i);
			}
		}
	}

	static void addition(int arr[]) {
		int i = 0;
		int j = 0;
		int sum = 0;
		while (i < arr.length) {
			sum = sum + arr[i];
			if (sum == 13) {
				for (int k = j; k <= i; k++) {
					System.out.println(arr[k]);

				}
				System.out.println();
				// System.out.println(i + " " + j);
			}
			if (sum > 13) {
				while (j < i && sum > 13) {
					sum = sum - arr[j];
					j++;
				}
				if (sum == 13) {
					for (int k = j; k <= i; k++) {
						System.out.println(arr[k]);
					}
					System.out.println();
					// System.out.println(i + " " + j);
				}

			}

			i++;
		}

	}

	static void additionsubarray(int arr[], int sum) {

		boolean brr[][] = new boolean[arr.length][sum + 1];
		Arrays.fill(brr[0], true);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (arr[i] == j) {
					brr[i][j] = true;
				} else if (brr[i - 1][j]) {
					brr[i][j] = true;
				} else {
					if (arr[i] > j) {
						brr[i][j] = brr[i - 1][j - arr[i]];
					}
				}

			}
		}

		String ab = "";
		String bc = "";
		boolean flag = false;
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = sum - arr[i];
			if (true == brr[i][val]) {
				if (val == 0) {
					flag = true;
					ab = ab + arr[i] + " ";
				} else {
					ab = ab + arr[i] + " ";
				}
			}

			if (flag = true) {
				System.out.println(ab);
				flag = false;
				ab = "";
			}
		}

	}

	public static int findFirstOccurrenceIfAdjecentValueDifferBy1(int arr[], int val) {
		if (arr.length == 0) {
			return -1;
		}

		int start = 0;

		while (start < arr.length) {
			if (arr[start] == val) {
				return start;
			}

			int diff = Math.abs(arr[start] - val);
			start = start + diff;
		}

		return -1;
	}

	static void greaterelement(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int j = arr.length - 1;
		while (j > 0) {
			int value = st.peek();
			if (value >= arr[j]) {
				System.out.print(value + " ");
				st.push(arr[j]);
			} else {
				while (arr[j] < st.peek()) {
					st.pop();
				}
				if (st.isEmpty()) {
					System.out.print(-1 + " ");
					st.push(arr[j]);
				} else {
					System.out.print(st.peek() + " ");
					st.push(arr[j]);
				}
			}
			j--;
		}
	}

	static void greater(ArrayList<Integer> arr) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr.get(arr.size() - 1));
		int j = arr.size() - 1;
		while (j > 0) {
			int value = st.peek();
			if (value >= arr.get(j)) {
				System.out.print(value + " ");
				st.push(arr.get(j));
			} else {
				while (arr.get(j) < st.peek()) {
					st.pop();
				}
				if (st.isEmpty()) {
					System.out.print(-1 + " ");
					st.push(arr.get(j));
				} else {
					System.out.print(st.peek() + " ");
					st.push(arr.get(j));
				}
			}
			j--;
		}
	}

	static void sortarrays(int arr[]) {
		int mid = 0;
		int i = 0;
		int j = arr.length - 1;
		while (mid < j) {
			if (arr[mid] == 0) {
				if (arr[i] != 0) {
					int temp = arr[i];
					arr[i] = arr[mid];
					arr[mid] = temp;
					i++;
				} else {
					arr[i++] = 0;
					mid++;
				}
			} else if (arr[mid] == 1) {
				arr[mid] = 1;
				mid++;
			} else if (arr[mid] == 2) {
				if (arr[j] != 2) {
					int temp = arr[mid];
					arr[mid] = arr[j];
					arr[j] = temp;
					j--;
				} else {
					arr[j] = 2;
					j--;
					mid++;
				}
			}

		}
	}

	static void missing(int arr[]) {
		int i = 0;
		int j = arr.length;
		int sum = 0;
		int sum1 = 0;
		while (i < j) {
			sum = sum + arr[i];
			i++;
		}
		for (int k = 1; k <= 6; k++) {
			sum1 = sum1 + k;
		}

		System.out.println(sum + " " + sum1);
	}

	static void largestcommon(int arr[]) {
		int i = 0;
		int j = arr.length;
		int sum = 0;
		int max = 0;
		while (i != j) {
			sum = sum + arr[i];
			max = Math.max(sum, max);
			if (sum < 0) {
				sum = 0;
			}

			i++;
		}
		System.out.println(max);
	}

	private static void merge(int[] arr, int i, int j) {
		if (i != j) {
			int mid = (i + j) / 2;
			merge(arr, i, mid);
			merge(arr, mid + 1, j);
			mergesort(arr, i, mid, j);
		}

	}

	private static void mergesort(int[] arr, int i, int mid, int j) {
		int k = 0;
		int l = mid + 1;
		int f = j;
		int c[] = new int[arr.length];
		while (i < mid && k < j) {
			if (arr[i] < arr[k]) {
				c[k++] = arr[i];
				i++;

			} else if (arr[i] > arr[k]) {
				c[k++] = arr[k];
				k++;
			}

		}
		while (i != mid) {
			c[k++] = arr[i++];
		}
		while (k < j) {
			c[k++] = arr[k++];
		}

		for (int m = i; m < f; m++) {
			arr[m] = c[m];
		}

	}

	static void quicksort(int arr[], int start, int end) {
		int i = start + 1;
		int j = end;
		while (i < j) {
			while (arr[start] < arr[i]) {
				i++;
			}
			while (arr[start] > arr[end]) {
				end--;
			}
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;
		}
		int temp = arr[i];
		arr[i] = arr[start];
		arr[start] = temp;
		quicksort(arr, start, i - 1);
		quicksort(arr, i + 1, end);
	}

	static void getvalue(int arr[], int brr[]) {
		int k = 0;
		for (int i = 4; i < arr.length; i++) {
			arr[i] = brr[k++];
		}
		Arrays.stream(arr).forEach(System.out::print);
	}

}
