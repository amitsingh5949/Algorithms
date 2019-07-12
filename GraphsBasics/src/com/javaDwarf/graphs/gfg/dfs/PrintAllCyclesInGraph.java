package com.javaDwarf.graphs.gfg.dfs;

import java.util.LinkedList;

public class PrintAllCyclesInGraph {

	static Graph g = new Graph(5);
	public static void main(String[] args) {

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 2);

		g.printGraph();
		System.out.println();
		printCyclesInGraph();
	}

	private static void printCyclesInGraph() {
		for(int i=0; i<g.numOfVertecies; i++){
			cycleWithCurrentNode(i);
		}
	}

	private static void cycleWithCurrentNode(int currentVertex){
		boolean[] vistedVertex = new boolean[g.numOfVertecies];
		LinkedList<Integer> ll = new LinkedList<>();
		dfs(currentVertex,vistedVertex,ll);
	}

	private static void dfs(int currentVertex, boolean[] vistedVertex,LinkedList<Integer> ll){
		ll.addLast(currentVertex);
		if(ll.getFirst() == currentVertex && ll.size() > 1){
			printCycle(ll);
			if(ll.size() > 2){
				vistedVertex[currentVertex]=false;
			}
		}
		LinkedList<Integer> currentNeighbhourList = g.vertextList[currentVertex];
		for(Integer temp : currentNeighbhourList ){
			if(!vistedVertex[temp]){
				vistedVertex[temp]=true;
				dfs(temp,vistedVertex,ll);
				ll.removeLast();
			}
		}
	}

	private static void printCycle(LinkedList<Integer> ll) {
		ll.parallelStream().forEach(e -> System.out.print(e +" "));
		System.out.println();
	}



}
