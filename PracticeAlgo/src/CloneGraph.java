import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class CloneGraph {
	static LinkedList<Integer> list[];

	public CloneGraph() {
		list = new LinkedList[5];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		list[v].add(w);
		list[w].add(v);
	}

	static boolean cycle(int source) {
		boolean b[] = new boolean[5];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		while (!q.isEmpty()) {
			int parent = q.poll();
			Iterator<Integer> it = list[parent].iterator();
			while (it.hasNext()) {
				int child = it.next();
				if (b[child] == false) {
					q.add(child);
					b[child] = false;
				} else if (child != parent) {
					return true;
				}
			}
		}
		return false;
	}

	static void detectcycle(int source) {
		boolean b[] = new boolean[5];
		boolean c[] = new boolean[5];
		for (int i = 0; i < 5; i++) {
			if (b[i] == false)
				DFSutil(b, c, i);
		}
	}

	private static boolean DFSutil(boolean[] b, boolean c[], int i) {
		if (b[i] == true) {
			return true;
		}
		if (c[i] == true) {
			return false;
		}
		b[i] = true;
		Iterator<Integer> it = list[i].iterator();
		while (it.hasNext()) {
			int d = it.next();
			if (b[d] == false) {
				DFSutil(b, c, d);
			}
		}
		c[i] = false;
		return false;

	}

	static void friendcircle(char m[][], String s, int j) {
		Queue<Character> q = new LinkedList<Character>();
		boolean b[] = new boolean[5];
		q.add(s.charAt(0));

		while (!q.isEmpty()) {
			int i = 0;
			char d = q.poll();
			for (int k = 0; k < 5; k++) {
				if (b[k] == false && m[d][i] == s.charAt(i)) {
					q.add(m[d][i]);
					b[k] = true;
					i++;
				}
			}

		}

	}
	static void gp(char m[][], String word)
	{	boolean b[][] = new boolean[5][5];
		for(int i=0;i<m.length;i++)
		{
			for (int j = 0; j < m.length; j++) {
				DCS(m,i,j,b,word,0);
			}
		}
		
	}

	

	private static boolean DCS(char[][] m, int i, int j, boolean[][] b, String word, int count) {
		if(word.length()==count)
		{
			return true;
		}
		if(m.length==0 ||i<0 ||i>m.length)
		{
			return false;
		}
		if(m[i][j]!=word.charAt(count))
		{
			return false;
		}
		char temp=m[i][j];
		 m[i][j]='*';
		
		DCS(m, i-1, j, b, word, count+1);
		DCS(m, i-1, j, b, word, count+1);
		m[i][j]=temp;
		return false;
	}

	public static void main(String[] args) {

	}
}