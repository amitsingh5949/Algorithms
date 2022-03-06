package com.javadwarf.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("10000000".compareTo("2000"));
			
			TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
			map.put("1","2");
			map.put("2","1");
			
			Set<Entry<String, String>> set = map.entrySet();
			Iterator<Entry<String, String>> itr = set.iterator();
			
			while(itr.hasNext()) {
				Entry<String, String> e = itr.next();
				map.remove(e.getKey());
			}
			
			System.out.println(map);
			
	}

}
