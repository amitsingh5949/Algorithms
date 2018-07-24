package com.javadwarf.stackbasics.gfg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testases = s.nextInt();
		for(int i=0; i<testases; i++) {
			int n = s.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int j=0; j<n; j++) {
				q.add(s.nextInt());
			}
		    reverse(q);
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
		}
	}
	
	public static void reverse(Queue<Integer> q){
		if(q.isEmpty()) return;
		int temp = q.poll();
		reverse(q);
		q.add(temp);
	}	

}
