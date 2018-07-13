package com.javaDwarf.binaryTrees.misc;

import com.javaDwarf.binaryTrees.dfs.Node;

public class IsomorphicTrees {

	public static void main(String[] args){

	}

	public static boolean isIsomorphic(Node root1,Node root2){
		return isIsomorphic(root1, root2, true);
	}

	public static boolean isIsomorphic(Node a,Node b, boolean b1){
		if(a==null && b ==null) {
			return true;
		}
		if((a==null&&b!=null)||(a!=null&&b==null)){
			return false;
		}
		
		if(a.left==null && b.left!=null && a.right!=null && b.right==null ) {
			if(a.right.data==b.left.data) {
				b.right = b.left;
				b.left=null;
			}
			else {
				b1=false;
			}
		}
		if (a.left!=null && b.left==null && a.right==null && b.right!=null) {
			if( a.left.data==b.right.data) {
				b.left = b.right;
				b.right=null;
			}
			else {
				b1=false;
			}
		}
		if(a.left!=null&&b.left!=null &&a.right!=null && b.right!=null) {
			if(a.right.data==b.left.data && a.left.data==b.right.data) {
				Node temp = b.left;
				b.left = b.right;
				b.right=temp;
			}
			else {
				b1=false;	
			}
		}
		
		boolean left = isIsomorphic(a.left, b.left, b1);
		boolean right =isIsomorphic(a.right, b.right, b1);
		
		return left && right;
	}
}
