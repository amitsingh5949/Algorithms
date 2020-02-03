package amazon.practice;

import java.util.Arrays;

public class Problem2 {

	public static void main(String[] args) {

	}

	public int generalizedGCD(int num, int[] arr){
		
		Arrays.parallelSort(arr);
		
		int max = -1;
		
		for(int i= 1; i<=arr[0]; i++) {
			
			boolean result = true;
			
			for(int j =0; j<arr.length; j++) {
				
				if(arr[j] % i != 0) {
					result = false;
				}
			}
			
			if(result) {
				max = i;
			}
			
		}
		
		return max;
	}

}
