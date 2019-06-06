package com.javadwarf.leetcode;

// exactly same as 31_nextpermutaion
public class _556_NextGreaterElementIII {

	public static void main(String[] args) {
		System.out.println(nextGreaterElement(1999999999));
		System.out.println(nextGreaterElement(12));
	}

	public static int nextGreaterElement(int n) {
		int len = Integer.valueOf(n).toString().length();
		int[] nums = new int[len];

		for(int i=0; i<nums.length; i++) {
			nums[i] = Character.getNumericValue(Integer.valueOf(n).toString().charAt(i));
		}


		boolean isDescreasing = true;
		int i= 0;
		while(i < nums.length-1) {
			if(nums[i+1] > nums[i]) {
				isDescreasing = false;
				break;
			}
			i++;
		}
		if(isDescreasing) {
			return -1;
		}
		nextPermutation(nums);

		String temp = "";
		for(i=0; i<nums.length; i++) {
			temp += nums[i];
		}
		int result = -1;
		try {
		 result =  Integer.parseInt(temp) ;
		}
		catch(NumberFormatException e) {
			return result;
		}
		return result;
	}


	public static void nextPermutation(int[] nums) {

		if(nums == null || nums.length==0 || nums.length ==1) return ;
	
		int i = 0;
		int curr = nums.length-1;
		while(curr>0) {
			if(nums[curr-1] < nums[curr]) {
				curr--;
				break;
			}
			curr--;
		}
		int j = curr+2;
		int min = curr+1;
		while(j<nums.length) {
			if(nums[j] <= nums[min] && nums[j] > nums[curr]) { // equals in first condition is important
				min = j;
			}
			j++;
		}
		int temp = nums[curr];
		nums[curr] = nums[min];
		nums[min] = temp;

		i = curr+1;
		j = nums.length-1;
		while(i < j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
