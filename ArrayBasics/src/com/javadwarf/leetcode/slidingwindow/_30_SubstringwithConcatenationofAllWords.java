package com.javadwarf.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(findSubstring("aaa", new String[] {"aa","aa"}));
		System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
		System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] {"fooo","barr","wing","ding","wing"}));
	}
	
	
	public static List<Integer> findSubstring(String s, String[] words) {

		List<Integer> l = new ArrayList<>();

		if(s == null || s.length() == 0 ||  words == null || words.length == 0) return l;

		String concatenatedWords = "";
		Map<String, Integer> inputStrFreqMap = new HashMap<>();
		for(String word : words) {
			int count = inputStrFreqMap.getOrDefault(word, 0);
			inputStrFreqMap.put(word, count +1);
			concatenatedWords += word;
		}
		
		if(concatenatedWords.length() > s.length()) return l;

		int required = inputStrFreqMap.size();
		int formed = 0;

		int begin = 0, end = 0;
		Map<String, Integer> windowStrFreqMap = new HashMap<>();
		int[] resArr = {-1,0,0};

		int wordLen = words[0].length();
		while(end <= s.length()-wordLen) {

			String curr = s.substring(end, end+wordLen);

			if(!inputStrFreqMap.containsKey(curr)) {
				formed = 0;
				windowStrFreqMap.clear();
				end = end + wordLen;
				begin = end;
			}
			else {
				int count = windowStrFreqMap.getOrDefault(curr, 0);
				windowStrFreqMap.put(curr, count + 1);

				if(inputStrFreqMap.get(curr).intValue() == windowStrFreqMap.get(curr).intValue()) {
					formed++;
				}

				if(formed ==  required) {

					while(begin <= end && formed == required) {

						if((end - begin) == concatenatedWords.length()-wordLen) {
							resArr[0] = (end -begin +1);
							resArr[1]  = begin;
							resArr[2] =  end;
							l.add(begin);
						}

						String removedStrFromBegin  = s.substring(begin, begin + wordLen);
						windowStrFreqMap.put(removedStrFromBegin, windowStrFreqMap.get(removedStrFromBegin) - 1);

						if(inputStrFreqMap.get(removedStrFromBegin).intValue() > windowStrFreqMap.get(removedStrFromBegin).intValue()) {
							formed--;
						}

						begin =  begin + wordLen;
					}
				}
				end = end + wordLen;
			}
		}
		return l;
	}
}
