package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.TreeNode;

public class _102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

	}


	// this is the solution for level order traversal for tree without using queue i.e. by using recursion
	// store nodes for each level in map, you can get away with map too, just use indexes of list, see solution below
	
	List<List<Integer>> res;
	public List<List<Integer>> levelOrder(TreeNode root) {
		res = new ArrayList<>();
		helper(root, 0);
		return res;
	}

	public void helper(TreeNode root, int level){
		if(root == null ) return;
		if(res.size() <= level){
			List<Integer> l = new ArrayList<>();
			l.add(root.val);
			res.add(l);
		}
		else{
			res.get(level).add(root.val);
		}
		helper(root.left, level+1);
		helper(root.right, level+1);
	}

}
