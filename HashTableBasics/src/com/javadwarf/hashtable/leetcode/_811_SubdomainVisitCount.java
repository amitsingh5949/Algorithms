package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _811_SubdomainVisitCount {

	public static void main(String[] args) {
		
		String[] arr = {"9001 discuss.leetcode.com"};
		System.out.println(new _811_SubdomainVisitCount().subdomainVisits(arr));

	}

	public List<String> subdomainVisits(String[] cpdomains) {
		
		List<String> res = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<>();
		
		for(String domain : cpdomains) {
			
			String[] arr = domain.split(" ");
			int count = Integer.parseInt(arr[0]);
			String[] domainArr = arr[1].split("\\.");
			
			for(int i=0; i<domainArr.length; i++) {
				
				String domainName = "";
				
				for(int j=i; j<domainArr.length; j++) {
					if(j==i) {
						domainName += domainArr[j];
					}
					else {
						domainName += "."+domainArr[j];
					}
				}
				
				int countCurr = map.getOrDefault(domainName, 0);
				map.put(domainName, count+countCurr);
			}
		}
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> itr = set.iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, Integer> e = itr.next();
			res.add(e.getValue() + " " + e.getKey());
		}
		
		return res;
	}
}
