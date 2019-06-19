package com.javadwarf.maths.leetcode;

public class _7_ReverseInteger {

	
	// use modules of 10 and power of 10, below solution is working but uses more memory and time
	public int reverse(int x) {

		int isNegative = x<0?-1:1;

		char[] arr = Integer.valueOf(Math.abs(x)).toString().toCharArray();
		int start = 0;
		int end = arr.length-1;

		while(start<end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end]  = temp;
			start++;
			end--;
		}
		int result = 0;
		try {
			result =  Integer.parseInt(new String(arr)) * isNegative;
		}
		catch(NumberFormatException e) {
			result = 0;
		}
		return result;  
	}

}
