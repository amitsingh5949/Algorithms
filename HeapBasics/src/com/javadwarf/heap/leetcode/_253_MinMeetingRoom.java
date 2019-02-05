package com.javadwarf.heap.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * Question:
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), find the minimum number of conference rooms required.
	Example 1:
	Input: [[0, 30],[5, 10],[15, 20]]
	Output: 2
	Example 2:
	Input: [[7,10],[2,4]]
	Output: 1
 */
public class _253_MinMeetingRoom {

	public static void main(String[] args) {
		System.out.println(new _253_MinMeetingRoom().minMeetingRooms(new Interval[] {
				new Interval(2,15),
				new Interval(36,45),
				new Interval(9,29),
				new Interval(16,23),
				new Interval(4,9)
		}));

		System.out.println(new _253_MinMeetingRoom().minMeetingRooms(new Interval[] {
				new Interval(15,16),
				new Interval(10,15),
				new Interval(16,25)
		}));


	}
/*
 * Sort array interval by start time,
 * maintain heap of interval  based on end time,
 * if next meeting start time < top of heap that mean some previously started meeting is over, we can use that room
 */
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length==0) 
			return 0;

		Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

		int rooms = 1;
		Interval curr = intervals[0];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(curr.end);

		for(int i=1; i<intervals.length; i++) {
			curr = intervals[i];
			if(!pq.isEmpty() && curr.start >= pq.peek()) {
				pq.poll();
			}
			else {
				rooms++;
			}
			pq.add(curr.end);
		}
		// not pq.size() == rooms , so instead of using rooms an extra variable , i can directly return pq.size() as my answer 
		return rooms;
	}

	/**
	 * Not similar to activity selection - wrong solution below
	 * */
	public int minMeetingRooms2(Interval[] intervals) {
		if(intervals == null || intervals.length==0) 
			return 0;

		int result = 0;
		Arrays.sort(intervals, (a,b) -> Integer.compare(a.end, b.end));

		Interval curr = null;
		int elemenstsPolled = 0;

		while(elemenstsPolled != intervals.length) {
			for(int i =0; i<intervals.length; i++) {
				if(intervals[i] == null) {
					continue;
				}
				else if(curr == null || intervals[i].start>=curr.end) {
					curr = intervals[i];
					intervals[i] = null;
					elemenstsPolled++;
				}
			}
			result++;
			curr = null;
		}
		return result;
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
