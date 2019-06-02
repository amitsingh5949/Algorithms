package com.javadwarf.string.leetcode;

public class _344_ReverseString {

	public void reverseString(char[] s) {

		if(s == null || s.length == 0) return;

		for(int start =0,end = s.length-1; start< end; start++,end-- ) {
			char ch = s[start];
			s[start] = s[end];
			s[end] = ch;
		}

	}

}
