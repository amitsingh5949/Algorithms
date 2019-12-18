package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.LinkedList;
import java.util.Queue;


public class _337_HouseRobberIII {

	public static void main(String[] args) {

	}

    public int rob(TreeNode root) {
    	
    	if(root == null) {
    		return 0;
    	}
    	// Option 1 : choose to rob root 
    	int rootSum = root.val;
    	if(root.left != null) {
    		rootSum += rob(root.left.left) + rob(root.left.right);
    	}
    	if(root.right != null) {
    		rootSum += rob(root.right.left) + rob(root.right.right);
    	}
    	
    	// Option 2 : choose not to rob root
    	int notRootSum = rob(root.left) + rob(root.right);
    	
    	return Math.max(rootSum, notRootSum);
    }

	
	// Wrong solution - as with bsf we are capturing the sum of levels,  [2,1,3,null,4] test case fails
	public int rob1(TreeNode root) {
		
		if(root ==null) {
			return 0;
		}
		
		int prevMax = 0;
		int currMax = 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		int sum = 0;
		
		while(q.size() > 1) {
			TreeNode curr = q.poll();
			
			if(curr == null) {
				int temp = currMax;
				currMax = Math.max(prevMax+sum, currMax);
				prevMax = temp;
				sum = 0;
				q.add(null);
				continue;
			}
			
			sum += curr.val;
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		
		currMax = Math.max(prevMax+sum, currMax);
		
		return currMax;
		

	}
	
	
	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }
		
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

}
