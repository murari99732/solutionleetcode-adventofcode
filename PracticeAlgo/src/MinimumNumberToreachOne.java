class Node8 {
	Node8 down;
	Node8 right;
	int data;
}

class Node1 {
	Node1 left;
	int data;
}

class Linked {

	static Node8 flatten(Node8 ab) {
		if (ab == null || ab.right == null) {
			return ab;
		}
		
		return merge(ab, ab.right);

	}

	private static Node8 merge(Node8 ab, Node8 right) {
		Node8 temp = new Node8();
		Node8 f=temp;
		while(ab!=null && right!=null)
		{
			if(ab.data>right.data)
			{
				temp.down=ab;
				ab=ab.down;
				temp=temp.down;
			}
			else 
			{
				temp.down=right;
				right=right.down;
				temp=temp.down;
			}
		}
		return null;
	}

	public static Node1 getNewNode1(int key) {
		Node1 a = new Node1();
		a.left = null;
		a.data = key;
		return a;
	}

	/*
	 * It'll get size of linked list
	 */
	public boolean getSizeOfList(Node8 node, int count) {
		if (node == null) {
			return false;
		}
		if (node.data == count) {
			return true;
		}
		return getSizeOfList(node.down, count);
	}

	/*
	 * getNewNode() method to generate a new node
	 */
	public Node8 getNewNode(int key) {
		Node8 a = new Node8();
		a.down = null;
		a.data = key;
		return a;
	}

	/*
	 * insert method is used to insert the element in Linked List
	 */
	public Node8 insert(int key, Node8 node) {

		if (node == null)
			return getNewNode(key);
		else
			node.down = insert(key, node.down);

		return node;
	}

	public void printList(Node8 node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.down);
	}
}

public class MinimumNumberToreachOne {

	public static void main(String[] args) {

		Node8 root = null;
		Linked a = new Linked();

		root = a.insert(12, root);
		root = a.insert(99, root);
		root = a.insert(37, root);
		root.right=a.insert(44, root.right);
		root.right=a.insert(55, root.right);
		root.right.right=a.insert(11, root.right.right);
		root.right.right=a.insert(43, root.right.right);

		a.printList(root);
		System.out.println();

		System.out.println(a.getSizeOfList(root, 990));

	}
}