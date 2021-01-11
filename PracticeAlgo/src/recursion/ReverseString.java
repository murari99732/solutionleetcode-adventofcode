package recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseString {

	static int fibonacci(int n)
	{
		if(n==0||n==1)
		{
			return 1;
		}
		int arr[]= new int[n+1];
		if(arr[n]==0)
		arr[n]= fibonacci(n-1)+fibonacci(n-2);
		
		return arr[n];
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}
}
