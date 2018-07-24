package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElement {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testases = s.nextInt();
		for(int i=0; i<testases; i++) {
			int n = s.nextInt();
			Stack<Integer> stack = new Stack<>();
			for(int j=0; j<n; j++) {
				stack.push(s.nextInt());
			}
			stack = deleteMid(stack, n, 0);
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		}

	}
	public static Stack<Integer> deleteMid(Stack<Integer> s,int n,int current){
		if(!s.isEmpty()) {
			if(current == n/2 + 1) {
				return s;
			}
			int temp = s.pop();
			deleteMid(s, n, ++current);
			if(current != n/2 + 1) {
				s.push(temp);
			}
		}
		return s;
	}
	
	

}
