package rough;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NondDivible {
	public static int nonDivisibleSubset(int k, List<Integer> s) {

		
		HashSet<Integer> hs= new HashSet<Integer>();
		for (int i = 0; i < s.size(); i++) {
			int sum = 0;
			int end = s.size();
			int c = i;
			int de=i+1;
			while (de < end ) {
				sum = s.get(c) + s.get(de);
				if (sum % 3 != 0) {
					hs.add(s.get(c));
					hs.add(s.get(de));
				}
				de++;
			}
		}
		
		
		return hs.size();
	}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(7);
		l.add(2);
		l.add(4);
		nonDivisibleSubset(3, l);
	}
}
