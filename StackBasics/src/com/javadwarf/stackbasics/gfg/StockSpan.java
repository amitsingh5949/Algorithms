package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			Integer arr[] = new Integer[size];
			for(int k=0; k<size; k++){
				arr[k] = in.nextInt();
			}
			stockSpan(arr);
			System.out.println();
		}
		in.close();
	}

	public static void stockSpan(Integer[] arr){

		Stack<Integer> s = new Stack<>();
		for(int temp:arr){
			if(s.isEmpty()){
				s.push(temp);
				System.out.print(1);
			}
			else{
				if(temp<s.peek()){
					s.push(temp);
					System.out.print(" "+ 1);
				}
				else{
					int i = spanMinRec(s,temp,1);
					s.push(temp);
					System.out.print(" "+ i);
				}
			}
		}
	}

	public static int spanMinRec(Stack<Integer> s, int curr, int count){
		if(s.isEmpty() || curr<s.peek()){
			return count;
		}
		else{
			int x = s.pop();
			count = spanMinRec(s,curr,++count);
			s.push(x);
		}
		return count;
	}

}
