package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _23_MergekSortedLists {
	
	// Add the head of all the lists in pq
	// poll element. add it to result list and and add next element to pq.

	public ListNode mergeKLists(ListNode[] lists) {

		if(lists == null || lists.length==0)
			return null;

		ListNode lnHead = null;
		ListNode dummy = new ListNode(0);
		lnHead = dummy;

		PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
		for(int i=0; i<lists.length; i++) {
			if(lists[i]!=null)
				pq.add(lists[i]);
		}

		while(!pq.isEmpty()) {
			ListNode l = pq.poll();
			ListNode temp = l.next;
			dummy.next = l;
			dummy = dummy.next;
			l.next = null;
			if(temp != null) {
				pq.add(temp);
			}
		}
		return lnHead.next;

	}
}

class ListNode {
	int val;
	ListNode next;    
	ListNode(int x) { val = x; }
}

/******
 * 
 * @author amit
 * Similar question, instead we have k sorted arrays instead of k sorted lists
 *
 */
class MergeKSortedArrays {

	// Add the first row of matrix in pq
	// poll element. add it to result list and and add next cell element from currently polled cell to pq.

	public static ArrayList<Integer> mergeKArrays(int[][] matrix,int k){
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Pos> pq = new PriorityQueue<>();

		for(int j=0; j<k; j++) {
			pq.add(new Pos(j,0, matrix[j][0]));
		}
		while(!pq.isEmpty()) {
			Pos min = pq.poll();
			list.add(min.value);
			if(min.y != matrix[min.x].length-1) {
				pq.add(new Pos(min.x, min.y+1, matrix[min.x][min.y+1]));
			}
		}
		return list;
	}
}

class Pos implements Comparable<Pos>{
	public int x,y, value;
	public Pos(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value =value;
	}
	@Override
	public int compareTo(Pos o) {
		return Integer.compare(this.value, o.value);
	}
	@Override
	public String toString() {
		return value+"";
	}
}
