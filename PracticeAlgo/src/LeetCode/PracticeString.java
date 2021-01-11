package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.text.PlainDocument;

public class PracticeString {

	static ArrayList<Integer> getindices(int arr[], int i, ArrayList<Integer> ar) {
		if (i == 0) {
			return ar;
		}
		if (arr[i] == 2) {
			ar.add(i);
		}

		ArrayList<Integer> br = getindices(arr, i - 1, ar);

		return br;

	}

	static int[] getindicesarray(int arr[], int i, int brr[], int j) {
		if (arr.length == i) {
			return brr;
		}
		if (arr[i] == 2) {
			brr[j] = i;
			return getindicesarray(arr, i + 1, brr, j + 1);
		} else {
			return getindicesarray(arr, i + 1, brr, j);
		}
	}

	static void getsubsequence(String word, int i, String ans) {
		if (word.length() == i) {
			System.out.println(ans);
			return;
		}
		getsubsequence(word, i + 1, ans + word.charAt(i));
		getsubsequence(word, i + 1, ans);
	}

	static ArrayList<Integer> getsubsquent(int arr[], int i, ArrayList<Integer> ar) {
		if (i == arr.length) {
			ar.add(0);
			return ar;
		}
		ArrayList<Integer> br = getsubsquent(arr, i + 1, ar);
		for (Integer dc : br) {
			br.add(dc * 10 + arr[i]);
			br.add(dc);
		}
		return br;

	}

	static ArrayList<String> getkeypad(String abc, int i) {

		if (abc.length() == i) {
			ArrayList<String> g = new ArrayList<String>();
			g.add("");
			return g;
		}

		ArrayList<String> br = getkeypad(abc, i + 1);
		ArrayList<String> g = new ArrayList<String>();
		String word = key[Integer.parseInt(String.valueOf(abc.charAt(i)))];
		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(i);
			for (String it : br) {
				br.add(it + c);
			}
		}
		return br;

	}

	static void getpath(int arr, String ans) {
		if (arr < 0) {
			System.out.println(ans);
			return;
		}
		getpath(arr - 1, ans + "H");
		getpath(arr - 2, ans + "V");
		getpath(arr - 3, ans + "M");
	}

	static String key[] = { "ABC", "DEFG", "HIZ", "JLM", "NOP" };

	static void printkeypad(String number, int i, String ans) {

		if (number.length() == i) {
			System.out.println(ans);
			return;
		}

		String w = key[Integer.parseInt(String.valueOf(number.charAt(i)))];
		for (int j = 0; j < w.length(); j++) {
			char c = w.charAt(j);
			printkeypad(number, i + 1, ans + c + " ");
		}
	}

	static ArrayList<String> printstairs(int stairs, String ans) {
		if (stairs <= 0) {
			ArrayList<String> dc = new ArrayList<String>();
			dc.add("");
			return dc;
		}
		ArrayList<String> br = printstairs(stairs - 1, ans + "H");
		ArrayList<String> cr = printstairs(stairs - 2, ans + "V");
		ArrayList<String> dr = printstairs(stairs - 3, ans + "Z");
		ArrayList<String> er = new ArrayList<String>();
		for (String it : br) {
			er.add(it + "H");
		}
		for (String it : cr) {
			er.add(it + "V");
		}
		for (String it : dr) {
			er.add(it + "Z");
		}
		return er;
	}

	static void getmaze(int x, int y, int xl, int yl, String ans) {
		if (x < 0 || y < 0 || x > xl || y > yl) {
			return;
		}
		if (x == xl && y == yl) {
			System.out.println(ans);
			return;
		}
		getmaze(x + 1, y, xl, yl, ans + "H");
		getmaze(x, y + 1, xl, yl, ans + "V");
	}

	static void displaymaze(int x, int y, int xf, int yf, String ans) {
		if (x < 0 || y < 0 || x > xf || y > yf) {
			return;
		}
		if (x == xf && y == yf) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i < xf - x; i++) {
			displaymaze(x + i, y, xf, yf, ans + "H");
		}
		for (int i = 1; i < yf - y; i++) {
			displaymaze(x, y + i, xf, yf, ans + "V");
		}
		for (int i = 1, j = 1; i < yf - y && j < xf - x; i++, j++) {
			displaymaze(x + j, y + i, xf, yf, ans + "Z");
		}
	}

	static void recursion(String a, int i, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int j = 0; j < a.length(); j++) {
			char c = a.charAt(j);
			String dc = a.substring(0, j) + a.substring(j + 1);
			recursion(dc, i, ans + c);
		}
	}

	static void printencoding(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		int val = Integer.parseInt(Character.toString(a.charAt(0)));
		printencoding(a.substring(1), ans + (char) (val + 'a' - 1) + " ");
		if (a.length() >= 2) {
			String dc = a.substring(0, 2);
			int v = Integer.parseInt(dc);
			if (v < 26) {
				printencoding(a.substring(2), ans + (char) ('A' + v - 1) + " ");
			}
		}
	}

	static void printencoding1(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		int val = Integer.parseInt(Character.toString(a.charAt(0)));
		printencoding1(a.substring(1), ans + (char) (val + 'a' - 1) + " ");
		if (a.length() >= 2) {
			int dal = Integer.parseInt(Character.toString(a.charAt(1)));
			if (Integer.parseInt(Character.toString(a.charAt(0))) * 10 + dal < 26) {
				printencoding1(a.substring(2),
						ans + (char) ((Integer.parseInt(Character.toString(a.charAt(0))) * 10 + dal) + 'a' - 1) + " ");
			}

		}
	}

	static void floodfill(int m[][], int x, int y) {
		if (x < 0 || x >= m.length || y < 0 || y >= m.length || m[x][y] == 2 || m[x][y] == 1) {
			return;
		}
		m[x][y] = 2;
		floodfill(m, x + 1, y);
		floodfill(m, x, y + 1);
		floodfill(m, x - 1, y);
		floodfill(m, x, y - 1);
		floodfill(m, x + 1, y + 1);
		floodfill(m, x - 1, y - 1);
	}

	static void subset(int arr[], int i, int ans, String store) {
		if (i == arr.length) {
			if (ans == 23)
				System.out.println(store);
			return;
		}
		subset(arr, i + 1, ans + arr[i], store + arr[i] + " ");
		subset(arr, i + 1, ans, store);
	}

	static void nqueen(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 0) {
				getqueenutil(m, i);
			}
		}
	}

	private static void getqueenutil(int[][] m, int i) {
		if (i > m.length) {
			return;
		}
		if (i == m.length) {
			for (int j = 0; j < m.length; j++) {
				for (int k = 0; k < m.length; k++) {
					System.out.print(m[j][k] + " ");
				}
				System.out.println();
			}
		}

		for (int j = 0; j < m.length; j++) {
			if (safevisit(m, i, j)) {
				m[i][j] = 1;
				getqueenutil(m, i + 1);
				m[i][j] = 0;
			}
		}

	}

	private static boolean safevisit(int[][] m, int i, int j) {
		for (int k = i; k >= 0; k--) {
			if (m[k][j] == 1) {
				return false;
			}
		}
		for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
			if (m[k][l] == 1) {
				return false;
			}
		}
		for (int k = i, l = j; k >= 0 && l < m.length; k--, l++) {
			if (m[k][l] == 1) {
				return false;
			}
		}
		return true;
	}

	static void knight(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					getknight(m, i, j, 0);
				}
			}
		}

	}

	private static void getknight(int[][] m, int x, int y, int count) {
		if (x >= m.length || x < 0 || y >= m.length || y < 0 || m[x][y] > 0) {
			return;
		}
		if (count == m.length * m.length) {
			for (int k = 0; k < m.length; k++) {
				for (int l = 0; l < m.length; l++) {
					System.out.print(m[k][l] + " ");
				}
				System.out.println();
			}
		}

		m[x][y] = count;
		getknight(m, x + 2, y + 1, count + 1);
		getknight(m, x + 1, y - 2, count + 1);
		getknight(m, x + 1, y + 2, count + 1);
		getknight(m, x - 1, y + 2, count + 1);

		m[x][y] = 0;

	}

	static void solvesudoku(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == 0) {
				sudokutils(m, i, 0);
			}
		}
	}

	private static void sudokutils(int[][] m, int i, int j) {
		if (i == m.length && j == m.length) {
			System.out.println("true");
			return;
		}

		int dx = 0;
		int dy = 0;
		if (j == m.length - 1) {
			dx = i + 1;
			dy = 0;
		} else {
			dx = i;
			dy = j + 1;
		}
		if (m[i][j] != 0) {
			sudokutils(m, dx, dy);
		} else {
			for (int k = 1; k <= 9; k++) {
				if (safevisitsudoku(m, i, j, k)) {
					m[i][j] = k;
					sudokutils(m, dx, dy);
					m[i][j] = 0;
				}
			}
		}

	}

	private static boolean safevisitsudoku(int[][] m, int i, int j, int value) {
		for (int k = 0; k < m.length; k++) {
			if (m[i][k] == value) {
				return false;
			}
		}
		for (int k = 0; k < m.length; k++) {
			if (m[k][i] == value) {
				return false;
			}
		}
		int dx = i / 3 * 3;
		int dy = j / 3 * 3;
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (m[dx + k][dy + l] == value) {
					return false;
				}

			}
		}

		return true;
	}

	static void pepcoding(int i, String pep, String ans, int ds) {
		if (pep.length() == i) {
			String dc=ans+ds;
			dc=dc.replaceAll("0", ""); 
			System.out.println(dc);
		
			return;
		}

		pepcoding(i + 1, pep, ans, ds + 1);
		pepcoding(i + 1, pep, ans + ds + pep.charAt(i), 0);
	}

	public static void main(String[] args) {
		IntStream.range(0, 6).filter(a->a%2==0).forEach(System.out::println);
		IntStream.range(0, 5).sum();
		ArrayList<String> ar= new ArrayList<String>();
		ar.add("akk");
		ar.add("abcd");
		ar.add("annasn");
		ar.add("av");
		
		System.out.println(ar.stream().filter(a->!a.isEmpty() && a.length()>3).collect(Collectors.toList()));
	}
}
