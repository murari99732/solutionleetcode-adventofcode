package linked;

class Node1 {
	int value;
	Node1 next;
}

public class Linked1 {

	static void print(Node1 root) {
		if (root == null) {
			return;
		} else {
		
			System.out.print(root.value);
			print(root.next);
		}
	}

	static Node1 insert(int value, Node1 root) {
		if (root == null) {
			return genewnode(value);
		} else {

			root.next = insert(value, root.next);
		}
		return root;
	}

	private static Node1 genewnode(int value) {
		Node1 a = new Node1();
		a.value = value;
		a.next = null;
		return a;
	}

	public static void main(String[] args) {
		Node1 root = null;
		root = insert(1, root);
		root = insert(2, root);

		root = insert(3, root);
		root = insert(3, root);
		root = insert(4, root);
		root = insert(6, root);
		root = insert(7, root);
		root = insert(8, root);
		root = insert(9, root);
		Node1 root1 = null;

		root1 = insert(3, root1);
		root1 = insert(4, root1);
		root1 = insert(5, root1);

		print(root);
		System.out.println();
		root = duplicate(root);
		print(root);
		System.out.println();

	}

	static Node1 deletelastnode(Node1 root) {
		if (root == null) {
			return null;
		}
		Node1 r = root;
		while (r.next != null) {
			r = r.next.next;
		}
		return root;

	}

	public static Node1 rotateClockwise(int k, Node1 node) {
		if (node == null || k < 0) {
			return node;
		}

		int sizeOfLinkedList = size(node);
		k = k % sizeOfLinkedList;

		if (k == 0) {
			return node;
		}

		Node1 tmp = node;
		int i = 1;

		while (i < sizeOfLinkedList - k) {
			tmp = tmp.next;
			i++;
		}

		Node1 temp = tmp.next;
		Node1 head = temp;
		tmp.next = null;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return head;
	}

	private static int sizeoflinked(Node1 root) {
		if (root == null) {
			return 0;
		}
		return sizeoflinked(root) + 1;

	}

	static Node1 mergeIntersection(Node1 root, Node1 node) {
		Node1 next = new Node1();
		Node1 test = next;
		int min = Integer.MAX_VALUE;
		while (root != null && node != null) {

			if (root.value > node.value) {

				node = node.next;
			} else if (root.value < node.value) {
				root = root.next;
			} else {
				min = Math.min(min, root.value);
				test.next = root;
				test = test.next;
				root = root.next;
				node = node.next;
			}

		}
		System.out.println(" " + min);
		test.next = null;
		return next.next;
	}

	private static Node1 duplicate(Node1 root) {
		if (root == null || root.next == null) {
			return root;
		}

		if (root.value == root.next.value) {
			root.next=root.next.next;
			root.next=duplicate(root.next);
		}
		else
		{
			root.next=duplicate(root.next);
		}
		return root;
	}

	
	
	private static int position(Node1 root, int i) {
		if (root.value == i) {
			return 0;
		}
		return position(root.next, i) + 1;
	}

	private static int size(Node1 node) {
		if (node == null) {
			return 0;
		}

		return 1 + size(node.next);
	}

	private static Node1 insertPos(Node1 root, int i, int j) {
		if (i < 1) {
			System.out.println("nothing");
			return root;
		}
		if (i > 1 && root == null) {
			System.out.println("novalue");
			return root;
		}
		if (i == 1 && root == null) {
			Node1 t = genewnode(j);
			t.next = root;
			return t;
		}
		if (i == 1) {
			Node1 t = genewnode(j);
			Node1 l = root.next;
			t.next = l;
			root.next = t;
			return root;
		}
		root.next = insertPos(root.next, i - 1, j);
		return root;
	}

	private static Node1 deletepos(Node1 root, int i) {

		if (i == 1) {

			return root.next;
		}
		root.next = deletepos(root.next, i - 1);
		return root;
	}

	static Node1 deleteFirst(Node1 root) {
		Node1 t = root.next;
		root = t;
		return root;

	}

	private static Node1 delete(Node1 root) {
		if (root == null || root.next == null) {
			return null;
		}
		root.next = delete(root.next);
		return root;

	}

	private static Node1 insertFirst(int i, Node1 root) {
		Node1 t = genewnode(i);
		Node1 p = root;
		t.next = root;
		root = t;
		return root;
	}

}
