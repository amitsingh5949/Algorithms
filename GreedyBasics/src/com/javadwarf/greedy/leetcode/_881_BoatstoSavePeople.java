package com.javadwarf.greedy.leetcode;

import java.util.Arrays;

public class _881_BoatstoSavePeople {

	public static void main(String[] args) {
		
		System.out.println(new _881_BoatstoSavePeople().numRescueBoats(new int[] {1,2},3 ));
		System.out.println(new _881_BoatstoSavePeople().numRescueBoats(new int[] {3,2,2,1}, 3));
		System.out.println(new _881_BoatstoSavePeople().numRescueBoats(new int[] {3,5,3,4},5 ));
		System.out.println(new _881_BoatstoSavePeople().numRescueBoats(new int[] {1,1,1,1,2,3},3));
		
		System.out.println(new _881_BoatstoSavePeople().numRescueBoats(new int[] {1,3,5,5},7));

	}

	
	// Sort and greedy O(nlogn) and o(1)
	public int numRescueBoats(int[] people, int limit) {
		
		Arrays.parallelSort(people);
		
		int i = 0;
		int j = people.length-1;
		
		int count = 0 ;
		
		while(i<=j) {
			
			if(people[j] + people[i]<=limit) {
				i++;
			}
			j--;
			count++;
			
		}
		return count;
	}
	
	
	// This logic uses bucket Sort o(n) and o(n)
	public int numRescueBoats1(int[] people, int limit) {
        int[] buckets = new int[limit+1];
        for(int p: people) buckets[p]++;
        int start = 0;
        int end = buckets.length - 1;
        int solution = 0;
        while(start <= end) {
			//make sure the start always point to a valid number
            while(start <= end && buckets[start] <= 0) start++;
			//make sure end always point to valid number
            while(start <= end && buckets[end] <= 0) end--;
			//no one else left on the ship, hence break.
            if(buckets[start] <= 0 && buckets[end] <= 0) break;
            solution++;
            if(start + end <= limit) buckets[start]--; // both start and end can carry on the boat
            buckets[end]--;
        }
        return solution;
    }

}
