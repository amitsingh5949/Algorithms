package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

public class _322_CoinChange {

	public static void main(String[] args) {
		System.out.println(new _322_CoinChange().coinChange(new int[]{1,2,5}, 11));
		System.out.println(new _322_CoinChange().coinChange(new int[]{3}, 4));
	}

	public int coinChange(int[] coins, int amount) {
		
		if(amount < 1) return 0;
		
		int[][] matrix = new int[coins.length+1][amount+1];

		for(int i=0; i<matrix.length; i++) {

			for(int j=0; j<matrix[i].length; j++) {

				if(i==0 || j==0) {
					matrix[i][j] = amount+1;
				}
				else if(coins[i-1] == j ) {
					matrix[i][j] = 1;
				}
				else if(coins[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					matrix[i][j] = Integer.min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]);
				}
			}
		}
		return matrix[coins.length][amount] == amount+1 ? -1 : matrix[coins.length][amount];
	}
}
