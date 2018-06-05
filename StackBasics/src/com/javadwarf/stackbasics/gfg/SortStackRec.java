package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class SortStackRec {

	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) {
		s.push(123);
		s.push(2);
		s.push(11);
		s.push(56);
		s.push(32);

		s.stream().forEach(e -> System.out.print(e + " "));
		if (!s.isEmpty()) {
			sortRec(s, s.pop());
		}
		System.out.println();
		s.stream().forEach(e -> System.out.print(e + " "));
	}

	public static void sortRec(Stack<Integer> s, int i){
		if (s.isEmpty()) {
			s.push(i);
			return ;
		}
		else{
			sortRec(s, s.pop());
			insertAtX(s,s.pop(),i);
		}
	}

	public static void insertAtX(Stack<Integer> s, int i, int e){
		if (e > i || s.isEmpty()) {
			if(e >= i){
				s.push(i);
				s.push(e);}
			else{
				s.push(e);	
				s.push(i);
			}
			return ;
		}
		else{
			insertAtX(s, s.pop(), e);
			s.push(i);
		}

	}

}
