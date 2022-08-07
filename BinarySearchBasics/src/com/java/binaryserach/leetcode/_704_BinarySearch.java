package com.java.binaryserach.leetcode;

public class _704_BinarySearch {

	public static void main(String[] args) {

	}
	
	
	// Iterative Solution
	public int searchIterative(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end-start)/2;
        
        while(start<= end){
            
            mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        
        return -1;
        
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
