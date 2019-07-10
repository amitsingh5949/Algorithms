package com.javadwarf.hashtable.leetcode;

import java.util.HashSet;

public class _771_JewelsandStones {

	public static void main(String[] args) {

	}

	// brute force -- not efficient as for every character in S we are doing lookup in J 
	// time complexity - O(J*S)
	public int numJewelsInStones1(String J, String S) {
		int result = 0;
		for(int i = 0; i<S.length();i++) {
			if(J.contains(Character.toString(S.charAt(i)))) {
				result++;
			}
		}
		return result;
	}
	
	// Use hash set to keep count 
	// time complexity - O(S) and space - O(J)
	public int numJewelsInStones(String J, String S) {
		int result = 0;
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i<J.length();i++) {
			set.add(J.charAt(i));
		}
		for(int i = 0; i<S.length();i++) {
			if(set.contains(S.charAt(i))) {
				result++;
			}
		}
		return result;
	}

}
