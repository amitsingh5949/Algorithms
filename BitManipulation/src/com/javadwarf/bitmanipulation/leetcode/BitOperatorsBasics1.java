package com.javadwarf.bitmanipulation.leetcode;

public class BitOperatorsBasics1 {

	public static void main(String[] args) {

		String str1 = Integer.toBinaryString(-78);

		String str2 = toBinaryString(-78);
		System.out.println(str1 + " " + str1.length());
		System.out.println(str2 + " " + str2.length());

		System.out.println(Integer.toBinaryString(13).equalsIgnoreCase(toBinaryString(13)));

		System.out.println(Integer.toBinaryString(24).equalsIgnoreCase(toBinaryString(24)));

		System.out.println(Integer.toBinaryString(177).equalsIgnoreCase(toBinaryString(177)));

		System.out.println(Integer.toBinaryString(2).equalsIgnoreCase(toBinaryString(2)));

		System.out.println(Integer.toBinaryString(1).equalsIgnoreCase(toBinaryString(1)));

		System.out.println(Integer.toBinaryString(0).equalsIgnoreCase(toBinaryString(0)));

		System.out.println(Integer.toBinaryString(-2).equalsIgnoreCase(toBinaryString(-2)));
		
		System.out.println(Integer.toBinaryString(789568).equalsIgnoreCase(toBinaryString(789568)));
		
		System.out.println(Integer.toBinaryString(9568).equalsIgnoreCase(toBinaryString(789568)));
		
	}

	public static String toBinaryString(int num) {

		if(num == 0 || num ==1) return "" + num;

		if(num < 0) {
			num = getTwosCompliment(num);
		}

		String result = "";

		int quotient  = num;

		while(quotient > 1) {
			result = quotient % 2 + result;
			quotient = quotient / 2;
		}
		return   quotient + result;
	}

	public static int getTwosCompliment(int num) {
		return (int)Math.pow(2.0, 32.0) + num;
	}

}
