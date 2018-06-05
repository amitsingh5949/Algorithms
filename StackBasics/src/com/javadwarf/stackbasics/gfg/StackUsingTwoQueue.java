package com.javadwarf.stackbasics.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class StackImpl{

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		public void push(Integer i){


			if(!q1.isEmpty()){
				while(!q1.isEmpty()){
					q2.add(q1.remove());
				}
				q1.add(i);
				while(!q2.isEmpty()){
					q1.add(q2.remove());
				}
			}

			if(q1.isEmpty() && q2.isEmpty()){
				q1.add(i);
			}
		}
	
	
	public Integer pop(){
		if(!q1.isEmpty()) return q1.remove();
		return -1;
	}
	}
}
