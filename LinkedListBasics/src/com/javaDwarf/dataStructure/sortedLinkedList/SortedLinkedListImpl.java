package com.javaDwarf.dataStructure.sortedLinkedList;

public class SortedLinkedListImpl {

	private Link first;

	public SortedLinkedListImpl() {
		this.first = null;
	}

	/*insert in descending order
	  public void insert(Employee emp){
		Link newLink = new Link(emp);

		Link previous = this.getFirst();
		Link current = this.getFirst();

		if(current == null){
			this.setFirst(newLink);
		}
		else{
			while(current != null){
				if(emp.getEmpId() > current.getEmployee().getEmpId()){
					previous.setNext(newLink);
					newLink.setNext(current);
					break;
				}
				else{
					previous = current;
					current = current.getNext();
				}
			}
			if(current == null){
				previous.setNext(newLink);
			}
		}
	}*/
	
	//insert in ascending order
	public void insert(Employee emp){
		Link newLink = new Link(emp);

		Link previous = this.getFirst();
		Link current = this.getFirst();

		if(current == null){
			this.setFirst(newLink);
		}
		else{
			while(current != null){
				if(emp.getEmpId() < current.getEmployee().getEmpId()){
					if(previous == this.getFirst()){
					this.setFirst(newLink);
					newLink.setNext(current);
					}
					else{
						previous.setNext(newLink);
						newLink.setNext(current);
					}
					break;
				}
				else{
					previous = current;
					current = current.getNext();
				}
			}
			if(current == null){
				previous.setNext(newLink);
			}
		}
	}


	public Link deleteFirst() throws SortedLinkedListEmptyException{

		if(!isSortedLinkedListEmpty()){
			Link oldfirstLink = this.getFirst(); 
			this.setFirst(oldfirstLink.getNext());
			return oldfirstLink;
		}
		else{
			throw new SortedLinkedListEmptyException("Cannot delete the first link as Sorted Linked List is empty");
		}
	}

	public Link delete(int empId) throws SortedLinkedListEmptyException{
		if(!isSortedLinkedListEmpty()){

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
			throw new SortedLinkedListEmptyException("Cannot delete the first link as Sorted Linked List is empty");
		}

	}

	public Link find(int empId) throws SortedLinkedListEmptyException{

		if(!isSortedLinkedListEmpty()){
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
			throw new SortedLinkedListEmptyException("Cannot delete the first link as Sorted Linked List is empty");
		}
	}

	public boolean isSortedLinkedListEmpty(){
		return (this.getFirst() == null);
	}

	public void displaySortedLinkedList(){
		System.out.println("Going to display Sorted Linked List content from first to end :");
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

