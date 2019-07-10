package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


// if we need to find all the cousins then we need to take a map of element and depth and a map of element and parent
public class _993_CousinsinBinaryTree {

	int d1 = -1;
	int d2 = -2;
	int p1 = -1;
	int p2 = -1;

	public boolean isCousins(TreeNode root, int x, int y) {

		if( root == null) return false;
		this.d1 = -1;
		this.d2 = -2;
		this.p1 = -1;
		this.p2 = -1;
		findDepthAndParent(root, x, y, 1);
		if((d1 == d2) && (p1 != p2)){
			return true;
		}
		return false;
	}
	
	public void findDepthAndParent(TreeNode root, int x, int y, int currDepth) {
		
		if( root == null) return;
		
		if( (root.left != null && root.left.val == x ) || (root.right != null && root.right.val == x) ){
			this.d1 = currDepth +1;
			p1 = root.val;
		}
		if( (root.left != null && root.left.val == y ) || (root.right != null && root.right.val == y) ){
			this.d2 = currDepth +1;
			p2 = root.val;
		}
		findDepthAndParent(root.left, x, y, currDepth+1);
		findDepthAndParent(root.right, x, y, currDepth+1);
	}
}
