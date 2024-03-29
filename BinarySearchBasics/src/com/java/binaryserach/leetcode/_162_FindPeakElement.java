package com.java.binaryserach.leetcode;

public class _162_FindPeakElement {

	public static void main(String[] args) {
		
		System.out.println(findPeakElement(new int[] {1}));
	}
	
	// time : O(log(n))
	
	/*
	 * Interesting thing about finding any peak(number which is greater than its neighbors ) is that we only
	 * need to check the number with its right neighbor if(nums[i] > nums[i+1])
	 * we do not need to check it with its left neighbor i.e (nums[i] > nums[i -1]) is not required. Why? 
	 * 
	 * To determine the slope is increasing or decreasing you need to compare either with left or right neighbor , comparing with one neighbor is enough
	 * So why don't we compare with left neighbor to find slop?
	 * 
	 * Because we want last element of any increasing slop or 
	 * first element of any slope
	 * 
	 * 
	 * Case 1 : Numbers in descending order then array is on decreasing slop then first element will be the peak
	 * Case 2 : Numbers in ascending  order then array is on increasing slop then last element will be the peak
	 * Case 3 : Mixed numbers, peak will be where slop changes from increasing to decreasing
	 *     so we just need to check for slop change
	 */
	
	public static int findPeakElement(int[] nums) {

		if(nums== null || nums.length == 0) return -1;


		int start = 0;
		int end = nums.length-1;
		int mid = (start+end)/2;


		while(start <  end) {
			mid = (start+end)/2;

			if( nums[mid] >  nums[mid+1]) {
				end = mid;// not to avoid the peak number, what if the mid itself is peak.
			}

			if(nums[mid] <  nums[mid+1]) {
				start = mid +1;
			}

		}
		return end;// return start; anything is fine

	}
	
//same solution as above with more verbose language and conditions, in this we are comparing with both left and right
//( in case we forgot the above condition to check only right)
	
public int findPeakElement11(int[] nums) {
        
        if( nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end- start)/2;
        
        while(start <= end){
            
            mid = start + (end- start)/2;
            
            if(mid == 0){
                 if(nums[mid] > nums[mid+1]){
                     return mid;
                 }
                else{
                    start = mid+1;
                }
            }
            else if( mid == nums.length -1){
                if(nums[mid] > nums[mid-1]){
                     return mid;
                 }
                else{
                    end = mid-1;
                }
            }
            else{
                 if( nums[mid-1]< nums[mid] && nums[mid] > nums[mid+1]){
                     return mid;
                 }
                else if( nums[mid-1]< nums[mid] && nums[mid] < nums[mid+1]){
                     start = mid +1;
                 }
                else if( nums[mid-1]> nums[mid] && nums[mid] > nums[mid+1]){
                    end = mid-1;
                }
                else if( nums[mid-1]> nums[mid] && nums[mid] < nums[mid+1]){
                    end = mid-1;
                }
                
            }
            
        }
        
        return -1;
        
        
    }

	// time : O(n)

	public int findPeakElement1(int[] nums) {

		if(nums== null || nums.length == 0) return -1;

		int result = -1;

		for(int i =0 ; i<nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				result = i;
				break;
			}
		}
		return result==-1?nums.length-1:result;

	}

	// same logic  above, divide the array based on increasing or decreasing slop
	

}
