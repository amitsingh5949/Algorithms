package com.javadwarf.greedy.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452_MinimumNumberofArrowstoBurstBalloons {

	public static void main(String[] args) {
		int[][] intervals = {{10,16}, {2,8}, {1,6}, {7,12}};
		int[][] intervals1 =  {{1,2},{2,3},{3,4},{4,5}};
		System.out.println(new _452_MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(intervals1));
	}

	public  int findMinArrowShots(int[][] intervals) {
		if(intervals == null || intervals.length ==0) return 0;

		int count = 0 ;
		
		Interval[] iv = new Interval[intervals.length];
		

		for(int i = 0 ; i<intervals.length; i++) {
			iv[i] = new Interval(intervals[i][0], intervals[i][1]);
		}
		
		Arrays.sort(iv, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.finish, o2.finish);
			}
		});
		
		Interval curr = iv[0];
		
		for(int i = 1;i <iv.length; i++) {
			Interval temp = iv[i];
			if(temp.start > curr.finish) {
				curr = temp;
				count++;
			}
		}
		return ++count;

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

}


