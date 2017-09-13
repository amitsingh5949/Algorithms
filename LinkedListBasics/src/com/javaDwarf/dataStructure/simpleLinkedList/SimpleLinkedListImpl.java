package com.javaDwarf.dataStructure.simpleLinkedList;

public class SimpleLinkedListImpl {

	private Link first;

	public SimpleLinkedListImpl() {
		this.first = null;
	}

	public void insertFirst(Employee emp){
		Link newLink = new Link(emp);
		if(!isSimpleLinkedListEmpty()){
			newLink.setNext(this.getFirst());
		}
		this.setFirst(newLink);
	}

	public Link deleteFirst() throws SimpleLinkedListEmptyException{

		if(!isSimpleLinkedListEmpty()){
			Link oldfirstLink = this.getFirst(); 
			this.setFirst(oldfirstLink.getNext());
			return oldfirstLink;
		}
		else{
			throw new SimpleLinkedListEmptyException("Cannot delete the first link as Simple Linked List is empty");
		}
	}

	/*public Link delete(int empId) throws SimpleLinkedListEmptyException{

		if(!isSimpleLinkedListEmpty()){

			Link matchedLink = this.find(empId);
			if(matchedLink != null){
				Link startingLink = this.getFirst();
				if(matchedLink == startingLink ){
					this.setFirst(startingLink.getNext());
				}
				else{
					while(startingLink.getNext() != matchedLink){
						startingLink = startingLink.getNext();
					}
					startingLink.setNext(matchedLink.getNext());
				}
			}
			return matchedLink;
		}
		else{
			throw new SimpleLinkedListEmptyException("Cannot delete the first link as Simple Linked List is empty");
		}
	}*/

	public Link delete(int empId) throws SimpleLinkedListEmptyException{
		if(!isSimpleLinkedListEmpty()){

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
			throw new SimpleLinkedListEmptyException("Cannot delete the first link as Simple Linked List is empty");
		}
		
	}

	public Link find(int empId) throws SimpleLinkedListEmptyException{

		if(!isSimpleLinkedListEmpty()){
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
			throw new SimpleLinkedListEmptyException("Cannot delete the first link as Simple Linked List is empty");
		}
	}

	public boolean isSimpleLinkedListEmpty(){
		return (this.getFirst() == null);
	}

	public void displaySimpleLinkedList(){
		System.out.println("Going to display Simple Linked List content from first to end :");
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



}
