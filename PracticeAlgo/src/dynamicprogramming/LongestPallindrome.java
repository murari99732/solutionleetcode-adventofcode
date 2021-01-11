package dynamicprogramming;

//https://www.youtube.com/watch?v=_AcULHRds3I&list=PLt4nG7RVVk1jcoLFb1gn0EylZ381IgrNq&index=9
public class LongestPallindrome {
	
	static int subpalindrome(String s, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		int b[][] = new int[end+1][end+1];
		for (int i = 0; i < s.length(); i++) {
			b[i][i] = 1;
		}
		int d=0;
		int max = 0;
		for (int i = end; i >= 0; i--) {
			for (int j = i + 1; j < end; j++) {
				int f=0;
				if (s.charAt(i) == s.charAt(j)) {
					b[i][j]=2+b[i+1][j-1];
					max=Math.max(max, b[i][j]);
				}
			}
		}
		return max;
	}
	static int palindrome(String s, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		boolean b[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			b[i][i] = true;
		}
		int d = 0;
		int max = 0;
		for (int i = s.length(); i >= 0; i--) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (b[i + 1][j - 1]) {
						b[i][j] = true;
						d++;
						max = Math.max(max, j - i + 1);
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String str = "bdbdb";

		System.out.println(palindrome(str, 0, str.length() - 1));

		// Integer[][] arr = new Integer[str.length()][str.length()];
		// System.out.println(LongestPalindromeStringApp.lpSubStringTopDown(str, 0,
		// str.length() - 1, arr));

		// System.out.println(lpSubstringBottomUp(str, str.length()));
	}
}
