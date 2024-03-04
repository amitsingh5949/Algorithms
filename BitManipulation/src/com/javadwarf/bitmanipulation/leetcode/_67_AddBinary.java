package com.javadwarf.bitmanipulation.leetcode;

public class _67_AddBinary {

	public String addBinary(String a, String b) {

		if(a.length() > b.length()) return addBinary(b, a);

		int l1 = a.length();
		int l2 = b.length();

		for( int i=0; i<(l2-l1); i++){
			a = "0" + a;
		}


		StringBuffer res = new StringBuffer();
		int carry = 0;

		for(int i=l2-1; i>=0; i--){

			int ch1 = a.charAt(i) - '0';
			int ch2 = b.charAt(i) - '0';

			int sum = ch1 + ch2 + carry;

			res.insert(0,sum %2)  ;
			carry = sum /2;

		}
		return (carry == 1 ) ? 1+res.toString() : res.toString();

	}

}
