package com.javadwarf.sorting.leetcode;

public class _215_KthLargestumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// this question can be solved by using min heap nlog(k) time
	// below solution is o(n) time using quick select from quick sort  logic
	int res = -1;
    public int findKthLargest(int[] nums, int k) {
        res = -1;
        quickselect(nums,nums.length-k, 0, nums.length-1);
        return res;
    }

    public void quickselect(int[] nums, int k, int start, int end){
        if(start > end) return;
        int pos = helper(nums, k, start, end);
        if(pos == k) {
            res = nums[pos];
            return;
        }
        if(pos > k)
         quickselect(nums, k, start, pos-1);
        else
         quickselect(nums, k, pos+1, end);
    }

    public int helper(int[] nums, int k, int start, int end){
        int pivot = end;
        end = end-1;
        while(start <= end){
            if(nums[start] <= nums[pivot]){
                start++;
            }
            else{
                swap(nums, start, end);
                end--;
            }
        }
        swap(nums, start, pivot);
        return start;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
