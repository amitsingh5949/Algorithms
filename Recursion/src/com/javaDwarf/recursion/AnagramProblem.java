package com.javaDwarf.recursion;

import java.util.Scanner;

public class AnagramProblem {

	public static char[] charArr;
	
	public static void main(String[] args) {
		System.out.println("Please enter a String to be angrammed");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		scan.close();
		charArr= word.toCharArray();
		doAnagram(charArr.length);
	}

	private static void doAnagram(int size) {
		System.out.println("Angramming " + new String(charArr)+" "+size);
		if(size == 1){
			 return;
		}
		else{
			for(int j = 0; j<size; j++){
				doAnagram(size-1);
			if(size == 2){
				saveWord();
			}
			rotateWord(size);
			}
		}
	}
	
	private static void saveWord() {
		System.out.println(new String(charArr));
	}

	public static void rotateWord(int size){
		System.out.println("going to rotate"+ new String(charArr)+" "+size);
		
		int position = charArr.length-size;
		char c= charArr[position];
		for(int k=position+1; k<charArr.length; k++){
			charArr[k-1]=charArr[k];
		}
		charArr[charArr.length-1]=c;
	}

}
