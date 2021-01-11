package linked;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Node {
	Node next;
	int data;
}

class Node2 {
	Node2 next;
	int data;
	Node2 random;
}

class Linked {
	/*
	 * It'll sort linked list
	 */
	public Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node middle = middleNode(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(node), mergeSort(secondHalf));
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
	public static Node getNewNode(int key) {
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

	Node recursively(Node node) {
		if (node == null) {
			return null;
		}

		Node temp = node;
		Stack<Integer> st = new Stack<Integer>();
		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}

		Node stp = new Node();
		Node dp = stp;
		while (!st.isEmpty()) {
			stp.next = getNewNode(st.pop());
			stp = stp.next;

		}
		return dp.next;
	}

	public Node reverseIteratively(Node node, int k) {
		if (node == null) {
			return null;
		}
		Node temp = node;
		Node prev = null;
		Node next = null;
		int i = 0;
		while (temp != null && k < i) {
			temp.next = next;
			next.next = prev;
			prev = node;
			node = next;
			i++;
		}

		if (next.next != null) {
			int j = 0;
			while (j < k) {
				next = next.next;
				j++;
			}

		}
		if (next.next != null) {
			node.next = reverseIteratively(next, k);
		}
		return prev;
	}

	void evenOrOdd(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node;
		Node evenStart = null, evenend = null, oddstart = null, oddend = null;

		while (temp.next != null) {
			if (temp.data % 2 == 0) {
				if (evenStart == null) {
					evenStart = temp;
					evenend = temp;
					temp = temp.next;

				} else {
					evenend.next = temp;
					temp = temp.next;
					evenend = evenend.next;
					evenStart.next = evenend;
				}

			} else {
				if (oddstart == null) {
					oddstart = temp;
					oddend = temp;
					temp = temp.next;

				} else {
					oddend.next = temp;
					temp = temp.next;
					oddend = oddend.next;
					oddstart.next = oddend;
				}

			}

		}
		evenStart.next = oddstart;
		System.out.println();

	}

	static void pairwise(Node node) {

		Node temp = node;
		while (temp.next.next != null) {
			int st = temp.next.data;
			int temp1 = temp.data;
			temp.data = temp.next.data;
			temp.next.data = temp1;
			temp = temp.next.next;
		}

		if (temp.next != null) {
			int st = temp.next.data;
			int temp1 = temp.data;
			temp.data = temp.next.data;
			temp.next.data = temp1;
			temp = temp.next;
		}
		System.out.println();

	}

	public static void split(Node node) {
		Node temp = node;
		Node tmp = node.next;
		Node st = null;
		Node ss = null;
		Node tt = null;
		Node ts = null;
		while (temp.next != null) {

		}

		System.out.println();
	}

	public static void merge1(Node node, Node root) {
		Node temp = node;
		Node tmp = root;
		Node t = null;
		Node s = t;

		while (temp.next != null && tmp.next != null) {
			s.next = temp;
			s.next.next = tmp;
			temp = temp.next;
			tmp = tmp.next;
			s = s.next.next;

		}
		System.out.println(s);

	}

	static int add(Node node) {
		if (node == null) {
			return 1;
		}
		int sum = node.data + add(node.next);
		node.data = sum % 10;
		return sum / 10;
	}

	static Node addValue(Node node) {
		int c = add(node);
		Node head = null;
		if (c == 1) {
			head = getNewNode(c);
			head.next = node;

		} else {
			return node;
		}
		return head;
	}

	public Node addTwoNumbers(Node node1, Node node2) {
		node1 = this.recursively(node1);
		node2 = this.recursively(node2);

		Node newListHead = null;
		Node prev = null;
		int sum, c = 0;

		while (node1 != null || node2 != null) {
			sum = c + (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0);

			c = sum / 10;

			Node node = getNewNode(sum % 10);
			if (newListHead == null) {
				newListHead = node;
			} else {
				prev.next = node;
			}

			prev = node;

			if (node1 != null) {
				node1 = node1.next;
			}

			if (node2 != null) {
				node2 = node2.next;
			}
		}

		if (c != 0) {
			prev.next = getNewNode(c);
		}

		newListHead = this.recursively(newListHead);

		return newListHead;
	}

	public static Node swap(Node node) {
		Node temp = node;
		Node es = null;
		Node ee = null;
		Node ss = null;
		Node se = null;
		while (temp != null) {
			if (temp.data % 2 == 0) {
				if (ss == null) {
					ss = temp;
					se = temp;
				} else {
					se.next = temp;
					se = se.next;
				}
			} else {
				if (es == null) {
					es = temp;
					ee = temp;
				} else {
					ee.next = temp;
					ee = ee.next;
				}
			}
			temp = temp.next;
		}
		Node h = es;
		ee.next = ss;
		return h;

	}

	Node diff(Node a, Node b) {
		Node temp = recursively(a);
		Node semp = recursively(b);

		Node prev = null;
		Node head = null;
		Node first = null;
		Node second = null;
		int size1 = getSize(temp);
		int size2 = getSize(semp);
		if (size1 > size2) {
			first = temp;
			second = semp;

		} else if (size1 < size2) {
			second = temp;
			first = semp;
		} else {
			if (temp == getbigger(temp, second)) {
				first = temp;
				second = semp;
			} else {
				first = semp;
				second = temp;
			}
		}
		int carry = 0;
		int diff = 0;

		while (first != null && second != null) {
			int f = first.data - second.data;
			if (f < 0) {
				diff = ((first == null) ? 0 : first.data) * 10 - ((second == null) ? 0 : second.data) - carry;

			} else {
				diff = ((first == null) ? 0 : first.data) - ((second == null) ? 0 : second.data) - carry;
			}
			carry = diff / 10;
			if (head == null) {
				head = getNewNode(diff % 10);
				prev = head;
			} else {
				prev.next = getNewNode(diff % 10);
			}

			prev = prev.next;
			if (first.next != null) {
				first = first.next;
			}
			if (second.next != null) {
				second = second.next;
			}
		}

		return recursively(head);
	}

	Node makeMiddle(Node node) {

		Node head = getmiddle(node);
		Node temp = node;
		Node tr = temp;
		int i = 1;
		while (7 / 2 != i - 1) {
			tr = temp;
			temp = temp.next;
			i++;
		}
		Node ct = tr.next;
		tr = temp.next;
		head.next = node;
		return head;
	}

	private Node getmiddle(Node node) {
		Node temp = node;
		Node fast = node;
		while (fast.next != null) {
			temp = temp.next;
			fast = fast.next.next;
		}

		return getNewNode(temp.data);

	}

	private Node getbigger(Node temp, Node second) {

		while (temp != null && second != null) {
			if (temp.data > second.data) {
				return temp;

			} else if (temp.data < second.data) {
				return second;
			}
			temp = temp.next;
			second = second.next;
		}
		return null;
	}

	int getSize(Node n) {
		if (n == null) {
			return 0;
		}
		return getSize(n.next) + 1;
	}

	int countPair(Node n, Node m, int value) {
		HashSet<Integer> hashset = new HashSet<>();
		while (n != null) {
			hashset.add(n.data);
			n = n.next;
		}
		int d = 0;
		while (m != null) {
			if (hashset.contains(value - m.data)) {
				d++;
			}
			m = m.next;

		}
		return d;
	}

	Node thirdElementRemove(Node n, int k) {

		int i = 0;
		Node temp = n;
		Node prev = n;
		while (k > i && temp.next.next != null) {
			prev = temp;
			temp = temp.next;
			i++;

		}

		prev.next = temp.next;
		temp = prev.next;

		return thirdElementRemove(temp, k);
	}

	Node sortedAbsolute(Node node) {

		Node temp = null;

		Node next;
		Node prev;
		Node tmp = prev = next = node;
		while (tmp != null) {
			if (tmp.data < 0) {
				temp = tmp;
				tmp = tmp.next;
				break;
			}
			tmp = tmp.next;
		}

		while (next != null) {
			if (next.data < 0) {
				temp.next = node;
				node = node.next;
				next.next = next.next.next;
				temp = temp.next;

			} else {
				prev = next;
				next = next.next;

			}
		}
		return node;
	}

	Node alreadysorted(Node head) {

		Node node, next, prev;

		node = next = head;
		prev = null;

		if (head.data < 0) {
			prev = node;
			node = node.next;
		}

		while (node != null) {
			if (node.data < 0) {
				prev.next = node.next;
				next = node.next;
				node.next = head;
				head = node;
				node = next;

			} else {
				prev = node;
				node = node.next;
			}
		}
		return head;
	}

	public Node2 insert(int key, Node2 node) {

		if (node == null) {
			return createNode2(key);
		} else {
			node.next = insert(key, node.next);
		}
		return node;

	}

	private Node2 createNode2(int key) {
		Node2 node = new Node2();
		node.data = key;
		return node;

	}

	public Node2 getedge(Node2 node) {

		Node2 next = node;
		Node2 prev = node;
		Node2 temp = node;

		while (next != null) {
			Node2 curr = createNode2(next.data);
			curr.next = next.next;
			next.next = curr;
			next = next.next.next;

		}
		Node2 f = null;
		while (temp != null) {
			temp.next.random = temp.random.next;
			temp = temp.next.next;

		}

		Node2 copy = temp;
		Node2 pen = temp;
		while (temp != null) {
			Node2 curr = null;
			curr = temp.next;
			copy.next = curr;
			copy = copy.next;
			temp = temp.next.next;

		}

		return null;
	}

	public Node2 createNewNode(int i) {
		Node2 a = new Node2();
		a.data = i;
		a.next = null;
		a.random = null;
		return a;
	}

	Node2 createHashingcloning(Node2 node) {
		HashMap<Node2, Node2> hashmap = new HashMap<Node2, Node2>();
		Node2 temp = node;

		Node2 hp = temp;
		temp = temp.next;
		Node2 curr1 = hp;
		while (temp != null) {
			Node2 curr = createNode2(temp.data);
			curr1.next = curr;
			hashmap.put(curr, temp.random);
			temp = temp.next;
		}
		Node2 first = hp;
		while (first != null) {

		}
		return null;

	}

	static Node swap1(Node root) {
		Node temp = root;
		Node prev = null;
		Node next = root;
		Node st = null;
		while (temp != null) {
			if (temp.data == 2) {
				prev.next = temp.next;
				temp = temp.next.next;
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
		return null;
	}

	static void reversegiven(Node node, int data, int value) {

		Node temp = node;
		Node tmp = node;
		Node prev = null;
		Node sprev = null;

		while (temp != null) {
			if (temp.next.data == data) {
				prev = temp;
				temp = temp.next;
			} else if (temp.data == value) {
				sprev = temp;
				temp = temp.next;
				break;
			} else {
				prev = temp;
				sprev = temp;
				temp = temp.next;
			}
		}

		Node hg = node;
		Node se = prev.next;
		Node next = null;
		while (se != null) {
			next = se.next;
			next.next = prev;
			prev = se;
			se = next;
		}
		prev.next = prev;
		next.next = temp;

	}

	Node deleteLargest(Node n) {
		if (n == null) {
			return null;
		}
		Node node = n;
		Node temp = n;
		Node prev = null;
		Node next = null;
		int min = node.data;
		while (node != null) {
			if (node.next.data < min) {
				prev = node;
				next = node.next;
				min = node.next.data;
				node = node.next;
			} else {
				prev = node;
				node = node.next;
			}
		}

		prev.next = next;
		return null;

	}

	Node alternate(Node node) {
		if (node == null) {
			return null;
		}
		Node etemp = node;
		Node otemp = node;
		Node hetemp = node;
		Node hotemp = node;

		Node tmp = node;
		while (tmp != null) {
			if (tmp.data % 2 == 0) {
				if (hetemp == null) {
					hetemp = tmp;
					etemp = tmp;
				} else {
					etemp.next = tmp;
					etemp = etemp.next;
				}
			} else {
				if (hotemp == null) {
					hotemp = tmp;
					otemp = tmp;
				} else {
					otemp.next = tmp;
					otemp = otemp.next;
				}
			}

			
				tmp = tmp.next;

		}
		Node temp = new Node();
		Node st=temp;
		while (hotemp!=null && hetemp!=null)
		{
			st.next=hotemp;
			st=st.next;
			hotemp= hotemp.next;
			st.next=hetemp;
			st=st.next;
			hetemp=hetemp.next;
		}
		st.next=(hotemp==null)?hetemp:hotemp;
		return temp;

	}

	
}

public class LinkedListApp {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		Node root1 = null;
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root1 = a.insert(1, root1);
		root1 = a.insert(2, root1);
		root1 = a.insert(3, root1);
		root1 = a.insert(2, root1);
		root1 = a.insert(5, root1);
		root1 = a.insert(2, root1);
		root1 = a.insert(7, root1);
		a.printList(root);
		System.out.println();
		Linked.swap1(root1);
		a.printList(root1);
		Node2 node = null;
		node = a.insert(1, node);
		node.random = a.insert(3, node);

		Node2 head = a.createNewNode(1);
		head.next = a.createNewNode(2);
		head.next.next = a.createNewNode(3);
		head.next.next.next = a.createNewNode(4);
		head.next.next.next.next = a.createNewNode(5);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next.next.next;
		head.next.next.next.next.random = head.next;

		// Node2 clone2 = a.getedge(head);

	}
}