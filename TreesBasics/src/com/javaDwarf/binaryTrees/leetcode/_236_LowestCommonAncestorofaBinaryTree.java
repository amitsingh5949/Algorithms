package com.javaDwarf.binaryTrees.leetcode;

public class _236_LowestCommonAncestorofaBinaryTree {
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
	public  TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p,TreeNode q) {
		
		if( root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;// don't need to go further down to check second element
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        
        return null;
	}
	
	//above solution is better
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
