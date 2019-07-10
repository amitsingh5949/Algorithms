package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _760_FindAnagramMappings {

	public int[] anagramMappings(int[] A, int[] B) {
		
		Map<Integer,Integer> m1 = new HashMap<>();
		for(int i= 0; i<B.length; i++) {
			m1.put(B[i],i);
		}
		for(int i= 0; i<B.length; i++) {
			A[i] = m1.get(A[i]);
		}
		
		return A;

	}

}
