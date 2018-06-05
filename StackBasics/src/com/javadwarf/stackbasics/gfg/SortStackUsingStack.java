package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class SortStackUsingStack {

	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) {
		s.push(123);
		s.push(2);
		s.push(11);
		s.push(56);
		s.push(32);

		s.stream().forEach(e -> System.out.print(e + " "));
		if (!s.isEmpty()) {
			s= sort(s);
		}
		System.out.println();
		s.stream().forEach(e -> System.out.print(e + " "));
	}

	public static Stack<Integer> sort(Stack<Integer> s){

		Stack<Integer> temp = new Stack<>();
		Integer i  = null;
		temp.push(s.pop());

		while(!s.isEmpty()){
			i = s.pop();
			if( !temp.isEmpty()){
				if(i<= temp.peek()){
					temp.push(i);
				}
				else{
					while(!temp.isEmpty() && temp.peek()<=i){
						s.push(temp.pop());
					}
					temp.push(i);
				}
			}
			else{
				temp.push(i);
			}
		}
		
	while(!temp.isEmpty()){
		s.push(temp.pop());
	}
		return s;
	}



}
