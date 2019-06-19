package com.java.binaryserach.leetcode;

public class _704_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursive solution
	public int search(int[] nums, int target) {
		return search(nums, 0, nums.length-1, target);
	}

	public int search(int[] nums, int begin, int end, int target) {

		if(begin > end) return -1;

		int mid = begin + ((end- begin)/2); // to avoid integer overflow after adding begin+end

		if(nums[mid] == target) {
			return nums[mid];
		}
		else if(nums[mid] > target) {
			return search(nums, begin, mid-1, target);
		}
		else {
			return search(nums, mid+1, end, target);
		}

	}

}
