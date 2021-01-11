import java.util.Arrays;

public class InsertionSort {

	static void insertion(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = 0; j <= i; j++) {
				if (temp > arr[j]) {
					int curr = arr[j];
					arr[j] = arr[i];
					arr[i] = curr;
				}
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	static int[] twosorted(int arr[], int brr[]) {
		Arrays.sort(arr);
		Arrays.sort(brr);
		int i = 0;
		int j = 0;
		int k = 0;
		int crr[] = new int[arr.length + brr.length];
		while (arr.length != i && brr.length != j) {
			if (arr[i] > brr[j]) {
				crr[k++] = brr[j];
				j++;
			} else if (arr[i] < brr[j]) {
				crr[k++] = arr[i];
				i++;
			} else {
				crr[k++] = arr[i];
				i++;
				j++;
			}

		}
		while (arr.length != i) {
			crr[k++] = arr[i];
			i++;
		}
		while (brr.length != j) {
			crr[k++] = brr[j];
			j++;
		}

		return crr;
	}

	static int[] mergesort(int arr[], int i, int j) {
		if (i == j) {
			int bc[] = new int[1];
			bc[0] = arr[i];
			return bc;
		}
		int mid = (i + j) / 2;
		return twosorted(mergesort(arr, i, mid), mergesort(arr, mid + 1, j));

	}

	static void bucketsort(int arr[], int i, int j)
	{
		int d=i+1;
		int temp=arr[i];
		while(d<j)
		{
			if(arr[d]<arr[i])
			{
				d++;
			}
		}
		int f=j;
		while(i<f)
		{
			
		}
		
	}
	public static void main(String[] args) {
		// twosorted(new int[] { 1, 4, 2, 10, 7, 5 }, new int[] { 3, 2, 7, 9 });
		int crr[] = mergesort(new int[] { 1, 4, 2, 10, 7, 5 }, 0, 5);
		Arrays.stream(crr).forEach(a -> System.out.print(a + " "));
	}
}
