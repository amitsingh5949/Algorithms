package com.javadwarf.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _438_FindAllAnagramsinaString {

	public static void main(String[] args) {

		//System.out.println(findAnagrams("abab", "ab"));

	}

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> l = new LinkedList<>();
		if(s == null || s.length() ==0 || p == null || p.length() ==0 || p.length() > s.length()) return l;

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
		return l;
	}
	
//very beautiful, hash solution	
public List<Integer> findAnagramsHashSolution(String s, String p) {
        
        List<Integer> l = new ArrayList<>();
        if(s.length() < p.length()) return l;
        
        int[] pHash = getHash(p, 0, p.length());
        int[] sSubStrHash = getHash(s, 0, p.length());
        
        for(int i=0; i< s.length() - p.length(); i++){
            
            if(isEqual(pHash, sSubStrHash)){
                l.add(i);
            }
            
            sSubStrHash[s.charAt(i) - 'a'] -= 1;
            sSubStrHash[s.charAt(i + p.length()) -'a'] += 1;
            
        }
        
        if(isEqual(pHash, sSubStrHash)){
            l.add(s.length() - p.length());
        }
        
        return l;
        
    }
    
    public int[] getHash(String curr, int start, int end){
        
        int[] map = new int[26];
        
        for(int i=start; i<end; i++){
            map[curr.charAt(i) - 'a'] += 1;
        }
        
        return map;
        
    }
    
    public boolean isEqual( int[] pHash,int[] subStrHash ){
        
        for(int i=0; i< pHash.length ; i++){
            if(pHash[i] != subStrHash[i]){
                return false;
            }
        }
        
        return true;
    }
}
