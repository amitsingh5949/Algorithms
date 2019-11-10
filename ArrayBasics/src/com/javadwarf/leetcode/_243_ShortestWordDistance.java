package com.javadwarf.leetcode;

public class _243_ShortestWordDistance {

	public static void main(String[] args) {

	}

	public int shortestDistance(String[] words, String word1, String word2) {

		    int min = Integer.MAX_VALUE;
			int index1 = -1;
			int index2 = -1;

			for(int i=0; i<words.length; i++) {

				if(words[i].equals(word1)) {
					index1 = i;
				}
				else if(words[i].equals(word2)) {
					index2 = i;
				}
				if (index1 != -1 && index2 != -1) {
					min = Math.min(min,Math.abs(index2-index1));
				}
			}
			return min;
	}
}
