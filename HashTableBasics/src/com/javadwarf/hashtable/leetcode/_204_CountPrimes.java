package com.javadwarf.hashtable.leetcode;

import java.util.Arrays;

public class _204_CountPrimes {

	public static void main(String[] args) {

	}
	// METHOD 1 :  O(n * sqrt(n) ) 
	public int countPrimes(int n) {
		int count = 0;
		for(int i=2; i<n; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	// to check primality of a number we need to use trial division from 2 to sqrt(number)
	public boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

	// Method2 : Sieve of Eratosthenes o(n*log(logn))
	
	/*complexity analysis : given in solution
	 * idea is to create a array of(n+1) size initially consider all numbers to be prime except 0 and 1
	 * now start checking from 2 to n ( or Math.sqr(n) is enough)
	 *   // if current number is prime then all its multiples cannot be prime, set them to 0
	 */
	public int countPrimes1(int n) {
		
		if(n ==0 ) return 0;
		int[] arr = new int[n+1];
		Arrays.fill(arr, 1); // O(n)
		arr[0] = 0;
		arr[1] = 0;

		for(int i=2; i<=Math.sqrt(n); i++) { // this line run o(sqrt(n)
			for(int j=2 ; j*i<n; j++) { // for every numeber it runs as n/2 + n/3 + n/5 + n/7 .... n/lastprimenumber
				arr[j*i] = 0;
			}
		}

		int count = 0;

		for(int i=2; i<n; i++) { //o(n)
			if(arr[i] == 1) {
				count++;
			}
		}

		return count;
	}


}
