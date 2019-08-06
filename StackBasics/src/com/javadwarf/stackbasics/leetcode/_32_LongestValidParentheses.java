package com.javadwarf.stackbasics.leetcode;

public class _32_LongestValidParentheses {

	public static void main(String[] args) {
		String str = ")()(((())))(";
		System.out.println(new _32_LongestValidParentheses().longestValidParentheses(str));

	}

	// There is Dp based solution and stack based solution 
	// This is O(n) + O(1) 
	public int longestValidParentheses(String s) {

		if(s == null || s.length() <2) return 0;

		int len = 0;
		int start = 0;
		int leftBracketCount = 0;
		int rightBracketCount = 0;

		for(int i=0;i<s.length(); i++) {

			if(s.charAt(i) == '(') 
				leftBracketCount++;
			else 
				rightBracketCount++;

			if(rightBracketCount > leftBracketCount) {
				start = i+1;
				leftBracketCount = 0;
				rightBracketCount = 0;
			}
			else if(rightBracketCount == leftBracketCount) {
				len = Integer.max(len, i-start+1);
			}
		}

		start = s.length()-1;
		leftBracketCount = 0;
		rightBracketCount = 0;

		for(int i=s.length()-1;i>=0; i--) {

			if(s.charAt(i) == '(') 
				leftBracketCount++;
			else 
				rightBracketCount++;

			if(leftBracketCount > rightBracketCount) {
				start = i-1;
				leftBracketCount = 0;
				rightBracketCount = 0;
			}
			else if(leftBracketCount == rightBracketCount) {
				len = Integer.max(len, start -i +1);
			}
		}
		return len;
	}

}
