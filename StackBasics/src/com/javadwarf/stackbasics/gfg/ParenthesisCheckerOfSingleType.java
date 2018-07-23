package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisCheckerOfSingleType {

	public static void main(String[] args) {

		/*Scanner in = new Scanner(System.in); 
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			String word = in.next();
			System.out.println(parenthesisChecker(word)?"balanced":"not balanced");
		}
		in.close();*/
		
		System.out.println(parenthesisChecker("(())(()())"));
		System.out.println(parenthesisChecker("())"));
		System.out.println(parenthesisChecker(")("));
		System.out.println(parenthesisChecker("()()(())("));
		System.out.println(parenthesisChecker("()()(()))"));
		
		System.out.println(parenthesisChecker("()()(())()"));
		System.out.println(parenthesisChecker("()()(()))("));
		System.out.println(parenthesisChecker("()()(()))()("));
		
		
	}

	public static boolean parenthesisChecker(String word){

		int count = 0;
		int index = 0;
		
		while(index<word.length()) {
			if(word.charAt(index)=='(') {
				count++;
			}
			else if(word.charAt(index)==')') {
				count--;
			}
			if(count<0) {
				return false;
			}
			index++;
		}
		return count==0?true:false;
	}

	
}

