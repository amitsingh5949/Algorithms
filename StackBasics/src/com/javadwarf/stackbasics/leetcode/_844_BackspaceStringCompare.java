package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _844_BackspaceStringCompare {

	public boolean backspaceCompare(String S, String T) {

		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack <>();

		int i= 0;
		while(i<S.length()) {
			if(S.charAt(i) != '#') {
				s1.push(S.charAt(i));
			}
			else {
				if(!s1.isEmpty()) {
					s1.pop();
				}
			}
			i++;
		}

		i= 0;
		while(i<T.length()) {
			if(T.charAt(i) != '#') {
				s2.push(T.charAt(i));
			}
			else {
				if(!s2.isEmpty()) {
					s2.pop();
				}
			}
			i++;
		}



		if(s1.size() != s2.size()) {
			return false;
		}

		boolean result = true;	
		while(!s1.isEmpty()) {
			if(s1.pop() != s2.pop()) {
				result = false;
				break;
			}
		}

		return result;

	}

}
