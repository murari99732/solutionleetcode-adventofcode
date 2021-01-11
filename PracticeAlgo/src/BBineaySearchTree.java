import java.util.HashSet;

public class BBineaySearchTree {

	static TreeValue delete(TreeValue tree, int value) {
		if (tree == null) {
			return null;
		}
		if (value > tree.value) {
			tree.left = delete(tree.left, value);
		} else if (value < tree.value) {
			tree.right = delete(tree.right, value);
		} else {
			if (tree.left == null || tree.right == null) {
				TreeValue curr = null;
				curr = tree.left != null ? tree.left : tree.right;
				if (curr != null) {
					return curr;
				} else {
					return null;
				}
			} else {
				TreeValue curr = successor(tree);
				if (curr != null) {
					curr.value = tree.value;
					tree.right = insert(tree.left, curr.value);
				}

			}
		}
		return tree;
	}

	static boolean check(TreeValue tree, int value) {
		if (tree == null) {
			return false;
		}
		while (tree != null) {
			if (tree.value > value) {
				tree = tree.left;
			} else if (tree.value < value) {
				tree = tree.right;
			} else {
				return true;
			}
		}
		return true;
	}

	static TreeValue parent(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue prev = null;
		while (tree != null) {
			if (tree.left != null) {
				prev = tree;
				tree = tree.left;
			} else if (tree.right != null) {
				prev = tree;
				tree = tree.right;
			} else {
				prev = tree;
				break;

			}
		}
		return prev;
	}

	static TreeValue inorderParent(TreeValue tree, int value) {
		if (tree == null) {
			return null;
		}

		TreeValue parent = null;
		while (tree != null) {
			if (tree.value > value) {
				parent = tree;
				tree = tree.left;
			} else if (tree.value < value) {
				tree = tree.right;

			} else {

			}
		}
		return parent;
	}

	static int count = 0;

	static TreeValue getKthSmallest(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue tr = getKthSmallest(tree.left);
		if (tr != null) {
			return tr;
		}
		count++;
		if (count == 2) {
			return tree;
		}
		return getKthSmallest(tree.right);
	}

	static TreeValue prev = null;

	static boolean binary(TreeValue tree) {
		if (tree == null) {
			return false;
		}
		if (!binary(tree.left)) {
			return false;
		}
		if (prev != null && prev.value > tree.value) {
			return false;
		}
		prev = tree;
		return binary(tree.right);
	}

	static TreeValue BSTfromPostorder(int post[], int start, int end, TreeValue tree) {
		if (tree == null) {
			return null;
		}
		int value = post[post.length - 1];
		int i;
		for (i = post.length - 1; i > 0; i++) {
			if (value > post[i]) {
				break;
			}
		}
		tree.left = BSTfromPostorder(post, start, i, tree);
		tree.right = BSTfromPostorder(post, i + 1, end, tree);
		return tree;

	}

	static void lca(TreeValue tree, int value, int word) {
		if (tree == null) {
			return;
		}
		while (tree != null) {
			if (value > tree.value && word > tree.value) {
				tree = tree.left;
			} else if (value > tree.value && word > tree.value) {
				tree = tree.left;
			} else {
				System.out.println(tree.value);
			}
		}
	}

	static TreeValue inorderParentsuccesor(TreeValue tree, int value) {
		if (tree == null) {
			return null;
		}
		TreeValue parent = null;
		while (tree != null) {
			if (tree.value > value) {
				parent = tree;
				tree = tree.left;
			} else if (tree.value < value) {
				parent = tree;
				tree = tree.right;
			} else {
				if (parent.right != null) {
					TreeValue curr = successor(parent);
					curr = parent;
					break;
				}
			}
		}
		return parent;
	}

	private static TreeValue successor(TreeValue tree) {
		if (tree == null) {
			return null;
		}
		TreeValue curr = tree.right;
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}

	static void AVL(TreeValue tree, int value) {
		TreeValue st = insert(tree, value);
		TreeValue v = height(st, value);
		if (v != null) {
		
		}
	}



	static TreeValue insert(TreeValue tree, int value) {
		if (tree == null) {
			return createNode(value);
		}

		if (tree.value < value) {
			insert(tree.left, value);
		}
		if (tree.value > value) {
			insert(tree.right, value);
		}

		return tree;
	}

	private static TreeValue createNode(int value) {
		// TODO Auto-generated method stub
		return null;
	}

	static TreeValue height(TreeValue tree, int value) {
		if (tree == null) {
			return null;
		}
		TreeValue t = height(tree.left, value + 1);

		TreeValue s = height(tree.right, value + 1);
		if (Math.abs(s.value - t.value) > 2) {
			return tree;
		}
		return tree != null ? tree.left : tree.right;

	}

	static TreeValue avlTree(TreeValue tree, int value) {
		if (tree == null) {
			return createNode(value);
		}
		if (tree.value > value) {
			tree.left = avlTree(tree.left, value);
		} else if (tree.value > value) {
			tree.right = avlTree(tree.right, value);
		}
		return tree;
	}

	public static void main(String[] args) {

	}
}
