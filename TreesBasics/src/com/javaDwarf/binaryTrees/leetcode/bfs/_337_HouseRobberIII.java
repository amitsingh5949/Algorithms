package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.TreeNode;

public class _337_HouseRobberIII {

	public static void main(String[] args) {



	}

	public int rob(TreeNode root) {

		if(root == null)  return 0;

		int oddSum = 0;
		int evenSum = 0;
		boolean odd = true;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(q.size() > 1) {

			TreeNode node = q.poll();

			if(node == null) {
				odd = !odd;
				q.add(null);
				continue;
			}

			if(odd) {
				oddSum += node.val;
			}
			else{
				evenSum += node.val;
			}

			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}

		}

		return Integer.max(evenSum, oddSum);
	}

}
