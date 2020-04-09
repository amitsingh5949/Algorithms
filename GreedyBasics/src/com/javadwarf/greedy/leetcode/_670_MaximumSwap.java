package com.javadwarf.greedy.leetcode;

public class _670_MaximumSwap {

	public static void main(String[] args) {
		System.out.println(new _670_MaximumSwap().maximumSwap(9937));

	}
	
	// Store the index of each digit in number in array
	// idea is to replace the current digit in number to the largest possible digit on right

	public int maximumSwap(int num) {
		
			int[] arr = new int[10];
			
			char[] numArr = Integer.valueOf(num).toString().toCharArray();
			
			for(int i=0; i<numArr.length; i++) {
				arr[numArr[i]-'0'] = i;
			}
			
			outer : for(int i=0; i<numArr.length; i++) {
				
				for(int j=9 ;j>=0; j--) {
					
					if( arr[j] != 0 && (numArr[i]-'0') < j && arr[j]> i ) {
						
						int bigIndex = arr[j];
						int smallIndex = i;
						
						char temp = numArr[bigIndex];
						numArr[bigIndex]= numArr[smallIndex];
						numArr[smallIndex] = temp;
						break outer;
					}
				}
			}
			
			String res = "";
			for(char ch : numArr) {
				res += ch;
			}
			return Integer.parseInt(res);
	}

}
