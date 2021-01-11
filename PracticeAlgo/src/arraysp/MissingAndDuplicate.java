package arraysp;

import java.util.ArrayList;

public class MissingAndDuplicate {

	public static void main(String[] args) {
		int arr[] = {17,14,15,13,16};
		missdup(arr);
	}

	private static void missdup(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		
		for(int i=0;i<=arr.length;i++)
		{
			if( arr[i]!=i+1)
			{
				int d=arr[i]-1;
				int temp=arr[i];
				arr[i]=arr[d];
				arr[d]=temp;
			}
			
		}
		ArrayList<Integer> ar= new ArrayList<Integer>();
	for(int i=0;i<arr.length;i++)
	{
		System.out.println(arr[i]);
		
	}
	}
}
