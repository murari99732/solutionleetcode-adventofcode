package rough;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Help {

	static void see(int d)
	{
		ArrayList<ArrayList<Integer>> ar= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> b= new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			b.add(0,2);
			ar.add(new ArrayList<Integer>(b));
		}
		int de=0;
	}
	public static void main(String[] args) {
		see(21);
	}
}
