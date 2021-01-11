package rough;

public class Dutch {

	static void flag(int arr[]) {

		int mid = 0;
		int start = 0;
		int end = arr.length - 1;
		while (mid < end) {
			if (arr[mid] == 0) {
				if (arr[start] != 0) {
					int temp = arr[mid];
					arr[mid] = arr[start];
					arr[start] = temp;
				}
				start++;
				mid++;
			}
			if (arr[mid] == 1) {
				mid++;
			}
			if (arr[mid] == 2) {
				if (arr[mid] != 2) {
					int temp = arr[end];
					arr[end] = arr[mid];
					arr[mid] = temp;
				}
				mid++;
				end--;

			}
		}
		for(int j:arr)
		{
			System.out.println(j);
		}

	}

	public static void main(String[] args) {
      int arr[]= {0,1,1,1,0,2,2,1};
      flag(arr);
	}
}
