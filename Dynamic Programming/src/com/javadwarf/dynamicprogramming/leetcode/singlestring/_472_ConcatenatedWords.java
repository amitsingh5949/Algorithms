package com.javadwarf.dynamicprogramming.leetcode.singlestring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _472_ConcatenatedWords {

	public static void main(String[] args) {

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> res = new ArrayList<String>();

		Set<String> set = new HashSet<>();

		for(String word: words) {
			set.add(word);
		}

		for(String word : words) {
			set.remove(word);
			if(wordBreak(word, set)) {
				res.add(word);
			}
			set.add(word);
		}
		return res;
	}

	public boolean wordBreak(String s, Set<String> set) {

		boolean[][] matrix = new boolean[s.length()][s.length()];

		for(int k=0; k<s.length();k++) {
			for(int i=0,j=k;j<s.length();i++,j++) {

				if(set.contains(s.substring(i,j+1))) {
					matrix[i][j] = true;
				}
				else {
					boolean val = false;
					for(int x=i; x<j; x++) {
						val = val || (matrix[i][x]  && matrix[x+1][j]);
					}
					matrix[i][j] = val;
				}
			}
		}
		return matrix[0][s.length()-1];
	}

}
