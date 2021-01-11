package dynamicprogramming;

public class Fibonacci {

	static int fibonacci(int arr[], int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (arr[n] == 0) {
			arr[n] = fibonacci(arr, n - 1) + fibonacci(arr, n - 2);
		}
		return arr[n];
	}

	static int minimumstairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2||n==3) {
			return 1;
		}
		int arr[]= new int[n+1];
		if(arr[n]==0)
		{
			arr[n]=1+Math.min(minimumstairs(n-1), minimumstairs(n-2));
		}
		return arr[n];
	}

	static int stairs(int n, int p) {
		int arr[] = new int[11];
		if (n == 1 || n == 0) {
			return 1;
		}

		int count = 0;
		if (arr[n] == 0) {
			arr[n] = stairs(n - 1, count + 1) + stairs(n - 2, count + 1);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		int ar[] = new int[11];
		System.out.println(minimumstairs(11));

	}
}
