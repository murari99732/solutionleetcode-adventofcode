package rough;

import java.util.ArrayList;

public class RightSideGeatest {
	static void right(int arr[]) {

		ArrayList<Integer> ar = new ArrayList<Integer>();
		int start = 0;
		int end = arr.length - 2;
		int max = arr.length - 1;
		ar.add(arr[max]);

		while (end >= 0) {
			if (arr[end] > arr[max]) {
				ar.add(arr[end]);
				System.out.println(arr[end]);
				max = end;

			}

			end--;
		}
		System.out.println(ar);
	}

	public static void eliqurim(int arr[]) {
		int i = 0;

		int mid = i + 1;

		while (mid < arr.length - 2) {
			int j = mid - 1;
			int next = mid + 1;
			int end = arr.length - 1;
			int sum1 = 0, sum = 0;
			for (int k = i; k <= j; k++) {
				sum = sum + arr[k];
			}
			for (int k = next; k <= end; k++) {
				sum1 = sum1 + arr[k];
			}
			if (sum1 == sum) {
				System.out.println(arr[mid]);
				break;
			} else if (sum1 > sum) {
				mid++;
			}

		}
	}

	public static void secondwayequilibrium(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			int sumfirst = sum - arr[i];
			if (sum == sumfirst) {
				System.out.println("yes it is");
			}
		}
	}

	public static void sort(int arr[]) {
		int start = 0;
		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 3) {
				a++;

			} else if (arr[i] == 1) {
				b++;
			} else if (arr[i] == 2) {
				c++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (i < a) {
				arr[i] = 3;
			} else if (i < a + b) {
				arr[i] = 1;
			} else {
				arr[i] = 2;
			}
		}

		for (int h : arr) {
			System.out.println(h);
		}
	}

	public static void torg(int arr[]) {
		int a = 0;
		int mid = 0;
		int b = arr.length;
		int start = 0;
		int end = arr.length - 1;
		int bc[] = new int[arr.length];
		while (start < arr.length && end > 0) {
			if (arr[start] == 0) {
				if (a != mid) {
					int temp = bc[a];
					bc[a] = bc[mid];
					bc[mid] = temp;
				}
				bc[a++] = 0;
				mid++;

			} else if (arr[start] == 1)
				bc[mid++] = 1;
			else if (arr[start] == 2) {
				bc[end--] = 2;
			}
			start++;
		}
	}

	static void largestcontigousum(int arr[]) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			max = Math.max(sum, max);
			if(sum<0)
			{
				sum=0;
			}
		}
		System.out.println(max);
	}

	public static void delete(int arr[], int d)
	{
		for(int i=d;i<arr.length;i++)
		{
			arr[i]=arr[i+1];
		}
	}
	public static void main(String[] args) {
		int arr[] = {-3, -4, 4, -1, -2, 1, 5, -3};
		largestcontigousum(arr);
	}
}
