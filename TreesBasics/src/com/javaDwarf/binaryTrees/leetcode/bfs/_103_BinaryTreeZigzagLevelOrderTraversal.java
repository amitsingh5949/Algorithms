package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _103_BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {

	}
	
	//Note : just by flag using one queue it wont work

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> l = new ArrayList<>();

		if(root == null) return l;

		Stack<TreeNode> s1LtoR = new Stack<>();
		Stack<TreeNode> s2RtoL = new Stack<>();
		boolean leftToRight = true;

		s1LtoR.add(root);

		while(!s1LtoR.isEmpty() || !s2RtoL.isEmpty()) {

			if(leftToRight) {

				List<Integer> l1 = new ArrayList<>();

				while(!s1LtoR.isEmpty()) {
					TreeNode curr = s1LtoR.pop();
					if(curr.left!=null) {
						s2RtoL.push(curr.left);
					}
					if(curr.right!=null) {
						s2RtoL.push(curr.right);
					}
					l1.add(curr.val);
				}

				l.add(l1);
				leftToRight = false;
			}
			else {

				List<Integer> l1 = new ArrayList<>();

				while(!s2RtoL.isEmpty()) {
					TreeNode curr = s2RtoL.pop();
					if(curr.right!=null) {
						s1LtoR.push(curr.right);
					}
					if(curr.left!=null) {
						s1LtoR.push(curr.left);
					}
					l1.add(curr.val);
				}
				l.add(l1);
				leftToRight = true;	
			}
		}
		return l;
	}
	
	
	
	
	///****technique 4 using 1 Queue and Using linkedlist in the resultant List which we need to return*/
	public List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
	       
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        boolean flag = true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null)
                        q.add(curr.left);
                if(curr.right != null)
                        q.add(curr.right);
                if(flag){
                    temp.add(curr.val);
                }
                else{
                    temp.addFirst(curr.val);
                }
                
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }

}
