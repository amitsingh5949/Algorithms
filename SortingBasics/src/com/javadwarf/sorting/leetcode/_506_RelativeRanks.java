package com.javadwarf.sorting.leetcode;

import java.util.Arrays;

public class _506_RelativeRanks {

	public static void main(String[] args) {
		findRelativeRanks(new int[] {1,1,5,4,3});
	}

	public static String[] findRelativeRanks(int[] nums) {

		String[] res = new String[nums.length];

		int[] copyNums = Arrays.copyOf(nums, nums.length);
		
		Arrays.parallelSort(copyNums);
		
		int i= 0;
		int j = nums.length-1;
		
		while(i<j) {
			int temp = copyNums[i];
			copyNums[i] = copyNums[j];
			copyNums[j] = temp;
			i++;
			j--;
		}
		
		boolean[] visited = new boolean[nums.length];
		
		for(i =0; i<copyNums.length;i++) {

			int currMark = copyNums[i];

			for( j= 0; j<nums.length; j++) {
		
				if(nums[j] == currMark && !visited[j]) {
					visited[j] = true;	
					if(i==0) {
						res[j] = "Gold Medal";
					}
					else if(i==1) {
						res[j] = "Silver Medal";
					}
					else if(i==2) {
						res[j] = "Bronze Medal";
					}
					else {
						res[j] = Integer.valueOf(i+1).toString();
					}
					break;
				}
			}
		}
		
		return res;
	}

}
