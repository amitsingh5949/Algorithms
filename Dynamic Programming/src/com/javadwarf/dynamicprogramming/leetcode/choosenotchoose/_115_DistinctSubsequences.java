package com.javadwarf.dynamicprogramming.leetcode.choosenotchoose;

public class _115_DistinctSubsequences {
	
	//top down approach
	public int numDistinct(String s, String t) {
        return helper(s,t,0,0, new Integer[s.length()][t.length()]);
    }
    
    public int helper(String s, String t, int i , int j, Integer[][] dp){
        
        if(j==t.length()) return 1;
        if(i== s.length()) return 0;
        int temp1 = 0;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            temp1 = helper(s,t,i+1,j+1, dp);
        }
        int temp2 = helper(s,t,i+1,j, dp);
        return dp[i][j] = temp1+temp2;
    }

}
