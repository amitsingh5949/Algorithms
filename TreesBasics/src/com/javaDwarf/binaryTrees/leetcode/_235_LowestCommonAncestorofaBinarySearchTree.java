package com.javaDwarf.binaryTrees.leetcode;

public class _235_LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {

	}

	// this can be done in o(n) by going thru all tree nodes and getting LCA . Refer question 236.
	// But with BST, we can decide whether to left or right based on search range on log(n) time
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val<root.val && q.val<root.val) root = root.left;
            else if(p.val>root.val && q.val>root.val) root = root.right;
            else return root;
        }
    }

}
 