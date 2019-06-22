package com.javadwarf.stackbasics.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackusingQueues {

	public static void main(String[] args) {
		
		_225_ImplementStackusingQueues x = 	new _225_ImplementStackusingQueues();
		x.push(1);
		x.push(2);
		System.out.println(x.top());
		System.out.println(x.pop());
	}

	Queue<Integer> q = new LinkedList<>();

	public void push(int x) {
		reverseQueue();
		q.add(x);
		reverseQueue();
	}
	
	public void reverseQueue() {
		if(q.isEmpty()) return;
		int temp = q.poll();
		reverseQueue();
		q.add(temp);
	}

	public int pop() {
		if(!q.isEmpty()) {
			return q.poll();
		}
		return -1;
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {

		return q.isEmpty();

	}

}
