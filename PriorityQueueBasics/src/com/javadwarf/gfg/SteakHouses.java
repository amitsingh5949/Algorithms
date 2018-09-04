package com.javadwarf.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SteakHouses {

	public static void main(String[] args) {

		List<List<Integer>>  l = new ArrayList<>();
		
		List<Integer>  l1 = new ArrayList<>();
		l1.add(1);
		l1.add(-3);
		l.add(l1);
		
		List<Integer>  l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);
		l.add(l2);
		
		List<Integer>  l3 = new ArrayList<>();
		l3.add(3);
		l3.add(4);
		l.add(l3);
		
		System.out.println(nearestXsteakHouses(3,l,1));
		
	}
	
	public static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, 
			List<List<Integer>> allLocations, 
			int numSteakhouses){
		List<List<Integer>>  l = new ArrayList<>();
		PriorityQueue<Location> q = new PriorityQueue<>(numSteakhouses);

		for(List<Integer> x : allLocations) {
			q.add(new Location(x.get(0), x.get(1), 
					x.get(0)*x.get(0) + x.get(1)*x.get(1)));
		}
		
		for(int i=0; i<numSteakhouses; i++) {
			Location temp = q.poll();
			List<Integer> ll = new ArrayList<>();
			ll.add(temp.x);
			ll.add(temp.y);
			l.add(ll);
		}

		return l;
	}
}

class Location implements Comparable<Location>{
	int x, y, d;

	public Location(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Location o) {
		return Integer.compare(d, o.d);
	}
}
