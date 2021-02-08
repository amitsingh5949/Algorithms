package com.javadwarf.stackbasics.leetcode.evalexpr;

import java.util.Stack;

public class _227_BasicCalculatorII {
	
	
	
	private Stack<String> stack ;
	private char prevSign ;
	private int num ;
	
	public int calculate(String s) {

		int result = 0;
		stack = new Stack<>();
		prevSign = '+';
		num  = 0;

		for(int i=0; i<s.length(); i++) {
			
			Character ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				num = num *10 + (ch-'0');
			}
			else if(ch == '+' || ch == '-' || ch =='*' || ch == '/') {
				helper(ch);
			}
			else if(ch == ' ') {
				continue;
			}
		}
		helper('+');
		while(!stack.isEmpty()) {
			result += Integer.parseInt(stack.pop());
		}
		return result;
	}
	
	private void helper(char ch) {
		if(prevSign == '-') {
			num *= -1;
		}
		else if(prevSign == '*') {
			num = num * Integer.parseInt(stack.pop());
		}
		else if(prevSign == '/') {
			num =  Integer.parseInt(stack.pop()) / num;
		}
		stack.push(Integer.valueOf(num).toString());
		num = 0;
		prevSign = ch;
	}

}
