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

}
