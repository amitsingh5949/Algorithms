package com.javadwarf.disjointset.leetcode;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		//int[][] matrix  = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		//int[][] matrix  = {{0,1},{0,2},{1,2}};
		int[][] matrix  = {{0,1},{1,0}};
		System.out.println(canFinish(2, matrix));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		DisjointSet ds = new DisjointSet();
		for(int i=0; i<numCourses; i++) {
			ds.makeSet(i);
		}
		for(int i=0; i<prerequisites.length; i++) {
			boolean val = ds.union(prerequisites[i][0], prerequisites[i][1]);
			if(!val) return val;
		}
		return true;
	}
}
