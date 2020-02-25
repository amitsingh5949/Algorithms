package com.javadwarf.string.leetcode;

import java.util.HashSet;

public class _1044_LongestDuplicateSubstring {

	public static void main(String[] args) {

	}
	
	 public String longestDupSubstring(String S) {
		 
		 
		 return "";
	        
	 }
	 
	 public int serach(int len, int base, long modulus, int[]strArr) {
		 
		 long initialHash = 0;
		 
		 for(int i=0; i<len; i++) {
			 long basePower = ((long)Math.pow((double)base, (double)i) % modulus);
			 initialHash = (initialHash + strArr[i] * basePower) % modulus;
		 }
		 
		 HashSet<Long> set = new HashSet<>();
		 set.add(initialHash);
		 
		 for(int start=1; start<strArr.length-len+1; start++) {
			 initialHash = initialHash - strArr[start-1];
		 }
		 
		 
		 
		 return -1;
	 }

}
