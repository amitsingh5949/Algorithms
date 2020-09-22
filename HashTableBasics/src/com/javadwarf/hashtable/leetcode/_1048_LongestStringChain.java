package com.javadwarf.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {

	public static void main(String[] args) {
		//System.out.println(new _1048_LongestStringChain().longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
		System.out.println(new _1048_LongestStringChain().longestStrChain(new String[] {"ab","bac"}));//1
	}

	/*
	 *  1. Sort the strings by their lengths
		2. Start from shorter words (bottom up DP)
		3. During the loop: for each word, iterate through its length and each time delete 1 char. 
		   Update the longest string chain length in the hashmap for the current word.
	 */
	public int longestStrChain(String[] words) {
		Arrays.parallelSort(words, (a,b) -> Integer.compare(a.length(), b.length()));
		int max = 0;
		Map<String, Integer> map = new HashMap<>();
		for(String word : words) {
			if(!map.containsKey(word)) {
				map.put(word, 1);
				for(int i=0; i<word.length(); i++) {
					String temp = word.substring(0,i)+word.substring(i+1);
					if(map.containsKey(temp) && map.get(temp) + 1 > map.get(word)) {
						map.put(word, map.get(temp) + 1);
					}
					max = Math.max(max, map.get(word));
				}
			}
		}
		return max;
	}

	// brute force using recursion
	public static int max = 0;
	public int longestStrChain1(String[] words) {
		Arrays.parallelSort(words, (a,b) -> Integer.compare(a.length(), b.length()));
		max = 0;
		for(int i=0; i<words.length; i++) {
			rec(i, words, 1);
		}
		return max;
	}

	public void rec(int pos, String[] words, int len) {
		for(int i=pos+1; i<words.length; i++){
			if(words[pos].length() != words[i].length()) {
				if(compare(words[pos], words[i])) {
					rec(i, words, len+1);
				}
			}
		}
		max = Math.max(max, len);
	}

	public boolean compare(String s1, String s2) {
		int[] arr = new int[26];
		for(int i=0; i<s2.length(); i++) {
			arr[s2.charAt(i)-'a'] += 1;
		}
		for(int i=0; i<s1.length(); i++) {
			arr[s1.charAt(i)-'a'] -= 1;
		}
		int count = 0;
		for(int i=0; i<26; i++) {
			if(arr[i] < 0) {
				return false;
			}
			count += arr[i];
		}
		return count == 1 ? true : false;
	}


}
