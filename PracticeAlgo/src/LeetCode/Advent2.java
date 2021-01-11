package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Advent2 {

	static class Pair {
		String src;
		int count;

		public Pair(String src, int count) {
			super();
			this.src = src;
			this.count = count;

		}

	}

	static class Flag {
		String val;
		boolean flag;

		public Flag(String val, boolean flag) {
			super();
			this.val = val;
			this.flag = flag;
		}
	}

	static void parse(String a[]) {
		int sum = 0;

//		
//		for (int i = 0; i < a.length; i++) {
//			String dc = a[i];
//
//			getvalue(set, "shiny gold", dc);
//
//		}
		ArrayList<Flag> bf = new ArrayList<>();
		Queue<Pair> q = new LinkedList<Advent2.Pair>();
		q.add(new Pair("shiny gold", 1));

		while (!q.isEmpty()) {

			Pair temp = q.poll();
			bf.add(new Flag(temp.src, true));
			System.out.println(temp.src + " " + temp.count);
			for (int i = 0; i < a.length; i++) {
				String dc = a[i];

				String val = getvalue(q, temp.src, dc, bf);
				for (int j = 0; j < a.length; j++) {
					if (bf.contains(new Flag(val, false))) {
						if (val != null)
							q.add(new Pair(val, temp.count + 1));

					}
				}

//			for (int i = 0; i < a.length; i++) {
//				String dc = a[i];
//
//				boolean val = parsevalue(set, dc);
//				if (val == true) {
//					sum++;
//				}
//
//			}
			}
		}

	}

	private static boolean parsevalue(ArrayList<String> set, String dc) {
		dc = dc.trim();
		for (int j = 0; j < set.size(); j++) {

			String fc = "";
			String bc = "";
			int k = 0;
			for (int i = 0; i < dc.length(); i++) {
				if (bc.contains("bags")) {
					k = i;
					break;
				}
				bc = bc + dc.charAt(i);
				fc = fc + dc.charAt(i);
			}
			if (dc.substring(k).contains(set.get(j))) {
				return true;
			}

		}
		return false;
	}

	private static String getvalue(Queue<Pair> set, String string, String dc, ArrayList<Flag> bf) {
		String fc = "";
		String bc = "";
		if (dc.contains(string)) {

			for (int i = 0; i < dc.length(); i++) {
				if (bc.contains("bags")) {
					break;
				}
				bc = bc + dc.charAt(i);
				fc = fc + dc.charAt(i);
			}

		}
		if (fc.length() != 0) {
			bf.add(new Flag(fc.substring(0, fc.length() - 5).trim(), false));
			return fc.substring(0, fc.length() - 5).trim();
		}
		return null;

	}

	private static int getvalue(String ab) {

		return 0;
	}

	public static void main(String[] args) {

		String ab[] = {};

		String bf[] = { "                             " };
		parse(bf);

	}

}
