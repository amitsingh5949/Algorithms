package com.javaDwarf.leetcode;

public class _707_DesignLinkedList {

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		System.out.println(obj.get(2));
		obj.addAtHead(1);
		obj.addAtTail(3);
		obj.addAtIndex(1,2);
		System.out.println(  obj.get(1)); 
		obj.deleteAtIndex(0);
		System.out.println( obj.get(0)); 



		System.out.println();
		obj = new MyLinkedList();
		System.out.println(obj.get(0));
		obj.addAtIndex(1,2);
		System.out.println(obj.get(0));
		System.out.println(obj.get(1));
		obj.addAtIndex(0,1);
		System.out.println(obj.get(0));
		System.out.println(obj.get(1));
		
		
		/*obj.addAtHead(7);
		obj.addAtHead(2);
		obj.addAtHead(1);
		obj.addAtIndex(3,0);
		obj.deleteAtIndex(2);
		obj.addAtHead(6);
		obj.addAtTail(4);
		System.out.println(obj.get(4));
		obj.addAtHead(4);
		obj.addAtIndex(5,0);
		obj.addAtHead(6);*/
	}

}
class MyLinkedList {

	class Node{
		int val = 0;
		Node next = null;
		public Node(int val) {
			this.val = val;
		}
	}
	Node head = null;
	Node tail = null;
	int size = 0;


	/** Initialize your data structure here. */
	public MyLinkedList() {

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		Node temp = head;
		while(temp != null && index >= 0) {
			if(index == 0) return temp.val;
			temp = temp.next;
			index--;
		}
		return -1;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		Node curr = new Node(val);

		if(head == null) {
			head = curr;
			tail = curr;
		}
		else {
			curr.next = this.head;
			this.head = curr;
		}
		size++;

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node curr = new Node(val);

		if(tail == null) {
			tail = curr;
			head = curr;
		}
		else {
			this.tail.next = curr;
			this.tail = curr;
		}
		size++;

	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if(index<0) return;
		Node curr = new Node(val);
		Node temp = head;
		if(index == 0 ) {
			addAtHead(val);
			return;
		}
		if(index == size) {
			addAtTail(val);
			return;
		}
		while(temp != null && index > 1) {
			temp = temp.next;
			index--;
		}
		if(temp != null) {
			curr.next = temp.next;
			temp.next = curr;
			size++;
		}

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(index<0) return;		
		Node temp = head;
		int i = index;
		while(temp !=null && i>1) {
			temp = temp.next;
			i--;
		}
		if( temp !=null && temp.next!=null) {
			
			if(index == 0) {
				head = temp.next;
			}
			if(size == index -1) {
				tail = temp;
			}
			temp.next = temp.next.next;
			size--;

		}
	}
}
