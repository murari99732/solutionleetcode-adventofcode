package rough;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution1 {

	static void island(int a[][]) {
		boolean visited[][] = new boolean[a.length - 1][a.length - 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				visited[i][j] = false;
			}
		}
		int d = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (!visited[i][j] && a[i][j] == 1) {
					if (dfs(a, visited, i, j) == true) {
						d++;
					}

				}

			}
		}
	}

	private static void rot(int a[][]) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 2) {
					map.put(i, j);
					continue;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 2)
					rot(map, a, i, j);
			}
		}
		System.out.println(map);
	}

	private static void rot(Map<Integer, Integer> map, int[][] a, int i, int j) {

		for (Entry<Integer, Integer> m : map.entrySet()) {
			if (safe(a, m.getKey() - 1, m.getValue())) {
				Integer mp = m.getKey() - 1;
				Integer mt = m.getValue();
				map.put(mp, mt);
				a[m.getKey()][m.getValue()] = 2;
			}
		}

	}

	private static boolean safe(int[][] a, Integer x, Integer y) {
		return x >= 0 && x < a.length && y >= 0 && y < a.length && a[x][y] == 1;
	}

	private static boolean dfs(int[][] a, boolean[][] visited, int i, int j) {
		if (visited[i][j] == false && a[i][j + 1] == 1)

			return true;
		return false;
	}

	static void getmin(int a[][], int n) {
		int start = 0;
		int end = a.length - 1;
		int value = 0;

		while (end >= 0) {

			if (n == a[start][end]) {
				value = a.length * end + start - 0;
				value = (a.length - 1 - start) + ((a.length - 1) * end);
				System.out.println(value);
				return;
			}
			if (a[start][end] < n) {
				start++;
			} else if (a[start][end] > n) {
				end--;
			}

		}

	}

	static void find(int a[][], int n) {
		int i = 0;
		int start = a.length;
		int d = i;
		while (i < start) {
			int mid = (i + start) / 2;
			if (n == a[0][mid]) {
				d = i;
				return;

			} else if (n > a[0][mid]) {
				d = mid;
				i++;
			} else {
				d = mid;
				start--;
			}
		}

		int end = d;
		int j = 0;
		int k = a.length;
		while (j < a.length) {
			int mid = (j + k) / 2;
			if (n == a[mid][end]) {
				System.out.println("true" + mid + " " + end);
				return;

			} else if (n > a[mid][end]) {
				j++;
			} else {
				k--;
			}
		}

	}

	static void matrix(int m[][], int n) {
		int i = 0;
		int end = m.length - 1;
		int start = 0;
		while (end >= 0) {
			if (m[i][end] > n) {
				end--;
				continue;
			} else if (m[i][end] < n) {
				i++;
				continue;
			}
			if (m[i][end] == n) {
				System.out.println(i + " " + end);
				return;
			}
		}
		System.out.println(false);
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 0, 0, 2 }, { 0, 0, 0, 2 }, { 0, 2, 0, 2 }, { 2, 0, 0, 2 } };

		rot(mat);

	}

}
