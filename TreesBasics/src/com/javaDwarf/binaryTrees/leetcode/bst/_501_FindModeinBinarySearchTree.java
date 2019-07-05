package com.javaDwarf.binaryTrees.leetcode.bst;

import java.util.HashSet;
import java.util.Set;

import com.javaDwarf.binaryTrees.TreeNode;

public class _501_FindModeinBinarySearchTree {

	public static void main(String[] args) {

	}

	// wrong logic TODO
	public int[] findMode(TreeNode root) {

		if(root == null) return new int[0];

		Set<Integer> set = findMode(root, new HashSet<>());

		int[] arr = new int[set.size()];

		int index = 0;
		for(int i : set) {
			arr[index++] = i;
		}

		return arr;

	}

	public Set<Integer> findMode(TreeNode root, Set<Integer> set) {

		if(root == null) return set;

		if(root != null && ( (root.left != null  && root.val == root.left.val) ||
				( root.right != null  && root.val == root.right.val))) {
			set.add(root.val);
		}

		set = findMode(root.left, set);
		set = findMode(root.right, set);

		return set;

	}

}
