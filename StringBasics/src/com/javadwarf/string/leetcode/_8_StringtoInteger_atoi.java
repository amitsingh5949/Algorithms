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
	//similar to question reverse integer
	//while reversing if your push can cause overflow. below condition to check for overflow
	  // postive  - push > Integer.MAX_VALUE/10  || (push == Integer.MAX_VALUE/10 && pop > 7)
	  //negative  - push < Integer.MIN_VALUE/10 || (push == Integer.MIN_VALUE/10 && pop < -8)
	public int myAtoi(String s) {

		Boolean isPostive = null;
		int push = 0;

		for( int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(isPostive == null && ch == ' ' ){
				continue;
			}
			else if(isPostive == null && ch == '+' ){
				isPostive = true;
			}
			else if(isPostive == null && ch == '-'){
				isPostive = false;
			}
			else if(Character.isDigit(ch)){
				if(isPostive == null) isPostive = true;
				int x = ch - '0';
				if( isPostive &&  ( push > Integer.MAX_VALUE/10 || (push == Integer.MAX_VALUE/10 && x > 7))) return Integer.MAX_VALUE;
				if( !isPostive && ( push*-1 < Integer.MIN_VALUE/10 || (push*-1 == Integer.MIN_VALUE/10 && x*-1 < -8))) return Integer.MIN_VALUE;
				push = push * 10 + x;   
			}
			else {
				break;
			}
		}

		return isPostive != null && isPostive  ? push : -1 * push;
	}

	public int myAtoi1(String str) {

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
