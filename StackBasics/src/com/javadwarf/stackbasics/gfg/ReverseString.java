package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		reverseStringUsingStack("amit");

	}

	public static  void reverseStringUsingStack(String str){
		Stack<Character> s = new Stack<>();
		int i = 0;
		while(i<str.length()) {
			s.push(Character.valueOf(str.charAt(i++)));
		}
		str = "";
		while(!s.isEmpty()) {
			str += s.pop();
		}
		System.out.println(str);
	}

}
