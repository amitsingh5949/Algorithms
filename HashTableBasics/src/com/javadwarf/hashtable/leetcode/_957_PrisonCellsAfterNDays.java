package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _957_PrisonCellsAfterNDays {

	public static void main(String[] args) {

		int[] arr = {1,0,0,1,0,0,1,0};

		int[] arr0 = {0,1,0,1,0,1,0,0};

		int[] arr1 = {1,1,0,1,1,0,1,1};


		int[] arr2 = {1,0,0,1,0,0,0,1};

		//System.out.println(new _957_PrisonCellsAfterNDays().prisonAfterNDays(arr, 1000000000));
		System.out.println(new _957_PrisonCellsAfterNDays().prisonAfterNDays(arr1, 27));

	}

	Map<String, Integer> map = null;

	public int[] prisonAfterNDays(int[] cells, int N) {

		map = new HashMap<>();

		int[] oldStates = new int[cells.length];
		for(int i=0; i<cells.length;i++) {
			oldStates[i] = cells[i];
		}

		for(int i=0; i<N;i++) {

			String stateStr = "";
			for(int j:cells) {
				stateStr += j;
			}

			if(map.containsKey(stateStr)) {
				int j = map.get(stateStr);
				N = N%(i-j);
				i = -1;
				map.clear();
				cells = oldStates;
				continue;
			}
			else {
				map.put(stateStr, i);
			}
			cells = update(cells);
		}
		return cells;
	}

	public int[] update(int[] oldStates) {

		int[] newState = new int[oldStates.length];

		for(int i=0; i<oldStates.length; i++) {

			if(i==0 || i ==oldStates.length-1) {
				newState[i] = 0;
			}

			else if( (oldStates[i-1] == 1 && oldStates[i+1] == 1) || (oldStates[i-1] == 0 && oldStates[i+1] == 0)) {
				newState[i] = 1;
			}
			else {
				newState[i] = 0;
			}
		}
		return newState;
	}


	// Time limit Exceeded 
	public int[] prisonAfterNDays1(int[] cells, int N) {

		int[] oldStates = new int[cells.length];

		for(int i=0; i<cells.length;i++) {
			oldStates[i] = cells[i];
		}

		for(int i=0; i<N;i++) {
			oldStates = update1(oldStates);
		}
		return oldStates;
	}

	public int[] update1(int[] oldStates) {

		int[] newState = new int[oldStates.length];

		for(int i=0; i<oldStates.length; i++) {

			if(i==0 || i ==oldStates.length-1) {
				newState[i] = 0;
			}

			else if( (oldStates[i-1] == 1 && oldStates[i+1] == 1) || (oldStates[i-1] == 0 && oldStates[i+1] == 0)) {
				newState[i] = 1;
			}
			else {
				newState[i] = 0;
			}
		}
		return newState;
	}

	//o(1) space
	public int[] prisonAfterNDaysConstantSpace(int[] arr, int n) {

		int zeroToOne = 2;
		int oneToZero = 3;

		int p  = 0;
		while(p < n ){
			for( int i = 1; i<arr.length-1; i++){

				if( ((arr[i-1] == 0 || arr[i-1] == 2) && (arr[i+1] == 0 || arr[i+1] == 2)) ||
						((arr[i-1] == 1 || arr[i-1] == 3) && (arr[i+1] == 1 || arr[i+1] == 3))){
					if(arr[i] == 0 ) arr[i] = 2;
				}

				else if(arr[i] == 1 ) {
					arr[i] = 3;
				}
			}

			for( int i = 1; i<arr.length-1; i++){
				if(arr[i] == 2)arr[i] = 1;
				if(arr[i] == 3)arr[i] = 0;
			}

			if(p == 0){
				arr[0] = 0;
				arr[arr.length-1] = 0;
			}

			p++;

		}
		return arr;

	}

}
