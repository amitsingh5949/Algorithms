package com.whatfix.robot;

import java.util.LinkedList;

public class Graph {

	private Vertex[] vertextArr;
	private int size;
	private int start;
	private int end;


	public Graph(int numVertices) {
		this.vertextArr =  new Vertex[numVertices];
		this.size=0;

	}

	public void insertVertices(String vertexName){ 
		Vertex v  =  new Vertex(vertexName, null);
		v.setAdjList(this.setNeighbhourList(vertexName));
		vertextArr[size++] = v;
	}

	public Neighbhor setNeighbhourList(String vertexName){

		int[] neighbhorArr = Main.getNeighbhours().get(Integer.valueOf(vertexName));
		Neighbhor first = null;
		Neighbhor parent = null;
		Neighbhor current = null;
		for(int i= 0; i<neighbhorArr.length; i++){
			if(first == null){
				first = new Neighbhor(neighbhorArr[i], null);
				parent =first;
				current= first;
			}
			else{
				current = new Neighbhor(neighbhorArr[i], null);
				parent.setNext(current);
				parent = current;
			}
		}
		return first;
	}

	public void dfs(int start, int end){
		this.setStart(start);
		this.setEnd(end);
		LinkedList<Integer> visited = new LinkedList<Integer>();
		visited.add(Integer.valueOf(start));
		this.dfs(visited);
	}

	private void dfs(LinkedList<Integer> visited){
		Neighbhor node = this.getVertextArr()[visited.getLast().intValue()].getAdjList();
		Neighbhor current = node;
		while(current!=null){
			if(visited.contains(Integer.valueOf(end))){
				this.printPath(visited);
				return;
			}
			if(visited.contains(Integer.valueOf(current.getVertexIndex())) || visited.contains(Integer.valueOf(end))){
				current =current.getNext();
				continue;
			}
			visited.add(current.getVertexIndex());
			dfs(visited);
			visited.removeLast();
			current =current.getNext();
		}
	}

	private void printPath(LinkedList<Integer> visited){
		for (Integer node : visited) {
			System.out.print(node+" ");
		}
		System.out.println();

	}

	public void printGraph(){

		for(int i = 0; i < vertextArr.length; i++){
			System.out.print(vertextArr[i].getVertexName());
			Neighbhor adjList = vertextArr[i].getAdjList();

			while(adjList != null ){
				System.out.print(" - " + adjList.getVertexIndex() );
				adjList = adjList.getNext();
			}
			System.out.println();
		}
	}

	public Vertex[] getVertextArr() {
		return vertextArr;
	}

	public void setVertextArr(Vertex[] vertextArr) {
		this.vertextArr = vertextArr;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}






}
