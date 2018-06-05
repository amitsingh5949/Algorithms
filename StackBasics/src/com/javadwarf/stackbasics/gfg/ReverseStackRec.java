package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class ReverseStackRec {

	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) {
		s.push(23);
		s.push(2);
		s.push(1);
		s.push(56);
		s.push(32);

		s.stream().forEach(e -> System.out.print(e + " "));
		if (!s.isEmpty()) {
			revRec(s, s.pop());
		}
		System.out.println();
		s.stream().forEach(e -> System.out.print(e + " "));
	}

	public static void revRec(Stack<Integer> s, int i){
		if (s.isEmpty()) {
			s.push(i);
			return ;
		}
		else{
			revRec(s, s.pop());
			insertAtBottom(s,s.pop(),i);
		}
	}

	public static void insertAtBottom(Stack<Integer> s, int i, int e){
		if (s.isEmpty()) {
			s.push(e);
			s.push(i);
			return ;
		}
		else{
			insertAtBottom(s, s.pop(), e);
			s.push(i);
		}

	}




}
