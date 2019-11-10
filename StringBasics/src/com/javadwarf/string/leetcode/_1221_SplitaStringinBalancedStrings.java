package com.javadwarf.string.leetcode;

public class _1221_SplitaStringinBalancedStrings {

	public static void main(String[] args) {

	}

	public int balancedStringSplit(String s) {

		int res = 0;

		int RCount = 0;
		int LCount = 0;

		for(int i =0; i<s.length(); i++) {

			if(s.charAt(i) == 'R') {
				RCount++;
			}
			else if(s.charAt(i) == 'R') {
				LCount++;
			}

			if(LCount == RCount) {
				res++;
				RCount = 0;
				LCount = 0;
			}
		}

		return res;

	}

}
