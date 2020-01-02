package com.javadwarf.stackbasics.leetcode;

public class _1249_MinimumRemovetoMakeValidParentheses {

	public static void main(String[] args) {
		System.out.println(new _1249_MinimumRemovetoMakeValidParentheses().minRemoveToMakeValid("(()()))"));
	}

	public String minRemoveToMakeValid(String s) {

		StringBuilder res = new StringBuilder();
		int count = 0;

		for(int i =0; i<s.length();i++) {
			if(s.charAt(i) == '(') {
				count += 1;
			}
			else if(s.charAt(i) == ')') {
				count -= 1;
			}
			if(count >=0 ) {
				res.append(s.charAt(i));
			}
			else {
				count = 0;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i=res.length()-1 ; i>=0; i--) {

			if(count > 0 && res.charAt(i) == '(') {
				count -= 1;
			}
			else {
				sb.insert(0, res.charAt(i));
			}
			
			if(count ==0) {
				sb.insert(0,res.substring(0,i));
				break;
			}
		}
		return sb.toString();
	}

}
