package com.javadwarf.dynamicprogramming.leetcode.twostring;

import java.util.Arrays;

public class _62_UniquePaths {
	
	//top down approach
	int m;
    int n ;
    int[][] dp;
    
    public int uniquePathsTopDown(int m, int n) {
        dp = new int[m][n];
        this.m = m;
        this.n = n;
        return helper(0,0);
    }
    
    public int helper(int x, int y){
        if(x>=m || y>=n) return 0;
        if(x==m-1 && y==n-1) return 1;
        
        if(dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = helper(x,y+1) + helper(x+1,y);
        return dp[x][y];
    }
    
    
    // bottom up
	public int uniquePaths(int m, int n) {

		int[][] matrix = new int[m+1][n+1]; // no need for 0th row and column

		for(int i=0;i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length; j++) {
				if(i==0 || j==0) {
					matrix[i][j] =0;
				}
				else if(i==1 ||  j==1) {
					matrix[i][j] =1;
				}
				else {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		return matrix[m][n];
	}

	// no need for 0th row and column
	public int uniquePaths1(int m, int n) {
		int[][] matrix = new int[m][n]; 
		for(int i=0;i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length; j++) {
				if(i==0 ||  j==0) 
					matrix[i][j] =1;
				else 
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}
		}
		return matrix[m-1][n-1];
	}
	
	// we can use o(n) space, no need to store all rows of dp, we need prev row only
	
	public int uniquePathsSpaceOptimised(int m, int n) {
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int i=1; i<m;i++){
            int prev = 1;
            for(int j =1; j<n; j++){
                dp[j] = dp[j] + prev;
                prev = dp[j];
            }
        }
        return dp[n-1];
    }
	
	//Math formula solution 
	int uniquePaths2(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }
	
}
