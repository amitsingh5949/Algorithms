package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class SpecialStackGetMinInO1TO1S {

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

class SpecialStackImpl{

	public static int minEle =-1;

	public static void push(int a,Stack<Integer> s)
	{
		if(isEmpty(s)) {
			s.push(a);
			minEle = a ;
		}
		else {
			if(a > min(s)) {
				s.push(a);
			}
			else {
				s.push(2*a-minEle);
				minEle = a;
			}
		}
	}
	public static int pop(Stack<Integer> s)
	{
		if(!isEmpty(s)) {
			int temp = s.pop();
			if(temp < min(s)) {
				int currentMin = min(s);
				int previousMin = 2*currentMin + temp;
				minEle = previousMin;
				return currentMin;
			}
			else {
				return temp;
			}
		}
		return -1;
	}
	public static int min(Stack<Integer> s)
	{
		return minEle;
	}
	public static boolean isFull(Stack<Integer>s, int n)
	{
		return s.size()==n?true:false;
	}
	public static boolean isEmpty(Stack<Integer>s)
	{
		return s.isEmpty();
	}
}
