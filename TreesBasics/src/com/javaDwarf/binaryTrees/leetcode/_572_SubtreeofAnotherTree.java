package com.javaDwarf.binaryTrees.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _572_SubtreeofAnotherTree {

	public static void main(String[] args) {

	}

	// One solution is to calculate preorder of both trees and store them string and see if s contains(t)
	// need to separate left null and right null 
	
	//[3,4,5,1,2] == 3 # 4 # 1 # lnull # rull # 2 # lnull # rnull # 5 # lnull # rnull	
	
	public boolean isSubtreeUsingPreorder(TreeNode root, TreeNode subRoot) {
        String s1 = preorder(root, new StringBuilder()).toString();
        String s2 = preorder(subRoot, new StringBuilder()).toString();
        System.out.println(s1+"***************"+s2);
        return s1.contains(s2);
    }
    
    public StringBuilder preorder(TreeNode root, StringBuilder sb){
        if( root == null){
            sb.append("NULL");        
            return sb;  
        }
        sb.append("val"+root.val);// adding val to handle test case [12] [2]
        preorder(root.left,sb);
        preorder(root.right,sb);
        return sb;
    }
	
	// below is o(n^2) approach to check for same tree for every node
	public boolean isSubtree(TreeNode s, TreeNode t) {

		if(s == null && t == null) return true;
		else if(s != null && t == null) return false;
		else if(s == null && t != null) return false;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(s);

		while(!q.isEmpty()) {

			TreeNode curr = q.poll();

			if(isSubtreeSame(curr, t)) return true;

			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}

		return false;

	}

	public boolean isSubtreeSame(TreeNode s, TreeNode t) {

		if(s == null && t == null) return true;
		else if(s != null && t == null) return false;
		else if(s == null && t != null) return false;

		boolean left = isSubtreeSame(s.left, t.left);
		boolean right = isSubtreeSame(s.right, t.right);

		return left && right && (s.val == t.val);

	}

}
