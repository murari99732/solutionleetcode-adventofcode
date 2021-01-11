
public class ListenValue {

	static Integer arr[] = new Integer[11];

	static int fibonacci(int value) {
		if (value == 0) {
			return 0;
		}
		if (value == 1) {
			return 1;
		}
		if (arr[value] == null) {
			arr[value] = fibonacci(value - 1) + fibonacci(value - 2);
		}
		return arr[value];
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}

}
