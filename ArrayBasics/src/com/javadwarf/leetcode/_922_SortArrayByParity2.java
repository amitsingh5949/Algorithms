package com.javadwarf.leetcode;

//Two pointer even-odd
public class _922_SortArrayByParity2 {
	
	public static void main(String[] args) {
		sortArrayByParity(new int[] {3,1,2,4});
		sortArrayByParity(new int[] {2,4,3,1});
	}

	public static int[] sortArrayByParity(int[] A) {
		
		int even = 0;
		int odd = 1;
		
		while(true) {
			
			while(even<A.length && (A[even]%2 == 0) ) {
				even = even + 2;
			}
			while(odd <A.length && A[odd]%2 != 0) {
				odd = odd +2;
			}
			
			if(even >= A.length || odd >=A.length) {
				break;
			}
			
			int temp = A[odd];
			A[odd] = A[even];
			A[even] = temp;
			
		}
		return A;

	}

}
