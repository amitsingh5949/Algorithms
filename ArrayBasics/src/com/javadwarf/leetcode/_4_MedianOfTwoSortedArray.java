package com.javadwarf.leetcode;

import java.util.Scanner;

public class _4_MedianOfTwoSortedArray {

	public static void main (String[] args){
		/*Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size1 = s.nextInt();
			int[] a = new int[size1];
			for(int x=0; x<size1; x++) {
					a[x]= s.nextInt();
			}
			int size2 = s.nextInt();
			int[] b = new int[size2];
			for(int x=0; x<size2; x++) {
					b[x]= s.nextInt();
			}
			System.out.println(median(a, b));
		}
		s.close();*/
		
		//System.out.println(median(new int[] {1,12,15,26,38},new int[] {2,13,17,30,45}));
		//System.out.println(median(new int[] {3,8},new int[] {2})); //- fails for this case gives exception
		//System.out.println(median(new int[] {1,2,3},new int[] {4})); //-- fails as it gives wrong result
		System.out.println(median(new int[] {1},new int[] {1}));
		//System.out.println(median(new int[] {1},new int[] {}));
		//System.out.println(median(new int[] {-2,-1},new int[] {3}));
		
		
	}

	
	//Method 2 - o(logn)
	/*
	 * Idea is find a partition which divides both arrays in equal halves not among themselves but combined
	 * It involves 8 variables : start, end, partitionX, partitionY, minX,maxX,minY,maxY
	 * partition X : (start+end)/2 and partitionY = (a.length + b.length + 1)/2 - partitionX
	 * perform binary search on smaller array and find pX and pY
	 * 
	 * how do we know that we have found px, py by (if(minX<=maxY && minY<=maxX))
	 * 
	 */
	public static double median(int[] a, int[] b) {

		if(a.length>b.length) {
			return median(b, a);
		}
		double result = -1.0;
		
		boolean isEven = (a.length + b.length)%2 == 0 ? true : false;
		
		int start = 0;
		int end = a.length;
		int partitionX = -1;
		int partitionY = -1;
		
		while(start<=end) {
		
		 partitionX = (start + end)/2;
		 partitionY = (a.length + b.length + 1)/2 - partitionX;
		 
		 int maxX = (partitionX==a.length) ? Integer.MAX_VALUE : a[partitionX];
		 int minX = partitionX==0?Integer.MIN_VALUE:a[partitionX-1];
		 
		 int maxY = (partitionY==b.length) ? Integer.MAX_VALUE : b[partitionY];
		 int minY = (partitionY==0)?Integer.MIN_VALUE:b[partitionY-1];
				 
		 
		 if(minX<=maxY && minY<=maxX) {
			 if(isEven) {
				 result = (Math.max(minX, minY) + 
						Math.min(maxX, maxY))/2.0;
			 }
			 else {
				 result = Math.max(minX, minY);
			 }
			break; 
		 }
		  
		 if(minX > maxY){
			 end = partitionX - 1;
		 }else {
			 start = partitionX + 1;
		 }	 
		}
		return result;
		
	}
	
	//Method 1 - o(n) -- doesn't work
		public static double median1(int[] a, int[] b) {
			
			
			boolean isEven = (a.length + b.length)%2 == 0 ? true : false;
			int mid = (a.length + b.length)/2;
			
			double result = -1;

			int x = 0;
			int y = 0;

			int count = 0;
			
			if(a.length == 0 && b.length==0){
				return 0.0;
			}
			
			else if(a.length == 0 && b.length!=0) {
				if(isEven) {
					return (b[mid-1] + b[mid])/2.0;
				}
				else {
					return b[mid];
				}
				
			}
			else if(a.length != 0 && b.length==0){
				if(isEven) {
					return (a[mid-1] + a[mid])/2.0;
				}
				else {
					return a[mid];
				}
			}

			while(true) {
				if(count==mid) {
					if(isEven) {
						if(a[x] <= b[y] && x<a.length-1 && a[x+1]<=b[y]) {
								result = (a[x] + a[x+1])/2.0;
						}
						else if (b[y] <= a[x] && y<b.length-1 && b[y+1]<=a[x]) {
							result = (b[y] + b[y+1])/2.0;
						}
						else {
							result = (a[x] + b[y])/2.0;
						}
					}
					else {
						result = a[x]<=b[y] ? b[y] : a[x];
					}
					break;
				}
				if((x<a.length-1 && a[x]<=b[y])  || (x<a.length-1 && y==b.length-1)) {
					x++;
				}
				else if ((y<b.length-1 && a[x]>=b[y])  || (y<b.length-1 && x==a.length-1)){
					y++;
				}
				count++;
			}
			return result;
		}
}
