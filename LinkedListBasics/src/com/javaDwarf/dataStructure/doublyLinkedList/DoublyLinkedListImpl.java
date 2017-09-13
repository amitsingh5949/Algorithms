package com.javaDwarf.dataStructure.doublyLinkedList;

public class DoublyLinkedListImpl {

	private Link first;
	private Link last;

	public DoublyLinkedListImpl() {
		this.first = null;
		this.last = null;
	}

	public void insertFirst(Employee emp){
		Link newLink = new Link(emp);
		if(isDoublyLinkedListEmpty()){
			this.setFirst(newLink);
			this.setLast(newLink);
		}
		else{
			newLink.setNext(this.getFirst());
			this.getFirst().setPrevious(newLink);
			this.setFirst(newLink);
		}
	}

	public void insertLast(Employee emp){
		Link newLink = new Link(emp);
		if(isDoublyLinkedListEmpty()){
			this.setFirst(newLink);
			this.setLast(newLink);
		}
		else{
			newLink.setPrevious(this.getLast());
			this.getLast().setNext(newLink);
			this.setLast(newLink);
		}
	}

	public void insertAfter(int empId, Employee emp){
		Link newLink = new Link(emp);
		if(isDoublyLinkedListEmpty()){
			this.setFirst(newLink);
			this.setLast(newLink);
		}
		else{
			Link current = this.getFirst();
			while(current != null){
				if(current.getEmployee().getEmpId() == empId){
					break;
				}
				else{
					current = current.getNext();
				}
			}
			if(current == null || (current == this.getLast())){
				newLink.setNext(null);
				newLink.setPrevious(this.getLast());
				this.getLast().setNext(newLink);
				this.setLast(newLink); 
			}
			else{
				newLink.setNext(current.getNext());
				newLink.setPrevious(current);
				current.getNext().setPrevious(newLink);
				current.setNext(newLink);
			}
		}
	}

	public Employee deleteFirst() throws DoublyLinkedListEmptyException{

		if(!isDoublyLinkedListEmpty()){
			Link first = this.getFirst();
			if(first.getNext() == null){
				this.setLast(null);
				this.setFirst(null);
			}
			else{
				this.setFirst(first.getNext());
				first.getNext().setPrevious(null);
			}
			return first.getEmployee();
		}
		else{
			throw new DoublyLinkedListEmptyException("Cannot delete the first link as Doubly Linked List is empty");
		}

	}

	public Employee deleteLast() throws DoublyLinkedListEmptyException{

		if(!isDoublyLinkedListEmpty()){
			Link last = this.getLast();
			if(last.getPrevious() == null){
				this.setLast(null);
				this.setFirst(null);
			}
			else{
				last.getPrevious().setNext(null);
				this.setLast(last.getPrevious());
			}
			return last.getEmployee();
		}
		else{
			throw new DoublyLinkedListEmptyException("Cannot delete the last link as Doubly Linked List is empty");
		}	
	}

	public Employee delete(int empId) throws DoublyLinkedListEmptyException{

		if(!isDoublyLinkedListEmpty()){
			Link current = this.getFirst();
			while(current != null){
				if(current.getEmployee().getEmpId() == empId){
					break;
				}
				else{
					current = current.getNext();
				}
			}
			if(current != null){
				if(current == this.getFirst()){
					this.setFirst(null);
					this.setLast(null);
				}
				else if(current == this.getLast()){
					current.getPrevious().setNext(current.getNext());
					this.setLast(current.getPrevious());
				}
				else{
					current.getPrevious().setNext(current.getNext());
					current.getNext().setPrevious(current.getPrevious());
				}
			}
			return ((current == null) ? null : current.getEmployee());
		}
		else{
			throw new DoublyLinkedListEmptyException("Cannot delete the link as Doubly Linked List is empty");
		}
	}

	public Employee find(int empId) throws DoublyLinkedListEmptyException{

		if(!isDoublyLinkedListEmpty()){
			Link startingLink = this.getFirst(); 
			while(startingLink != null){
				if(startingLink.getEmployee().getEmpId() == empId){
					break;
				}
				else{
					startingLink = startingLink.getNext();
				}
			}
			return ((startingLink == null) ? null : startingLink.getEmployee());
		}
		else{
			throw new DoublyLinkedListEmptyException("Cannot find the link as Doubly Linked List is empty");
		}
	}

	public boolean isDoublyLinkedListEmpty(){
		return (this.getFirst() == null);
	}


	public void displayDoublyLinkedListForward(){
		System.out.println("Going to display Doubly Linked List content from first to end :");
		Link nextItem = this.getFirst();
		while(nextItem != null){
			System.out.println(nextItem.displayLink().toString());
			nextItem = nextItem.getNext();
		}
	}

	public void displayDoublyLinkedListBackward(){
		System.out.println("Going to display Doubly Linked List content from end to first :");
		Link previousItem = this.getLast();
		while(previousItem != null){
			System.out.println(previousItem.displayLink().toString());
			previousItem = previousItem.getPrevious();
		}
	}

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

	public Link getLast() {
		return last;
	}

	public void setLast(Link last) {
		this.last = last;
	}

}

