package com.javaDwarf.binaryTrees.leetcode;

public class _255_VerifyPreorderSequenceinBinarySearchTree {

	public static void main(String[] args) {

	}

	// wrong logic
	public boolean verifyPreorder(int[] preorder) {

		if(preorder == null || preorder.length <= 2) return true;

		boolean increasing = true;
		boolean decreasing = true;
		boolean decreasingIncreasing = true;

		if(preorder[0] < preorder[1]) {
			decreasing = false;
			decreasingIncreasing = false;
			for(int i=0; i<preorder.length-1;i++) {
				if(preorder[i] > preorder[i+1]) {
					increasing = false;
					break;
				}
			}
		}
		else {
			increasing = false;
			int i=0;
			for(i=0; i<preorder.length-1;i++) {
				if(preorder[i] < preorder[i+1]) {
					decreasing = false;
					break;
				}
			}
			for(; i<preorder.length-1;i++) {
				if(preorder[i] > preorder[i+1]) {
					decreasingIncreasing = false;
					break;
				}
			}
		}

		return (increasing || decreasing || decreasingIncreasing);

	}

}
