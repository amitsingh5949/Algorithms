package com.javaDwarf.graphs.adjacencyLinkedList;

public class Neighbhor {
	
	private int vertexIndex;
	private Neighbhor next;
	
	public Neighbhor(int vertexIndex, Neighbhor next) {
		super();
		this.vertexIndex = vertexIndex;
		this.next = next;
	}

	public int getVertexIndex() {
		return vertexIndex;
	}

	public void setVertexIndex(int vertexIndex) {
		this.vertexIndex = vertexIndex;
	}

	public Neighbhor getNext() {
		return next;
	}

	public void setNext(Neighbhor next) {
		this.next = next;
	}
	
	
}
