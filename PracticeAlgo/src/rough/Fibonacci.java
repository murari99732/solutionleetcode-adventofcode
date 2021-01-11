package rough;

public class Fibonacci {

	static int arr1[] = new int[11];

static int pal(int ar[], int l, int r)
{
	if(l==r)
	{
		return 1;
	}
	if(l>=r)
	{
		return 0;
	}
	if(ar[l]==ar[r])
	{
		int at=l-r-1;
		return 1+pal(ar, l-1, r-1);
	}
	return Math.max(pal(ar, l, r-1), pal(ar, l-1, r));
}
	
	
	
	public static void main(String[] args) {
	    int ar[]= {2,3,-1,-4,6,9};
	    int br[]= {2,3,5,9};
	    
	 //   System.out.println(commonsequnce(ar, br, ar.length, br.length));
	    

	  }

}
