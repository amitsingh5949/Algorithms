package com.javadwarf.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {
	static int  initialCount = 0;
	public static void main(String[] args) {
		fibonacciRecursion(45);
	}

	private static void fibonacciRecursion(int count) {
		System.out.println("\nLast number is : "+ fibRec(count)); // 45 - 1134903170
		System.out.println("\nLast number is : "+  fibRecMemoization(count, new HashMap<Long,Long>())); // 45 - 1134903170
		System.out.println("\nLast number is : "+  fibRecMemoizationRefactored(count, new HashMap<Long,Long>())); // 45 - 1134903170
	}

	private static long fibRec(int i) {
		if( i<=2 ) return 1L;
		return  fibRec(i-1) + fibRec(i-2) ;
	}

	private static long fibRecMemoization(int i, Map<Long, Long> memory) {
		if( i<=2 ){
			return 1L;
		}
		Long num1 = 0L;
		Long num2 = 0L;
		if(memory.containsKey(Long.valueOf(i-1))){
			num1 = memory.get(Long.valueOf(i-1));
		}
		else{
			num1 = fibRecMemoization(i-1,memory) ;
			memory.put(Long.valueOf(i-1), Long.valueOf(num1));
		}
		if(memory.containsKey(Long.valueOf(i-2))){
			num2 = memory.get(Long.valueOf(i-2));
		}
		else{
			num2 = fibRecMemoization(i-2,memory) ;
			memory.put(Long.valueOf(i-2), Long.valueOf(num2));
		}
		return num1 + num2;
	}

	private static long fibRecMemoizationRefactored(int i, Map<Long, Long> memory) {
		if( i<=2 ){
			memory.put(Long.valueOf(i), 1L);
			return 1L;
		}
		Long num = 0L;
		if(memory.containsKey(Long.valueOf(i))){
			num = memory.get(Long.valueOf(i));
		}
		else{
			num = fibRecMemoizationRefactored(i-1,memory) + fibRecMemoizationRefactored(i-2,memory) ;
			memory.put(Long.valueOf(i), Long.valueOf(num));
		}
		return num; 
	}
}
