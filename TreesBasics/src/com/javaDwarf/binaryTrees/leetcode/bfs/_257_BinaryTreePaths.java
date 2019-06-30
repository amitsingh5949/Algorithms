package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _257_BinaryTreePaths {


	class Element{
		TreeNode node = null;
		String path = null;
		public Element(TreeNode node, String path) {
			super();
			this.node = node;
			this.path = path;
		}

	}

	public List<String> binaryTreePaths(TreeNode root) {

		List<String>  l =new ArrayList<String>();
		if(root == null) return l;

		Stack<Element> q = new Stack<>();
		q.add(new Element(root, Integer.valueOf(root.val).toString()));


		while(!q.isEmpty()) {

			Element e = q.pop();
			
			if(e.node.left==null && e.node.right==null) {
				l.add(e.path);
				continue;
			}
			
			if(e.node.left!=null) {
				q.add(new Element(e.node.left, (e.path+"->"+e.node.left.val)));
			}
			if(e.node.right!=null) {
				q.add(new Element(e.node.right, (e.path+"->"+e.node.right.val)));
			}
		}
		return l;
	}


}
