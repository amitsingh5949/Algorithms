package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _513_FindBottomLeftTreeValue {

	public static void main(String[] args) {

	}

	// Method 1 - left to right BST
	// One approach is to find the height and do level order traversal from left to right , 
	//the first element on the last level is answer


	//Method 2  - right to left BST


	public int findBottomLeftValue(TreeNode root) {

		if(root == null) return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		TreeNode node = null;

		while(!q.isEmpty()) {
			node = q.poll();

			if(node.right != null) {
				q.add(node.right);
			}
			if(node.left != null) {
				q.add(node.left);
			}
			
		}

		return node.val;

	}
}
