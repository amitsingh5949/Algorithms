package com.javaDwarf.dataStructure.graphs.shortestpath;

public class DistanceInfo {
	
	int distance = -1;
	int lastVertex = -1;
	
	public DistanceInfo() {
		super();
	}
	
	public DistanceInfo(int distance, int lastVertex) {
		super();
		this.distance = distance;
		this.lastVertex = lastVertex;
	}
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getLastVertex() {
		return lastVertex;
	}
	public void setLastVertex(int lastVertex) {
		this.lastVertex = lastVertex;
	}

	@Override
	public String toString() {
		return "DistanceInfo [distance=" + distance + ", lastVertex=" + lastVertex + "]";
	}
	
	

}
