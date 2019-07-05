package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _872_LeafSimilarTrees {

	public static void main(String[] args) {

	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		if(root1 == null || root2 == null) return false;

		List<Integer> l1 = getLeaves(root1, new ArrayList<>());
		List<Integer> l2 = getLeaves(root2, new ArrayList<>());
		
		/*System.out.println(l1);
		System.out.println(l2);

		if(l1.size() ==0 || (l1.size() != l2.size())) {
			return false;
		}

		for(int i = 0; i<l1.size(); i++) {
			if(l1.get(i) != l2.get(i)) {
				return false;
			}
		}
		return true;*/
		
		return l1.equals(l2);
	}

	public List<Integer> getLeaves(TreeNode root, List<Integer> lc){

		if(root == null) return lc;

		lc = getLeaves(root.left, lc);
		
		if(root!=null && root.left == null && root.right == null) {
			lc.add(root.val);
		}
		lc = getLeaves(root.right, lc);
		return lc;

	}

}
