package com.javaDwarf.binaryTrees.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1120_MaximumAverageSubtree {
	
	class Pos{
		
		double avg;
		int count;
		
		public Pos(double avg, int count) {
			super();
			this.avg = avg;
			this.count = count;
		}
		
	}

	public static void main(String[] args) {

	}
	
	public  double maxAvg = 0;
	
	public  double maximumAverageSubtree(TreeNode root) {
		if(root == null) return 0.0;
		dfs(root);
		return maxAvg;
	}
	
	public  Pos dfs(TreeNode curr) {
		
		if(curr == null) return new Pos(0.0,0);
		
		Pos left = dfs(curr.left);
		Pos right = dfs(curr.right);
		
		Pos p = new Pos(curr.val, 1);
		p.count = p.count +left.count +right.count;
		p.avg = (p.avg + left.avg+ right.avg)/p.count;
		maxAvg = Math.max(maxAvg, p.avg);
		
		return p;
	}

	
	
	// Brute-Force o(n^2) - Time limit Exceeded
	public double maximumAverageSubtree1(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			
			maxAvg = Math.max(maxAvg, getAverageOFSubTree(curr));
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return maxAvg;
	}

	private double getAverageOFSubTree(TreeNode curr) {
		
		int avg = 0;
		int count = 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(curr);
		
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			
			count++;
			avg += t.val/count;
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return avg;
	}
}
