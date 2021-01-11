
public class BinarySearchTree {

	static Node insert(Node node, int value) {
		if (node == null) {
			return createNewNode(value);
		} else {
			if (node.data > value)
				node.left = insert(node.left, value);
			if (node.data > value)
				node.right = insert(node.right, value);
		}
		return node;
	}

	public static Node createNewNode(int k) {
		Node a = new Node();
		a.data = k;
		a.left = null;
		a.right = null;
		return a;
	}

	public static void main(String[] args) {
		BinarySearchTree a = new BinarySearchTree();
		Node root = null;

		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 7);
		root = a.insert(root, 1);
		root = a.insert(root, 14);
		root = a.insert(root, 13);

		print(root);

	}

	static Node delete(Node root, int value) {
		if (root == null) {
			return null;
		}
		if (root.data > value) {
			root.right=delete(root.right, value);

		} else if (root.data < value) {
			root.left=delete(root.left, value);
		}
		else
		{
			if(root.left==null || root.right==null)
			{
				Node temp=root.left!=null?root.left:root.right;
				if(temp!=null)
				{
					return null;
				}
				else
				{
					return root;
				}
			}
			else
			{
				Node temp=successor(root.left);
				root.data=temp.data;
				temp=null;
				
			}
		}
		return root;
	}

	private static Node successor(Node left) {
		if(left.right!=null)
		{
			while(left!=null)
			{
				left=left.left;
			}
		}
		return left;
	}

	private static void print(Node root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);

	}

}
