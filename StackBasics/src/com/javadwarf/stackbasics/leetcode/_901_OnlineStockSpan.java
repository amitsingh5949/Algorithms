package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;



public class _901_OnlineStockSpan {


	public static void main(String[] args) {

	}


	public _901_OnlineStockSpan() {
		this.index = 0;
	}

	int index = 0;
	class Element{

		int index = -1;
		int val = -1;

		public Element(int index, int val) {
			this.index = index;
			this.val = val;
		}

	}

	Stack<Element> stack = new Stack<>();

	public int next(int price) {
		this.index++;
		int result = 1;

		if(!stack.isEmpty() && stack.peek().val <= price) {
			while(!stack.isEmpty() && stack.peek().val <= price) {
				stack.pop();
			}
			result = index - (stack.isEmpty() ? 0 : stack.peek().index);
		}

		stack.push(new Element(index, price));

		return result;
	}



	// Online stock span using 2 stacks - O(n^2)
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public int next1(int price) {

		int result = 1;

		if(!s1.isEmpty() && s1.peek() <= price) {

			while(!s1.isEmpty() && s1.peek() <= price) {
				s2.push(s1.pop());
				result += 1;
			}

			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}

		s1.push(price);
		return result;
	}



	// Online stock span using 1 stack and recursion - O(n^2)
	Stack<Integer> s = new Stack<>();

	int result = 1;

	public int next2(int price) {
		this.result = 1;
		if(!s.isEmpty() && s.peek() <= price) {
			recStockSpan(price);
		}
		s.push(price);
		return this.result;
	}

	public void recStockSpan(int currPrice) {

		if(s.isEmpty() || s.peek() > currPrice) {
			return;
		}
		this.result =  this.result +1;
		int temp = s.pop();
		recStockSpan(currPrice);
		s.push(temp);
	}

}


