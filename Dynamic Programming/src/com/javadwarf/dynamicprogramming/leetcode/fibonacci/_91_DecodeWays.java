package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class _91_DecodeWays {

	public static void main(String[] args) {
		System.out.println(new _91_DecodeWays().numDecodings("01"));
		//System.out.println(new _91_DecodeWays().numDecodings("226"));
	}

	//********* Recursive Solution ********************
	public int numDecodings(String s) {
		return numDecodingsRec(s);
	}

	public int numDecodingsRec(String s) {

		if(s.length()==0) return 1;// this is the trick return  1 for empty string
		else if(s.charAt(0) == '0') return 0;//doesn't make sense but leetcode wants "01" to be decoded as 0
		else if(s.length() == 1) return 1;

		int oneDigit = Integer.valueOf(s.substring(0,1));
		int twoDigit = Integer.valueOf(s.substring(0,2));

		int count = 0;

		if(oneDigit != 0) {
			count += numDecodingsRec(s.substring(1));
		}

		if(twoDigit >= 1 && twoDigit <=26) {
			count += numDecodingsRec(s.substring(2));
		}
		return count;
	}
	
	//********* DP Solution ********************
	
	public int numDecodingsDP(String s) {
		return numDecodingsDPRec(s, new HashMap<String, Integer>());
	}

	public int numDecodingsDPRec(String s, Map<String, Integer> memo) {

		if(s.length()==0) return 1;// this is the trick return  1 for empty string
		else if(s.charAt(0) == '0') return 0;//doesn't make sense but leetcode wants "01" to be decoded as 0
		else if(s.length() == 1) return 1;
		
		if(memo.containsKey(s)) {
			return memo.get(s);
		}

		int oneDigit = Integer.valueOf(s.substring(0,1));
		int twoDigit = Integer.valueOf(s.substring(0,2));

		int count = 0;

		if(oneDigit != 0) {
			count += numDecodingsDPRec(s.substring(1),memo);
		}

		if(twoDigit >= 1 && twoDigit <=26) {
			count += numDecodingsDPRec(s.substring(2),memo);
		}
		memo.put(s, count);
		return count;
	}
	
	
	//*********Another way of writing dp, partion at every index and call recursion
	
	public int numDecodingsTOPDOWN(String s) {
        return helper(s, 0, new Integer[s.length()]);
    }
    
    public int helper(String s, int index, Integer[] dp){
        
        if(index == s.length()) return 1;
        if(dp[index] != null) return dp[index];
        
        dp[index] = 0;
        
        for(int i=index; i<s.length(); i++){
            String str = s.substring(index, i+1);
            if(str.length() <=2 && str.charAt(0) != '0') {
                int x = Integer.parseInt(str);
                if( x>=1 && x<=26){
                    dp[index] += helper(s, i+1, dp);
                }
            }
        }
        return dp[index];
    }
}
