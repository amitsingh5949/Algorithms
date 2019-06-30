package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.Stack;

import com.javaDwarf.binaryTrees.TreeNode;

public class _112_PathSum {

	class Element{
		TreeNode node = null;
		int sum = 0;
		public Element(TreeNode node, int sum) {
			super();
			this.node = node;
			this.sum = sum;
		}

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;

		Stack<Element> q = new Stack<>();
		q.add(new Element(root, root.val));


		while(!q.isEmpty()) {

			Element e = q.pop();
			
			if(e.node.left==null && e.node.right==null && e.sum == sum) {
				return true;
			}
			
			if(e.node.left!=null) {
				q.add(new Element(e.node.left, (e.sum+e.node.left.val)));
			}
			if(e.node.right!=null) {
				q.add(new Element(e.node.right, (e.sum+e.node.right.val)));
			}
		}



		return false;
	}

}
