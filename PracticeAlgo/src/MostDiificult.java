import java.util.ArrayList;

public class MostDiificult {
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static DoubleLinkedList doublell = new DoubleLinkedList();
	static DoubleLinkedList prevValue;

	static void printfromKnodes(TreeValue tree) {
		if (tree == null) {
			return;
		}
	}

	static int max = 0;

	static int maximumleave(TreeValue tree, int sum) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return sum;
		}
		int tr = maximumleave(tree.left, sum + tree.value);
		int lr = maximumleave(tree.right, sum + tree.value);
		if (tr != 0 && lr != 0) {

		}
		return 0;
	}

	static int maximumpathsum(TreeValue tree, int sum) {
		if (tree == null) {
			return 0;
		}
		if (tree.left == null && tree.right == null) {
			return sum;
		}
		int lt = maximumpathsum(tree.left, sum + tree.value);
		int rt = maximumpathsum(tree.right, sum + tree.value);
		if (lt != 0 && rt != 0) {
			int maxone = Math.max(lt, rt) + tree.value;
			int maxsecond = Math.max(maxone, lt + rt + tree.value);
			max = Math.max(maxsecond, max);
			return maxsecond;
		} else {
			return rt != 0 ? lt + tree.value : rt + tree.value;
		}
	}

	static int diameter(TreeValue tree) {
		if (tree == null) {
			return 0;
		}

		int tr = diameter(tree.left);
		int st = diameter(tree.right);
		max = Math.max(max, tr + st + 1);
		return Math.max(tr, st) + 1;
	}

	static void doubleTree(TreeValue tree) {

		if (tree == null) {
			return;
		}
		doubleTree(tree.left);
		DoubleLinkedList curr = createDouble(tree.value);
		if (doublell == null) {
			doublell = curr;
			prevValue = doublell;
		} else {
			prevValue.next = curr;
			curr.prev = prevValue;
			prevValue = curr;
		}

	}

	private static DoubleLinkedList createDouble(int value) {

		DoubleLinkedList d = new DoubleLinkedList();
		d.value = value;
		return d;
	}

	static void serilaize(TreeValue tree) {

		if (tree == null) {
			array.add(-1);
			return;
		}
		array.add(tree.value);
		serilaize(tree.left);
		serilaize(tree.right);

	}

	static TreeValue prev = null;

	static boolean BST(TreeValue tree) {
		if (tree == null) {
			return true;
		}

		if (!BST(tree.left)) {
			return false;
		}
		if (prev != null && prev.value > tree.value) {
			return false;
		}
		prev = tree;
		return BST(tree.right);

	}

	static TreeValue desirialize(TreeValue tree, ArrayList<Integer> arr, int i) {
		if (i == arr.size()) {
			return tree;
		}
		TreeValue curr = Binary.createNode(arr.get(i));
		curr.left = desirialize(curr.left, arr, i + 1);
		curr.right = desirialize(curr.right, arr, i + 1);
		return curr;

	}

	public static void main(String[] args) {
		TreeValue tree = Binary.createNode(12);
		tree.left = Binary.createNode(9);
		tree.right = Binary.createNode(13);
		tree.left.left = Binary.createNode(5);
		tree.left.right = Binary.createNode(10);

		System.out.println(getSum(tree, 0));

//		tree.right.left = createNode(7);
//		tree.right.right = createNode(8);
//		tree.right.left.left = createNode(10);
//		tree.right.left.left.left = createNode(25);
//		tree.right.left.left.left.left = createNode(35);
	}
	
	static int getSum(TreeValue tree, int sum)
	{
		if(tree==null)
		{
			return 0;
		}
		if(tree.left==null && tree.right==null)
		{
			return 1;
		}
		int t=getSum(tree.left, sum);
		int r=getSum(tree.right, sum);
		return t+r;
	}
	

	
}
