package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _1047_RemoveAllAdjacentDuplicatesInString {


	public static void main(String[] args) {
		System.out.println(new _1047_RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String S) {

		StringBuffer result = new StringBuffer("");

		Stack<Character> s = new Stack<>();

		if(S == null || S.length() ==0) return "";

		for(int i=0; i<S.length(); i++ ) {

			Character  ch = S.charAt(i);

			if(!s.isEmpty() && s.peek() == ch) {
				while(!s.isEmpty() && s.peek() == ch) {
					s.pop();
				}
			}
			else {
				s.push(ch);
			}
		}

		while(!s.isEmpty()) {
			result.insert(0,s.pop());
		}

		return result.toString() ;

	}

}
