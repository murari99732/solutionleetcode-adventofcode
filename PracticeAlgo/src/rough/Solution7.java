package rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution7 {

	static void kadanes(int arr[]) {

		int start = 0;
		int end = arr.length - 1;
		int sums = 0;
		int sume = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			int i=0;
			while(i<mid)
			{
				sums=sums+arr[i];
				i++;
			}
			i=mid+1;
			while( i<=end)
			{
				sume=sume+arr[i];
				i++;
			}
			if(sums==sume)
			{
				System.out.println("true");
			}
			start++;
			end--;

			
		}

	}

	public static void main(String[] args) {
		int arr[] = { 14, 25, 3, 5, 6, 2 };
		int arr1[] = { 1,6,7,8,7};

		kadanes(arr1);
	}
}
