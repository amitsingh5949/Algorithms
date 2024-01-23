package com.javadwarf.bitmanipulation.leetcode;

public class _190_ReverseBits {

	// wont work
	public int reverseBits(int n) {

		for( int i=0; i<32; i++){
			if( (n & (1<< i) ) != 0){
				n = n & ~(1 << i);
			}
			else{
				n = n | ( 1 << i);
			}
		}
		return n;
	}
}
/*
i/p:000000 10100101000001111010011100
o/p:111111 01011010111110000101100011
leetcode expected o/p : 001110 01011110000010100101000000
*/