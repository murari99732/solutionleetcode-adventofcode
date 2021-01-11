import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	static Node ancestors(Node n, int arr[], int level, int data) {
		if (n == null) {
			return null;
		}
		arr[level] = n.data;
		if (n.data == data) {
			arr[level] = data;
			return n;
		}
		Node l = ancestors(n.left, arr, level + 1, data);
		if (l != null) {
			return l;
		}
		l = ancestors(n.right, arr, level + 1, data);
		return l;

	}

	static int position = 0;

	static boolean ancestors2(Node n, int node, int node1, int level) {
		if (n == null) {
			return true;
		}

		if (n.left != null && n.left.data == node) {
			if (n.right != null && n.right.data != node1) {
				position = level;
			}

		}
		if (n.right != null && n.right.data == node && position == level) {
			if (n.left != null && n.left.data != node1) {
				System.out.println(true);
				return true;
			}
		}
		boolean b = ancestors2(n.left, node, node1, level + 1);
		if (b) {
			return b;
		}

		b = ancestors2(n.right, node, node1, level + 1);
		return b;
	}

	public Node createNewNode(int val) {
		Node newNode = new Node();
		newNode.data = val;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	static Node Lca(Node n, int data, int value) {
		if (n == null) {
			return null;
		}
		if (n.data == data || n.data == value) {
			return n;
		}
		Node left = Lca(n.left, data, value);
		Node right = Lca(n.right, data, value);
		if (left != null && right != null) {
			return n;
		}
		return left != null ? left : right;

	}

	static void distanceFrom(Node n, int data, int value) {
		Node node = Lca(n, data, value);

	}

	static int h = 0;

	private static int distance(Node node, Node target, int data, int i) {

		return 0;
	}

	static int distanceFromLeaf(Node node, int sum) {
		if (node == null) {
			return 0;
		}
		sum = sum + node.data;
		int p = distanceFromLeaf(node.left, sum);
		int c = distanceFromLeaf(node.right, sum);
		return p + c;
	}

	static void serialize(Node node, int level, List<Integer> ar) {
		if (node == null) {
			ar.add(-1);
			return;

		}
		ar.add(node.data);
		serialize(node.left, level + 1, ar);
		serialize(node.right, level + 1, ar);
	}

	static Node desiralize(List<Integer> ar, int index) {
		if (ar.get(index) == -1) {
			return null;
		}
		Node head = null;

		head.left = desiralize(ar, index + 1);
		head.right = desiralize(ar, index + 1);
		return head;

	}

	static Node head = null;
	static Node prev = null;

	static void convertBst(Node node) {
		if (node == null) {
			return;
		}
		convertBst(node.left);
		if (head == null) {
			head = node;
			prev = node;

		} else {
			node.left = prev;
			prev.right = node;
			prev = prev.right;

		}
		convertBst(node.right);

	}
	
	static void getrightNode(Node n,int data)
	{
		Queue<Node> q= new LinkedList<Node>();
		
		q.add(n);
		while(true)
		{
			Boolean flag= false;
			int size=q.size();
			if(size==0 && flag==true)
			{
				break;
			}
			while(size>0)
			{
				Node curr=q.poll();
				if(flag==true)
				{
					return;
				}
				if(curr.data==data)
				{
					flag= true;
				}
				if(curr.left!=null)
				{
					q.add(curr.left);
				}
				if(curr.right!=null)
				{
					q.add(curr.right);
				}
				size--;
			}
			
		}
		
	}


	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();

		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		int arr[] = new int[10];

		for (int j : arr) {
			System.out.println(j);
		}

	}
}
