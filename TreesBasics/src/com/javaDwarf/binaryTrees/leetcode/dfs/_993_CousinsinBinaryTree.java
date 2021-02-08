package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


// if we need to find all the cousins then we need to take a map of element and depth and a map of element and parent
public class _993_CousinsinBinaryTree {

	int d1 = -1;
	int d2 = -2;
	int p1 = -1;
	int p2 = -1;

	public boolean isCousins(TreeNode root, int x, int y) {

		if( root == null) return false;
		this.d1 = -1;
		this.d2 = -2;
		this.p1 = -1;
		this.p2 = -1;
		findDepthAndParent(root, x, y, 1);
		if((d1 == d2) && (p1 != p2)){
			return true;
		}
		return false;
	}

	public void findDepthAndParent(TreeNode root, int x, int y, int currDepth) {

		if( root == null) return;

		if( (root.left != null && root.left.val == x ) || (root.right != null && root.right.val == x) ){
			this.d1 = currDepth +1;
			p1 = root.val;
		}
		if( (root.left != null && root.left.val == y ) || (root.right != null && root.right.val == y) ){
			this.d2 = currDepth +1;
			p2 = root.val;
		}
		findDepthAndParent(root.left, x, y, currDepth+1);
		findDepthAndParent(root.right, x, y, currDepth+1);
	}

	//using BFS	-- 
	public boolean isCousins2(TreeNode root, int x, int y) {

		if(root == null) return false;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		int lx = -1;
		int ly = -2;
		int px = -1;
		int py = -1;
		
		int level = 1;

		while(!q.isEmpty()){

			int size = q.size();


			for(int i= 0; i<size; i++){
				TreeNode curr = q.poll();
				if( (curr.left != null && curr.left.val == x) || (curr.right != null && curr.right.val == x)){
					px = curr.val;
					lx = level + 1;
				}
				if( (curr.left != null && curr.left.val == y) || (curr.right != null && curr.right.val == y)){
					px = curr.val;
					ly = level + 1 ;
				}
				
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
			}
			level++;
		}
		
		return (lx == ly) && (px != py) ;


	}
}
