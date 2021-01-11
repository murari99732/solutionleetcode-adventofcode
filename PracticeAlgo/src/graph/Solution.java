package graph;

public class Solution {
	int N = 4;

	public void queen() {
		int q[][] = new int[4][4];
		queenutility(q, 0, 0);
	}

	private boolean queenutility(int[][] q, int i, int j) {

		if (j == 4) {
			return true;
		}
		if (safevisit(q, i, j)) {
			q[i][j] = 1;
			if (queenutility(q, i, j + 1)) {
				return true;
			}
			q[i][j]=0;
		}
		return false;

	}

	private boolean safevisit(int[][] sol, int row, int col) {

		int i, j;

		for (i = 0; i < col; i++) {
			if (sol[row][i] == 1) {
				return false;
			}
		}

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (sol[i][j] == 1) {
				return false;
			}
		}

		for (i = row, j = col; i < N && j >= 0; i++, j--) {
			if (sol[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

}