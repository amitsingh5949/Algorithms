package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _359_LoggerRateLimiter {

	public static void main(String[] args) {

	}

	Map<String, Integer> map = null;

	/** Initialize your data structure here. */
	public _359_LoggerRateLimiter() {
		map = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		int count = map.getOrDefault(message, -1);
		if(count == -1||timestamp-count >= 10)
			map.put(message, timestamp);
		return (count == -1||timestamp-count >= 10);
	}

}
