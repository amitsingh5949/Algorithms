package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _235_LowestCommonAncestorofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val<p.val &&root.val<q.val) root=root.right;
            else if(root.val>p.val &&root.val>q.val) root=root.left;
            else return root;
        }
        return null;
    }

}
