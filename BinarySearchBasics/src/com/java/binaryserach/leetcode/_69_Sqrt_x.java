package com.java.binaryserach.leetcode;

public class _69_Sqrt_x {

	public static void main(String[] args) {
		System.out.println(new _69_Sqrt_x().mySqrt(9));
		System.out.println(new _69_Sqrt_x().mySqrt(24));
		System.out.println(new _69_Sqrt_x().mySqrt(25));
		System.out.println(new _69_Sqrt_x().mySqrt(26));
	}

	//A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.

	public int mySqrt(int x) {

		if( x==0 ) return 0;

		int start = 1;
		int end = x;

		int mid =  start + (end-start)/2;

		while(start<end) {

			mid =  start + (end-start)/2;

			if(mid <= x/mid && (mid+1) > x/(mid+1)) {
				return mid;
			}
			else if(mid > x/mid) {
				end = mid-1;
			}
			else  {
				start = mid+1;
			}
		}
		return start;
	}

	//my method by finding the bound giving time limit exceeded
	public int mySqrt0(int x) {

		if( x==0 ) return 0;
		int start = 2;
		int end = 2;

		while (end < x) {
			if(end*end > x) {
				break;
			}
			start = end;
			end = end * end;
		}

		int mid  = start + (end- start)/2;

		while( start < end) {

			mid =  start + (end- start)/2;

			if(mid*mid == x) {
				return mid;
			}
			else if(mid*mid > x) {
				end = mid -1;
			}
			else {
				start = mid +1;
			}
		}
		return (start*start> x)?start-1:start;
	}

	//newton's method
	public int mySqrt1(int x) {
		long r = x;
		while (r*r > x)
			r = (r + x/r) / 2;
		return (int) r;
	}

	//Solution3 - Brute Force: Time complexity = O(sqrt(x))
	public int mySqrt2(int x) { 
		if (x == 0) return 0;
		for (int i = 1; i <= x / i; i++) 		
			if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
				return i;		
		return -1;
	}

}
