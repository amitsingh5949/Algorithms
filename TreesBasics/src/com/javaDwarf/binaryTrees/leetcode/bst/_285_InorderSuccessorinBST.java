package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.TreeNode;

public class _285_InorderSuccessorinBST {
	
/*

1. Since its a bst, we can move left if target is smaller than current node else move right
2. Now if you find the element
   a. if it has right node then go to the left most node of the right sub tree
   b. if node does not have right child or right sub tree then successor will be parent or
    	grand parent or great.. parent at some higher level up in the tree. How should be determine ? which parent?
    	
    	TO solve this problem , maintain a parent node, if you move to the left sub tree of the parent becomes
    	current element as left subtree would have all the elements smaller than current element . 
    	So if we encounter a null right subtree for a given node we can return parent as it will be next successor.
    	
    	If you move to the right subtree then don't change parent grand parent would be the successor.
    	
 3. Above solution will work for all nodes except the last node in the inorder, for that we need to return null.
 	so add an extra check that if you are returning a parent as successor then parent value should be grater
	than current node else return null.

*/	
	
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode parent = root;
        
        TreeNode curr = root;
        
        while(curr != null){
            
            if(p.val == curr.val){
                
                if(p.right == null){
                    
                    if(parent.val > p.val){
                        return parent;
                    }
                    else{
                        return null;
                    }
                }
                else{
                    TreeNode temp = p.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    return temp;
                }
            }
            
           else if(p.val < curr.val){
                parent = curr;
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        
        return null;
        
    }

}
