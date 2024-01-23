package com.javadwarf.dynamicprogramming.leetcode.singlestring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This question can be solved by using Trie as well, below is the DP solution
public class _139_WordBreak {
	
	// top down
	Set<String> set;
    int[] dp;
    
    public boolean wordBreaktopDown(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        dp[0] = helper(s,0);
        return dp[0] == 1;
    }
    
    public int helper(String s, int index){
        
        if(s.length() == index) return 1;

        if(dp[index] != -1) return dp[index];
        
        boolean res = false;
        
        for(int i = index; i< s.length() && !res; i++){
            String substr =  s.substring(index, i+1);
            boolean part1 = set.contains(substr);
            boolean part2 = helper(s, i+1) == 1 ? true : false;
            res = part1 && part2;
        }
        
        dp[index] = res==true ? 1 : 0;
        return dp[index];
        
    }
	
	
	// bottom up
	public static void main(String[] args) {
		List<String >wordDict = Arrays.asList( new String[]{"leet", "code"});
		System.out.println(new _139_WordBreak().wordBreak("leet", wordDict));
	}

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
