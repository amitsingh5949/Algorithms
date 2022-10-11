package com.javadwarf.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
	
	//same as above , instead of using map use set, more cleaner
	public int lengthOfLongestSubstringUsingSet(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int start=0;
        int end = 0;

        while(end < s.length()){
            char ch = s.charAt(end);
            if(!set.contains(ch)){
                set.add(ch);
                max = Math.max(max, end-start+1);
            }
            else{
                while( start < end && s.charAt(start) != ch){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }    

        return max;
    }
	
}
