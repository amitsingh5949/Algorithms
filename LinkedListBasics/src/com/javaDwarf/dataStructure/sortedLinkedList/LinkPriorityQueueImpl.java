package com.javaDwarf.dataStructure.sortedLinkedList;

public class LinkPriorityQueueImpl {
	
	SortedLinkedListImpl ssl = null;
	
	public LinkPriorityQueueImpl(){
		ssl = new SortedLinkedListImpl();
	}

	public void insert(Employee emp){
		ssl.insert(emp);
	}
	
	public Employee remove() throws SortedLinkedListEmptyException{
		return ssl.deleteFirst().getEmployee();
	}
	
	public Employee peek(){
		return ssl.getFirst().getEmployee();
	}
	
	public boolean isPriorityQueueEmpty(){
		return ssl.isSortedLinkedListEmpty();
	}
	
	public void displayPriorityQueue(){
		ssl.displaySortedLinkedList();
	}
}
