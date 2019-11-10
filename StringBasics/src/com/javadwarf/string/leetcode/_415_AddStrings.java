package com.javadwarf.string.leetcode;

public class _415_AddStrings {

	public static void main(String[] args) {
		System.out.println(new _415_AddStrings().addStrings("124", "999"));

	}

	public String addStrings(String num1, String num2) {

		if(num1.length() > num2.length()) {
			num2 = addZeros(num2, (num1.length() - num2.length()));
		}
		else {
			num1 = addZeros(num1, (num2.length() - num1.length()));
		}

		StringBuffer sb = new StringBuffer();
		int carry = 0;

		for(int i =num1.length()-1; i>=0; i--) {
			int ch1 = num1.charAt(i) -'0';
			int ch2 = num2.charAt(i) -'0';

			sb.insert(0, (ch1+ch2+carry)%10);
			carry = (ch1+ch2+carry)/10;
		}
		if(carry !=0) {
			sb.insert(0, carry);
		}

		return sb.toString();
	}

	public String addZeros(String s, int num) {
		if( num ==0) return s;
		String temp = "";
		for(int i =0 ; i<num;i++) {
			temp += "0";
		}
		temp += s;
		return temp;
	}

}
