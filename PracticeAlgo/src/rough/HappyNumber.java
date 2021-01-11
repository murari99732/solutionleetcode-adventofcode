package rough;

import java.util.Iterator;
import java.util.List;

class Merge {
	int x;
	int y;
}

public class HappyNumber {

	static void happy(int a) {
		int mul = 0;
		while (mul >= 0) {

			while (a != 0) {
				mul = mul + (a % 10) * (a % 10);
				a = a / 10;
				if (mul == 1) {
					System.out.println("kauns a" + true);
					return;
				}

			}
			if (mul == 1) {
				System.out.println(true);
			}
			if (mul != 0) {
				a = mul;
				mul = 0;
				continue;
			}

		}
		System.out.println(mul);
	}

	static void merge(List<Merge> list) {
		int x = list.get(0).x;
		int y = list.get(0).y;
		Iterator<Merge> merge = list.iterator();
		while (merge.hasNext()) {
			int currx = merge.next().x;
			int curry = merge.next().y;
			if (currx < y) {
				y = curry;
			} else {
				x = currx;
				y = curry;
			}
		}
	}

	public static void main(String[] args) {
		happy(19);

	}
}
