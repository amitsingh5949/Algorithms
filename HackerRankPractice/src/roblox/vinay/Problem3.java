package roblox.vinay;

import java.util.List;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*public static long lisMax(int n , List<List<Integer>> operations) {

		int[] arr = new int[n];

		int max = Integer.MIN_VALUE;

		for(List<Integer> operation : operations) {

			int start = operation.get(0);
			int end = operation.get(1);
			int val = operation.get(2);

			for(int i = start-1; i< end; i++ ) {
				arr[i] += val;
				max = Math.max(arr[i], max);
			}

		}

		return max;

	}*/


	public static long listMax(int n , List<List<Integer>> operations) { 

		int[] arr = new int[n];

		for(List<Integer> operation : operations) {

			int start = operation.get(0)-1;
			int end = operation.get(1)-1;
			int val = operation.get(2);

			arr[start] += val; 
			if (end != n - 1) 
				arr[end + 1] -= val; 

		}

		int max = arr[0];
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1]; 
			max = Math.max(max, arr[i]);
		}
		return max;
	} 

}
