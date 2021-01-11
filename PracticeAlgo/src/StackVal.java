import java.util.ArrayList;
import java.util.Stack;

public class StackVal {
	static int min = Integer.MAX_VALUE;
	static Stack<Integer> st = new Stack<Integer>();

	static void minim(int val) {

		if (min >= Integer.MAX_VALUE) {
			min = val;
			st.add(val);
		} else if (min < val) {
			st.add(val);
		} else if (min > val) {

			st.add(val + (val - min));
			min = val;
		}

	}

	static void pom() {
		if (min < st.peek()) {
			System.out.println(min);
			st.pop();
		} else if (min > st.peek()) {
			int de = st.pop();
			System.out.println(de + (de - st.peek()));

		}
	}

	static class Tree {
		int value;
		ArrayList<Tree> ar = new ArrayList<StackVal.Tree>();
	}

	static Tree root = null;

	static void pushvalue(int arr[]) {
		Tree root;
		Stack<Tree> st = new Stack<Tree>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Tree t = new Tree();
				t.value = arr[i];
				if (st.size() > 1) {
					st.peek().ar.add(t);
				} else {
					root = t;
					st.push(t);
				}
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, -1, -1, 5, 6, -1 };

	}
}
