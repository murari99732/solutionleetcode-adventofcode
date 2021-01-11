//https://www.youtube.com/watch?v=miCYGGrTwFU

//https://www.youtube.com/watch?v=y71m0wsbjWo
public class MColoringGraph {

	static int graph[][] = new int[5][5];
	static int[] distance = new int[5];
	static void graph(int k) {
		
		if(k==5)
		{
			return ;
		}
		for (int c = 1; c < 3; c++) {

			if (safeVisit(c, k)) {
				distance[k] = c;
				if (k + 1 < 4) {
					graph(k + 1);
				}
					else {
						distance[k] = 0;
					
					}
				}
			} 
		}

	

	private static boolean safeVisit(int c, int k) {
		for (int i = 0; i < 10; i++) {
			if (graph[k][i] == 0 && c == distance[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
