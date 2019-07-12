package com.javaDwarf.graphs.gfg.dfs;

import java.util.LinkedList;

public class DFSGraph {

	static Graph graph = new Graph(5);
	public static void main(String[] args) {
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(4, 3);
		
		graph.printGraph();
		dfs(0, 4);
		
		//If there are more that one cluster in graph i.e. all vertices are not connected to each other
				/*for(int i=0;i<=4;i++){
					dfs(i,4);
				}*/
	}
	
	public static void dfs(int currentVertex, int key){
		boolean[] vistedVertex = new boolean[graph.numOfVertecies];
		dfs(currentVertex,key,vistedVertex);
	}
	
	public static void dfs(int currentVertex, int key, boolean[] vistedVertex){
		System.out.println(currentVertex);
		if(currentVertex == key){
			System.out.println("Found");
		}
		vistedVertex[currentVertex] = true;
		LinkedList<Integer> currentNeighbhourList = graph.vertextList[currentVertex];
		for(Integer temp : currentNeighbhourList ){
			if(!vistedVertex[temp])
				dfs(temp,key,vistedVertex);
		}
	}
	
	

}
