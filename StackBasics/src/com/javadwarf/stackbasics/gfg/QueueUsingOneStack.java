package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingOneStack {

	public static void main(String[] args) {

		QueueImpl q  =  new QueueImpl();
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

class QueueImpl	{

	Stack<Integer> s1= new Stack<>();

	public void enqueue(int n){

		if(s1.isEmpty())
			s1.push(n);
		else{
			recEnqueue(n, s1.pop());
		}
	}
	
	private void recEnqueue(int n, int x){
		if(s1.isEmpty()){
			s1.push(n);
		}
		else{
		recEnqueue(n, s1.pop());
		}
		s1.push(x);
	}

	public int dequeue(){
		if(!s1.isEmpty()) return s1.pop();
		return -1;
	}

}