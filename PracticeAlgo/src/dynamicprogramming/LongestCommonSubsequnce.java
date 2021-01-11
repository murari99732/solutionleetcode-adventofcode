package dynamicprogramming;

public class LongestCommonSubsequnce {

	static int subs(String a[],int ab, String b[], int bc)
	{
		if(a.length==0 || b.length==0)
		{
			return 0;
		}
		if(a[ab-1].equals(b[bc-1]))
		{
			return 1+ subs(a, ab-1, b, bc-1);
		}
		return Math.max(subs(a, ab-1, b, bc), subs(a, ab, b, bc-1));
		
	}
	
	public static void main(String[] args) {
		String a[]= {"a","b","b","b","c"};
		String b[]= {"a","d","b","c","c"};
		System.out.println(subs(a,a.length,b,b.length));
	}
}
