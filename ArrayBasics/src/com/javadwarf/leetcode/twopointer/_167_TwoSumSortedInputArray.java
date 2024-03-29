package com.javadwarf.leetcode.twopointer;

public class _167_TwoSumSortedInputArray {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] numbers, int target) {

		int[] result = new int[2];

		if(numbers== null || numbers.length <=2) return result;

		int start = 0;

		int end = numbers.length-1;

		while(start < end) {

			int temp = numbers[start] + numbers[end];

			if(temp == target) {
				result[0] = start +1;
				result[1] = end + 1;
				break;
			}
			else if(temp < target) {
				start++;
			}
			else {
				end--;
			}
		}
		return result;

	}
	
	//exactly same as above but less LOC
	public int[] twoSum1(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j] == target) return new int[]{i+1,j+1};
            else if(numbers[i]+numbers[j] < target) i++;
            else j--;  
        }
        return null;
    }

}
