package com.java.binaryserach.leetcode;

public class _81_SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
	}

	// space complexity - o(1)
	//time - o(log(n))
	//Approach : FInd mid and see which side is sorted, go to the sorted side and check if number could lie in the sorted side, if not move to other side
	// only condition to check is nums[start==mid==end], then end  = end-1

	public boolean search(int[] nums, int target) {

		if(nums == null || nums.length == 0) return false;

		int start = 0 ;
		int end = nums.length -1;
		int mid  = start + (end - start)/2;

		while(start <= end){
			mid  = start + (end - start)/2;
			if(nums[mid] == target) return true;

			if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
				end = end-1;
				continue;
			}

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
		return false;
	}


	// if need to return index
	public int search2(int[] nums, int target) {

		int i = 0;
		int j = nums.length-1;

		while(i<=j){
			int mid = (j-i)/2 + i;

			if(nums[mid] == target) return mid;

			if( i== mid){
				if(nums[mid] == target) return mid;
				if(nums[j] == target) return j;
				return -1;
			}

			if(nums[mid] < nums[j]){

				if(nums[mid] < target && target <= nums[j]){
					i = mid +1;
				}
				else{
					j = mid;                
				}
			}
			if(nums[i] < nums[mid]){

				if(nums[i] <= target && target < nums[mid]){
					j = mid -1;
				}
				else{
					i = mid;                
				}
			}
		}

		return -1;
	}

}
