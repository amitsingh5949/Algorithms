package com.javadwarf.string.leetcode;

public class _125_ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(new _125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}

	public boolean isPalindrome(String s) {

		if ( s == null || s.length() ==0) return true;

		char[] charArr = s.toCharArray();		
		int start = 0;
		int end = charArr.length-1;

		while(start <= end) {

			while(start < end && !(Character.isLetter(charArr[start]) || Character.isDigit(charArr[start]))){
				start++;
			}
			while(start < end && !(Character.isLetter(charArr[end]) || Character.isDigit(charArr[end]))){
				end--;
			}

			if(start < end) {
				if(Character.toLowerCase(charArr[start]) != Character.toLowerCase(charArr[end])) {
					return false;
				}
			}
			else {
				break;
			}

			start++;
			end--;
		}

		return true;

	}

}
