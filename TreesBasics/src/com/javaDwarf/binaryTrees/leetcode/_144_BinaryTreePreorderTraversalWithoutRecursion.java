package com.javaDwarf.binaryTrees.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BinaryTreePreorderTraversalWithoutRecursion {

	public static void main(String[] args) {

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> l = new ArrayList<>();
		
		if(root == null) return l;
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		while(!s.isEmpty()) {
			
			TreeNode curr = s.pop();
			l.add(curr.val);
			
			if(curr.right!=null) {
				s.push(curr.right);
			}
			
			if(curr.left!=null) {
				s.push(curr.left);
			}
		}
		return l;
	}

}
