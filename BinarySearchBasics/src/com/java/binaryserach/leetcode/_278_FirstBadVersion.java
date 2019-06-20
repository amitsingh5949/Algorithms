package com.java.binaryserach.leetcode;

public class _278_FirstBadVersion extends VersionControl  {

	public static void main(String[] args) {

	}

	public int firstBadVersion(int n) {

		if(n < 1) return -1;

		int  start = 1 ;
		int end = n;

		if(isBadVersion(start) ) 
			return start;
		else if(!isBadVersion(end)) 
			return n;

		int mid = start + (end- start)/2;

		boolean midBad = false;

		while(start <= end) {

			mid = start + (end- start)/2;
			midBad = isBadVersion(mid);

			if(start == mid && midBad) {
				return mid; 
			}

			if(midBad) {
				end = mid;
			}
			else {
				start = mid +1; 
			}
		}
		return -1;
	}
}

class  VersionControl{
	int n = 4;
	public boolean isBadVersion(int version) {
		if(version >= n) 
			return true;
		return false;
	}
}
