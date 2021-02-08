package com.javadwarf.sorting.leetcode;

public class _88_MergeSortedArray {

	public static void main(String[] args) {

		//merge(new int[] {}, 0, new int[] {}, 0);
		merge1(new int[] {4,5,6,0,0,0}, 3, new int[] {1,2,3}, 3);
		System.out.println();
		//merge(new int[] {0}, 0, new int[] {1}, 1);
		//System.out.println();
		
		//merge(new int[] {4,5,6,0,0,0}, 3, new int[] {1,2,3}, 3);

	}
	
	
	
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {

		if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0) return;		
		
		int x = 0;
		int y = 0;
		int v = nums1.length-1;
		
		while(x < m && y < n) {
			
			if(nums1[x]>=nums2[y]) {
				nums1[v] = nums2[y];
				y++;
				v--;
				
			}
			else if(nums1[x]<nums2[y] ) {
				nums1[v] = nums1[x];
				x++;
				v--;
			}
			
		}
		
		for(int i=y; i<n; i++) {
			nums1[v--] = nums2[i];
		}
		
		for(int i=x; i<m; i++) {
			nums1[v--] = nums1[i];
		}
		
		int i = 0;
		int j = m+n-1;
		
		while(i<j) {
			int temp  = nums1[i];
			nums1[i] = nums1[j];
			nums1[j] = temp;
		}

		
	}
	
	
	
	//time o(n+m) and space o(1)
		// idea is to merge number from back, high to low
		
		public static void merge(int[] nums1, int m, int[] nums2, int n) {

			if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0) return;		
			
			int x = m-1;
			int y = n-1;
			int v = nums1.length-1;
			
			while(x >=0 && y >=0) {
				
				if(nums1[x]<=nums2[y]) {
					nums1[v] = nums2[y];
					y--;
					v--;
					
				}
				else if(nums1[x]>nums2[y] ) {
					nums1[v] = nums1[x];
					x--;
					v--;
				}
				
			}
			
			for(int i=0; i<=y; i++) {
				nums1[v--] = nums2[i];
			}

			for(int z : nums1) {
				System.out.print(z +" ");
			}
		}
		
	

}
