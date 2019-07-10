package com.javadwarf.string.leetcode;

public class _541_ReverseStringII {

	public static void main(String[] args) {
		System.out.println(new _541_ReverseStringII().reverseStr("abcdefg", 2));
	}

	public String reverseStr(String s, int k) {

		if(s == null || s.length() == 0) return s;

		char[] charArr = s.toCharArray();

		boolean flag = true;

		for(int i=0; i < s.length() ; i+= k) {

			if(flag) {
				int start = i;
				int end = ( (start+k-1) <= charArr.length-1) ? start+k-1 : charArr.length-1;

				while(start < end) {
					char ch = charArr[start];
					charArr[start] = charArr[end];
					charArr[end] = ch;
					start++;
					end--;
				}
				flag = false;
			}
			else {
				flag = true;
			}
		}
		return new String(charArr);
	}
}
