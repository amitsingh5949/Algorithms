package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {

	public static void main(String[] args) {

	}

	public int evalRPN(String[] tokens) {

		Stack<String> stack = new Stack<>();

		for(String token : tokens){
			if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")  ){
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				if(token.equals("+")){
					stack.push(Integer.valueOf(num1+num2).toString());
				}
				else if(token.equals("-")){
					stack.push(Integer.valueOf(num2-num1).toString());
				}   
				else if(token.equals("*")){
					stack.push(Integer.valueOf(num1*num2).toString());
				}
				else{
					int num = (int)Math.floor(num2/num1);
					stack.push(Integer.valueOf(num).toString());
				}
			}    
			else stack.push(token);
		}
		return Integer.parseInt(stack.pop());
	}

}
