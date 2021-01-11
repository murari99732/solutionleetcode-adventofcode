import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://www.youtube.com/watch?v=19tY6Y90TP0
public class SnakeLadder {
	static class Entry {
		int vertex;
		int distance;

		public Entry() {
			// TODO Auto-generated constructor stub
		}

		public Entry(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {

		int board[] = new int[36];
		Arrays.fill(board, -1);
		board[2] = 21;
		board[32] = 2;
		board[7] = 35;
		snakeLadder(board, 36);
	}

	private static void snakeLadder(int[] board, int i) {

		boolean[] b = new boolean[i];
		Queue<Entry> queue = new LinkedList<Entry>();
		queue.add(new Entry(0, 0));
		int distance = 0;
		Entry en = new Entry();
		while (!queue.isEmpty()) {
			en = queue.poll();
			queue.peek();
			int dis = en.distance;
			b[en.vertex] = true;
			if (en.vertex >= 36) {
				System.out.println(en.distance);
				return;
			}
			for (int j = en.vertex + 1; j < en.vertex + 6 && j < 36; j++) {
				if (b[j] == false) {
					Entry tr = new Entry();
					tr.distance = en.distance + 1;
					if (board[j] == -1) {
						queue.add(new Entry(board[j], tr.distance));
					} else {
						queue.add(new Entry(j, tr.distance));
					}
				}
			}
		}

	}
}