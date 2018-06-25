package com.javaDwarf.dataStructure.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;


public class BFSGraph {

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
		
		bfs(0, 4);
	
		//If there are more that one cluster in graph i.e. all vertices are not connected to each other
		/*for(int i=0;i<=4;i++){
			bfs(i,4);
		}*/
		
	}
	
	public static void bfs(int currentVertex, int key){
		
		boolean[] vistedVertex = new boolean[graph.numOfVertecies];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(currentVertex);

		vistedVertex[currentVertex] = true;

		LinkedList<Integer> currentNeighbhourList = null;
		while(!queue.isEmpty()){
			Integer i = queue.poll();
			System.out.print(i +" ");
			currentNeighbhourList = graph.vertextList[i];
			for(Integer temp : currentNeighbhourList ){
				if(!vistedVertex[temp]){
					vistedVertex[temp] = true;
					queue.add(temp);
					if(temp == key){
						System.out.print("Found ");
					}
				}
			}

		}
	}
	
	

}
