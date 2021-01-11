import java.awt.Robot;
import java.util.Random;

public class AVLTree {
	static class Node {
		int data;
		Node left;
		Node right;
		int height;
	}

	static Node root;

	static Node insert(int data) {
		if (root == null) {
			return createNode(data);
		}
		if (data > root.data) {
			root.left = insert(data);
		} else if (data < root.data) {
			root.right = insert(data);
		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		int bf = balancingfactor(root);
		if (bf > 1 && data > root.left.data) {
			return rightrotate(root);
		} else if (bf < -1 && data < root.right.data) {
			return leftrotate(root);
		} else if (bf > 1 && data < root.left.data) {
			return rightleft(root);

		}
		return root;
	}

	private static Node rightleft(Node root2) {
		Node temp = root.left.right;
		Node pr = null;
		if (temp.left != null) {
			pr = temp.left;
		}
		temp.left = root2.left;
		root2.right = pr;

		root2.height = Math.max(height(root2.left), height(root2.right));
		temp.height = Math.max(height(temp.left), height(temp.right));
		return null;
	}

	private static Node leftrotate(Node node) {
		Node temp = node.right;
		Node tc = null;
		if (temp.left != null) {
			tc = temp.left;
		}
		temp.left = node;
		node.right = tc;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
		return temp;

	}

	static int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	static Node rightrotate(Node node) {
		Node temp = node.left;
		Node pc = null;
		if (temp.left != null) {
			pc = temp.left;
		}
		temp.right = node;
		node.left = pc;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		pc.height = Math.max(height(pc.left), height(pc.right)) + 1;
		return pc;
	}

	private static int balancingfactor(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private static Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		return node;
	}

	static void count(String a, int i, String pattern, String value) {

		if (a.length() == i && pattern.length() == 0) {
			System.out.println(1);
			return;
		}
		if (a.length() == i) {
			return;
		}
		char c = a.charAt(i);
		char d = pattern.charAt(0);
		if (c == d) {
			count(a, i + 1, pattern, value);
			count(a, i + 1, pattern.substring(1), value);
		} else {
			count(a, i + 1, pattern, value);
		}
	}

	static void lcs(String a, String b) {
		int dp[][] = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == a.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
	}

	static void maximumrepating(String as) {
		int dp[][] = new int[as.length()][as.length()];

		for (int i = 0; i < as.length(); i++) {
			for (int j = 0; j < as.length(); j++) {
				if (as.charAt(i) == as.charAt(j) && i != j) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = dp[i + 1][j + 1];
				}
			}
		}
	}

	static int eggbreak(int egg, int floor) {
		if (egg == 0) {
			return 0;
		}
		if (egg == 1) {
			return floor;
		}

		for (int i = 0; i < floor; i++) {
			eggbreak(egg - 1, i - floor);
			eggbreak(egg - 1, floor - 1);
		}
		return 0;
	}

	static void atleast(int arr[], int n) throws Exception {
		if (arr.length < n) {
			throw new Exception("Value length is smaller");
		}
		int j = 0;
		int i = 0;
		int max = 0;
		int sum = 0;
		int k = 0;
		while (i != arr.length - 1) {
			if (j != n) {
				while (sum < 0 && j != 0 && k < i) {
					sum = sum - arr[k];
					j--;
					k++;
				}
				sum = sum + arr[i];
				i++;
				j++;
			} else if (j == n) {
				max = Math.max(sum, max);
				sum = sum - arr[k];
				j--;
				k++;
			}
			
		}
		System.out.println(max);

	}

	public static void main(String... args) throws Exception {
		int arr[] = { 1, 2, 3, 4, -17, 8, 10, -2, 3, -26 };
		atleast(arr, 3);
	}
}
