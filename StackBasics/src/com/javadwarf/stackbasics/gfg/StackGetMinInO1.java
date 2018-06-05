package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class StackGetMinInO1 {

	public static void main(String[] args) {

	}

}

class SpecialStack{
	
	Stack<Integer> s = new Stack<>();
	Stack<Integer> sMin = new Stack<>();
	
	
	public void push(int n){
		if(s.isEmpty()){
			s.push(n);
			sMin.push(n);
		}
		else{
			if(n<getMin()){
				s.push(n);
				sMin.push(n);
			}
			else{
				s.push(n);
			}
		}
	}
	public int pop(){
		if(!s.isEmpty()){
			if(s.peek()==getMin()){
				s.pop();
				return sMin.pop();
			}
			else{
				return s.pop();
			}
		}
		return -1;
	}
	
	public int getMin(){
		if(!sMin.isEmpty()){
			return sMin.peek();
		}
		return -1;
	}
	
	public boolean isFull(int n){
		return s.size()>=n;
	}
	
	public boolean isEmpty(){
		return s.isEmpty();
	}
	
	
}
