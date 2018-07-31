package com.javaDwarf.gfg;

public class MergekSortedLists {

	public static void main(String[] args) {

	}
	
	public static Node mergeKList(Node[]a,int N){
		if(N<=0) return null;
		
		Node head1 = a[0];
		for(int i=1; i< N; i++) {
			head1 = merge(head1,a[i]);
		}
		return head1;
    }
	private static Node merge(Node head1, Node head2) {
		Node head = head1;
		while(head2 != null) {
			Node temp = head2.next;
			if(head1.value < head2.value) {
				Node prev = null;
				while(head1!=null && head1.value < head2.value) {
					prev = head1;	
					head1 = head1.next;
				}
				if(head1!=null) {
					prev.next = head2;
					head2.next = head1;
				}
				else {
					prev.next = head2;
					head2.next = null;
				}
			}
			else{
				head2.next = head1;
				head = head2;
			}
			head2 = temp;
			head1 = head;
		}
		return head;
	}

}
