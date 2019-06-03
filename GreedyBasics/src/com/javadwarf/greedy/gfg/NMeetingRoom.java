package com.javadwarf.greedy.gfg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class GFG {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			Meeting[] a = new Meeting[size];
			
			int[] start = new int[size];
			int[] end = new int[size];
			
			for(int x=0; x<size; x++) {
				start[x] = s.nextInt();
			}
			for(int x=0; x<size; x++) {
				end[x] = s.nextInt();
			}
			
			for(int x=0; x<size; x++) {
				a[x] = new Meeting(start[x], end[x], x+1);
			}
			meetingOrder(a);
			System.out.println();
		}
		s.close();

	}

	private static void meetingOrder(Meeting[] a) {
		
		Arrays.sort(a, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return Integer.compare(o2.s, o1.s);
			}
		});
		
		Meeting m = a[0];
		
		for(int i = 1;i <a.length; i++) {
			Meeting curr = a[i];
			if(curr.s > m.f) {
				System.out.print(m.o + " ");
				m = curr;
			}
		}
		System.out.print(m.o + " ");
	}

}

class Meeting{
	int s, f, o;

	public Meeting(int s, int f, int o) {
		super();
		this.s = s;
		this.f = f;
		this.o = o;
	}
}