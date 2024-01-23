package com.javadwarf.maths.leetcode;

public class _7_ReverseInteger {
	
	
	//while reversing if your push can cause overflow. below condition to check for overflow
	  // postive  - push > Integer.MAX_VALUE/10  || (push == Integer.MAX_VALUE/10 && pop > 7)
	  //negative  - push < Integer.MIN_VALUE/10 || (push == Integer.MIN_VALUE/10 && pop < -8)
	
	 public int reverse(int x) {
	        
	        if(x == 0) return 0;
	        boolean isPositive = x > 0 ;
	        int push = 0;
	        
	        while( x != 0){
	            
	            int pop = x % 10;
	            x = x/10;
	            
	            if( isPositive){
	                if( push > Integer.MAX_VALUE/10  || (push == Integer.MAX_VALUE/10 && pop > 7)) return 0;
	                else push = push * 10 + pop;
	            }else{
	                 if( push < Integer.MIN_VALUE/10 || (push == Integer.MIN_VALUE/10 && pop < -8)) return 0;
	                 else push = push * 10 + pop;
	            }
	        }
	        
	        return push;
	    }
	 

	
	// use modules of 10 and power of 10, below solution is working but uses more memory and time
	public int reverse1(int x) {

		int isNegative = x<0?-1:1;

		char[] arr = Integer.valueOf(Math.abs(x)).toString().toCharArray();
		int start = 0;
		int end = arr.length-1;

		while(start<end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end]  = temp;
			start++;
			end--;
		}
		int result = 0;
		try {
			result =  Integer.parseInt(new String(arr)) * isNegative;
		}
		catch(NumberFormatException e) {
			result = 0;
		}
		return result;  
	}
	
	

}
