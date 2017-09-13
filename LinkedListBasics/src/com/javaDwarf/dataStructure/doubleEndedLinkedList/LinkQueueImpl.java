package com.javaDwarf.dataStructure.doubleEndedLinkedList;

public class LinkQueueImpl {

	DoubleEndedLinkedListImpl dell = null;

	public LinkQueueImpl() {
		dell=  new DoubleEndedLinkedListImpl();
	}

	public void insert(Employee emp){
		dell.insertLast(emp);
	}

	public Employee remove() throws DoubleEndedLinkedListEmptyException{
		return dell.deleteFirst().getEmployee();
	}

	public Employee peekFront(){
		if(dell.getFirst() != null){
			return dell.getFirst().getEmployee();
		}
		else{
			return null;
		}
	}
	
	public Employee peekRear(){
		if(dell.getLast() != null){
			return dell.getLast().getEmployee();
		}
		else{
			return null;
		}
	}

	public void displayQueue(){
		dell.displayDoubleEndedLinkedList();
	}
	
	public boolean isQueueEmpty(){
		return dell.isDoubleEndedLinkedListEmpty();
	}

}
