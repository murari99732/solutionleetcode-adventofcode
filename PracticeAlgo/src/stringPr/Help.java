package stringPr;

public class Help {

	public static int moves(int a[])
	{
		int end=0;
		int distance=0;
		int min=Integer.MAX_VALUE;
		while(end<a.length-1)
		{
			
				end=end+a[end];
			
				distance++;
				min= Math.min(distance, min);
		
			
		}
		System.out.println(distance);
		return distance;
	}
	public static void main(String[] args) {
	 int a[]= {2,2,3};
	System.out.println( moves(a));
	}
}
