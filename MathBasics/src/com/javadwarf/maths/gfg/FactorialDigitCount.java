package com.javadwarf.maths.gfg;


public class FactorialDigitCount {

	public static void main(String[] args) {
		System.out.println(digitsInFactorial(42));
	}

	public static int digitsInFactorial(int N){
		java.math.BigInteger f =  java.math.BigInteger.valueOf(1);
		for(int i=1; i<=N; i++) {
			f  = f.multiply(java.math.BigInteger.valueOf(i));
		}
		return f.toString().length();
	}
}
