
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//https://www.youtube.com/c/Pepcoding/playlists
public class RecursionPerfect {

	static int increasingdecreasing(int value, boolean flag) {
		if (value == 0 && flag == false) {
			return 0;
		}
		if (value == 5 && flag == true) {
			return 5;
		}
		int d = increasingdecreasing(value - 1, false);
		System.out.print(d + " ");
		d = increasingdecreasing(value + 1, true);
		System.out.print(d + " ");
		return d;
	}

	static int increasingfirst(int value) {
		if (value == 0) {
			return 0;
		}
		System.out.print(value + " ");
		int s = increasingfirst(value - 1);
		System.out.print(value + " ");
		return s;
	}

	static int increasing(int value) {
		if (value == -1) {
			return -1;
		}

		int s = increasing(value - 1);

		System.out.print((s + 1) + " ");
		return s + 1;

	}

	static int factorial(int value) {
		if (value == 1) {
			return 1;
		}
		int s = factorial(value - 1);
		return value * s;

	}

	static int power(int n, int x) {
		if (x == 1) {
			return n;
		}
		return (int) Math.pow(n, power(n, x - 1));
	}

	static int powerlog(int x, int y) {
		if (x == 0) {
			return 1;
		}
		if (x == 1) {
			return y;
		}
		int val = 0;
		if (x % 2 == 0) {
			val = powerlog(x / 2, y);
		} else {
			val = powerlog(x / 2, y) * y;
		}
		return val;
	}

	static int printBst(int n) {
		if (n == 0) {
			return 0;
		}
		System.out.print(n + " <-first value ");
		int nc = printBst(n - 1);
		System.out.println();
		System.out.print(n + " <-second value ");

		System.out.println();
		System.out.print(n + " <-third value ");
		return nc;
	}

	static int max = 0;

	static int getmaximum(int arr[], int i, int max) {
		if (i == 0) {
			return 0;
		}
		int d = getmaximum(arr, i - 1, max);
		int e = arr[i];
		return Math.max(e, d);

	}

	static int getpos(int arr[], int i) {
		if (i == 0) {
			return 0;
		}
		if (arr[i] == 3) {
			return i;
		}
		int f = getpos(arr, i - 1);
		if (f != 0) {
			return f;
		}
		return 0;

	}

	static int getlastpos(int arr[], int i, ArrayList<Integer> ar) {
		if (i == 0) {
			return -1;
		}

		int d = getlastpos(arr, i - 1, ar);
		if (arr[i] == 3) {
			ar.add(i);
			return i;
		}
		return d;
	}

	static ArrayList<String> getsubsequence(String word) {
		if (word.equals("")) {
			ArrayList<String> curr = new ArrayList<String>();
			curr.add("");
			return curr;
		}
		char start = word.charAt(0);
		String temp = word.substring(1);
		ArrayList<String> ar = getsubsequence(temp);
		ArrayList<String> curr = new ArrayList<String>();
		for (String a : ar) {
			curr.add(a);
			curr.add(start + a);
		}
		return curr;
	}

	static ArrayList<String> getsubcount(String word, ArrayList<String> curr) {
		if (word.equals("")) {
			curr.add("");
			return curr;
		}
		char start = word.charAt(0);
		String temp = word.substring(1);
		ArrayList<String> ar = getsubsequence(temp);
		for (String a : ar) {
			curr.add(a);
			curr.add(start + a);
		}
		return curr;
	}

	static ArrayList<String> getsubvalue(String word, ArrayList<String> curr) {
		if (word.equals("")) {
			curr.add("");
			return curr;
		}
		char start = word.charAt(0);
		String temp = word.substring(1);
		ArrayList<String> ar = getsubsequence(temp);
		for (String a : ar) {
			curr.add(a);
			curr.add(start + a);
		}
		return curr;
	}

	static ArrayList<String> getkeypad(String word, int i, ArrayList<String> arr, String str[]) {

		if (word.equals("")) {
			arr.add("");
			return arr;
		}

		String t = word.substring(1);
		ArrayList<String> curr = getkeypad(t, i, arr, str);
		if (t.equals("")) {
			arr.add("");
			return arr;
		}
		int g = Integer.parseInt(t);
		String cd = str[g];
		for (String a : curr) {
			for (int l = 0; l < cd.length(); l++) {
				arr.add(a + l);
			}
		}
		return arr;

	}

	static ArrayList<String> getdisplayvalue(String word, ArrayList<String> arr) {
		if (word.equals("")) {
			arr.add("");
			return arr;
		}
		char c = word.charAt(0);
		ArrayList<String> list = getdisplayvalue(word.substring(1), arr);

		for (String ar : list) {
			arr.add(ar);
			arr.add(ar + c);
		}
		return arr;

	}

	static ArrayList<String> displayvalue(String word, ArrayList<String> arr, String str[]) {
		if (word.length() == 0) {
			arr.add("");
			return arr;
		}

		char temp = word.charAt(0);
		String curr = word.substring(1);
		ArrayList<String> arrval = displayvalue(curr, arr, str);

		String c = str[temp - '0'];
		for (int i = 0; i < c.length(); i++) {
			char ct = c.charAt(i);
			for (String cd : arrval) {
				arr.add(ct + cd);
			}
		}
		return arr;
	}

	static ArrayList<Integer> getstairs(int value, ArrayList<Integer> arr) {
		if (value == 0) {
			arr.add(value);
			return arr;
		} else if (value < 0) {
			return arr;
		}
		ArrayList<Integer> a = getstairs(value - 1, arr);
		ArrayList<Integer> b = getstairs(value - 2, arr);
		ArrayList<Integer> c = getstairs(value - 3, arr);

		for (int i = 0; i < a.size(); i++) {
			arr.add(1 + a.get(i));
		}
		for (int i = 0; i < b.size(); i++) {
			arr.add(2 + b.get(i));
		}
		for (int i = 0; i < c.size(); i++) {
			arr.add(3 + c.get(i));
		}

		return arr;
	}

	static ArrayList<String> getmatrixvalue(int i, int j, int dx, int dy, ArrayList<String> arr) {
		if (i == dx && j == dy) {
			arr.add("");
			return arr;
		}

		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		if (i < dx)
			a = getmatrixvalue(i + 1, j, dx, dy, arr);
		if (j < dy)
			b = getmatrixvalue(i, j + 1, dx, dy, arr);
		if (i < dx && j < dy)
			c = getmatrixvalue(i + 1, j + 1, dx, dy, arr);
		for (String ab : a) {
			arr.add("h" + ab);
		}
		for (String ab : b) {
			arr.add("v" + ab);
		}
		for (String ab : c) {
			arr.add("d" + ab);
		}
		return arr;
	}

	static void getencoding(String word, String ans) {

		if (word.length() < 0 || word.length() > 4) {
			return;
		}
		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		String c = word.substring(0, 1);
		String temp = word.substring(1);
		String ptemp = "";
		int cd = Integer.parseInt(word.substring(0, 2));
		if (cd <= 26) {
			ptemp = word.substring(2);
		}
		getencoding(temp, ans + c + ('a' + Integer.parseInt(c)));
		getencoding(ptemp, ans + cd + ('a' + cd));

	}

	static void getpermutation(String word, String ans) {

		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(0);
			String v = word.substring(0, i);
			String w = word.substring(i + 1);
			String ab = v + w;
			getpermutation(ab, ans + c);

		}
	}

	static void towerhanoi(int i, int id1, int id2, int id3) {
		if (i == 0) {
			return;
		}
		towerhanoi(i - 1, id1, id3, id2);
		System.out.println("[" + id1 + " -> " + id2);
		towerhanoi(i - 1, id3, id1, id2);
	}

	static int max(int arr[], int i) {
		if (i == 0) {
			return arr[i];
		}
		int d = max(arr, i - 1);
		int e = arr[i];
		return Math.max(d, e);
	}

	static void targetsum(int arr[], int i, String ans, int value, int temp) {
		if (value == temp) {
			System.out.println(ans);
			return;
		}
		if (i > arr.length - 1) {
			return;
		}
		int c = arr[i];
		targetsum(arr, i + 1, ans + c, value, temp + c);
		targetsum(arr, i + 1, ans, value, temp);

	}

	static ArrayList<String> getbb(int arr[], int i, ArrayList<String> temp, int sum) {
		if (i > arr.length - 1) {
			return temp;
		}
		if (sum == 4) {
			return temp;
		}
		int value = arr[0];
		ArrayList<String> curr = getbb(arr, i + 1, temp, sum + value);
		// ArrayList<String> curr1 = getbb(arr, i + 1, temp, sum);

		for (String a : curr) {
			if (sum == 4) {
				temp.add(a + value);
			} else {
				temp.add(a);
			}
		}
		return temp;
	}

	static void getpair(int arr[], int i, String ans) {
		int pair = arr[i];
		getpair(arr, i + 1, ans + pair);
		if (i >= 2) {

		}
		getpair(arr, i + 2, ans + arr[i]);
	}

	static void decoding(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}

		if (a.charAt(0) != '0') {
			char c = a.charAt(0);
			String word = a.substring(1);
			decoding(word, ans + (c + 'a') + c);
			if (a.length() >= 2) {
				String curr = a.substring(0, 2);
				if (Integer.parseInt(curr) < 26) {
					String temp = a.substring(2);
					decoding(temp, ans + curr + ((char) 64 + curr));
				}
			}

		}

	}

	static void queen(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			nqueen(m, i, "");
		}
		System.out.println();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void nqueen(int m[][], int i, String value) {
		if (m.length <= i) {
			System.out.println(value);
			System.out.println("..................................................................");
			for (int k = 0; k < m.length; k++) {
				for (int j = 0; j < m.length; j++) {
					System.out.print(m[k][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		for (int j = 0; j < m.length; j++) {
			if (safevisit(m, i, j)) {
				m[i][j] = 1;

				nqueen(m, i + 1, value + " " + i + " " + j + " ");

				m[i][j] = 0;

			}
		}

	}

	private static boolean safevisit(int[][] m, int i, int j) {

		for (int p = i - 1, q = j; p >= 0; p--) {
			if (m[p][q] == 1) {
				return false;
			}
		}
		for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p--, q--) {
			if (m[p][q] == 1) {
				return false;
			}
		}
		for (int p = i - 1, q = j + 1; p >= 0 && q < m.length; p--, q++) {
			if (m[p][q] == 1) {
				return false;
			}
		}

		return true;
	}

	static void knight(int m[][]) {
		boolean b[][] = new boolean[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				movesknight(m, i, j, b, "", 0);
			}
		}
	}

	private static void movesknight(int[][] m, int i, int j, boolean[][] b, String ans, int count) {
		if (count >= 15) {
			System.out.println(ans);
			System.out.println("....................................................");
			for (int k = 0; k < m.length; k++) {
				for (int l = 0; l < m.length; l++) {
					System.out.print(b[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println("....................................................");
			return;
		}
		b[i][j] = true;

		if (safevisitknight(m, i - 1, j, b)) {
			movesknight(m, i - 1, j, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i - 1, j + 1, b)) {
			movesknight(m, i - 1, j + 1, b, ans + " " + i + " " + j, count + 1);
		}

		if (safevisitknight(m, i, j + 1, b)) {
			movesknight(m, i, j + 1, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i + 1, j + 1, b)) {
			movesknight(m, i + 1, j + 1, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i + 1, j, b)) {
			movesknight(m, i + 1, j, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i - 1, j - 1, b)) {
			movesknight(m, i - 1, j - 1, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i, j - 1, b)) {
			movesknight(m, i, j - 1, b, ans + " " + i + " " + j, count + 1);
		}
		if (safevisitknight(m, i - 1, j + 1, b)) {
			movesknight(m, i - 1, j + 1, b, ans + " " + i + " " + j, count + 1);
		}
		b[i][j] = false;

	}

	private static boolean safevisitknight(int[][] m, int i, int j, boolean[][] b) {
		if (i >= 0 && i <= m.length - 1 && j >= 0 && j <= m.length - 1 && b[i][j] == false) {
			return true;
		}
		return false;
	}

	static void targetvalue(int arr[], int i, String value, int temp, int val) {
		if (val == temp) {
			System.out.println(value);
			return;
		}

		if (arr.length - 1 < i) {
			return;
		}

		int v = arr[i];
		targetvalue(arr, i + 1, value + v, temp, val + v);
		targetvalue(arr, i + 1, value, temp, val);

	}

	static void getsum(int arr[], int i, String ans, int value) {
		if (i > arr.length - 1) {
			return;
		}
		if (value == 5) {
			System.out.println(ans);
			return;
		}
		int v = arr[i];
		getsum(arr, i + 1, ans + v, value + v);
		getsum(arr, i + 1, ans, value);
	}

	static void sudoku(int m[][], int a, int b) {
		if (m.length < a || m.length < b) {
			return;
		}
		if (m.length - 1 == a && m.length - 1 == b) {
			System.out.println("....................................................");
			for (int k = 0; k < m.length; k++) {
				for (int l = 0; l < m.length; l++) {
					System.out.print(m[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println("....................................................");
			return;
		}
		for (int i = 0; i < m.length; i++) {
			for (int k = 0; k < m.length; k++) {
				for (int n = 0; n < 4; n++) {
					if (safevisitadd(m, i, k, n)) {
						m[i][k] = n;
						sudoku(m, i, k);
						m[i][k] = 0;
					}
				}
			}
		}

	}

	private static boolean safevisitadd(int[][] m, int i, int j, int val) {
		if (j <= 0 && j > m.length - 1) {
			return false;
		}
		for (int r = i - 1, c = j; r >= 0; r--) {
			if (m[r][c] == val) {
				return false;
			}
		}
		for (int r = i, c = j - 1; c >= 0; c--) {
			if (m[r][c] == val) {
				return false;
			}
		}

		return true;
	}

	static void getmatrix(int m, int x, int y) {
		int value = m / 3;
		int dx = x / 3 + 1;
		int dy = y / 3 + 1;
		System.out.println(dx + " " + dy);
	}

	static void getsudoku(int m[][], int x, int y) {
		if (x >= 0 || y == m.length - 1) {
			System.out.println("....................................................");
			for (int k = 0; k < m.length; k++) {
				for (int l = 0; l < m.length; l++) {
					System.out.print(m[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println("....................................................");

			return;
		}
		int vx = 0;
		int vy = 0;
		if (y == m.length - 1) {
			vx = x + 1;
			vy = 0;
		} else {
			vx = x;
			vy = y + 1;
		}
		if (m[x][y] != 0) {
			getsudoku(m, vx, vy);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (safevisitknight(m, x, y, i)) {
					m[x][y] = i;
					getsudoku(m, vx, vy);
					m[x][y] = 0;
				}

			}
		}
	}

	private static boolean safevisitknight(int[][] m, int x, int y, int i) {

		for (int j = 0; j < m.length; j++) {
			if (m[x][j] == i) {
				return false;
			}
		}

		for (int j = 0; j < m.length; j++) {
			if (m[j][y] == i) {
				return false;
			}
		}

		int dx = 3 * x / 3;
		int dy = 3 * y / 3;

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (m[dx + 1][dy + 1] == i) {
					return false;
				}
			}
		}

		return true;
	}

	static void subsequence(String a, String b) {
		if (a.length() == 0) {
			System.out.println(b);
			return;
		}
		char f = a.charAt(0);
		String word = a.substring(1);
		subsequence(word, b + f);
		subsequence(word, b);
	}

	static int recursivegetword(String word[], int value[], ArrayList<Integer> score, int index) {
		int g = recursivegetword(word, value, score, index + 1);

		String w = word[index];
		boolean flag = true;
		int words = 0;
		for (int i = 0; i < w.length(); i++) {
			char c = w.charAt(i);
			if (value[c - 'a'] == 0) {
				flag = false;
				break;
			}
			value[c - 'a']--;
			words = words + score.get(c - 'a');

		}
		if (flag == true) {
			words = recursivegetword(word, value, score, index + 1);
		}
		return Math.max(words, g);

	}

	static void recursive(String a, int count, String phele) {
		if (a.length() == 0) {
			if (phele.contains("0")) {
				phele = phele.replace("0", "");
			}
			System.out.print(phele + " ");
			return;
		}

		char c = a.charAt(0);
		String word = a.substring(1);

		recursive(word, count + 1, phele);
		recursive(word, count, phele + c + count);

	}

	static void getdeath(int value, int i, int temp) {
		if (value < 9) {
			System.out.println(value);
			return;
		}
		if (i == 4) {

		}
		getdeath(value, i + 1, temp);
	}

	static void sudokugame(int m[][], int x, int y) {

		if (x > m.length - 1 || y > m.length - 1) {
			System.out.println("....................................................");
			for (int k = 0; k < m.length; k++) {
				for (int l = 0; l < m.length; l++) {
					System.out.print(m[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println("....................................................");

			return;
		}

		int dx = 0;
		int dy = 0;
		if (y == m.length - 1) {
			dx = x + 1;
			dy = 0;
		} else {
			dx = x;
			dy = y + 1;
		}
		if (m[x][y] != 0) {
			sudokugame(m, dx, dy);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (safevisitgame(m, x, y, i)) {
					m[x][y] = i;
					sudokugame(m, dx, dy);
					m[x][y] = 0;

				}
			}
		}

	}

	private static boolean safevisitgame(int[][] m, int x, int y, int i) {

		for (int j = 0; j < m.length; j++) {
			if (m[x][j] == i) {
				return false;
			}
		}

		for (int j = 0; j < m.length; j++) {
			if (m[j][y] == i) {
				return false;
			}
		}

		int dx = 3 * x / 3;
		int dy = 3 * y / 3;

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (m[dx + 1][dy + 1] == i) {
					return false;
				}
			}
		}

		return true;
	}

	static void abb(String s, String a, int count) {
		if (s.length() == 0) {
			System.out.println(a);
			return;
		}
		char val = s.charAt(0);
		abb(s.substring(1), a, count + 1);
		abb(s.substring(1), a + val + count, count);
	}

	static int jesophusproblem(int value, int count) {

		int k = jesophusproblem(value, count - 1);
		int d = (count + k) % value;
		return d;
	}

	static void crossword(char c[][], String s[], int x, int y, int index, String word) {

		int dx = 0;
		int dy = 0;
		if (word.length() == 0) {
			index = index + 1;
			dx = x + 1;
			dy = y + 1;
			word = s[index];
		} else {
			dx = x;
			dy = y;
		}
		if (c[x][y] != '-') {
			for (int i = 0; i < word.length(); i++) {
				char cd = word.charAt(0);
				String temp = word.substring(1);
				crossword(c, s, dx, dy, index, word);
			}
		}

	}

	static int getgold(int m[][], int i, int j) {

		int a = getgold(m, i, j);
		int b = getgold(m, i, j);
		int c = getgold(m, i, j);
		int d = getgold(m, i, j);
		max = Math.max(max, a + b + c + d);
		return max;
	}

	static void getdfs(int n) {
		for (int i = 1; i <= 9; i++) {
			DFS(i, n);
		}
	}

	private static void DFS(int i, int n) {
		if (i < n) {
			return;
		}
		System.out.println(i);
		for (int j = 0; j < 9; i++) {
			DFS(i * 10 + j, n);
		}

	}

	static void lexigraph(String a[], int index, int temp, String answer) {
		if (!answer.equals("") && Integer.parseInt(answer) == 1000) {
			System.out.println(Integer.parseInt(answer));
			return;
		}
		if (!answer.equals("") && Integer.parseInt(answer) > 1000) {
			System.out.println(Integer.parseInt(answer));
			return;
		}

		for (int i = 1; i <= a.length; i++) {
			lexigraph(a, i, temp, answer + i);
			lexigraph(a, i, temp, answer);
		}

	}

	static void printsta(int value, String ans) {
		if (value == 0) {
			System.out.println(ans);
			return;
		}
		if (value < 0) {
			return;
		}

		printsta(value - 1, ans + "L");
		printsta(value - 2, ans + "R");
		printsta(value - 3, ans + "M");
	}

	static void horizontal(int m[][], int x, int y, String ans, boolean b[][]) {
		if (x < 0 || y < 0 || x > m.length || y > m.length || b[x][y] == false) {
			return;
		}
		if (x == m.length && y == m.length) {
			System.out.println(ans);
			return;
		}
		b[x][y] = true;
		horizontal(m, x + 1, y, ans + "H", b);
		horizontal(m, x, y + 1, ans + "V", b);
		b[x][y] = false;
	}

	private static void nqueenvalue(int[][] m, int j) {
		if (j >= m.length) {
			return;
		}
		for (int i = 0; i < m.length; i++) {
			if (safevistj(m, i, j)) {
				m[i][j] = 1;
				nqueenvalue(m, j + 1);
				m[i][j] = 0;
			}
		}

	}

	private static boolean safevistj(int[][] m, int i, int j) {
		for (int rc = i, bc = j; bc >= 0; bc--) {

		}
		return false;
	}

	static void targetsumvalue(int arr[], int i, int ans, String store) {
		if (arr.length == i) {
			return;
		}
		if (ans > 10) {

			return;
		}
		if (ans == 10) {
			System.out.println(store);
			return;
		}
		int temp = arr[i];
		targetsumvalue(arr, i + 1, ans + temp, store + temp + " ");
		targetsumvalue(arr, i + 1, ans, store);
	}

	static void encodingvalue(String a, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		String c = a.substring(0, 1);
		String temp = a.substring(1);
		char cd = (char) (Integer.parseInt(c) - 1 + 'a');
		encodingvalue(temp, ans + cd);
		if (a.length() >= 2) {
			String b = a.substring(0, 2);
			String pt = a.substring(2);
			if (Integer.parseInt(b) < 26) {
				encodingvalue(pt, ans + (char) ('a' + Integer.parseInt(b) - 1));
			}
		}
	}

	static void jumprecurs(int m[][], int x, int y) {
		for (int i = 0; i < m.length; i++) {
			jumprecurs(m, i, y);
		}
	}

	static void recursionper(String a, String b) {

		if (a.length() == 0) {
			System.out.println(b);
			return;
		}

		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			String next = a.substring(0, i);
			String prev = a.substring(i + 1);
			String pre = next + prev;
			recursionper(pre, b + c);
		}
	}

	static void mobile(String a, String value[], String b) {
		if (a.length() == 0) {
			System.out.println(b);
			return;
		}
		char c = a.charAt(0);
		String temp = a.substring(1);
		String curr = value[c - '0'];
		for (int i = 0; i < curr.length(); i++) {
			char cd = curr.charAt(i);
			System.out.println(b);
			mobile(temp, value, b + cd);
			System.out.println(b);
		}

	}

	static ArrayList<String> subvalue(String value) {
		if (value.length() == 0) {
			ArrayList<String> ar = new ArrayList<String>();
			ar.add("");
			return ar;
		}
		char c = value.charAt(0);
		ArrayList<String> val = subvalue(value.substring(1));
		ArrayList<String> ar = new ArrayList<String>();
		for (String it : val) {
			ar.add(it + c);
			ar.add(it);
		}
		return ar;
	}

	static void subseuqncerem(String value, String ans) {
		if (value.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		subseuqncerem(value.substring(1), ans + value.charAt(0));
		subseuqncerem(value.substring(1), ans);
	}

	static void valuemaximum(int arr[], int i, int j, String ans, int temp) {
		if (j == arr.length - 1) {
			int st = Integer.parseInt(ans.replaceAll(" ", ""));
			max = Math.max(max, st);
			System.out.println(max);
			return;
		}
		for (int k = 0; k < arr.length - 1; k++) {
			for (int l = k + 1; l < arr.length; l++) {
				int stemp = arr[k];
				arr[k] = arr[l];
				arr[l] = stemp;
				valuemaximum(arr, k, l, ans + arr[k] + arr[l], stemp);
				stemp = arr[k];
				arr[k] = arr[l];
				arr[l] = stemp;
			}
		}

	}

	static void combination(int arr[], int index, ArrayList<Integer> ans, int box, int j) {
		if (index == arr.length - 1) {
			Arrays.stream(arr).forEach(a -> System.out.print(a));
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				combination(arr, index + 1, ans, box, j);
				arr[i] = 1;
				combination(arr, index + 1, ans, box, j);
				arr[i] = 0;

			}
		}
	}

	static void printpermutate(int arr[], int index, ArrayList<Integer> ans, int box, int j) {

		if (j > box) {
			Arrays.stream(arr).forEach(a -> System.out.print(a));
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = j;
				printpermutate(arr, i, ans, box, j + 1);
				arr[i] = 0;
			}
		}

	}

	static void boxes(int v, int arr[], int i, String ans) {
		if (v == 0) {
			if (ans.length() == 4)
				System.out.println(ans);
			return;
		}
		if (i == arr.length) {
			i = 0;
		}
		for (int k = 0; k < arr.length; k++) {
			for (int j = 0; j < v; j++) {
				boxes(j, arr, k, ans + arr[k]);

			}
		}
	}

	static void minimumval(int arr[], int i, ArrayList<Integer> a, ArrayList<Integer> b, String c, String d) {
		if (i > arr.length - 2) {

			System.out.println(a + " " + b);
			System.out.println();
			System.out.println("[" + c + "] [" + d + "]");
			return;
		}
		a.add(arr[i]);
		minimumval(arr, i + 1, a, b, c + arr[i], d);
		a.remove(a.size() - 1);
		b.add(arr[i]);
		minimumval(arr, i + 1, a, b, c, d + arr[i]);
		b.remove(b.size() - 1);
	}

	static void hiring(Set<String> set, String ans, String word) {

		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int j = 0; j < word.length(); j++) {
			String w = word.substring(0, j + 1);

			if (set.contains(w)) {
				String t = word.substring(j + 1);
				hiring(set, " " + ans + w + " ", t);
			}
		}
	}

	static void wordpattern(String word, String ans, String temp, HashMap<Character, String> hasmap) {

		if (word.length() == 0) {
			System.out.println(ans + " " + hasmap);
			return;
		}

		char c = word.charAt(0);
		for (int i = 0; i < temp.length(); i++) {
			String curr = word.substring(0, i + 1);
			if (!hasmap.containsKey(c)) {
				hasmap.put(c, curr);
				wordpattern(word.substring(1), ans + curr, temp, hasmap);
			} else if (hasmap.containsKey(c)) {
				String dp = hasmap.get(c);
				if (dp.equals(curr)) {
					wordpattern(word.substring(1), ans + curr, temp, hasmap);
				}
			}

		}
	}

	static void palindromes(String word, String ans) {
		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < word.length(); i++) {
			String c = word.substring(0, i);
			if (ispalindrome(c, 0, c.length() - 1)) {
				String d = word.substring(i + 1);
				palindromes(d, ans + c);
			}
		}
	}

	private static boolean ispalindrome(String c, int i, int j) {
		if (i >= j) {
			return true;
		}

		boolean ft = false;
		if (c.charAt(i) == c.charAt(j)) {
			ft = ispalindrome(c, i + 1, j - 1);
		}
		return ft;
	}

	static void palrecurse(String word, String ans) {
		if (word.length() == 0) {
			max++;
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			String a = word.substring(0, i);
			String b = word.substring(i + 1);
			palrecurse(a + b, ans + c);
		}
	}

	static void kpartion(int arr[], int i, String l, String r, int k) {
		if (i >= arr.length - 1) {
			if (!l.equals("") && !r.equals(""))
				System.out.println(l + " " + r);
			return;
		}
		if (l.equals("")) {
			kpartion(arr, i, l + arr[i], r, k);
		}
		for (int j = i + 1; j <= k; j++) {
			kpartion(arr, j + 1, l + arr[j], r, k);
			kpartion(arr, j + 1, l, r + arr[j], k);
		}
	}

	static void partition(int arr[], int index, boolean visited[], String ans) {
		if (visited[index] == true) {
			partition(arr, index + 1, visited, ans);
		}
		visited[index] = true;
		partition(arr, index + 1, visited, ans + index + " ");
		for (int i = index + 1; i < arr.length; i++) {
			visited[i] = true;
			partition(arr, index + 1, visited, ans + index + i);
			visited[i] = false;
		}
		visited[index] = false;

	}

	static void friendpairing(int arr[], int index, boolean visited[], String ans) {
		if (index == 0) {
			System.out.println(ans);
			return;
		}

		visited[index] = true;
		friendpairing(arr, index + 1, visited, ans + "-" + arr[index]);
		for (int i = index + 1; i < arr.length; i++) {
			visited[i] = true;
			friendpairing(arr, index + 1, visited, ans + "-" + arr[index] + arr[i]);
			visited[i] = false;
		}
		visited[index] = false;

	}

	private static void mat(int i, int j, String ans) {
		if (j < i) {
			return;
		}

		System.out.println(ans);

		for (int k = 0; k <= 10; k++) {
			mat(10 * i + k, j, ans + k);
		}

	}

	static void maximumscore(String a[], int index, String ans, int pr[]) {

		if (index == a.length) {
			System.out.println(ans);
			return;
		}
		maximumscore(a, index + 1, ans, pr);

		String word = a[index];
		boolean flag = true;
		for (int i = 0; i < word.length(); i++) {
			char cd = word.charAt(0);
			if (pr[cd - 'a'] == 0) {
				flag = false;
				break;
			}
			pr[cd - 'a']--;

		}
		if (flag == true) {

			maximumscore(a, index + 1, ans + word, pr);
		}
		for (int i = 0; i < word.length(); i++) {
			char cd = word.charAt(0);

			pr[cd - 'a']++;

		}

	}

	static void getcoinsvalue(int arr[], int index, int count, int val, String ans) {

		if (index == arr.length - 1) {

			if (count == val) {
				System.out.println(ans);
				return;
			}
			return;
		}

		for (int i = val / arr[index]; i >= 1; i--) {

			getcoinsvalue(arr, index + 1, count, val + arr[index] * i, ans + arr[index]);

		}
		getcoinsvalue(arr, index + 1, count, val, ans);
	}

	static void getcoins(int arr[], int index, int count, int val, String ans) {
		if (arr.length - 1 < index) {
			return;
		}
		if (val < count) {
			return;
		}
		if (val == count) {
			System.out.println(ans);
			return;
		}

		getcoins(arr, index + 1, count + arr[index], val, ans + arr[index]);
		getcoins(arr, index + 1, count, val, ans);

	}

	static void game(int m[][], int x, int y) {
		int dx = 0;
		int dy = 0;
		if (y == m.length) {
			dx = x + 1;
			dy = 0;
		} else {
			dx = x;
			dy = y + 1;
		}
		if (m[x][y] != 0) {
			game(m, dx, dy);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (safevisitgame(m, x, y, i)) {
					m[x][y] = i;
					game(m, dx, dy);
					m[x][y] = 0;
				}
			}
		}
	}

	static void tgs(int arr[], int index, String val, int count) {

		if (index > arr.length - 1) {
			return;
		}
		if (count == 10) {
			System.out.println(val);
			return;
		}
		if (count > 10) {
			return;
		}

		tgs(arr, index + 1, val, count);
		tgs(arr, index + 1, val + arr[index], count + arr[index]);

	}

	static void printmaze(int m[][], int x, int y, String ans) {
		if (x == m.length && y == m.length) {
			System.out.println(ans);
			return;
		}
		printmaze(m, x + 1, y, ans + "H");
		printmaze(m, x, y + 1, ans + "V");
	}

	static void printstairs(int value, String ans) {
		if (value == 0) {
			System.out.println(ans);
			return;
		}
		if (value < 0) {
			return;
		}
		printstairs(value - 1, ans + "1");
		printstairs(value - 2, ans + "2");
		printstairs(value - 3, ans + "3");
	}

	static void printsubsequence(String word, String ans) {
		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}
		printsubsequence(word.substring(1), ans + word.charAt(0));
		printsubsequence(word.substring(1), ans);
	}

	static int min = Integer.MAX_VALUE;

	static void permutation(String word, String ans) {
		if (word.length() == 0) {
			min++;
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			String curr = word.substring(0, i);
			String temp = word.substring(i + 1);
			String dc = curr + temp;
			permutation(dc, ans + c);
		}
	}

	static void printkeypadsearch(String word, String arr[], String ans) {

		if (word.length() == 0) {
			System.out.println(ans);
			return;
		}

		char c = word.charAt(0);
		String w = word.substring(1);
		String a = arr[c - '0'];
		for (int i = 0; i < a.length(); i++) {
			printkeypadsearch(w, arr, ans + a.charAt(i));
		}

	}

	static void friendspairing(int arr[], int j, String ans, boolean used[]) {
		if (j == arr.length) {
			System.out.println(ans);
			return;
		}
		int t = arr[j];
		used[j] = true;
		friendspairing(arr, j + 1, ans + " {" + t + "}  ", used);
		for (int i = j + 1; j < arr.length - 1; j++) {
			used[i] = true;

			friendspairing(arr, i, ans + " {" + j + "" + i + "}  ", used);
			used[i] = false;
		}
		used[j] = false;
	}
	public static final int FIVE_SECONDS = 10000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		Random random = new Random();
		while (true) {
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(FIVE_SECONDS);
		}

	}



	static void friends(int arr[], int i, String ans) {
		friends(arr, i, ans);
		int c = arr[i];
		for (int j = i + 1; j < arr.length; j++) {
			friends(arr, j, ans + c);
		}
	}

	static void coinvalue(int arr[], int i, int value, int ans, String t) {
		if (i == arr.length) {
			if (ans == value) {
				System.out.println(t + " ");
			}
			return;
		}
		if (ans == value) {
			System.out.println(t + " ");
		}
		for (int j = 0; j < arr.length; j++) {

			coinvalue(arr, i + 1, value + arr[i] * j, ans, t + arr[i]);

		}
		coinvalue(arr, i + 1, value, ans, t);
	}

	static void coinchangevalue(int arr[], int i, int value, int ans, String t) {
		if (i == arr.length) {
			if (ans == value) {
				System.out.println(t + " ");
			}
			return;
		}

		int c = arr[i];
		coinchangevalue(arr, i + 1, value, ans + c, t + c);
		coinchangevalue(arr, i + 1, value, ans, t);

	}

	static void stockmarket(int arr[], int i, int add, int bad, String ans) {
		if (i == arr.length) {
			System.out.println(ans);
			max = Math.max(max, add);
			return;
		}
		int temp = arr[i];
		for (int j = i + 1; j < arr.length; j++) {
			stockmarket(arr, j, add + temp, bad, ans + " " + arr[j] + " " + temp);
			stockmarket(arr, j + 1, add - temp, bad, ans + " " + arr[j] + "- " + temp);
		}
	}

	static void distinctchar(String a, int i, String ans, HashMap<Character, Integer> hashmap, int k) {
		if (a.length() == 0) {

			return;
		}
		if (ans.length() == 3) {
			System.out.println(ans);
		}
		char c = a.charAt(0);
		distinctchar(a.substring(1), i + 1, ans + c, hashmap, k);
		distinctchar(a.substring(1), i + 1, ans, hashmap, k);

	}

	static void wordselection(String a, int i, Set<Character> set, String ans) {
		if (a.length() == 0) {
			System.out.println(ans);
			return;
		}
		if (ans.length() == 3) {
			System.out.println(ans);

		}
		for (int j = 0; j < a.length(); j++) {
			char c = a.charAt(j);
			if (set.contains(c)) {
				wordselection(a, j + 1, set, ans);
			} else if (ans.length() > 3) {
				char cd = ans.charAt(0);
				set.remove(cd);
				wordselection(a, j + 1, set, ans.substring(1));

			} else {
				set.add(c);
				wordselection(a, j + 1, set, ans + c);
				set.remove(c);

			}
		}
	}

	static void permutatestring(int value, String asf, String data, int br[], int j) {

		if (asf.length() == 0) {
			System.out.println(data);
			return;
		}
		if (j == br.length) {
			System.out.println(data);
			j = 0;
		}

		for (int i = 0; i < data.length() - 1; i++) {
			String dc = data;
			if (data.charAt(i) == '-') {
				char c = (char) br[j];
				String temp = asf.substring(0, i);
				String ds = asf.substring(i + 1);
				permutatestring(i, asf, data + temp + c + ds, br, j + 1);

			}
			data = dc;
		}

	}

	static void printpermutate(int arr[], int i, int val[], int j) {
		if (i == arr.length - 1) {
			Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
			System.out.println();
			return;
		}

		if (j == val.length) {
			j = 0;
		}
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 0) {
				arr[k] = val[j];
				printpermutate(arr, k, val, j + 1);
				arr[k] = 0;
			}
		}
	}

	static void backtracking(int arr[], int i, ArrayList<Integer> ar, ArrayList<Integer> br, int ans, int bns) {
		if (i == arr.length) {
			int ds = max;
			max = Math.max(Math.abs(ans - bns), max);
			if (ds < max) {
				System.out.println(ans + " " + bns);
				ds = max;
			}

			return;
		}
		ar.add(arr[i]);
		backtracking(arr, i + 1, ar, br, ans + arr[i], bns);
		ar.remove(ar.size() - 1);
		br.add(arr[i]);
		backtracking(arr, i + 1, ar, br, ans, bns + arr[i]);
		br.remove(br.size() - 1);

	}

	static void patterngraph(String pattern, Set<String> arr, int i, ArrayList<String> store, String ans) {
		if (0 == pattern.length() - 1) {
			System.out.println(store);
			return;
		}
		for (int j = 0; j < pattern.length(); j++) {
			String left = pattern.substring(0, j + 1);
			if (arr.contains(left)) {
				String right = pattern.substring(j + 1);
				patterngraph(right, arr, j, store, ans + left + " ");
			}
		}
	}

	static void patterngraph(String pattern, int i, String match, String ans) {
		if (i >= pattern.length()) {
			return;
		}
		if (pattern.length() == 0) {
			if (ans.equals(match)) {
				System.out.println(ans);
				return;
			}
			return;
		}
		for (int j = 0; j < pattern.length(); j++) {
			char c = pattern.charAt(j);
			String temp = pattern.substring(1);
			patterngraph(temp, j, match, ans);
			patterngraph(temp, j, match, ans + c);
		}
	}

	static void permutate(String a, String ans, Set<String> set) {
		if (a.length() == 0) {
			boolean b = ispalindrome(ans, 0, ans.length() - 1);
			if (b == true) {
				System.out.println(ans);
			}
			return;
		}

		char c = a.charAt(0);
		String temp = a.substring(1);

		permutate(temp, ans, set);
		if (!set.contains(ans + c)) {
			set.add(ans + c);
			permutate(temp, ans + c, set);
			set.remove(ans + c);
		}

	}

	static void maximumgold(int m[][], int x, int y, int value, boolean flag[][]) {

		flag[x][y] = true;
		maximumgold(m, x + 1, y, value + m[x][y], flag);
		maximumgold(m, x, y + 1, value + m[x][y], flag);
		value = value - m[x][y];
		flag[x][y] = false;

	}

	static void printdict(int value, int maxval) {

		if (value >= maxval) {
			return;
		}

		System.out.println(value);
		for (int i = 0; i < 9; i++) {
			printdict(10 * value + i, maxval);
		}
	}

	static void maximumword(String s[], int i, int value[], HashMap<Character, Integer> hasmap, String ans) {

		maximumword(s, i + 1, value, hasmap, ans);
		String c = s[i];
		HashMap<Character, Integer> temp = hasmap;
		boolean flag = true;
		for (int j = 0; j < c.length(); i++) {
			char cd = c.charAt(j);
			if (hasmap.containsKey(cd) && hasmap.get(cd) <= 0) {
				int cf = hasmap.get(cd);
				hasmap.put(cd, cf - 1);
			} else {
				flag = false;
			}

		}
		if (flag == true)
			maximumword(s, i + 1, value, hasmap, ans + s[i]);
		hasmap = temp;
	}

	static void getrec(int value, String ans, String ds) {
		if (value == 0) {
			System.out.println(ans);
			return;
		}
		char c = ds.charAt(0);
		getrec(value - 1, ans + c, ds.substring(1));
		if (Integer.parseInt(ans.substring(ans.length() - 1)) >= 0
				&& Integer.parseInt(ans.substring(ans.length() - 1)) >= 9) {
			getrec(value, ans.substring(0, ans.length() - 1) + Integer.parseInt(ans.substring(ans.length() - 1)) + 1,
					ds);
		} else
			getrec(value - 1, ans + 1, ds.substring(1));
	}

	static void tiktok(int m[][], int i, int j) {
		int dx = 0;
		int dy = 0;
		if (j == m.length) {
			dx = i + 1;
			dy = 0;
		} else {
			dx = i;
			dy = j + 1;
		}
		if (m[i][j] != 0) {
			tiktok(m, dx, dy);
		} else {
			for (int k = 1; k <= 9; k++) {
				if (safevisittik(m, i, j, k)) {
					m[i][j] = k;
					tiktok(m, dx, dy);
					m[i][j] = 0;
				}

			}
		}
	}

	private static boolean safevisittik(int[][] m, int i, int j, int k) {
		// TODO Auto-generated method stub
		return false;
	}

}
