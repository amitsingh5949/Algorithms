package com.javadwarf.greedy.leetcode;

public class _991_BrokenCalculator {

	public static void main(String[] args) {

	}

	public int brokenCalc(int X, int Y) {

		int k = 0;
		
		while(Y > X) {
			
			if(Y %2 == 0) {
				Y = Y/2;
			}
			else {
				Y += 1;
			}
			k++;
		}
		
		return k + X - Y;

	}

}
