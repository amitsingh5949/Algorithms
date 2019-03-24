package com.javadwarf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));

	}
	public static List<Integer> findDuplicates(int[] nums) {
		
		List<Integer> list = new ArrayList<>();
		
		if(nums==null || nums.length==0) return list;
		
		for(int i=0; i<nums.length; i++) {
			nums[i] -= 1;
		}
		
		int n = nums.length;
		
		for(int i=0; i<nums.length; i++) {
			nums[nums[i]%n] = nums[nums[i]%n] + n;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i]/n>1) {
				list.add(i+1);
			}
		}
		
		
		
		return list;

	}

}
