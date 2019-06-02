package com.javaDwarf.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		permutation("ABCD");
	}

	public static void permutation(String S) {

		List<String> list = new ArrayList<>();

		for(int i= 0; i <=S.length(); i++) {
			list = permutation(S,i, 0, "", list);
		}
		for(String s : list) {
			System.out.print(s + " ");
		}

	}

	public static List<String> permutation(String S, int len, int index, String str, List<String> list) {
		if(len == str.length()) {
			list.add(str);
			return list;
		}

		if(S.length() == index) 
			return list ;

		list = permutation(S, len, index+1, str + S.charAt(index), list);
		list = permutation(S, len, index+1, str, list);

		return list;
	}




}
