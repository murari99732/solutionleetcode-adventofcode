package rough;

import java.util.ArrayList;

public class Practice4 {

	public static void main(String[] args) {

		paths("abc", 0, 2);
	}

	private static void paths(String string, int i, int j) {
		if (i == j) {
			System.out.println(string);
			return;
		}
		for (int k = i; k <=j; k++) {
			string = interchange(string, i, k);
			
			paths(string, i + 1, j);
			string = interchange(string, i, k);

		}

	}

	private static String interchange(String string, int i, int k) {
		char a[] = string.toCharArray();
		char temp = a[i];
		a[i] = a[k];
		a[k] = temp;
		return String.valueOf(a);

	}

}
