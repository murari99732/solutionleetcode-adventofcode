package tree;

public class RatBactracking {

	static void backtrack(int m[][]) {

		boolean b[][] = new boolean[m.length][m.length];

		if (ratMoves(b, m, 0, 0)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		for(int i=0;i<m.length;i++ )
		{
			for(int j=0;j<m.length;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}

	}

	static boolean g = false;

	private static boolean ratMoves(boolean[][] b, int[][] m, int i, int j) {
		if (i == m.length - 1 && j == m.length - 1) {
			return true;
		}
		if (i == m.length - 1 || j == m.length - 1) {
			return false;
		}

		if (Safevisit(m, i, j)) {
			b[i][j] = true;

			if(ratMoves(b, m, i + 1, j))
			{
				return true;
			}
			if(ratMoves(b, m, i, j + 1))
			{
				return false;
			}
			b[i][j] = false;
		}
		return false;
	}

	private static boolean Safevisit(int[][] m, int i, int j) {

		if (i > 0 && i < m.length && j > 0 && j < m.length) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 1 } };
		backtrack(maze);

	}

}
