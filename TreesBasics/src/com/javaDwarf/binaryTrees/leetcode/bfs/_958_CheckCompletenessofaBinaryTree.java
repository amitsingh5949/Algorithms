package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _958_CheckCompletenessofaBinaryTree {

	public boolean isCompleteTree(TreeNode root) {

		if(root == null) return false;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean foundNull = false;

		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr == null) {
				foundNull = true;
				continue;
			}
			if(curr !=null && foundNull) {
				return false;
			}
			q.add(curr.left);
			q.add(curr.right);
		}
		return true;
	}
}
