package com.javadwarf.dynamicprogramming.leetcode.singlestring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This question can be solved by using Trie as well, below is the DP solution
public class _139_WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {

		Set<String> set = new HashSet<>(wordDict);

		boolean[][] matrix = new boolean[s.length()][s.length()];

		for(int k=0; k<s.length();k++) {
			for(int i=0,j=k;j<s.length();i++,j++) {
				if(set.contains(s.substring(i,j+1))) {
					matrix[i][j] = true;
				}
				else {
					boolean val = false;
					int start = i;
					for(int x=i; x<j; x++) {
						val = val || (matrix[start][x]  && matrix[x+1][j]);
					}
					matrix[i][j] = val;
				}
			}
		}
		return matrix[0][s.length()-1];
	}
}
