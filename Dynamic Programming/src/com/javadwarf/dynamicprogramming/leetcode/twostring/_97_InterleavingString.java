package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _97_InterleavingString {

	public static void main(String[] args) {
		System.out.println(new _97_InterleavingString().isInterleave("aab", "axy", "aaxaby"));
	}

	//top- down
	public boolean isInterleaveTD(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1 == null || s1.length()==0) return s2.equals(s3);
        if(s2 == null || s2.length()==0) return s1.equals(s3);
        return helper(s1,s2,s3,0,0,new Boolean[s1.length()][s2.length()]);
    }
    
    public boolean helper(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        
        if(i==s1.length() && j==s2.length()) return true;
        if(i==s1.length()) return s3.substring(i+j).equals(s2.substring(j));
        if(j==s2.length()) return s3.substring(i+j).equals(s1.substring(i));
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(s1.charAt(i) != s3.charAt(i+j) && s2.charAt(j) != s3.charAt(i+j)){
            dp[i][j] = false;
            return false;
        }
        
        boolean temp1=false,temp2=false;
        
        if(s1.charAt(i) == s3.charAt(i+j)){
            temp1 = helper(s1,s2,s3,i+1,j,dp);
        }
        if(s2.charAt(j) == s3.charAt(i+j)){
            temp2 =  helper(s1,s2,s3,i,j+1,dp);
        }
        
        return dp[i][j] = temp1 || temp2;
    }
	
	//bottom-up
	public boolean isInterleave(String s1, String s2, String s3) {

		if(s3.length() != s1.length()+s2.length()) return false;

		boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j =0; j<matrix[i].length;j++) {

				if(i==0 || j==0) {
					if(i==0 && j==0) {
						matrix[i][j] = true;
					}
					else if(i==0) {
						if(matrix[i][j-1] && s3.charAt(j-1) == s2.charAt(j-1) ) {
							matrix[i][j] = true;
						}
					}
					else if(j==0) {
						if(matrix[i-1][j] && s3.charAt(i-1) == s1.charAt(i-1) ) {
							matrix[i][j] = true;
						}
					}
				}
				else {
					if( s3.charAt(i+j-1) != s1.charAt(i-1) && s3.charAt(i+j-1) != s2.charAt(j-1)){						
						matrix[i][j] = false;
					}
					else if( s3.charAt(i+j-1) == s1.charAt(i-1) && s3.charAt(i+j-1) == s2.charAt(j-1)){						
						matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
					}
					else if( (s3.charAt(i+j-1) == s1.charAt(i-1)) && matrix[i-1][j] ) {
						matrix[i][j] = true;
					}
					else if(s3.charAt(i+j-1) == s2.charAt(j-1) && matrix[i][j-1] ) {
						matrix[i][j] = true;
					}
				}
			}
		}

		return matrix[s1.length()][s2.length()];

	}

}
