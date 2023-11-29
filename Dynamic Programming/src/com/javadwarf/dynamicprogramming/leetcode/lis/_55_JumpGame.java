package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.LinkedList;
import java.util.Queue;

public class _55_JumpGame {

	public static void main(String[] args) {

	}

	// whichever approach you using, remember you can use the nums[i] only to go forward

	//Top-Down T : o(n^2)  , S : o(n)
	Boolean[] dp;
	public boolean canJumpTopDown(int[] nums) {
		dp = new Boolean[nums.length];
		return helper(nums, 0);
	}

	public boolean helper(int[] nums, int index){
		if(index >= nums.length-1) return true;
		if(dp[index] != null) return dp[index];
		dp[index]  = false;
		for(int i=index+1; i<= index+nums[index] && i< nums.length; i++){
			dp[index] = dp[index] || helper(nums,i);
			if(dp[index]) return true;
		}
		return dp[index];
	}

	//////TBottom-Up T : o(n^2) , S : o(2n)
	// Same as above, using for loop instead of recursion. 
	// For each index coming from end , check if can reach end
	public boolean canJumpBottomUpFromEnd(int[] nums) {

		boolean[] dp = new boolean[nums.length];
		dp[nums.length-1] = true;

		for(int i=nums.length-2; i>=0; i--){
			dp[i] = false;
			for(int j = i+1; j<nums.length && j<=i+nums[i] ; j++){
				if(dp[j]){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}

	//TBottom-Up T : o(n^2)  , S : o(2n)
	//starting from start and going  to end

	public boolean canJumpBottomUpFromStart(int[] nums) {

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] visited = new boolean[nums.length];
		visited[0] = true;

		while(!q.isEmpty()){
			int curr = q.poll();
			if(curr >= nums.length-1) return true;
			for(int i=1; i<=nums[curr] && i+curr < nums.length; i++){
				if(!visited[i+curr]){
					visited[i+curr] = true;
					q.add(i+curr);
				}
			}
		}
		return false;
	}

	//TBottom-Up T : o(n^2)  , S : o(n)
	//starting from start and going  to end without queue
	public boolean canJumpBottomUpFromStartWitHoutQueue(int[] nums) {

		boolean[] dp = new boolean[nums.length];
		dp[0] = true;

		for(int i=1; i<nums.length; i++){
			for(int j=0; j<i; j++){
				dp[i] = dp[i] || (dp[j] && nums[j] >= (i-j)); 
				if(dp[i]) break;    
			}
		}
		return dp[nums.length-1];
	}

	//same as above
	public boolean canJumpBottomUpFromStartWitHoutQueue1(int[] nums) {

		boolean[] dp = new boolean[nums.length];
		dp[0] = true;

		for(int i=0; i<nums.length; i++){
			if(!dp[i]) return false;

			for(int j=1; j<=nums[i]; j++){
				int ni = i + j;
				if(ni >= nums.length-1) return true; 
				dp[ni] = true; 
			}
		}
		return dp[nums.length-1];
	}

	//same as above but no dp array
	//o(n^2) o(1)
	public boolean canJumpBottomUpFromStartWitHoutQueuewithoutDPArray(int[] nums) {

		if(nums.length == 1) return true;

		for(int i=0; i<nums.length; i++){
			nums[i] = -nums[i];   
		}

		nums[0] = Math.abs(nums[0]);

		for(int i=0; i<nums.length; i++){

			if(nums[i] < 0) return false;

			for(int j=1; j<=Math.abs(nums[i]); j++){
				int ni = i + j;
				if(ni >= nums.length-1) return true; 
				nums[ni] = Math.abs(nums[ni]); 
			}
		}
		return nums[nums.length-1]>0;
	}

	// DP approach - O(n^2) and O(n)
	// In this approach we store the min jump needed for each element by traversing nums[i] distance for every ith element
	public boolean canJump(int[] nums) {

		int[] jumpCount = new int[nums.length];

		for(int i=0; i<nums.length; i++) {

			if( i!=0 && jumpCount[i] == 0) return false; 

			for(int j=i+1; j<=i+nums[i] && j<nums.length; j++) {

				int nextCount = jumpCount[i] + 1;

				if(j == nums.length-1) {
					return true;
				}
				else if(jumpCount[j] == 0 || jumpCount[j] > nextCount) {
					jumpCount[j] = nextCount;
				}
			}	
		}
		return true;
	}


	//Greedy Method : o(n) and o(1)
	// idea is move to a index which will take you closed to the end i.e an index which has nums[i] - (n-i) greater .i.e power - distance from end
	public boolean canJump12(int[] nums) {

		int n = nums.length-1;

		//if(nums == null || nums.length == 0 ) return false;

		int i = 0;

		while( i < n){

			if(nums[i] <= 0) return false;

			int pi = 0;
			int ps = Integer.MIN_VALUE;

			for(int j = i+1; j<= i+ nums[i] ; j++){
				if(j == n) return true;
				int temp =  nums[j] - (n - j);
				if(temp >= ps){
					ps = temp;
					pi = j;
				}
			}
			i = pi;
		}

		return true;
	}

	//Greedy
	// try to reach lastPos, if you can reach lastPos from i , your i becomes lastPos, see if you can reach 0
	public boolean canJumpbestSolution(int[] nums) {
		int lastPos = nums.length-1;
		for(int i=nums.length-2; i>=0; i--){
			if(i+nums[i] >= lastPos) 
				lastPos = i;
		}    
		return lastPos == 0;
	}
}
