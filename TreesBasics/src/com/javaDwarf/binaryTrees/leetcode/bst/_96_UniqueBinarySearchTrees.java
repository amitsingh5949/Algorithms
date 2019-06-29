package com.javaDwarf.binaryTrees.leetcode.bst;


public class _96_UniqueBinarySearchTrees {

	public static void main(String[] args) {

	}

	public int numTrees(int n) {

		int c1 = 1 ;
		int c2 = 0; 
		for(int i= 0; i<n; i++) {
			//c2 = c1 * ( (2*i+1) / ((i+1)*(i+2)) );
			c2 = c1*2*(2*i+1) / (i+2);
			c1 = c2;
		}
		return c2;


	}

}
