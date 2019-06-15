package com.javadwarf.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _340_LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int result = 0;

		if(s == null || s.length() == 0 || k ==0) return result;

		Map<Character, Integer> inputStrFreqMap = new HashMap<>();

		int required = k;
		int formed  = 0;

		int begin = 0, end = 0;
		int[] resArr = {-1,0,0};

		while(end < s.length()) {
			Character ch = s.charAt(end);
			if(inputStrFreqMap.containsKey(ch)) {
				if(resArr[0] == -1 || (end-begin+1) > resArr[0]) {
					resArr[0] = end - begin + 1;
					resArr[1] = begin;
					resArr[2] = end;
				}
				result =  Integer.max(resArr[0], result);
				inputStrFreqMap.put(ch , inputStrFreqMap.get(ch) + 1);
			}
			else {
				if(formed < required) {
					formed++;
					if(resArr[0] == -1 || (end-begin+1) > resArr[0]) {
						resArr[0] = end - begin + 1;
						resArr[1] = begin;
						resArr[2] = end;
					}
					result =  Integer.max(resArr[0], result);
					inputStrFreqMap.put(ch, 1);
				}
				else {
					while(begin <= end && formed >= required ) {
						Character removedCharBegin = s.charAt(begin);
						if(inputStrFreqMap.get(removedCharBegin).intValue() > 1) {
							inputStrFreqMap.put(removedCharBegin , inputStrFreqMap.get(removedCharBegin) - 1);
						}
						else {
							inputStrFreqMap.remove(removedCharBegin);
							formed--;
						}
						begin++;
					}
					continue;
				}
			}
			end++;
		}
		return result;
	}

}
