package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _198_HouseRobber {

	public static void main(String[] args) {
		System.out.println(new _198_HouseRobber().rob(new int[] {1,2,3,1}));
	}

	
	/*
	 * 
	 *      Let us look at the case n = 1, clearly f(1) = A1.
			Now, let us look at n = 2, which f(2) = max(A1, A2).
			For n = 3, you have basically the following two options:
				Rob the third house, and add its amount to the first house's amount.
				Do not rob the third house, and stick with the maximum amount of the first two houses.
				Clearly, you would want to choose the larger of the two options at each step.
				Therefore, we could summarize the formula as following:
				f(k) = max(f(k – 2) + Ak, f(k – 1))
			We choose the base case as f(–1) = f(0) = 0, which will greatly simplify our code as you can see.
	 */

	//Solution similar to LIS o(n^2) + o(n)
	public int rob(int[] nums) {

		int max = 0;
		int[] output = new int[nums.length];

		if(nums== null || nums.length == 0) return 0;
		else if(nums.length == 1) return nums[0];
		else {
			output[0] = nums[0];
			output[1] = nums[1];
			max = Integer.max(nums[0], nums[1]);
		}

		for(int i=2; i<nums.length; i++) {
			for(int j=i-2; j>=0; j--) {
				output[i] = Integer.max(output[i], nums[i] + output[j]);
				max = Integer.max(max, output[i]);
			}
		}
		return max;
	}

	// Solution similar to LIS o(n) + o(n)
	// storing max so far
	public int rob1(int[] nums) {

		int max = 0;
		int[] output = new int[nums.length];

		if(nums== null || nums.length == 0) return 0;
		else if(nums.length == 1) return nums[0];
		else {
			output[0] = nums[0];
			output[1] = Integer.max(nums[0], nums[1]);
			max = Integer.max(nums[0], nums[1]);
		}

		for(int i=2; i<nums.length; i++) {
			output[i] =  nums[i] + output[i-2];
			max = Integer.max(max, output[i]);
			output[i] = max;
		}
		return max;
	}
	
	
	// Solution similar to LIS o(n) + o(n)
		// storing max so far -- same as above just removed max variable
	
	// formula is Math.max(nums[i] + output[i-2], output[i-1]);
		public int rob11(int[] nums) {

			int[] output = new int[nums.length];

			if(nums== null || nums.length == 0) return 0;
			else if(nums.length == 1) return nums[0];
			else {
				output[0] = nums[0];
				output[1] = Integer.max(nums[0], nums[1]);
			}

			for(int i=2; i<nums.length; i++) {
				output[i] = Math.max(nums[i] + output[i-2], output[i-1]);
			}
			return output[output.length-1];
		}
	
	    // Solution similar to LIS o(n) + o(1)
		// storing max so far in two variables -  we actually don't need  store all maxs
		public int rob2(int[] nums) {

			int currMax = 0;
			int prevMax = 0;
			if(nums== null || nums.length == 0) return 0;
			else if(nums.length == 1) return nums[0];
			else {
				prevMax = nums[0];
				currMax =  nums[1];
			}

			for(int i=2; i<nums.length; i++) {
				int temp = prevMax + nums[i];
				prevMax = Integer.max(currMax, prevMax);
				currMax = Integer.max(currMax, temp);
			}
			return Integer.max(currMax, prevMax);
		}





}
