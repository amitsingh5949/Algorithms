package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _863_AllNodesDistanceKinBinaryTree {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t4;
		t2.left = t3;
		t3.left = t5;
		System.out.println(new _863_AllNodesDistanceKinBinaryTree().distanceK(t1, t2, 0));
	}

	List<Integer> res = null;
	int distance = 0;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		res = new ArrayList<>();
		distance = K;
		if(root == null || target == null) return res;
		search(root, target, K);
		return res;
	}

	public boolean search(TreeNode curr, TreeNode target, int K) {

		if(curr == null) return false;

		if(curr.val == target.val) {
			findKDistanceElement(target, K);
			if(K == 0) {// special condition to handle case when K= 0 , findKDistanceElement has already added the element we would return false so that no other processing happens
				return false;
			}
			return true;
		}
		
		boolean left = search(curr.left, target, K);
		boolean right = search(curr.right, target, K);


		if(left && distance > 0) {
			distance -= 1;
			findKDistanceElement(curr.right, distance-1);
		}

		else if(right && distance > 0) {
			distance -= 1;
			findKDistanceElement(curr.left, distance-1);
		}

		if((left || right) && distance == 0) {
			distance  = -1;
			res.add(curr.val);
		}
		return left || right;
	}

	private void findKDistanceElement(TreeNode target, int k) {

		if(target == null || k < 0) return;

		if(k == 0) {
			res.add(target.val);
			return;
		}
		findKDistanceElement(target.left, k-1);
		findKDistanceElement(target.right, k-1);
	}

}
