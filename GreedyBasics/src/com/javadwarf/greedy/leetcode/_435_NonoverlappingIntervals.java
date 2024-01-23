package com.javadwarf.greedy.leetcode;

import java.util.Arrays;

public class _435_NonoverlappingIntervals {
	
	//top-down approach
	// o(n^2) and o(n^2) - LC -> MLE
	public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]-b[0] == 0) return a[1]-b[1];
            return a[0]-b[0];
        });
        return helper(intervals, 1, 0, new Integer[intervals.length+1][intervals.length+1]);
    }
    
    public int helper(int[][] intervals, int c, int p, Integer[][] dp){
        if(c >= intervals.length) return 0;
        
        if(dp[c][p] != null) return dp[c][p];
        
        int temp = 0;
        
        if(intervals[p][1] > intervals[c][0]){
            temp = 1 + Math.min(helper(intervals, c+1, c, dp), helper(intervals, c+1, p, dp));
        }
        else{
            temp = helper(intervals, c+1, c, dp);
        }
        return dp[c][p] = temp;
    }
    
    //greedy
    public int eraseOverlapIntervalsGreedy(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]-b[0] == 0) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        int last = 0;
        int count = 0;
        for( int i =1; i<intervals.length; i++ ){
            if(intervals[last][1]  > intervals[i][0]){ // if overlap occurs
                if(intervals[last][1]  > intervals[i][1]){ // choose the interval with smaller end to minimize the chances of overlap again
                    last = i;
                }
                count++;
            }
            else{
                last = i;
            }
        }
        return count;
    }

}
