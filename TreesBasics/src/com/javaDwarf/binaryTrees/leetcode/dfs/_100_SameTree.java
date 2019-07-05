package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.TreeNode;

public class _100_SameTree {

	public static void main(String[] args) {

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p == null && q == null) {
			return true;
		}
		else if((p== null && q!=null) || ( p!= null && q==null) ||
				(p!= null && q!=null && p.val != q.val)){
			return false;
		}
		
		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

	}

}
