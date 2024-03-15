package com.javadwarf.greedy.leetcode;

public class _921_MinimumAddtoMakeParenthesesValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minAddToMakeValid(String s) {

		int count = 0;
		int res = 0;

		for(int i=0; i<s.length(); i++){

			if(s.charAt(i) == '('){
				count++;
			}

			else if(s.charAt(i) == ')'){
				count--;
			}

			if(count < 0){
				count++;
				res++;
			}

		}

		return res+count;

	}

}
