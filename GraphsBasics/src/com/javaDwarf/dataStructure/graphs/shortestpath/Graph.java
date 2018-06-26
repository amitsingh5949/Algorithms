package com.javaDwarf.dataStructure.graphs.shortestpath;

import java.util.LinkedList;

public class Graph {

	int numOfVerticies;
	LinkedList<Integer>[] vertextList ;

	public Graph(int numOfVerticies) {
		this.numOfVerticies =  numOfVerticies;
		vertextList = new LinkedList[numOfVerticies];
		for(int i=0; i<numOfVerticies; i++) {
			vertextList[i] = new LinkedList<>();
		}
	}

	public void addEdge(Integer src, Integer dest) {
		vertextList[src].addFirst(dest);
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
