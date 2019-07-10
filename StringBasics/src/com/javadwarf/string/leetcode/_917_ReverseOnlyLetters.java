package com.javadwarf.string.leetcode;

public class _917_ReverseOnlyLetters {
	
	public static void main(String[] args) {
		System.out.println(new _917_ReverseOnlyLetters().reverseOnlyLetters("?6C40E"));
	}

	public String reverseOnlyLetters(String S) {

		if ( S == null || S.length() ==0) return S;
		char[] charArr = S.toCharArray();		
		int start = 0;
		int end = charArr.length-1;

		while(start < end) {

			while( start < charArr.length && start < end && !Character.isLetter(charArr[start])){
				start++;
			}
			while(end >=0 && start < end && !Character.isLetter(charArr[end])){
				end--;
			}

			if(start < charArr.length && end >= 0) {
				char ch = charArr[start];
				charArr[start] = charArr[end];
				charArr[end] = ch;
			}
			else {
				break;
			}
			start++;
			end--;
		}

		return new String(charArr);

	}

}
