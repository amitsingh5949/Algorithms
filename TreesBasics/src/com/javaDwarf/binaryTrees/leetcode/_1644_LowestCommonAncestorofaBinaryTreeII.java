package com.javaDwarf.binaryTrees.leetcode;

public class _1644_LowestCommonAncestorofaBinaryTreeII {

	// idea is we are expecting two trues from left and right sub tree if the numbers are found and 1 true can be expected if the root itself is p or q
	// so if count is 2 or more that means its an LCA, however if count > 0 that means its not LC but this subtree should return true
	TreeNode result;
	public TreeNode lowestCommonAncestor11(TreeNode root, TreeNode p, TreeNode q) {
		helper(root,p,q);
		return result;
	}

	private boolean helper(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return false;
		int count = 0;
		count += helper(root.left,p,q)?1:0;
		count += helper(root.right,p,q)?1:0;
		count += (root.val==p.val ||root.val==q.val)?1:0;
		if(count>1)result=root;
		return count>0;
	}
	
	//TODO the follow up question in leetcode 1644
	//Can you find the LCA traversing the tree, without checking nodes existence?

}
