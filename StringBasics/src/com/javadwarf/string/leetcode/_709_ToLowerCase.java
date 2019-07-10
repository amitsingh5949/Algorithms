package com.javadwarf.string.leetcode;

public class _709_ToLowerCase {

	public String toLowerCase(String str) {
		
		String result  = "";
		
		for(int i =0 ; i< str.length(); i++) {
			int code = str.charAt(i);
			if(code>=65 && code<=90) {
				code = code + 32;
			}
			result += (char)code;
		}
		
		return result;

	}

}
