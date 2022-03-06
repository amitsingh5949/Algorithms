package com.java.binaryserach.leetcode;

import java.util.Scanner;

public class _33_Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		Scanner s = new  Scanner(System.in);
		int test = s.nextInt();

		for(int i =0; i < test; i++){
			int size = s.nextInt();
			int arr[] = new int[size];

			for(int j =0; i < size; j++) {
				arr[j]  = s.nextInt();
			}

			System.out.println(search(arr, s.nextInt()));
		}

	}
	
	// space complexity - o(1)
	//time - o(log(n))
	//Approach : FInd mid and see which side is sorted, go to the sorted side and check if number could lie in the sorted side, if not move to other side
	
	public static int search(int[] nums, int target) {

	      if(nums == null || nums.length == 0) return -1;

	      int start = 0 ;
	      int end = nums.length -1;
	      int mid  = start + (end - start)/2;

	      while(start <= end){
	        mid  = start + (end - start)/2;
	        if(nums[mid] == target) return mid;

	        if(nums[mid] <= nums[end]){
	          if(nums[mid] <= target && target <= nums[end]){
	            start = mid + 1;
	          }
	          else{
	            end = mid -1;
	          }
	        }

	        if(nums[start] <= nums[mid]){
	          if(nums[start] <= target && target <= nums[mid]){
	              end = mid -1;
	          }
	          else{
	              start = mid + 1;
	          }
	        }
	      }
	      return -1;
	    }

	/*
	 * STRING SOLUTION BUT DIFFICULT TO COME UP AT THGE MOMENT (Need to memorize the condition)
	go to left if (left half is sorted and target lies in left half ) or (left is not sorted and element also does not lie in right half) else go right
	space complexity - o(1)
	time - o(log(n))
	 */
	
	public static int search11(int[] nums, int target) {	
		int begin = 0;
		int end = nums.length-1;

		int mid = begin + (end-begin)/2;

		while(begin<=end){

			mid = begin + (end-begin)/2;

			if(nums[mid] == target){
				return mid;
			}
			if((nums[begin] <= nums[mid] && target >= nums[begin] && target < nums[mid] )
					|| (nums[begin] > nums[mid] && !(target > nums[mid] && target <= nums[end])) ){
				end = mid - 1;
			} 
			else {
				begin = mid + 1;
			}
		}

		return -1;
	}
	
//search pivot and then two binary searches on two sorted arrays
	public static int search1(int[] nums, int target) {

		if(nums.length==0) return -1;
		int result = -1;

		int pivot = findPivot(nums);

		if(pivot == -1) {
			result = binarySearch(nums, target,  0, nums.length-1);
		}
		else if(nums[0] <= target && target <= nums[pivot] ) {
			result = binarySearch(nums, target,  0, pivot);
		}
		else {
			result = binarySearch(nums, target, pivot+1, nums.length-1);
		}
		return result;
	}

	public static int findPivot(int[] nums) {

		if(nums[0]<=nums[nums.length-1]) return 0;

		int result = 0;
		int start = 0;
		int end = nums.length-1;

		int mid = (start + end)/2;

		while(start <= end) {
			mid = (start + end)/2;
			if(nums[mid] > nums[mid+1]) {
				result = mid;
				break;
			}
			else if(nums[start] <= nums[mid]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return result;
	}

	public static int binarySearch(int[] nums, int target, int start, int end) {
		int result = -1;

		int mid = (start + end)/2;

		while(start <= end) {
			mid = (start + end)/2;
			if(nums[mid] == target) {
				result = mid;
				break;
			}
			else if(target < nums[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return result;
	}

}
