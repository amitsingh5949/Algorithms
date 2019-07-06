package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _662_MaximumWidthofBinaryTree {

	public static void main(String[] args) {
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(1);
		TreeNode l3 = new TreeNode(1);
		TreeNode l4 = new TreeNode(1);
		TreeNode l5 = new TreeNode(1);
		TreeNode l6 = new TreeNode(1);
		TreeNode l7 = new TreeNode(1);
		TreeNode l8 = new TreeNode(1);
		
		l1.left = l2;
		l2.left = l3;
		l3.left = l4;
		
		l1.right = l5;
		l5.right = l6;
		l6.right = l7;
		l7.right = l8;
		
		
		int x = new _662_MaximumWidthofBinaryTree().widthOfBinaryTree(l1);
		System.out.println(x);

	}
	class Element{

		TreeNode node = null;
		int pos = 0;

		public Element(TreeNode node, int pos) {
			super();
			this.pos = pos;
			this.node = node;
		}

	}

	public int widthOfBinaryTree(TreeNode root) {

		if(root == null) return 0;
		else if(root.left == null && root.right == null) return 1;

		int max= 0 ;
		Queue<Element> q = new LinkedList<>();
		q.add(new Element(root, 0));
		q.add(null);

		Element start = q.peek();
		Element end = q.peek();

		while(q.size() > 1) {

			end = q.poll();
			if(end == null) {
				start = end = q.peek();
				q.add(null);
				continue;
			}
			else {
				max = Integer.max(max, end.pos - start.pos);
			}

			if(end.node.left != null) {
				q.add(new Element(end.node.left , end.pos-1 ));
			}
			if(end.node.right != null) {
				q.add(new Element(end.node.right , end.pos+1 ));
			}
		}
		max = Integer.max(max, end.pos - start.pos);
		return max;
	}
}
