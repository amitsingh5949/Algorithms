package com.javaDwarf.binaryTrees.leetcode.dfs;


import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _101_SymmetricTree {
	
	//Recursive solution 
	public boolean isSymmetric(TreeNode root) {
		if( root == null ) return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		
		if(left == null && right == null){
			return true;
		}
		if((left == null && right != null)  || (left != null && right == null) || ( left.val != right.val ) ) {
			return false;
		}
		
		boolean leftRightSymmtry =  isSymmetric(left.left, right.right);
		boolean rightLeftSymmtry =  isSymmetric(left.right, right.left);
		
		return leftRightSymmtry && rightLeftSymmtry;
	}
	
	

	//Iterative solution - in bfs package
	

}
