package com.java.binaryserach.leetcode;

public class _50_Pow_x_n {
	
	public static void main(String [] args) {
		System.out.println(new _50_Pow_x_n().myPow(2, -2));
	}

	public double myPow(double x, int n) {
		
		boolean isNegative = (n < 0) ? true : false;
		return isNegative ? 1.0/pow(x, n) : pow(x, n);// or return isNegative ? 1.0/pow(x, -n) : pow(x, n); n or -n both works
	}

	public double pow(double x, int n) {

		if(n == 0)  return 1;

		double temp =  pow(x, n/2);
		
		if(n%2 == 0) {
			temp = temp * temp;
		}
		else {
			temp = temp * temp * x;
		}
		
		return temp;

	}

}
