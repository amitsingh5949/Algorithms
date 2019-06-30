package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.javaDwarf.binaryTrees.TreeNode;

public class _113_PathSumII {
	
	class Element{
		TreeNode node = null;
		int sum = 0;
		List<Integer> lc= null;
		public Element(TreeNode node, int sum, List<Integer> l) {
			super();
			this.node = node;
			this.sum = sum;
			lc = new ArrayList<>(l);
			lc.add(node.val);
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		List<List<Integer>> l = new ArrayList<>();
		
		if(root == null) return l;

		Stack<Element> q = new Stack<>();
		q.add(new Element(root, root.val, new ArrayList<>()));


		while(!q.isEmpty()) {

			Element e = q.pop();
			
			if(e.node.left==null && e.node.right==null && e.sum == sum) {
				l.add(e.lc);
				continue;
			}
			
			if(e.node.left!=null) {
				q.add(new Element(e.node.left, (e.sum+e.node.left.val), e.lc));
			}
			if(e.node.right!=null) {
				q.add(new Element(e.node.right, (e.sum+e.node.right.val),e.lc));
			}
		}
		return l;

	}

}
