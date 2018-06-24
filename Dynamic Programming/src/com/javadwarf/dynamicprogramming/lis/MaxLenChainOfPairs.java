package com.javadwarf.dynamicprogramming.lis;

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
	}
	
	public static int longestIncreasingPairSubsequence(int[][] a){
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
