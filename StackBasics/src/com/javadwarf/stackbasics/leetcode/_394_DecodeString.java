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

	public String decodeStringAgain(String s) {

		Stack<String> stack = new Stack<>();
		int num = 0;
		StringBuilder temp = new StringBuilder();

		for(int i=0;i<s.length(); i++){

			if(s.charAt(i) == '['){
				stack.add(Integer.valueOf(num).toString());
				stack.add("[");
				num = 0;
			}
			else if(s.charAt(i) == ']'){
				stack.add(temp.toString());
				temp = new StringBuilder();

				StringBuilder sb = new StringBuilder();

				while(!stack.peek().equals("[")){
					sb.insert(0, stack.pop());
				}
				stack.pop();
				String val = sb.toString();

				int times = Integer.parseInt(stack.pop());
				StringBuilder jz = new StringBuilder();
				for(int j=1; j<=times; j++){
					jz.append(val);
				}
				stack.add(jz.toString());

			}
			else if( Character.isDigit(s.charAt(i))){
				if(temp.length() > 0){
					stack.add(temp.toString());
					temp = new StringBuilder();
				}
				num = num*10 + (s.charAt(i)-'0');
			}
			else if(Character.isLetter(s.charAt(i))){
				temp.append(s.charAt(i));
			}

		}

		stack.add(temp.toString());

		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.insert(0, stack.pop());
		}

		return sb.toString();

	}

	//stack better to understand

	public String decodeStringjz(String s) {

		Stack<String> stack = new Stack<>();

		int i = 0;
		while(i<s.length()){

			if(s.charAt(i) == '['){
				stack.push("[");
				i++;
			}
			else if(s.charAt(i) == ']'){
				StringBuilder val = new StringBuilder();
				while(!stack.peek().equals("[")){
					val.insert(0,stack.pop());
				}
				stack.pop();
				int times = Integer.parseInt(stack.pop());
				StringBuilder temp = new StringBuilder();
				for(int k = 0; k<times; k++){
					temp.append(val.toString());
				}
				stack.push(temp.toString());
				i++;
			}
			else if(Character.isDigit(s.charAt(i))){
				int num = 0;
				while(i<s.length() && Character.isDigit(s.charAt(i))){
					char ch = s.charAt(i);
					num = num*10 + (ch - '0');
					i++;
				}
				stack.push(Integer.valueOf(num).toString());
			}
			else if(Character.isLetter(s.charAt(i))){
				StringBuilder temp = new StringBuilder();
				while(i<s.length() && Character.isLetter(s.charAt(i))){
					char ch = s.charAt(i);
					temp.append(ch);
					i++; 
				}
				stack.push(temp.toString());
			}
		}

		StringBuilder temp = new StringBuilder();
		while(!stack.isEmpty()){
			temp.insert(0,stack.pop());
		}
		return temp.toString();

	}

}
