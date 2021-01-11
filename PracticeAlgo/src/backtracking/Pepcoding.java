package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pepcoding {

	static class Node {
		int value;
		List<Node> list = new ArrayList<Pepcoding.Node>();

	}

	static int count = 0;

	static void consturction(int arr[], Node node) {

		Node root = node;
		Stack<Node> st = new Stack<Node>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.value = arr[i];
				Node temp = st.peek();
				temp.list.add(t);
				st.push(t);
			}
		}

	}

	static void display(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.value);
			for (int i = 0; i < node.list.size(); i++) {
				q.add(node.list.get(i));
			}
		}
	}

	static class Tree {
		int data;
		Tree left;
		Tree right;
	}

	static Tree singlechild(Tree tree) {
		if (tree == null) {
			return null;
		}
		Tree temp = singlechild(tree.left);
		Tree stemp = singlechild(tree.right);
		if (temp != null && stemp == null || temp == null && stemp != null) {
			System.out.println(tree);
		}
		return tree;
	}

	static void displayPreorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		for (int i = 0; i < node.list.size(); i++) {
			displayPreorder(node.list.get(i));
		}
	}

}
