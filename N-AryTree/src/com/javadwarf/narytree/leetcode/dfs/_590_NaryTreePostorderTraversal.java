package com.javadwarf.narytree.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import com.javadwarf.narytree.leetcode.Node;

public class _590_NaryTreePostorderTraversal {

	public static void main(String[] args) {

	}


	public List<Integer> postorder(Node root) {
		if(root == null) return new ArrayList<>();
		return postorder(root, new ArrayList<>());

	}
	public List<Integer> postorder(Node root, List<Integer> l) {
		if(root == null) return l;
		for(Node child : root.children) {
			l = postorder(child,l);
		}
		l.add(root.val);
		return l;
	}
}
