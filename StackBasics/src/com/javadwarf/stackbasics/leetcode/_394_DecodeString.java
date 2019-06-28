package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _394_DecodeString {

	public static void main(String[] args) {
		System.out.println(new _394_DecodeString().decodeString("3[a]2[bc]"));
		System.out.println(new _394_DecodeString().decodeString("3[a2[c]]"));
		System.out.println(new _394_DecodeString().decodeString("2[abc]3[cd]ef"));
		System.out.println(new _394_DecodeString().decodeString("100[ef]"));

	}
	public String decodeString(String s) {
		
		if(s==null || s.length() == 0) return s;
		
		StringBuffer result = new StringBuffer("");
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch == ']') {
				
				StringBuffer temp = new StringBuffer("");
				while(!stack.isEmpty() && !stack.peek().equals("[")) {
					temp.insert(0,stack.pop());
				}
				stack.pop();
				
				int count = Integer.parseInt(stack.pop());
				String finalStr = "";
				
				while(count > 0) {
					finalStr += temp;
					count--;
				}
				stack.push(finalStr);	
				
			}
			else {
				Character c = Character.valueOf(ch);
				String temp = "";
				if(Character.isDigit(c)) {
					while(Character.isDigit(c)) {
						temp += c.toString();
						c = s.charAt(++i);
					}
					i--;
				}
				else {
					temp = c.toString();
				}
				stack.push(temp);
			}
		}
		
		while(!stack.isEmpty()) {
			result.insert(0,stack.pop());
		}
		return result.toString();
	}

}
