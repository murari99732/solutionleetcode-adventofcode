package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class StackUsingArray {
	static Stack<Integer> s = new Stack<Integer>();
	static Stack<Integer> st = new Stack<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();

	static void implqueue(int value) {
		if (st.size() == 5) {
			return;
		} else if (st.size() != 5) {
			st.push(value);
		}
	}

	static void delete() {
		Stack<Integer> st1 = new Stack<Integer>();
		if (st.isEmpty()) {
			return;
		} else if (st.size() != 5) {
			while (!st.isEmpty()) {
				st1.add(st.pop());
			}
			st1.pop();
			while (!st1.isEmpty()) {
				st.add(st1.pop());
			}
		}
	}

	public static void push(int value) {
		if (q.size() == 5) {
			System.out.println("false");
			return;
		} else {
			q.add(value);

		}
	}

	static void pop() {
		Queue<Integer> queue = new LinkedList<Integer>();
		if (q.isEmpty()) {
			return;
		} else {
			while (q.size() != 1) {
				queue.add(q.remove());
			}
			q.remove();
			while (queue.size() != 0) {
				q.add(queue.remove());
			}
		}
	}

	static void nextLargerElement(int arr[]) {
		int i = 0;
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (i < arr.length) {
			max = Math.max(max, arr[i]);
			stack.push(max);
			i++;
		}
		System.out.println(stack);
	}

	static void minimumelement(Stack<Integer> stack) {
		int i = 0;
		int min = Integer.MAX_VALUE;
		while (i < 6) {
			min = Math.min(stack.pop(), min);
			i++;
		}
		System.out.println(min);
	}

	static void minimum(int b[]) {
		Stack<Integer> st = new Stack<Integer>();
		int min = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < b.length; i++) {
			st.add(b[i]);
			min = Math.min(min, b[i]);
			if (s.peek() != min)
				s.add(min);
		}
		for (int i = 0; i < b.length; i++) {
			int d = st.pop();
			if (d == s.peek()) {
				s.pop();
			}

		}
	}
	static void min(int value)
	{
		
		if(s.isEmpty())
		{
			s.push(value);
		}
		else
		{
			
		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 2, 4, 6, 5, 4, 3, 8, 9, 3 };
		Stack<Integer> st = new Stack<Integer>();
		st.add(4);
		st.add(6);
		st.add(2);
		st.add(7);
		st.add(8);
		st.add(9);
		min(7);min(8);min(3);min(1);min(5);

	}
}
