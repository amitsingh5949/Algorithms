package com.javaDwarf.gfg;

public class FlatteningALinkedList {

	public static void main(String[] args) {

		Node2 n1 = new Node2(5);
		Node2 n2 = new Node2(7);
		Node2 n3 = new Node2(8);
		Node2 n4 = new Node2(30);
		Node2 n5 = new Node2(10);
		Node2 n6 = new Node2(20);

		n1.next =n5;
		n1.bottom = n2;
		n2.bottom = n3;
		n3.bottom = n4;

		n5.bottom = n6;

		Node2 root = flatten(n1);
		while(root!=null) {
			System.out.print(root.data+" ");
			root = root.bottom;
		}


	}

	public static Node2 flatten(Node2 root){
		Node2 head1 = root;
		Node2 head2 = root.next;
		while(head2!=null) {
			head1 = merge(head1,head2);
			head2=head2.next;
		}
		root = head1;
		/*while(head1!=null) {
			head1.next=head1.bottom;
			head1.bottom=null;
			head1 = head1.next;
		}*/
		return root;
	}

	private static Node2 merge(Node2 head1, Node2 head2) {
		Node2 head = head1;
		while(head2 != null) {
			Node2 temp = head2.bottom;
			if(head1.data < head2.data) {
				Node2 prev = null;
				while(head1!=null && head1.data < head2.data) {
					prev = head1;	
					head1 = head1.bottom;
				}
				if(head1!=null) {
					prev.bottom = head2;
					head2.bottom = head1;
				}
				else {
					prev.bottom = head2;
					head2.bottom = null;
				}
			}
			else{
				head2.bottom = head1;
				head = head2;
			}
			head2 = temp;
			head1 = head;
		}
		return head;
	}
}

class Node2
{
	int data;
	Node2 next;
	Node2 bottom;

	public Node2(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
