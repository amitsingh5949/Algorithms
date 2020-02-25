package com.javadwarf.dynamicprogramming.leetcode.singlestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _140_WordBreakII {

	public static void main(String[] args) {
		//System.out.println(new _140_WordBreakII().wordBreak("catsanddog", Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"})));
		//System.out.println(new _140_WordBreakII().wordBreak("ab", Arrays.asList(new String[] {"a","b","ab"})));
		
		//System.out.println(new _140_WordBreakII().wordBreak("pineapplepenapple", Arrays.asList(new String[] {"apple", "pen", "applepen", "pine", "pineapple"})));
		
        System.out.println(new _140_WordBreakII().wordBreak("catsandog", Arrays.asList(new String[] {"cats","dog","sand","and","cat"})));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		
		Set<String> dict = new HashSet<>(wordDict);

		Set<String>[][] matrix = new HashSet[s.length()][s.length()];

		for(int k=0; k<s.length(); k++) {
			for(int i=0,j=k; j<s.length(); i++,j++) {
				
				Set<String> curr = new HashSet<String>();
				
				if(dict.contains(s.substring(i,j+1))) {
					curr.add(s.substring(i,j+1));
				}
				
				for(int x=i; x<j; x++){
					
					Set<String> temp1 = matrix[i][x];
					Set<String> temp2 = matrix[x+1][j];
					
					if(temp1 != null && temp2 != null) {
						for(String s1 : temp1) {
							for(String s2 : temp2) {
								curr.add(s1+" "+s2);
							}
						}
					}
				}
				
				if(curr.size() > 0) {
					matrix[i][j] = curr;
				}
			}
		}
		return  matrix[0][s.length()-1] != null ?new ArrayList<>(matrix[0][s.length()-1]) : new ArrayList<>();
	}

}
