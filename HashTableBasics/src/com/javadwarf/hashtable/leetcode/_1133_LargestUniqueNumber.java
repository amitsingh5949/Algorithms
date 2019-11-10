package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1133_LargestUniqueNumber {

	public static void main(String[] args) {

	}

	public int largestUniqueNumber(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();

		for(int i : A) {
			int count = map.getOrDefault(i, 0);
			map.put(i, count+1);
		}

		int max = -1;

		for(int i : A) {
			if(map.get(i) ==1 ) {
				max = Math.max(max, map.get(i));
			}
		}

		return max;
	}

}
