package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _199_BinaryTreeRightSideView {

	public static void main(String[] args) {

	}

	//Iterative solution : time and space o(n) and o(n)
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
	
	// recursive solution , idea is same as traversing the tree level order using recursion and adding the last element at every level
	//time and space o(n) and o(n)
    List<Integer> result = null;
    public List<Integer> rightSideView1(TreeNode root) {
        result = new ArrayList<>();
        helper(root,0);
        return result;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        Object o = (result.size() == level) ? result.add(root.val) : result.set(level,root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }


}
