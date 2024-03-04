package com.javadwarf.leetcode.twopointer;

public class _283_MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] {0,1,0,3,12});
		System.out.println();
		moveZeroes(new int[] {1,0});
	}
	
	public static void moveZeroes(int[] nums) {
        int i=0, j=0;
        
        while(j < nums.length){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        
        while( i<nums.length){
            nums[i] = 0;
            i++;
        }
        
    }

	public static void moveZeroes1(int[] nums) {

		if(nums== null || nums.length <=1) return ;

		int zeroIndex = 0;
		int nonZeroIndex = 0;

		while(nonZeroIndex < nums.length && zeroIndex < nums.length) {

			while(zeroIndex < nums.length && nums[zeroIndex] != 0) {
				zeroIndex++;
			}

			while(nonZeroIndex < nums.length && nums[nonZeroIndex] == 0) {
				nonZeroIndex++;
			}
			if(zeroIndex < nums.length && nonZeroIndex < nums.length) {

				if( zeroIndex < nonZeroIndex) {
					nums[zeroIndex] = nums[nonZeroIndex];
					nums[nonZeroIndex] = 0;
				}
				else{
					nonZeroIndex++;
				}
			}
		}

		for(int x : nums) {
			System.out.print(x +" ");
		}

	}

}
