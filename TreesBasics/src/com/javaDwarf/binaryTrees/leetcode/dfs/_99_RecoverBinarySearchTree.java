package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _99_RecoverBinarySearchTree {

	public static void main(String[] args) {

	}
	
	TreeNode x = null;
	TreeNode y = null;
	
	TreeNode prev = null;
	
	public void recoverTree(TreeNode root) {
		dfs(root);
		swap(x, y);
	}
	
	public void dfs(TreeNode root) {
		
		if(root == null) return;
		
		dfs(root.left);
		
		if(prev != null) {
			
			if(root.val < prev.val) {
				y = root;
				if(x == null) x = prev;
			}
		}
		prev = root;
		dfs(root.right);
	}

	
	// recover using moris traversal
	public void recoverTree1(TreeNode root) {

		TreeNode curr = root; 
		
		TreeNode x = null;
		TreeNode y = null;
		
		TreeNode prev = null;

		while(curr != null) {

			if(curr.left == null) {
				//l.add(curr.val);
				
				if(prev != null && curr.val < prev.val) {
					y = curr;
					if(x == null) x = prev;
				}
				prev = curr;
				
				curr = curr.right;
			}
			else {

				TreeNode predecessor = findPredecessor(curr);

				if(predecessor.right == null) {
					predecessor.right = curr;
					curr = curr.left;
				}
				else {
					predecessor.right = null;
					
					//l.add(curr.val);
					
					if(prev != null && curr.val < prev.val) {
						y = curr;
						if(x == null) x = prev;
					}
					prev = curr;
					
					curr = curr.right;
				}
			}
		}
		
		swap(x, y);
	}
	
	public TreeNode findPredecessor(TreeNode curr) {
		TreeNode temp = curr;
		temp = temp.left;
		while(temp.right != null ) {
			if(temp.right == curr) {
				return temp;
			}
			temp = temp.right;
		}
		return temp;
	}
	
	public void swap(TreeNode x, TreeNode y) {
		int temp =  x.val;
		x.val = y.val;
		y.val = temp;
	}



}
