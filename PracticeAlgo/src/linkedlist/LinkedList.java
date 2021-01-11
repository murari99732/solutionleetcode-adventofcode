
package linkedlist;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Node {
	Node next;
	int data;
	Node random;
}

class Linked {
	/*
	 * It'll sort linked list
	 */

	public Node intersection(Node a, Node b) {
		int size = getSize(a, 0);
		int dsize = getSize(b, 0);
		Node first = null;
		Node second = null;
		if (size > dsize) {
			first = a;
			second = b;
		} else {
			first = b;
			second = a;
		}

		int t = 0;
		int diff = size > dsize ? size - dsize : dsize - size;
		while (t != 0) {
			first = first.next;
			t++;
		}

		while (first != null && second != null) {
			if (first != second) {
				first = first.next;
				second = second.next;
			} else {
				break;
			}
		}
		printList(first);
		return first;
	}

	Node recursive(Node node) {

		if (node == null || node.next == null) {
			return node;
		}
		Node temp = recursive(node);
		node.next.next = node;
		node = null;
		return temp;
	}

	Node recursiveKroot(Node node, int k) {

		Node next = null;
		Node prev = null;
		int kd = 0;
		while (node != null && kd != k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			kd++;

		}
		if (node != null) {
			node.next = recursiveKroot(next.next, k);
		}
		return prev;
	}

	Node reverseAlternatively(Node n, int k, boolean b) {
		if (b == true) {
			Node next = null;
			Node prev = null;
			while (n != null) {
				next = n.next;
				n.next = prev;
				prev = n;
				n = next;
			}
			if (n != null) {
				n.next = reverseAlternatively(next.next, k + 1, false);
			}

		} else {

		}

		return null;
	}

	private int getSize(Node a, int count) {
		if (a == null) {
			return count;
		}

		return getSize(a, count + 1);
	}

	public Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node middle = middleNode(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(node), mergeSort(secondHalf));
	}

	Node getKthNode(Node node, int i, int k) {
		if (i == k) {
			System.out.println(node.data);
			return node;
		}
		return getKthNode(node.next, i + 1, k);
	}

	/*
	 * It'll find the middle node of the linked list
	 */
	public Node middleNode(Node node) {
		if (node == null) {
			return null;
		}

		Node a = node;
		Node b = node.next;

		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}

		return a;
	}

	/*
	 * It'll merge both linked list
	 */
	public Node merge(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;

		while (a != null && b != null) {
			if (a.data < b.data) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

	/*
	 * getNewNode() method to generate a new node
	 */
	public Node getNewNode(int key) {
		Node a = new Node();
		a.next = null;
		a.data = key;
		return a;
	}

	/*
	 * insert method is used to insert the element in Linked List
	 */
	public Node insert(int key, Node node) {

		if (node == null)
			return getNewNode(key);
		else
			node.next = insert(key, node.next);

		return node;
	}

	/*
	 * It'll print the complete linked list
	 */
	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	Node add(Node a) {
		int val = count(a);
		if (val == 1) {
			Node head = getNewNode(1);
			head.next = a;
			return head;
		} else {
			return a;
		}
	}

	Node add(Node a, Node b) {
		Node c = recursive(a);
		Node d = recursive(b);
		Node cd = null;
		Node fc = cd;
		int de = 0;
		int value = 0;
		while (c != null && d != null) {
			value = de + c.data + d.data;
			int res = value % 10;
			de = value / 10;
			c.data = res;
			c = c.next;
			d = d.next;
		}
		return null;
	}

	private static int count(Node a) {
		if (a == null) {
			return 1;
		}

		int res = a.data + count(a.next);
		a.data = res / 10;

		return res % 10;
	}

	public Node createNode(int i) {
		Node n = new Node();
		n.data = i;
		return n;
	}

}

public class LinkedList {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();

		root = a.insert(12, root);
		root = a.insert(99, root);
		root = a.insert(37, root);
		root = a.insert(8, root);
		root = a.insert(18, root);
		root = a.insert(7, root);
		root = a.insert(9, root);

		a.printList(root);
		System.out.println();

		Node sorted = a.mergeSort(root);
		a.printList(sorted);

		System.out.println();

		Node node[] = new Node[3];
		node[0] = a.createNode(2);
		node[0].next = a.createNode(3);
		node[0].next.next = a.createNode(4);
		node[0].next.next.next = a.createNode(5);
		node[1] = a.createNode(7);
		node[1].next = a.createNode(8);
		node[1].next.next = a.createNode(9);
		node[1].next.next.next = a.createNode(13);
		node[2] = a.createNode(32);
		node[2].next = a.createNode(39);
		node[2].next.next = a.createNode(44);
		node[2].next.next.next = a.createNode(50);

		Node p = zigzag(root);
		a.printList(p);

	}

	static void clone(Node n) {
		Node temp = n;
		Node prev = n;
		while (temp != null) {

			Node next = temp.next;
			Node currtemp = getNewNode(temp.data);
			temp.next = currtemp;
			currtemp = next;
			temp = temp.next.next;
		}

		n = temp;
		while (temp != null) {
			temp.next.random = temp.random.next;
			temp = temp.next.next != null ? temp.next.next : temp.next;
		}

		Node t = null;
		Node s = null;

		while (n != null) {
			t.next = n.next;
			n = n.next;
			t = t.next;
			s.next = n.next;
			n = n.next;
			n = n.next;
		}

	}

	private static Node getNewNode(int data) {
		Node n = new Node();
		n.data = data;
		return n;
	}

	static void union(Node a, Node b) {
		Set<Integer> set = new HashSet<Integer>();
		Node temp = null;
		Node p = temp;
		while (a != null) {
			if (!set.contains(a.data)) {
				set.add(a.data);
				temp.data = a.data;
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}
		while (a != null) {
			if (!set.contains(a.data)) {
				set.add(a.data);
				temp.data = a.data;
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}

		while (b != null) {
			if (!set.contains(b.data)) {
				set.add(b.data);
				temp.data = b.data;
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}
	}

	private static Node merge(Node[] node, int i) {

		int start = 0;
		int end = i - 1;
		while (start <= end) {
			if (start == end) {
				Node p = node[start];
				node[start] = ksort(p, node[end]);
			} else {
				node[start] = ksort(node[start], node[end]);
			}
			start++;
			end--;
		}
		return node[start];
	}

	private static Node ksort(Node node, Node node2) {

		if (node2 == null) {
			return node;
		}
		if (node == null) {
			return node2;
		}

		Node temp = new Node();
		Node rent = temp;
		while (node != null && node2 != null) {
			if (node.data > node2.data) {
				temp.next = node2;
				node2 = node2.next;
			} else {
				temp.next = node;
				node = node.next;
			}
			temp = temp.next;
		}
		temp.next = node == null ? node2 : node;
		return rent.next;
	}

	static void cloneHashmap(Node a) {
		HashMap<Node, Node> hashmap = new HashMap<Node, Node>();
		Node temp = a;
		Node secondf = null;
		Node secondl = null;
		while (temp != null) {
			Node curr = getNewNode(temp.data);

			if (secondf == null) {
				secondf = curr;
				secondl = secondf;

			} else {
				secondl.next = curr;

			}
			hashmap.put(temp, secondf);
			secondl = secondl.next;
			temp = temp.next;
		}

	}

	static Node zigzag(Node a) {
		Node temp = a;
		Node prev = null;
		while (temp != null) {

			if (prev != null) {

				if (prev.data > temp.data) {
					temp = temp.next;
				} else {
					int val = prev.data;
					prev.data = temp.data;
					temp.data = val;

				}
				prev = temp;
				temp = temp.next;
				if (prev.data < temp.data) {
					temp = temp.next;
				} else {
					int val = prev.data;
					prev.data = temp.data;
					temp.data = val;

				}
				prev = temp;
				temp = temp.next;
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
		return a;

	}

	static void display(Node node) {

		Node start = node;
		Node end = start;
		
		while(end!=null)
		{
			end=end.next;
		}
		while(start!=null)
		{
			if(start!=null)
			{
				end.next=start.random;
				end=end.next;
				while(end.next!=null)
				{
					end=end.next;
				}
			}
		}

	}
}