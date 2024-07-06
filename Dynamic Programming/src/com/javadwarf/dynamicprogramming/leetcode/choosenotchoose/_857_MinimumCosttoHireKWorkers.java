package com.javadwarf.dynamicprogramming.leetcode.choosenotchoose;

import java.util.Arrays;

public class _857_MinimumCosttoHireKWorkers {

//DP 2^n , not able to memoize
    double result;
    int people;
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        result = Double.MAX_VALUE;
        people = k;

        int[][] skill = new int[wage.length][2];
        for(int i=0;i<wage.length; i++){
            skill[i] = new int[]{quality[i], wage[i]};
        }

        Arrays.sort(skill, (a, b) -> Double.compare( (double)b[1]/(double)b[0], (double)a[1]/(double)a[0] ) );

        helper(skill, k, 0, 0, 0);
        return result;
    }

    public void helper(int[][] skill, int k, int chooseIndex, int idx, double cost){

        if(k == 0 ){
            result = Math.min(result, cost);
            return;
        }

        if( k != 0 && idx == skill.length) return ;

        //not choose
        helper(skill, k, chooseIndex, idx+1, cost);

        // choose
        double pricePerQuality =  (double)skill[chooseIndex][1]/(double)skill[chooseIndex][0];
        double temp = (double)skill[idx][1]/(double)skill[idx][0];

        if(temp <= pricePerQuality){
            helper(skill, k-1, chooseIndex, idx+1, cost + (skill[idx][0] * pricePerQuality) );
        }
        helper(skill, people-1, idx, idx+1, skill[idx][1]);// choose and discard others

    }

}
