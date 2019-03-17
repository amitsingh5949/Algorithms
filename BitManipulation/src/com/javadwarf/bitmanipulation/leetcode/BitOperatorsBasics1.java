package com.javadwarf.bitmanipulation.leetcode;

public class BitOperatorsBasics1 {

	public static void main(String[] args) {
		
		String str1 = Integer.toBinaryString(-2);
		
		String str2 = toBinaryString(-2);
		System.out.println(str1);
		System.out.println(str2);
		
		
		System.out.println(Integer.toBinaryString(13).equalsIgnoreCase(toBinaryString(13)));
		
		System.out.println(Integer.toBinaryString(24).equalsIgnoreCase(toBinaryString(24)));
		
		System.out.println(Integer.toBinaryString(177).equalsIgnoreCase(toBinaryString(177)));
		
		System.out.println(Integer.toBinaryString(2).equalsIgnoreCase(toBinaryString(2)));
		
		System.out.println(Integer.toBinaryString(1).equalsIgnoreCase(toBinaryString(1)));
		
		System.out.println(Integer.toBinaryString(0).equalsIgnoreCase(toBinaryString(0)));
		
		System.out.println(Integer.toBinaryString(-2).equalsIgnoreCase(toBinaryString(-2)));

	}
	
	public static String toBinaryString(int num) {
		
		if(num < 0) return "";
		
		if(num == 0 || num ==1) return "" + num;
		
		String result = "";
		
		int quotient  = num;
		
		while(quotient > 1) {
			result = quotient % 2 + result;
			quotient = quotient / 2;
		}
		return   quotient + result;
	}

}
