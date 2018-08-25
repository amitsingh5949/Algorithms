package com.javadwarf.dynamicprogramming.lis;

import java.util.Arrays;

public class MaxLenChainOfPairs {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int a[][] = new int[size][2];
			for(int j=0; j<size; j++){
				for(int k=0; k<2; k++){
				a[j][k] =  in.nextInt();
			}
			}
			System.out.println(longestIncreasingPairSubsequence(a) ); 
		}
		in.close();*/
		System.out.println(longestIncreasingPairSubsequence(new int[][]{{9,10},{9,10},{4,5},{-9,-3},{-9,1},{0,3},{6,10},{-5,-4},{-7,-6}}));
		System.out.println(longestIncreasingPairSubsequence1(new int[][]{{9,10},{9,10},{4,5},{-9,-3},{-9,1},{0,3},{6,10},{-5,-4},{-7,-6}}));
	}
	
	
	public static int longestIncreasingPairSubsequence(int[][] a){
		
		class Pair implements Comparable<Pair>{
			int x, y;
			public Pair(int x, int y) {
				this.x = x;
				this.y = y;
			}
			@Override
			public String toString() {
				return "Pair [x=" + x + ", y=" + y + "]";
			}
			@Override
			public int compareTo(Pair o) {
				int r = Integer.compare(x, o.x);
				if(r == 0) {
					r = Integer.compare(y, o.y);
				}
				return r;
			}
		}
		
		Pair[] arr = new Pair[a.length];
		for(int i=0; i<a.length; i++){
			arr[i]= new Pair(a[i][0], a[i][1]);
		}
		Arrays.sort(arr);
		int[] temp = new int[arr.length];
		if(arr.length==0) return 0;
		
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<i;j++){
				if(arr[i].x > arr[j].y && temp[i] < temp[j]) {
					temp[i] = temp[j];
				}
			}
			temp[i] += 1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<temp.length; i++){
			if(temp[i]>max) max = temp[i];
		}
		return max;
	}
		
	// method 2
	
	public static int longestIncreasingPairSubsequence1(int[][] a){
		a= sortPairs(a);
		int[] temp = new int[a.length];
		if(a.length==0) return 0;
		
		for(int i=0; i<a.length; i++){
			for(int j=0;j<i;j++){
				if(a[j][0]<a[i][0] && a[j][1]<a[i][0] && temp[j] >= temp[i]){
						temp[i] = temp[j];
				}
			}
			temp[i] += 1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<temp.length; i++){
			if(temp[i]>max) max = temp[i];
		}
		return max;
	}
	
	public static int[][] sortPairs(int[][] a){
		for(int i=0; i<a.length; i++){
			for(int j=0;j<a.length-1-i;j++){
				int[] temp = null;
				if(a[j][0]>a[j+1][0]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					temp=null;
				}
			}
			}
		return a;
	}
}
