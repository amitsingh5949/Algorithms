package com.javadwarf.narytree.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javadwarf.narytree.leetcode.Node;

public class _589_NaryTreePreorderTraversal {

	public List<Integer> preorder(Node root) {
		if(root == null) return new ArrayList<>();
		return preorder(root, new ArrayList<>());
	}

	public List<Integer> preorder(Node root, List<Integer> l) {
		if(root == null) return l;
		l.add(root.val);
		for(Node child : root.children) {
			l = preorder(child,l);
		}
		return l;
	}

}
