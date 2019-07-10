package com.javaDwarf.binaryTrees.leetcode;

public class _988_SmallestStringStartingFromLeaf {

	public static void main(String[] args) {

	}

	String result = "";
	public String smallestFromLeaf(TreeNode root) {
		if(root == null) return "";
		this.result = "";
		smallestFromLeafdfs(root, "");
		return result;
	}

	public void smallestFromLeafdfs(TreeNode root, String s) {
		if( root == null) return;

		if(root.left == null && root.right == null) {
			int temp = root.val + (int)'a';
			s = (char)temp + s;
			if(result.equals("")) {
				result = s.toString();
			}
			else {
				result = (result.compareTo(s) <= 0) ? result : s;
			}
		}

		int temp = root.val + (int)'a';
		s = (char)temp + s;

		smallestFromLeafdfs(root.left,s);
		smallestFromLeafdfs(root.right,s);

	}

}
