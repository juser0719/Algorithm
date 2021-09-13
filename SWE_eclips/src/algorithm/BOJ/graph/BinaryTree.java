// Java program to find maximum path sum in Binary Tree
package algorithm.BOJ.graph;
/* Class containing left and right child of current
node and key value*/
class Res {
	public int val;
}

class BinaryTree {
	
	static public class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	static Node root = new Node(1);

	// This function returns overall maximum path sum in 'res'
	// And returns max path sum going through root.
	int findMaxUtil(Node node, Res res)
	{

		// Base Case
		if (node == null)
			return 0;

		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		int max_top = Math.max(max_single, l + r + node.data);

		res.val = Math.max(res.val, max_top);

		return max_single;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(Node node) {

		// Initialize result
		// int res2 = Integer.MIN_VALUE;
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		// Compute and return result
		findMaxUtil(node, res);
		return res.val;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(1);
		tree.root.right = new Node(-1);
		tree.root.left.left = new Node(-1);
		tree.root.left.right = new Node(-1);
		tree.root.right.right = new Node(1);
		tree.root.right.left = new Node(1);
		tree.root.right.right.left = new Node(-1);
		tree.root.right.right.right = new Node(-1);
		System.out.println("maximum path sum is : " +
							tree.findMaxSum());
	}
}
