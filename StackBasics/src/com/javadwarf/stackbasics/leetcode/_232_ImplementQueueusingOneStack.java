package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _232_ImplementQueueusingOneStack {

	// space complexity O(n)
	// Time complexity 
	//push  and empty- O(1)
	//pop() and peek() - Worst case o(n), average case O(1)

	Stack<Integer> pushStack ;
	Stack<Integer> popStack ;

	/** Initialize your data structure here. */
	public _232_ImplementQueueusingOneStack() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		pushStack.push(x);

	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {

		if(!empty()){
			if(popStack.empty()){
				while(!pushStack.empty()){
					popStack.push(pushStack.pop());
				}

			}
			return popStack.pop();
		}

		return -1;

	}

	/** Get the front element. */
	public int peek() {
		if(!empty()){
			if(popStack.empty()){
				while(!pushStack.empty()){
					popStack.push(pushStack.pop());
				}

			}
			return popStack.peek();
		}

		return -1;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {

		return pushStack.empty() && popStack.empty();

	}
}



