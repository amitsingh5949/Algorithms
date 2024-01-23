package com.javadwarf.maths.leetcode;

public class _66_PlusOne {

	public int[] plusOne(int[] digits) {

		int carry = 1;
		for( int i=digits.length-1;i>=0; i--){
			int temp = digits[i]+carry;
			digits[i] = temp % 10;
			carry = temp /10;
		}

		if( carry == 1){
			int[] x = new int[digits.length+1];
			x[0] = 1;
			for(int i=0; i<digits.length; i++) x[i+1] = digits[i];
			return x;
		}
		/* we do not need to iterate the digits array if is carry is 1 in end
        // We're here because all the digits are nines
            int[] x = new int[n + 1];
            x[0] = 1;
            return x;
        */
		return digits;

	}

}
