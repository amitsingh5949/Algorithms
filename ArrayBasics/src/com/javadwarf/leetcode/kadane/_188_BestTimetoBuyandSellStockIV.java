package com.javadwarf.leetcode.kadane;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// For more optimized solution
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution

public class _188_BestTimetoBuyandSellStockIV {

	public static void main(String[] args) {
		System.out.println(new _188_BestTimetoBuyandSellStockIV().maxProfit(2, new int[] {3,2,6,5,0,3}));
	}


	// naive solution
	public int maxProfit(int k, int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int[][] matrix = new int[k+1][prices.length];

		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length;j++) {

				if(i==0 || j==0) {
					matrix[i][j] = 0;
				}
				else {
					// case 1 : if  we do not transact on jth day at all
					int x = matrix[i][j-1];
					// case 2 : if  we do transact on jth day that is sell at jth and then we might have bought it
					// on some day m, m can be 0,1,2,... j-1, 
					// so the profit would be (price at jth day - price at mth day )+ profit we have made by 1 less tranctaction(i-1) at mth day {matrix[i-1][m]}
					int y =0;
					for(int m =0; m<j;m++) {
						int z = prices[j]-prices[m] + matrix[i-1][m];
						y = Math.max(y, z);
					}
					matrix[i][j] = Math.max(x, y);
				}
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}

	// optimized approach , we don't need to look back at all the values of m from 0 to j-1
	public int maxProfit0(int k, int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int[][] matrix = new int[k+1][prices.length];

		for(int i=0; i< matrix.length; i++) {

			int maxDiff = -prices[0];
			for(int j=0; j<matrix[0].length;j++) {

				if(i==0 || j==0) {
					matrix[i][j] = 0;
				}
				else {
					// case 1 : if  we do not transact on jth day at all
					int x = matrix[i][j-1];
					// case 2 : if  we do transact on jth day that is sell at jth and then we might have bought it
					// on some day m, m can be 0,1,2,... j-1, 
					// We don't go back to every m instead we would calculate maxdiff = matrix[i-1][j] -prices[j] 
					//and use maxdiff to calculate current day profit y = prices[j] + maxDiff
					int y = prices[j] + maxDiff;
					maxDiff = Math.max(maxDiff, matrix[i-1][j]-prices[j]);

					matrix[i][j] = Math.max(x, y);
				}
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}

	public int maxProfit11(int k, int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int[][] matrix = new int[k+1][prices.length];

		for(int i=1; i< matrix.length; i++) {

			int maxDiff = -prices[0];
			for(int j=1; j<matrix[0].length;j++) {
				matrix[i][j] = Math.max(matrix[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, matrix[i-1][j]-prices[j]);
			}
		}

		return matrix[matrix.length-1][matrix[0].length-1];

	}

	//Wrong approach
	// idea was to find all the profits using unlimited transaction technique and get k max profits
	// but approach won't work for k = 2 and arr  = [1,2,4,2,5,7,2,4,9,0] expected 13 , output 12
	public int maxProfit1(int k, int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int start = 0;
		int end = -1;
		int currProfit = 0;

		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int i=0; i<prices.length; i++) {
			if(prices[start] < prices[i] && prices[i] - prices[start] > currProfit) {
				end = i;
				currProfit = prices[i] - prices[start];
			}
			else if(end == -1 && prices[i] < prices[start]) {
				start  = i;
			}
			else if(end != -1 && prices[i] < prices[end]) {
				q.add(currProfit);
				start = i;
				end = -1;
				currProfit = 0;
			}
		}

		q.add(currProfit);

		int totalProfit  = 0;

		while(k>0 && !q.isEmpty()) {
			totalProfit += q.poll();
			k--;
		}

		return totalProfit;

	}

}
