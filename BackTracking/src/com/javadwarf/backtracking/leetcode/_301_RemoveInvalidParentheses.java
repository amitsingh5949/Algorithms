package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _301_RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(new _301_RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
		System.out.println(new _301_RemoveInvalidParentheses().removeInvalidParentheses(")(()"));
	}

	List<String> res = null;

	Set<String> setBack = new HashSet<>();
	public List<String> removeInvalidParentheses(String s) {
		res = new ArrayList<String>();

		removeBackParantheses(0, s);

		return new ArrayList<String>(setBack);
	}

	public String  removeBackParantheses(int pos, String s) {

		if(pos == s.length()) {
			setBack.add(s);
			return s;
		}

		int count = 0;

		for(int i=pos; i<s.length(); i++) {

			if(s.charAt(i)=='(') {
				count += 1;
			}
			else if(s.charAt(i)==')') {
				count -= 1;
			}

			if(count < 0) {
				for(int j=0; j<i; j++) {
					if(s.charAt(j) == ')') {
						String newStr = s.substring(0,j) + s.substring(j+1, i) + s.substring(i);
						s = removeBackParantheses(i, newStr);
					}
				}
				count = 0;
			}
		}
		
		if(count >=0) {
			setBack.add(s);
			return s;
		}
		
		return s;
	}

}
