package com.javadwarf.backtracking.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		permutation("SABHD");
	}

	public static void permutation(String S) {
		char[] arr = S.toCharArray();
		Arrays.parallelSort(arr);
		S = "";
		for(char  c : arr) {
			S += c;
		}

		List<String> list= permutation(S, S, 0, new ArrayList<>());
		for(String s : list) {
			System.out.print(s +" ");
		}
	}

	public static List<String>  permutation(String S, String currStr, int index, List<String> list) {
		if(index == S.length()) {
			list.add(currStr);
			return list;
		}

		for(int i= index; i< S.length(); i++) {
			currStr = swap(currStr, index, i );
			list = permutation(S, currStr, (index +1), list);
		}

		return list;
	}

	public static String swap(String s , int src, int dest) {
		if( src == dest) return s;
		StringBuffer sb = new StringBuffer(s);
		String srcChar = s.charAt(src) + "" ;
		String destChar = s.charAt(dest) + "" ;
		sb.replace(src, src+1, destChar);
		sb.replace(dest, dest+1, srcChar);
		return sb.toString();
	}

}
