import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class BitManipulation {

	static void graycode(int v, String ans) {
		if (v == 0) {
			System.out.println(ans);
			return;
		}
		graycode(v - 1, ans + 0);
		graycode(v - 1, ans + 1);
	}

	static void increment(int arr[], int i, int value, String ans) {
		if (arr.length - 1 == i) {
			System.out.println(ans + " " + value);
			System.out.println();
			return;
		}
		for (int j = i + 1; j < arr.length; j++) {
			increment(arr, j, value | i, ans + ":" + j + ":" + i + "->");
			increment(arr, j, value, ans);
		}
	}

	static void gettwoduplicate(int arr[]) {
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			c = c ^ arr[i];
		}
		int dc = c & -c;

		int fc = 0;
		int dce = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean f = (dc & arr[i]) == 0 ? false : true;
			if (f == false) {
				fc = fc ^ arr[i];
			} else {
				dce = dce ^ arr[i];
			}

		}
		System.out.println(dce + " " + fc);

	}

	static void checkbit(int value) {
		int c = 0;
		for (int i = 0; i < 16; i++) {

		}
	}

	public static void main(String[] args) throws Exception {

		gettwoduplicate(new int[] { 1, 2, 3, 2, 4, 1, 5, 4 });

//		int md = 11;
//		int c = (1 << 2);
//		System.out.println(md | c);
//		int d = ~(1 << 3);
//		System.out.println(md & d);
//		int ce = (1 << 1);
//		System.out.println(md ^ ce);
//		int de = (1 << 3);
//		System.out.println((md & de) == 0 ? false : true);
		// int m = 25;

		// System.out.println(Integer.toBinaryString(6 & -6));
		// System.out.println(6 & -6);
//		int n = 5;
//		int offmask = (1 << 3);
//		int onmask = ~(1 << 2);
//		int toggle = (1 << 2);
//		int check = (1 << 3);
//		System.out.println(n | offmask);
//		System.out.println(n & onmask);
//		System.out.println(n ^ toggle);
//		System.out.println((n & check) == 0 ? true : false);
//		int value = 8;
//		int fd = 0;
//		while (value != 0) {
//			fd++;
//			int d = value & -value;
//		//	int c = value - d;
//		/	value = c;
//		}
		// System.out.println(fd);

	}

}
