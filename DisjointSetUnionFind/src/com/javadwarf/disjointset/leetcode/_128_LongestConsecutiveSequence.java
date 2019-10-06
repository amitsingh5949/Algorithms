package com.javadwarf.disjointset.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
		System.out.println(new _128_LongestConsecutiveSequence().longestConsecutive(arr));

	}

	public int longestConsecutive(int[] nums) {
		DisjointSet ds = new DisjointSet();
		int max = 0 ;
		for(int i : nums) {
			ds.makeSet(i);
		}
		
		for(int i : nums) {
			ds.union(i, i-1);
			ds.union(i, i+1);
		}
		
		for(int i : nums) {
			ds.find(i);
		}
		
		Map<Integer, Integer> leaderCount = new HashMap<>();
		for(DisjointSet.Node n : ds.map.values()) {
			int count = leaderCount.getOrDefault(n.parent.data, 0);
			leaderCount.put(n.parent.data, count +1);
			max = Math.max(max,  count +1);
		}
		return max;
	}

}
