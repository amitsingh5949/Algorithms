package com.javadwarf.dynamicprogramming.leetcode.choosenotchoose;

import java.util.HashMap;
import java.util.Map;

public class _494_TargetSum {

	public static void main(String[] args) { }

	//BRUTE FORCE RECURSION
	public int findTargetSumWays(int[] nums, int target) {
		return helper(nums, target, 0, 0);
	}

	public int helper(int[] nums, int target, int sum, int i){
		if(target == sum && i == nums.length) return 1;
		if(i == nums.length) return 0;
		return helper(nums, target, sum+nums[i], i+1) + helper(nums, target, sum-nums[i], i+1);
	}
	
	/***********************************************************************************************************************************/
	
	//Top-down with memoisation
	public int findTargetSumWaysTD(int[] nums, int target) {
        return helper(nums, target, 0, 0, new HashMap<>());
    }
    
    public int helper(int[] nums, int target, int sum, int i, Map<Integer, Map<Integer, Integer>> dp){
        if(target == sum && i == nums.length) return 1;
        if(i == nums.length) return 0;
        if(dp.get(i) != null && dp.get(i).get(sum) != null) return dp.get(i).get(sum);
        int count = helper(nums, target, sum+nums[i], i+1,dp) + helper(nums, target, sum-nums[i], i+1,dp);
        Map<Integer, Integer> val = dp.getOrDefault(i, new HashMap<>());
        val.put(sum, count);
        dp.put(i, val);
        return count;
    }
    
    /***********************************************************************************************************************************/
    
    //bottom-up

}

