package com.javadwarf.leetcode.subarray;

import java.util.HashMap;
import java.util.Map;

public class _523_ContinuousSubarraySum {

	public static void main(String[] args) {
		
		System.out.println(new _523_ContinuousSubarraySum().checkSubarraySum(new int[] {5,0,0},0));

	}

	public boolean checkSubarraySum(int[] nums, int k) {
		
		if(nums == null ||  nums.length < 2) return false;
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		int sum  = 0;
		
		for(int i =0 ; i<nums.length; i++) {
			
			sum += nums[i];
			
			if(k !=  0) {
				sum = sum % k;
			}
			
			if(map.containsKey(sum) && (i - map.get(sum) > 1)){
				return true;
			}
			map.putIfAbsent(sum, i);
		}
		
		return false;
		
	}
}
