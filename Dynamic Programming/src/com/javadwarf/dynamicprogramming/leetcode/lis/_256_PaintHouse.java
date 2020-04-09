package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _256_PaintHouse {

	public static void main(String[] args) {

	}

	// idea is to find cost of painting at ith house with a specific color i.e if i want to paint the 3rd house by red color t
	// then cost of painting 3rd house with red would be c =  cost of red for 3rd house + Math.min( cost of painting 2nd house by yellow, cost of painting 2nd house by green)


	public int minCost(int[][] costs) {
		
		if(costs== null || costs.length==0) return 0;
	
		for(int i =1; i<costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}

		return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));

	}

}
