package com.javadwarf.string.leetcode;

import java.util.Stack;

public class _1963_MinimumNumberofSwapstoMaketheStringBalanced {

	public int minSwaps(String s) {

		Stack<Character> stack = new Stack<>();

		for( int i=0; i<s.length(); i++){

			if(s.charAt(i) == '['){
				stack.push('[');
			}
			else{
				if(!stack.isEmpty() && stack.peek() == '['){
					stack.pop();
				}
				else{
					stack.push(']');  
				}
			}
		}
		// divide by 4.0 is important as after removing all valid pairs, we will be left with closed brackets followed by open brackets. so we need to swap half the number of pairs.
		return stack.size() == 0 ? 0 : (int) Math.ceil(stack.size()/4.0); 
		//return stack.size() == 0 ? 0 : (stack.size()+2)/4;
	}
	
	// instead of storing the mismatches in stack, store the count of open brackets mismatched.
	    public int minSwapsOptimized(String s) {
	        int stack_size = 0;
	        for (int i = 0; i < s.length (); i++) {
	            char ch = s.charAt (i);
	            if (ch == '[')
	                stack_size++;
	            else {
	                if (stack_size > 0)
	                    stack_size--;
	            }
	        }
	        return (stack_size + 1) / 2;
	    }

}
