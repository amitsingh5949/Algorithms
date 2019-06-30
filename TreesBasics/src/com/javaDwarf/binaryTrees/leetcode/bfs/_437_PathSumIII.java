package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.TreeNode;

public class _437_PathSumIII {

	class Element{
		TreeNode node = null;
		int sum = 0;
		LinkedList<Integer> lc= null;
		public Element(TreeNode node, int sum, List<Integer> l) {
			super();
			this.node = node;
			this.sum = sum;
			lc = new LinkedList<>(l);
			lc.add(node.val);
		}
	}

	
	// below logic is wrong
	public int pathSum(TreeNode root, int sum) {

		int numOfPath = 0; 

		if(root == null) return 0;

		Queue<Element> q = new LinkedList<>();
		q.add(new Element(root, root.val, new ArrayList<>()));


		while(!q.isEmpty()) {

			Element e = q.poll();

			if( e.sum == sum) {
				numOfPath++;
				int first = e.lc.removeFirst();
				e.sum -= first; 
			}
			else if(e.sum >sum) {
				int first = e.lc.removeFirst();
				e.sum -= first;
				q.add(e);
			}

			if(e.node.left!=null) {
				q.add(new Element(e.node.left, (e.sum+e.node.left.val), e.lc));
			}
			if(e.node.right!=null) {
				q.add(new Element(e.node.right, (e.sum+e.node.right.val),e.lc));
			}
		}
		return numOfPath;

	}

}
