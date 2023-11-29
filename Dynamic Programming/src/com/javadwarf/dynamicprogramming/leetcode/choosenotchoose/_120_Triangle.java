package com.javadwarf.dynamicprogramming.leetcode.choosenotchoose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120_Triangle {

	public static void main(String[] args) {
		List<List<Integer>> l = new ArrayList<>();
		l.add(Arrays.asList(new Integer[]{2}));	
		l.add(Arrays.asList(new Integer[]{3,4}));	
		l.add(Arrays.asList(new Integer[]{6,5,7}));	
		l.add(Arrays.asList(new Integer[]{4,1,8,3}));	
		int min = 	minimumTotalBottomUpGoingDownToUpUsingOnlyOneArray(l);
		System.out.print(min);
	}
	
	//Top down
	Integer[][] dp;
	public int minimumTotalTopDown(List<List<Integer>> triangle) {
		dp = new Integer[triangle.size()][];
		for(int i=0; i< dp.length; i++){
			dp[i] = new Integer[triangle.get(i).size()];
		}
		return helper(triangle, 0, 0);        
	}

	public int helper(List<List<Integer>> triangle, int level, int index){

		if(level >= triangle.size()){
			return 0;
		}

		if(index >= triangle.get(level).size()){
			return 0;
		}

		if(dp[level][index] != null) return dp[level][index];

		List<Integer> l = triangle.get(level);

		int min = Integer.MAX_VALUE;

		//choose i
		min = Integer.min(min, l.get(index)+helper(triangle, level+1, index));
		// choose i+1
		min = Integer.min(min, l.get(index)+helper(triangle, level+1, index+1));

		dp[level][index] = min;
		return min;
	}

	//Bottom - up - going from up to down
	public static int minimumTotalBottomUp(List<List<Integer>> triangle) {

		Integer[][] dp = new Integer[triangle.size()][];
		for(int i=0; i< triangle.size(); i++){
			dp[i] = new Integer[triangle.get(i).size()];
		}
		dp[0][0] = triangle.get(0).get(0);

		for(int i=1; i< triangle.size(); i++){

			List<Integer> l = triangle.get(i);

			for(int j=0; j<l.size(); j++){

				if(j == 0 ){
					dp[i][j] = l.get(j) + dp[i-1][j];
				}
				else if(j == l.size()-1){
					dp[i][j] = l.get(j) + dp[i-1][j-1];
				}
				else{
					dp[i][j] = l.get(j) + Integer.min( dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i=0; i<triangle.get(triangle.size()-1).size(); i++){
			min = Integer.min(min, dp[triangle.size()-1][i]);
		}
		
		return min;

	}
	
	//Bottom - up - going from down to up
		public static int minimumTotalBottomUpGoingDownToUp(List<List<Integer>> triangle) {

			Integer[][] dp = new Integer[triangle.size()][];
			for(int i=0; i< triangle.size(); i++){
				if(i == triangle.size()-1) {
					dp[i] = triangle.get(triangle.size()-1).toArray(new Integer[triangle.get(triangle.size()-1).size()]);
				}
				else {
					dp[i] = new Integer[triangle.get(i).size()];
				}
			}
			
			for(int i=triangle.size()-2; i>= 0; i--){
				List<Integer> l = triangle.get(i);
				for(int j=0; j<l.size(); j++){
					dp[i][j] = l.get(j) + Integer.min( dp[i+1][j+1], dp[i+1][j]);
				}
			}
			
			return dp[0][0];
		}
		
		// Same as above but using o(n) space
		public static int minimumTotalBottomUpGoingDownToUpUsing1DArray(List<List<Integer>> triangle) {

			Integer[] dp = triangle.get(triangle.size()-1).toArray(new Integer[triangle.get(triangle.size()-1).size()]);
			
			for(int i=triangle.size()-2; i>= 0; i--){
				List<Integer> l = triangle.get(i);
				Integer[] temp = new Integer[l.size()];
				for(int j=0; j<l.size(); j++){
					temp[j] = l.get(j) + Integer.min( dp[j], dp[j+1]);
				}
				dp = temp;
			}
			
			return dp[0];
		}
		
		// Same as above but using o(n) space
		public static int minimumTotalBottomUpGoingDownToUpUsingOnlyOneArray(List<List<Integer>> triangle) {
			Integer[] dp = triangle.get(triangle.size()-1).toArray(new Integer[triangle.get(triangle.size()-1).size()]);
	        for (int i=triangle.size()-2; i>=0; i--) 
	            for(int j=0; j<triangle.get(i).size(); j++) 
	                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j); 
	        return dp[0];
		}

}