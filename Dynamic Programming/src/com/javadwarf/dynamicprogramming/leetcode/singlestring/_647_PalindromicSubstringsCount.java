package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _647_PalindromicSubstringsCount {

	public int countSubstrings(String s) {

		if(s == null || s.length() == 0) return 0;

		int[][] matrix = new int[s.length()][s.length()];

		int count = 0;

		for(int k=0; k<s.length();k++) {
			for(int i=0,j=k; j<s.length() ;i++,j++) {
				if(i==j) {
					matrix[i][j] = 1;
					count++;
				}
				else if(s.charAt(i) == s.charAt(j) && (matrix[i+1][j-1] != 0 || j-i==1)) {
					matrix[i][j] = 2+matrix[i+1][j-1];// or any on-zero number number 
					count++;
				}
			}
		}
		return count;
	}

	//same as above using boolean array
	public int countSubstrings1(String s) {
		int count = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int len=0; len<s.length(); len++){
			for( int i=0,j=len; j<s.length(); i++,j++){
				if(i==j) dp[i][j] = true;
				else if( (s.charAt(i) == s.charAt(j) )&& (dp[i+1][j-1] || j-i==1)) dp[i][j] = true;
				if(dp[i][j]) count++;
			}
		}
		return count;
	}
	
	// expand around centers approach
	
	 public int countSubstrings2(String s) {
	        int count =0;
	        for( int i=0;i<s.length(); i++){
	            count += expand(s, i,i) + expand(s, i, i+1);
	        }
	        return count;
	    }
	    
	    public int expand(String s, int i, int j){
	        int count = 0;
	        while( i>=0 && j<s.length() && s.charAt( i) == s.charAt(j)){
	            count++;
	            i--;
	            j++;
	        }
	        return count;
	    }

}
