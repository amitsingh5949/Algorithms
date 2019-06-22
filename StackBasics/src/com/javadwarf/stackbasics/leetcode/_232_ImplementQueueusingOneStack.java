package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _232_ImplementQueueusingOneStack {

	public static void main(String[] args) {

	}
	
	Stack<Integer> s = new Stack<>();
    
    public int pop() {
        if(!s.isEmpty()){
        	return s.pop();
        }
        return -1;
    }
    
    public int peek() {
    	if(!s.isEmpty()){
        	return s.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
    

    public void push(int x) {
    	insertAtBottom(x);
        
    }
    
    public void insertAtBottom(int x) {
    	if(s.isEmpty()) {
    		s.add(x);
    		return;
    	}
    	int temp = s.pop();
    	insertAtBottom(x);
    	s.add(temp);
    	
    }
    
    

}
