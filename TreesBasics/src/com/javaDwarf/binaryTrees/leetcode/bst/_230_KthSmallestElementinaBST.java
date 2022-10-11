package com.javaDwarf.binaryTrees.leetcode.bst;

import java.util.Stack;

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
    
    
public int kthSmallestIterativeO(TreeNode root, int k) {
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            s.add(temp);
            temp= temp.left;
        }
        
        while(true){
            temp = s.pop();
            k--;
            if(k == 0){
                return temp.val;
            }
            temp = temp.right;
            while(temp != null){
                s.add(temp);
                temp= temp.left;
            }
        }
    }
}
