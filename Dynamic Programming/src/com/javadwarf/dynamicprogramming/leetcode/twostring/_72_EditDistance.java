package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _72_EditDistance {

	public static void main(String[] args) {
		System.out.println(new _72_EditDistance().minDistance("horse", "ros"));
	}
	
	//Top -down
	
	Integer[][] dp;
    public int minDistanceTopDown(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return helper(word1, word2, 0, 0);
    }
    
    public int helper(String word1, String word2, int i , int j){
        
       if(i== word1.length() && j == word2.length()){
           return 0 ;
       }
       
       if(i == word1.length() && j != word2.length()){
           return word2.length() -j;
       }
        
        if(i != word1.length() && j == word2.length()){
           return (word1.length() -i);
       }
       
        
       if(dp[i][j] != null) return dp[i][j];
        
       if(word1.charAt(i) == word2.charAt(j)){
           dp[i][j] = helper(word1, word2, i+1, j+1);
       }
       else{
           int x = helper(word1, word2, i+1, j+1);
           int y = helper(word1, word2, i+1, j);
           int z = helper(word1, word2, i, j+1);
           dp[i][j] = 1 + Integer.min(x, Integer.min(y,z));
       }
       return dp[i][j]; 
    }

    //Bottom -up

	public int minDistance(String word1, String word2) {

		int[][] matrix = new int[word1.length()+1][word2.length()+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j= 0; j<matrix[i].length; j++) {

				if(i==0 && j==0) {
					matrix[i][j] = 0;
				}
				else if(i==0 && j!=0) {
					matrix[i][j] = j;
				}
				else if(i!=0 && j==0) {
					matrix[i][j] = i;
				}
				else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1];
				}
				else {
					matrix[i][j] = Math.min(matrix[i][j-1],
							Math.min(matrix[i-1][j-1] ,matrix[i-1][j])) +1;
				}

			}

		}

		return matrix[word1.length()][word2.length()];
	}
}
