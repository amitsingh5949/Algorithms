package com.javadwarf.hashtable.leetcode;

public class _1189_MaximumNumberofBalloons {

	public static void main(String[] args) {

	}

	public int maxNumberOfBalloons(String text) {

		int[] arr = new int[26];
		
		for(int i=0; i<text.length(); i++) {
			arr[text.charAt(i) -'a'] += 1;
		}
		
		return Math.min(arr['b'-'a'], 
				Math.min(arr['a'-'a'], 
				Math.min(arr['n'-'a'], 
				Math.min(arr['l'-'a']/2,arr['o'-'a']/2))));
	}

}
