package com.javaDwarf.dataStructure.adjacencyLinkedList;

public class Vertex {

	private String vertexName;
	private Neighbhor adjList;
	
	public Vertex(String vertexName, Neighbhor adjList) {
		super();
		this.vertexName = vertexName;
		this.adjList = adjList;
	}
	
	public String getVertexName() {
		return vertexName;
	}
	public void setVertexName(String vertexName) {
		this.vertexName = vertexName;
	}
	public Neighbhor getAdjList() {
		return adjList;
	}
	public void setAdjList(Neighbhor adjList) {
		this.adjList = adjList;
	}
	
	
	
}
