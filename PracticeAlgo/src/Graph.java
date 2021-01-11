import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Vertices {
	int val;
	int distance;

	Vertices(int val, int distance) {
		this.val = val;
		this.distance = distance;

	}
}

class Graph {

	LinkedList<Vertices>[] list;
	boolean visited[];
	int distance[];

	public Graph() {
		list = new LinkedList[10];
		visited = new boolean[10];
		distance = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Vertices>();
		}
	}

	void edges(int source, int node, int distance) {
		list[source].add(new Vertices(node, distance));
	}

	void dijsktra() {
		PriorityQueue<Vertices> pr = new PriorityQueue<Vertices>((a, b) -> {
			int d = a.distance;
			int e = b.distance;
			if (d != e) {
				return e - d;
			}
			return 0;
		});
		distance[0]=0;
		pr.add(new Vertices(0, 0));
		while(pr.isEmpty())
		{
			Vertices value=pr.poll();
			int gh=value.distance;
			visited[value.val]=true;
			Iterator<Vertices> it= list[value.distance].iterator();
			while(it.hasNext())
			{
				int v=it.next().distance;
				if(visited[v]==false)
				{
					
				}
			}
		}
	}

}