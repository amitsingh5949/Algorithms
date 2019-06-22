package com.javadwarf.stackbasics.gfg;

import java.util.LinkedList;
import java.util.Queue;

import com.javadwarf.stackbasics.leetcode._225_ImplementStackusingQueues;

public class StackUsingOneQueue {

	public static void main(String[] args) {

	}

	class StackQueueRecImpl{

		Queue<Integer> q = new LinkedList<>();

		
		// this push is too complicated, look at same question leetcode package _225_ImplementStackusingQueues
		public void push(Integer i){

			if(!q.isEmpty()){
				q = reverseQueue(q,q.poll(),false,-1);
				q = reverseQueue(q,q.poll(),true,i);
			}
			if(q.isEmpty()){
				q.add(i);
			}
		}

		public Queue<Integer> reverseQueue(Queue<Integer> q, Integer i, Boolean addElement, int e){
			if(q.isEmpty()){
				if(addElement) q.add(e);
				q.add(i);
				return q;
			}
			else{
				q = reverseQueue(q, q.poll(),addElement,e);
				q.add(i);
			}
			return q;
		}

		public Integer pop(){
			if(!q.isEmpty()) return q.remove();
			return -1;
		}
	}
}
