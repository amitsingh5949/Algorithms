package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;
import com.javaDwarf.binaryTrees.leetcode._104_MaximumDepthofBinaryTree;

public class _102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

	}

	
	//Iterative solution
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> l = new ArrayList<>();
		
		if(root ==  null) return l;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		TreeNode current = null;
		List<Integer> l1 = new ArrayList<>();
		while ( !q.isEmpty() && q.size() > 1){
				current = q.poll();
				if(current == null) {
					l.add(l1);
					l1 = new ArrayList<>();
					q.add(null);
					continue;
				}
				else {
					l1.add(current.val);
				}
				if(current.left != null)
					q.add(current.left);
				if(current.right!=null)
					q.add(current.right);
		}
		if(l1.size()>0) {
			l.add(l1);
		}
		return l;
	}
	
	//recursive solution
	
	private static void levelOrderTraversal2(TreeNode root) {
		int height =  new _104_MaximumDepthofBinaryTree().maxDepth(root);
		for(int i = 1; i<=height; i++){
             printNodesAtLevel2(root, i);
		}
	}
	
	private static void printNodesAtLevel2(TreeNode n, int level){
		if(n==null){
			return;
		}
		if(level ==1){
			System.out.println(n.val);
		}
		printNodesAtLevel2(n.left, level-1);
		printNodesAtLevel2(n.right, level-1);
	}

}
