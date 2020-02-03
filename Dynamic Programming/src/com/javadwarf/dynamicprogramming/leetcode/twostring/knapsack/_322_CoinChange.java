package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Map;
import java.util.TreeMap;

public class _322_CoinChange {

	public static void main(String[] args) {
		//System.out.println(new _322_CoinChange().coinChange(new int[]{1,2,5}, 11));
		//System.out.println(new _322_CoinChange().coinChange(new int[]{3}, 4));
		
		System.out.println(new _322_CoinChange().minimumCoinBottomUp(11, new int[]{1,2,5}));
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
