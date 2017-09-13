package com.javaDwarf.dataStructure.doublyLinkedList;

public class DoublyLinkedListBasics1 {

	public static void main(String[] args) {
		
		DoublyLinkedListImpl sll = new DoublyLinkedListImpl();
		
		sll.insertFirst(new Employee(101, "Amit Singh", "Application Developer"));
		sll.insertFirst(new Employee(13, "Aryan Sharma", "Associate Manager"));
		sll.insertFirst(new Employee(12, "Namit Singh", "Equity Analyst"));
		sll.insertFirst(new Employee(78, "Amit kumar", "SMO"));
		sll.insertLast(new Employee(45, "simpu Singh", "Electronics Enggineer"));
		sll.insertLast(new Employee(272, "Shashank kumar", "Digital marketing manager"));
		sll.insertAfter(12,new Employee(33, "Jairam", "Digital marketing manager"));
		sll.displayDoublyLinkedListForward();
		
		System.out.println();
		try {
			System.out.println("lets delete aryan : " + sll.delete(13));
		} catch (DoublyLinkedListEmptyException e) {
			System.out.println("Exception caught while deleting element from Doubly Linked List : " + e.getMessage());
		}
		
		System.out.println();
		sll.displayDoublyLinkedListForward();
		System.out.println();
		
		System.out.println();
		try {
			System.out.println("lets delete first : " + sll.deleteFirst());
		} catch (DoublyLinkedListEmptyException e) {
			System.out.println("Exception caught while deleting element from Doubly Linked List : " + e.getMessage());
		}
		
		System.out.println();
		sll.displayDoublyLinkedListForward();
		System.out.println();
		
		
		System.out.println();
		try {
			System.out.println("lets delete last : " + sll.deleteLast());
		} catch (DoublyLinkedListEmptyException e) {
			System.out.println("Exception caught while deleting element from Doubly Linked List : " + e.getMessage());
		}
		
		System.out.println();
		sll.displayDoublyLinkedListForward();
		System.out.println();
		
	}

}
