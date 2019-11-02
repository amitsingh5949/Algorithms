package com.javadwarf.dynamicprogramming.leetcode.singlestring;

//1. Brute Force -  for every (i,j) pair check if s.substring(i,j+1) is palindrom - o(n^3) and O(1)

//4 DP - reverse the string and find longest common substring in original and reversed string
		/*
		 * We could see that the longest common substring method fails when there exists
		 *  a reversed copy of a non-palindromic substring in some other part of SS. 
		 *  To rectify this, each time we find a longest common substring candidate, 
		 *  we check if the substring’s indices are the same as the reversed substring’s
		 *   original indices. If it is, then we attempt to update the longest palindrome 
		 *   found so far; if not, we skip this and find the next candidate.
		 */

public class _5_LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		System.out.println(new _5_LongestPalindromicSubstring().longestPalindrome2("babad"));
	}

	
	//2. Expand around centers - O(n^2) and O(1)
			/* We observe that a palindrome mirrors around its center. 
				Therefore, a palindrome can be expanded from its center, 
				and there are only 2n - 1 such centers.
			You might be asking why there are 2n -1 but not n centers? 
					The reason is the center of a palindrome can be in between two letters. 
					Such palindromes have even number of letters (such as "abba") and 
					its center are between the two 'b's.
					
			so every letter is a center and center is also between two letters
					*/
	public String longestPalindrome2(String s) {

		String max = "";
		
		for(int i=0;i<s.length();i++) {
			String x1 = expand(s, i-1, i+1);
			String x2 = expand(s, i, i+1);
			if(x1.length() > x2.length() && x1.length() > max.length()) {
				max = x1;
			}
			else if(x2.length() > x1.length() && x2.length() > max.length()){
				max = x2;
			}
		}
		return max;
	}
	
	public String expand(String s , int x, int y) {
		while(x>=0 && y<s.length() && s.charAt(x)==s.charAt(y)) {
			x--;
			y++;
		}
		return s.substring(x+1,y);
	}
	


	//3. DP - similar to Longest palindromic subsequence with two extra conditions o(n^2) and O(n^2)
	public String longestPalindrome3(String s) {

		if(s==null || s.length() == 0) return s;

		int x = 0;
		int y = 0;

		int max = 1;

		int[][] matrix = new int[s.length()][s.length()];

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
				if(i == j) {
					matrix[i][j] = 1;
				}
				else if(s.charAt(i) == s.charAt(j) && 
						(matrix[i+1][j-1] !=0 || j-i == 1)) { // this condition is important when characters are same 
					// we want to check if the characters between them forms a  palindrom
					//	so if matrix[i+1][j-1] != 0 that is the characters between them forms a non zero length palindrom
					// j-i == 1 condition to tackle cbbd 
					matrix[i][j] = 2 + matrix[i+1][j-1];
					if(max < matrix[i][j]) {
						max = matrix[i][j];
						x = i;
						y = j;
					}
				}
			}
		}
		return s.substring(x, y+1);
	}
	
	//5. mancher's Algorithm  -- o(n) and o(n)
		//https://www.youtube.com/watch?v=nbTSfrEfo6M
		//https://leetcode.com/problems/palindromic-substrings/solution/
	
	public String longestPalindrome5(String s) {
		
		if(s==null || s.length() == 0) return s;
		
		
		return "";
		
	}
}
