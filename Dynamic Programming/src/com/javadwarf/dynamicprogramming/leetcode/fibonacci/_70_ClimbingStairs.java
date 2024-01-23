package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _70_ClimbingStairs {

	
	//top down
	public int climbStairsBFRecursion(int n) {
		if(n <= 1)  return 1;
		return climbStairs(n-1) +  climbStairs(n-2);
	}

	public int climbStairs(int n) {
		return climbStairs(n, new int[n+1]);
	}

	public int climbStairs(int n, int[] memo) {
		if(n <= 2) return n;
		if(memo[n]!=0) return memo[n];
		memo[n] = climbStairs(n-1,memo) + climbStairs(n-2,memo);
		return memo[n];
	}


	//Bottom -up
	public int climbStairsBottomUp(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1; dp[1] = 1;
		for(int i=2;i<=n;i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	/* Or we can use the formula below to use calculate nth fib number - O(logn) + o(1)
	  F(n) = [((1+sqrt(5))/2)^n+1 - ((1-sqrt(5))/2)^n+1] / sqrt(5)
	 */

	// There is matrix multiplication solution also available which takes o(logn) time



}
