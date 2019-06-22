package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _155_MinStack {

	public _155_MinStack() {

	}
	
	Long minEle = -1l;

	Stack<Long> s = new Stack<>();

	public void push(int x) {
		long y = x;

		if(s.isEmpty()) {
			minEle = y;
			s.push(y);
		}
		else {
			if(x > minEle) {
				s.push(y);
			}
			else {
				s.push(2*y-minEle);
				minEle =y;
			}
		}
	}

	public void pop() {
		if(!s.isEmpty()) {
			long temp = s.pop();
			if(temp < minEle) {
				minEle = 2*minEle - temp;
			}
		}
	}

	public int top() {
		return Long.valueOf(s.peek()<minEle?minEle:s.peek()).intValue();
	}

	public int getMin() {
		return Long.valueOf(minEle).intValue();
	}

}
