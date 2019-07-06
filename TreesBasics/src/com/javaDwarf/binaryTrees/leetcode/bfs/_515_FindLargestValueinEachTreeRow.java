package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _515_FindLargestValueinEachTreeRow {

	public List<Integer> largestValues(TreeNode root) {

		List<Integer> l = new ArrayList<>();

		if(root==null) return l;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int max = Integer.MIN_VALUE;
		while(q.size() > 1) {

			TreeNode node = q.poll();

			if(node== null) {
				l.add(max);
				max = Integer.MIN_VALUE;
				q.add(null);
				continue;
			}

			max = Integer.max(max, node.val);

			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		l.add(max);
		return l;
	}

}
