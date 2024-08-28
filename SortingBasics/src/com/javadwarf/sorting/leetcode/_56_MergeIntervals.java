package com.javadwarf.sorting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class _56_MergeIntervals {

	public static void main(String[] args) {
		//new _56_MergeIntervals().merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
		new _56_MergeIntervals().merge(new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}});

	}

	
	public int[][] merge1(int[][] intervals) {

		Arrays.sort(intervals, (a,b) -> {
			if(a[0]-b[0] == 0) return a[1]-b[1];
			return a[0]-b[0];
		});

		List<int[]> l = new ArrayList<>();
		l.add(intervals[0]);
		for(int i=1; i<intervals.length; i++){
			if(l.get(l.size()-1)[1] >= intervals[i][0]) l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1], intervals[i][1] );
			else l.add(intervals[i]);
		}

		return l.toArray(new int[l.size()][2]);
	}

	public int[][] merge2(int[][] intervals) {

		Arrays.sort(intervals,(a,b) -> a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]);

		int len = intervals.length;
		for( int i =1; i<intervals.length; i++){
			if(intervals[i-1][1] >= intervals[i][0] ){
				intervals[i][0] = intervals[i-1][0];
				intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);
				intervals[i-1] = null;
				len--;
			}
		}

		int[][] res = new int[len][2];
		int j = 0;
		for( int i =0; i<intervals.length; i++){
			if(intervals[i] != null){
				res[j++] = intervals[i];
			}
		}
		return res;
	}

	//most optimized - OG solution 
	public int[][] merge3(int[][] intervals) {

		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]) == 0 ?
				Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));

		int merged = 0;

		for( int i=1; i<intervals.length; i++){
			if(intervals[merged][1] >= intervals[i][0]){//case of overlapping
				intervals[merged][1] = Math.max(intervals[merged][1], intervals[i][1]);
			}
			else{//non-overlapping case
				intervals[++merged] = intervals[i];           
			}
		}
		return Arrays.copyOfRange(intervals, 0, merged+1);
	}

	///Too -long --old code

	public int[][] merge(int[][] intervals) {

		if(intervals == null || intervals.length == 0) return new int[0][0];

		List<Pos> arr = new ArrayList<>();

		for(int i=0; i<intervals.length; i++) {
			arr.add(new Pos(intervals[i][0], intervals[i][1]));
		}

		Collections.sort(arr, (a,b) -> Integer.compare(a.start,b.start));

		List<Pos> arr1 = new ArrayList<>();

		int start = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE;

		for(Pos p : arr) {
			if(start == Integer.MIN_VALUE && end == Integer.MIN_VALUE) {
				start = p.start;
				end = p.end;
			}
			else{
				if(p.start <= end) {
					if(end <= p.end) {
						end = p.end;
					}
				}
				else {
					arr1.add(new Pos(start, end));
					start = p.start;
					end = p.end;
				}
			}
		}
		arr1.add(new Pos(start, end));

		int[][] result = new int[arr1.size()][2];
		for(int i=0; i<arr1.size(); i++) {
			result[i][0] = arr1.get(i).start;
			result[i][1] = arr1.get(i).end;
		}

		return result;


	}

	class Pos{
		int start=0, end = 0;

		public Pos(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}


	}

}
