package com.javadwarf.string.leetcode;

public class _28_ImplementSubStringSerach {

	public static void main(String[] args) {
		System.out.println(new _28_ImplementSubStringSerach().strStr("cab", "ab"));
	}

	public int strStr(String haystack, String needle) {

		int needleHash = getHash(needle);

		int len = needle.length();

		int strHash = 0;
		
		for(int i=0; i<=haystack.length()-len;i++) {

			
			String str = haystack.substring(i, i+len);

			if(i==0) {
				strHash = getHash(str);
			}
			else {
				int chVal = (int)haystack.charAt(i-1);
				strHash = getHash(str, chVal, strHash);
			}

			if(strHash == needleHash && str.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public int getHash(String str) {

		int sum  = 0;

		double prime = 3.0;

		for(int i=0; i<str.length(); i++) {
			int chVal = (int)str.charAt(i);
			sum += (chVal* Math.pow(prime, i));
		}
		return sum;
	}

	public int getHash(String str, int prevCharVal, int oldhash) {
		double prime = 3.0;
		oldhash = oldhash - prevCharVal;
		oldhash = oldhash/(int)prime;
		int end = (int)str.charAt(str.length()-1);
		oldhash += (end*Math.pow(prime, str.length()-1 ));
		return oldhash;
	}



}
