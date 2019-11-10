package com.javadwarf.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _575_DistributeCandies {

	public static void main(String[] args) {

	}

	public int distributeCandies(int[] candies) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int candy : candies) {
			set.add(candy);
		}
		
		return  (set.size()<=candies.length/2)? set.size(): candies.length/2;

	}

}
