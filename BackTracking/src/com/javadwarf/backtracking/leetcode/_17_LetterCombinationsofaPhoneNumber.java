package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		System.out.println(new _17_LetterCombinationsofaPhoneNumber().letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		
		if(digits == null || digits.length() ==0 ) return result;

		Map<Integer, String>  map =  new HashMap<>();
		map.put(2,"abc");
		map.put(3,"def");
		map.put(4,"ghi");
		map.put(5,"jkl");
		map.put(6,"mno");
		map.put(7,"pqrs");
		map.put(8,"tuv");
		map.put(9,"wxyz");

		combination(0, "", digits, map, result);
		return result;

	}

	public void combination(int pos, String curr, String digits, Map<Integer, String>  map,  List<String> result ) {

		if(pos == digits.length()) {
			result.add(curr);
			return;
		}

		String str = map.get(Integer.parseInt(Character.valueOf(digits.charAt(pos)).toString()));

		for(int j= 0; j<str.length(); j++) {
			curr += str.charAt(j);
			pos = pos + 1;
			combination(pos, curr, digits, map, result);
			pos = pos - 1;
			curr = curr.substring(0, curr.length()-1);
		}
	}
}
