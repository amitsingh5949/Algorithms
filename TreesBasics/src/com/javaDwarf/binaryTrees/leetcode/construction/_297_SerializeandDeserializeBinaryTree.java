package com.javaDwarf.binaryTrees.leetcode.construction;

import com.javaDwarf.binaryTrees.TreeNode;
/*
 * a.)
 * If we are trying to solve serialize/deserialize question by 
 *  1. Find inorder and preorder in string
 *  2. then use the string to construct preorder/ inorder array and construct tree
 * 
 * The above logic fails if the tree has duplicates, anyway two different trees can produce the same in/preorder
 * 
 * b.)
 * We need to use preorder traversal only
 * 
 */
public class _297_SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left =t2;
		t1.right =t3;
		t3.left=t4;
		t3.right =t5;
		String x = new _297_SerializeandDeserializeBinaryTree().serialize(t1);
		TreeNode r = new _297_SerializeandDeserializeBinaryTree().deserialize(x);


	}

	public String serialize(TreeNode root) {
		return preorder(root, "");
	}

	public String preorder(TreeNode root, String res){
		if(root == null) return res+"null,";
		res  += root.val+",";;
		res = preorder(root.left, res);
		res = preorder(root.right, res);
		return res;
	}

	public static int current = 0;
	public TreeNode deserialize(String data) {
		current = 0;
		String[] arr = data.split(",");
		return deserialize(arr);
	}


	public TreeNode deserialize(String[] arr) {

		if(arr[current].equals("null")) {
			current++;
			return null;
		}
		int i =  Integer.parseInt(arr[current]);
		current++;
		
		TreeNode root = new TreeNode(i);
		
		root.left = deserialize(arr);
		root.right = deserialize(arr);
		
		return root;
	}


	/* logic a.) pre/in order - doesn't work
	 
	 
	public static int current = 0;
	public String serialize(TreeNode root) {
		current = 0;
		String res ="";
		res = preorder(root, res);
		res +="#";
		res = inorder(root, res);
		return res;
	}


	public String inorder(TreeNode root, String res){
		if(root == null) return res;
		res = inorder(root.left, res);
		res  += root.val+",";
		res = inorder(root.right, res);
		return res;
	}

	public String preorder(TreeNode root, String res){
		if(root == null) return res;
		res  += root.val+",";;
		res = preorder(root.left, res);
		res = preorder(root.right, res);
		return res;
	}

	public TreeNode deserialize(String data) {

		if(data.equals("#")) return null;

		String[] arr = data.split("#");
		String[] preorderStr = arr[0].split(",");
		String[] inorderStr = arr[1].split(",");

		int[] preorder = new int[preorderStr.length];
		int[] inorder = new int[inorderStr.length];

		for(int i= 0; i<preorder.length; i++) {
			preorder[i] = Integer.parseInt(preorderStr[i]);
			inorder[i] = Integer.parseInt(inorderStr[i]);
		}

		return buildTree(preorder, inorder);
	}



	public  TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, inorder.length-1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

		if(start > end) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[current]);

		int mid = -1;
		for(int i=start ; i<=end; i++) {
			if(preorder[current] == inorder[i]) {
				mid = i;
				break;
			}
		}

		current++ ;

		root.left = buildTree(preorder, inorder, start, mid-1);
		root.right = buildTree(preorder, inorder, mid+1, end);

		return root;
	}

	 */

}
