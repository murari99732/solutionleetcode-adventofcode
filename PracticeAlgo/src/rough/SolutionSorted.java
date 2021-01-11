package rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionSorted {
	public static int sortedSum(List<Integer> a) {

		int start = 0;
		int add = 0;
		while (start < a.size()) {
			int mul = 0;
			int d = 1;
			for (int j = start; j >= 0; j--) {
				mul = mul + d * a.get(j);
				d++;
			}
			add = add + mul;
			start++;
		}
		return add;

	}

	public static int sortedSum1(List<Integer> a) {

		int add = 0;

		ArrayList<Integer> ar = new ArrayList<Integer>();
		int start = 0;
		while (start < a.size()) {
			ar.add(a.get(start));
			Collections.sort(ar);
			int st = 0;
			int mul = 0;
			int e = 1;
			while (st < ar.size()) {
				mul = mul + e * ar.get(st);
				e++;
				st++;
			}
			add = add + mul;
			start++;
		}

		int f = 1;
		for (int i = 1; i <= 9; i++)
			f = (f * i) % add;
		return f;

	}

    public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        
    int answer = 0; 
           
            // Sort the array 
            Collections.sort(skillLevel); 
           
            // Stores the minimum difference 
            // between adjacent pairs 
            
            for (int i = 0; i < skillLevel.size(); i++) 
           {
                
           
            for (int j = i+1; i < skillLevel.size()-1 ; j++)  
            { 
                if (Math.abs(skillLevel.get(j)  - skillLevel.get(i)) == minDiff && i<j) 
           
                  
                    answer++; 
            } 
           }
            // Return the final count 
            return answer; 
    }


	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(5);
		list.add(8);
		list.add(4);

		System.out.println(maxPairs(list,1));
	}
}
