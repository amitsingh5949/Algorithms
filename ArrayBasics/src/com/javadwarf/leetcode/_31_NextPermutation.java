package com.javadwarf.leetcode;

public class _31_NextPermutation {

	public static void main(String[] args) {
		int [] arr = {1,3,2};
		//Sint [] arr1 = {3,2,1};
		//int [] arr2 = {7,1,2,3,8,4,5,6};
		
		//nextPermutation(arr1);
		//SnextPermutation(arr2);
		nextPermutation(arr);
System.out.println();
	}

	public static void nextPermutation(int[] nums) {

		if(nums == null || nums.length==0 || nums.length ==1) return ;

		boolean isDescreasing = true;
		int i= 0;
		while(i<nums.length-1) {
			if(nums[i+1] > nums[i]) {
				isDescreasing = false;
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

		int start = -1;
		int end   = -1;
		
		int j = nums.length-1;
		while(j>0) {
			if(nums[j-1] < nums[j]) {
				start = j-1;
				end = j;
				break;
			}
			j--;
		}
		
		j= end;
		while(j<nums.length-1) {
			if(nums[j] < nums[start]) {
				break;
			}
			j++;
		}
		int temp = nums[start];
		nums[start] = nums[j];
		nums[j] = temp;
		
		int x = start +1 ;
		int y = nums.length-1;
		while(start<end) {
			int temp1 = nums[x];
			nums[x] = nums[y];
			nums[y] = temp1;
			start++;
			end--;


		}



	}

}
