package com.javaDwarf.dataStructure.doublyLinkedList;

public class Link {
	
	private Employee employee;
	private Link next;
	private Link previous;
	
	public Link(Employee employee) {
		this.employee = employee;
		this.next = null;
	}
	
	public Employee displayLink(){
		return this.getEmployee();
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}

	public Link getPrevious() {
		return previous;
	}

	public void setPrevious(Link previous) {
		this.previous = previous;
	}
	
}
