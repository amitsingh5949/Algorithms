package com.javadwarf.leetcode;

public class _66_PlusOne {

	public static void main(String[] args) {

		
		new _66_PlusOne().plusOne(new int[] {1,9});
	}

	public int[] plusOne(int[] digits) {

		int carry = 0;
		
		if(digits[digits.length-1] == 9) {
			digits[digits.length-1] = 0;
			carry = 1;
		}
		else {
			digits[digits.length-1] += 1;
			return digits;
		}

		for(int i = digits.length-2; i>=0; i--) {

			int x = digits[i] + carry;
			
			if(x >=10) {
				digits[i] = 0;
				carry = 1;
			}
			else {
				digits[i] += 1;
				return digits;
			}
		}
		
		if(carry == 1) { // carry can only be one if all the elements in array are 9
			int[] res = new int[digits.length+1];
			res[0] = 1;
			return res;
		}
		
		return digits;
	}
}
