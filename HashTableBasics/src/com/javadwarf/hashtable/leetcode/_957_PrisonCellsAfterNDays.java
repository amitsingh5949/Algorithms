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

}
