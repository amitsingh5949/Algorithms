package com.javaDwarf.binaryTrees.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversalWithoutRecursion  {

	public static void main(String[] args) {

	}

	// The main challenge is not to add the left nodes which are already added to stack again
	// below approach sets the left node to null after adding it to stack. This changes the given tree
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> l = new ArrayList<>();

		if(root == null) return l;

		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		while(!s.isEmpty()) {

			if(s.peek().left == null) {
				TreeNode temp = s.pop();
				l.add(temp.val);
				if(temp.right!=null) {
					s.push(temp.right);
				}
			}
			else {
				TreeNode temp =  s.peek();
				s.push(temp.left);
				temp.left = null;//Important condition so that left explored children do not get explored again
			}
		}
		return l;
	}



	//The main challenge is not to add the left nodes which are already added to stack again
	//above approach sets the left node to null after adding it to stack. This changes the given tree

	// one observation is when we go to leftmost leaf on a branch, we need not add all its ancestors to stack as they have already been added 
	// for this we introduce new variable called current when current go to leftmost leaf on a branch 
	//then left nodes of stack.top() will not be explored as curr will be null due to curr = curr.right


	public List<Integer> inorderTraversal1(TreeNode root) {

		List<Integer> l = new ArrayList<>();

		if(root == null) return l;

		Stack<TreeNode> s = new Stack<>();
		s.add(root);
		TreeNode curr = root;

		while(!s.isEmpty()) {

			while( curr != null && s.peek().left != null) {
				s.add(s.peek().left);
				curr = s.peek().left;
			}

			curr = s.pop();
			l.add(curr.val);

			curr = curr.right;
			if(curr != null) {
				s.push(curr);
			}
		}
		return l;
	}

	//Morris inorder tree traversal without using stacks or recursion - TODO

}
