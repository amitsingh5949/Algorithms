package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class StackGetMinInO1TO1S {

	public static void main(String[] args) {

	}

}

class SpecialStackOpt{
	
	Stack<Integer> s = new Stack<>();
	Integer min ;
	
	public void push(int n){
		if(s.isEmpty()){
			s.push(n);
			min = n;
		}
		else{
			if( n < min ){
				s.push(n);
				min = n;
			}
			else{
				s.push(n);
			}
		}
	}
	
	//Pop method start
	public int pop(){
		if(!s.isEmpty()){
			if(s.peek()!=min){
				return s.pop();
			}
			else{
				int temp = s.pop();
				min  = getCurrentmin(s);
				return temp;
			}
		}
		return -1;
	}
	
	public int getCurrentmin(Stack<Integer> s){
		int temp  = s.pop();
		int min = getMinRec(s,temp,temp);
		s.push(temp);
		return min;
	}
	
	public int getMinRec(Stack<Integer> s, int min, int poppedVal){
		if( poppedVal < min){
			min = poppedVal;
		}
		if (s.isEmpty()){
			return min;
		}else{
			int temp = s.pop();
			min =  getMinRec(s,temp,temp);
			s.push(temp);
			return min;
		}
	}
	
	//pop method end
	
	
	
	public int getMin(){
		if(min != null){
			return min.intValue();
		}
		return -1;
	}
	
}
