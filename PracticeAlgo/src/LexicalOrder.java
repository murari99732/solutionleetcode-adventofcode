import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class GraphNode {
	int val;
	List<GraphNode> graph;

	public GraphNode(int val) {
		this.val = val;
		graph = new ArrayList<GraphNode>();
	}
}

public class LexicalOrder {

	
	static void hindex(int prof1[], int prof2[])
	{
		int update=0;
		for(int i=0;i<prof1.length;i++)
		{
			if(prof1[i]>=prof1.length-i)
			{
				update=prof1[i];
			}
		}
		
		int update1=0;
		for(int i=0;i<prof2.length;i++)
		{
			if(prof2[i]>=prof2.length-i)
			{
				update1=prof2[i];
			}
		}
		System.out.println(update>update1?update:update1+" djd");
		
		
		
	}
	
	static void getminimuenergy(int board[][], int i, int j) {
	
	

	}

	static int max = 0;

	private static int DFSUtil(int[][] board, int i, int j, int k, boolean[][] b) {

		if (i > board.length || i < 0 || j > board.length || j < 0 || b[i][j] == false) {
			return 0;
		}
		b[i][j] = true;
		if (i == board.length && j == board.length) {
			max = Math.max(k + board[i][j], max);
		}
		DFSUtil(board, i + 1, j, k + board[i][j], b);
		DFSUtil(board, i, j + 1, k + board[i][j], b);

		b[i][j] = false;
		return max;

	}

	static void clone(GraphNode node) {
		Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		map.put(node, new GraphNode(node.val));
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(node);
		while (!q.isEmpty()) {
			GraphNode curr = q.poll();

			Iterator<GraphNode> it = curr.graph.iterator();
			while (it.hasNext()) {
				GraphNode gt = it.next();
				if (!map.containsKey(gt)) {
					GraphNode gy = map.get(gt);
					map.put(gy, new GraphNode(gy.val));
					q.add(gt);
				}
				map.get(curr).graph.add(map.get(gt));
			}
		}

	}

}