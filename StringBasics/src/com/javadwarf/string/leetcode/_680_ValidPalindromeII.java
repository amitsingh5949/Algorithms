package com.javadwarf.string.leetcode;

public class _680_ValidPalindromeII {

	public static void main(String[] args) {
		//System.out.println(new _680_ValidPalindromeII().validPalindrome("ebcbb e cecabbacec bbcbe"));
		System.out.println(new _680_ValidPalindromeII().validPalindrome("eceec"));
	}

	public boolean validPalindrome(String s) {

		int start = 0;
		int end = s.length()-1;

		boolean flag = true;

		while(start < end) {

			if(s.charAt(start) != s.charAt(end) && flag) {
				if(s.charAt(start) == s.charAt(end-1) && s.charAt(start+1) == s.charAt(end)) {
					return isPalindrom(s.substring(start, end)) || isPalindrom(s.substring(start+1,end+1));
				}
				else if(s.charAt(start) == s.charAt(end-1)) {
					end--;
					flag = false;
					continue;
				}
				else if(s.charAt(start+1) == s.charAt(end)) {
					start++;
					flag = false;
					continue;
				}
				else {
					return false;
				}
			}
			else if(s.charAt(start) != s.charAt(end) && !flag) {
				return false;
			}

			start++;
			end--;
		}

		return true;
	}
	
	public boolean isPalindrom(String s ) {
		int start = 0;
		int end = s.length()-1;

		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

}
