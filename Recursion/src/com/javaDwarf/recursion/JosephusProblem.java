package com.javaDwarf.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {

	public static void main(String[] args) {
		System.out.println(josephus(3, 2));
		System.out.println(josephus(5, 3));
		
		System.out.println(josephusWithoutExtraSpace(3, 2));
		System.out.println(josephusWithoutExtraSpace(5, 3));
	}

	public static int josephus(int n, int k){

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}

		while(q.size() > 1) {
			for(int i=1; i<k; i++) {
				q.offer(q.poll());
			}
			q.poll();
		}

		return q.peek();
	}
	
	public static int josephusWithoutExtraSpace(int n, int k) {
		
		if( n==1) return 1;
		int x = josephusWithoutExtraSpace(n-1, k);
		
		/* The position returned by josephus(n - 1, k)  
	    is adjusted because the recursive call  
	    josephus(n - 1, k) considers the original  
	    position k%n + 1 as position 1 */
		return ( (x + k-1) % n ) +  1; 
	}

} 
