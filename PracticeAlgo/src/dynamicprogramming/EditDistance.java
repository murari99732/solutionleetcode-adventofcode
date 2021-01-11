package dynamicprogramming;

public class EditDistance {

	int arr[][]= new int [5][5];
	static int distance(String b, String a, int n, int m)
	{
		if(n==0|| m==0)
		{
			return 0;
		}
		
		if(n==0)
		{
			return m;
		}
		if(m==0)
		{
			return n;
		}
		
		if(b.charAt(n-1)==a.charAt(m-1))
		{
			return distance(b, a, n-1, m-1);
		}
		return Math.min(distance(b, a, n, m-1),Math.min( distance(b, a, n-1, m), distance(b, a, n-1, m)));
			
		
		
	}
	public static void main(String[] args) {
		
	}
}
