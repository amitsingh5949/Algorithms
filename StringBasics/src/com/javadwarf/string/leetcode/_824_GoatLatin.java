package com.javadwarf.string.leetcode;

public class _824_GoatLatin {

	public static void main(String[] args) {
		System.out.println(new _824_GoatLatin().toGoatLatin("I speak Goat Latin"));
	}

	public String toGoatLatin(String S) {
		
		if(S ==null ||S.length() == 0) return "";

		String[] arr = S.split(" ");

		String s = "";
		String res =  "";

		for(int i=0;i<arr.length; i++) {
			s += "a";
			if(!startsWithVowel(arr[i])) {
				arr[i] = arr[i].substring(1) + arr[i].charAt(0);	
			}
			res += arr[i] + "ma" + s + " ";
		}

		return res.substring(0, res.length()-1);
	}

	public boolean startsWithVowel(String s) {
		char ch = s.charAt(0);
		if(ch == 'a' || ch =='e' || ch == 'i'|| ch == 'o' || ch == 'u' ||
				ch == 'A' || ch =='E' || ch == 'I'|| ch == 'O' || ch == 'U') {
			return true;
		}
		return false;
	}

}
