package LeetCode;

public class PracticeDP {

	static class Tree {
		int data;
		Tree left;
		Tree right;
		int height;
	}

	

	private static Tree rrotation(Tree root) {
		Tree tree = root.right;
		Tree tr = tree.left;
		tree.left = root;
		root.right = tr;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
		return tree;
	}

	private static Tree llrotation(Tree root) {
		Tree tree = root.left;
		Tree tr = tree.right;
		tree.right = root;
		root.left = tr;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
		return tree;
	}

	static int height(Tree root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private static int balancefactor(Tree root) {

		return height(root.left) - height(root.right);
	}

	private static Tree createtree(int value) {
		Tree tree = new Tree();
		tree.data = value;
		return tree;
	}

	public static void main(String[] args) {

	}

}
