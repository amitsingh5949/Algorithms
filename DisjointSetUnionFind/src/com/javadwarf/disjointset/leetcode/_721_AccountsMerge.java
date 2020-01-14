package com.javadwarf.disjointset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _721_AccountsMerge {

	public static void main(String[] args) {
		String[][] arr = {{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}};
		
		List<List<String>> ip = new ArrayList<List<String>>();
		
		for(String[] temp : arr ) {
			ip.add(Arrays.asList(temp));
		}
		
		System.out.println(new _721_AccountsMerge().accountsMerge(ip));
		

	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> res = new ArrayList<List<String>>();

		int count  = 0;

		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, List<String>> map2 = new HashMap<>();

		for(List<String> account : accounts) {

			Integer id = null;

			for(int i=1; i<account.size(); i++) {
				if(map1.containsKey(account.get(i))){
					id = map1.get(account.get(i));
					break;
				}
			}

			if(id != null) {
				List<String> mergedList = map2.get(id);
				for(int i=1; i<account.size(); i++) {
					if(!mergedList.contains(account.get(i))) {
						mergedList.add(account.get(i));
					}
					map1.put(account.get(i), id);
				}
			}
			else {
				List<String> tobeAdded = new ArrayList<>();
				tobeAdded.add(account.get(0));
				map2.put(count, tobeAdded);
				for(int i=1; i<account.size(); i++) {
					map1.put(account.get(i), count);
					if(!tobeAdded.contains(account.get(i))) {
						tobeAdded.add(account.get(i));
					}
				}
				count++;
			}
		}

		for(List<String> value : map2.values()) {
			Collections.sort(value.subList(1, value.size()));
			res.add(value);
		}
		return res;
	}

}
