package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _256_PaintHouse {

	public static void main(String[] args) {

	}
	
	// top down
	int[][] money;
    
    public int minCosttop(int[][] costs) {
        int sum = Integer.MAX_VALUE;
        money = new int[costs.length][3];
        
        for(int[] arr : money){
            Arrays.fill(arr, -1);
        }
    
        for(int i=0; i<3; i++ ){
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
        
        for(int i=0; i<3; i++ ){
            if(color != i){
                 int temp = costs[index][color] + minCost(costs, index+1, i);
                 min = Integer.min(min, temp);
            }
        }
        money[index][color] = min;
        return min;
    }
	

	// idea is to find cost of painting at ith house with a specific color i.e if i want to paint the 3rd house by red color t
	// then cost of painting 3rd house with red would be c =  cost of red for 3rd house + Math.min( cost of painting 2nd house by yellow, cost of painting 2nd house by green)



	
	// bottom up approach
	
	public int minCost(int[][] costs) {
        
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        
        for(int i=1 ; i<costs.length; i++){
            
            int redTemp = costs[i][0] +  Integer.min(blue, green);
            int blueTemp = costs[i][1] +  Integer.min(green, red);
            int greenTemp = costs[i][2] +  Integer.min(blue, red);
            
            red = redTemp;
            blue = blueTemp;
            green = greenTemp;
        }
        
        return Integer.min(red, Integer.min(blue, green));
        
    }
	// // bottom up approach -optimised 
	
	public int minCost1(int[][] costs) {
		
		if(costs== null || costs.length==0) return 0;
	
		for(int i =1; i<costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}

		return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));

	}

}
