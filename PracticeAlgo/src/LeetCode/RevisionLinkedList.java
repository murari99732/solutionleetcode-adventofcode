package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RevisionLinkedList {

	static class Node {
		int data;
		Node next;
		Node random;
	}

	static Node createNode(int value) {
		Node n = new Node();
		n.data = value;
		return n;
	}

	static Node insert(Node node, int value) {
		if (node == null) {
			return createNode(value);
		}
		return insert(node.next, value);
	}

	static void display(Node node) {

		System.out.println();
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

	}

	static Node p = null;
	static Node headlinked = null;

	static void displayDepthwise(Node node) {
		if (node == null) {
			return;
		}

		if (headlinked == null) {
			headlinked = node;
			p = headlinked;
		} else if (node != null) {
			p.next = node;
			p = node;
		}
		if (node.random != null)
			displayDepthwise(node.random);
		if (node.next != null) {
			p.next = node.next;
			p = p.next;
		}
		if (node.next != null)
			displayDepthwise(node.next);

	}

	private static Node insertatLast(Node node, int value, int position) {
		if (position > size(node)) {
			return null;
		}
		if (node == null) {
			return null;
		}

		if (position == 0) {
			Node temp = createNode(value);

			temp.next = node;

			return temp;
		}

		node.next = insertatLast(node.next, value, position - 1);
		return node;

	}

	private static int size(Node node) {
		if (node == null) {
			return 0;
		}

		return size(node.next) + 1;
	}

	static void rotatelinkedlist(Node node) {
		Node root = node;
		int i = 2;
		while (root.next != null && i != 0) {
			i--;
			root = root.next;
		}

		Node temp = root.next;
		root.next = null;
		Node ptr = temp;

		while (ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = node;

		display(temp);

	}

	private static Node recursive(Node node) {
		if (node.next == null || node == null) {
			return node;
		}
		Node temp = recursive(node.next);
		node.next.next = node;
		node.next = null;

		return temp;
	}

	static Node getmiddle(Node node) {
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

	static Node sort(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node middle = getmiddle(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return mergesort(sort(node), sort(secondHalf));
	}

	private static Node mergesort(Node a, Node b) {
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

	public static Node removeDuplicateSortedList(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		if (node.data == node.next.data) {
			node.next = node.next.next;
			removeDuplicateSortedList(node);
		} else {
			removeDuplicateSortedList(node.next);
		}

		return node;
	}

	static Node duplicate(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		if (node.data == node.next.data) {
			node.next = node.next.next;
			duplicate(node);
		} else {
			duplicate(node.next);
		}
		return node;

	}

	static void duplicatemanually(Node node) {
		Node temp = node;
		while (node != null && node.next != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		display(temp);
	}

	static Node flattenlist(Node node) {
		Node first = getmiddle(node);
		Node secondNode = first.next;
		first.next = null;

		return mergesort(flattenlist(first), flattenlist(secondNode));
	}

	static void removehash(Node node) {
		Set<Integer> set = new HashSet<>();
		while (node != null) {
			if (!set.contains(node.data)) {
				set.add(node.data);
			}
			node = node.next;

		}
		System.out.println(set);
	}

	static void checkloop(Node node) {
		Node fast = node;
		Node slow = node;
		while (fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				System.out.println("loop found");
				break;
			}
		}

		while (node != fast) {
			node = node.next;
			if (node.next == fast) {
				node.next = null;
			}
		}

	}

	static void deletemiddle(Node node) {
		int height = size(node) / 2;
		Node temp = node;
		while (node != null) {
			if (height == 1) {
				node.next = node.next.next;
			} else
				node = node.next;
			height--;
		}
		display(temp);
	}

	static void deletemiddleval(Node node) {
		Node fast = node;
		Node slow = node;
		Node prev = null;
		while (fast.next != null && slow != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		prev.next = slow.next;
		display(node);

	}

	static void deletefromright(Node node) {

		Node root = recursive(node);
		display(root);
		Node head = root;
		Node prev = null;
		int max = 0;
		while (head != null) {

			if (max == 0) {
				max = head.data;
				prev = head;
				head = head.next;
			} else {
				if (head.data > max) {
					prev = head;
					head = head.next;
				} else {
					prev.next = head.next;
					head = prev.next;

				}
			}
		}
		display(root);
	}

	static void swap(Node node) {
		Node head = node;
		while (head.next != null) {
			int temp = head.next.data;
			head.next.data = head.data;
			head.data = temp;
			head.next = head.next.next;
			head = head.next;
		}
		display(node);
	}

	static void swapnode(Node node, int first, int second) {
		Node head = node;
		Node fprev = null;
		Node fnext = null;
		Node sprev = null;
		Node snext = null;
		boolean flag = false;
		boolean flag2 = false;
		while (node != null && flag2 == false || flag == false) {

			if (node.data == first) {
				fnext = node.next;
				flag = true;
			}
			if (node.data == second) {
				snext = node.next;
				flag2 = true;
			}
			if (flag == false) {
				fprev = node;
				node = node.next;
			} else if (flag2 == false) {
				sprev = node;
				node = node.next;
			}
			if (flag == true && flag2 == true) {
				Node p = fprev.next;
				Node r = sprev.next;
				fprev.next = r;
				r.next = fnext;
				sprev.next = p;
				p.next = snext;

			}

		}
		display(head);

	}

	static void iterative(Node node) {
		Node prev = null;
		while (node != null) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		display(node);
	}

	static Node reversegroup(Node node, int k) {

		Node prev = null;
		Node head = node;
		int i = 0;
		while (node != null && i != k) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}
		if (node != null) {
			head.next = reversegroup(node, k);
		}
		return prev;

	}

	static Node reversealte(Node node, int k) {
		Node prev = null;
		Node head = node;
		int i = 0;
		while (node != null && i != k) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}
		i = 0;
		while (node != null && i != k) {
			node = node.next;
			i++;
		}
		if (node != null) {
			node.next = reversealte(node, k);
		}
		return prev;

	}

	static Node pairwise(Node node) {
		Node prev = null;
		Node head = node;
		int i = 0;
		while (node != null && i != 2) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		if (node != null) {
			head.next = pairwise(node);
		}
		return prev;

	}

	static void pairwiseswap(Node node) {
		Node head = node;
		while (head != null && node.next != null) {
			int temp = node.data;
			node.data = node.next.data;
			node.next.data = temp;
			node = node.next.next;
		}
		display(head);
	}

	static void addone(Node node) {
		int value = getAdditon(node);
		if (value == 1) {
			Node n = createNode(1);
			n.next = node;
			display(n);
		} else {
			display(node);
		}

	}

	static int carry = 0;

	private static int getAdditon(Node node) {
		if (node == null) {
			return 1;
		}
		int value = node.data + getAdditon(node.next);
		node.data = value % 10;
		return value / 10;
	}

	static void gettriplet(Node node, Node first, Node sec, int sum) {
		first = sort(first);
		sec = recursive(sort(sec));

		while (node != null) {

			while (first != null && sec != null) {
				int val = node.data + first.data + sec.data;
				if (val == sum) {
					System.out.println(node.data + "" + first.data + " " + sec.data);
				} else if (val > sum) {
					sec = sec.next;
				} else if (val < sum) {
					first = first.next;
				}
			}
			node = node.next;
		}
	}

	static void addtwonumber(Node first1, Node sec1) {
		Node first = recursive(first1);
		display(first);
		Node sec = recursive(sec1);
		display(sec);
		int carry = 0;
		Node result = null;
		Node head = null;
		while (sec != null || first != null) {
			int val = (sec != null ? sec.data : 0) + (first != null ? first.data : 0) + carry;
			int c = val % 10;
			carry = val / 10;
			if (head == null) {
				head = createNode(c);
				result = head;
			} else {
				result.next = createNode(c);
				result = result.next;
			}
			if (first != null) {
				first = first.next;
			}
			if (sec != null) {
				sec = sec.next;
			}

		}
		if (carry != 0) {
			Node n = createNode(carry);
			n.next = head;
			display(n);
		} else
			display(head);
	}

	static void substract(Node first, Node sec) {
		first = recursive(first);
		sec = recursive(sec);
		boolean flag = getsize(first, sec);
		Node greater = null;
		Node smaller = null;
		if (flag) {
			greater = first;
			smaller = sec;
		} else {
			smaller = first;
			greater = sec;
		}
		int carry = 0;
		Node head = null;
		Node result = null;
		while (smaller != null || greater != null) {
			int val = 0;
			boolean fl = false;
			if (greater.data > (smaller != null ? smaller.data : 0)) {
				val = greater.data - (smaller != null ? smaller.data : 0) - carry;
			} else {
				fl = true;
				val = 10 + greater.data - (smaller != null ? smaller.data : 0) - carry;
			}
			if (fl = true) {
				carry = 1;
			}
			if (head == null) {
				head = createNode(val);
				result = head;

			} else {
				result.next = createNode(val);
				result = result.next;

			}
			if (smaller != null) {
				smaller = smaller.next;
			}
			if (greater != null) {
				greater = greater.next;
			}

		}

	}

	private static boolean getsize(Node first, Node sec) {
		int height = size(first);
		int height2 = size(sec);
		if (height > height2) {
			return true;
		} else if (height < height2)
			return false;
		else {
			while (first != null && sec != null) {
				if (first.data > sec.data) {
					return true;
				} else if (first.data < sec.data) {
					return false;
				}
			}
		}
		return false;
	}

	static void sortedklist(ArrayList<Node> node) {
		int i = 0;
		int j = node.size();
		while (i != j) {
			Node a = node.get(i);
			Node b = node.get(j);
			Node c = mergesort(a, b);
			node.add(0, c);
			node.remove(1);
		}
	}

	static void countpair(Node first, Node sec) {
		Set<Integer> set = new HashSet<>();
		while (first != null) {
			set.add(first.data);
			first = first.next;
		}

		while (sec != null) {
			if (set.contains(10 - sec.data)) {
				System.out.println(true);
			}
		}
	}

	static void checkevenorodd(Node fast) {

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
		}
		if (fast == null) {
			System.out.println("odd");
		} else if (fast.next == null) {
			System.out.println("even");
		}
	}

	static void removekth(Node node, int k) {
		Node head = node;
		Node prev = null;
		while (node != null && node.next != null) {
			int i = 0;

			while (node != null && i != k) {
				prev = node;
				node = node.next;
				i++;
			}
			if (node != null) {
				prev.next = node.next;
				prev = prev.next;
				node = prev;

			}
			i = 0;
		}
		display(head);

	}

	static void sortedabsolute(Node node) {
		Node head = node;
		Node prev = null;
		while (node != null) {
			if (node.data > 0) {
				prev = node;
				node = node.next;
			} else {

				prev.next = node.next;
				node.next = null;
				Node p = node;
				p.next = head;
				head = p;
				prev = prev.next;
				node = prev;
			}
		}
		display(head);
	}

	static Node kthremove(Node node) {
		Node prev = null;
		Node head = node;
		int i = 0;
		while (node != null && i != 2) {
			prev = node;
			node = node.next;
			i++;
		}
		if (node != null) {
			prev.next = node.next;
			prev = prev.next;
			node = prev;
			head.next = kthremove(node);
		}
		return head;

	}

	static void deleteonly(Node node) {
		Node head = node;
		Node prev = null;
		while (node != null && node.data != 10) {
			prev = node;
			node = node.next;
		}
		prev.next = node.next;
		prev = prev.next;
		node = prev;
		display(head);
	}

	static void lastoccurence(Node node) {
		Node start = recursive(node);
		Node temp = start;
		Node prev = null;
		while (start != null && start.data != 4) {
			prev = start;
			start = start.next;
		}
		prev.next = start.next;
		prev = prev.next;
		start = prev;
		display(temp);

	}

	static void alreadysorted(Node node) {
		Node prev = null;
		Node head = node;
		Node p = null;
		while (node != null) {
			if (node.data > 0) {
				prev = node;
				node = node.next;
			} else {
				prev.next = node.next;
				prev = prev.next;
				node.next = head;
				p = node;
				node.next = null;
				node = prev;
				p.next = head;

			}
		}
		display(p);

	}

	static void clonelinked(Node node) {
		Node head = node;
		while (node != null) {
			Node p = createNode(node.data);
			Node r = node.next;
			node.next = p;
			p.next = r;
			node = r;
		}

		while (node != null) {
			node.next.random = node.random.next;
			node = node.next.next;

		}
		display(head);
		Node even = null;
		Node odd = null;
		Node heade = null;
		Node odde = null;
		int i = 0;
		node = head;
		int k = size(node);
		while (node != null && i != k) {
			if (i % 2 != 0) {
				if (heade == null) {
					heade = node;
					even = heade;
				} else {
					even.next = node;
					even = even.next;
				}
				node = node.next;

			} else {
				if (odde == null) {
					odde = node;
					odd = odde;
				} else {

					odd.next = node;
					odd = odd.next;
				}
				node = node.next;
			}
			i++;
		}

		display(heade);
		display(odde);
	}

	static void moveorcur(Node node, int data) {
		Node prev = null;
		Node head = recursive(node);
		Node root = head;
		Node p = null;
		while (root != null) {
			if (root.data != data) {
				prev = root;
				root = root.next;
			} else {
				prev.next = root.next;
				prev = prev.next;
				root.next = head;
				p = root;
				root.next = null;
				root = prev;
				p.next = head;

			}
		}
		display(p);
	}

	static void flatten(Node node) {
		Node root = node;
		while (node.next != null) {
			node = node.next;
		}
		Node ptnode = root;
		while (ptnode != null) {
			if (ptnode.random != null) {
				node.next = ptnode.random;
			}
			while (node != null) {
				node = node.next;
			}
			ptnode = ptnode.next;
		}
	}

	static Node headNode = null;
	static Node prev = null;

	static void flattenw(Node node) {
		if (node == null) {
			return;
		}
		if (headNode == null) {
			headNode = node;
			prev = headNode;
		}
		prev.next = node;
		prev = node;
		flattenw(node.random);
		if (node.next != null) {
			prev.next = node;
			prev = prev.next;
		}
		flattenw(node.next);

	}

	static void nextrandom(Node node) {
		Stack<Node> st = new Stack<>();
		Node head = recursive(node);
		Node root = head;

		while (root != null) {
			if (st.isEmpty()) {
				st.push(root);
			} else if (st.peek().data > root.data) {
				root.random = st.peek();
				st.push(root);
			} else {
				while (st.peek().data < root.data) {
					st.pop();

				}
				root.random = st.peek();
				st.push(root);
			}
			root = root.next;

		}
	}

	static void clonelinkednode(Node node) {
		HashMap<Node, Node> map = new HashMap<>();
		Node start = node;
		Node head = null;
		Node root = null;
		while (node != null) {
			Node n = createNode(node.data);
			if (head == null) {
				head = n;
				root = head;
			} else {
				root.next = n;
				root = root.next;
			}
			map.put(node, root);
			node = node.next;
		}
		Node f = head;
		Node s = start;
		while (start != null) {
			if (start.random != null) {
				head.random = map.get(start.random);
			}
			start = start.next;
			head = head.next;
		}

	}

	public static void main(String[] args) {
		Node node = new Node();
		node = insert(node, 1);
		node.next = insert(node.next, 2);
		node.next.next = insert(node.next.next, 3);
		node.next.next.next = insert(node.next.next.next, 8);
		node.next.next.next.next = insert(node.next.next.next.next, 4);
		node.next.next.next.next.next = insert(node.next.next.next.next.next, 5);
		node.next.next.next.next.next.next = insert(node.next.next.next.next.next.next, 10);
		node.next.next.next.next.next.next.next = insert(node.next.next.next.next.next.next.next, 11);
		// node.next.next.next.next.next.next.next.next =
		// insert(node.next.next.next.next.next.next.next.next, 12);

		display(node);
		// deleteonly(node);
		clonelinkednode(node);

	}

}
