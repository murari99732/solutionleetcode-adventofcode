package queueproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCM {
	static void contigiuose(int arr[], int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = 0;
		while (start < arr.length) {
			sum = sum + arr[start];

			if (start - end + 1 > k) {
				sum = sum - arr[end];
				end++;
			}
			
			while (sum < 0) {
				sum = 0;
				end++;
			}
			max = Math.max(sum, max);

			start++;
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, -3, 3, -4 };
		contigiuose(arr, 4);
	}

}
