package com.javadwarf.leetcode.twopointer;

public class _345_ReverseVowelsofaString {

	public static void main(String[] args) {
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {

		if(s == null || s.length() == 0) return s;

		char[]  arr = s.toCharArray();
		int begin = 0 ;
		int end = s.length()-1;

		while(begin < end) {

			while(begin < end && !isVowel(s.charAt(begin))) {
				begin++;
			}
			while(end > begin && !isVowel(s.charAt(end))) {
				end--;
			}

			if(isVowel(s.charAt(begin)) && isVowel(s.charAt(end))) {
				char temp = s.charAt(begin);
				arr[begin] = arr[end];
				arr[end] = temp;
			}
			begin++;
			end--;
		}
		return new String(arr);
	}

	public static boolean isVowel(char ch){
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
				ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
 	}

}
