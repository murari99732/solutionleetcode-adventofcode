package tree;

import java.util.PriorityQueue;
import java.util.Stack;

public class Recursive {
	
	static int max;
	static int[] ascendingorder(int arr[], int start, int end)
	{
		if(start>end)
		{
			return arr ;
		}
		int min=arr[start]>arr[end]?arr[start]:arr[end];
		
	
		arr=ascendingorder(arr, start+1, end-1);
		return arr;
	}
	
	static void delete(Stack<Integer> st,int size)
	{
		int mid=st.size();
		deletemid(st,mid,size);
	}
	private static void deletemid(Stack<Integer> st, int mid, int size) {
		if(size==0)
		{
			return;
		}
		
			int f=st.pop();
		
		deletemid(st, mid, size-1);
		if(mid!=size)
		{
			st.push(f);
		}
		
	}
	
	static void permutate(String ar[],  int length,int a)
	{
		if(a==0)
		{
			return;
		}
		
		if(ar[a].matches("//d+"))
		{
			
		}
	}

	public static void main(String[] args) {
		int arr[]= {2,31,4,1,5,7};
		ascendingorder(arr, 0, arr.length-1);
		for(int j:arr)
		{
			System.out.println(j);
		}
	}

}
