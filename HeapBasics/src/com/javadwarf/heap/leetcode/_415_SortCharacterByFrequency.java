package com.javadwarf.heap.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class _415_SortCharacterByFrequency {
	
	/*
	 * if we would have been given to just print the frequency of each letter, we would have taken 26 length array
	 *  and got the index by str.chatAt(i) -'a' and update the count in that array
	 */

	public String frequencySort(String s) {
        String result = "";
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++) {
        	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>(
        		(x, y) -> Integer.compare(y.getValue(), x.getValue()));
        
        /*Iterator<Map.Entry<Character, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()) {
        	maxHeap.add(itr.next());
        }
        */
        maxHeap.addAll(map.entrySet());
        
        while(!maxHeap.isEmpty()) {
        	Map.Entry<Character, Integer> entry = maxHeap.poll();
        	for(int i=0; i<entry.getValue(); i++) {
        		result += entry.getKey();
        	}
        }
        return result;
    }

}
