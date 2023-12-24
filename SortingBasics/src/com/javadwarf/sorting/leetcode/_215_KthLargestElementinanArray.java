package com.javadwarf.sorting.leetcode;

public class _215_KthLargestElementinanArray {

	int res = -1;

	public int findKthLargest(int[] nums, int k) {
		quickSelect(nums, k, 0, nums.length-1);
		return res;
	}

	public void quickSelect (int[] nums, int k, int b, int e) {
		if(b > e) return;
		int pos = partition(nums, b, e);
		if(pos == nums.length-k) res = nums[pos];
		else if (pos > nums.length-k) quickSelect(nums, k, b, pos-1);
		else quickSelect(nums, k, pos+1, e);
	}

	public int partition(int[] nums, int b, int e){
		int p =  (int)(Math.random()*(e-b+1))+b;
		swap(nums,p,e);
		int i=b, j=e-1;

		while(i<=j){
			if(nums[i] <= nums[e]) {
				i++;
			}
			else{
				swap(nums, i, j);
				j--;
			}
		}
		swap(nums, i, e);
		return i;
	}

	public void swap(int[] nums, int i, int j){
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
