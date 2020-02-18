package com.javadwarf.maths.leetcode;

public class _273_IntegertoEnglishWords {

	public static void main(String[] args) {
		System.out.println(new _273_IntegertoEnglishWords().numberToWords(100));
		System.out.println(new _273_IntegertoEnglishWords().numberToWords(1234));
		System.out.println(new _273_IntegertoEnglishWords().numberToWords(67894));
		System.out.println(new _273_IntegertoEnglishWords().numberToWords(1929735400));
		
	}

	private static final String[] ones = {"", "One","Two", "Three","Four", "Five", "Six","Seven", "Eight", "Nine", "Ten", 
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen", "Eighteen","Nineteen"}; 

	private static final String[] tens = {"","Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

	private static final String[] thousnads = {"","Thousand","Million","Billion" };

	public String numberToWords(int num) {

		if(num == 0) return "Zero";

		String result = "";

		int i=0;

		while(num > 0) {

			if(num % 1000 != 0) {
				result =  helper(num % 1000) + thousnads[i] + " "+result;
			}
			num /= 1000;
			i++;
		}
		return result.trim();
	}

	public String helper(int num) {
		if(num == 0) {
			return "";
		}
		else if(num < 20) {
			return ones[num] + " ";
		}
		else if(num < 100){
			return tens[num/10] + " " + helper(num%10);
		}
		else {
			return ones[num/100] + " Hundred " + helper(num%100);
		}
	}

}
