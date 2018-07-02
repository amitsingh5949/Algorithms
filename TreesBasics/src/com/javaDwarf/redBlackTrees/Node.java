package com.javaDwarf.redBlackTrees;

public class Node {
	
	private Employee employee;
	private Node parent;
	private Node leftChild;
	private Node rightChild;
	
	public Node(Employee employee) {
		this.employee = employee;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Employee displayNode(){
		return this.getEmployee();
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	

}
