package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _814_BinaryTreePruning {

	public static void main(String[] args) {

	}

	public TreeNode pruneTree(TreeNode root) {
		
		if(root == null) return null;
		
		hasOneInSubTree(root);
		
		if(root.val == 0 && root.left == null && root.right == null) return null;
		
		return root;

	}
	
   public boolean hasOneInSubTree(TreeNode root) {
	   
	   if(root == null ) return false;
	   
	   boolean left = hasOneInSubTree(root.left);
	   
	   boolean right = hasOneInSubTree(root.right);
	   
	   if(!left)
		   root.left = null;
	   if(!right)
		   root.right = null;
	   
	   return (root.val == 1 ) || left || right;

	}
	

}
