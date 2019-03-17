package com.javadwarf.leetcode;

public class _905_SortArrayByParity {
	
	public static void main(String[] args) {
		sortArrayByParity(new int[] {3,1,2,4});
		sortArrayByParity(new int[] {2,4,3,1});
	}

	public static int[] sortArrayByParity(int[] A) {
		
		int odd = 0;
		int even = A.length -1;
		
		while(true) {
			
			while(odd<A.length && A[odd]%2 == 0 ) {
				odd++;
			}
			while(even >=0 && A[even]%2 != 0) {
				even--;
			}
			
			if(odd > even) {
				break;
			}
			
			int temp = A[odd];
			A[odd] = A[even];
			A[even] = temp;
			
		}
		return A;

	}

}
