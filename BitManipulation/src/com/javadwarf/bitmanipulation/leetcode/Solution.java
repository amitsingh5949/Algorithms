package com.javadwarf.bitmanipulation.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Solution {


	public static void main(String[] args) {
		Object obj = initialise(); 
		String company = helper(obj);
		System.out.println(company);

	}

	private static String helper(Object obj) {
		
		LinkedHashMap data = (LinkedHashMap) obj;
		data = (LinkedHashMap)data.get("Data");
		ArrayList companies = (ArrayList)data.get("companies");
		
		for(int i =0 ; i<companies.size(); i++) {
			LinkedHashMap company = (LinkedHashMap) companies.get(i);
			LinkedHashMap stat = (LinkedHashMap)company.get("stat");
			if(!stat.containsKey("open")) {
				return company.get("name").toString();
			}
		}
		return "";

	}

	private static LinkedHashMap initialise() {

		LinkedHashMap data = new LinkedHashMap<>();
		LinkedHashMap companies = new LinkedHashMap<>();
		ArrayList comp = new ArrayList();

		LinkedHashMap company1 =  new LinkedHashMap();
		company1.put("name", "google");
		LinkedHashMap stat1 =  new LinkedHashMap();
		stat1.put("high", 12.2);
		stat1.put("low", 12.2);
		stat1.put("open", 45.33);
		stat1.put("close", 45.33);
		company1.put("stat", stat1);

		LinkedHashMap company2 =  new LinkedHashMap();
		company2.put("name", "apple");
		LinkedHashMap stat2 =  new LinkedHashMap();
		stat2.put("high", 12.2);
		stat2.put("low", 12.2);
		stat2.put("close", 45.33);
		company2.put("stat", stat2);

		comp.add(company1);
		comp.add(company2);
		companies.put("companies", comp);
		data.put("Data", companies);

		return data;

	}
}
