package com.java.binaryserach.leetcode;

public class _367_ValidPerfectSquare {

	public static void main(String[] args) {
		
		//System.out.println(10/3);

		for(int i = 0; i< 59; i++) {
			System.out.println(i +":"+new _367_ValidPerfectSquare().isPerfectSquare(i));
		}
		
		//System.out.println(10 + ":" + new _367_ValidPerfectSquare().isPerfectSquare(25));
	}

	public boolean isPerfectSquare(int num) {

		if(num == 1) return true;

		int start = 1;
		int end = num;

		int mid = start + (end - start)/2;

		while(start <= end) {
			mid = start + (end - start)/2;

			double x = ((double)num)/mid;
			double y = Math.ceil(x);
			if(mid == num/mid && (x-y)==0) {
				return true;
			}
			else if(mid > num/mid) {
				end = mid -1;
			}
			else {
				start = mid+1;
			}
		}
		return false;
	}
}
