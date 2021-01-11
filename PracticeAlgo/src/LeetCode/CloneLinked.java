package LeetCode;

import java.util.HashMap;

public class CloneLinked {

	static class LinkedList {
		int data;
		LinkedList next;
		LinkedList random;
	}

	static void clone1(LinkedList list) {
		LinkedList prev = null;
		LinkedList first = list;
		while (first != null) {
			LinkedList bst = createnode(first.data);
			LinkedList first1 = first.next;
			first.next = bst;
			first.next = first.next.next;
		}

		LinkedList bist = list;
		LinkedList rist = null;
		LinkedList gst = null;
		while (bist != null) {
			if (rist == null) {
				LinkedList dst = bist;
				dst.next.random = bist.random.next;
				rist = dst;
				gst = rist;

				bist = bist.next.next;
			} else {
				LinkedList dst = bist;
				dst.next.random = bist.random.next;
				gst.next = dst;
				bist = bist.next.next;
				gst = gst.next;

			}

		}

	}

	static LinkedList insert(LinkedList list, int val) {
		if (list == null) {
			return createnode(val);
		}
		list.next = insert(list.next, val);
		return list;

	}

	private static LinkedList createnode(int val) {
		LinkedList l = new LinkedList();
		l.data = val;
		return l;
	}

	static void clonehashmap(LinkedList list) {
		HashMap<LinkedList, LinkedList> hashmap = new HashMap<CloneLinked.LinkedList, CloneLinked.LinkedList>();
		LinkedList sbt = null;
		LinkedList rst = null;
		while (list != null) {
			LinkedList newnode = createnode(list.data);
			if (sbt == null) {
				sbt = newnode;
				rst = sbt;
			} else {
				rst.next = newnode;
				rst = newnode;
			}
			hashmap.put(list, rst);
			list = list.next;

		}

		LinkedList pr = null;
		while (list != null) {
			LinkedList rst1 = hashmap.get(list);
			pr.random = rst1.random;
			pr = pr.next;
			rst1 = rst1.random;
		}

	}

	static void iterative(LinkedList list) {
		LinkedList prev = null;

		while (list != null) {
			LinkedList next = list.next;
			list.next = prev;
			prev.next = list;
			list = next;

		}
	}

	static java.util.LinkedList<Integer> list = new java.util.LinkedList<Integer>();

	static void push(int v) {
		list.add(v);
	}

	static int pop() {
		int v = list.removeLast();
		return v;
	}
	

	public static void main(String[] args) {
		CloneLinked cl = new CloneLinked();
		LinkedList l = new LinkedList();

	}

}
