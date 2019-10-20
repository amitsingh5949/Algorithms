package com.javaDwarf.binaryTrees.leetcode.construction;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

/*
 * Two way to do it :
 * 
 * 1. Use preorder and construct the tree same as _297_
 * 2. Get inorder and use inorder to create tree
 */
public class _449_SerializeandDeserializeBST {

	public static void main(String[] args) {

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

}
