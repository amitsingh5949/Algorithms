package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class StackGetMinInO1T1Stack {

	public static void main(String[] args) {

		SpecialStackOpt q  =  new SpecialStackOpt();
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){

			int numOfTestQueries = in.nextInt();

			for(int j=0; j<numOfTestQueries; j++){

				int query = in.nextInt();
				if(query ==1 )
					q.push(in.nextInt());
				else if(query==2)
					System.out.print(q.pop()+" ");
				else if(query==3)
					System.out.print(q.getMin() + " ");
			}
		}
		in.close();
	}
}

class SpecialStackOpt{

	Stack<Integer> s = new Stack<>();
	int minEle =-1;

	public int getMin(){
		return minEle;
	}

	public void push(int n){
		if(s.isEmpty() || n < minEle ){
			s.push(n);
			minEle = n;
		}
		else{
			s.push(n);
		}
	}

	public int pop(){
		if(!s.isEmpty()){
			int temp = s.pop();
			if(!s.isEmpty()){
				if(temp==minEle) {
					minEle  = getCurrentmin(s,s.peek());
				}
			}
			else {
				minEle = -1;
			}
			return temp;
		}
		return -1;
	}

	public int getCurrentmin(Stack<Integer> s, int min){
		if(s.isEmpty()) {
			return min;
		}
		int temp = s.pop();
		if(temp < min) {
			min = temp;
		}
		min =  getCurrentmin(s,min);
		s.push(temp);
		return min;
	}
}
