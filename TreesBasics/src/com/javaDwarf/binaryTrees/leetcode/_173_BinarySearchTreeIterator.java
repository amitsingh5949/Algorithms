package com.javaDwarf.binaryTrees.leetcode;

import java.util.Stack;

public class _173_BinarySearchTreeIterator {

}


class BSTIterator {

	Stack<TreeNode> s = null;
	TreeNode curr = null;

	public BSTIterator(TreeNode root) {
		s = new Stack<>();
		if(root != null){
			s.add(root);
		}
		curr = root;
	}

	/** @return the next smallest number */
	public int next() {
		while(curr != null && s.peek().left!=null) {
			s.add(s.peek().left);
			curr = s.peek().left;
		}
		curr = s.pop();
		int res = curr.val;
		curr = curr.right;
		if(curr != null) {
			s.add(curr);
		}
		return res;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();
	}
}

