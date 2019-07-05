package com.javadwarf.narytree.leetcode.dfs;

import  com.javadwarf.narytree.leetcode.Node;

public class _559_MaximumDepthofNaryTree {

	public int maxDepth(Node root) {

		if(root == null ) return 0;

		int max =  0;

		for(Node child  : root.children) {
			max = Integer.max(max, maxDepth(child));
		}
		return max +1;
	}

}
