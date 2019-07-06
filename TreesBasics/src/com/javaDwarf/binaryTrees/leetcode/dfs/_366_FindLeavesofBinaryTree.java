package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.TreeNode;

public class _366_FindLeavesofBinaryTree {
	
	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		
		l1.left = l2;
		l1.right = l3;
		
		l2.left = l4;
		l2.right = l5;
		
		new _366_FindLeavesofBinaryTree().findLeaves(l1);
		
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();

		if(root==null) return l;

		while(root.left!=null || root.right != null) {
			l.add(childDFS(root, root, new ArrayList<>()));
		}
		
		List<Integer> ll = new ArrayList<>();
		ll.add(root.val);
		l.add(ll);
		root = null;

		return l;
	}

	public List<Integer> childDFS(TreeNode root, TreeNode parent, List<Integer>  l){
		
		if(root == null) return l;

		if(root.left == null && root.right == null) {
			l.add(root.val);
			if(parent.left != null && parent.left.val == root.val ) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}
			return l;
		}

		l = childDFS(root.left, root, l);
		l = childDFS(root.right, root, l);

		return l;
	}
}
