package com.javadwarf.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350_IntersectionofTwoArraysII {

	public static void main(String[] args) {

		intersect(new int[] {1,2,2,1}, new int[] {2,2});
		System.out.println();
		intersect(new int[] {1,2,2,1}, new int[] {2});
		
	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> l = new ArrayList<>();

		if(nums1 == null || nums2== null || nums1.length==0 || nums2.length ==0 ) return new int[] {};

		Arrays.parallelSort(nums1);
		Arrays.parallelSort(nums2);

		int x = 0;
		int y = 0;


		while(x<nums1.length && y<nums2.length ) {
			if(nums2[y] == nums1[x]) {
				l.add(nums2[y]);
				x++;
				y++;
			}
			else if(nums2[y] < nums1[x]) {
				y++;
			}
			else {
				x++;
			}
		}


		int[] result = new int[l.size()];
		for(int i=0; i< result.length; i++) {
			result[i] = l.get(i);
			System.out.print(result[i] + " ");
		}
		return result;

	}
	
	//
	
	
	class Solution {
	    public int[] intersect(int[] nums1, int[] nums2) {
	        
	        List<Integer> res = new ArrayList<>();
	        
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        
	        int[] small = nums1.length<=nums1.length? nums1 : nums2;
	        int[] big = nums1.length>nums1.length? nums1 : nums2;
	        
	        int start = 0;
	        int end = big.length-1;
	        
	        for(int i=0; i<small.length; i++){
	            int index = findFirstOccurence(big, small[i], start, end);
	            if(index != -1){
	                start = index + 1;
	                res.add(small[i]);
	            }
	        }
	        
	        return res.stream().mapToInt(i->i).toArray();
	        
	    }
	    
	    
	    public int findFirstOccurence(int[] nums, int target, int start, int end){
	        
	        int mid = start + (end-start)/2;
	        
	        while(start <= end){
	            
	            mid = start + (end-start)/2;
	            
	            if(start == mid){
	                
	                if(nums[start] == target) return start;
	                if(nums[end] == target) return end;
	                return -1;
	                
	            }
	            else if(nums[mid] == target){
	                end = mid;
	            }
	            else if(nums[mid] < target){
	                start = mid + 1;
	            }
	            else{
	                end = mid -1;
	            }
	            
	        }
	        
	        return -1;
	        
	    }
	}

}
