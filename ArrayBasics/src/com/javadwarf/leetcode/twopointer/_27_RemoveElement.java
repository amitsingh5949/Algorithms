package com.javadwarf.leetcode.twopointer;

public class _27_RemoveElement {
	
	public static void main(String[] args) {
		System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2},2));
		System.out.println();
		//removeElement(new int[] {1,0});
	}

	public static int removeElement(int[] nums, int val) {
		
		int result = 0;
		
		if(nums== null || nums.length ==0) return 0;

		int zeroIndex = 0;
		int nonZeroIndex = 0;

		while(nonZeroIndex < nums.length && zeroIndex < nums.length) {

			while(zeroIndex < nums.length && nums[zeroIndex] != val) {
				zeroIndex++;
			}

			while(nonZeroIndex < nums.length && nums[nonZeroIndex] == val) {
				nonZeroIndex++;
			}
			if(zeroIndex < nums.length && nonZeroIndex < nums.length) {

				if( zeroIndex < nonZeroIndex) {
					nums[zeroIndex] = nums[nonZeroIndex];
					nums[nonZeroIndex] = val;
				}
				else{
					nonZeroIndex++;
				}
			}
		}
		
		for(int j=0; j<nums.length; j++) {
			if(nums[j] == val) {
				break;
			}
			else {
				result++;
			}
		}
		
		for(int x : nums) {
			System.out.print(x +" ");
		}
		
		return result;

	}

}
