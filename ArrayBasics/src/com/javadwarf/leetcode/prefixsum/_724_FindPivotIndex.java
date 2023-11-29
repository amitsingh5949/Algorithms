package com.javadwarf.leetcode.prefixsum;

public class _724_FindPivotIndex {
	////time and space : o(n) , space o(1)
	 
	
public int pivotIndex(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            nums[i] = sum;
            sum += temp;
        }

        int ans = -1;
        
        for(int i=0; i< nums.length; i++){
            
            if( i == nums.length-1){
                if(nums[i] == 0) return i;
            }
            else{
                if(nums[i] == sum - nums[i+1]) return i;
            }
        }
        return ans;
    }
	 
	 //time and space : o(n)
	 
	 public int pivotIndex1(int[] nums) {
		 int[] prefix = new int[nums.length];
	        prefix[0] = nums[0];
	        
	        for(int i=1; i<nums.length; i++){
	           prefix[i] = prefix[i-1] + nums[i];     
	        }
	        
	        int ans = -1;
	        int sum = 0;
	        for( int i=nums.length-1; i>=0; i--){
	            if(i==0 && sum == 0) return 0;
	            if(i!=0 && sum == prefix[i-1]) ans = i;
	            sum += nums[i];
	        }
	        
	        return ans;
	 }
	 
	 
	 // Two -pointer Approach : Does not work 
	 public int pivotIndex2(int[] nums) {
		 if(nums.length == 1) return 0;
	        
	        int i = 0;
	        int j = nums.length-1;
	        
	        int m = nums[i];
	        int n = nums[j];
	        
	        while(i <= j){
	            if(i == j && m == n){
	                return i;
	            }
	            if(i == j && m != n){
	                return -1;
	            }
	            if(m < n){
	                m += nums[++i];
	            }
	            else{
	                n += nums[--j];
	            }
	        }
	        
	        return i;
	 }

}
