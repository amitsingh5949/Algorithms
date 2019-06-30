package com.javaDwarf.binaryTrees.leetcode.bst;

import java.util.HashSet;
import java.util.Set;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _653_TwoSumInBST {
	
	// since its a bst , we can traverse it inorder an store it in list then use two pointers to find the pair

	public boolean findTarget(TreeNode root, int k) {

		if(root==null) return false;
		
		return findTarget(root, k, new HashSet<Integer>(), false);
		
	}
	
	public boolean findTarget(TreeNode root, int k, Set<Integer> set, boolean result ) {
		
		if(root == null)  return result;
		
		if(set.contains(k - root.val)) {
			return true;
		}
		else {
			set.add(root.val);
		}
		
		return findTarget(root.left, k, set, result) || findTarget(root.right, k, set, result) ;

	}

}
