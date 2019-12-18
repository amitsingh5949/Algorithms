package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _123_BestTimetoBuyandSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// read  _188_BestTimetoBuyandSellStockIV for explanation
	public int maxProfit(int[] prices) {
        if(prices == null ||  prices.length<2) return 0;

		int[][] matrix = new int[3][prices.length];

		for(int i=1; i< matrix.length; i++) {

			int maxDiff = -prices[0];
			for(int j=1; j<matrix[0].length;j++) {
				matrix[i][j] = Math.max(matrix[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, matrix[i-1][j]-prices[j]);
			}
		}

		return matrix[matrix.length-1][matrix[0].length-1];
    }

}
