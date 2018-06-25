package com.javaDwarf.dataStructure.graphs.dfs;

import java.util.LinkedList;

public class Graph {

	LinkedList<Integer>[] vertextList;
	int numOfVertecies;

	public Graph(int size) {
		vertextList = new LinkedList[size];
		numOfVertecies =size;
		for(int i=0; i<size; i++){
			vertextList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int neighbhour){
		vertextList[src].addFirst(neighbhour);
	}

	public void printGraph(){
		for(int i=0; i<vertextList.length; i++){
			System.out.print("Vertex " + i +" neighbhour -> " );
			for(Integer temp : vertextList[i]){
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}
}
