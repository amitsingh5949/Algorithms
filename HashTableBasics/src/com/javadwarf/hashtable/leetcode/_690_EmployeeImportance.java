package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _690_EmployeeImportance {

	public static void main(String[] args) {

	}

	public int getImportance(List<Employee> employees, int id) {
		
		Map<Integer, Employee> map = new HashMap<>();
		for(Employee employee : employees) {
			map.put(employee.id, employee);
		}
		
		return dfs(id,0,map);

	}
	
	public int dfs(int id, int importance, Map<Integer, Employee> map) {
		
		importance = map.get(id).importance;
		
		for(int subordinate : map.get(id).subordinates) {
			importance += dfs(subordinate,importance,map);
		}
		
		return importance;
		
	}
	/*
	 * use of global variable
	 * 
	 * public int importance = 0;
	public int getImportance(List<Employee> employees, int id) {
		importance = 0;
		Map<Integer, Employee> map = new HashMap<>();
		for(Employee employee : employees) {
			map.put(employee.id, employee);
		}
		dfs(id,map);
		return importance;
	}

	public void dfs(int id, Map<Integer, Employee> map) {
		importance += map.get(id).importance;

		for(int subordinate : map.get(id).subordinates) {
			dfs(subordinate,map);
		}
	}
	 */
	
	
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	}

}
