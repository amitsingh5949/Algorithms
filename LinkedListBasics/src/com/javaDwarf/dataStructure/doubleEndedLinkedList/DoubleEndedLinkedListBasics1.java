package com.javaDwarf.dataStructure.doubleEndedLinkedList;

public class DoubleEndedLinkedListBasics1 {

	public static void main(String[] args) {
		
		DoubleEndedLinkedListImpl sll = new DoubleEndedLinkedListImpl();
		
		sll.insertFirst(new Employee(101, "Amit Singh", "Application Developer"));
		sll.insertFirst(new Employee(13, "Aryan Sharma", "Associate Manager"));
		sll.insertFirst(new Employee(12, "Namit Singh", "Equity Analyst"));
		sll.insertFirst(new Employee(78, "Amit kumar", "SMO"));
		
		System.out.println("First element in DoubleEnded Linked List : " + sll.getFirst().displayLink());
		
		sll.insertLast(new Employee(45, "simpu Singh", "Electronics Enggineer"));
		sll.insertLast(new Employee(22, "Shashank kumar", "Digital marketing manager"));
		sll.displayDoubleEndedLinkedList();
		
		System.out.println();
		try {
			System.out.println("lets delete aryan : " + sll.delete(13).displayLink());
		} catch (DoubleEndedLinkedListEmptyException e) {
			System.out.println("Exception caught while deleting element from DoubleEnded Linked List : " + e.getMessage());
		}
		
		System.out.println();
		sll.displayDoubleEndedLinkedList();
		System.out.println();
		
		while(!sll.isDoubleEndedLinkedListEmpty()){
			try {
				Link deletedLink = sll.deleteFirst();
				System.out.println("Deleted Link :" +deletedLink.displayLink());
				
			} catch (DoubleEndedLinkedListEmptyException e) {
				System.out.println("Exception caught while deleting first element from DoubleEnded Linked List : " + e.getMessage());
			}
		}
		
		sll.displayDoubleEndedLinkedList();

	}

}

/*OUTPU:
First element in DoubleEnded Linked List : Employee ID : 78 - Name : Amit kumar - Role : SMO
Going to display Double Ended Linked List content from first to end :
Employee ID : 78 - Name : Amit kumar - Role : SMO
Employee ID : 12 - Name : Namit Singh - Role : Equity Analyst
Employee ID : 13 - Name : Aryan Sharma - Role : SEO
Employee ID : 101 - Name : Amit Singh - Role : Application Developer
Employee ID : 45 - Name : simpu Singh - Role : Electronics Enggineer
Employee ID : 22 - Name : Shashank kumar - Role : Digital marketing manager

lets delete aryan : Employee ID : 13 - Name : Aryan Sharma - Role : SEO

Going to display Double Ended Linked List content from first to end :
Employee ID : 78 - Name : Amit kumar - Role : SMO
Employee ID : 12 - Name : Namit Singh - Role : Equity Analyst
Employee ID : 101 - Name : Amit Singh - Role : Application Developer
Employee ID : 45 - Name : simpu Singh - Role : Electronics Enggineer
Employee ID : 22 - Name : Shashank kumar - Role : Digital marketing manager

Deleted Link :Employee ID : 78 - Name : Amit kumar - Role : SMO
Deleted Link :Employee ID : 12 - Name : Namit Singh - Role : Equity Analyst
Deleted Link :Employee ID : 101 - Name : Amit Singh - Role : Application Developer
Deleted Link :Employee ID : 45 - Name : simpu Singh - Role : Electronics Enggineer
Deleted Link :Employee ID : 22 - Name : Shashank kumar - Role : Digital marketing manager
Going to display Double Ended Linked List content from first to end :
 */
