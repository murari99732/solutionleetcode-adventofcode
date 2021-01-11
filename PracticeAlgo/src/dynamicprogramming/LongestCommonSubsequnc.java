package dynamicprogramming;

public class LongestCommonSubsequnc {
	int arr[][]= new int[11][11];
	static int subsqeunce(String s1, String s2, int n, int m, int [][]m1)
	{
		if(n==0|| m==0)
		{
			return 0;
		}
		if(m1[n][m]==0)
			if(s1.charAt(n-1)==s2.charAt(m-1))
		{
			m1[n][m]=1+subsqeunce(s1, s2, n-1, m-2, m1);
		}
		else
		m1[n][m]=Math.max(subsqeunce(s1, s2, n, m-1, m1), subsqeunce(s1, s2, n-1, m, m1));
		return m1[n][m];
	}
	static int subsqeunce1(String s1, String s2, int n, int m, int [][]m1)
	{
		if(n==0||m==0)
		{
			return 0;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					 m1[i][j] = 1 + m1[i - 1][j - 1];
				}else
				{
					m1[i][j]=Math.max(m1[i-1][j], m1[i][j-1]);
				}
			}
		}
		return m1[n][m];
	}
	
	public static void main(String[] args) {
		
	}

}
