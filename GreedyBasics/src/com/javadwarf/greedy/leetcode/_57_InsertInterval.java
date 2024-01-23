package com.javadwarf.greedy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> l = new ArrayList<>();
		boolean intervalAdded = false;

		for( int i=0; i<intervals.length; i++){
			if(newInterval[0] <= intervals[i][0]){// index at which new interval can be inserted ( insertable index can also be found by binary search logic)
				addInterval(l, newInterval);
				intervalAdded = true;
			}
			addInterval(l, intervals[i]);
		}

		if(!intervalAdded) addInterval(l, newInterval);

		return l.toArray(new int[l.size()][2]);    
	}

	// typical logic to merge last interval in list with new interval
	public void addInterval(List<int[]> l ,int[] newInterval){
		if(l.isEmpty() || l.get(l.size()-1)[1] < newInterval[0]){
			l.add(newInterval);
		}
		else{
			l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1], newInterval[1]);
		}
	}

}
