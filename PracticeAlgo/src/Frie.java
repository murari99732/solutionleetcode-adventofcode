import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FrieData {
	FrieData[] trie = new FrieData[26];
	boolean isEnd = false;
}

public class Frie {
	FrieData fr = new FrieData();

	void add(String value) {
		FrieData temp = fr;
		for (int i = 0; i < value.length(); i++) {
			int val = value.charAt(i) - 65;
			if (temp.trie[val] == null) {
				temp.trie[val] = new FrieData();
			}
			temp = temp.trie[val];
		}
		temp.isEnd = true;
	}

	boolean find(String value) {
		FrieData temp = fr;
		for (int i = 0; i < value.length(); i++) {
			int val = value.charAt(i) - 65;
			if (temp.trie[val] == null) {
				return false;
			}
		}
		return temp.isEnd;
	}

	boolean searchstart(String value) {
		FrieData temp = fr;
		for (int i = 0; i < value.length(); i++) {
			int val = value.charAt(i) - 65;
			if (temp.trie[val] == null) {
				return false;
			}
		}
		return true;
	}

	void searchoneword(char c[][], String value) {
		boolean b[][] = new boolean[c.length][c.length];
		for (int i = 0; i < c.length; i++) {
//			for (int j = 0; j < c.length; j++) {
//				if (c[i][j] == value.charAt(0) && DFS(b, i, j, c, value, "", 0, fr))
//					
//				{
//					System.out.println(true);
//				}
//			}
		}

	}

	private boolean DFS(boolean[][] b, int i, int j, char[][] c, String value, String string, int d, Frie fr) {

		if (i > c.length && i < 0 && j > c.length && j < 0 && c[i][j] != string.charAt(d)) {
			return false;
		}

		if (value.equals(string) || value.length() == string.length()) {
			return true;
		}
		b[i][j] = true;
		boolean bc = DFS(b, i + 1, j, c, value, string + c[i][j], d + 1, fr);
		b[i][j] = false;
		return bc;
	}

	void findallword(List<String> word, char c[][]) {
		HashSet<String> hashset = new HashSet<>();
		boolean[][] b = new boolean[c.length][c.length];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (fr.trie[c[i][j] - 65] != null) {
				//	DFSUtil(fr, c, i, j, hashset, b);
				}
			}
		}

	}

	private boolean DFSUtil(FrieData fr2, char[][] c, int i, int j, HashSet<String> hashset, boolean[][] b, String w) {
		if (i < 0 || i > b.length || j < 0 || j > b.length) {
			return false;
		}

		fr = fr.trie[c[i][j] - 65];
		if (fr.isEnd == true) {
			hashset.add(w);
			return true;
		}
		b[i][j] = true;
		boolean cd = DFSUtil(fr2, c, i + 1, j, hashset, b, w + c[i][j]);
		b[i][j] = false;
		return cd;

	}

	static void bipartitegraph(int m[][])
	{
		int flag[]= new int[m.length];
		for(int i=0;i<m.length;i++)
		{
			if(flag[i]==1 || flag[i]==-1)
			{
				continue;
			}
			Queue<Integer> q= new LinkedList<Integer>();
			q.add(i);
			while(!q.isEmpty())
			{
				int v=q.poll();
				for(int j=0;j<m.length;j++)
				{
					if(m[i][j]==1 ||flag[j]==0)
					{
						flag[j]=-flag[v];
						q.add(j);
					}
					if(flag[v]==flag[j])
					{
						System.out.println("true");
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
