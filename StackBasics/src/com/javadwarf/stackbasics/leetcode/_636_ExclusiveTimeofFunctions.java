package com.javadwarf.stackbasics.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _636_ExclusiveTimeofFunctions {

	public static void main(String[] args) {
		System.out.println(new _636_ExclusiveTimeofFunctions().exclusiveTime(2, Arrays.asList(new String[] {"0:start:0","1:start:2","1:end:5","0:end:6"})));
	}

	public int[] exclusiveTime(int n, List<String> logs) {

		int[] res = new int[n];

		Stack<Integer> s = new Stack<>();

		int prevBeginTime = -1;
		boolean flag = true;

		for(String log : logs) {

			String[] arr = log.split(":");

			if(flag) {
				s.add(Integer.parseInt(arr[0]));
				prevBeginTime = Integer.parseInt(arr[2]);
				flag = false;
				continue;
			}

			if(arr[1].equals("start")) {
				int newBeginTime = Integer.parseInt(arr[2]);
				if(!s.isEmpty()) {
					res[s.peek()] += newBeginTime - prevBeginTime;
				}
				prevBeginTime = newBeginTime;
				s.add(Integer.parseInt(arr[0]));
			}
			else {
				s.pop();
				int newBeginTime = Integer.parseInt(arr[2]);
				res[Integer.parseInt(arr[0])] += newBeginTime - prevBeginTime+1;
				prevBeginTime = newBeginTime+1;
			}
		}
		return res;
	}
}