package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _45_JumpGameII {

	public static void main(String[] args) {
		System.out.println(new _45_JumpGameII().jump(new int[] {2,3,1,1,4}));

	}

	// DP approach - O(n^2) and O(n)
	// In this approach we store the min jump needed for each element by traversing nums[i] distance for every ith element
	public int jumpDP(int[] nums) {

		int[] jumpCount = new int[nums.length];

		for(int i=0; i<nums.length; i++) {

			if( i!=0 && jumpCount[i] == 0) return 0; 

			for(int j=i+1; j<=i+nums[i] && j<nums.length; j++) {

				int nextCount = jumpCount[i] + 1;

				if(j == nums.length-1) {
					return nextCount;
				}
				else if(jumpCount[j] == 0 || jumpCount[j] > nextCount) {
					jumpCount[j] = nextCount;
				}
			}	
		}
		return jumpCount[nums.length-1];
	}

	// Greedy - o(n) solution
	
	// take two variables and initialize  them with arr[0]
	// decrement both
	// b would be max(b,arr[i])
	// when a==0 copy b to a

	public int jump(int[] nums) {
		
		if(nums== null || nums.length <=1) return 0;
		
		int count = 1;
		int a = nums[0];
		int b = nums[0];

		for(int i=1; i<nums.length;i++){
			if(i == nums.length-1) return count;
			if(a ==0 && b == 0) return 0;
			a--;
			b--;
			b = Integer.max(b, nums[i]);
			if(a==0){
				a = b;
				count++;
			}
		}
		return count;
	}
}
