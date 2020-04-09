package fundingcircles;

import java.util.Scanner;

public class Problem2 {


	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int size =  in.nextInt(); 
		long[] arr = new long[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = in.nextLong();
		}
		
		long count  = 0;
		
		for(int i=0; i<32; i++) {
			count = Math.max(count, setBit(i, arr));
		}
		
		System.out.println(count);
		in.close();
	}
	
	public static long setBit(int pos, long[] arr) {
		
		long count = 0;
		
		for(int i =0; i<arr.length; i++) {
			if((arr[i] & (1 << pos)) != 0) {
				count++;
			}
		}
		return count;
	}

}
