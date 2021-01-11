
public class LeetCode {

	static int st = Integer.MAX_VALUE;
	static int pt = Integer.MAX_VALUE;
	static int ct = Integer.MAX_VALUE;

	static int minimumsteps(int value, int a[]) {
		if (value == 1) {
			return 0;
		}
		if (a[value] == 0) {
			if (value / 3 >= 1 && value % 3 == 0) {
				st = 1 + minimumsteps(value / 3, a);
			} else if (value / 2 >= 1 && value % 2 == 0) {
				pt = 1 + minimumsteps(value / 2, a);
			} else if (value - 1 >= 1) {
				ct = 1 + minimumsteps(value - 1, a);
			}
			a[value] = Math.min(st, Math.min(pt, ct));
		}

		return a[value];
	}

	static int min = Integer.MAX_VALUE;

	static int minlength(int m[][], int i, int j, int c[][]) {
		if (i == m.length - 1 && j == m.length - 1) {
			return m[i][j];
		}
		if (c[i][j] == 0) {
			if ((i >= 0 && i < m.length - 1) && (j >= 0 && j < m.length - 1)) {
				min = m[i][j] + Math.min(minlength(m, i + 1, j, c), minlength(m, i, j + 1, c));

			} else if (i >= 0 && i < m.length - 1) {
				min = m[i][j] + minlength(m, i + 1, j, c);
			} else if (j >= 0 && j < m.length - 1) {
				min = m[i][j] + minlength(m, i, j + 1, c);
			}
			c[i][j]=min;
		}
		return c[i][j];
	}

	public static void main(String[] args) {
		int a[] = new int[11];
		// System.out.println(minimumsteps(10, a));

		int m[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int c[][]= new int[m.length][m.length];
		System.out.println(minlength(m, 0, 0,c));

	}
}
