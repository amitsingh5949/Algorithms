package com.javaDwarf.gfg;

public class CloneLinkedListWithNextAndRandomPointer {

	public static void main(String[] args) {
		Node3 n1 = new Node3(1);
		Node3 n2 = new Node3(2);
		Node3 n3 = new Node3(3);

		n1.next = n2;
		n2.next = n3;

		n1.arb = n3;
		n2.arb= n1;
		n3.arb =n2;

		Node3 root = copyList(n1);
		while(root!=null) {
			System.out.println(root);
			root = root.next;

		}

	}
	public static Node3 copyList(Node3 head){

		if(head == null) return null;

		Node3 copyLL = null;
		Node3 headTemp = head;

		while(headTemp != null) {
			Node3 curr = new Node3(headTemp.data);
			Node3 next = headTemp.next;
			headTemp.next = curr;
			curr.next=next;
			headTemp = next;
		}

		headTemp = head;
		copyLL = head.next;

		while(headTemp != null) {
			if(headTemp.arb!=null)
				headTemp.next.arb = headTemp.arb.next;
			headTemp = headTemp.next.next;
		}

		headTemp = head;

		while(headTemp != null) {
			Node3 copy = headTemp.next;
			headTemp.next = headTemp.next.next;
			if(copy.next != null)
				copy.next = copy.next.next;
			headTemp = headTemp.next;
		}
		return copyLL;
	}
}

class Node3
{
	int data;
	Node3 next;
	Node3 arb;
	public Node3(int d) {data = d; next = null; }
	@Override
	public String toString() {
		return "Node3 [data=" + data + ", arb=" + arb.data + "]";
	}

}
