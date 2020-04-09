package fundingcircles;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size =  in.nextInt(); 
		long[] arr = new long[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = in.nextLong();
		}
		System.out.println(getNum(arr));
		in.close();
	}
	
	
	public static long getNum(long[] arr) {
		Arrays.parallelSort(arr);
		
		if(Math.abs(arr[0]) > Math.abs(arr[arr.length-1])) {
			return arr[0];
		}
		else {
			return arr[arr.length-1];
		}
	}

}
