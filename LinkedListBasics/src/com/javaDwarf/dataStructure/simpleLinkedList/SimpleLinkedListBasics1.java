package com.javaDwarf.dataStructure.simpleLinkedList;

public class SimpleLinkedListBasics1 {

	public static void main(String[] args) {
		
		SimpleLinkedListImpl sll = new SimpleLinkedListImpl();
		
		sll.insertFirst(new Employee(101, "Amit Singh", "Application Developer"));
		sll.insertFirst(new Employee(13, "Aryan Sharma", "SEO"));
		sll.insertFirst(new Employee(12, "Namit Singh", "Equity Analyst"));
		sll.insertFirst(new Employee(78, "Amit kumar", "SMO"));
		
		sll.displaySimpleLinkedList();
		System.out.println("First element in Simple Linked List : " + sll.getFirst().displayLink());
		
		System.out.println();
		try {
			System.out.println("lets delete aryan : " + sll.delete(13).displayLink());
		} catch (SimpleLinkedListEmptyException e) {
			System.out.println("Exception caught while deleting element from Simple Linked List : " + e.getMessage());
		}
		
		System.out.println();
		sll.displaySimpleLinkedList();
		System.out.println();
		
		while(!sll.isSimpleLinkedListEmpty()){
			try {
				Link deletedLink = sll.deleteFirst();
				System.out.println("Deleted Link :" +deletedLink.displayLink());
				
			} catch (SimpleLinkedListEmptyException e) {
				System.out.println("Exception caught while deleting first element from Simple Linked List : " + e.getMessage());
			}
		}
		
		sll.displaySimpleLinkedList();

	}

}

