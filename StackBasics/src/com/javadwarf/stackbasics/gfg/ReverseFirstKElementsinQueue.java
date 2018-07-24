package com.javadwarf.stackbasics.gfg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseFirstKElementsinQueue {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testases = s.nextInt();
		for(int i=0; i<testases; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int j=0; j<n; j++) {
				q.add(s.nextInt());
			}
			q = modifyQueue(q,k);
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
		}
	}

	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k){
		Queue<Integer> q1 = extract(q, new LinkedList<>(), k);
		while(!q.isEmpty()) {
			q1.add(q.poll());
		}
		return q1;
	}
	
	public static  Queue<Integer>  extract(Queue<Integer> q, Queue<Integer> q1, int k){
		if(!q.isEmpty()) {
			if(k==0) {
				return q1;
			}
			int temp = q.poll();
			q1 = extract(q, q1, --k);
			q1.add(temp);
		}
		return q1;
	}
}