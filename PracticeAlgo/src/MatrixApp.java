import java.util.LinkedList;
import java.util.Queue;



public class MatrixApp {

	int ROW = 4;
	int COL = 5;

	public int timeToRotOranges(int[][] mat) {
		Queue<Matrix> q = new LinkedList<>();

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (mat[i][j] == 2) {
					q.add(new Matrix(i, j));
				}
			}
		}

		q.add(new Matrix(-1, -1));

		int count = 0;
		boolean flag = false;

		while (!q.isEmpty()) {

			while (!ifPeekDelimeter(q.peek())) {
				Matrix element = q.remove();

				if (isFreshOrange(mat, element.x - 1, element.y)) {
					mat[element.x - 1][element.y] = 2;
					q.add(new Matrix(element.x - 1, element.y));

					if (!flag) {
						flag = true;
						count++;
					}
				}

				if (isFreshOrange(mat, element.x, element.y + 1)) {
					mat[element.x][element.y + 1] = 2;
					q.add(new Matrix(element.x, element.y + 1));

					if (!flag) {
						flag = true;
						count++;
					}
				}

				if (isFreshOrange(mat, element.x + 1, element.y)) {
					mat[element.x + 1][element.y] = 2;
					q.add(new Matrix(element.x + 1, element.y));
					if (!flag) {
						flag = true;
						count++;
					}
				}

				if (isFreshOrange(mat, element.x, element.y - 1)) {
					mat[element.x][element.y - 1] = 2;
					q.add(new Matrix(element.x, element.y - 1));
					if (!flag) {
						flag = true;
						count++;
					}
				}
			}

			q.remove();
			flag = false;

			if (!q.isEmpty()) {
				q.add(new Matrix(-1, -1));
			}
		}

		return ifAnyFreshOrangesLeft(mat) ? -1 : count;

	}

	public boolean ifPeekDelimeter(Matrix c) {
		return c.x == -1 && c.y == -1;
	}

	public boolean isFreshOrange(int[][] mat, int x, int y) {
		return x >= 0 && x < ROW && y >= 0 && y < COL && mat[x][y] == 1;
	}

	public boolean ifAnyFreshOrangesLeft(int[][] mat) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (mat[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

		MatrixApp a = new MatrixApp();

		int[][] mat = { { 0, 2, 0, 0, 2 }, { 0, 1, 0, 1, 1 }, { 0, 1, 0, 1, 2 }, { 2, 1, 0, 2, 0 } };

		System.out.println(a.timeToRotOranges(mat));
	}
}
