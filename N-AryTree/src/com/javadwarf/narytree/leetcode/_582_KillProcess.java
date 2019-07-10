package com.javadwarf.narytree.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _582_KillProcess {

	public static void main(String[] args) {

	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int i = 0 ; i<ppid.size(); i++) {
			int parentID = ppid.get(i);
			if(!map.containsKey(parentID)) {
				map.put(parentID, new ArrayList<>());
			}
			map.get(parentID).add(pid.get(i));
		}
		return dfs(kill, 0, map, new ArrayList<>(),false);
	}

	public List<Integer> dfs(int kill, int currId, Map<Integer, List<Integer>> map, List<Integer> l, boolean found ) {

		if(found || kill == currId) {
			l.add(currId);
			found = true;
		}
		if(map.containsKey(currId)) {
			for(int child : map.get(currId)) {
				l = dfs(kill, child, map, l, found);
			}
		}
		return l;
	}
}
