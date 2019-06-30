package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _111_MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		
		if(root == null)  return 0;
		
		int min = 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(q.size() > 1) {
			
			TreeNode node = q.poll();
			
			if(node== null) {
				min++;
				q.add(null);
			}
			
			if(node.left == null && node.right == null) {
				return ++min;
			}
			
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return min;
	}
	
	// we can write recursive solution using bottom up approach taking min of left and right leaf height

}
