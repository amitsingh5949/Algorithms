package com.javadwarf.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		
		for(int i=0 ; i<tests ; i++) {
			System.out.println(lengthOfLongestSubstring(scan.next()));
		}
		scan.close();
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {

		int result = 0;

		if( s == null || s.length() == 0) return result;

		Map<Character, Integer> inputStrFreqMap = new HashMap<>();

		int begin = 0;
		int end = 0;
		int formed = 0 ;

		while(end < s.length()){
			Character ch = s.charAt(end);
			
			if(!inputStrFreqMap.containsKey(ch)) {
				inputStrFreqMap.put(ch,1);
				formed++;
				result = Integer.max(result, formed);
			}
			else {
				while(begin <= end && s.charAt(begin) != ch) {
					inputStrFreqMap.remove(s.charAt(begin));
					begin++;
					formed--;
				}
				begin++;
			}
			end++;
		}
		return result;
	}
}
