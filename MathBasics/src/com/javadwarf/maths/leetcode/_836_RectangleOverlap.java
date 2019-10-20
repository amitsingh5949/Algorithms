package com.javadwarf.maths.leetcode;

public class _836_RectangleOverlap {

	public static void main(String[] args) {

	}
	
// trick is find condition where they will not overlap and then return not of result
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		boolean res = 	rec1[2] <= rec2[0] || 
				rec2[2] <= rec1[0] ||
				rec1[3] <= rec2[1] || 
				rec2[3] <= rec1[1] ;

		return !res;
	}

}
