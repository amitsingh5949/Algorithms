package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class RemoveDuplicateLexiographical {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
	}

	public static String removeDuplicateLetters(String s) {
		
		String result = "";
		char[] arr = s.toCharArray();
		Stack<Character> stack  = new Stack<>();
		
		for(char c : arr){
			if(stack.isEmpty()){
				stack.push(c);
			}
			else{
				boolean isBigger = checkDuplicate(stack, c, true);
				if(isBigger){
					stack.push(c);
				}
			}
		}
		
		while(!stack.isEmpty()){
			result += stack.pop();
		}
		return new StringBuilder(result).reverse().toString();
	}
	
	public static boolean checkDuplicate(Stack<Character> s, Character ch, boolean isBigger){
		if(s.isEmpty() || ch == s.peek()){
			if(isBigger && !s.isEmpty()){
				s.pop();
			}
			if(s.isEmpty()){
				isBigger = true;
			}
			return isBigger;
		}
		Character c = s.pop();
		if((int)c > (int)ch){
			isBigger = false;
		}
		isBigger = checkDuplicate(s, ch, isBigger);
		s.push(c);
		return isBigger;
	}

}
