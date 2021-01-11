
public class Dynamic {

	static void manimumdiff(int arr[], int diff) {
		if (arr.length == 0) {
			return;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {

			sum = sum + arr[i];

		}

		sum = sum / 2;
		sum = sum - 1;

		boolean brr[][] = new boolean[arr.length][sum + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < brr[i].length; j++) {
				if (brr[i - 1][j]) {
					brr[i][j] = true;
				} else {
					if (arr[i] >= j) {
						brr[i][j] = brr[i - 1][j - arr[i]];
					}
				}
			}
		}

		System.out.println(brr[arr.length - 1][diff]);

	}

	public static void main(String[] args) {

	}

}
