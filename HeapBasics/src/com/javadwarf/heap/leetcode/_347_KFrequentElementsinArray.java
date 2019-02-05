package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _347_KFrequentElementsinArray {
	
	public static void main(String[] args) {

		System.out.println(new _347_KFrequentElementsinArray().topKFrequent(new int[] {1,1,12,2,2,2,4},2));
	}

  public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(nums==null || nums.length==0)
        	return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
           if(map.containsKey(i)) {
        	 map.put(i , map.get(i) + 1);  
           }
           else {
        	   map.put(i, 1);
           }
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> itr = set.iterator();
        while(itr.hasNext()) {
        	pq.add(itr.next());
        }
        
        for(int i=0; i<k; i++) {
        	result.add(pq.poll().getKey());
        }
        return result;
    }
}
