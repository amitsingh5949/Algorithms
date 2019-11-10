package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_UniqueNumberofOccurrences {

	public static void main(String[] args) {

	}

	public boolean uniqueOccurrences(int[] arr) {
		
		Map<Integer, Integer> map =new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		for(int e : arr) {
			int count = map.getOrDefault(e, 0);
			map.put(e, count+1);
		}
		
		for(Integer a : map.values()) {
			if(set.contains(a)) {
				return false;
			}
			set.add(a);
		}
		
		return true;

	}

}
