package com.javadwarf.gfg;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {

	public static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
	public static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int x=1; x<=n; x++) {
			addNum(s.nextInt());
			System.out.println(findMedian());
		}
		s.close();
	}
	
	public static void addNum(int num) {
		if(pqMin.size()==0) {
			pqMin.add(num);
		}
		else {
			if(pqMin.peek()<num) {
				pqMax.add(pqMin.poll());
				pqMin.add(num);
			}
			else {
				pqMax.add(num);
			}
			if(pqMax.size()-pqMin.size()>1) {
				pqMin.add(pqMax.poll());
			}
		}
	}

	public static double findMedian() {
		double median = 0.0;
		if(pqMin.size() < pqMax.size() ) {
			median = pqMax.peek();
		}
		else if(pqMin.size() > pqMax.size() ) {
			median = pqMin.peek();
		}
		else {
			median =  (pqMin.peek() + pqMax.peek())/2.0;
		}
		return median;
	}
}
