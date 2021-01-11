package arraysp;

public class Solution8 {

	public int subarray(int weight[], int n, int pr[], int sum) {
		if (sum == 0 || n == 0 || weight.length == 0 || pr.length == 0) {
			return 0;
		}

		int b[][] = new int[weight.length][sum];
		for (int j = 0; j <= sum; j++) {
			if (weight[0] <= j) {
				b[0][j] = pr[0];
			}
		}

		for (int i = 1; i < weight.length; i++) {
			for (int j = 1; j < sum; j++) {
				int d = 0;
				if (weight[i] < j) {

					d = pr[i];
				}
				b[i][j]=Math.max(b[i-1][j], d+b[i-1][j-weight[i]]);

			}
		}
		 return b[weight.length - 1][sum];

	}

	public static void main(String[] args) {

	}
}
