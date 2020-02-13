package com.javadwarf.maths.leetcode;

public class _273_IntegertoEnglishWords {

	public static void main(String[] args) {

	}
	
	private static final String[] ones = {"", "One","Two", "Three","Four", "Five", "Six","Seven", "Eight", "Nine", "Ten", 
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen", "Eighteen","Nineteen"}; 
	
	private static final String[] tens = {"","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	
	private static final String[] thousnads = {"","Thousand","Million","Billion" };

	public String numberToWords(int num) {
		
		if(num == 0) return "Zero";
		
		String result = "";
		
		int i=0;
		
		while(num > 0) {
			
			if(num % 1000 != 0) {
				
			}
			num /= 1000;
			i++;
		}
		
		return result;

	}
	
	public String helper(int num) {
		String res = "";
		
		if(num == 0) {
			return "";
		}
		else if(num<20) {
			return ones[num] + " ";
		}
		else if(num<100){
			return tens[num%10] + " " + helper(num%10);
		}
		else {
			
		}
		
		return res;
		
	}

}
