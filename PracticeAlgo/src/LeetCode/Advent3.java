package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Advent3 {

	static class Cordinate {
		int x;
		int y;
		int flag;

		public Cordinate(int x, int y, int flag) {
			super();
			this.x = x;
			this.y = y;
			flag = Integer.MIN_VALUE;
		}

		@Override
		public String toString() {
			return "Cordinate [x=" + x + ", y=" + y + "id" + flag + "]";
		}

	}

	static void day6(String a[]) {

		for (int i = 0; i < a.length; i++) {
			String[] instruction = a[i].split(" ");
			switch (instruction[0]) {
			case "nop":
				instruction[0] = "jmp";
				String newinset = String.join("", instruction);
				String p[] = a.clone();
				p[i] = newinset;
				if (isnotloop(p)) {
					break;
				}
				break;

			case "jmp":
				instruction[0] = "jmp";
				String newinset2 = String.join("", instruction);
				String p2[] = a.clone();
				p2[i] = newinset2;
				if (isnotloop(p2)) {
					break;
				}
				break;

			default:
				break;
			}
		}

	}

	private static boolean isnotloop(String[] a) {
		List<Integer> list = new ArrayList<Integer>();
		int acc = 0;
		int i = 0;
		for (i = 0; i < a.length; i++) {
			if (list.contains(i)) {
				return false;
			}
			list.add(i);
			String[] instruction = a[i].split(" ");
			switch (instruction[0]) {
			case "nop":

				break;
			case "acc":
				acc = acc + Integer.parseInt(instruction[1]);
				break;
			case "jmp":
				i = i + Integer.parseInt(instruction[1]) - 1;
				break;

			default:
				break;
			}
		}
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(acc);
		System.out.println(i);
		return true;
	}

	private static void parsearraylist(HashMap<Integer, Cordinate> ar, HashMap<Integer, Cordinate> pr) {}

	static void validparse(String a[]) {
		HashMap<Long, Integer> hashmap = new HashMap<Long, Integer>();
		ArrayList<Long> set = new ArrayList<Long>();
		for (int i = 0; i < a.length; i++) {
			String ab = a[i].trim();
			long b = Long.parseLong(ab);
			set.add(b);

		}
		int max = 0;
		for (int i = 0; i < set.size(); i++) {
		}
	}

	static void getpax(String a[]) {
		ArrayList<Long> set = new ArrayList<Long>();
		for (int i = 0; i < a.length; i++) {
			String ab = a[i].trim();
			long b = Long.parseLong(ab);
			set.add(b);
		}set.add(0L);
		Collections.sort(set);
		ArrayList<Long> pt = new ArrayList<Long>();
		
		int one = 0;
		int three = 0;
		for (int k = 0; k < set.size()-1; k++) {
			System.out.println(set.get(k)+" ");
			if (set.get(k+1) - set.get(k)==1) {
				one++;
			}
			if (set.get(k+1) -set.get(k)== 3){
				three++;
			}

		}
		System.out.println((one)* three);
	}

	public static void main(String[] args) {
		String br[] = { "153   ", "17     ", "45     ", "57     ", "16     ", "147    ", "39     ", "121    ",
				"75     ", "70     ", "85     ", "134    ", "128    ", "115    ", "51     ", "139    ", "44     ",
				"65     ", "119    ", "168    ", "122    ", "72     ", "105    ", "31     ", "103    ", "89     ",
				"154    ", "114    ", "55     ", "25     ", "48     ", "38     ", "132    ", "157    ", "84     ",
				"71     ", "113    ", "143    ", "83     ", "64     ", "109    ", "129    ", "120    ", "100    ",
				"151    ", "79     ", "125    ", "22     ", "161    ", "167    ", "19     ", "26     ", "118    ",
				"142    ", "4      ", "158    ", "11     ", "35     ", "56     ", "18     ", "40     ", "7      ",
				"150    ", "99     ", "54     ", "152    ", "60     ", "27     ", "164    ", "78     ", "47     ",
				"82     ", "63     ", "46     ", "91     ", "32     ", "135    ", "3      ", "108    ", "10     ",
				"159    ", "127    ", "69     ", "110    ", "126    ", "133    ", "28     ", "15     ", "104    ",
				"138    ", "160    ", "98     ", "90     ", "144    ", "1      ", "2      ", "92     ", "41     ",
				"86     ", "66     ", "95     ", "12     " };
		String hc[] = { "16 ", "10 ", "15 ", "5  ", "1  ", "11 ", "7  ", "19 ", "6  ", "12 ", "4  " };

		getpax(br);
	}

}
