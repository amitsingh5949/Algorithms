package com.javaDwarf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {
	
	public static void main(String[] args) {
		System.out.println(new _95_UniqueBinarySearchTreesII().generateTrees(3));
		
	}
	// can also incorporate memoization in this recursive approach too
	public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
		return  generateTrees(n,1,n);
	}

	public List<TreeNode>  generateTrees(int n, int start, int end) {
		
		if(start > end) {
			List<TreeNode> empty = new ArrayList<>();
			empty.add(null);
			return empty;
		}
		
		List<TreeNode> l = new ArrayList<>();
		
		for(int i =start; i<=end; i++) {
			
			List<TreeNode> leftTrees = generateTrees(n, start, i-1);
			List<TreeNode> rightTrees = generateTrees(n, i+1, end);
			
			for(TreeNode leftTree : leftTrees) {
				for(TreeNode rightTree : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					l.add(root);
				}
			}
		}
		return l;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		
		@Override
		public String toString() {
			return "val=" + val;
		}
		
	}

}
