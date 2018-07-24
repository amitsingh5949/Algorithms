package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class PrintBracketNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcases = s.nextInt();
		for(int i=0; i<testcases; i++) {
			printBracketNumber(s.next());
			System.out.println();
		}
		s.close();
	}

	private static void printBracketNumber(String exp) {

		Stack<Integer> si = new Stack<>();

		int startBracketCount = 0;

		int index = 0;
		while(index < exp.length()) {
			char ch = exp.charAt(index++);
			if(ch=='(') {
				si.push(++startBracketCount);
				System.out.print(si.peek() +" ");
			}
			else if(ch==')') {
				System.out.print(si.pop() +" ");
			}
		}
	}

}
