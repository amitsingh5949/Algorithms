package com.javaDwarf.dataStructure.graphs;

import java.util.List;

public class Vertex {

	private int vertextIndex;
	private String vertexName;
	private List<Vertex> neighbhourList;
	
	
	public int getVertextIndex() {
		return vertextIndex;
	}
	public void setVertextIndex(int vertextIndex) {
		this.vertextIndex = vertextIndex;
	}
	public String getVertexName() {
		return vertexName;
	}
	public void setVertexName(String vertexName) {
		this.vertexName = vertexName;
	}
	public List<Vertex> getNeighbhourList() {
		return neighbhourList;
	}
	public void setNeighbhourList(List<Vertex> neighbhourList) {
		this.neighbhourList = neighbhourList;
	}
	
	
	
	
	
}
