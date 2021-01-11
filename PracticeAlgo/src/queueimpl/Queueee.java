package queueimpl;

import java.io.ObjectInputStream.GetField;
import java.util.Stack;

class Node {
	int data;
	Node next;
}

public class Queueee {

	static Node first;
	static int size = 0;
	static int maximum = 5;
	static Node last;
	static int arr[] = new int[5];
	static int aage = 0;
	static int piche = 0;
	static Stack<Integer> st = new Stack<Integer>();

	static void enqueuearray(int value) {
		if (aage - piche == 5) {
			size++;
			System.out.println("we cannot accomadate it");
		} else {
			int start = 0;
			int end = arr.length - 1;
			while (start < end) {
				int mid = (start + end) / 2;
				if (arr[mid] < value) {
					start = mid + 1;
				} else if (arr[mid] > value) {
					end = mid - 1;
				} else {
					break;
				}
			}
			int k = 0;
			int b[] = new int[arr.length + 1];
			int mid = (start + end) / 2;
			for (int i = 0; i < arr.length + 1; i++) {
				if (i < mid) {
					b[k++] = arr[i];
				} else if (i == start) {
					b[k++] = value;
				} else {
					b[k++] = arr[i + 1];
				}
			}
			piche++;
			size++;
		}

	}

	static int dequeuearray() {
		if (piche == 0) {
			return -222222222;
		}
		int value = arr[aage];
		for (int i = 1; i < arr.length + 1; i++) {
			arr[i - 1] = arr[i];
		}
		return value;
	}

	static Node enqueue(int value) {
		if (first == null) {
			first = getnewnode(value);
			last = getnewnode(value);
			size++;
			return last;
		} else {
			size++;
			last.next = getnewnode(value);
			first = sort(last, last.next);
			last = last.next;
			return last;

		}

	}

	static Node dequeue() {
		if (last == null) {
			return null;
		} else {
			return first.next;
		}
	}

	private static Node sort(Node last2, Node getnewnode) {

		Node temp = new Node();
		Node zemp = temp;

		while (last2 != null && getnewnode != null) {
			if (last2.data < getnewnode.data) {
				zemp.next = last2;
				last2 = last2.next;
			} else {
				zemp.next = getnewnode;
				getnewnode = getnewnode.next;
			}
			zemp = zemp.next;
		}

		zemp.next = (last2 == null) ? getnewnode : last2;
		return temp.next;

	}

	static void push(int value) {

		if (st.size() == 5) {
			return;
		} else {
			st.push(value);

		}

	}

	static void pop() {
		Stack<Integer> temp = new Stack<Integer>();
		if (st == null) {
			return;
		} else {
			if (st.size() != 1) {
				temp.push(st.pop());
			}
			System.out.println(st.pop());
			if (!temp.isEmpty()) {
				st.push(temp.pop());
			}
		}
	}

	private static Node getnewnode(int value) {
		Node node = new Node();
		node.data = value;
		return node;
	}
}
