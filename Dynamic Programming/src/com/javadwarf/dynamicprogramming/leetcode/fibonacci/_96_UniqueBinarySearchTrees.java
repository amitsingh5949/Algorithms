package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _96_UniqueBinarySearchTrees {

	public int numTrees(int n) {
		return numTrees(n,new int[n]);
	}

	/*

	 Unique BST for n= 6 would be  = { Num ofBSt with root 1 +  Num ofBSt with root 2 + Num ofBSt with root 3 + Num ofBSt with root 4 + Num ofBSt with root 5  + Num ofBSt with root 6}
	  Num ofBSt with root 1 = (nums of bst with n =0 on left ) * (number of bst with n = 5 on right)  as    {} <- 1 ->{2,3,4,5,6}
	  .
	  .
	  Num ofBSt with root 3 = (nums of bst with n =2 on left ) * (number of bst with n = 3 on right)  as    {1,2} <- 3 ->{4,5,6}
	  .
	  .

	 */

	public int numTrees(int n, int[] arr) {

		if(n==0 || n==1) return 1;

		if(arr[n] != 0) return arr[n];

		int start = 0;
		int end = n-1;
		while(start<n && end>=0) {
			arr[n] += numTrees(start, arr) * numTrees(end, arr);
			start++;
			end--;
		}

		return arr[n];
	}

	// Catalan number 

	// F(n+1) = (2*(2n+1)/(n+2)) * F(n)
	public int numTreesFormula(int n) {
		long c = 1 ;
		for(int i= 0; i<n; i++) {
			c = c * 2*(2*i+1) / (i+2) ;
		}
		return (int)c; 
	}

}
