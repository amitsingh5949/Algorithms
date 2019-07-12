package com.javaDwarf.graphs.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class _787_CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		int[][] flights = {
				{0,1,100},
				{1,2,100},
				{0,2,500}
		};
		//System.out.println(new _787_CheapestFlightsWithinKStops().findCheapestPrice(3, flights, 0, 2, 0));
		
		int[][] flights1 = {
				{0,1,1},
				{0,2,5},
				{1,2,1},
				{2,3,1}
		};
		System.out.println(new _787_CheapestFlightsWithinKStops().findCheapestPrice(4, flights1, 0, 3, 1));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Graph graph = new Graph(n);
		graph.addEdgesAndWeights(flights);

		Map<Integer, DistanceInfo> map = new HashMap<>();

		for(int i = 0; i<n; i++) {
			if(i==src) {
				map.put(src, new DistanceInfo(src,0,-1,-1));
			}
			else {
				map.put(i, new DistanceInfo(i, Integer.MAX_VALUE, -1,-1));
			}
		}

		Set<Integer> visited = new HashSet<>();
		Queue<DistanceInfo> q = new PriorityQueue<DistanceInfo>();
		q.add(map.get(src));
		visited.add(src);

		while(!q.isEmpty()) {
			DistanceInfo df = q.poll();

			LinkedList<Integer> neighbours = graph.g[df.node];

			for(Integer neighbour : neighbours) {
				DistanceInfo dfNeighbour  = map.get(neighbour);
				if(visited.contains(neighbour)) {
					if(dfNeighbour.distance > df.distance + graph.weightMatrix[df.node][neighbour] && df.numOfStops < K) {
						dfNeighbour.distance = df.distance + graph.weightMatrix[df.node][neighbour];
						dfNeighbour.lastNode = df.node;
						dfNeighbour.numOfStops = df.numOfStops + 1;
					}
				}
				else {
					dfNeighbour.distance = df.distance + graph.weightMatrix[df.node][neighbour];
					dfNeighbour.lastNode = df.node;
					dfNeighbour.numOfStops = df.numOfStops + 1;
					q.add(dfNeighbour);
					visited.add(neighbour);

				}
			}
		}
		return (map.get(dst).distance!=Integer.MAX_VALUE)?map.get(dst).distance:-1;
	}

	class Graph{
		int numOfNodes = 0 ;
		LinkedList<Integer>[] g = null;
		int[][] weightMatrix = null;

		public Graph(int numOfNodes) {
			this.numOfNodes = numOfNodes;
			g = new LinkedList[numOfNodes];
			for(int i = 0 ; i<numOfNodes; i++) {
				g[i] = new LinkedList<Integer>();
			}
			weightMatrix = new int[numOfNodes][numOfNodes];
		}

		public void addEdgesAndWeights(int[][] flights) {
			for(int i=0; i<flights.length; i++) {
				for(int j=0; j<flights[i].length; j++) {
					g[flights[i][0]].addLast(flights[i][1]);
					weightMatrix[flights[i][0]][flights[i][1]] = flights[i][2];
				}
			}

		}
	}

	class DistanceInfo  implements Comparable<DistanceInfo> {
		int node, distance, lastNode, numOfStops;
		public DistanceInfo(int node, int distance, int lastNode, int numOfStops) {
			this.node = node;
			this.distance = distance;
			this.lastNode = lastNode;
			this.numOfStops = numOfStops;
		}
		@Override
		public int compareTo(DistanceInfo o) {
			return Integer.compare(this.distance, o.distance);
		}
		@Override
		public String toString() {
			return "("+ node + "," + distance + ")";
		}
	}

}
