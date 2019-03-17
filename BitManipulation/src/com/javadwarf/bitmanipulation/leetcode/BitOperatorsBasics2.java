package com.javadwarf.bitmanipulation.leetcode;

public class BitOperatorsBasics2 {

	public static void main(String[] args) {
		
		String str1 = Integer.toBinaryString(5);
		String str2 = Integer.toBinaryString( 5 << 1);
		System.out.println(str1 + " -- " +str2);
		
		String str3 = Integer.toBinaryString(5);
		String str4 = Integer.toBinaryString( 5 >> 1);
		System.out.println(str3 + " -- " +str4);
		
		

	}
	
	
	public static boolean findKthBitIsSetOrNot(int num, int k){
		
		return ((num & (1 << k-1)) == 0) ? true : false;
		
	}
	

}
