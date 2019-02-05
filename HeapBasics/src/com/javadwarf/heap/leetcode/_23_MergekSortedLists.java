package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _23_MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists == null || lists.length==0)
			return null;
		
		ListNode lnHead = null;
		ListNode lnTail = null;

		PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
		for(int i=0; i<lists.length; i++) {
			if(lists[i]!=null)
			pq.add(lists[i]);
		}

		while(!pq.isEmpty()) {
			ListNode l = pq.poll();
			ListNode temp = l.next;
			if(lnHead == null) {
				lnHead = l;
				lnTail = l;
			}
			else {
				lnTail.next = l;
				lnTail = lnTail.next ;
			}
			l.next = null;
			if(temp != null) {
				pq.add(temp);
			}
		}
		return lnHead;

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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int row = s.nextInt();
			int col = row;
			int[][] matrix = new int[row][col];
			for(int x=0; x<row; x++) {
				for(int y=0; y<col; y++) {
					matrix[x][y] = s.nextInt();
				}
			}
			System.out.println(mergeKArrays(matrix, row));
		}
		s.close();
	}

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
