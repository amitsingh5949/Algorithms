package com.javaDwarf.binaryTrees.leetcode;

public class _1448_CountGoodNodesinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	// go in preorder and check if curr node is greater than prev node. Pass the max so far into the recursion
	int res = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return res;
    }
    
    public void helper(TreeNode root, int prevMax){
        if(root == null) return;
        
        if(root.val>= prevMax) {
            res++;
            helper(root.left, root.val);
            helper(root.right, root.val);
        }
        else{
            helper(root.left, prevMax);
            helper(root.right, prevMax);
        }
    }
    

}
