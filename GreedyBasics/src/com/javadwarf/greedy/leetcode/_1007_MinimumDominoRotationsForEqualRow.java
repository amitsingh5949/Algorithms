package com.javadwarf.greedy.leetcode;

public class _1007_MinimumDominoRotationsForEqualRow {

	public static void main(String[] args) {

	}


	public int count(int[] A, int[] B, int c) {

		int countA  = 0;
		int countB = 0;
 
		for(int i=0; i <A.length; i++) {
			if(A[i] == c  && B[i] != c ) {
				countB++;
			}
			else if(B[i] == c && A[i] != c) {
				countA++;
			}
			else if(A[i] != c  && B[i] != c){
				return -1;
			}
		}

		return Math.min(countA, countB);

	}

	
	// Idea is if rows A or B  need to be same, there must be one element  which is present at every ith position  either in A or B.
	 // So we need to check only two numbers A[0] and B[0], search in Array if elements can be fliped and made equal to either A[0] or B[0]
	public int minDominoRotations(int[] A, int[] B) {

		int countA = count(A, B, A[0]);
		int countB = count(A, B, B[0]);

		if(countA == -1 && countB == -1) {
			return -1;
		}
		else if(countA == -1 && countB !=-1) {
			return countB;
		}
		else if(countA != -1 && countB ==-1) {
			return countA;
		}
		else {
			return Math.min(countA, countB);
		}
	}



	// brute for approach, idea is check for all possible 1 to 6 numbers, check 1 can be formed in row A or row B , check 2 and so on
	public int minDominoRotations1(int[] A, int[] B) {


		int min = Integer.MAX_VALUE;

		for(int num=1; num<=6; num++) {

			int rotA = 0;
			boolean rotAPossible = true;

			for(int i =0; i<A.length; i++) {

				if(A[i] == num) {
					continue;
				}
				else if(B[i] == num) {
					rotA++;
				}
				else {
					rotAPossible = false;
					rotA = Integer.MAX_VALUE;
					break;
				}
			}

			int rotB = 0;
			boolean rotBPossible = true;

			for(int i =0; i<B.length; i++) {

				if(B[i] == num) {
					continue;
				}
				else if(A[i] == num) {
					rotB++;
				}
				else {
					rotBPossible = false;
					rotB = Integer.MAX_VALUE;
					break;
				}
			}

			if(rotAPossible || rotBPossible) {
				min = Math.min(min, Math.min(rotA, rotB));
			}

		}

		return min==Integer.MAX_VALUE?-1:min;

	}

}
