package com.javadwarf.bitmanipulation.leetcode;

public class _191_Numberof1Bits {
	
	public static void main(String[] args) {
		int count = hammingWeight(15);
		
		
		System.out.println(count  + " " + Integer.toBinaryString(15));
		
	}

	public static int hammingWeight(int n) {
		int count  = 0;
		
		for(int i=0; i<32; i++) {
			if((n & (1 << i)) != 0) {
				count++;
			}
		}
		
		return count;

	}

}
