package com.javaDwarf.leetcode;

public class _708_InsertIntoCyclicSortedList {

	public static void main(String[] args) {

	}

	public Node insert(Node head, int insertVal) {

		Node newNode = new Node(insertVal);

		if(head == null) {
			head =  newNode;
			head.next = head;
		}
		else if(head.next == head) {
			head.next = newNode;
			newNode.next = head;
		}
		else{
			Node temp = head;

			while(!(temp.next.val < temp.val || temp.next == head)) {
				temp = temp.next;
			}
			temp = temp.next;

			while( true) {

				if(temp.next.val < insertVal || temp.next == head) {
					Node tempAgain  = temp.next;
					temp.next = newNode;
					newNode.next = tempAgain;
					break;
				}
				else {
					temp = temp.next;
				}
			}
		}
		return head;
	}
}
