package com.javadwarf.maths.leetcode;


//System.out.println(Integer.MAX_VALUE);2147483647
//System.out.println(Integer.MIN_VALUE);-2147483648
public class _7_ReverseInteger {


	//My own approach
	// idea is that to reverse number we perform p*10 and p*10 + rem
	// check these two operations before performing if they as causing overflow
	public int reverse(int x) {
	
		if(x == Integer.MIN_VALUE ) return 0;

		boolean isPositive = x >= 0 ? true : false;
		x = Math.abs(x);

		int p = 0 ;
		while(x > 0){
			int rem = x % 10;
			x = x/10;
			if(Integer.MAX_VALUE/10 < p || Integer.MAX_VALUE-p*10 < rem) return 0;
			p = p*10 + rem;
		}
		return isPositive ? p : -p;
	}


	//Leetcode approach - nice to look
	//while reversing if your push can cause overflow. below condition to check for overflow
	// positive  - push > Integer.MAX_VALUE/10  || (push == Integer.MAX_VALUE/10 && pop > 7)
	//negative  - push < Integer.MIN_VALUE/10 || (push == Integer.MIN_VALUE/10 && pop < -8)



	public int reverse1(int x) {

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
	public int reverse2(int x) {

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
