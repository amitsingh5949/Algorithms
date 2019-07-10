package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _545_BoundaryofBinaryTree {

	public static void main(String[] args) {
		
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		
		l1.right = l2;
		
		l2.left = l3;
		l2.right = l4;
		
		new _545_BoundaryofBinaryTree().boundaryOfBinaryTree(l1);
		

	}

	Map<Integer, Integer> map = null;
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		
		List<Integer> boundary =  new ArrayList<>();
		if(root ==  null) return boundary;
		this.map = new HashMap<>();
		
		List<Integer> leftView = leftView(root, new ArrayList<>(), 1);
		
		List<Integer> leaves = leaves(root, new ArrayList<>());
		if(leaves.size() >1) {
			leaves.remove(0);
			if(leaves.size() >1)
				leaves.remove(leaves.size()-1);
		}
		
		this.map.clear();
		List<Integer> rightView = rightView(root.right, new ArrayList<>(), 1); 
		Collections.reverse(rightView);

		boundary.addAll(leftView);
		boundary.addAll(leaves);
		boundary.addAll(rightView);

		return boundary;
	}

	private List<Integer> leaves(TreeNode root,  List<Integer> l) {
		if(root == null) return l;
		if(root.left!=null && root.right != null){
			l.add(root.val);
		}
		l = leaves(root.right, l);
		l = leaves(root.left, l);
		return l;
	}

	private List<Integer> leftView(TreeNode root, List<Integer> l, int i) {
		if(root == null) return l;
		if(!map.containsKey(i)) {
			map.put(i, root.val);
			l.add(root.val);
		}
		l = leftView(root.left, l, i+1);
		l = leftView(root.right, l, i+1);
		return l;
	}

	private List<Integer> rightView(TreeNode root, List<Integer> l, int i) {
		if(root == null) return l;
		if(!map.containsKey(i)) {
			map.put(i, root.val);
			l.add(root.val);
		}
		l = rightView(root.right, l, i+1);
		l = rightView(root.left, l, i+1);
		return l;
	}

}
