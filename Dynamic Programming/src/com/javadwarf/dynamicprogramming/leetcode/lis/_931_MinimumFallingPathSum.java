package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _931_MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//top down
	int[][] money;
    
    public int minFallingPathSum(int[][] costs) {
     int sum = Integer.MAX_VALUE;
        money = new int[costs.length][costs[0].length];
        
        for(int[] arr : money){
            Arrays.fill(arr, -1);
        }
    
        for(int i=0; i<costs[0].length; i++ ){
            money[0][i]=minCost(costs, 0, i);
        }
        for(int i : money[0]){
            sum = Integer.min(i, sum);
        }
        return sum;
    }
    
    public int minCost(int[][] costs, int index, int color) {
        
        if(index == costs.length-1) return costs[index][color];
        
        if(money[index][color] != -1) return money[index][color];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<costs[0].length; i++ ){
            if(Math.abs(color- i) <= 1){
                 int temp = costs[index][color] + minCost(costs, index+1, i);
                 min = Integer.min(min, temp);
            }
        }
        money[index][color] = min;
        return min;
    }
    
    //bottom up
    public int minFallingPathSumBottomUP(int[][] matrix) {
        int[] res = matrix[0];
        
        for(int i=1 ; i<matrix.length; i++){
            
            int[] resTemp = new int[matrix[0].length];
            
            for(int j =0; j<matrix[0].length; j++){
                if(j == 0){
                    resTemp[j] =  matrix[i][j] + Integer.min(res[j],res[j+1]);
                }
                else if(j == matrix[0].length-1){
                    resTemp[j] = matrix[i][j] + Integer.min(res[j],res[j-1]);
                }
                else{
                    resTemp[j] = matrix[i][j] + Integer.min(res[j], Integer.min(res[j-1], res[j+1]));
                }
            }
            res = resTemp;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i : res){
            min = Integer.min(min, i);
        }
        return min;
    }

}
