package com.javadwarf.greedy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _134_GasStation {
	
	//Start from each index and see if you can reach at the same index
	// Smart pruning : If you start from some index and you cannot reach to the same index then all the index visited are useless too, 
		//you cannot reach from those indexes too hence those indexes should be excluded.
	Set<Integer> exclude;
    int[] gas;
    int[] cost;
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        exclude = new HashSet<>();
        this.gas = gas;
        this.cost = cost;
        for( int i=0; i<gas.length; i++){
            if(!exclude.contains(i) && helper(i)) 
                return i;
        }
        return -1;
    }
    
    public boolean helper(int start){
        
        Set<Integer> temp = new HashSet<>();
        temp.add(start);
        
        int tank = gas[start] - cost[start];
        int curr = -1;
        if( tank >= 0){
            curr = start+1;
            curr = curr % (gas.length);
        }
        
        while(curr != -1 && curr != start){
            temp.add(curr);
            tank += gas[curr] - cost[curr];
            if( tank >= 0){
                curr += 1;
                curr = curr % (gas.length);
            }
            else{
                curr = -1;
            }
        }
        
        exclude.addAll(temp);
        return curr == start;
    }

}
