
public class Recursion {

	static int sum(int num, int value) {

		if (num < 10) {
			return num;
		} else {

			return value + num % 10 + sum(num / 10, value);
		}

	}

	static int power(int a, int b) {
		if (b == 1) {
			return a;
		}
		return a * power(a, b - 1);
	}

	static int fact(int num) {
		if (num == 1) {
			return num;
		}
		return num * fact(num - 1);
	}

	static void printnatural(int value, int dis) {
		if (value == dis) {
			return;
		} else if (value < dis) {
			System.out.println(dis);
			printnatural(value, dis - 1);
		} else {
			System.out.println(value);
			printnatural(value - 1, dis);
		}

	}

	static int printreverse(int n) {
		if (n == 1) {
			return 1;
		}
		System.out.println(n);
		return printreverse(n - 1);
	}

	static boolean pallindrome(int n, int sum) {
		if (n == 0) {
			return false;
		}
		return false;
	}

	static int lcm(int n, int m, int value) {
		value = value + m;
		if (value % n == 0 && value % m == 0) {
			return value;
		}
		return lcm(n, m, value);
	}

	public static void main(String[] args) {
		System.out.println(lcm(11, 7, 0));

	}
}
