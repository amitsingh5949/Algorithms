package com.javadwarf.leetcode;

import java.util.Arrays;

public class _217_ContainsDuplicate {

	public static void main(String[] args) {

	}
	
	 public boolean containsDuplicate(int[] nums) {
		 
		 boolean result = false;
		 
		 if(nums==null || nums.length == 0) return false;
		 
		 Arrays.parallelSort(nums);
		 
		 for(int i=0; i<nums.length-2; i++) {
			 if(nums[i] == nums[i+1]) {
				 result = true;
				 break;
			 }
		 }
		 
		 return result;
	        
	    }

}
