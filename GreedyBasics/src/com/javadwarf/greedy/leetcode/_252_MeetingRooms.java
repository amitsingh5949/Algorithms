package com.javadwarf.greedy.leetcode;

import java.util.Arrays;

public class _252_MeetingRooms {

	class Meeting implements Comparable<Meeting> {
		int s, f;
		public Meeting(int s, int f) {
			super();
			this.s = s;
			this.f = f;
		}
		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(this.f, o.f);
		}
	}

	public boolean canAttendMeetings(int[][] intervals) {

		Meeting[] arr =new Meeting[intervals.length];

		for(int i =0; i<intervals.length;i++ ) {
			arr[i] = new Meeting(intervals[i][0], intervals[i][1]);
		}

		Arrays.parallelSort(arr);
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i].f > arr[i+1].s) {
				return false;
			}
		}
		
		return true;
	}

}
