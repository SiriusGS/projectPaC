// Binary Tree Elements of programming 

// test if a binary tree is height balanced 

private static class BalanceStatusWithHeight {
	public boolean balanced;
	public int height;
	public BalanceStatusWithHeight(boolean balanced, int height) {
		this.balanced = balanced;
		this.height = height;
	}
}

public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
	return checkBalanced(tree).balanced;
}

private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> root) {
	if (root == null) {
		return new BalanceStatusWithHeight(true, -1);  //base case
	}

	BalanceStatusWithHeight left = checkBalanced(root.left);
	if (!left.balanced) {
		return left;			// left subtree is not balanced
	}
	BalanceStatusWithHeight right = checkBalanced(root.right);
	if(!right.balanced) {    // right subtree is not balanced
		return right;
	}

	boolean isBalanced = Math.abs(left.height - right.height) <= 1;
	int height = Math.max(left.height, right.height) + 1;
	return new BalanceStatusWithHeight(isBalanced, height);
}

// time complexity: O(n)  because every node is visited once
// space complexity: O(h)  the stack height is bounded by the height of the tree
// The function call stack corresponds to a sequence of calls from the root through the unique path to the current node.