package com.javaDwarf.binaryTrees.leetcode;

public class _617_MergeTwoBinaryTrees {
	
	
	//using extra tree o(n) extra
	 public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		 
		 if(t1==null && t2 == null) return null;
		 
		 TreeNode root = null;
		 
		 if(t1!=null && t2 == null) {
			 root = t1;
		 }
		 else if(t1==null && t2 != null) {
			 root = t2;
		 }
		 else {
			 root =  new TreeNode(t1.val + t2.val);
			 root.left = mergeTrees(t1.left, t2.left);
			 root.right = mergeTrees(t1.right, t2.right);
		 }
		 return root;
	    }
	 
 public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
		 
		 if(t1==null && t2 == null) return null;
		 
		 TreeNode root = null;
		 
		 if(t1!=null && t2 == null) {
			 root = t1;
		 }
		 else if(t1==null && t2 != null) {
			 root = t2;
		 }
		 else {
			 t1.val = t1.val + t2.val;
			 root =  t1;
			 root.left = mergeTrees(t1.left, t2.left);
			 root.right = mergeTrees(t1.right, t2.right);
		 }
		 return root;
	    }

}
