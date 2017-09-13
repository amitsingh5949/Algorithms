package com.javaDwarf.dataStructure.doublyLinkedList;

public class LinkDequeImpl {

	DoublyLinkedListImpl dll = null;
	
	public LinkDequeImpl() {
		dll = new DoublyLinkedListImpl();
	}
	
	public void insertFirst(Employee emp){
		dll.insertFirst(emp);
	}
	
	public void insertLast(Employee emp){
		dll.insertLast(emp);
	}
	
	public Employee deleteFirst() throws DoublyLinkedListEmptyException{
		return dll.deleteFirst();
	}
	
	public Employee deleteLast() throws DoublyLinkedListEmptyException{
		return dll.deleteLast();
	}
	
	
}
