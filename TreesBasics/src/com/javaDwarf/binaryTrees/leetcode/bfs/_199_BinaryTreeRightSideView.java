package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _199_BinaryTreeRightSideView {

	public static void main(String[] args) {

	}

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> l = new ArrayList<>();

		if(root == null)  return l;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(q.size() > 1) { 

			TreeNode curr = q.poll(); 
			
			if(curr.left!= null) {
				q.add(curr.left);
			}
			if(curr.right!=null) {
				q.add(curr.right);
			}
			
			if(q.peek() == null) {
				l.add(curr.val);
				q.add(q.poll());
				continue;
			}
			
		}
		
		return l;

	}

}
