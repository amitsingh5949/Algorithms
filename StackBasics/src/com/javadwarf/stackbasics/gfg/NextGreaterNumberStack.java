package com.javadwarf.stackbasics.gfg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNumberStack {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			Integer arr[] = new Integer[size];
			for(int k=0; k<size; k++){
				arr[k] = in.nextInt();
			}
			printNextGreaterNum(arr);
			System.out.println();
		}
		in.close();
	}

	public static void printNextGreaterNum(Integer arr[]){
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> s = new Stack<>();
		for(Integer i : arr){
			while(!s.isEmpty() && s.peek() < i){
				map.put(s.pop(),i);
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			map.put(s.pop(),-1);
		}
		for(Integer i : arr){
				System.out.print(map.get(i) + " ");
		}
	}

}
