package com.java.binaryserach.leetcode;

import java.util.Arrays;
import java.util.Random;

public class _398_RandomPickIndex {

	public static void main(String[] args) {

	}

	int[] nums = null;
	Random random = null;
	
	public _398_RandomPickIndex(int[] nums) {
		nums = this.nums;
		Arrays.parallelSort(nums);
		random = new Random();
	}

	public int pick(int target) {
		int[] result = searchRange(nums, target);
		int start = result[0];
		int end = result[1];
		if(start == end) {
			return nums[start];
		}
		int index = random.nextInt(result[1]-result[0]) + result[0];
		return nums[index];
	}
	
	public static int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		int start = 0;
		int end = nums.length -1;
		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start +end)/2;

			if(nums[mid] == target) {
				result[0] = findStart(nums, start, mid, target);
				result[1] = findEnd(nums, mid, end, target);
				break;
			}
			else if(target < nums[mid]) {
				end = mid - 1;
			}
			else if(target > nums[mid]) {
				start = mid + 1;
			}
		}

		return result;

	}

	// first occurrence will be found when arr[start] == target
	public static int findStart(int[] nums, int start, int end, int target) {
		int result = end;

		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start + end)/2;

			if(nums[start] == target) {
				result = start;
				break;
			}

			if(nums[mid] == target) {
				end = mid -1;
			}
			else if(target > nums[mid]) {
				start = mid + 1;
			}
		}
		return result;
	}

	// first occurrence will be found when arr[start] == target
	public static int findEnd(int[] nums, int start, int end, int target) {
		int result = start;

		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start + end)/2;

			if(nums[end] == target) {
				result = end;
				break;
			}

			if(nums[mid] == target) {
				start = mid+1;
			}
			else if(target < nums[mid]) {
				end = mid - 1;
			}
		}
		return result;
	}

}
