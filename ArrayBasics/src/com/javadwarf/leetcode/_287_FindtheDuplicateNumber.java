package com.javadwarf.leetcode;

public class _287_FindtheDuplicateNumber {
	
	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
		System.out.println(findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}));
		
	}

	//cycle detection Floyd's turtle and rabbit algorithm, fast moves two step and slow moves one step
	// after each of their moves  if they meet that means there is a cycle
	// Beginning of the cycle would be the duplicate number
	public static int findDuplicate(int[] nums) {
		if(nums==null || nums.length==0) return 0;

		int fast = nums[0];
		int slow = nums[0];
		
		while(true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			
			if(slow == fast) {
			break;
			}
		}
		
		int start = nums[0];
		int end = slow;
		
		while(start != end) {
			start = nums[start];
			end = nums[end];
		}
		
		return start;
	}

	// wrong, this approach assumes number occurs only twice
	public int findDuplicate1(int[] nums) {
		if(nums==null || nums.length==0) return 0;

		int n = nums.length;

		int xor = 0;

		for(int i =0; i<n; i++) {
			xor ^= nums[i];
		}

		for(int i =1; i<=n; i++) {
			xor ^= i;
		}

		return xor ^ n;

	}

}
