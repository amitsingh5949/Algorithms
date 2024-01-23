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

	//Greedy Brute Force o(n^2) and o(1)
	// try to reach lastPos, if you can reach lastPos from i , your i becomes lastPos, see if you can reach 0
	public int jumpGreedyBF(int[] nums) {

		int lastPos = nums.length-1;
		int count = 0;

		while( lastPos > 0){

			int temp = lastPos;

			for(int j=lastPos-1; j>=0; j--){

				if( j + nums[j] >= lastPos){
					temp = j;
				}
			}
			lastPos = temp;
			count++;
		}
		return count;        
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
	//Greedy Method : o(n) and o(1)
	// idea is move to a index which will take you closed to the end i.e an index which has nums[i] - (n-i) greater .i.e power - distance from end

	public int jumpOptimized(int[] nums) {

		int count = 0;
		int i = 0;

		while( i < nums.length-1){

			int sum = nums[i];

			int pi = 0;
			int ps = Integer.MIN_VALUE;

			for(int j = 1; j<= sum ; j++){

				if(i+j == nums.length-1) return count+1;

				int temp =  nums[i+j] - (nums.length -1 - i- j);
				if(temp >= ps){
					ps = temp;
					pi = i+j;
				}
			}
			i = pi;
			count++;
		}

		return count;  
	}
}
