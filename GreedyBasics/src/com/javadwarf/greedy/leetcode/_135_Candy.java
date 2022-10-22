package com.javadwarf.greedy.leetcode;

import java.util.Arrays;

public class _135_Candy {

	public static void main(String[] args) {

	}

	// o(n^2), o(n)
	// give one candy to everyone, go from left to right if right is greater, give him more, if right is small then check candy from left, fix all left cellss
	public int candyBF(int[] rating) {

		int[] dp = new int[rating.length];
		Arrays.fill(dp,1);

		for(int i=1; i<rating.length; i++){

			if(rating[i] > rating[i-1]){
				dp[i] = dp[i-1] + 1;
			}
			else if(rating[i] < rating[i-1] && dp[i] >= dp[i-1]){
				int k = i;
				while( k > 0 && rating[k-1] > rating[k] &&  dp[k-1] <= dp[k]){
					dp[--k] += 1;
				}
			}
		}

		int sum = 0;
		for(int x : dp){
			sum += x;
		}

		return sum;

	}

	//BF optimized o(n) and o(n)
	// instead of fixing the left cell every time we find an anomaly, skip the anomaly and fix all at once starting from last to first in one go.
	public int candyBFOptimised(int[] rating) {

		int[] dp = new int[rating.length];
		Arrays.fill(dp,1);

		for(int i=1; i<rating.length; i++){
			if(rating[i] > rating[i-1])
				dp[i] = dp[i-1] + 1;
		}

		int k = rating.length-1;
		while( k > 0 ){
			if(rating[k-1] > rating[k] &&  dp[k-1] <= dp[k]){
				dp[k-1] = dp[k] + 1;
			}
			k--;
		}

		int sum = 0;
		for(int x : dp){
			sum += x;
		}

		return sum;

	}

	//optimized o(n) and o(n)
	//Derived from  same above logic, have prefix ad suffix array and take max of each cell
	public int candyOptimizd(int[] rating) {

		int[] dpLR = new int[rating.length];
		int[] dpRL = new int[rating.length];
		Arrays.fill(dpLR,1);
		Arrays.fill(dpRL,1);


		for(int i=1; i<rating.length; i++){
			if(rating[i] > rating[i-1])
				dpLR[i] = dpLR[i-1] + 1;
		}

		for(int i=rating.length-1; i>0; i--){
			if(rating[i-1] > rating[i])
				dpRL[i-1] = dpRL[i] + 1;
		}

		int sum = 0;
		for(int i=0; i<rating.length; i++){
			sum += Math.max(dpLR[i],dpRL[i]);
		}

		return sum;

	}

	// same as above but calculating suffix array on the fly
	public int candy(int[] rating) {

		int[] dpLR = new int[rating.length];
		Arrays.fill(dpLR,1);

		for(int i=1; i<rating.length; i++){
			if(rating[i] > rating[i-1])
				dpLR[i] = dpLR[i-1] + 1;
		}

		int sum = 0;
		int suffix = 1;
		for(int i=rating.length-1; i>0; i--){
			sum += Math.max(dpLR[i], suffix);
			if(rating[i-1] > rating[i])
				suffix += 1;
			else
				suffix = 1;
		}

		sum += Math.max(dpLR[0], suffix);

		return sum;

	}
	
	//Different solution, easy to come up with, fill the lowest rank and then next rating ad so on
	public int candyDifferent(int[] ratings) {
	     
        int max = ratings[0];
        int min = ratings[0];
        
        for(int i=0; i< ratings.length; i++){
            max = Math.max(max, ratings[i]);
            min = Math.min(min, ratings[i]);
        }
        
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        
        for( int i=min; i<=max; i++){
            
            for(int j=0; j<ratings.length; j++){
            
                if(ratings[j] == i){
                    
                    int left = j==0?Integer.MAX_VALUE: ratings[j-1];
                    int right = j==ratings.length-1?Integer.MAX_VALUE: ratings[j+1];
                    
                    if(left< ratings[j] && right >= ratings[j]){
                        res[j] = res[j-1] + 1;
                    }
                    else if(left>= ratings[j] && right < ratings[j]){
                        res[j] = res[j+1] + 1;
                    }
                    else if(left< ratings[j] && right < ratings[j]){
                        res[j] = Math.max(res[j-1], res[j+1]) + 1;
                    }
                    //else if(left>= ratings[j] && right >= ratings[j]){} -- Do NOthing
                }
            }
        }
        
        int count = 0;
        for(int i : res){
            count = count + i;
        }
        return count;
        
    }

}
