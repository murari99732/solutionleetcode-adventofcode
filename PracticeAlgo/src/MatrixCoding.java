
public class MatrixCoding {

	static void wavetravel(int m[][], int cend, int rend) {
		int cstart = 0;
		int rstart = 0;

		while (cstart < cend && rstart < rend) {
			for (int i = 0; i < 3; i++) {
				System.out.print(m[i][cstart] + " ");
			}
			cstart++;
			for (int i = 2; i >= 0; i--) {
				System.out.print(m[i][cstart] + " ");
			}
			cstart++;
		}
	}

	static void exit(int m[][], int i, int j, String ans) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			System.out.println(ans);
			return;
		}
		if (safevisit(m, i + 1, j) && m[i + 1][j] == 0) {
			exit(m, i + 1, j, ans + "R" + " ");
		} else {
			if (safevisit(m, i, j + 1))
				exit(m, i, j + 1, ans + "L" + " ");
		}

	}

	private static boolean safevisit(int[][] m, int i, int j) {
		if (i < 0 || i > m.length || j < 0 || j > m.length) {
			return false;
		}
		return true;
	}

	static void rotate(int m[][]) {
		int g[][] = new int[m.length][m.length];
		for (int i = 0; i < 3; i++) {
			for (int j = 2; j >= 0; j--) {
				System.out.println(m[j][j]);
			}
		}
	}

	static void diagonal(int m[][]) {
		for (int k = 0; k < m.length; k++) {
			System.out.println();
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if (Math.abs(i - j) == k) {
						System.out.print(m[i][j] + " ");
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		diagonal(a);

	}

}
