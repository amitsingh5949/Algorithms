package com.javaDwarf.binaryTrees.leetcode;

public class _235_LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode ancenstor  = null;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.ancenstor  = null;
		lowestCommonAncestorRec(root, p, q);
		return this.ancenstor;
	}

	public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {

		if(root == null) return null;

		TreeNode left = lowestCommonAncestorRec(root.left, p, q);
		TreeNode right = lowestCommonAncestorRec(root.right, p, q);

		if( (left != null && right!=null) || ((left != null || right != null ) && (root.val == p.val || root.val == q.val))) {
			this.ancenstor = root;
			return root;
		}
		if(left != null && right==null){
			return left;
		}
		else if(left == null && right!=null){
			return right;
		}
		
		if(root.val == p.val || root.val == q.val) return root;
		
		return null;
	}
	
	// Neater solution 
	public  TreeNode lowestCommonAncestor1(TreeNode root, TreeNode n1,TreeNode n2) {
		if(root != null) {
			if(root.val==n1.val || root.val==n2.val) {
				return root;
			}
			TreeNode left = lowestCommonAncestor1(root.left,n1,n2);
			TreeNode right = lowestCommonAncestor1(root.right,n1,n2);

			if(left !=null && right==null) {
				root =  left;
			}
			else if(left ==null && right!=null) {
				root =  right;
			}
			else if(left ==null && right==null) {
				root =  null;
			}
		}
		return root;
	}
	
	//even neater solution
	// idea is we are expecting two trues from left and right sub tree if the numbers are found and 1 true can be expected if the root itself is p or q
	// so if count is 2 or more that means its an LCA, however if count > 0 that means its not LC but this subtree should return true
	TreeNode result;
    public TreeNode lowestCommonAncestor11(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return result;
    }
    
    private boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        int count = 0;
        count += helper(root.left,p,q)?1:0;
        count += helper(root.right,p,q)?1:0;
        count += (root.val==p.val ||root.val==q.val)?1:0;
        if(count>1)result=root;
        return count>0;
    }

}
