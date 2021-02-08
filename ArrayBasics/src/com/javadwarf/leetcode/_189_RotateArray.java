package com.javadwarf.leetcode;

public class _189_RotateArray {

	public static void main(String[] args) {
		rotate2(new int[] {1,2,3,4,5,6,7}, 3);
	}

	//cleaner code than below
	public void rotate(int[] nums, int k) {

		k = k % nums.length;

		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);

	}

	private void reverse(int[] nums, int start, int end){
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	//complekity O(n)
	public static void rotate2(int[] nums, int k) {

		if(nums == null || nums.length <= 1) return;

		if(k > nums.length) {
			k %= nums.length;
		}

		for(int i= 0, j=nums.length-k-1 ; i<j; i++, j--) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i]  = temp;

		}

		for(int i=nums.length-k,j=nums.length-1; i<j; i++, j--) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i]  = temp;

		}

		for(int i= 0, j=nums.length-1 ; i<j; i++, j--) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i]  = temp;

		}

		for(int x = 0 ; x<nums.length ;x++) {
			System.out.print(nums[x] + " ");
		}

	}

	//complekity O(kn)
	public static void rotate1(int[] nums, int k) {

		if(nums == null || nums.length <= 1) return;

		if(k > nums.length) {
			k %= nums.length;
		}

		for(int i= 0; i< k; i++) {
			int temp = nums[nums.length-1];
			for(int j = nums.length-2; j>=0; j--) {
				nums[j+1] = nums[j];
			}
			nums[0] = temp;
		}

		for(int x = 0 ; x<nums.length ;x++) {
			System.out.print(nums[x] + " ");
		}

	}

}
