package com.javadwarf.bitmanipulation.gfg;

public class UniqueElementWhereOtherElemntsKTimes {

	public static void main(String[] args) {

		System.out.println(findUnique(new int[] {6, 2, 5, 2, 2, 6, 6}, 3));
		System.out.println(findUnique(new int[] {2, 2, 2, 10, 2}, 4));
		System.out.println(findUnique(new int[] {5, 5, 4, 8, 4, 5, 8, 9, 4, 8}, 3));
		System.out.println(findUnique(new int[] {4,4,4,3}, 3));

	}
	
	/*
	   Create an array count[] of size equal to number of bits in binary representations of numbers.
	   Fill count array such that count[i] stores count of array elements with i-th bit set.
	   If we take mode x of count[] array, then numbers which repeats k time their ith bit will be zero 
	    and remainder we get distinct number.
	   Form the number by result  += Math.pow(2, k)
	 */

	public static int findUnique(int[] a, int x){
		int result = 0;

		int[] countBitArr = new int[32];

		for(int i=0; i<a.length; i++) {

			for(int k=0; k<32; k++) {
				if( (a[i] & (1 << k)) != 0) {
					countBitArr[k]++ ;
				}
			}
		}

		for(int k=0; k<32; k++) {
			countBitArr[k] %= x; 
		}

		for(int k=0; k<32; k++) {
			if(countBitArr[k] == 1 ) {
				result  += Math.pow(2, k);
			}
		}

		return result;
	}

}
