package com.javadwarf.stackbasics.leetcode.evalexpr;

import java.util.Stack;

public class _224_BasicCalculator {

	public static void main(String[] args) {
		
		String[] arr1 = {
				"1 + 1",
				" 2-1 + 2 ",
				"(1+(4+5+2)-3)+(6+8)",
				"-1+1",
				"(-23+2)",
				"-1-4"
		};
		
		
		String[] arr = {
				"1-(5)",
				"2*(5)"
		};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i] +" : "+new _224_BasicCalculator().calculate(arr[i]));
		}
	}
	
	private Stack<String> stack = new Stack<>();
	private char prevSign = '+';
	private int num  = 0;
	
	public int calculate(String s) {

		int result = 0;
		stack = new Stack<>();
		prevSign = '+';
		num  = 0;

		for(int i=0; i<s.length(); i++) {
			
			Character ch = s.charAt(i);

			if(ch == '(') {
				helper('+');
				stack.push(prevSign+ch.toString());
			}
			else if(ch == ')') {
				helper(prevSign);
				while(!stack.isEmpty() && !stack.peek().contains("(")) {
					num += Integer.parseInt(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek().equals("(")) {
					String str = stack.pop();
					prevSign = str.charAt(0);
				}
				helper('+');
			}
			else if(Character.isDigit(ch)) {
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


