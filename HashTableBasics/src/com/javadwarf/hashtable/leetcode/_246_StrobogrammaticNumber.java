package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _246_StrobogrammaticNumber {

	public static void main(String[] args) {}
	
	public boolean isStrobogrammatic(String num) {

		Map<Character, Character> map = new HashMap<>();

		map.put('0','0');
		map.put('1','1');
		map.put('8','8');
		map.put('6','9');
		map.put('9','6');

		int i=0, j=num.length()-1;

		while(i <= j ){

			char ch1 = num.charAt(i);
			char ch2 = num.charAt(j);

			if(map.getOrDefault(ch1,'\0') != ch2) return false;
			i++;
			j--;
		}
		return true;
	}

}
