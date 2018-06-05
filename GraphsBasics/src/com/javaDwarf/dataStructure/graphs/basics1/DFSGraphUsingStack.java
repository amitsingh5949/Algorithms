package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.LinkedList;
import java.util.Stack;

public class DFSGraphUsingStack {
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

		//graph.printGraph();
		dfs(0, 2);
		
		//If there are more that one cluster in graph i.e. all vertices are not connected to each other
				/*for(int i=0;i<=4;i++){
					dfs(i,4);
				}*/
	}

	public static void dfs(int currentVertex, int key){
		boolean[] vistedVertex = new boolean[graph.numOfVertecies];
		Stack<Integer> s = new Stack<>();
		s.push(currentVertex);

		while(!s.isEmpty()){
			Integer temp = s.pop();
			if(!vistedVertex[temp]){
				System.out.println(temp);
				vistedVertex[temp] = true;
				if(temp==key){
					System.out.println("Key Found");
				}
				LinkedList<Integer> currentNeighbhourList = graph.vertextList[temp];
				for(Integer temp1 : currentNeighbhourList ){
					if(!vistedVertex[temp1])
						s.add(temp1);
				}

			}
		}
	}
}
