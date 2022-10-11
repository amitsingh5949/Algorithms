package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _101_SymmetricTree {
	
	//Recursive solution TODO
	public boolean isSymmetric(TreeNode root) {
		return true;
	}

	//Iterative solution
	public boolean isSymmetric1(TreeNode root) {

		if( root == null ) return true;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root.left);
		Queue<TreeNode> s = new LinkedList<>();
		s.add(root.right);

		while(!q.isEmpty() || !s.isEmpty()) {

			if(q.size() != s.size()) return false;

			TreeNode q1 = q.poll();
			TreeNode s1 = s.poll();

			if(q1 == null && s1 == null){
				continue;
			}
			if((q1 == null && s1 != null)  || (q1 != null && s1 == null) || ( q1.val != s1.val ) ) {
				return false;
			}

			if(q1 != null) {
				q.add(q1.left);
				q.add(q1.right);
			}
			if(s1 != null) {
				s.add(s1.right);
				s.add(s1.left);
			}
		}
		return true;
	}
	
	//Same logic as above but using one queue, same time and memory as above but looks cool
	public boolean isSymmetric23(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size; i++){
                TreeNode first = q.poll();
                TreeNode second = q.poll();
                
                if(first != null && second == null ) return false;
                if(first == null && second != null ) return false;
                if(first != null && second != null && first.val != second.val ) return false;
                if(first != null && second != null){
                    q.add(first.left);
                    q.add(second.right);
                    q.add(first.right);
                    q.add(second.left);
                }
            }
        }
        
        return true;
    }

}
