package com.javaDwarf.graphs.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1203_SortItemsbyGroupsRespectingDependencies {

	public static void main(String[] args) {

	}
// wrong logic below, need to form topological order of groups as well, so this question is two level topological ordering
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

		int[] res = new int[n];

		createGraph(n);

		int[] degree = new int[n];

		for(int i=0 ; i<beforeItems.size(); i++) {

			List<Integer> beforeItem = beforeItems.get(i);

			if(beforeItem.size()>0) {
				for(Integer curr : beforeItem) {
					addEdge(curr, i);
					degree[i] += 1;
				}
			}
		}
		
		Queue<Element> q = new PriorityQueue<>();
		for(int i=0 ; i<degree.length; i++) {
			if(degree[i] == 0) {
				q.add(new Element(i,group[i]==-1?Integer.MIN_VALUE:group[i]));
			}
		}
		
		int count = 0;
		while(!q.isEmpty()) {
			
			Element curr = q.poll();
			res[count++] = curr.item;
			
			ArrayList<Integer> neighbors = graph[curr.item];
			for(Integer neighbor : neighbors) {
				degree[neighbor] -= 1;
				if(degree[neighbor] == 0) {
					q.add(new Element(neighbor,group[neighbor]==-1?Integer.MIN_VALUE:group[neighbor]));
				}
			}
		}
		
		if(count != n) return new int[0];

		return res;
	}


	public static ArrayList<Integer>[] graph = null;
	public static int numOfVertices=0;
	public static void createGraph(int n){
		numOfVertices = n;
		graph = new ArrayList[n];
		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
	}
	public static void addEdge(int src, int dest) {
		graph[src].add(dest);
	}
	
	class Element implements Comparable<Element>{
		int item;
		int group;
		public Element(int item,int group) {
			super();
			this.group = group;
			this.item = item;
		}
		@Override
		public int compareTo(Element o) {
			return Integer.compare(this.group, o.group);
		}
	}

}
