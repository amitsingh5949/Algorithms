package com.javadwarf.greedy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _846_HandofStraights {
	
	
	//o(n^2)
	// Approach : sort array and start making groups of consecutive numbers.
	// Look for better approach with hashmap and min heap
	public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int prev = -1;
        
        for(int i=0; i<hand.length; i++){
            if(!set.contains(i)){
                if(count == 0){
                    prev = hand[i];
                    count++;
                    set.add(i);
                    if(count ==  groupSize){
                        count = 0;
                        i=0;
                    }
                }
                else{
                    if(hand[i] - prev != 1) 
                        continue;
                    else{
                      prev = hand[i];
                      count++;
                      set.add(i); 
                    }
                    if(count ==  groupSize){
                        count = 0;
                        i=0;
                    }
                }
            }
        }
        return count == 0 && set.size()==hand.length;
    }
	
	

}
