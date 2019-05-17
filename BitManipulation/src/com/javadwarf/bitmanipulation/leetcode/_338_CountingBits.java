package com.javadwarf.bitmanipulation.leetcode;

public class _338_CountingBits {

	public static void main(String[] args) {
System.out.println(0b11001000);
System.out.println(0b11000111);
	}

	public int[] countBits(int num) {

		int[] bitCounter = new int[num+1];

		for(int i = 0; i <= num ; i++) {
			bitCounter[i] = hammingWeight(i);
		}
		return bitCounter;
	}

	public static int hammingWeight(int n) {
		int count  = 0;

		while(n != 0) {
			n = n & (n-1);
			count ++;
		}

		return count;

	}
	// DP - approach
	public int[] countBits1(int num) {

		int[] bitCounter = new int[num+1];

		for(int i = 1; i <= num ; i++) {
			bitCounter[i] = bitCounter[i & (i-1)] + 1;
		}
		return bitCounter;
	}

}
