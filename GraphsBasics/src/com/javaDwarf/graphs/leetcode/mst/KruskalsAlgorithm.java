package com.javaDwarf.graphs.leetcode.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class KruskalsAlgorithm {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graph =  new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> e1 = new ArrayList<Integer>();
		e1.add(1);
		e1.add(2);
		e1.add(5);
		graph.add(e1);

		ArrayList<Integer> e2 = new ArrayList<Integer>();
		e2.add(2);
		e2.add(3);
		e2.add(3);
		graph.add(e2);

		ArrayList<Integer> e3 = new ArrayList<Integer>();
		e3.add(1);
		e3.add(3);
		e3.add(1);
		graph.add(e3);
		
		int x = KruskalsAlgorithm.spanningTree(3, 3, graph);
		System.out.println(x);

	} 

	
	// Implementation of Krushkal's Algorithm
	static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph){

		int sum = 0;
		DisjointSet ds = new DisjointSet();// create Disjoint set

		for(int i=1; i<=V; i++) {
			ds.makeSet(i); // make independent set of all vertices
		}

		Collections.sort(graph, (a,b) -> Integer.compare(a.get(2), b.get(2))); // sort the edges in ascending order of weight

		for(ArrayList<Integer> edge : graph) { //iterate over all edges and union the src and dest of that edge
			if(ds.union(edge.get(0), edge.get(1))) {
				sum += edge.get(2);
			}
		}
		return sum;
	}
}



class DisjointSet {

	public Map<Integer, Node> map = new HashMap<>();

	class Node{
		Node parent;
		int data;
		int rank;
		public Node(int data) {
			this.data = data;
			this.parent = this;
			this.rank = 0;
		}
	}

	public void makeSet(int data) {
		Node node = new Node(data);
		map.put(data, node);
	}


	public boolean union(int data1, int data2) {

		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parentNode1 = map.get(find(data1));
		Node parentNode2 = map.get(find(data2));

		if(node1 == null || node2 == null || data1 == data2 || node1.parent.data == node2.parent.data) 
			return false;

		if(parentNode1.rank > parentNode2.rank){
			parentNode2.parent = parentNode1;
		}
		else if (parentNode1.rank < parentNode2.rank) {
			parentNode1.parent = parentNode2;
		}
		else {
			parentNode1.rank += 1;
			parentNode2.parent = parentNode1;
		}
		return true;
	}

	public int find(int data) {

		Node currNode = map.get(data);
		Node parent = currNode.parent;

		if(currNode != parent){
			int rootParent = find(parent.data);
			currNode.parent = map.get(rootParent);
		}
		return currNode.parent.data;
	}
}
