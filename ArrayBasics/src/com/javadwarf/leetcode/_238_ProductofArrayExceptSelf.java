package com.javadwarf.leetcode;

public class _238_ProductofArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4}; // [2,6,48,6]
		int[] x = new _238_ProductofArrayExceptSelf().productExceptSelf(arr);
		

	}

	public int[] productExceptSelf(int[] nums) {
		
		if(nums == null || nums.length == 0) return nums;
		
		int[] productLeft = new int[nums.length+1];
		productLeft[0] = 1;
		for(int i=0; i<nums.length; i++) {
			productLeft[i+1] = productLeft[i] * nums[i];
		}
		
		int[] productRight = new int[nums.length+1];
		productRight[nums.length] = 1;
		for(int i=nums.length-1; i>=0; i--) {
			productRight[i] = productRight[i+1] * nums[i];
		}
		
		int[] res = new int[nums.length];
		
		for(int i=1; i<=nums.length; i++){
			res[i-1] = productLeft[i-1]*productRight[i];
		}
		
		return res;
	}

}
