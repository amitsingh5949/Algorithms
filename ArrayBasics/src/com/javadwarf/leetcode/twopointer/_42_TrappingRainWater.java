	package com.javadwarf.leetcode.twopointer;

import java.util.Scanner;

public class _42_TrappingRainWater {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i=0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			System.out.println(trap(a));
			System.out.println();
		}
		s.close();
	}

	// Brute force approach - O(n^2)
	// Solution is that every index of array, maximum water that can be trapped would be
	// min(Max on Left, Max of right)-height at that index
	public static int trap(int[] height) {

		if(height == null || height.length <=1) return 0;

		int result = 0;

		for(int i=0; i<height.length; i++) {
			
			int maxL = height[i];
			int maxR = height[i];

			for(int j=i-1; j>=0; j--) {
				if(height[j]> maxL) {
					maxL = height[j];
				}
			}

			for(int j=i+1; j<height.length; j++) {
				if(height[j] > maxR) {
					maxR = height[j];
				}
			}

			result += Integer.min(maxL, maxR) - height[i];
		}
		return result;
	}

	// approach - O(n) time and O(n) space
	// Solution is that every index of array, maximum water that can be trapped would be
	// min(Max on Left, Max of right)-height at that index
	// We take two arrays and store left max and right max for each index
	public static int trap1(int[] height) {

		if(height == null || height.length <=1) return 0;

		int result = 0;

		int[] maxL = new int[height.length];
		int maxLeft = height[0];
		for(int j=0; j<height.length; j++) {
			if(height[j] > maxLeft) {
				maxLeft = height[j];
			}
			maxL[j] = maxLeft ;
		}

		int[] maxR = new int[height.length];
		int maxRight = height[height.length-1];
		for(int j=height.length-1; j>=0; j--) {
			if(height[j] > maxRight) {
				maxRight = height[j];
			}
			maxR[j] = maxRight ;
		}

		for(int i=0; i<height.length; i++) {
			result += Integer.min(maxL[i], maxR[i]) - height[i];
		}
		return result;
	}
	
// Trapping Rain Water : approach - O(n) time and O(1) space - Two pointer approach
	/*
	  Initialize 
   			left pointer to 0 and right pointer to size-1 and leftMax = 0, rightMax = 0
			 While left<right, do:
				  If height[left] is smaller than height[right]
					    If height[left]≥left_max, update left_max
					    Else add left_max−height[left] ans
					    Add 1 to left.
				  Else
					    If height[right]≥right_max, update right_max
					    Else add right_max−height[right] to ans
					    Subtract 1 from right.
	 */
		
		public static int trap2(int[] height) {
			if(height == null || height.length <=1) return 0;

			int result = 0;

			int leftMax = 0, rightMax = 0;
			int left = 0;
			int right = height.length -1;
			
			while(left < right) {
				//we can say that if there is a larger bar at one end (say right), 
				//we are assured that the water trapped would be dependent on height of smaller bar in current direction (from left to right). 
				//As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). 
				if(height[left] < height[right]) { //the water trapped depends upon the left_max
					if(height[left] > leftMax) {
						leftMax = height[left];
					}
					else {
						result += leftMax - height[left];
					}
					left++;
				}
				else {								//the water trapped depends upon the right_max	
					if(height[right] > rightMax) {
						rightMax = height[right];
					}
					else {
						result += rightMax - height[right];
					}
					right--;
				}
				
			}
			return result;
		}
	
	

}
