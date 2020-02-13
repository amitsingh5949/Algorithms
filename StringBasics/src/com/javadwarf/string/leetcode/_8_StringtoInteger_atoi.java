package com.javadwarf.string.leetcode;

import java.math.BigInteger;

public class _8_StringtoInteger_atoi {

	public static void main(String[] args) {

		String[] arr = {"+","+-2","-+2","-1", "42", "   -42","4193 with words", "words and 987", 
				"-91283472332","  0000000000012345678","20000000000000000000"};

		for(String str : arr) {
			System.out.println(new _8_StringtoInteger_atoi().myAtoi(str));
		}

	}

	public int myAtoi(String str) {

		int result = 0;

		int start = -1;
		int end = -1;

		for(int i=0; i<str.length(); i++) {

			char ch = str.charAt(i);

			if(ch != '-' && ch != '+' && ch != ' ' && !Character.isDigit(str.charAt(i))){
				break;
			}

			if((ch == '-' || ch == '+' ) && ( i==str.length()-1 || !Character.isDigit(str.charAt(i+1)) ) ) {
				break;
			}
			
			if(ch == '-' ||  ch == '+' || Character.isDigit(str.charAt(i))){
				start = i;
				end = extractDigits(str, i+1);
				break;
			}
		}

		if(start != -1 && end !=-1) {
			
			String digitStr = str.substring(start, end+1);

			BigInteger l = new BigInteger(digitStr);
			
			if(l.compareTo(new BigInteger(Integer.MAX_VALUE+"")) == 1) {
				result = Integer.MAX_VALUE;
			}
			else if(l.compareTo(new BigInteger(Integer.MIN_VALUE+"")) == -1) {
				result = Integer.MIN_VALUE;
			}
			else {
				result = l.intValue();
			}
		}
		return result;
	}

	public int extractDigits(String str , int start) {
		while(start<str.length() && Character.isDigit(str.charAt(start))){
			start++;
		}
		return start-1;
	}

}
