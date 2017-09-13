package com.javaDwarf.dataStructure.simpleLinkedList;

public class LinkStackImpl {

	private SimpleLinkedListImpl sll = null;
	
	public LinkStackImpl() {
		sll = new SimpleLinkedListImpl();
	}
	
	public void push(Employee emp){
		sll.insertFirst(emp);
	}
	
	public Employee pop() throws SimpleLinkedListEmptyException{
		return sll.deleteFirst().getEmployee();
	}
	
	public Employee peek(){
		if(sll.getFirst() != null){
		return sll.getFirst().getEmployee();
		}
		else{
			return null;
		}
	}
	
	public void displayStack(){
		sll.displaySimpleLinkedList();
	}
	
	public boolean isEmpty(){
		return sll.isSimpleLinkedListEmpty();
	}

}
