package com.javadwarf.leetcode;

public class _31_NextPermutation {

	public static void main(String[] args) {
		int [] arr = {2,3,1};
		int [] arr1 = {3,2,1};
		int [] arr2 = {7,1,2,3,8,4,5,6};
		int[]  arr3 = {2,3,1,3,3};

		int[] arr4 = {2,1,3};
		//nextPermutation(arr1);
		System.out.println();
		nextPermutation(arr3);
		System.out.println();
	//	nextPermutation(arr3);
		System.out.println();
	}
	
	/*
	 * case 1 : if number is in decreasing order then reverse the number
	 * case 2 : if number is in increasing order, swap last two digits
	 * case 3 :
	 *   a. start from  rightmost, index arr.length-1, find a number such that arr[i] < arr[i+1]
	 *   b. find a min number right of i-1 which is greater than arr[i-1] and is smallest among all numbers right to arr[i]
	 *   c. swap arr[min] and arr[i-1]
	 *   d. Sort the numbers right to arr[i-1] or  reverse the remaining elements right to i
	 */

	public static void nextPermutation(int[] nums) {

		if(nums == null || nums.length==0 || nums.length ==1) return ;

		//case 1 : if number is in decreasing order then reverse the number
		boolean isDescreasing = true;
		int i= 0;
		while(i < nums.length-1) {
			if(nums[i+1] > nums[i]) {
				isDescreasing = false;
				break;
			}
			i++;
		}
		if(isDescreasing) {
			int start =0;
			int end = nums.length-1;
			while(start<end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start++;
				end--;
			}
			return;
		}

		/* case 2 condtions are handled in case 3
		 //case 2 : if number is in increasing order, swap last two digits
		boolean isIncreasing = true;
		i = 0;
		while(i < nums.length-1) {
			if(nums[i+1] < nums[i]) {
				isIncreasing = false;
				break;
			}
			i++;
		}
		if(isIncreasing) {
			int temp = nums[nums.length-1];
			nums[nums.length-1] = nums[nums.length-2];
			nums[nums.length-2] = temp;
			return;
		}*/

		// case 3 : 

		//a. start from rightmost index arr.length-1, find a number such that arr[i-1] < arr[i]
		int curr = nums.length-1;
		while(curr>0) {
			if(nums[curr-1] < nums[curr]) {
				curr--;
				break;
			}
			curr--;
		}
		//b. find a min number right of i which is greater than arr[i] and is smallest among all numbers right to arr[i]
		int j = curr+2;
		int min = curr+1;
		while(j<nums.length) {
			if(nums[j] <= nums[min] && nums[j] > nums[curr]) { // equals in first condition is important
				min = j;
			}
			j++;
		}
		//c. swap arr[min] and arr[i]
		int temp = nums[curr];
		nums[curr] = nums[min];
		nums[min] = temp;

		//d. Sort the numbers right to arr[i] - can we do sorting in n without using Arrays.sort(), see the same question in package gfg? because numbers right to i-1 are partially sorted
		//Arrays.sort(nums, curr+1, nums.length);
		
		//d. reverse the remaining elements right to i 
		i = curr+1;
		j = nums.length-1;
		while(i < j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		
		for(int  x= 0 ; x<nums.length; x++) {
			System.out.print(nums[x] + " ");
		}
		
	}

}
