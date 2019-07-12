package com.javaDwarf.graphs.gfg.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PrimsAlgorithm {
	/*input 
	    2
		3 3
		1 2 5 2 3 3 1 3 1
		2 1
		1 2 5
	 */

	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int e = Integer.parseInt(inputLine[1]);
			Graph graph = new Graph(n);
			inputLine = br.readLine().trim().split(" ");
			for(int i=0; i<(3*e); i=i+3){
				graph.addEdge(Integer.parseInt(inputLine[i]), Integer.parseInt(inputLine[i+1]), Integer.parseInt(inputLine[i+2]));
			}
			PrimsAlgorithm pa = new PrimsAlgorithm();
			System.out.println(pa.spanningTree(graph, n));
		}
	}

	public int spanningTree(Graph g, int n){
		int length = 0 ;

		int start = 1;
		Map<Integer, DistanceInfo> map = new HashMap<>();

		for(int i=1; i<=n; i++) {
			if(i==start) {
				map.put(i, new DistanceInfo(i, 0, i));
			}
			else {
				map.put(i, new DistanceInfo(i, Integer.MAX_VALUE, -1));
			}
		}

		Set<Integer> spanningTree = new HashSet<>();
		Set<Integer> visited = new HashSet<>();

		Queue<DistanceInfo> q = new PriorityQueue<>();
		q.add(map.get(start));
		visited.add(start);

		while(!q.isEmpty()) {

			DistanceInfo df = q.poll();
			spanningTree.add(df.node);

			int parentNode = df.node;

			LinkedList<Pair> neighbours = g.lst[parentNode];

			for(Pair neighbour : neighbours) {
				if(!spanningTree.contains(neighbour.x)) {
					if(visited.contains(neighbour.x)) {
						if( map.get(neighbour.x).distance > neighbour.y) {
							map.get(neighbour.x).distance = neighbour.y;
							map.get(neighbour.x).lastNode = parentNode;
						}
					}
					else {
						map.get(neighbour.x).distance = neighbour.y;
						map.get(neighbour.x).lastNode = parentNode;
						q.add(map.get(neighbour.x));
						visited.add(neighbour.x);
					}
				}
			}

		}

		Set<Map.Entry<Integer, DistanceInfo>> set = map.entrySet();
		Iterator<Map.Entry<Integer, DistanceInfo>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, DistanceInfo> entry = itr.next();
			if(entry.getValue().distance != Integer.MAX_VALUE){
				length += entry.getValue().distance;
			}
		}
		return length;
	}
	
}


class Graph {
	int V;
	LinkedList<Pair> lst[];
	
	public Graph(int v){
		this.V = v+1;
		lst = new LinkedList[V];
		for(int i=0; i<V; i++) {
			lst[i] = new LinkedList<>(); 
		}
	}

	void addEdge(int s, int d, int w){
		lst[s].add(new Pair(d, w));
		lst[d].add(new Pair(s, w));
	}

}

class Pair {
	int x;// vertex
	int y;// weight
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "v:" + x + ",w:" + y;
	}
}

class DistanceInfo implements Comparable<DistanceInfo>{
	int node;
	int distance;
	int lastNode;

	public DistanceInfo(int node, int distance, int lastNode) {
		super();
		this.node = node;
		this.distance = distance;
		this.lastNode = lastNode;
	}

	@Override
	public int compareTo(DistanceInfo o) {
		return Integer.compare(distance, o.distance);
	}

	@Override
	public String toString() {
		return "(" + node + "," + distance + "," + lastNode + ")";
	}


}
