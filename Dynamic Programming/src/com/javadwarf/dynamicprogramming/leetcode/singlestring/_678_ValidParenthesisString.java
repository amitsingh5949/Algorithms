package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _678_ValidParenthesisString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//top-down
	public boolean checkValidString(String s) {
        return helper(s, 0, 0, new Boolean[s.length()][s.length()+1]);
    }
    
    public boolean helper(String s, int i, int count, Boolean[][] dp){
        
        if(count < 0) return false;
        if(i==s.length()) return count == 0;
        
        if(dp[i][count] != null) return dp[i][count];
        
        boolean temp = false;
        
        if(s.charAt(i) == '('){
            temp = helper(s,i+1, count+1,dp);
        }
        else if(s.charAt(i) == ')'){
            temp = helper(s,i+1, count-1,dp);
        }
        else if(s.charAt(i) == '*'){
            temp = helper(s,i+1, count-1,dp) || helper(s,i+1, count,dp) || helper(s,i+1, count+1,dp);
        }
        
        return dp[i][count] = temp;
        
    }

}
