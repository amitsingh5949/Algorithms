package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in); 
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			String word = in.next();
			System.out.println(parenthesisChecker(word)?"balanced":"not balanced");
		}
		in.close();
	}

	public static boolean parenthesisChecker(String word){

		boolean match = false;
		Stack<Character> stack = null;
		char currentChar ='\0';

		if(word.length() == 0){
			return false;
		}
		else{
			stack = new Stack<>();
			outer : for(int i=0; i<word.length(); i++){

				currentChar = word.charAt(i);
				switch(currentChar){
				case '{': case'[': case'(':{
					stack.push(currentChar);
					break;
				}
				case ')': case ']': case '}':{
					match = matchParenthesis(stack,currentChar);
					if(!match){
						break outer;
					}
					else{
						break;
					}
				}
				}
			}
		}
		if(!stack.isEmpty()){
			return false;
		}
		return match;

	}

	public static boolean matchParenthesis(Stack<Character> stack,char c)  {
		boolean  match=  false;
		if(stack.isEmpty()){
			return false;
		}
		else{
			switch(c){
			case ')': {
				if(stack.peek()=='('){
					stack.pop();
					match=  true;
				}
				break;
			}
			case ']': {
				if(stack.peek()=='['){
					stack.pop();
					match=  true;
				}
				break;
			}
			case '}':{
				if(stack.peek()=='{'){
					stack.pop();
					match=  true;
				}
				break;
			}
			}
		}
		return match;
	}
}

