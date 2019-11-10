package com.javadwarf.string.leetcode;

public class _1119_RemoveVowelsfromaString {

	public static void main(String[] args) {
		
		System.out.println(new _1119_RemoveVowelsfromaString().removeVowels("abiidf"));

	}
	
	public String removeVowels(String S) {
		for(int i=0; i<S.length();i++) {
			char ch = S.charAt(i);
			if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u' ||
					ch == 'A' || ch =='E' || ch == 'I' || ch == 'O' || ch == 'U') {
				 S = S.substring(0,i) + S.substring((i+1));
				 i--;
			}
		}
		return S;

	}

	// extra space
	public String removeVowels1(String S) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<S.length();i++) {
			char ch = S.charAt(i);
			if(ch != 'a' && ch !='e' && ch != 'i' && ch != 'o' && ch != 'u' &&
					ch != 'A' && ch !='E' && ch != 'I' && ch != 'O' && ch != 'U') {
				sb.append(ch);
			}
		}
		return sb.toString();

	}

}
