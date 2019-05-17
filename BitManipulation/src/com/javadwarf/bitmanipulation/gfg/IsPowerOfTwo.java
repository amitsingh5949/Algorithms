package com.javadwarf.bitmanipulation.gfg;

import java.math.BigInteger;

public class IsPowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerofTwo(BigInteger.valueOf(2)));
		System.out.println(isPowerofTwo(BigInteger.valueOf(0)));
		System.out.println(isPowerofTwo(BigInteger.valueOf(1)));
	}
	
	public static boolean isPowerofTwo(BigInteger n){

		if(n == BigInteger.ZERO ) return false;

		BigInteger x = n.subtract(BigInteger.valueOf(1));
		return n.and(x) == BigInteger.ZERO ? true : false;


	}
}
