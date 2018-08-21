package com.javadwarf.stackbasics.gfg;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class SnakeLadder {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int test = s.nextInt();

		for( int i=0; i<test; i++) {
			int p = s.nextInt();
			Map<Integer, Integer> map = new TreeMap<>();

			for(int j=0; j<p; j++) {

				map.put(s.nextInt(), s.nextInt());
			}
			System.out.println(minAttempt(map, 30));
		}
		s.close();
	}
	
	private static int  minAttempt(Map<Integer, Integer> map, int dest) {
		int minAttempts = 0;
	
		boolean[] visted = new boolean[31];
		
		Queue<Integer> q1 = new LinkedList<>();
		q1.add(1);
		q1.add(null);

		while(!q1.isEmpty()) {

			Integer curr = q1.poll();
			if(curr==null) {
				minAttempts++;
				q1.add(null);
				continue;
			}
			
			for(int i = curr+1; i<= curr+6; i++) {
				int next = -1;
				if(map.containsKey(i) && map.get(i)>i){
					next = map.get(i);
				}
				else if(!map.containsKey(i)) {
					next = i;
				}
				if(next == dest) {
					return ++minAttempts;
				}
				if(next != -1 && !visted[next] ) {
					q1.add(next);
				}
			}
		}
		return minAttempts;
	}
}
