package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _1161_MaximumLevelSumofaBinaryTree {

	public static void main(String[] args) {

		//[989,null,10250,98693,-89388,null,null,null,-32127]
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(7);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(-8);
		
		t1.left = t2;
		t1.right = t3;
		
		t2.left = t4;
		t2.right = t5;
		
		System.out.println(new _1161_MaximumLevelSumofaBinaryTree().maxLevelSum(t1));
		
		
	}

	public int maxLevelSum(TreeNode root) {


		if(root == null) return 0;

		int minLevel = 0;
		int currLevel = 1;

		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);


		while(q.size() > 1) {

			TreeNode curr = q.poll();

			if(curr == null) {
				if( currSum > maxSum ) {
					maxSum = currSum;
					minLevel = currLevel;
				}
				currSum = 0;
				currLevel++;
				q.add(null);
				continue;
			}

			currSum  += curr.val;

			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}

		}
		
		// for the last null that is last level
		currLevel++;
		if(currSum > maxSum) {
			maxSum = currSum;
			minLevel = currLevel;
		}
		
		return minLevel;

	}

}
