package rough;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import recursion.Print;

class Node {
	int data;
	Node next;
}

class LinkedImpl {

	Node insert(Node node, int value) {
		if (node == null) {
			return createnewnode(value);
		} else {
			node.next = insert(node.next, value);
			return node;
		}
	}

	void print(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		print(node.next);
	}

	private Node createnewnode(int value) {
		Node node = new Node();
		node.data = value;
		node.next = null;
		return node;

	}

	public Node insertFirst(Node node, int value) {
		Node temp = createnewnode(value);
		temp.next = node;
		return temp;
	}

	public Node insertLast(Node node, int value) {
		Node temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node tmp = createnewnode(value);
		temp.next = tmp;
		return node;
	}

	Node insertAtGivenPosition(Node node, int position, int value) {
		if (position == 0) {
			return null;
		}
		if (node == null && position == 1) {
			Node temp = createnewnode(value);
			temp.next = node;
		}
		if (position == 1) {
			Node t = createnewnode(value);
			Node temp = node.next;
			node.next = t;
			t.next = temp;
			return node;
		}
		node.next = insertAtGivenPosition(node.next, position - 1, value);
		return node;
	}

	Node deleteFirst(Node node) {
		Node temp = node.next;
		return temp;
	}

	Node deleteLast(Node node) {
		Node temp = node;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return node;
	}

	Node deleteAtPosition(Node node, int position) {
		if (position == 1) {
			return node.next;
		}
		node.next = deleteAtPosition(node.next, position - 1);
		return node;
	}

	public int getSizeofList(Node root) {
		if (root == null) {
			return 0;
		}
		return getSizeofList(root.next) + 1;
	}

	public boolean searchNode(Node root, int i) {
		if (root == null) {
			return false;
		}

		if (root.data == i) {
			return true;
		}
		return searchNode(root.next, i);
	}

	public Node rotateClockWise(Node root, int i) {
		if (root == null) {
			return null;
		}
		int rotate = i % getSizeofList(root);

		Node temp = root;
		int j = 0;
		while (getSizeofList(root) - rotate > j) {
			temp = temp.next;
			j++;
		}
		Node tmp = temp.next;
		Node rat = tmp;
		temp.next = null;
		while (rat.next != null) {
			rat = rat.next;
		}
		rat.next = root;
		return tmp;

	}

	public Node rotateAntiClockWise(Node root, int i) {
		if (root == null) {
			return null;
		}
		int rotate = i % getSizeofList(root);

		Node temp = root;
		int j = 0;
		while (rotate < j) {
			temp = temp.next;
			j++;
		}
		Node tmp = temp.next;
		Node rat = tmp;
		temp.next = null;
		while (rat.next != null) {
			rat = rat.next;
		}
		rat.next = root;
		return tmp;

	}

	public Node recursive(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		Node temp = recursive(root.next);
		root.next.next = root;
		root.next = null;
		return temp;
	}

	public static Node middle(Node root) {
		if (root == null) {
			return null;
		}
		Node temp = root;
		Node tmp = root.next;
		while (temp != null && tmp.next != null) {
			temp = temp.next;
			tmp = tmp.next.next;
		}

		return temp;
	}

	public static Node sort(Node root) {
		if (root == null) {
			return null;
		}

		Node middle = middle(root);
		Node last = middle.next;
		middle.next = null;

		return mergeSort(sort(middle), sort(last));

	}

	private static Node mergeSort(Node sort, Node sort2) {

		Node f = new Node();
		Node temp = f;
		while (sort != null && sort2 != null) {
			if (sort.data > sort2.data) {
				temp.next = sort;
				sort = sort.next;
			} else {
				temp.next = sort2;
				sort2 = sort2.next;
			}
			temp = temp.next;
		}
		temp.next = (sort == null) ? sort2 : sort;
		return f.next;
	}

	void union(Node node, Node data) {
		HashSet<Integer> hashset = new HashSet<>();
		Node tmp = node;
		while (tmp != null) {
			hashset.add(tmp.data);
			tmp = tmp.next;
		}

		Node hs = data;
		while (hs != null) {
			hashset.add(hs.data);
			hs = hs.next;
		}
		System.out.println(hashset);
	}

	Node removeduplicate(Node data) {
		if (data == null || data.next == null) {
			return data;
		}
		if (data.data == data.next.data)

		{
			data.next = data.next.next;
			removeduplicate(data);
		} else {
			removeduplicate(data.next);
		}
		return data;
	}

	Node deleteNodes(Node node, int n, int m) {
		Node temp = node;
		int i = 0;
		while (i < n) {
			temp = temp.next;
			i++;
		}
		Node tmp = temp.next;
		Node dt = tmp;

		temp.next = null;
		int j = 0;
		while (j < m) {
			dt = dt.next;
			j++;
		}
		temp.next = dt.next;

		return node;
	}

	Node hashSorting(Node node) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		Node temp = node;
		Node prev = null;
		while (temp != null) {
			if (!hm.containsKey(temp.data)) {
				hm.put(temp.next.data, 1);
				temp = temp.next;
			} else {
				prev = temp.next;
				temp = prev.next;
				prev.next = null;

			}

		}
		return node;

	}

	static void detectLops(Node root) {
		Node temp = root;
		Node tmp = root;
		while (temp.next != null && tmp.next.next != null) {
			temp = temp.next;
			tmp = tmp.next.next;
			if (temp.data == tmp.data) {
				System.out.println("true");
				break;
			}
		}

	}

	boolean middleandLast(Node root) {

		if (root == null) {
			return false;
		}
		Node temp = root;
		int i = 0;
		Node prev = root;
		while (i < getSizeofList(root) / 2) {
			prev = temp;
			temp = temp.next;
			i++;
		}

		Node st = prev.next;
		Node ts = st;
		prev.next = null;

		while (ts != null && root != null) {
			if (ts.data == root.data) {
				ts = ts.next;
				root = root.next;
			} else {
				return false;
			}
		}

		return true;

	}

	boolean pallindrome(Node node) {
		Stack<Integer> st = new Stack<Integer>();
		Node temp = node;
		Node tmp = node;
		Node prev = temp;
		while (temp != null) {
			prev = tmp;
			st.push(tmp.data);
			tmp = tmp.next;
			temp = temp.next.next;
		}
		Node half = prev.next;
		Node shalf = half;
		prev.next = null;
		while (shalf != null) {
			if (st.pop() != shalf.data) {
				return false;
			} else {
				shalf = shalf.next;
			}
		}

		System.out.println(true);
		return true;
	}

	Node greatervalue(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node reverse = this.recursive(node);
		Node tmp = reverse;
		int max = tmp.data;
		while (tmp.next != null) {
			if (max < tmp.next.data) {
				max = tmp.next.data;
				tmp = tmp.next;
			} else {
				tmp.next = tmp.next.next;
			}
		}

		node = this.recursive(reverse);

		return node;
	}

	boolean identical(Node node, Node data) {
		int d = getSizeofList(node);
		int e = getSizeofList(data);
		if (d != e) {
			return false;
		}

		while (node != null && data != null) {
			if (node.data != data.data) {
				return false;
			}
			node = node.next;
			data = data.next;
		}
		return true;

	}

	Node swappairwise(Node node) {
		Node temp = node;

		while (temp.next != null) {
			int data1 = temp.data;
			temp.data = temp.next.data;
			temp.next.data = data1;
			temp = temp.next;
		}
		return node;
	}

	Node deleteAlternate(Node temp) {
		Node node = temp;
		while (temp.next != null && temp != null) {
			temp.next = temp.next.next;
			temp = temp.next;
		}
		return node;
	}

	Node printful(Node data) {
		Node head = data;
		while (head.next.next != null) {
			head.next = head.next.next;
			head = head.next;
		}
		return data;
	}

	Node drintful(Node head) {
		Node data = head;
		while (head.next.next != null) {
			head.next = head.next.next;
			head = head.next;
		}
		return data;
	}

	Node swap(Node head) {
		Node dat = head;
		while (dat.next.next != null) {
			dat = dat.next;
		}
		Node pr = dat.next;
		pr.next = head;
		dat.next = null;
		return pr;
	}

	int count(Node head, int value) {
		Node temp = head;
		int max = 0;
		while (temp.next != null) {
			if (temp.data == value) {
				max++;
			}
			temp = temp.next;
		}
		return max;
	}

	
}

public class LinkedSolution {
	public static void main(String[] args) {
		LinkedImpl linked = new LinkedImpl();
		Node root = null;
		root = linked.insert(root, 1);
		root = linked.insert(root, 2);
		root = linked.insert(root, 39);
		root = linked.insert(root, 6);
		root = linked.insert(root, 16);
		root = linked.insert(root, 1);
		root = linked.insert(root, 2);
		root = linked.insert(root, 16);
		root = linked.insert(root, 1);
		root = linked.insert(root, 2);
		root = linked.insert(root, 16);
		root = linked.insert(root, 1);
		root = linked.insert(root, 2);
		root = linked.insert(root, 16);
		root = linked.insert(root, 1);
		root = linked.insert(root, 2);
		root = linked.insert(root, 16);
		root = linked.insert(root, 1);
		// linked.print(root);
		System.out.println(linked.count(root, 1));

		// linked.print(linked.drintful(root));

		// System.out.println(linked.pallindrome(root));
		// linked.middleandLast(root);
		// linked.print(root);
		// System.out.println();
		// root = linked.insertAtGivenPosition(root, 3, 12);
		// root = linked.hashSorting(root);

		// linked.print(root);

		Node head = null;
		LinkedImpl a = new LinkedImpl();

		head = a.insert(head, 12);
		head = a.insert(head, 99);
		head = a.insert(head, 37);
		head = a.insert(head, 5);
		head = a.insert(head, 35);

		// a.detectLops(head);
		/*
		 * Node node = null; node = linked.insert(node, 2); node = linked.insert(node,
		 * 3); node = linked.insert(node, 4); node = linked.insert(node, 5); node =
		 * linked.insertFirst(node, 6); node = linked.insertLast(node, 7); node =
		 * linked.insertAtGivenPosition(node, 3, 12); node =
		 * linked.deleteAtPosition(node, 3);
		 * 
		 * int d = linked.getSizeofList(root); boolean bc = linked.searchNode(root, 67);
		 * // linked.print(root); root = linked.rotateClockWise(root, 2); //
		 * linked.print(root); System.out.println(); root =
		 * linked.rotateAntiClockWise(root, 2); root = linked.middle(root); //
		 * linked.print(root); linked.union(node, root);
		 */
	}
}
