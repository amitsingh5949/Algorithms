package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _739_DailyTemperatures {

	public static void main(String[] args) {

	}

	public int[] dailyTemperatures(int[] T) {
		
		if(T==null ||T.length == 0) return T;

		int[] result = new int[T.length];

		Stack<Integer> s = new Stack<>();
		s.push(0);

		for(int i=1; i<T.length; i++) {
			while(!s.isEmpty() && T[i] > T[s.peek()]) {
				int top = s.pop();
				result[top] = i - top; 
			}
			s.push(i);
		}
		return result;
	}

}
