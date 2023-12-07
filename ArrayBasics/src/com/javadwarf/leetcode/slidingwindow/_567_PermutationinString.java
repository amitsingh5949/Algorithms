package com.javadwarf.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _567_PermutationinString {

	public static void main(String[] args) {

	}

	public boolean checkInclusion(String p, String s) {

		List<Integer> l = new LinkedList<>();
		if(s == null || s.length() ==0 || p == null || p.length() ==0 || p.length() > s.length()) return false;

		Map<Character, Integer> inputStrFreqMap = new HashMap<>();
		for(int i=0; i<p.length(); i++) {
			Character ch = p.charAt(i);
			if(inputStrFreqMap.containsKey(ch)) {
				inputStrFreqMap.put(ch, inputStrFreqMap.get(ch) + 1);
			}
			else {
				inputStrFreqMap.put(ch, 1);
			}
		}

		int required = inputStrFreqMap.size();
		int formed = 0;

		int begin = 0;
		int end = 0;
		Map<Character, Integer> windowStrFreqMap = new HashMap<>();
		int[] resultArr = {Integer.MAX_VALUE,0,0};

		while(end < s.length()) {
			Character ch = s.charAt(end);

			if(!inputStrFreqMap.containsKey(ch)) {
				windowStrFreqMap.clear();
				formed = 0;
				end++;
				begin = end;
			}
			else {
				if(windowStrFreqMap.containsKey(ch)) {
					windowStrFreqMap.put(ch, windowStrFreqMap.get(ch) + 1);
				}
				else {
					windowStrFreqMap.put(ch, 1);
				}
				if(inputStrFreqMap.get(ch).intValue() == windowStrFreqMap.get(ch).intValue()) {
					formed++;
				}
				if(begin <= end && formed == required) {

					while(begin <= end && formed == required) {
						if( (end - begin + 1) == p.length()){
							resultArr[0] = (end - begin + 1) ;
							resultArr[1] = begin;
							resultArr[2] = end;
							((LinkedList)l).addLast(begin);
						}
						Character removedCharFromBegin = s.charAt(begin);
						if(windowStrFreqMap.containsKey(removedCharFromBegin)) {
							windowStrFreqMap.put(removedCharFromBegin, windowStrFreqMap.get(removedCharFromBegin).intValue() -1);
						}
						if(windowStrFreqMap.get(removedCharFromBegin).intValue() < inputStrFreqMap.get(removedCharFromBegin).intValue()) {
							formed--;
						}
						begin++;
					}
				}
				end++;
			}
		}
		return (l.size() > 0)? true : false;

	}

	//same logic as above but less LOC
	public boolean checkInclusion2(String s1, String s2) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for(int i=0;i<s1.length();i++){
			arr1[s1.charAt(i)-'a']++;
		}

		int b=0,e=0;
		while(e < s2.length()){
			arr2[s2.charAt(e)-'a']++;
			e++;
			if(isEqualWindow(arr1,arr2) )return true;
			while(b<e && !isValidWindow(arr1,arr2)){
				arr2[s2.charAt(b)-'a']--;
				b++;  
			}
		}
		return false;
	}

	public boolean isValidWindow(int[] arr1, int[] arr2){
		for(int i=0;i<26;i++){
			if(arr1[i] < arr2[i]) return false;
		}
		return true;
	}

	public boolean isEqualWindow(int[] arr1, int[] arr2){
		for(int i=0;i<26;i++){
			if(arr1[i] != arr2[i]) return false;
		}
		return true;
	}

}
