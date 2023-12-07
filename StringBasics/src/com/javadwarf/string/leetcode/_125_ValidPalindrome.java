package com.javadwarf.string.leetcode;

public class _125_ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(new _125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}

	//ignore non alphanumeric chars and check palindrom

	public boolean isPalindromeBest(String s) {

		if(s == null) return false;
		s = s.toLowerCase();

		int i = 0;
		int j = s.length()-1;
		while(i<j){
			if(!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
			else if(!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j--;
			else if( s.charAt(i++) != s.charAt(j--) ) return false;
		}
		return true;
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

	// remove all unnecessary chars and check palindrome

	public boolean isPalindrome1(String s) {

		if(s == null) return false;

		StringBuffer sb = new StringBuffer(s);

		for(int i=0; i<sb.length(); i++){
			if(!Character.isLetter(sb.charAt(i)) && !Character.isDigit(sb.charAt(i))){
				sb = sb.deleteCharAt(i--);// note index is reduced and size of string reduces after deleting car
			}
		}
		s = sb.toString().toLowerCase();

		int i = 0;
		int j = s.length()-1;
		while(i<j){
			if( s.charAt(i++) != s.charAt(j--) ) return false;
		}
		return true;
	}


}

