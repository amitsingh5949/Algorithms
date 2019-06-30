package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _107_BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> l = new ArrayList<>();
		if(root == null) return l;

		int height = height(root);
		for(int i = height; i>0; i--) {
			l.add(levelOrderBottomUp(root, i,  new ArrayList<>()));
		}
		return l;
	}

	public List<Integer> levelOrderBottomUp(TreeNode root, int level, List<Integer> l ) {

		if(root == null) return l;

		if(level == 1) {
			l.add(root.val);
		}
		
		l = levelOrderBottomUp(root.left, level-1, l);
		l = levelOrderBottomUp(root.right, level-1, l);

		return l;
	}

	public int height(TreeNode root) {
		if (root==null) return 0;
		return Integer.max(height(root.left), height(root.right)) +1;
	}

}
