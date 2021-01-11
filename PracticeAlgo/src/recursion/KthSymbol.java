package recursion;

public class KthSymbol {

	static int kthsymbol(int n, int k)
	{
		if(n==1||k==1)
		{
			return 0;
		}
		int mid=(int) (Math.pow(2, n-1)/2);
		if(mid<=k)
		{
			return kthsymbol(n-1, k);
		}
		else
		{
			return (kthsymbol(n-1, k-mid)==0?1:0);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(kthsymbol(4, 5));
	}
}
