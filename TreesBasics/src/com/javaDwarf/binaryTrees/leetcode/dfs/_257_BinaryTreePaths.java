package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _257_BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return new ArrayList<String>();
		return binaryTreePaths(root, new ArrayList<String>(), new LinkedList<Integer>());
	}

	public List<String> binaryTreePaths(TreeNode root,List<String> l, LinkedList<Integer> lc) {

		if(root.left == null && root.right == null) {
			String result = "";
			for(int i : lc) {
					result += i+"->";	
			}
			result +=root.val;
			l.add(result);
            return l;
		}

		lc.addLast(root.val);
		if(root.left!=null)
			l = binaryTreePaths(root.left,l,lc);
		if(root.right!=null)
			l = binaryTreePaths(root.right,l,lc);
		lc.removeLast();
		return l;
	}
}
