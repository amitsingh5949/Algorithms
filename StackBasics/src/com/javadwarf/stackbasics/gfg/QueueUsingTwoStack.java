package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStack {

	public static void main(String[] args) {

		Queue q  =  new Queue();
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){

			int numOfTestQueries = in.nextInt();

			for(int j=0; j<numOfTestQueries; j++){

				int query = in.nextInt();
				if(query ==1 )
					q.enqueue(in.nextInt());
				else if(query==2)
					System.out.println(q.dequeue());
			}
		}
		in.close();
	}

}

class Queue{

	Stack<Integer> s1= new Stack<>();
	Stack<Integer> s2= new Stack<>();

	public void enqueue(int n){

		if(!s1.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			s2.push(n);
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
		}

		if(s1.isEmpty() && s2.isEmpty()){
			s1.push(n);
		}

	}

	public int dequeue(){
		if(!s1.isEmpty()) return s1.pop();
		return -1;
	}

}