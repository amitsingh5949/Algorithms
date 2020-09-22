package com.javadwarf.hashtable.leetcode;

public class _299_BullsandCows {

	public static void main(String[] args) {

	}

	//one pass
	public String getHint(String secret, String guess) {

		int[] arr =  new int[10];

		int cows = 0;
		int bulls = 0;

		for(int i=0; i<secret.length(); i++) {

			int one = secret.charAt(i) - '0';
			int two = guess.charAt(i)  - '0';

			if(one == two) {
				bulls++;
			}
			else {
				if(arr[one] < 0) {
					cows += 1;
				}
				if(arr[two] > 0) {
					cows +=  1;
				}
                arr[one] += 1;
                arr[two] -= 1;
			}
		}

		return bulls+"A"+cows+"B";
	}

	public String getHint1(String secret, String guess) {

		int[] arr1 = new int[10];
		int[] arr2 = new int[10];

		int cows = 0;
		int bulls = 0;

		for(int i=0; i<secret.length(); i++) {

			int one = secret.charAt(i) - '0';
			int two = guess.charAt(i)  - '0';

			if(one == two) {
				bulls++;
			}
			else {
				arr1[one] += 1;
				arr2[two] += 1;
			}
		}

		for(int i=0; i<=9; i++){
			cows += Math.min(arr1[i], arr2[i]);
		}

		return bulls+"A"+cows+"B";

	}

}
