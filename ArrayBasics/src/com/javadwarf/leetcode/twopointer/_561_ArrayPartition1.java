package com.javadwarf.leetcode.twopointer;

import java.util.Arrays;

public class _561_ArrayPartition1 {
	
	// sort the array, answer would be sum of 2nd max, 4th max, 6th max.... last max i.e 1st min
	public int arrayPairSum1(int[] nums) {
		
		if(nums==null || nums.length==0) return 0;
		
		int result = 0;
		
		Arrays.sort(nums);
		
		for(int i =0 ; i<nums.length; i = i+2) {
			result += nums[i];
		}
		
		return result;

	}
	
	// using counting/Bucket sort
	public int arrayPairSumCountingSort(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
                
        int[] arr = new int[max-min+1];
        
        for(int i=0; i<nums.length; i++){
            arr[nums[i]-min] +=1;
        }
        
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            int count = arr[i]/2;
            sum += count * (i+min );
            arr[i] = arr[i]%2;
        }
        
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0 && flag){
                flag = false;
                sum += (i+min);
            }
            else if(arr[i] != 0 && !flag){
                flag = true;
            }
        }
        
        return sum;
    }
}
