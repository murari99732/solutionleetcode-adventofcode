package queueimpl;

class Node1 {
	int data;
	Node1 next;
	Node1 prev;
}

public class DoubleQueue {

	Node1 insertAtFirst(Node1 root, int v) {
		Node1 head = root;
		if (root == null) {
			return null;

		} else {
			Node1 a = new Node1();
			a.next = head;
			head.prev = a;
			return root;
		}
	}

	Node1 rotate(Node1 root, int position) {
		Node1 node = root;
		int i = 0;
		while (node != null && i < position) {
			node = node.next;
			i++;
		}

		Node1 tmp = node.next;
		Node1 temp = tmp;
		node.next = null;
		tmp.prev = null;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = root;
		root.prev = temp;

		return tmp;
	}

	Node1 insertAtGivenPosition(Node1 root, int position, int value) {

		Node1 head = root;
		if (position == 0) {
			if (head == null) {
				return getnewnode(value);
			} else {
				Node1 tmp = getnewnode(value);
				head.prev = tmp;
				tmp.next = head;
				return root;

			}
		} else {
			int k = 0;
			Node1 prev = null;
			while (head != null && k < position) {
				head = prev;
				head = head.next;
				k++;
			}
			Node1 tmp = getnewnode(value);
			head.prev = tmp;
			tmp.prev = prev;
			prev.next = tmp;
			tmp.next = head;
			return tmp;

		}
	}

	Node1 insert(Node1 root, int n) {
		if (root == null) {
			return getnewnode(n);
		} else {
			root.next = getnewnode(n);
			getnewnode(n).prev = root;
		}
		return root;
	}

	private Node1 getnewnode(int n) {
		Node1 node = new Node1();
		node.data = n;

		return node;

	}

	public static void main(String[] args) {

	}

}
