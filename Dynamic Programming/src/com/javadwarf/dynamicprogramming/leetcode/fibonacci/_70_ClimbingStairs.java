package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _70_ClimbingStairs {
	
	public int climbStairs(int n) {
		return climbStairs(n, new int[n+1]);
	}

	public int climbStairs(int n, int[] memo) {
		if(n <= 2) return n;
		if(memo[n]!=0) return memo[n];
		memo[n] = climbStairs(n-1,memo) + climbStairs(n-2,memo);
		return memo[n];
	}
	
	
	/* Or we can use the formula below to use calculate nth fib number - O(logn) + o(1)
	  F(n) = [((1+sqrt(5))/2)^n+1 - ((1-sqrt(5))/2)^n+1] / sqrt(5)
	 */
	
	// There is matrix multiplication solution also available which takes o(logn) time

}
