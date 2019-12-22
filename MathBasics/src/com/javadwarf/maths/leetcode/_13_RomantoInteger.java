package com.javadwarf.maths.leetcode;

public class _13_RomantoInteger {

	public static void main(String[] args) {
		System.out.println(new _13_RomantoInteger().romanToInt("LVIII"));
	}

	public int romanToInt(String s) {

		int[] arr = new int[s.length()];

		for(int i=0; i<s.length(); i++) {

			char ch = s.charAt(i);

			if(ch  == 'I')
				arr[i] = 1;
			else if(ch  == 'V')
				arr[i] = 5;
			else if(ch  == 'X')
				arr[i] = 10;
			else if(ch  == 'L')
				arr[i] = 50;
			else if(ch  == 'C')
				arr[i] = 100;
			else if(ch  == 'D')
				arr[i] = 500;
			else if(ch  == 'M')
				arr[i] = 1000;
		}


		int sum = 0;

		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] < arr[i+1] ) {
				sum  -= arr[i];
			}
			else {
				sum += arr[i];
			}
		}

		return sum + arr[arr.length-1];
	}

}
