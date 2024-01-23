package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Map;
import java.util.TreeMap;

public class _322_CoinChange {

	public static void main(String[] args) {
		//System.out.println(new _322_CoinChange().coinChange(new int[]{1,2,5}, 11));
		//System.out.println(new _322_CoinChange().coinChange(new int[]{3}, 4));

		System.out.println(new _322_CoinChange().minimumCoinBottomUp(11, new int[]{1,2,5}));
	}
	/**********************************************************************************************************************************************/
	////Brute force without memoization and use of global variable
	int res = Integer.MAX_VALUE;
	public int coinChange14(int[] coins, int amount) {
		helper14(coins, amount, 0, 0);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public void helper14(int[] coins, int amount, int i , int count){
		if( amount == 0) {
			res = Math.min( res, count);
			return;
		}

		if(amount < 0) return;
		if( i == coins.length) return;

		helper14(coins, amount-coins[i], i, count+1);
		helper14(coins, amount, i+1, count);
	}
	/**********************************************************************************************************************************************/
	//Brute force without memoization
	public int coinChange12(int[] coins, int amount) {
		int res = helper(coins, amount, 0, 0);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public int helper(int[] coins, int amount, int i , int count){
		if( amount == 0) {
			return count;
		}

		if(amount < 0)   return Integer.MAX_VALUE;
		if( i == coins.length) return Integer.MAX_VALUE;

		return Math.min(helper(coins, amount-coins[i], i, count+1), helper(coins, amount, i+1, count));
	}
	/**********************************************************************************************************************************************/	    
	//Brute force without memoization and without count variable

	public int coinChange13(int[] coins, int amount) {
		int res = helper13(coins, amount, 0);
		return res == Integer.MAX_VALUE-1 ? -1 : res;
	}

	public int helper13(int[] coins, int amount, int i ){
		if( amount == 0) return 0;
		if(amount < 0)   return Integer.MAX_VALUE-1;
		if( i == coins.length) return Integer.MAX_VALUE-1;
		return Math.min(1 + helper13(coins, amount-coins[i], i), helper13(coins, amount, i+1));
	}
	/**********************************************************************************************************************************************/	
	//top to down approach, using recursion and memoization
	int[][] dp;
	public int coinChangeTopDown(int[] coins, int amount) {
		dp = new int[coins.length][amount+1];
		if(amount == 0) return 0;
		if(coins == null || coins.length ==0) return -1;
		int res =  coinChange(coins, amount, 0);
		return  (res == Integer.MAX_VALUE-1) ? -1 : res;
	}

	public int coinChange(int[] coins, int amount, int index) {

		if(amount == 0) return 0;
		if(amount < 0 ) return Integer.MAX_VALUE-1;
		if(index >= coins.length) return Integer.MAX_VALUE-1;    
		if(dp[index][amount] != 0) return dp[index][amount];

		int excludeCurrCoin =  coinChange(coins, amount, index+1);
		int includeCurrCoin =  1 + coinChange(coins, amount-coins[index], index);

		dp[index][amount] = Math.min(excludeCurrCoin,includeCurrCoin);
		return  dp[index][amount];
	}
	/**********************************************************************************************************************************************/
	//optimized top down where we do not choose or unchoose a coin, logic is to choose all the coins one by one
	class Solution {

		int[] dp;

		public int coinChange(int[] coins, int amount) {
			dp = new int[amount+1];
			dp[amount] = helper(coins,amount);
			return  dp[amount] == Integer.MAX_VALUE ? -1:   dp[amount];
		}

		public int helper(int[] coins, int amount){

			if( amount == 0 ) return 0;
			if(amount < 0) return Integer.MAX_VALUE;
			if(dp[amount] != 0) return dp[amount];

			int min = Integer.MAX_VALUE;
			for(int i=0;i<coins.length; i++){
				int temp = helper(coins, amount-coins[i]);
				if(temp != Integer.MAX_VALUE)
					min = Integer.min(min, 1+temp);
			}

			dp[amount] = min;
			return dp[amount];
		}
	}
	/**********************************************************************************************************************************************/
	// bottom up approach using iteration and memoization
	public int coinChange(int[] coins, int amount) {

		int[][] dp = new int[coins.length+1][amount+1];

		for(int i=0; i<dp.length; i++){
			for(int j =0; j<dp[0].length; j++){
				
				if(i==0) dp[i][j] = Integer.MAX_VALUE-1;// to avoid integer overflow
				else if(j==0) dp[i][j] = 0;
				else if( j < coins[i-1]) dp[i][j] =  dp[i-1][j]; // coin cannot be used to make amount if coin is greater than amount
				else dp[i][j] = Math.min(1+ dp[i][j-coins[i-1]], dp[i-1][j]); //min(1+choose curr coin, not choose curr coin)
				
			}
		}
		return dp[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : dp[coins.length][amount];
	}
	/**********************************************************************************************************************************************/
	//***** Advance bottom up

	public int minimumCoinBottomUp(int total, int coins[]){
		int T[] = new int[total + 1];
		int R[] = new int[total + 1];
		T[0] = 0;
		for(int i=1; i <= total; i++){
			T[i] = Integer.MAX_VALUE-1;
			R[i] = -1;
		}
		for(int j=0; j < coins.length; j++){
			for(int i=1; i <= total; i++){
				if(i >= coins[j]){
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		printCoinCombination(R, coins);
		return T[total];
	}

	private static Map<Integer, Integer>  printCoinCombination(int R[], int coins[]) {

		Map<Integer, Integer> map = new TreeMap<>();

		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return map;
		}


		int start = R.length - 1;
		while ( start != 0 ) {
			int j = R[start];


			System.out.print(coins[j] + " ");
			int count1 = map.getOrDefault(coins[j], 0);
			map.put(coins[j], count1+1);
			start = start - coins[j];
		}

		return map;
	}
}

