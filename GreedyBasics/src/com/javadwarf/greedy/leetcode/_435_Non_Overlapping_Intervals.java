package com.javadwarf.greedy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _435_Non_Overlapping_Intervals {
	
	public static void main(String[] args) {
		int[][] intervals = {{1,2},{2,3}};
		System.out.println(eraseOverlapIntervals(intervals));
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		
		if(intervals == null || intervals.length ==0) return 0;

		int count = 0 ;
		
		Interval[] iv = new Interval[intervals.length];
		
		List<Interval> l1 = new ArrayList<>();
		List<Interval> l2 = new ArrayList<>();

		for(int i = 0 ; i<intervals.length; i++) {
			iv[i] = new Interval(intervals[i][0], intervals[i][1]);
		}
		
		Arrays.sort(iv, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o2.start, o1.start);
			}
		});
		
		Interval curr = iv[0];
		
		for(int i = 1;i <iv.length; i++) {
			Interval temp = iv[i];
			if(temp.finish <= curr.start) {
				l1.add(curr);
				curr = temp;
			}
			else {
				l2.add(temp);
				count++;
			}
		}
		
		if(!l1.contains(curr) && !l2.contains(curr)) {
			l1.add(curr);
		}
		
		
		System.out.println(l1);
		System.out.println(l2);

		return count;

	}

}

class Interval {
	int start, finish;

	public Interval(int start, int finish) {
		super();
		this.start = start;
		this.finish = finish;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finish;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (finish != other.finish)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return start + "," + finish;
	}
	
	
	
	


}
