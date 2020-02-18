package com.javadwarf.greedy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {

	public static void main(String[] args) {
		System.out.println(new _763_PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));

	}

	public List<Integer> partitionLabels(String S) {

		List<Integer> res = new ArrayList<Integer>();

		if(S == null || S.length() == 0) return res;

		int[] charEndIndex = new int[26];

		for(int i =0; i<S.length(); i++) {
			charEndIndex[S.charAt(i)-'a'] = i;
		}

		int start = 0;
		int end = 0;

		for(int i=0; i<S.length(); i++) {
			if( i > end) {
				res.add(S.substring(start, end+1).length());
				start = i;
				end = i;
			}
			end = Math.max(end, charEndIndex[S.charAt(i) - 'a']);
		}
		res.add(S.substring(start, end+1).length());
		return res;
	}

}
