package dynamicprogramming;

public class LongestCommonSubstring {

	static int arr[][]= new int[4][5];
	public static int lcsubstring(String s1, String s2, int n, int m, int countOfLCS) {
	    if(n == 0 || m == 0) {
	      return countOfLCS;
	    }
	    
	    if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
	      countOfLCS = lcsubstring(s1, s2, n - 1, m - 1, countOfLCS + 1);
	    } 
	    
	    int count1 = lcsubstring(s1, s2, n - 1, m, 0);
	    int count2 = lcsubstring(s1, s2, n, m - 1, 0);
	    
	    return Math.max(countOfLCS, Math.max(count1, count2));
	  }
	 
	public static int lcsub(String s1, String s2, int n, int m, int m1[][])
	{
		if(n == 0 || m == 0) {
		      return m1[n][m];
		    }
return 0;
	}
	
	public static void main(String[] args) {
		String s1 = "abd";
	    String s2 = "abca";
	    
	    System.out.println(lcsubstring(s1, s2, s1.length(), s2.length(),0));

	}
}
