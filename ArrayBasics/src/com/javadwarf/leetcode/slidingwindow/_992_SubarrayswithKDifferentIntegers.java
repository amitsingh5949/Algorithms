package com.javadwarf.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _992_SubarrayswithKDifferentIntegers {

	public static void main(String[] args) {
		int[] x = {1,2,1,3,4};
		System.out.println(new _992_SubarrayswithKDifferentIntegers().subarraysWithKDistinct(x, 3));
	}

	public int subarraysWithKDistinct(int[] A, int K){

		int res = 0;
		int curr = 0;
		Map<Integer, Integer> map = new HashMap<>();

		int begin = 0;
		int end = 0;

		while(end<A.length) {

			Integer chEnd = A[end];
			int count = map.getOrDefault(chEnd, 0);
			map.put(chEnd, count+1);

			if(map.size() < K) {
				end++;
				continue;
			}
			else if(map.size() == K) {
				res++;
				curr++;
				end++;
				continue;
			}
			else {
				while(map.size() != K) {

					if(map.size() != K && curr != 0) {
						curr--;
						res += curr;
					}
					else {
						curr = 0;
						continue;
					}

					begin++;
					Integer chBegin = A[begin];
					int countBegin = map.getOrDefault(chBegin, 0);
					if(countBegin == 1) {
						map.remove(countBegin);
					}
					else {
						map.put(chBegin, countBegin-1);
					}
				}
			}
		}
		return res;
	}
}
