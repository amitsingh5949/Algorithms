package com.javadwarf.gfg;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeCharacters {

	public static PriorityQueue<Node> pq = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int x=1; x<=testCases; x++) {
			pq = new PriorityQueue<>();
			System.out.println(rearrange(s.next()));
		}
		s.close();
	}

	private static int rearrange(String str) {
		int result = 1;

		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'a']++;
		}
		for(int i=0; i<arr.length;i++) {
			if(arr[i]!=0) {
				char c = (char)(i + (int)'a');
				pq.add(new Node(c,arr[i]));
			}
		}
		while(!pq.isEmpty()) {
			
			if(pq.size()>1) {
				Node n1 = pq.poll();
				n1.count = n1.count-1;
				Node n2 = pq.poll();
				n2.count = n2.count-1;
				if(n1.count>0) {
					pq.add(n1);
				}
				if(n2.count>0) {
					pq.add(n2);
				}
			}
			else if(pq.size()==1) {
				if(pq.poll().count>1) {
					result = 0;
				}
			}
		}
		return result;
	}

}

class Node implements Comparable<Node>{
	public char ch;
	public int count;
	public Node(char ch, int count) {
		this.ch = ch;
		this.count = count ;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(o.count, this.count);
	}
	@Override
	public String toString() {
		return ch + "-" + count;
	}
	
}
