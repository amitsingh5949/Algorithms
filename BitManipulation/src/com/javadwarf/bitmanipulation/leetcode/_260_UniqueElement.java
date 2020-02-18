package com.javadwarf.bitmanipulation.leetcode;

public class _260_UniqueElement {
	/*
	    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
	    Find the two elements that appear only once.
	  
	    The two numbers that appear only once must differ at some bit, this is how we can distinguish between them.
	    Otherwise, they will be one of the duplicate numbers.

        One important point is that by XORing all the numbers, we actually get the XOR of the two target numbers 
        (because XORing two duplicate numbers always results in 0). Consider the XOR result of the two target numbers; 
        if some bit of the XOR result is 1, it means that the two target numbers differ at that location.

		Let’s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i 
		equaling: 0, the other number has bit i equaling 1.
		
		Thus, all the numbers can be partitioned into two groups according to their bits at location i.
		the first group consists of all numbers whose bits at i is 0.
		the second group consists of all numbers whose bits at i is 1.
		
		Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. 
		Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.
		
		by XoRing all numbers in the first group, we can get the first number.
		by XoRing all numbers in the second group, we can get the second number.
	 */

	public static int[] singleNumber(int[] nums) {

		int xorAll = 0;
		for(int i=0; i<nums.length; i++) {
			xorAll ^= nums[i]; 
		}
		int diffBit = -1;
		for(int i = 0; i<32; i++) {
			if((xorAll & (1<<i)) != 0) {
				diffBit = i;
				break;
			}
		}
		int xorGroup1 = 0;
		int xorGroup2 = 0;

		for(int i=0; i<nums.length; i++) {
			if((nums[i] & (1<<diffBit)) != 0) {
				xorGroup1 ^= nums[i];
			}
			else {
				xorGroup2 ^= nums[i];
			}
		}
		return new int[] {xorGroup1, xorGroup2};
	}

}
