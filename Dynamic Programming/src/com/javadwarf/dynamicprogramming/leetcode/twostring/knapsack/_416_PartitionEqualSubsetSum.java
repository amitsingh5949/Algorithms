package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,5,11,5}));
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,2,3,5}));
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,2,5}));
	}


	//Brute force approach. Imagine two sets. each number has an option to go in one these sets
	//Explore all possible ways of adding and filling these sets with given number
	// at end, if any any of these combination gives equal subset sum then we have an anwser.
	public boolean canPartitionBF(int[] nums) {
		return helper(nums,0, 0,0);
	}
	public boolean helper(int[] nums, int i, int sum1, int sum2){
		if(i==nums.length) return sum1==sum2;        
		return helper(nums,i+1,sum1+nums[i], sum2) || helper(nums,i+1,sum1, sum2+nums[i]);
	}

	/**********************************************************************************************************************************************************/
	//Same as above, just removed sum2 variable , because its difficult to memoise the state above
	// if we think, to divide the array two equal subset. Total sum of array should be even number and sum of each subset should be totalsum/2.
	public boolean canPartitionBBF(int[] nums) {
        return helper2(nums, Arrays.stream(nums).sum(), 0, 0);
    }
	/**********************************************************************************************************************************************************/
    
    public boolean helper2(int[] nums, int total , int i, int sum1){
        if(i==nums.length) return total%2==0 && sum1==total/2;        
        return helper2(nums,total,i+1,sum1+nums[i]) || helper2(nums,total,i+1,sum1);
    }
    /**********************************************************************************************************************************************************/
    
    // top-down approach with memoisation of above approach
    
    public boolean canPartitionTD(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum %2 !=0) return false;
        return helper3(nums,sum, 0, 0, new Boolean[nums.length][sum+1]);
    }
    
    public boolean helper3(int[] nums, int total , int i, int sum1, Boolean[][] dp){
        if(i==nums.length) return total%2==0 && sum1==total/2;
        if(dp[i][sum1] != null) return dp[i][sum1];
        dp[i][sum1] = helper3(nums,total,i+1,sum1+nums[i],dp) || helper3(nums,total,i+1,sum1,dp);
        return dp[i][sum1] ;
    }
    /**********************************************************************************************************************************************************/
	//bottom-up approach- problem can b e thought as coin change where we need to make sum by using coin only once 
	public boolean canPartition(int[] nums) {
		Arrays.parallelSort(nums);

		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}

		if(sum%2 != 0) return false;
		sum = sum/2;

		boolean[][] matrix = new boolean[nums.length+1][sum+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(i==0 ) {
					matrix[i][j] = false;
				}
				else if(j==0) {
					matrix[i][j] = true;
				}
				else if(nums[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j - nums[i-1]]; //as one number can be used only once
				}
			}
		}
		return matrix[nums.length][sum];
	}
	// Wrong logic below
	//sorting and begin and end pointer approach won't work[1,1,2,2]
	public boolean canPartitionWrong(int[] nums) {
		Arrays.sort(nums);
		int i=0,j=nums.length-1;
		int sum1=0, sum2=0;
		while(i<=j){
			if(sum1>sum2) sum2 += nums[j--];
			else sum1 += nums[i++];
		}
		return sum1 ==sum2;
	}
}
