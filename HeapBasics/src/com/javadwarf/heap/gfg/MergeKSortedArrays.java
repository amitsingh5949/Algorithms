package com.javadwarf.heap.gfg;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeKSortedArrays {

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

		Pos[] heap = new Pos[k];
		for(int j=0; j<k; j++) {
			heap[j] = new Pos(j,0, matrix[j][0]);
			siftup(heap,j);
		}
		int count = heap.length;
		while(true) {
			if(count == 0) {
				break;
			}
			Pos min = heap[0];
			list.add(min.value);
			if(min.y == matrix[min.x].length-1) {
				count--;
				Pos temp  = heap[0];
				heap[0] = heap[count];
				heap[count]  = temp;
				siftdown(heap, 0, count-1);

			}
			else {
				heap[0] = new Pos(min.x, min.y+1, matrix[min.x][min.y+1]);
				siftdown(heap, 0, count-1);
			}
		}
		return list;
	}

	public static void siftup(Pos[] heap, int lastIndex){

		int parentIndex = (lastIndex-1)/2;
		if(parentIndex >= 0 && heap[parentIndex].compareTo(heap[lastIndex]) > 0) {
			Pos temp = heap[parentIndex];
			heap[parentIndex] = heap[lastIndex];
			heap[lastIndex] = temp;
			siftup(heap, parentIndex);
		}
		else {
			return;
		}
	}

	public static void siftdown(Pos[] heap, int currIndex, int lastIndex){

		int left = -1;
		int right = -1;
		if(currIndex*2+1<=lastIndex) {
			left = currIndex*2+1;
		}
		if(currIndex*2+2<=lastIndex) {
			right = currIndex*2+2;
		}

		if((left != -1 && right != -1 && heap[left].compareTo(heap[right])<=0 && heap[left].compareTo(heap[currIndex])< 0) ||
				(left!=-1 && right==-1 && heap[left].compareTo(heap[currIndex])< 0)) {
			Pos temp = heap[currIndex];
			heap[currIndex] = heap[left];
			heap[left] = temp;
			siftdown(heap, left, lastIndex);
		}
		else if((left != -1 && right != -1 && heap[left].compareTo(heap[right])>0 && heap[right].compareTo(heap[currIndex])< 0) ||
				(left==-1 && right!=-1 && heap[right].compareTo(heap[currIndex])< 0)) {
			Pos temp = heap[currIndex];
			heap[currIndex] = heap[right];
			heap[right] = temp;
			siftdown(heap, right, lastIndex);
		}
		else {
			return;
		}
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
