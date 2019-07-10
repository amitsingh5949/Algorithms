package com.javadwarf.string.leetcode;

public class _557_ReverseWordsinaStringIII {

	public static void main(String[] args) {
		System.out.println(new _557_ReverseWordsinaStringIII().reverseWords("take leet"));
	}

	public String reverseWords(String s) {

		if(s == null || s.length() == 0) return s;

		char[] charArr = s.toCharArray();

		int start = 0;
		int end = 0;
		int i =0;
		while(i<s.length()-1) {

			while( i<s.length()-1 && charArr[i]!= ' ') {
				i++;
			}
			if(charArr[i] == ' ')
				end = i-1;
			else {
				end = i;
			}

			while(start< end) {
				char ch = charArr[start];
				charArr[start] = charArr[end];
				charArr[end] = ch;
				start++;
				end--;
			}

			start = ++i;

		}
		return new String(charArr);
	}
}
