package com.javadwarf.leetcode.slidingwindow;

public class _424_LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {

	}

	//sliding window approach o(n) o(1)
	public int characterReplacement(String s, int k) {

		int b=0,e=0,max=0;
		int[] arr = new int[26];

		while(e<s.length()){
			arr[s.charAt(e)-'A']++;
			e++;
			if(isWindowValid(arr,k)){
				max = Math.max(max,e-b);
			}
			else{
				while(b<e && !isWindowValid(arr,k)){
					arr[s.charAt(b)-'A']--;
					b++;
				}
			}
		}
		return max;
	}

	public boolean isWindowValid(int[] arr, int k){

		int sum =0;
		int max = 0;

		for(int i=0; i<26; i++){
			max = Math.max(max,arr[i]);
			sum+= arr[i];
		}

		return (sum-max-k) <= 0;
	}

}
