package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _113_PathSumII {

	public static void main(String[] args) {
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(5);
		
		l1.left = l2;
		l1.right = l5;
		
		l2.left = l3;
		l2.right = l4;
		
		l5.right = l6;
		
		new _113_PathSumII().pathSum(l1, 7);

	}

	List<List<Integer>> res = null;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		res  = new ArrayList<List<Integer>>();
		if(root == null) return res;
		List<Integer> temp =new ArrayList<>();
		temp.add(root.val);
		dfs(root, sum, root.val, temp);
		return res;
	}

	public void dfs(TreeNode root, int sum, int currSum, List<Integer> temp){
		
		if(root == null) return ;
		if(root.left == null && root.right == null  && currSum == sum) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		if(root.left != null) {
			temp.add(root.left.val);
			dfs(root.left, sum, currSum+root.left.val, temp);
			temp.remove(temp.size()-1);
		}
		if(root.right != null) {
			temp.add(root.right.val);
			dfs(root.right, sum, currSum+root.right.val, temp);
			temp.remove(temp.size()-1);
		}
	}

}
