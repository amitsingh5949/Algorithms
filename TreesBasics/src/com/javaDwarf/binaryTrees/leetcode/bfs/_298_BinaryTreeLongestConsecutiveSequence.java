package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.TreeNode;

public class _298_BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {

	}

	class Element{
		TreeNode node =  null;
		int count = 0 ;

		public Element(TreeNode node, int count) {
			super();
			this.node = node;
			this.count = count;
		}

	}

	public int longestConsecutive(TreeNode root) {

		int max = 0;

		if(root ==  null) return max;

		Queue<Element> q = new LinkedList<>();
		q.add(new Element(root, 1));

		while(!q.isEmpty()) {

			Element e = q.poll();
			max = Integer.max(max,e.count);

			TreeNode left = e.node.left;
			if(left != null) {
				if(e.node.val == left.val -1) {
					q.add(new Element(left, e.count+1));
				}
				else {
					q.add(new Element(left, 1));
				}
			}

			TreeNode right = e.node.right;
			if(right != null) {
				if(e.node.val == right.val -1) {
					q.add(new Element(right, e.count+1));
					max = Integer.max(max,e.count+1);
				}
				else {
					q.add(new Element(right, 1));
				}
			}

		}
		return max;
	}

}
