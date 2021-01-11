import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Coordinate {
	int x;
	int y;
}

public class Distance {
	static void distance(Matrix c) {

		PriorityQueue<Matrix> pr = new PriorityQueue<Matrix>((a, b) -> {

			int x = a.x * a.x;
			int y = a.y * a.y;
			double sum = Math.sqrt(x + y);
			int ax = b.x * b.x;
			int ay = b.y * b.y;
			double sumy = Math.sqrt(ax + ay);
			if (sumy > sum) {
				return ax - x;
			}
			return 0;

		});

	}

	static void rope(int arr[]) {
		int start = 1;
		Arrays.sort(arr);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		while (start < arr.length) {
			int sum = 0;
			if (start != 0) {
				sum = arr[start - 1] + arr[start];
				arr[start] = sum;
				ar.add(sum);
			}
			start++;
		}
		int sum = 0;

		for (int j : ar) {
			sum = sum + j;
		}
		System.out.println(sum);
	}

	static void rope1(int arr[]) {
		PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pr.add(arr[i]);
		}
		int p=0;
		while (!pr.isEmpty() && pr.size()!=1) {
			int d = pr.poll();
			int e = pr.poll();
			int sum = d + e;
			pr.add(sum);
			if(pr.size()==1)
			{
				sum=sum+pr.poll();
				
			}
			p=sum;
		}
		System.out.println(p);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 2 };
		rope1(arr);
	}

}
