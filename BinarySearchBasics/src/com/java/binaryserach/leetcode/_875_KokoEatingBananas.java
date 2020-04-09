package com.java.binaryserach.leetcode;

public class _875_KokoEatingBananas {

	public static void main(String[] args) {
		
		System.out.println(new _875_KokoEatingBananas().minEatingSpeed(new int[] {3,6,7,11}, 8));
		System.out.println(new _875_KokoEatingBananas().minEatingSpeed(new int[] {30,11,23,4,20}, 5));
		System.out.println(new _875_KokoEatingBananas().minEatingSpeed(new int[] {30,11,23,4,20}, 6));

	}

	public int minEatingSpeed(int[] piles, int H) {
		
		int max = 0;
		
		for(int n : piles) {
			max = Math.max(n, max);
		}
		
		int start = 1;
		int end = max;
		int mid =  start+(end-start)/2;
		
		while(start < end) {
			mid = start+(end-start)/2;
			if(isPossible(piles, H, mid)) {
				end = mid;
			}
			else {
				start = mid +1;
			}
		}
		return start;
	} 
	
	public boolean isPossible(int[] piles, int H, int k) {
		int time = 0;
		for(int n : piles) {
			time += (((n-1)/k) + 1);
		}
		return time<=H;
	}

}
