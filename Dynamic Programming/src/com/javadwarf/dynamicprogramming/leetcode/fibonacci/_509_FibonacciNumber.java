package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _509_FibonacciNumber {
	
	public static void main(String[] args) {
		System.out.println(new _509_FibonacciNumber().fib(2));
	}

	public int fib(int N) {
		return fib(N, new int[N+1]);
	}

	//DP -  top-down approach
	public int fib(int N, int[] memo) {
		if(memo[N] != 0) {
			return memo[N];
		}
		if(N==0) {
			return 0;
		}
        if(N==1) {
			return 1;
		}
		memo[N] =  fib(N-1, memo) + fib(N-2, memo);
		return memo[N];
	}

}
