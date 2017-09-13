package com.javaDwarf.dataStructure.simpleLinkedList;

public class Link {
	
	private Employee employee;
	private Link next;
	
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
	
	

}
