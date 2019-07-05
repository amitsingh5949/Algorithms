package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _606_ConstructStringfromBinaryTree {

	public static void main(String[] args) {

	}

	//please read and understand leetcode's iterartive solution
	public String tree2str(TreeNode t) {
		if(t == null) return "";
		if(t!=null && t.left == null && t.right == null) return Integer.valueOf(t.val).toString();
		return tree2str(t,"");
	}

	public String tree2str(TreeNode t, String str) {

		if(t == null) return str;

		if(t.left == null && t.right == null ) return str +t.val;

		str += t.val;

		if(t.left!=null || t.right!=null) {
			str = tree2str(t.left, str+"(");
			str +=")";
		}
		if(t.right!=null) {
			str = tree2str(t.right, str+"(");
			str +=")";
		}
		return str;
	}

}
