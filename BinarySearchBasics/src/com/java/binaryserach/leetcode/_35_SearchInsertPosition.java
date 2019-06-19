package com.java.binaryserach.leetcode;

public class _35_SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(new _35_SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 0));
	}

	public int searchInsert(int[] nums, int target) {

		int start = 0 ;
		int end = nums.length-1;
		int mid = start + (end- start)/2;

		while(start <= end) {
			mid = start + (end- start)/2;
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < target){
				start = mid + 1;
			}
			else if(nums[mid] > target) {
				end = mid - 1;
			}
		}
		return start;

	}

}
