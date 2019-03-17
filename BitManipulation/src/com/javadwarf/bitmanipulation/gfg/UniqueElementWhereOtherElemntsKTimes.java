package com.javadwarf.bitmanipulation.gfg;

public class UniqueElementWhereOtherElemntsKTimes {

	public static void main(String[] args) {

		System.out.println(findUnique(new int[] {6, 2, 5, 2, 2, 6, 6}, 3));
		System.out.println(findUnique(new int[] {2, 2, 2, 10, 2}, 4));
		System.out.println(findUnique(new int[] {5, 5, 4, 8, 4, 5, 8, 9, 4, 8}, 3));
		System.out.println(findUnique(new int[] {4,4,4,3}, 3));

	}

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
