package com.javadwarf.leetcode.kadane;

import java.util.Scanner;

public class _152_MaxProductArray {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int i=0; i<test; i++) {
			int size = s.nextInt();
			int[] nums = new int[size];
			for(int j =0; j<size ; j++) {
				nums[j] = s.nextInt();
			}
			System.out.println(maxProduct(nums));
		}

	}
	
	/****************************************************************************************************************************************/
	
	// 9 0 8 -1 -2 -2 6 
	// idea is maintain running min and running max from beginning till end, compare each index with min/max*nums[i]
	public static int maxProduct(int[] nums) {
    	if(nums.length==0) return 0;
    	
    	int result = nums[0];
    	int prevmax = nums[0];
    	int prevmin = nums[0];
    	
    	int currmax = nums[0];
    	int currmin = nums[0];
    	
    	for(int i=1; i<nums.length; i++) {
    		
    		currmax = Integer.max(Integer.max(prevmax*nums[i], prevmin*nums[i]), nums[i]);
    		currmin = Integer.min(Integer.min(prevmax*nums[i], prevmin*nums[i]), nums[i]);
    		
    		prevmax = currmax;
    		prevmin = currmin;
    		
    		if(result < currmax) {
    			result = currmax;
    		}
    	}
    	
    	return result;
        
    }
	
	/****************************************************************************************************************************************/
	
	//Same as above, with variables
	// idea is maintain running min and running max from beginning till end, compare each index with min/max*nums[i]
	
	public int maxProductAgain(int[] nums) {
	       
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        for( int i=1; i<nums.length; i++){
            int temp = Integer.max(nums[i], Integer.max(max*nums[i], min*nums[i]));
            min = Integer.min(nums[i], Integer.min(max*nums[i], min*nums[i]));
            max = temp;
            res = Math.max(res, max);
        }
        
        return res;
    }
	
	/****************************************************************************************************************************************/
	
    public static int maxProduct1(int[] nums) {
    	if(nums.length==0) return 0;
    	
    	int max = Integer.MIN_VALUE;
    	int posmax = 1;
    	int negmin = 1;
    	
    	for(int i=0; i<nums.length; i++) {
    		
    		if(nums[i] == 0) {
    			posmax = 1;
    			negmin = 1;
    			continue;
    		}
    		negmin *= nums[i];
    		
    		if(nums[i] < 0) {
    			posmax = 1;
    		}
    		else {
    			posmax *= nums[i];
    		}
    		
    		if(posmax < negmin) {
    			posmax = negmin;
    		}
    		if(max < posmax) {
    			max = posmax;
    		}
    	}
    	
    	return max;
        
    }
    
    /****************************************************************************************************************************************/

}



