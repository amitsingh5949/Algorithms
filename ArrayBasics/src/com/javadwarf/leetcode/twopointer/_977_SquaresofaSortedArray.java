package com.javadwarf.leetcode.twopointer;

public class _977_SquaresofaSortedArray {

	public static void main(String[] args) {

		sortedSquares(new int[] {-4,-1,0,3,10});
		System.out.println();
		sortedSquares(new int[] {-7,-3,2,3,11});
	}

	public static int[] sortedSquares(int[] A) {

		if(A == null || A.length == 0) return A;

		int[] squaredArr = new int[A.length];

		int begin = 0 ;
		int end = A.length-1;

		int count = A.length-1;
		while(begin <= end) {

			int beginSqr = A[begin] * A[begin];
			int endSqr = A[end] * A[end];

			if(beginSqr > endSqr) {
				squaredArr[count--] = beginSqr;
				begin++;
			}
			else {
				squaredArr[count--] = endSqr;
				end--;
			}
		}
		for(int x : squaredArr) {
			System.out.print(x +" ");
		}
		return squaredArr;

	}

}
