package com.javaDwarf.binaryTrees.misc;

import com.javaDwarf.binaryTrees.TreeNode;

public class ConstructTreefromInPreOrder {
	public static int current = 0;

	public static void main(String... args) {
		int[] preorder = 	{3,9,20,15,7};
		int[] inorder = 	{9,3,15,20,7};
		TreeNode n = buildTree(preorder, inorder);
		System.out.println(n);

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return construct(preorder, inorder, 0, inorder.length-1);
	}

	public static TreeNode construct(int[] preorder, int[] inorder, int start, int end){

		if (start > end) 
			return null;
		TreeNode currentNode = new TreeNode(preorder[current++]);

		int rootindex = -1;
		for(int i=start; i <= end; i++) {
			if(inorder[i]==currentNode.val) {
				rootindex=i;
			}
		}

		currentNode.left =  construct(preorder, inorder, start, rootindex-1);
		currentNode.right =  construct(preorder,inorder,  rootindex+1,  end);

		return currentNode;
	}

}
