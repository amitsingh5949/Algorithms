package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _230_KthSmallestElementinaBST {

	TreeNode res;
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        res=null;
        this.k =k;
        helper(root);
        return res.val;
    }
    
    public void helper(TreeNode root){
        if(root == null ) return;
        helper(root.left);
        k--;
        if(k==0 &&res==null){
            res=root;
        }
        helper(root.right);
    }
}
