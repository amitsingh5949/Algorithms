package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _669_TrimaBinarySearchTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n3.left = n1;
		n3.right = n4;
		n1.right = n2;

		TreeNode result = new _669_TrimaBinarySearchTree().trimBST(n3, 3, 4);
		System.out.println(result);
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {

		if(root == null)  return root;

		while(root.val > R || root.val < L) {
			if(root.val > R) {
				root = root.left;
			}
			else if(root.val < L) {
				root = root.right;
			}
		}

		if(root == null)  return root;

		while(root.left != null && root.left.val < L) {
			root.left = root.left.right;
		}

		while(root.right != null && root.right.val > R) {
			root.right = root.right.left;
		}

		trimBST(root.left, L, R);
		trimBST(root.right, L, R);

		return root;

	}

}
