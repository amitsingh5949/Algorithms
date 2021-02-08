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


	//Iterative solution o(n)
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

	// same logic as above , using size instead of marker null
	public List<List<Integer>> levelOrder4(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()){

			int size = q.size();

			List<Integer> temp = new ArrayList<>();

			for(int i= 0; i<size; i++){
				TreeNode curr = q.poll();
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
				temp.add(curr.val);
			}
			res.add(temp);

		}

		return res;

	}



	//recursive solution o(n^2)
	// find height for number of levels and do inorder for each level
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


	//recursive solution o(n) - by maintaining the level at each node and incrementing it for the next level
	List<List<Integer>> res = null;
	public List<List<Integer>> levelOrder3(TreeNode root) {
		res = new ArrayList<>();
		if(root == null) return res;
		inorder(root,0);
		return res;
	}

	public void inorder(TreeNode root, int level){
		if(root == null) return;
		if(res.size() == level) res.add(new ArrayList<>());
		res.get(level).add(root.val);
		inorder(root.left, level+1);
		inorder(root.right, level+1);
	}

}
