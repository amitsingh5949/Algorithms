package com.javadwarf.leetcode;

import java.util.HashMap;
import java.util.Map;

//Hashing
public class _1_TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>() ;

		for(int x=0; x<nums.length; x++) {
			map.put(nums[x],x);
		}
		for(int x=0; x<nums.length; x++) {
			Integer val = map.get(target-nums[x]);
			if(val !=null && x != val) {
				return new int[] {x,val};
			}
		}
		return new int[] {};
	}
	
	public int[] twoSumOnePass(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>() ;
		
		for(int x=0; x<nums.length; x++) {
			Integer val = map.get(target-nums[x]);
			if(val !=null && x != val) {
				return new int[] {x,val};
			}
			map.put(nums[x],x);
		}
		return new int[] {};
	}
}
