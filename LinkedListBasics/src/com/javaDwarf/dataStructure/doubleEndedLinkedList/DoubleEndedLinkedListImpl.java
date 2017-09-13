package com.javaDwarf.dataStructure.doubleEndedLinkedList;

public class DoubleEndedLinkedListImpl {

	private Link first;
	private Link last;

	public DoubleEndedLinkedListImpl() {
		this.first = null;
		this.last = null;
	}

	public void insertFirst(Employee emp){
		Link newLink = new Link(emp);
		if(isDoubleEndedLinkedListEmpty()){
			this.setLast(newLink);
		}
		else{
			newLink.setNext(this.getFirst());
		}
		this.setFirst(newLink);
	}
	
	public void insertLast(Employee emp){
		Link newLink = new Link(emp);
		if(isDoubleEndedLinkedListEmpty()){
			this.setFirst(newLink);
		}
		else{
			this.getLast().setNext(newLink);
		}
		this.setLast(newLink);
	}


	public Link deleteFirst() throws DoubleEndedLinkedListEmptyException{

		if(!isDoubleEndedLinkedListEmpty()){
			Link oldfirstLink = this.getFirst(); 
			if(oldfirstLink.getNext() == null){
				this.setLast(oldfirstLink.getNext());
			}
			this.setFirst(oldfirstLink.getNext());
			return oldfirstLink;
		}
		else{
			throw new DoubleEndedLinkedListEmptyException("Cannot delete the first link as Double Ended Linked List is empty");
		}
	}
	
	/* 
	Cannot delete elements from last as we have reference of last not the previous link to last, else it would have been
	
	public Link deleteLast() throws DoubleEndedLinkedListEmptyException{
		previous.setNext(null);
		this.setLast(previous);
	}
	*/

	public Link delete(int empId) throws DoubleEndedLinkedListEmptyException{
		if(!isDoubleEndedLinkedListEmpty()){

			Link previous = this.getFirst();
			Link current = this.getFirst();
			
			while(current != null && current.getEmployee().getEmpId() != empId){
				previous = current;
				current = current.getNext();
			}
			if(current != null){
				previous.setNext(current.getNext());
			}
			return current;
		}
		else{
			throw new DoubleEndedLinkedListEmptyException("Cannot delete the first link as Double Ended Linked List is empty");
		}
		
	}

	public Link find(int empId) throws DoubleEndedLinkedListEmptyException{

		if(!isDoubleEndedLinkedListEmpty()){
			Link matchedLink = null;
			Link startingLink = this.getFirst(); 
			while(startingLink != null){
				if(startingLink.getEmployee().getEmpId() == empId){
					matchedLink = startingLink;
					break;
				}
				else{
					startingLink = startingLink.getNext();
				}
			}
			return matchedLink;
		}
		else{
			throw new DoubleEndedLinkedListEmptyException("Cannot delete the first link as Double Ended Linked List is empty");
		}
	}

	public boolean isDoubleEndedLinkedListEmpty(){
		return (this.getFirst() == null);
	}

	public void displayDoubleEndedLinkedList(){
		System.out.println("Going to display Double Ended Linked List content from first to end :");
		Link nextItem = this.getFirst();
		while(nextItem != null){
			System.out.println(nextItem.displayLink().toString());
			nextItem = nextItem.getNext();
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

