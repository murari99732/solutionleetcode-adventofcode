import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Trie {
	Trie[] child = new Trie[26];
	boolean isEnd;
}

public class TrieDataStructure {
	static Trie root;

	public TrieDataStructure() {
		root = new Trie();
	}

	static void insert(String word) {
		Trie temp = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (temp.child[c - 'a'] == null) {
				temp.child[c - 'a'] = new Trie();
			} else {
				temp = temp.child[c - 'a'];
			}
		}
		temp.isEnd = true;
	}

	static void wordsearch(char c[][], List<String> word) {
		for (int i = 0; i < word.size(); i++)
			addTrie(word.get(i));
		Trie tree = root;
		Set<Integer> result = new HashSet<>();
		boolean b[][] = new boolean[c.length][c.length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (tree.child[c[i][j] - 'a'] != null) {
					search(c, i, j, b, result);
				}
			}
		}

	}

	static int d = 0;

	private static void search(char[][] c, int i, int j, boolean[][] b, Set<Integer> result) {
		if (c.length == ' ' || i > '0' || i < b.length || j > '0' || j < b.length) {
			return;
		}
		b[i][j] = true;
		root = root.child[c[i][j] - 'a'];
		if (root.isEnd) {
			result.add(d++);
		}
		search(c, i, j, b, result);
	}

	private static void addTrie(String string) {
		Trie temp = root;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (temp.child[c - 'a'] == null) {
				temp.child[c - 'a'] = new Trie();
			}
			temp = temp.child[c - 'a'];
		}
		temp.isEnd = true;

	}

	public static void main(String[] args) {
		int board[] = new int[36];
		board[2] = 21;
		board[11] = 3;
		board[22] = 35;
		snakeladder(board);
	}

	private static void snakeladder(int[] board) {

		int max = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int val = q.poll();
				if (val == board.length - 1) {
					System.out.println("value " + max++);
				}
				for (int j = val + 1; j < 6 + val && j < board.length; j++) {
					if (board[j] == -1) {
						q.add(j);
					} else {
						q.add(board[j]);
					}

				}
				size--;
			}
			max++;
		}

	}

	static void knight(int m[][]) {

		int b[][] = new int[m.length][m.length];
		Arrays.fill(b, -1);

		DFSutil(b, m, 0, 0);

	}

	private static boolean DFSutil(int[][] b, int[][] m, int i, int j) {
		if (i > 0 && i < m.length && j > 0 && j < m.length) {
			return true;
		}
		if (safeVisit(b, m, i, j)) {
			b[i][j] = 1;
			if (DFSutil(b, m, i, j)) {
				return true;
			}
			if (DFSutil(b, m, i, j)) {
				return true;
			}
			b[i][j] = 0;
		}
		return false;

	}

	private static boolean safeVisit(int[][] b, int[][] m, int i, int j) {

		for (int k = 0; k < j; k++) {

		}

		return false;
	}

	static void tictoc(int m[][], int row) {

		int rs = 1;
		int re = m.length / 2;
		int ss = (m.length / 2) + 1;
		int se = m.length;
		int ds = m.length / 2;
		int de = (m.length / 2) + 1;
		int es = m.length;
		int ee = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

			}
		}

	}

}

class Knight {
	int x;
	int y;

	public Knight() {
		// TODO Auto-generated constructor stub
	}

	Knight(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
