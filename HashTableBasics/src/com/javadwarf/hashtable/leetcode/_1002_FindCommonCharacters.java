package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1002_FindCommonCharacters {

	public static void main(String[] args) {

	}

	public List<String> commonChars(String[] A) {
		
		List<String> l = new ArrayList<>();
		if(A==null || A.length == 0) return l;
		
		Map<String, Integer> m1 = new HashMap<>();
		for(char c : A[0].toCharArray()) {
			String ch  = Character.valueOf(c).toString();
			int count = m1.getOrDefault(ch, 0);
			m1.put(ch, count+1);
		}
		Map<String, Integer> m2 = new HashMap<>();
		
		for(int i=1; i<A.length; i++) {
			
			for(int j=0; j<A[i].length(); j++) {
				String ch  = Character.valueOf(A[i].charAt(j)).toString();
				if(m1.containsKey(ch)){
					int count = m2.getOrDefault(ch, 0);
					if(count < m1.get(ch)) {
						m2.put(ch, count+1);
					}
				}
			}
			
			Map<String, Integer> temp = null;
			m1.clear();
			temp = m1;
			m1 = m2;
			m2 = temp;
		}
		
		Set<Map.Entry<String , Integer>> s = m1.entrySet();
		Iterator<Map.Entry<String , Integer>> itr = s.iterator();
		while(itr.hasNext()) {
			Map.Entry<String , Integer> e = itr.next();
			for(int i=0; i<e.getValue(); i++) {
				l.add(e.getKey());
			}
		}
		
		return l;
		

	}

}
